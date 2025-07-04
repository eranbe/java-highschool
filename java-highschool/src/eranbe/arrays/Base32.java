package eranbe.arrays;

public class Base32 {

    public static Character[] encode(Character[] input, Character[] alphabet) {
        Character[] encoded = new Character[input.length * 2];
        int index = encoded.length;
        long num = 0;
        
        for (char c : input) {
            num = num * 256 + (int) c;
        }
        
        while (num > 0) {
            int remainder = (int) (num % alphabet.length);
            num /= alphabet.length;
            encoded[--index] = alphabet[remainder];
        }
        
        int resultLength = encoded.length - index;
        Character[] result = new Character[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = encoded[index + i];
        }
        return result;
    }

    public static Character[] decode(Character[] input, Character[] alphabet) {
        long num = 0;
        for (char c : input) {
            int pos = 0;
            while (alphabet[pos] != c) {
                pos++;
            }
            num = num * alphabet.length + pos;
        }
        
        Character[] decoded = new Character[input.length];
        int index = decoded.length;
        while (num > 0) {
            decoded[--index] = (char) (num % 256);
            num /= 256;
        }
        
        int resultLength = decoded.length - index;
        Character[] result = new Character[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = decoded[index + i];
        }
        return result;
    }

    public static void main(String[] args) {
    	Character[] alphabet = {'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[] text = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'B', 'a', 's', 'e', '5', '8', ' ', 'E', 'n', 'c', 'o', 'd', 'e', 'r'};
        
        Character[] encoded = encode(text, alphabet);
        System.out.print("Encoded: ");
        for (char c : encoded) {
            System.out.print(c);
        }
        System.out.println();
        
        Character[] decoded = decode(encoded, alphabet);
        System.out.print("Decoded: ");
        for (char c : decoded) {
            System.out.print(c);
        }
        System.out.println();
    }
}
