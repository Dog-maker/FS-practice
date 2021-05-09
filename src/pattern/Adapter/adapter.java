package pattern.Adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * 适配器模式
 */
public class adapter {

    //我是被适配的，

    public void doSomething(){
        System.out.println("i do");
    }
}

interface person{
    public void doSomething();
}


