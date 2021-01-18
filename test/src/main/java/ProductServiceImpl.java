

//具体的服务实现类
public class ProductServiceImpl implements IProductService {


    public Product findProductById(Integer id){
        return new Product(id, "productA");
    }
}
