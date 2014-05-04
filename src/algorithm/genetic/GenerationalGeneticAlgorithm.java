package algorithm.genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import operator.crossover.Crossover;
import operator.mutation.Mutation;
import operator.selection.Selection;
import solution.Solution;
import solution.generator.SolutionGenerator;
import evaluation.Evaluator;

/**
 * Generacijski genetski algoritam. U svakoj iteraciji stvara se nova
 * populacija. U novoj populaciji dijete se stvara na sljedeći način:
 * <ul>
 * <li>odaberu se 2 roditelja</li>
 * <li>križanjem 2 roditelja nastaje novo dijete</li>
 * <li>dijete se mutira te se ubacuje u novu populaciju</li>
 * </ul>
 * <p>
 * Algoritam ima ugrađeni elitizam (najbolja jedinka prethodne generacije se
 * ubacuje u novu populaciju).
 * </p>
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 *            tip rješenja/jedinke.
 */
public class GenerationalGeneticAlgorithm<T extends Solution<?>> extends
		GeneticAlgorithm<T> {

	public GenerationalGeneticAlgorithm(int populationSize,
			Mutation<T> mutationOperator, Crossover<T> crossoverOperator,
			Selection<T> selectionOperator, Evaluator<T> evaulator,
			SolutionGenerator<T> randomSolutionGenerator) {
		setPopulationSize(populationSize);
		setMutationOperator(mutationOperator);
		setCrossoverOperator(crossoverOperator);
		setSelectionOperator(selectionOperator);
		setEvaulator(evaulator);
		setRandomSolutionGenerator(randomSolutionGenerator);
		initilizePopulation();
	}

	@Override
	public T run(long numOfIterations) {
		evaluatePopulation(population);
		T bestSolution = Collections.min(population);

		for (long it = 0; it < numOfIterations; it++) {
			List<T> newPopulation = new ArrayList<T>(populationSize);
			newPopulation.add(bestSolution);
			for (int i = 1; i < populationSize; i++) {
				T parent1 = selectionOperator.select(population);
				T parent2 = selectionOperator.select(population);
				T child = crossoverOperator.mate(parent1, parent2);
				mutationOperator.mutate(child);
				evaluateSolution(child);
				newPopulation.add(child);
			}
			// nova populacija postaje trenutna populacija
			population = newPopulation;
			// tražimo najbolje dijete nove populacije
			T bestFromNewPopulation = Collections.min(newPopulation);
			if (bestFromNewPopulation.getFitness() <= bestSolution.getFitness()) {
				bestSolution = bestFromNewPopulation;
			}
			// ispis najboljeg rješenja svakih 5000 iteracija
			if (it % 5000 == 0) {
				System.out.println(it + ": " + bestSolution.getFitness());
			}
		}
		return bestSolution;
	}

}
