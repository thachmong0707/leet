package array;

public class SimpleArrayRotationGame {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] r = {1, 2, 3, 4};
        int[] expected = {1, 0, 2, 1};

        int[] rs = new SimpleArrayRotationGame().run(a, r);
        for (int i = 0; i < rs.length; i++) {
            if (rs[i] != expected[i]) {
                System.out.println("WRONG ANSWER " + expected[i] + " - " + "actual " + rs[i]);
            } else {
                System.out.println("TRUE IND");
            }
        }
    }

    public int[] run(int[] a, int[] rotate) {
        int length = a.length;
        int maxIdx = maxIndex(a);

        int[] indices = new int[rotate.length];
        for (int i = 0; i < rotate.length; i++) {
            //rotate a
            int rotateTimes = rotate[i] % length;
            int maximalIndex = getMaxIndexAfterRotate(rotateTimes, maxIdx, length);
            indices[i] = maximalIndex;
        }
        return indices;
    }

    private int getMaxIndexAfterRotate(int rotateTimes, int maxIdx, int length) {
        if (rotateTimes <= maxIdx) {
            return maxIdx - rotateTimes;
        }
        return length - (rotateTimes - maxIdx);
    }


    public int maxIndex(int[] a) {
        int maxValue = a[0];
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxValue) {
                maxValue = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
