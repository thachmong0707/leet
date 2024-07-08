package math;

public class WaterBottles_1518 {

    public static void main(String[] args) {
        new WaterBottles_1518().numWaterBottles(15, 4);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int rs = numBottles;
        int mod = 0;
        while (numBottles >= numExchange) {
            int bot = numBottles / numExchange;
            rs += bot;
            mod = numBottles % numExchange;
            numBottles = bot + mod;
        }
        return rs;
    }
}
