package eranbe.sort.advanced;

public class BucketSortWithNode {

    /**
     * ביצוע מיון דליים על מערך של מספרים בטווח [0, 1)
     * @param arr המערך למיון
     */
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // 1. יצירת מערך הדליים. כל תא הוא 'ראש שרשרת' (Node)
        // אנו משתמשים ב-SuppressWarnings כי יצירת מערך גנרי היא בעייתית בג'אווה,
        // אך זה מקובל במסגרת הלימודים בתיכון לצורך הפשטות.
        @SuppressWarnings("unchecked")
        Node<Double>[] buckets = new Node[n];

        // 2. פיזור האיברים לדליים (לתוך שרשראות החוליות)
        for (int i = 0; i < arr.length; i++) {
        	double val = arr[i];
            int bucketIdx = (int) (val * n);
            // הכנסה ממוינת לתוך השרשרת המתאימה
            buckets[bucketIdx] = insertSorted(buckets[bucketIdx], val);
        }

        // 3. איסוף חזרה מן הדליים למערך המקורי
        int index = 0;
        for (int i = 0; i < n; i++) {
            Node<Double> curr = buckets[i];
            while (curr != null) {
                arr[index++] = curr.getValue();
                curr = curr.getNext();
            }
        }
    }

    /**
     * פעולת עזר קלאסית מיחידה 4: הכנסת ערך לשרשרת ממוינת תוך שמירה על הסדר
     * @param head ראש השרשרת הנוכחית
     * @param val הערך להכנסה
     * @return ראש השרשרת המעודכן (למקרה שהערך החדש נכנס בראש)
     */
    private static Node<Double> insertSorted(Node<Double> head, double val) {
        Node<Double> newNode = new Node<>(val);

        // מקרה א': השרשרת ריקה, או שהערך החדש קטן מראש השרשרת
        if (head == null || head.getValue() >= val) {
            newNode.setNext(head);
            return newNode; // החוליה החדשה היא הראש החדש
        }

        // מקרה ב': חיפוש המקום המתאים באמצע או בסוף השרשרת
        Node<Double> current = head;
        while (current.hasNext() && current.getNext().getValue() < val) {
            current = current.getNext();
        }

        // שתילת החוליה החדשה אחרי 'current'
        newNode.setNext(current.getNext());
        current.setNext(newNode);

        return head; // הראש נשאר אותו ראש
    }

    // לבדיקה
    public static void main(String[] args) {
        double[] data = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};

        System.out.println("לפני המיון:");
        for (double d : data) System.out.print(d + "  ");
        System.out.println();

        bucketSort(data);

        System.out.println("אחרי המיון:");
        for (double d : data) System.out.print(d + "  ");
        System.out.println();
    }
    
    // מחלקה המייצגת חוליה גנרית - לפי תוכנית הלימודים
    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() { return value; }
        public Node<T> getNext() { return next; }
        public void setValue(T value) { this.value = value; }
        public void setNext(Node<T> next) { this.next = next; }
        public boolean hasNext() { return (this.next != null); }

        @Override
        public String toString() { return "" + this.value; }
    }
}