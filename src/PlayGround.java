import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class PlayGround {
    public static void main(String[] args) {


    HashMap<Integer, Integer> map = new HashMap<>();
    Integer a = map.put(1,200);
    String s = "abc";
    String ss = s.substring(1);
    HashMap<Integer, String> mymap = new HashMap<>();
    mymap.put(1,"Hello");
        mymap.put(2,"World");
        mymap.put(3,"!");
    Set<Map.Entry<Integer, String>> myset = mymap.entrySet();
    for (String temp : mymap.values()) {
        System.out.println(temp);
    }
    for (Map.Entry en : myset) {
        System.out.println(en.getKey() + ": " + en.getValue());
        en.setValue("lalala");
    }
    }
}
