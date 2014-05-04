package operator.crossover;

import rng.IRNG;
import solution.DoubleArraySolution;

/**
 * BLX-alpha križanje.
 * 
 * @author Ivan Kraljević
 * 
 */
public class BLXAlphaCrossover implements Crossover<DoubleArraySolution> {

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/** Parametar alpha. */
	private double alpha;

	public BLXAlphaCrossover(double alpha, IRNG rand) {
		setAlpha(alpha);
		setRand(rand);
	}

	@Override
	public DoubleArraySolution mate(DoubleArraySolution p1,
			DoubleArraySolution p2) {
		if (p1.getDimension() != p2.getDimension()) {
			throw new IllegalArgumentException();
		}
		double[] p1Data = p1.getData();
		double[] p2Data = p2.getData();

		double[] v = new double[p1.getDimension()];
		for (int i = 0; i < v.length; i++) {
			double max = Math.max(p1Data[i], p2Data[i]);
			double min = Math.min(p1Data[i], p2Data[i]);
			double interval = max - min;
			min -= alpha * interval;
			max += alpha * interval;
			v[i] = rand.nextDouble(min, max);
		}
		return new DoubleArraySolution(v);
	}

	/**
	 * Postavlja generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            generator slučajnih brojeva.
	 * @throws IllegalArgumentException
	 *             ako je parametar {@code null}.
	 */
	protected void setRand(IRNG rand) {
		if (rand == null) {
			throw new IllegalArgumentException();
		}
		this.rand = rand;
	}

	/**
	 * Postavlja parametar alpha.
	 * 
	 * @param alpha
	 *            parametar alpha.
	 */
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

}
