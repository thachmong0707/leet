import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {

    public String convertV(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        //init map with s
        Map<Integer, String> maps = new HashMap<>();
        int cursor = 1;
        boolean increase = true;
        for(int i = 0; i< s.length(); i++){
            String si = maps.getOrDefault(cursor, "");
            si += s.charAt(i);
            maps.put(cursor, si);
            if(increase){
                cursor++;
            } else {
                cursor--;
            }
            if(cursor == numRows || cursor == 1){
                increase = !increase;
            }
        }
        String rs = "";
        for(int i = 1; i<= numRows; i++){
            if(!maps.containsKey(i)){
                continue;
            }
            rs += maps.get(i);
        }
        return rs;
    }
}
