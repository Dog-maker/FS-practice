package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerLog {
    private static Map<String,Class> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        map.put("RPC.logService",logServiceImpl.class);
        ServerSocket socket = new ServerSocket(9090);
        System.out.println("服务器启动,端口:"+socket.getLocalPort());
        while (true){
            Socket accept = socket.accept();
            ObjectInputStream OIS = new ObjectInputStream(accept.getInputStream());
            ObjectOutputStream OOS = new ObjectOutputStream(accept.getOutputStream());
            //接口名
            String Interfacename = OIS.readUTF();
            //方法名
            String MethodName = OIS.readUTF();
            //方法参数
            Object[] arg = (Object[]) OIS.readObject();
            //参数类型
            Class[] TypeParameters = (Class[]) OIS.readObject();



            System.out.println("方法名:"+MethodName);

            System.out.println("方法参数:"+arg);

            for (Class x:TypeParameters){
                System.out.println("参数类型:"+x.getName());
            }

            Class cla = map.get(Interfacename);
            Method declaredMethod = cla.getDeclaredMethod(MethodName, TypeParameters);
            Object invoke = declaredMethod.invoke(cla.newInstance(), arg);
            OOS.writeObject(invoke);
        }
    }

}
