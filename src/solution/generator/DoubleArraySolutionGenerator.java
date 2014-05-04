package solution.generator;

import java.util.Arrays;

import rng.IRNG;
import solution.DoubleArraySolution;

/**
 * Razred je zadužen za stvaranje nasumičnog rješenja tipa
 * {@code DoubleArraySolution}.
 * 
 * @author Ivan Kraljević
 * 
 */
public class DoubleArraySolutionGenerator implements
		SolutionGenerator<DoubleArraySolution> {

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/** Minimalna vrijednost komponenti. */
	private double[] mins;

	/** Maksimalna vrijednost komponenti. */
	private double[] maxs;

	/** Broj komponenti vektora. */
	private int dimension;

	/**
	 * Vraća generator rješenja gdje je generator slučajnih brojeva specificiran
	 * u parametrima.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public DoubleArraySolutionGenerator(int dimension, double min, double max,
			IRNG rand) {
		setRand(rand);
		this.dimension = dimension;
		mins = new double[dimension];
		maxs = new double[dimension];
		Arrays.fill(mins, min);
		Arrays.fill(maxs, max);
	}

	@Override
	public DoubleArraySolution createSolution() {
		return new DoubleArraySolution(dimension, mins, maxs, rand);
	}

	/**
	 * Postavlja generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	private void setRand(IRNG rand) {
		if (rand == null) {
			throw new IllegalArgumentException();
		}
		this.rand = rand;
	}

}
