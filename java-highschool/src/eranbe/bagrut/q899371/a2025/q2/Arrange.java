package eranbe.bagrut.q899371.a2025.q2;

public class Arrange {
	public static void main(String[] args) {
		int[] input = {7, -2, -5, 61, 4, -1, 0, 33 };
		arrange(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println();
	}

	public static void arrange(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int[] positives = new int[input.length];
		int[] negatives = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			positives[i] = -1;
			negatives[i] = 1;
		}
		int pIdx = 0;
		int nIdx = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 0) {
				positives[pIdx++] = input[i];
			} else {
				negatives[nIdx++] = input[i];
			}
		}
		for (int i = 0; i < pIdx; i++) {
			input[i] = positives[i];
		}
		for (int i = 0; i < nIdx; i++) {
			input[i+pIdx] = negatives[i];
		}
	}
}
