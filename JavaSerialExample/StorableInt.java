import java.io.*;
public class StorableInt implements Serializable {
    public int value;


    public StorableInt(int value){

      this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

