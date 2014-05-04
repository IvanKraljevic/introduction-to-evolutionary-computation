package operator.selection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rng.IRNG;
import solution.Solution;

/**
 * Implementacija k-turnirske selekcije. Parametar <em>k</em> određuje veličinu
 * turnira. Ako se traži najgora jedinka turnira (najniži fitness), atribut
 * {@code min} mora biti postavljen na <b>true</b>.<br>
 * Ako se traži najbolja jedinka turnira (najveći fitness), atribut {@code min}
 * mora biti postavljen na <b>false</b>.
 * 
 * @author Ivan Kraljević
 * 
 */
public class TournamentSelection<T extends Solution<?>> implements Selection<T> {

	/** Veličina turnira, tj. parametar k. */
	private int tournamentSize;

	/** Generator slučajnih brojeva. */
	private IRNG rand;

	/** {@code true} ako tražimo najgoru jedinku, inače {@code false}. */
	private boolean min;

	public TournamentSelection(int tournamentSize, boolean min, IRNG rand) {
		setRand(rand);
		setTournamentSize(tournamentSize);
		this.min = min;
	}

	@Override
	public T select(List<? extends T> pool) {
		// ukoliko je veličina turnira veća od veličine ulazne liste, cijela
		// lista se natječe u turniru
		if (pool.size() < tournamentSize) {
			return getWinner(pool);
		}

		List<T> chosenSolutions = new ArrayList<T>();
		for (int i = 0; i < tournamentSize; i++) {
			int index = rand.nextInt(0, pool.size());
			// ne dozvoljavamo višestruko pojavljivanje istog objekta
			if (!chosenSolutions.contains(pool.get(index))) {
				chosenSolutions.add(pool.get(index));
				i++;
			}
		}
		return getWinner(chosenSolutions);
	}

	/**
	 * Vraća pobjednika turnira.
	 * 
	 * @param chosenSolutions
	 *            rješenja koja se "natječu" u turniru.
	 * @return pobjednik turnira, tj. najbolja jedinka.
	 */
	protected T getWinner(List<? extends T> chosenSolutions) {
		return min ? Collections.min(chosenSolutions) : Collections
				.max(chosenSolutions);
	}

	/**
	 * Vraća veličinu turnira.
	 * 
	 * @return veličina turnira.
	 */
	public int getTournamentSize() {
		return tournamentSize;
	}

	/**
	 * Postavlja veličinu turnira na vrijednost zadanu u parametru. Veličina
	 * turnira mora biti pozitivan cijeli broj.
	 * 
	 * @param tournamentSize
	 *            veličina turnira.
	 * @throws IllegalArgumentException
	 *             ako je veličina turnira manja od 0.
	 */
	public void setTournamentSize(int tournamentSize) {
		if (tournamentSize <= 0) {
			throw new IllegalArgumentException();
		}
		this.tournamentSize = tournamentSize;
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

}
