package eranbe.bagrut.q899371.a2026.q1;

public class Q1 {

	/*
a) 

n  | steps | root | square |
---+-------+------+--------+
23 | 0     | 4    | 16     |
7  | 1     | 2    | 4      |
3  | 2     | 1    | 1      |
2  | 3     | 1    | 1      |
1  | 4     | 1    | 1      |
0  | 5     |

Print: 5

b) any number which is a square root of a positive int greater than one.
 E.g., 4, 9, 16, 25, 36, ...  

	 */
	public static void main(String[] args) {
		int n = 23;
		int steps = 0;
		while (n > 0) {
			int root = (int)(Math.sqrt(n));
			int square = (int)(Math.pow(root, 2));
			n = n - square;
			steps++;
		}
		System.out.println(steps);
	}
}
