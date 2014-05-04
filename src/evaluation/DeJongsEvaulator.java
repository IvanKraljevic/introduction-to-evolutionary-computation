package evaluation;

import solution.DoubleArraySolution;

/**
 * Evaulacija De Jongove funkcije.
 * <p>
 * f(x) = sum(x[i] * x[i])
 * </p>
 * 
 * @author Ivan Kraljević
 * 
 */
public class DeJongsEvaulator implements Evaluator<DoubleArraySolution> {

	@Override
	public void evaluate(DoubleArraySolution solution) {
		double fitness = 0.;
		double[] x = solution.getData();
		for (int i = 0; i < x.length; i++) {
			fitness += x[i] * x[i];
		}
		solution.setFitness(fitness);
	}

}
