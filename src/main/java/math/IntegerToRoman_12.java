package math;

public class IntegerToRoman_12 {
    public static void main(String[] args) {
        String s = new IntegerToRoman_12().intToRoman(3749);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        String s = "" + num;
        String rs = "";
        int mod = 5;
        for (int i = s.length() - 1; i >= 0; i--) {
            String w = String.valueOf(s.charAt(i));
            rs = parse(Integer.parseInt(w), mod) + rs;
            mod = mod * 10;
        }
        return rs;
    }

    /**
     * I	1
     * V	5
     * X	10
     * L	50
     * C	100
     * D	500
     * M	1000
     */
    String parse(int val, int mod) {
        if (mod < 11) {
            switch (val) {
                case 1:
                    return "I";
                case 2:
                    return "II";
                case 3:
                    return "III";
                case 4:
                    return "IV";
                case 5:
                    return "V";
                case 6:
                    return "VI";
                case 7:
                    return "VII";
                case 8:
                    return "VIII";
                case 9:
                    return "IX";
            }
        } else if (mod < 111) {
            switch (val) {
                case 1:
                    return "X";
                case 2:
                    return "XX";
                case 3:
                    return "XXX";
                case 4:
                    return "XL";
                case 5:
                    return "L";
                case 6:
                    return "LX";
                case 7:
                    return "LXX";
                case 8:
                    return "LXXX";
                case 9:
                    return "XC";
            }
        } else if (mod < 1111) {
            switch (val) {
                case 1:
                    return "C";
                case 2:
                    return "CC";
                case 3:
                    return "CCC";
                case 4:
                    return "CD";
                case 5:
                    return "D";
                case 6:
                    return "DC";
                case 7:
                    return "DCC";
                case 8:
                    return "DCCC";
                case 9:
                    return "CM";
            }
        } else {
            switch (val) {
                case 1:
                    return "M";
                case 2:
                    return "MM";
                case 3:
                    return "MMM";
            }
        }
        return "";

    }

}
