package rng.provimpl;

import rng.IRNG;
import rng.IRNGProvider;

/**
 * 
 * @author Ivan Kraljević
 * 
 */
public class ThreadBoundRNGProvider implements IRNGProvider {

	@Override
	public IRNG getRNG() {
		IRNGProvider rv = (IRNGProvider) Thread.currentThread();
		return rv.getRNG();
	}

}
