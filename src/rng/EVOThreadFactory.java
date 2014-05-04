package rng;

import java.util.concurrent.ThreadFactory;

/**
 * Razred koji stvara nove dretve i skriva njihovo stvaranje od ostatka
 * aplikacije.
 * 
 * @author Ivan Kraljević
 * @see {@link ThreadFactory}
 */
public class EVOThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		return new EVOThread(r);
	}

}
