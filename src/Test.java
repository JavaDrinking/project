public class Test {
    public static void main(String[] args) {
        String str1 = new StringBuilder("ja").append("va").toString();
        String str2 = new StringBuilder("我爱").append("编程").toString();
        System.out.println(str1 == str1.intern());
        System.out.println(str2 == str2.intern());

    }
}
