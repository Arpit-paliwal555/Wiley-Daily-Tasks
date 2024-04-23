import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class Product implements Serializable {
    private int product_id;
    private String product_name;
    private String mfg_data;

    public Product(int product_id, String product_name, String mfg_data) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.mfg_data = mfg_data;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", product_id=" + product_id +
                ", mfg_data='" + mfg_data + '\'' +
                '}';
    }
}
