package eranbe.loops;

public class Armstrong {
    public static void main(String[] args) {
        for (int num = 100; num < 1000; num++) {
            int original = num;
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit * digit; // שלוש ספרות → חזקה של 3
                temp /= 10;
            }

            if (sum == original) {
                System.out.println(original + " הוא מספר ארמסטרונג");
            }
        }
    }
}
