package solution;

import java.util.Arrays;

import rng.IRNG;

/**
 * {@code IntArraySolution} predstavlja rješenje koje podatke pohranjuje u niz
 * cijelobrojnih vrijednosti (tj. u int array).
 * 
 * @author Ivan Kraljević
 * 
 */
public class IntArraySolution extends Solution<int[]> {

	/**
	 * Vraća objekt čije su vrijednosti nasumično postavljene u opsegu zadanog u
	 * parametrima.
	 * <p>
	 * Vrijednost pojedine komponente (dimenzije) se računa na sljedeći način:
	 * data[i] = random(min[i], max[i]).
	 * </p>
	 * 
	 * @param mins
	 *            niz sa minimalnim vrijednostima.
	 * @param maxs
	 *            niz sa maksimalnim vrijednostima.
	 * @param rand
	 *            generator slučajnih brojeva.
	 */
	public IntArraySolution(int[] mins, int[] maxs, IRNG rand) {
		data = new int[mins.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(mins[i], maxs[i]);
		}
	}

	/**
	 * Vraća objekt čije su vrijednosti postavljenje na zadani parametar.
	 * 
	 * @param data
	 *            vrijednosti rješenja.
	 */
	public IntArraySolution(int[] data) {
		setData(data);
	}

	/**
	 * Vraća objekt čije su vrijednosti i fitness postavljeni na vrijednosti
	 * zadane u parametrima.
	 * 
	 * @param data
	 *            vrijednosti rješenja.
	 * @param fitness
	 *            vrijednost fitnessa.
	 */
	public IntArraySolution(int[] data, double fitness) {
		setData(data);
		setFitness(fitness);
	}

	@Override
	public Solution<int[]> copy() {
		return new IntArraySolution(data.clone(), fitness);
	}

	@Override
	public String toString() {
		return "IntegerSolution [data=" + Arrays.toString(data) + ", fitness="
				+ fitness + "]";
	}

}
