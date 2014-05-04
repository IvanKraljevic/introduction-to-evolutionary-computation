package operator.selection;


import java.util.List;

import solution.Solution;

/**
 * Sučelje kojega implementiraju operatori selekcije.
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip jedinke/rješenja.
 */
public interface Selection<T extends Solution<?>> {

	/**
	 * Iz liste jedinki/rješenja odabire i vraća jednu jedinku/rješenje.
	 * 
	 * @param pool
	 *            lista jedinki.
	 * @return odabrana/selektirana jedinka.
	 */
	public T select(List<? extends T> pool);
}
