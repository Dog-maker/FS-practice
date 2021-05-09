package pattern.Proxy;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        person t = new Teacher();
        DynamicProxy dynamicProxy = new DynamicProxy(t);
        person o =(person) Proxy.newProxyInstance(t.getClass().getClassLoader(), new Class[]{person.class}, dynamicProxy);
        o.dosome();


    }
}
