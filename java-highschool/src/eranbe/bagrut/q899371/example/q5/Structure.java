package eranbe.bagrut.q899371.example.q5;

public class Structure {
	private Pixel[][] arr;
	
	public boolean isBalanced() {
		int redCount = 0, greenCount = 0, blueCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				Pixel p = arr[i][j];
				if (p.isRed())
					redCount++;
				else if (p.isGreen())
					greenCount++;
				else if (p.isBlue())
					blueCount++;
			}
		}
		return (redCount == greenCount) && (greenCount == blueCount);
	}
	
	public boolean allOthers() {
		int redCount = 0, greenCount = 0, blueCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				Pixel p = arr[i][j];
				if (p.isRed())
					redCount++;
				else if (p.isGreen())
					greenCount++;
				else if (p.isBlue())
					blueCount++;
			}
			if ((redCount == 0) && (greenCount == 0) && (blueCount == 0))
				return true;
		}
		return false;
	}
}
