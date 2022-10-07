package arraysdiff;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

	}

	public static int[] arrayDiff(int[] a, int[] b) {
		b = Arrays.stream(b).distinct().toArray();
		Integer[] aCopy = Arrays.stream(a).boxed().toArray(Integer[]::new);
		for (int iter: b) {
			for (int i = 0; i < aCopy.length; i++) {
				if (aCopy[i] != null && aCopy[i].equals(iter)) {
					aCopy[i] = null;
				}
			}
		}
		aCopy = Arrays.stream(aCopy)
				.filter(integer -> integer != null)
				.toArray(Integer[]::new);
		a = new int[aCopy.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = aCopy[i];
		}
		return a;
	}
}
