package RPC;


import javax.swing.*;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class logController {

    public static void main(String[] args) {
        Object proxy = proxy(logService.class);
//        Method[] declaredMethods = proxy.getClass().getDeclaredMethods();
//        for (Method method : declaredMethods)
//            System.out.println(method.getName());
        logService logService = (logService) proxy;
        System.out.println(logService.getLog("aaa"));

    }


    public static Object proxy(Class cla){

        Class[] classes = {cla};
        return Proxy.newProxyInstance(cla.getClassLoader(), classes, new logHandler(cla.getName()));
    }


}
