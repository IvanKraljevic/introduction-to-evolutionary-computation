package rng;

import rng.impl.RNGRandomImpl;

/**
 * Dretva koja istovremeno implementira ponašanje {@link IRNGProvider} stoga
 * sadrži vlastiti generator slučajnih brojeva.
 * 
 * @author Ivan Kraljević
 * 
 */
public class EVOThread extends Thread implements IRNGProvider {

	/** Generator slučajnih brojeva dretve. */
	private IRNG rng = new RNGRandomImpl();

	@Override
	public IRNG getRNG() {
		return rng;
	}

	// *** KONSTRUKTORI *** \\

	public EVOThread() {

	}

	public EVOThread(Runnable target) {
		super(target);
	}

	public EVOThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public EVOThread(ThreadGroup group, String name) {
		super(group, name);
	}

	public EVOThread(Runnable target, String name) {
		super(target, name);
	}

	public EVOThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public EVOThread(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
	}

}
