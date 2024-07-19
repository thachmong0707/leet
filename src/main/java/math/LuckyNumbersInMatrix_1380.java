package math;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        int i = 0;
        boolean[] has = new boolean[matrix[0].length];
        while (i < matrix.length) {
            int idxMin = 0;
            int valueMin = matrix[i][0];
            int j = 0;
            while (j < matrix[i].length) {
                if (valueMin > matrix[i][j]) {
                    idxMin = j;
                    valueMin = matrix[i][j];
                }
                j++;
            }
            if (has[idxMin]) {
                i++;
                continue;
            }
            int column = 0;
            boolean valueIsMax = true;
            while (column < matrix.length) {
                if (matrix[column][idxMin] > valueMin) {
                    valueIsMax = false;
                    break;
                }
                column++;
            }
            if (valueIsMax) {
                rs.add(valueMin);
                has[idxMin] = true;
            }
            i++;
        }
        return rs;
    }
}
