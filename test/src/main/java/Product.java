import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;


    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Procuct{"+
                "id = " + id +
                ", name = " + name +'\''+
               '}';
    }
}
