package eranbe.bagrut.q899371.a2025.q2;

public class Arrange {
	public static void main(String[] args) {
		int[] input = createArray();
		arrange(input);
		printArray(input);
		input = createArray();
		arrange2(input);
		printArray(input);
		input = createArray();
		arrange3(input);
		printArray(input);
		input = createArray();
		arrange4(input);
		printArray(input);

	}

	public static int[] createArray() {
		int[] input = {7, -2, -5, 61, 4, -1, 0, 33 };
		return input;
	}

	public static void printArray(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println();
	}

	// first solution - create to input-length arrays
	// one for pos and one neg. copy to them, and then copy back
	public static void arrange(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int[] positives = new int[input.length];
		int[] negatives = new int[input.length];
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
	
	public static void arrange2(int[] input) {
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
				positives[pIdx] = input[i];
				pIdx++;
			} else {
				negatives[nIdx] = input[i];
				nIdx++;
			}
		}
		int i = 0;
		while (positives[i] != -1) {
			input[i] = positives[i];
			i++;
		}
		int j = 0;
		while (negatives[j] != 1) {
			input[i] = negatives[j];
			i++;
			j++;
		}
	}

	public static void arrange3(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int[] helper = new int[input.length];
		int idx = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 0) {
				helper[idx] = input[i];
				idx++;
			}
		}
		for (int i = 0; i < input.length; i++) {
			if (input[i] < 0) {
				helper[idx] = input[i];
				idx++;
			}
		}
		for (int i = 0; i < helper.length; i++) {
			input[i] = helper[i];
		}
	}
	
	public static void arrange4(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int insertPos = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 0) {
				int temp = input[i];
				for (int j = i; j > insertPos; j--) {
					input[j] = input[j - 1];
				}
				input[insertPos] = temp;
				insertPos++;
			}
		}
	}

}
