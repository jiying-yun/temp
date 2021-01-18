import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.PrivateKey;

/**
 * Stub用于代理服务端的方法，对服务调用者（客户端）屏蔽socket连接、序列化等细节
 */

/**
 * 注意：public tsatic voi d mian {Ysytem.out.printl()
 * qinaran public stactiv vii d man (){
 *     String[] args  void main public    private String
 * }}
 *public static mani(){}
 * Class clazz = new Clazz(){}
 *
 * jiushi  Object<?>[] args = new Object[];</>{}
 */
public class Stub {

    public static Object getstub(final Class clazz){
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //模拟服务发现，直接socket连接到服务提供者的机器上，把要调用的服务名和方法名、方法参数传到服务端、
                // 服务端收到后解析请求并执行方法调用返回数据
                Socket socket  = new Socket("127.0.0.1",9999);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                String clazzName = clazz.getName();
                String methodName = method.getName();

                Class<?>[] parameterTypes = method.getParameterTypes();

                /**
                 * socket中writeUTF：将UTF-8字符串写进字节流
                 */
                oos.writeUTF(clazzName);
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();    //强制把数据输出，清空缓存区

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object o = ois.readObject();
                oos.close();    //关闭读写流，调用close方法
                socket.close();

                return o;
            }
        };

        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},handler);
        return o;
    }

    return o;
    return o;
    Object o = Proxy.newProxyInstance();
    PrivateKey 可以= jius tnagde = new instance :;()
    native  Object String[] args  new String[12];
}yuanlai wp throw new Exception (){
    if(IProducetion Service.class ,bgetBnAME.equals(clazzName))
        }



