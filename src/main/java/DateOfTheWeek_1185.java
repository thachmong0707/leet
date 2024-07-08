public class DateOfTheWeek_1185 {

    public static void main(String[] args) {
        System.out.println(new DateOfTheWeek_1185().dayOfTheWeek(6, 3, 1995));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        //1/1/1971: Friday
        //Get total days between 1971 and day/month/year
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // sum totalDays with the numbers of days from 1/1/year to day/month/year
        boolean isN = isLeapYear(year);
        for (int i = 1; i <= month; i++) {
            if (i == month) {
                totalDays += day;
            } else {
                totalDays += daysInMonth(i, isN);
            }
        }
        return days[totalDays % 7];
    }

    private int daysInMonth(int month, boolean isN) {
        if (month == 2) {
            return isN ? 29 : 28;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 0;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
