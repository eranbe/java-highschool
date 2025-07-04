package eranbe.arrays;

import java.util.Random;
import java.util.Arrays; // ייבוא עבור Arrays.toString לטובת הדפסה נוחה

public class AnonymizationHelper {

    /**
     * Generates an array of positive and negative numbers that sum to zero.
     * The method attempts to create a balanced distribution of positive and negative numbers.
     *
     * @param num The total number of positive and negative numbers to generate. Must be a positive integer.
     * @return An array of Integers where the sum of all elements is zero.
     * @throws IllegalArgumentException if num is not a positive integer.
     */
    public static int[] generateZeroSumNumbers(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("The number of elements (num) must be a positive integer.");
        }

        // יצירת מערך בגודל num
        int[] numbers = new int[num];
        Random random = new Random();
        int currentSum = 0;

        // יצירת num - 1 מספרים אקראיים והוספתם למערך
        for (int i = 0; i < num - 1; i++) {
            // יצירת מספר אקראי בין -100 ל-100 (ניתן לשנות את הטווח הזה)
            int randomNumber = random.nextInt(201) - 100; // -100 עד 100
            numbers[i] = randomNumber;
            currentSum += randomNumber;
        }

        // המספר האחרון יחושב כך שסכום כל המספרים יהיה אפס
        int lastNumber = -currentSum;
        numbers[num - 1] = lastNumber; // הכנסת המספר האחרון למקום האחרון במערך

        return numbers;
    }

    public static void main(String[] args) {
        // דוגמה לשימוש:
        try {
            int numberOfElements = 10;
            int[] generatedNumbers = generateZeroSumNumbers(numberOfElements);
            System.out.println("Generated Numbers: " + Arrays.toString(generatedNumbers)); // שימוש ב-Arrays.toString להדפסת המערך

            // בדיקת הסכום
            int sum = 0;
            for (int number : generatedNumbers) {
                sum += number;
            }
            System.out.println("Sum of Generated Numbers: " + sum);

            // דוגמה נוספת
            int anotherSetOfElements = 5;
            int[] anotherSet = generateZeroSumNumbers(anotherSetOfElements);
            System.out.println("\nAnother Set of Numbers: " + Arrays.toString(anotherSet));
            int anotherSum = 0;
            for (int number : anotherSet) {
                anotherSum += number;
            }
            System.out.println("Sum of Another Set: " + anotherSum);

            // דוגמה לקלט לא חוקי
            // generateZeroSumNumbers(0); // זה יזרוק IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}