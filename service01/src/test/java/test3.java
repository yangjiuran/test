/**
 * @author yangjiuran
 * @Date 2020/3/25
 */
public class test3 {
    public static void main(String[] args) {
        String s1="a";
        String s2="b";
        String s4=s1+s2;
        String intern = s4.intern();
        String s3="ab";
        String s5="a"+"b";
        System.out.println(s4==s3);
        System.out.println(s3==intern);
        System.out.println(s4==intern);
        System.out.println(s5==s3);
    }
}
