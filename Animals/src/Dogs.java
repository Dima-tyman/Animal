import java.util.Date;
import java.util.zip.DataFormatException;

public class Dogs extends Pets {

    protected Dogs(String name, Date birthday, String owner) throws DataFormatException {
        super(name, birthday, owner);
    }

    protected Dogs(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Dogs(String name) throws DataFormatException {
        super(name);
    }


    @Override
    public String toString() {
        return super.toString() + " - собака";
    }
}