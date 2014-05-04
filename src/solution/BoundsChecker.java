package solution;

/**
 * Statički razred čije su metode zadužene za provjeravanje jesu li vrijednosti
 * nizova brojeva u zadanom rasponu.
 * 
 * @author Ivan Kraljević
 * 
 */
public class BoundsChecker {
	/** Niz sa minimalnim vrijednostima komponenti. */
	private static int[] mins;

	/** Niz sa maksimalnim/najvećim vrijednostima komponenti. */
	private static int[] maxs;

	/**
	 * Postavljanje okoline minimalnih/maksimalnih vrijednosti za korištenje
	 * prilikom aproksimacije crno-bijele slike proizvoljnim brojem
	 * pravokutnika.
	 * 
	 * @param minColor
	 *            minimalna vrijednost boje.
	 * @param maxColor
	 *            maksimalna vrijednost boje.
	 * @param minRectangle
	 *            minimalna vrijednost koordinate.
	 * @param maxRectangle
	 *            maksimalna vrijednost koordinate.
	 * @param numOfRectangles
	 *            broj pravokutnika.
	 */
	public static void setup(int minColor, int maxColor, int[] minRectangle,
			int[] maxRectangle, int numOfRectangles) {
		int varsPerRectangle = minRectangle.length;
		int size = 1 + numOfRectangles * varsPerRectangle;

		mins = new int[size];
		maxs = new int[size];
		mins[0] = minColor;
		maxs[0] = maxColor;
		
		int index = 1;
		for (int i = 0; i < numOfRectangles; i++) {
			for (int j = 0; j < varsPerRectangle; j++) {
				mins[index] = minRectangle[j];
				maxs[index] = maxRectangle[j];
				index++;
			}
		}
	}

	/**
	 * Provjerava da li je specificirani niz unutar zadanog opsega. Ako je
	 * pojedina komponenta izvan opsega, njena vrijednost se postavlja na bližu
	 * granicu.
	 * 
	 * @param data
	 *            niz cijelih brojeva.
	 * @throws IllegalArgumentException
	 *             ako je parametar {@code null}.
	 */
	public static void check(int[] data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] < mins[i]) {
				data[i] = mins[i];
			} else if (data[i] > maxs[i]) {
				data[i] = maxs[i];
			}
		}
	}

	/**
	 * Vraća polje sa minimalnim dopuštenim vrijednostima.
	 * 
	 * @return polje sa minimalnim vrijednostima komponenata.
	 */
	public static int[] getMins() {
		return mins;
	}

	/**
	 * Vraća polje sa maksimalnim vrijednostima komponenata.
	 * 
	 * @return polje sa maksimalnim vrijednostima komponenata.
	 */
	public static int[] getMaxs() {
		return maxs;
	}
}
