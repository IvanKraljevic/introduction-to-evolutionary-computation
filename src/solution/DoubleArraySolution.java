package solution;

import java.util.Arrays;

import rng.IRNG;

/**
 * {@code DoubleArraySolution} predstavlja rješenje koje podatke pohranjuje u
 * niz realnih brojeva (tj. u double array).
 * 
 * @author Ivan Kraljević
 * 
 */
public class DoubleArraySolution extends Solution<double[]> {

	/** Dimenzija rješenja, tj. broj komponenti vektora. */
	protected int dimension;

	/**
	 * Vraća objekt sa ulaznom dimenzijom specificiranom u parametru.
	 * 
	 * @param dimension
	 *            dimenzija ulaznog prostora.
	 */
	public DoubleArraySolution(int dimension) {
		setDimension(dimension);
		setData(new double[dimension]);
	}

	/**
	 * Vraća objekt sa podacima specificiranim u parametru.
	 * 
	 * @param data
	 *            podaci.
	 */
	public DoubleArraySolution(double[] data) {
		setData(data);
		setDimension(data.length);
	}

	/**
	 * Vraća objekt sa podacima i fitnessom iz parametara.
	 * 
	 * @param data
	 *            podaci.
	 * @param fitness
	 *            fitness.
	 */
	public DoubleArraySolution(double[] data, double fitness) {
		this(data);
		setFitness(fitness);
	}

	/**
	 * Stvara nasumično rješenje gdje su podaci unutar dozvoljenih granica.
	 * 
	 * @param dimension
	 *            dimenzija rješenja.
	 * @param mins
	 *            minimalne vrijednosti komponenti.
	 * @param maxs
	 *            maksimalne vrijednosti komponenti.
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public DoubleArraySolution(int dimension, double[] mins, double[] maxs,
			IRNG rand) {
		this(dimension);
		for (int i = 0; i < dimension; i++) {
			data[i] = rand.nextDouble(mins[i], maxs[i]);
		}
	}

	/**
	 * Vraća dimenziju rješenja (tj. broj komponenti vektora realnih brojeva).
	 * 
	 * @return dimenzija rješenja.
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * Postavlja dimenziju rješenja. Mora biti veća od 0.
	 * 
	 * @param dimension
	 *            dimenzija rješenja.
	 */
	private void setDimension(int dimension) {
		if (dimension <= 0) {
			throw new IllegalArgumentException();
		}
		this.dimension = dimension;
	}

	@Override
	public Solution<double[]> copy() {
		return new DoubleArraySolution(data.clone(), dimension);
	}

	@Override
	public String toString() {
		return "DoubleArraySolution [dimension=" + dimension + ", data="
				+ Arrays.toString(data) + ", fitness=" + fitness + "]";
	}

}
