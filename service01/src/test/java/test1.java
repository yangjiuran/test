/**
 * @author yangjiuran
 * @Date 2020/3/22
 */
public class test1 {
    public static void main(String[] args) {
        int i = method1(1, 2);
        System.out.println(i);
    }

    private static int method1(int i, int i1) {
        return method2(i,i1);
    }

    private static int method2(int i, int i1) {
        int c=i+i1;
        return c;
    }

}
