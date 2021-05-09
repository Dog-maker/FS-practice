package RPC;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class logHandler implements InvocationHandler{

    private String SeviceNmae;

    logHandler(String name){
        this.SeviceNmae = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Socket socket = new Socket("127.0.0.1",9090);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        //接口名
        objectOutputStream.writeUTF(SeviceNmae);
        //方法名
        objectOutputStream.writeUTF(method.getName());
        //方法参数
        objectOutputStream.writeObject(args);
        //参数类型
        objectOutputStream.writeObject(method.getParameterTypes());

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object o = objectInputStream.readObject();
        return o;
    }
}
