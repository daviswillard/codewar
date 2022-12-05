package exercises.tribonacci;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Arrays.stream(tribonacci(new double []{1,1,1},1))
				.forEach(System.out::println);
	}

	public static double[] tribonacci(double[] s, int n) {
		double[] ret = new double[n];

		System.arraycopy(s, 0, ret, 0, Math.max(s.length, ret.length));
		for (int i = 3; i < n; ++i) {
			ret[i] = sumArray(ret, i - 3);
		}
		return ret;
	}

	private static double	sumArray(double[] a, int i) {
		return a[i] + a[i + 1] + a[i + 2];
	}
}
