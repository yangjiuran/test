import java.util.ArrayList;

/**
 * @author yangjiuran
 * @Date 2020/3/23
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Student student = new Student();
            list.add(student);
        }
    }
static class Student{
    private byte[] b=new byte[1024*1024];
}
}
