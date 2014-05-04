package main;

import operator.crossover.BLXAlphaCrossover;
import operator.crossover.Crossover;
import operator.mutation.DoubleArrayNormalMutation;
import operator.mutation.Mutation;
import operator.selection.Selection;
import operator.selection.TournamentSelection;
import rng.IRNG;
import rng.RNG;
import solution.DoubleArraySolution;
import solution.generator.DoubleArraySolutionGenerator;
import solution.generator.SolutionGenerator;
import algorithm.genetic.GenerationalGeneticAlgorithm;
import algorithm.genetic.GeneticAlgorithm;
import evaluation.Evaluator;
import evaluation.RosebrockFunctionEvaulator;

public class FunctionMinimisation {
	public static void main(String[] args) {
		IRNG rand = RNG.getRNG();
		
		// veličina populacije = 50
		int populationSize = 50;
		// dimenzija rješenja = 5
		int dimension = 5;

		// operator mutacije, srednja vrijednost = 0, disperzija = 1
		Mutation<DoubleArraySolution> mutationOperator = new DoubleArrayNormalMutation(
				0.1, 0, 1, rand);
		
		// BLX-alpha križanje, alpha = 0.1
		Crossover<DoubleArraySolution> crossoverOperator = new BLXAlphaCrossover(
				0.1, rand);

		// operator selekcije, 3-turnirska selekcija
		Selection<DoubleArraySolution> selectionOperator = new TournamentSelection<DoubleArraySolution>(
				3, true, rand);

		// De Jongov evaulator
		Evaluator<DoubleArraySolution> evaulator = new RosebrockFunctionEvaulator();

		// generator slučajnog rješenja, 5 dimenzija, min=-100, max=100
		SolutionGenerator<DoubleArraySolution> randomSolutionGenerator = new DoubleArraySolutionGenerator(
				dimension, -100, 100, rand);

		GeneticAlgorithm<DoubleArraySolution> geneticAlgorithm = new GenerationalGeneticAlgorithm<>(
				populationSize, mutationOperator, crossoverOperator,
				selectionOperator, evaulator, randomSolutionGenerator);

		DoubleArraySolution best = geneticAlgorithm.run(200000);
		System.out.println("Najbolje rješenje: " + best.toString());
	}
}
