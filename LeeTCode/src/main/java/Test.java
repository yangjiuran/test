/**
 * @author yangjiuran
 * @Date 2020/6/28
 */
public class Test implements ITest {
    private String name;
    private Test2 t2 = new Test2();

    public String method(String name) {
        return null;
    }

    @Override
    public int getName() {
        return 1;
    }
}
