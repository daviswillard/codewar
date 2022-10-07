package exeoh;

public class Main {
	public static void main(String[] args) {

	}

	public boolean getXO(String str) {
		boolean b = true;
		int[] arr = new int[2];

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x' || str.charAt(i) == 'X') {
				arr[0]++;
			} else if (str.charAt(i) == 'o' || str.charAt(i) == 'O') {
				arr[1]++;
			}
		}
		if (arr[0] != arr[1]) {
			b = false;
		}
		return b;
	}
}
