package eranbe.classes.arrayofobjects.yomhashoa;

public class HasidimProgram {

	public static void main(String[] args) {
		Hasid[] hasidim = YadVaShemDataReader.readHasidData(
				YadVaShemDataReader.Source.FILE);
		printAndCountAllHasidsFromCountry(hasidim, "belarus");
		printHasidimPerYear(hasidim);
		printHasidimPerCountry(hasidim);
	}

	public static void printHasidimPerCountry(Hasid[] hasidim) {
		String[] countries = new String[200];
		int[] counts = new int[200];
		int nextAvailableIndex = 0;
		for (int i = 0; i < hasidim.length; i++) {
			Hasid h = hasidim[i];
			String country = h.getCountry();
			int j = 0;
			boolean found = false;
			while (j < nextAvailableIndex && !found) {
				if (country.equals(countries[j])) {
					updateCounter(counts, j, h);
					found = true;
				} else {
					j++;
				}
			}
			if (!found) {
				countries[nextAvailableIndex] = country;
				updateCounter(counts, nextAvailableIndex, h);
				nextAvailableIndex++;
			}
		}
		Medina[] medinot = new Medina[200];
		int k = 0; 
		while (k < counts.length && counts[k] > 0) {
			medinot[k] = new Medina(countries[k], counts[k]);
			System.out.println(medinot[k]);
			k++;
		}
	}

	public static void printHasidimPerYear(Hasid[] hasidim) {
		int[] years = new int[100];
		int[] counts = new int[100];
		int nextAvailableIndex = 0;
		for (int i = 0; i < hasidim.length; i++) {
			Hasid h = hasidim[i];
			int year = h.getYear();
			int j = 0;
			boolean found = false;
			while (j < nextAvailableIndex && !found) {
				if (year == years[j]) {
					updateCounter(counts, j, h);
					found = true;
				} else {
					j++;
				}
			}
			if (!found) {
				years[nextAvailableIndex] = year;
				updateCounter(counts, nextAvailableIndex, h);
				nextAvailableIndex++;
			}
		}
		int k = 0; 
		while (k < counts.length && counts[k] > 0) {
			System.out.println("Year: " + years[k] + " - Count: " + counts[k]);
			k++;
		}
	}
		
	private static void updateCounter(int[] counts, int index, Hasid h) {
		counts[index] += h.getQty();
	}

	public static void printAndCountAllHasidsFromCountry(Hasid[] hasidim, String country) {
		int count = 0;
		for (int i = 0; i < hasidim.length; i++) {
			if (hasidim[i].getCountry().equals(country)) {
				count += hasidim[i].getQty();
				System.out.println(hasidim[i].getName());
			}
		}
		System.out.println("Count for " + country + " is " + count);
	}
}
