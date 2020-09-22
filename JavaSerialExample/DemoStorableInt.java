import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DemoStorableInt {

    public static void main(String[] args) throws Exception {
        try {
            StorableInt s1 = new StorableInt(100);
            FileOutputStream fos = new FileOutputStream("./s1");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        try {
            StorableInt s2;
            FileInputStream fis = new FileInputStream("./s1");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (StorableInt) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
