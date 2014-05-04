package evaluation;

import image.GrayScaleImage;
import solution.IntArraySolution;

/**
 * Evaulacija grayscale ("crno-bijele") slike. Aproksimacija originalne slike se
 * radi od fiksnog brojeg pravokutnika.
 * <p>
 * <strong>{@code IntArraySolution} tip rješenja je loš i neefikasan za ovaj tip
 * problema!</strong>
 * </p>
 * 
 * @author Ivan Kraljević
 * 
 */
public class GrayscaleImageEvaluator implements Evaluator<IntArraySolution> {
	/** Originalna slika. */
	private GrayScaleImage template;

	/** Pomoćni objekt u kojega se spremaju bajtovi rješenja. */
	public GrayScaleImage im;

	/**
	 * Vraća evaulator gdje je slika koja se aproksimira zadana u parametru.
	 * 
	 * @param template
	 *            originalna slika.
	 */
	public GrayscaleImageEvaluator(GrayScaleImage template) {
		setTemplate(template);
		createIm();
	}

	/**
	 * Metoda od {@code IntArraySolution} objekta crta sliku, tj. aproksimaciju
	 * originalne slike.
	 * 
	 * @param solution
	 *            rješenje/jedinka/kromosom.
	 */
	private void draw(IntArraySolution solution) {
		int[] data = solution.getData();
		byte bgcol = (byte) data[0];
		im.clear(bgcol);
		int n = (data.length - 1) / 5;
		int index = 1;
		for (int i = 0; i < n; i++) {
			im.rectangle(data[index], data[index + 1], data[index + 2],
					data[index + 3], (byte) data[index + 4]);
			index += 5;
		}
	}

	@Override
	public void evaluate(IntArraySolution solution) {
		if (im == null) {
			createIm();
		}
		draw(solution);
		byte[] data = im.getData();
		byte[] tdata = template.getData();
		int w = im.getWidth();
		int h = im.getHeight();
		double error = 0;
		int index2 = 0;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				error += Math.abs(((int) data[index2] & 0xFF)
						- ((int) tdata[index2] & 0xFF));
				index2++;
			}
		}
		solution.setFitness(error);
	}

	/**
	 * Metoda alocira memoriju za pomoćni objekt.
	 */
	private void createIm() {
		setIm(new GrayScaleImage(template.getWidth(), template.getHeight()));
	}

	/**
	 * Postavlja originalnu sliku.
	 * 
	 * @param template
	 *            originalna slika.
	 */
	private void setTemplate(GrayScaleImage template) {
		if (template == null) {
			throw new IllegalArgumentException();
		}
		this.template = template;
	}

	/**
	 * Postavlja pomoćni objekt.
	 * 
	 * @param im
	 *            pomoćni objekt.
	 */
	private void setIm(GrayScaleImage im) {
		if (im == null) {
			throw new IllegalArgumentException();
		}
		this.im = im;
	}

	/**
	 * Vraća kopiju ovog objekta, tj. klonira ga.
	 * 
	 * @return kopija evaulatora.
	 */
	public GrayscaleImageEvaluator copy() {
		return new GrayscaleImageEvaluator(template.copy());
	}
}
