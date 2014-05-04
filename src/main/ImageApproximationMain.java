package main;

import operator.crossover.Crossover;
import operator.crossover.IntArrayCrossover;
import operator.mutation.IntArrayMutation;
import operator.mutation.Mutation;
import operator.selection.Selection;
import operator.selection.TournamentSelection;
import rng.IRNG;
import rng.RNG;
import solution.BoundsChecker;
import solution.IntArraySolution;
import solution.generator.IntArraySolutionGenerator;
import solution.generator.SolutionGenerator;
import algorithm.genetic.GenerationalGeneticAlgorithm;
import algorithm.genetic.GeneticAlgorithm;
import evaluation.Evaluator;
import evaluation.GrayscaleImageEvaluator;

public class ImageApproximationMain {

	/** Putanja do datoteke sa slikom. */
	public static String IMAGE_PATH = "11-kuca-200-133.png";

	public static void main(String[] args) {

		// veličina populacije
		int populationSize = 25;
		// broj pravokutnika za aproksimaciju
		int numOfRectangles = 250;

		IRNG rand = RNG.getRNG();
		BoundsChecker.setup(0, 255, new int[] { 0, 0, 0, 0, 0 }, new int[] {
				200, 133, 200, 133, 255 }, numOfRectangles);

		// operator mutacije, varijacija = 4, vjerojatnost mutacije = 0.1,
		// vjerojatnost reseta = 0.08
		Mutation<IntArraySolution> mutationOperator = new IntArrayMutation(4,
				0.1, 0.08, rand);
		// operator križanja
		Crossover<IntArraySolution> crossoverOperator = new IntArrayCrossover(
				rand);
		// operator selekcije, 3-turnirska selekcija
		Selection<IntArraySolution> selectionOperator = new TournamentSelection<IntArraySolution>(
				20, true, rand);
		// evaulacija
		Evaluator<IntArraySolution> evaulator = new GrayscaleImageEvaluator(
				Utilities.loadImage(IMAGE_PATH));
		// generator rješenja
		SolutionGenerator<IntArraySolution> randomSolutionGenerator = new IntArraySolutionGenerator(
				rand);

		// steady state algoritam
		GeneticAlgorithm<IntArraySolution> geneticAlgorithm = new GenerationalGeneticAlgorithm<IntArraySolution>(
				populationSize, mutationOperator, crossoverOperator,
				selectionOperator, evaulator, randomSolutionGenerator);

		// pokrećemo algoritam
		IntArraySolution best = geneticAlgorithm.run(5000);

		Utilities.exportIntArraySolution(best, "best2.png");
	}
}