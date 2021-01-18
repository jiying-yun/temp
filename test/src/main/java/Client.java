/**
 * 客户端代码
 * 服务调用者（RPC客户端）获取服务提供方（RPC服务端）提供的服务
 * 并像调用本地接口一样调用远程方法
 */
public class Client {
    public static void main(String[] args) {

        //客户端指定需要调用的远程服务（客户端可以注入服务提供方的服务）、调用服务的接口方法
        IProductService productService = (IProductService) Stub.getstub(IProductService.class);
        System.out.println(productService.findProductById(1));

        IUerSerivce uerSerivce = (IUerSerivce) Stub.getstub(IUerSerivce.class);
        System.out.println(uerSerivce.findUserById(123));

    }
}
