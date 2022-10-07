package squaredigit;

import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Main mainObj = new Main();
		System.out.println(mainObj.squareDigits(303));
	}

	public int squareDigits(int n) {
		return Integer.parseInt(String.valueOf(n)
				.chars()
				.map(i -> Integer.parseInt(String.valueOf((char) i)))
				.map(i -> i * i)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining("")));
	}
}
