package rng.impl;

import java.util.Random;

import rng.IRNG;

/**
 * Implementacija generatora slučajnih brojeva.
 * 
 * @author Ivan Kraljević
 * 
 */
public class RNGRandomImpl implements IRNG {

	/** Javin generator slučajnih brojeva. */
	private Random rand;

	/**
	 * Pretpostavljeni (engl. default) konstruktor.
	 */
	public RNGRandomImpl() {
		setRand(new Random());
	}

	/**
	 * Stvara novi objekt sa zadanim Java generatorom slučajnih brojeva.
	 * 
	 * @param rand
	 *            Javin generator slučajnih brojeva.
	 */
	public RNGRandomImpl(Random rand) {
		setRand(rand);
	}

	@Override
	public double nextDouble() {
		return rand.nextDouble();
	}

	@Override
	public double nextDouble(double min, double max) {
		return (max - min) * rand.nextDouble() + min;
	}

	@Override
	public float nextFloat() {
		return rand.nextFloat();
	}

	@Override
	public float nextFloat(float min, float max) {
		return (max - min) * rand.nextFloat() + min;
	}

	@Override
	public int nextInt() {
		return rand.nextInt();
	}

	@Override
	public int nextInt(int min, int max) {
		return rand.nextInt(max - min) + min;
	}

	@Override
	public boolean nextBoolean() {
		return rand.nextBoolean();
	}

	@Override
	public double nextGaussian() {
		return rand.nextGaussian();
	}

	/**
	 * Postavlja javin generator slučajnih brojeva.
	 * 
	 * @param rand
	 *            ako je parametar {@code null}.
	 */
	private void setRand(Random rand) {
		if (rand == null) {
			throw new IllegalArgumentException(
					"Random number generator must not be null!");
		}
		this.rand = rand;
	}

}
