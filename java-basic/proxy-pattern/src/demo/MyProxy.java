package demo;

public class MyProxy implements MyInterface{

    private MyTarget myTarget;

    public MyProxy(MyTarget myTarget) {
        this.myTarget = myTarget;
    }

    @Override
    public void doSomething() {

        doSomethingExtra();

        myTarget.doSomething();
    }

    public void doSomethingExtra() {
        System.out.println("Do Something Extra.");
    }
}
