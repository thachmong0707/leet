package hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfAtoms_726 {

    public static void main(String[] args) {
        String formula = "Mg(H2O)N";
        NumberOfAtoms_726 inst = new NumberOfAtoms_726();
        String s = inst.countOfAtoms(formula);

        System.out.println(s);
    }

    private Map<String, Integer> counts = new HashMap<>();

    public String countOfAtoms(String formula) {
        put(formula, 1);
        if (counts.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        counts.keySet().stream().sorted().forEach(k -> {
            sb.append(k).append(counts.get(k) == 1 ? "" : counts.get(k));
        });
        return sb.toString();
    }


    private void put(String item, int div) {
        if (item == null || item.isEmpty()) {
            return;
        }
        if (item.charAt(0) == '(') {
            // tìm dấu ngoặc đóng cho nó
            int open = 1;
            boolean isFindNum = false;
            int cur = 1;
            String num = "";
            while (open > 0 && cur < item.length()) {
                if (isFindNum) {
                    if (item.charAt(cur) < 48 || item.charAt(cur) > 57) {
                        break;
                    } else {
                        num += item.charAt(cur);
                    }
                }
                if (item.charAt(cur) == '(') {
                    open++;
                } else if (item.charAt(cur) == ')') {
                    if (open == 1) {
                        isFindNum = true;
                    } else {
                        open--;
                    }
                }
                cur++;
            }
//            item = item.substring(cur);
            put(item.substring(1, cur - num.length() - 1), div * (num.isEmpty() ? 1 : Integer.parseInt(num)));
            put(item.substring(cur), div);
        } else {
            String next = getNextItem(item);
            String fo = "";
            String count = "";
            int i = 0;
            while (i < next.length()) {
                if (next.charAt(i) == '(') {
                    break;
                }
                if (next.charAt(i) < 48 || next.charAt(i) > 57) {
                    fo += next.charAt(i);
                } else {
                    count += next.charAt(i);
                }
                i++;
            }
            if (count.isEmpty()) {
                count = "1";
            }
            counts.put(fo, counts.getOrDefault(fo, 0) + Integer.parseInt(count) * div);
            item = item.substring(i);
            put(item, div);
        }
    }


    private String getNextItem(String formula) {
        String rs = "";
        if (formula.charAt(0) == '(') {
            int j = formula.length() - 1;
            while (j > 0) {
                if (formula.charAt(j) == ')') {
                    j++;
                    while (j < formula.length()) {
                        if ((formula.charAt(j) > 65 && formula.charAt(j) < 90)) {
                            return formula.substring(0, j);
                        }
                        j++;
                    }
                    return formula.substring(0, j);
                }
                j--;
            }
        } else {
            rs += formula.charAt(0);
            for (int i = 1; i < formula.length(); i++) {
                char w = formula.charAt(i);
                if ((formula.charAt(i) >= 65 && formula.charAt(i) <= 90) || w == '(') {
                    // is Upper Character
                    break;
                }
                rs += w;
            }
        }
        return rs;
    }
}
