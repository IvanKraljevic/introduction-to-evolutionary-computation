package operator.crossover;

import rng.IRNG;
import solution.IntArraySolution;

/**
 * Križanje sa jednom točkom prekida.
 * <p>
 * child[index] = rand.boolean() ? parent1[index] : parent2[index]
 * </p>
 * 
 * @author Ivan
 * 
 */
public class IntArrayCrossover implements Crossover<IntArraySolution> {

	/** Generator slučajnih brojeva. */
	IRNG rand;

	/**
	 * Vraća operator križanja sa zadanim generatorom slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public IntArrayCrossover(IRNG rand) {
		setRand(rand);
	}

	@Override
	public IntArraySolution mate(IntArraySolution parent1,
			IntArraySolution parent2) {
		int[] p1Data = parent1.getData();
		int[] p2Data = parent2.getData();
		int[] childData = new int[p1Data.length];

		// randIndex je točka prekida
		int randIndex = rand.nextInt(0, p1Data.length);
		for (int i = 0; i < p1Data.length; i++) {
			childData[i] = (i <= randIndex) ? p1Data[i] : p2Data[i];
		}
		return new IntArraySolution(childData);
	}

	/**
	 * Postavlja generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 * @throws IllegalArgumentException
	 *             ako je parametar {@code null}.
	 */
	public void setRand(IRNG rand) {
		if (rand == null) {
			throw new IllegalArgumentException();
		}
		this.rand = rand;
	}
}
