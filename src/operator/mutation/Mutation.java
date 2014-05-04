package operator.mutation;

import solution.Solution;

/**
 * Sučelje kojega implementiraju operatori mutacije.
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip jedinke/rješenja.
 */
public interface Mutation<T extends Solution<?>> {
	/**
	 * Mutira jedinku/rješenje zadanu u parametru.
	 * 
	 * @param solution
	 *            jedinka koja se mutira.
	 */
	public void mutate(T solution);
}
