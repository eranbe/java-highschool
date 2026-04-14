package eranbe.datastructures.bintree;

import static eranbe.datastructures.BinNode.isLeaf;
import eranbe.datastructures.BinNode;

/**
 * See
 * https://docs.google.com/presentation/d/1lQLC3Eh_qNKYLvZn-TwdqWyJVk_4tGRQ/edit?usp=sharing&ouid=101494708632928300874&rtpof=true&sd=true
 */
public class ExpressionTrees {
	public static void main(String[] args) {
		BinNode<String> mathExp = buildComputeTree();
		System.out.println(isComputeTree(mathExp));
		System.out.println(computeTree(mathExp) + "=" + mathTreeToString(mathExp));
		
		BinNode<String> boolExp = buildBoolTree();
		System.out.println(isBoolTree(boolExp));
		System.out.println(calculateBoolTree(boolExp) + "=" + mathTreeToString(boolExp));
	}
	
	public static BinNode<String> buildComputeTree() {
		BinNode<String> tm1 = new BinNode<String>(new BinNode<String>("3"), "-", new BinNode<String>("2"));
		BinNode<String> tm2 = new BinNode<String>(new BinNode<String>("4"), "*", new BinNode<String>("1"));
		BinNode<String> tm3 = new BinNode<String>(tm2, "+", new BinNode<String>("8"));
		BinNode<String> t = new BinNode<String>(tm1, "*", tm3);
		return t;
	}

	public static BinNode<String> buildBoolTree() {
		BinNode<String> tm1 = new BinNode<String>(new BinNode<String>("F"), "AND", new BinNode<String>("T"));
		BinNode<String> tm2 = new BinNode<String>(new BinNode<String>("T"), "AND", new BinNode<String>("T"));
		BinNode<String> tm3 = new BinNode<String>(tm2, "AND", new BinNode<String>("T"));
		BinNode<String> t = new BinNode<String>(tm1, "OR", tm3);
		return t;
	}

	public static boolean isComputeTree(BinNode<String> bt) {
		if (bt == null)
			return false;
		if (isLeaf(bt))
			return isNumber(bt.getValue()); // בדיקה אם העלה הוא מספר
		else {
			boolean isOp = false;
			String value = bt.getValue();
			if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))
				isOp = true;
			return isOp && isComputeTree(bt.getLeft()) && isComputeTree(bt.getRight());
		}
	}

	static boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9')
				return false;
		}
		return true;
	}

	public static int computeTree(BinNode<String> bt) {
		if (isLeaf(bt))
			return Integer.parseInt(bt.getValue());
		int left = computeTree(bt.getLeft());
		int right = computeTree(bt.getRight());
		String op = bt.getValue();
		int ans = 0;
		if (op.equals("+"))
			ans = left + right;
		if (op.equals("-"))
			ans = left - right;
		if (op.equals("*"))
			ans = left * right;
		if (op.equals("/"))
			ans = left / right;
		return ans;
	}

	public static String mathTreeToString(BinNode<String> bt) {
		if (isLeaf(bt))
			return bt.getValue();
		else {
			String left = mathTreeToString(bt.getLeft());
			String right = mathTreeToString(bt.getRight());
			return "(" + left + " " + bt.getValue() + " " + right + ")";
		}
	}

	public static boolean calculateBoolTree(BinNode<String> t) {
		if (isLeaf(t)) {
			if (t.getValue() == "T")
				return true;
			else // "F"
				return false;
		}
		if (t.getValue() == "AND")
			return calculateBoolTree(t.getLeft()) && calculateBoolTree(t.getRight());
		else // "OR"
			return calculateBoolTree(t.getLeft()) || calculateBoolTree(t.getRight());
	}

	public static boolean isBoolTree(BinNode<String> t) {
		 // אם אין 2 בנים !
		if (t == null)
			return false;
		// אם אני עלה והתוכן תקין
		if (isLeaf(t) && (t.getValue().equals("T") || t.getValue().equals("F")))
			return true;
		// אם אני צומת והערך תקין
		if (t.getValue().equals("OR") || t.getValue().equals("AND"))
			return isBoolTree(t.getLeft()) && isBoolTree(t.getRight());
		else
			return false;
	}
}
