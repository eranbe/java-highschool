package eranbe.bagrut.q899371.a2026.q2;

public class Speed {
    public static int getStatus(int speed, int min, int max) {
        if (speed >= max + 10) {
            return 1;
        }
        if (speed <= min - 10) {
            return -1;
        }
        return 0;
    }

    public static int[] getAllStatus(int[] speeds, int min, int max) {
        int[] result = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            result[i] = getStatus(speeds[i], min, max);
        }
        return result;
    }

    public static boolean mostFined(int[] speeds, int min, int max) {
        int[] statuses = getAllStatus(speeds, min, max);
        int count = 0;
        for (int i = 0; i < statuses.length; i++) {
            if (statuses[i] != 0) {
                count++;
            }
        }
        return count * 2 > speeds.length;
    }

}
