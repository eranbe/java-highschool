package eranbe.arrays;

import java.util.Random;

public class SecondMax {
    public static void main(String[] args) {
        Random rnd = new Random();
        final int SIZE = 20; // קביעת אורך המערך ל-20
        int[] arr = new int[SIZE];
        // מילוי המערך במספרים אקראיים בין 1 ל-100
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100) + 1;
        }
        // הדפסת המערך המוגרל
        System.out.println("המערך בגודל 20 שהוגרל:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        findSecondMaxWay1(arr);
        findSecondMaxWay2(arr);
    }

    public static void findSecondMaxWay1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        System.out.println("max: " + max);
        System.out.println("second max:" + secondMax);
    }

    public static void findSecondMaxWay2(int[] arr) {
        // שכפול המערך כי אנחנו הולכים לשנות אותו
    	int[] copy = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
    		copy[i] = arr[i];
    	}
        // מציאת האינדקס של המקסימום
        int maxIndex = 0;
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] > copy[maxIndex]) {
                maxIndex = i;
            }
        }
        int firstMax = copy[maxIndex];
        // הצבת ערך מינימלי בתא המקסימום כדי "לנטרל" אותו
        copy[maxIndex] = Integer.MIN_VALUE;
        // חיפוש המקסימום החדש במערך המעודכן
        int secondMax = copy[0];
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] > secondMax) {
                secondMax = copy[i];
            }
        }
        System.out.println("max:" + firstMax);
        System.out.println("second max:" + secondMax);
    }
}
