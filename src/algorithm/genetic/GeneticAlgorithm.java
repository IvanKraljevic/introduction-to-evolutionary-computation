package algorithm.genetic;

import java.util.ArrayList;
import java.util.List;

import operator.crossover.Crossover;
import operator.mutation.Mutation;
import operator.selection.Selection;
import solution.Solution;
import solution.generator.SolutionGenerator;
import evaluation.Evaluator;

/**
 * Apstraktni genetskig algoritam.
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip rješenja/jedinke.
 */
public abstract class GeneticAlgorithm<T extends Solution<?>> {

	/** Veličina populacije. */
	protected int populationSize;

	/** Populacija jedinki/rješenja. */
	protected List<T> population;

	/** Operator mutacije. */
	protected Mutation<T> mutationOperator;

	/** Operator križanja. */
	protected Crossover<T> crossoverOperator;

	/** Operator selekcije. */
	protected Selection<T> selectionOperator;

	/** Evaluator rješenja. */
	protected Evaluator<T> evaluator;

	/** Generator rješenja, koristi se kod stvaranja početne populacije. */
	protected SolutionGenerator<T> randomSolutionGenerator;

	/**
	 * Pokreće genetski algoritam i vraća najbolje pronađeno rješenje.
	 * 
	 * @param numOfIterations
	 *            dopušteni broj iteracija.
	 * @return najbolje pronađeno rješenje.
	 */
	public abstract T run(long numOfIterations);

	/**
	 * Metoda evaulira skup rješenja.
	 * 
	 * @param pool
	 *            skup/lista rješenja.
	 */
	public void evaluatePopulation(List<T> pool) {
		for (T solution : pool) {
			evaluateSolution(solution);
		}
	}

	/**
	 * Metoda evaluira jedno rješenje.
	 * 
	 * @param solution
	 *            rješenje.
	 */
	public void evaluateSolution(T solution) {
		evaluator.evaluate(solution);
	}

	/**
	 * Metoda stvara početnu populaciju.
	 */
	protected void initilizePopulation() {
		population = new ArrayList<T>(populationSize);
		for (int i = 0; i < populationSize; i++) {
			population.add(randomSolutionGenerator.createSolution());
		}
	}

	/**
	 * Postavlja veličinu populacije. Mora biti pozitivan broj.
	 * 
	 * @param populationSize
	 *            veličina populacije.
	 */
	protected void setPopulationSize(int populationSize) {
		if (populationSize <= 0) {
			throw new IllegalArgumentException();
		}
		this.populationSize = populationSize;
	}

	/**
	 * Postavlja operator mutacije.
	 * 
	 * @param mutationOperator
	 *            operator mutacije.
	 */
	protected void setMutationOperator(Mutation<T> mutationOperator) {
		this.mutationOperator = mutationOperator;
	}

	/**
	 * Postavlja operator križanja.
	 * 
	 * @param crossoverOperator
	 *            operator križanja.
	 */
	protected void setCrossoverOperator(Crossover<T> crossoverOperator) {
		this.crossoverOperator = crossoverOperator;
	}

	/**
	 * Postavlja operator selekcije.
	 * 
	 * @param selectionOperator
	 *            operator selekcije.
	 */
	protected void setSelectionOperator(Selection<T> selectionOperator) {
		this.selectionOperator = selectionOperator;
	}

	/**
	 * Postavlja evaluator.
	 * 
	 * @param evaluator
	 *            evaluator.
	 */
	protected void setEvaulator(Evaluator<T> evaluator) {
		this.evaluator = evaluator;
	}

	/**
	 * Postavlja generator slučajnih rješenja.
	 * 
	 * @param randomSolutionGenerator
	 *            generator slučajnih rješenja.
	 */
	protected void setRandomSolutionGenerator(
			SolutionGenerator<T> randomSolutionGenerator) {
		this.randomSolutionGenerator = randomSolutionGenerator;
	}
}
