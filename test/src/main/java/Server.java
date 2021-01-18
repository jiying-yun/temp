import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端不断接受客户端请求
 * 按照双方约定的格式(协议)反序列化服务端发来的消息、完成服务端本地接口调用、返回序列化数据
 */
public class Server {

    private static boolean running = true;

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        while(running){
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }

        serverSocket.close();

    }

    private static void process(Socket socket) throws Exception{
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        //按照服务端写入的格式来反序列化数据
        String clazzName = ois.readUTF();
        String methodName = ois.readUTF();
        Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
        Object[] args = (Object[]) ois.readObject();

        //模拟从服务注册表查到到具体的实现服务类
        Class clazz = findService(clazzName);
        Method method = clazz.getMethod(methodName,parameterTypes);
        Object o = method.invoke(clazz.newInstance(),args);

        oos.writeObject(o);
        oos.flush();
    }


    public static Class findService(String clazzName) throws Exception{
        if(IProductService.class.getName().equals(clazzName)) {
            return ProductServiceImpl.class;
        }else if(IUerSerivce.class.getName().equals(clazzName)){
            return UserServiceImpl.class;
        }else{
            throw new Exception("no service found");
        }
    }
}
