package rng;

import java.io.InputStream;
import java.util.Properties;

/**
 * Razred koji pojednostavljuje dohvaćanje generatora slučajnih brojeva tako da
 * ih se ne mora slati svugdje po kodu. Korišten je <em>singleton</em> oblikovni
 * obrazac.
 * 
 * @author Ivan Kraljević
 * 
 */
public class RNG {

	/** Ime datoteke koja sadrži konfiguracijske parametre */
	private static final String CONFIG_FILE_NAME = "rng-config.properties";

	/**
	 * Ime resursa koji sadrži ime {@code IRNGProvider} implementacije koja se
	 * koristi.
	 */
	private static final String RNG_PROVIDER_PROPERTY_NAME = "rng-provider";

	/** Objekt koji sadrži generatore slučajnih brojeva. */
	private static IRNGProvider provider;

	/**
	 * Privatna metoda koja stvara jedinstvenog <em>providera</em> generatora
	 * slučajnih brojeva.
	 */
	private static void initialize() {
		try {
			Properties p = new Properties();
			ClassLoader loader = RNG.class.getClassLoader();
			InputStream stream = loader.getResourceAsStream(CONFIG_FILE_NAME);
			p.load(stream);
			String className = p.getProperty(RNG_PROVIDER_PROPERTY_NAME);
			provider = (IRNGProvider) loader.loadClass(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Vraća generator slučajnih brojeva.
	 * 
	 * @return generator slučajnih brojeva.
	 */
	public static IRNG getRNG() {
		// lazy initialization
		if (provider == null) {
			initialize();
		}
		return provider.getRNG();
	}
}
