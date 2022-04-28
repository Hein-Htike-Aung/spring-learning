package generic;

import java.util.List;

public class MyClass<T, R> {

    private T t;
    private R r;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public <T> void test(T t) {

    }

}
