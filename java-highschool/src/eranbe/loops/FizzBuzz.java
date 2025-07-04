package eranbe.loops;

public class FizzBuzz {
    public static void main(String[] args) {
    	int fizzCount = 0, buzzCount = 0, fizzBuzzCount = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
                fizzBuzzCount++;
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
                fizzCount++;
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
                buzzCount++;
            } else {
                System.out.println(i);
            }
        }
        System.out.println("FizzBuzz: " + fizzBuzzCount);
        System.out.println("Fizz: " + fizzCount);
        System.out.println("Buzz: " + buzzCount);
    }
}
