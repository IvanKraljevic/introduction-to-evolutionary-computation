package operator.mutation;

import rng.IRNG;
import solution.DoubleArraySolution;

/**
 * Svakoj komponenti realnog vektora se dodaje nasumično odabrana vrijednost iz
 * normalne (Gaussove) distribucije.
 * 
 * @author Ivan Kraljević
 * 
 */
public class DoubleArrayNormalMutation implements Mutation<DoubleArraySolution> {

	/** Vjerojatnost mutacije komponente. */
	double mutationProbability;

	/** Srednja vrijednost. */
	private double mi;

	/** Disperzija/raspršenost. */
	private double sigma;

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/**
	 * Vraća operator mutacije sa zadanom vjerojatnosti mutacije, srednjom
	 * vrijednosti, disperzijom i generatorom slučajnih brojeva.
	 * 
	 * @param mutationProbability
	 *            vjerojatnost mutacije.
	 * @param mi
	 *            srednja vrijednost.
	 * @param sigma
	 *            disperzija/raspršenost.
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public DoubleArrayNormalMutation(double mutationProbability, double mi,
			double sigma, IRNG rand) {
		this.mutationProbability = mutationProbability;
		setRand(rand);
		setMi(mi);
		setSigma(sigma);
	}

	@Override
	public void mutate(DoubleArraySolution solution) {
		double[] data = solution.getData();
		for (int i = 0; i < data.length; i++) {
			if (rand.nextDouble() <= mutationProbability) {
				data[i] += rand.nextGaussian() * sigma - mi;
			}
		}
		solution.setData(data);
	}

	/**
	 * Postavlja srednju vrijednost.
	 * 
	 * @param mi
	 *            srednja vrijednost.
	 */
	public void setMi(double mi) {
		this.mi = mi;
	}

	/**
	 * Postavlja disperziju.
	 * 
	 * @param sigma
	 *            disperzija.
	 * @throws IllegalArgumentException
	 *             ako je disperzija negativan broj.
	 */
	public void setSigma(double sigma) {
		if (sigma < 0) {
			throw new IllegalArgumentException();
		}
		this.sigma = sigma;
	}

	/**
	 * Postavlja generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 * 
	 * @throws IllegalArgumentException
	 *             ako je parametar {@code null}.
	 */
	protected void setRand(IRNG rand) {
		if (rand == null) {
			throw new IllegalArgumentException();
		}
		this.rand = rand;
	}

}
