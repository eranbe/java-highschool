package eranbe.datastructures.lzw;

import eranbe.datastructures.Node;

class LZ77Compression {
	static class Tuple {
		int offset;
		int length;
		char nextChar;

		Tuple(int offset, int length, char nextChar) {
			this.offset = offset;
			this.length = length;
			this.nextChar = nextChar;
		}

		@Override
		public String toString() {
			return "(" + offset + ", " + length + ", '" + nextChar + "')";
		}
		
		public char[] toCharArray() {
			char[] result = new char[3];
			result[0] = (char) offset;
			result[1] = (char) length;
			result[2] = nextChar;
			return result;
		}
	}

	public static Node<Tuple> compress(String input, int windowSize) {
		Node<Tuple> head = null, tail = null;
		int i = 0;

		while (i < input.length()) {
			int bestMatchOffset = 0, bestMatchLength = 0;
			String searchWindow = input.substring(Math.max(0, i - windowSize), i);

			int j = 1;
			boolean foundMatch = false;

			// חיפוש ההתאמה הכי ארוכה
			while (j <= input.length() - i) {
				String sub = input.substring(i, Math.min(i + j, input.length()));
				int index = searchWindow.lastIndexOf(sub);

				if (index != -1) {
					bestMatchOffset = searchWindow.length() - index;
					bestMatchLength = j;
					foundMatch = true;
				}

				j++;
			}

			// אם לא מצאנו התאמה, אנו נשארים עם offset = 0 ו-length = 0
			if (!foundMatch) {
				bestMatchOffset = 0;
				bestMatchLength = 0;
			}

			// קביעת התו הבא לאחר ההתאמה
			char nextChar = '\0';
			if (i + bestMatchLength < input.length()) {
				nextChar = input.charAt(i + bestMatchLength);
			}

			// יצירת Tuple המייצג את ההתאמה
			Tuple tuple = new Tuple(bestMatchOffset, bestMatchLength, nextChar);
			Node<Tuple> newNode = new Node<>(tuple);

			// הוספת ה-Node לרשימה המקושרת
			if (head == null) {
				head = newNode;
			} else {
				tail.setNext(newNode);
			}
			tail = newNode;

			// מעבר למיקום הבא אחרי ההתאמה
			i += bestMatchLength + 1;
		}

		return head;
	}

	public static void printCompressed(Node<Tuple> head) {
		Node<Tuple> current = head;
		String sizer = "";
		while (current != null) {
			System.out.println(current.getValue());
			sizer += current.getValue();
			current = current.getNext();
		}
		System.out.println("Compressed size:" + (sizer.length() * 3 / 11));

	}

	public static String decompress(Node<Tuple> compressedData) {
		String result = "";
		Node<Tuple> currentNode = compressedData;

		while (currentNode != null) {
			Tuple tuple = currentNode.getValue();
			int offset = tuple.offset;
			int length = tuple.length;
			char nextChar = tuple.nextChar;

			// אם יש התאמה מתוך ההיסטוריה, נשחזר אותה
			int startIndex = result.length() - offset;
			String match = result.substring(startIndex, startIndex + length);

			// הוסף את ההתאמה לטקסט
			result = result + match;

			// הוסף את התו הבא (nextChar)
			if (nextChar != '\0') {
				result = result + nextChar;
			}

			currentNode = currentNode.getNext();
		}

		return result;
	}

	public static char[] toCharArray(Node<Tuple> compressedData) {
		Node<Tuple> nodeCounter = compressedData;
		int count = 1;
		while (nodeCounter != null) {
			nodeCounter = nodeCounter.getNext();
			count++;
		}
		int nextAvailable = 0;
		char[] result = new char[count * 3];
		while (compressedData != null) {
			char[] currEncoded = compressedData.getValue().toCharArray();
			result[nextAvailable++] = currEncoded[0];
			result[nextAvailable++] = currEncoded[1];
			result[nextAvailable++] = currEncoded[2];
			compressedData = compressedData.getNext();
		}
		return result;
	}
	
	public static Node<Tuple> toNodeList(char[] encoded) {
		Node<Tuple> head = null, curr = null;
		int i = 0;
		while (i < encoded.length) {
			Tuple t = new Tuple(encoded[i], encoded[i+1], encoded[i+2]);
			i += 3;
			Node<Tuple> next = new Node<Tuple>(t);
			if (head == null) {
				head = next;
				curr = next;
			} else {
				curr.setNext(next);
				curr = next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		// String input = "ABABABABA";
		String input = "In the beginning God created the heaven and the earth."

				+ " And the earth was without form, and void; and darkness was upon the face of the deep. And the Spirit of God moved upon the face of the waters."

				+ " And God said, Let there be light: and there was light."

				+ " And God saw the light, that it was good: and God divided the light from the darkness."

				+ " And God called the light Day, and the darkness he called Night. And the evening and the morning were the first day."

				+ " And God said, Let there be a firmament in the midst of the waters, and let it divide the waters from the waters."

				+ " And God made the firmament, and divided the waters which were under the firmament from the waters which were above the firmament: and it was so."

				+ " And God called the firmament Heaven. And the evening and the morning were the second day."

				+ " And God said, Let the waters under the heaven be gathered together unto one place, and let the dry land appear: and it was so."

				+ " And God called the dry land Earth; and the gathering together of the waters called he Seas: and God saw that it was good."

				+ " And God said, Let the earth bring forth grass, the herb yielding seed, and the fruit tree yielding fruit after his kind, whose seed is in itself, upon the earth: and it was so."

				+ " And the earth brought forth grass, and herb yielding seed after his kind, and the tree yielding fruit, whose seed was in itself, after his kind: and God saw that it was good."

				+ " And the evening and the morning were the third day."

				+ " And God said, Let there be lights in the firmament of the heaven to divide the day from the night; and let them be for signs, and for seasons, and for days, and years:"

				+ " And let them be for lights in the firmament of the heaven to give light upon the earth: and it was so."

				+ " And God made two great lights; the greater light to rule the day, and the lesser light to rule the night: he made the stars also."

				+ " And God set them in the firmament of the heaven to give light upon the earth,"

				+ " And to rule over the day and over the night, and to divide the light from the darkness: and God saw that it was good."

				+ " And the evening and the morning were the fourth day."

				+ " And God said, Let the waters bring forth abundantly the moving creature that hath life, and fowl that may fly above the earth in the open firmament of heaven."

				+ " And God created great whales, and every living creature that moveth, which the waters brought forth abundantly, after their kind, and every winged fowl after his kind: and God saw that it was good."

				+ " And God blessed them, saying, Be fruitful, and multiply, and fill the waters in the seas, and let fowl multiply in the earth."

				+ " And the evening and the morning were the fifth day."

				+ " And God said, Let the earth bring forth the living creature after his kind, cattle, and creeping thing, and beast of the earth after his kind: and it was so."

				+ " And God made the beast of the earth after his kind, and cattle after their kind, and every thing that creepeth upon the earth after his kind: and God saw that it was good."

				+ " And God said, Let us make man in our image, after our likeness: and let them have dominion over the fish of the sea, and over the fowl of the air, and over the cattle, and over all the earth, and over every creeping thing that creepeth upon the earth."

				+ " So God created man in his own image, in the image of God created he him; male and female created he them."

				+ " And God blessed them, and God said unto them, Be fruitful, and multiply, and replenish the earth, and subdue it: and have dominion over the fish of the sea, and over the fowl of the air, and over every living thing that moveth upon the earth."

				+ " And God said, Behold, I have given you every herb bearing seed, which is upon the face of all the earth, and every tree, in the which is the fruit of a tree yielding seed; to you it shall be for meat."

				+ " And to every beast of the earth, and to every fowl of the air, and to every thing that creepeth upon the earth, wherein there is life, I have given every green herb for meat: and it was so."

				+ " And God saw every thing that he had made, and, behold, it was very good. And the evening and the morning were the sixth day.";
		System.out.println("Original:");
		// System.out.println(input);
		System.out.println("Original size:" + input.length());
		int windowSize = 256;
		Node<Tuple> compressed = compress(input, windowSize);

		System.out.println("Compressed:");
		printCompressed(compressed);
		// System.out.println("Deflated:");
		// System.out.println(decompress(compressed));
		char[] encoded = toCharArray(compressed);
		System.out.println(encoded);
		Node<Tuple> fromEncoded = toNodeList(encoded);
		System.out.println("Deflated:");
		System.out.println(decompress(fromEncoded));

	}
}
