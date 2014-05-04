package operator.crossover;

import solution.Solution;

/**
 * Sučelje kojega implementiraju svi operatori križanja.
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip jedinke/rješenja.
 */
public interface Crossover<T extends Solution<?>> {
	/**
	 * Vraća dijete koje nastaje križanjem roditelja.
	 * 
	 * @param p1
	 *            prvi roditelj.
	 * @param p2
	 *            drugi roditelj.
	 * @return dijete nastalo križanjem roditelja.
	 */
	public T mate(T p1, T p2);
}
