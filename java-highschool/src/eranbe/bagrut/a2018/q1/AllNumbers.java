package eranbe.bagrut.a2018.q1;

public class AllNumbers {

	private int[] arrayNum;
	public int lastOddValue() {
		for (int i = arrayNum.length - 1; i >= 0; i--) {
			if (arrayNum[i] % 2 == 1) {
				return arrayNum[i];
			}
		}
		return 0;
	}
}
