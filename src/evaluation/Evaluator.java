package evaluation;

import solution.Solution;

/**
 * Sučelje kojega implementiraju evaluatori (funkcije koje "ocjenjuju" rješenje,
 * tj. računaju fitness).
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip rješenja/jedinke.
 */
public interface Evaluator<T extends Solution<?>> {
	/**
	 * Metoda evaluira rješenje, tj. računa i postavlja njegov fitness.
	 * 
	 * @param solution
	 *            rješenje koje se evaluira.
	 */
	public void evaluate(T solution);
}
