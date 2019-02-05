public class RemoveUniHiden {
    public static String replace(String s) {
        return s.replaceAll("[\\p{Cf}]", "");
    }
}
