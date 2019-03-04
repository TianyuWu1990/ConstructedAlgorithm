import java.util.*;

class PlayGround {
    public void test() {


        TreeMap<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        map.put("a", 1);
        map.remove("a");
    }
}
