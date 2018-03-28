public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
        cache.toString();
        System.out.println(cache.get(1));

    }
}
