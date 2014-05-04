package operator.mutation;

import rng.IRNG;
import solution.BoundsChecker;
import solution.IntArraySolution;

/**
 * Operator mutacije. Ukoliko se komponenta mutira, ona se ili resetira na
 * nasumičnu vrijednost, ili joj se dodaje/oduzima neka (mala) nasumična
 * vrijednost.
 * 
 * @author Ivan Kraljević
 * 
 */
public class IntArrayMutation implements Mutation<IntArraySolution> {

	/** Vjerojatnost mutacije. */
	private double mutationProbability;

	/** Vjerojatnost da se komponenta resetira na novu vrijednost. */
	private double componentResetProbability;

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/**
	 * Varijacija komponente. Ukoliko dođe do mutacije komponente, njena nova
	 * vrijednost je nasumični broj između [x - variation, x + variation].
	 */
	private int variation;

	/** Minimalna vrijednost komponenti. */
	private int[] mins;

	/** Maksimalna vrijednost komponenti. */
	private int[] maxs;

	/**
	 * Vraća operator mutacije sa atributima specificiranim u parametrima.
	 * 
	 * @param variation
	 *            varijacija komponente.
	 * @param mutationProbability
	 *            vjerojatnost mutacije.
	 * @param componentResetProbability
	 *            vjerojatnost resetiranja komponente.
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public IntArrayMutation(int variation, double mutationProbability,
			double componentResetProbability, IRNG rand) {
		setMutationProbability(mutationProbability);
		setComponentResetProbability(componentResetProbability);
		setRand(rand);
		setVariation(variation);
		mins = BoundsChecker.getMins();
		maxs = BoundsChecker.getMaxs();
	}

	@Override
	public void mutate(IntArraySolution solution) {
		int[] solutionData = solution.getData();
		for (int i = 0; i < solutionData.length; i++) {
			if (rand.nextDouble() <= mutationProbability) { // mutacija
				if (rand.nextDouble() <= componentResetProbability) { // resetiranje
					solutionData[i] = rand.nextInt(mins[i], maxs[i] + 1);
				} else { // varijacija komponente
					solutionData[i] += rand.nextInt(-1 * variation,
							variation + 1);
				}
			}
		}
	}

	/**
	 * Postavlja vjerojatnost mutacije na zadanu vrijednost.
	 * 
	 * @param mutationProbability
	 *            vjerojatnost mutacije.
	 * @throws IllegalArgumentException
	 *             ako je zadani parametar manji od 0 ili veći od 1.
	 */
	private void setMutationProbability(double mutationProbability) {
		if (mutationProbability < 0 || mutationProbability > 1) {
			throw new IllegalArgumentException();
		}
		this.mutationProbability = mutationProbability;
	}

	/**
	 * Postavlja vjerojatnost resetiranja komponente realnog vektora.
	 * 
	 * @param mutationProbability
	 *            vjerojatnost resetiranja.
	 * @throws IllegalArgumentException
	 *             ako je zadani parametar manji od 0 ili veći od 1.
	 */
	private void setComponentResetProbability(double componentResetProbability) {
		if (componentResetProbability < 0 || componentResetProbability > 1) {
			throw new IllegalArgumentException();
		}
		this.componentResetProbability = componentResetProbability;
	}

	/**
	 * Postavlja generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 * @throws IllegalArgumentException
	 *             ako je parametar {@code null}.
	 */
	private void setRand(IRNG rand) {
		if (rand == null) {
			throw new IllegalArgumentException();
		}
		this.rand = rand;
	}

	/**
	 * Postavlja varijaciju komponente na specificiranu vrijednost.
	 * 
	 * @param variation
	 *            varijacija komponente.
	 */
	private void setVariation(int variation) {
		variation = Math.abs(variation);
	}

}
