package main;

import image.GrayScaleImage;

import java.io.File;
import java.io.IOException;

import solution.IntArraySolution;

/**
 * Razred koji obavlja pomoćne operacije poput učitavanja slike, ili ispisa
 * rješenja u datoteku i slično.
 * 
 * @author Ivan Kraljević
 * 
 */
public class Utilities {

	/**
	 * Vraća sliku sa zadane lokacije.
	 * 
	 * @param path
	 *            putanja do slike.
	 * @return učitana slika.
	 */
	public static GrayScaleImage loadImage(String path) {
		GrayScaleImage image = null;
		try {
			image = GrayScaleImage.load(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Metoda pretvara rješenje u sliku te ju pohranjuje na specificiranu
	 * lokaciju.
	 * 
	 * @param solution
	 *            rješenje.
	 * @param path
	 *            lokacija na koju će se rješenje spremiti.
	 */
	public static void exportIntArraySolution(IntArraySolution solution,
			String path) {
		GrayScaleImage im = fromIntArraySolutionToImage(solution);
		try {
			im.save(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Ne mogu spremiti sliku!");
		}
	}

	/**
	 * Metoda pretvara {@code IntArraySolution} u grayscale sliku.
	 * 
	 * @param solution
	 *            rješenje.
	 * @return slika rješenja.
	 */
	public static GrayScaleImage fromIntArraySolutionToImage(
			IntArraySolution solution) {
		GrayScaleImage im = new GrayScaleImage(200, 133);
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
		return im;
	}
}
