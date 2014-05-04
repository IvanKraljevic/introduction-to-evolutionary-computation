package evaluation;

import solution.DoubleArraySolution;

/**
 * Evaulacija Rosebrockove funkcije.
 * 
 * @author Ivan Kraljević
 * @see <a href="http://en.wikipedia.org/wiki/Rosenbrock_function">Wikipedia</a>
 */
public class RosebrockFunctionEvaulator implements
		Evaluator<DoubleArraySolution> {

	@Override
	public void evaluate(DoubleArraySolution solution) {
		double[] x = solution.getData();

		double fitness = 0.;
		for (int i = 0; i < x.length - 1; i++) {
			fitness += (1 - x[i]) * (1 - x[i]) + 100 * (x[i + 1] - x[i] * x[i])
					* (x[i + 1] - x[i] * x[i]);
		}
		solution.setFitness(fitness);
	}

}
