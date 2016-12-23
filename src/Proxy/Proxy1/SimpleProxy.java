package Proxy.Proxy1;

public class SimpleProxy implements SomeInterface{
    private SomeInterface proxied;

    public SimpleProxy(SomeInterface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("DoSomeHack for doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("DoSomeHack for somethingElse");
        proxied.somethingElse(args);
    }
}
