package solution.generator;

import solution.Solution;

/**
 * Sučelje kojega implementiraju generatori pojedinih rješenja. Uloga generatora
 * rješenja je da od ostalih dijelova skriva način stvaranja random
 * jedinki/rješnja.
 * 
 * @author Ivan Kraljević
 * 
 */
public interface SolutionGenerator<T extends Solution<?>> {
	/**
	 * Metoda stvara i vraća novo rješenje.
	 * <p>
	 * Način na koji će se rješenje generirati ovisi o konkretnoj
	 * implementaciji.
	 * </p>
	 * 
	 * @return novostvoreno rješenje.
	 */
	public T createSolution();
}
