package solution.generator;

import rng.IRNG;
import solution.BoundsChecker;
import solution.IntArraySolution;

/**
 * Razred je zadužen za stvaranje nasumičnog rješenja tipa
 * {@code IntArraySolution}.
 * 
 * @author Ivan Kraljević
 * 
 */
public class IntArraySolutionGenerator implements
		SolutionGenerator<IntArraySolution> {

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/** Minimalna vrijednost komponenti. */
	private int[] mins;

	/** Maksimalna vrijednost komponenti. */
	private int[] maxs;

	/**
	 * Stvara generaor rješenja sa specificiranim generatorom slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public IntArraySolutionGenerator(IRNG rand) {
		setRand(rand);
		mins = BoundsChecker.getMins();
		maxs = BoundsChecker.getMaxs();
	}

	@Override
	public IntArraySolution createSolution() {
		return new IntArraySolution(mins, maxs, rand);
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
