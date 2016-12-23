package Proxy.Proxy1;

public class ProxyDemo {
    public static void consumer(SomeInterface someInterface){
        someInterface.doSomething();
        someInterface.somethingElse("Bonobo");
    }

    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
