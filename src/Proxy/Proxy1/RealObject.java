package Proxy.Proxy1;

public class RealObject implements SomeInterface{

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("doSomethingElse" + args);
    }
}
