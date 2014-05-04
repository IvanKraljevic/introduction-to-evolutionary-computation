package solution;

/**
 * Apstraktna klasa koja predstavlja rješenje evolucijskog algoritma.
 * 
 * @author Ivan Kraljević
 * 
 * @param <T>
 */
public abstract class Solution<T> implements Comparable<Solution<T>> {

	/** Podaci. */
	protected T data;

	/** Vrijednost fitnessa. */
	protected double fitness;

	/**
	 * Pretpostavljeni (engl. default) konstruktor.
	 */
	public Solution() {

	}

	/**
	 * Vraća novu kopiju (tj. klona) ovog rješenja.
	 * 
	 * @return nova kopija rješenja.
	 */
	public abstract Solution<T> copy();

	/**
	 * Uspoređuje ovo rješenje sa rješenjem iz parametra kako bi utvrdilo njihov
	 * odnos. Vraća negativan broj, nulu ili pozitivan broj ukoliko je ovaj
	 * objekt manji od, jednak, odnosno veći od rješenja iz parametra. Koristi
	 * se kod sortiranja.
	 */
	@Override
	public int compareTo(Solution<T> o) {
		return Double.compare(this.fitness, o.fitness);
	}

	/**
	 * Vraća pohranjene podatke.
	 * 
	 * @return data.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Postavlja podatke na vrijednost zadanu u argumentu.
	 * 
	 * @param data
	 *            podaci.
	 * @throws IllegalArgumentException
	 *             ako je vrijednost podataka {@code null}.
	 */
	public void setData(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Null values are not allowed!");
		}
		this.data = data;
	}

	/**
	 * Vraća fitness rješenja.
	 * 
	 * @return fitness.
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * Postavlja fitness rješenja na vrijednost zadanu u parametru.
	 * 
	 * @param fitness
	 *            new fitness value.
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	@Override
	public String toString() {
		return "Solution [data=" + data + ", fitness=" + fitness + "]";
	}

}
