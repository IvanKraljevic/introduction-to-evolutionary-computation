package rng.provimpl;

import rng.IRNG;
import rng.IRNGProvider;
import rng.impl.RNGRandomImpl;

public class ThreadLocalRNGProvider implements IRNGProvider {
	private ThreadLocal<IRNG> rngs;
	
	public ThreadLocalRNGProvider() {
		rngs = new ThreadLocal<IRNG>() {
			@Override
			protected IRNG initialValue() {
				return new RNGRandomImpl();
			}
		};
	}

	@Override
	public IRNG getRNG() {
		return rngs.get();
	}

}
