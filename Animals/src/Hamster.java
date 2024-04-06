import java.util.Date;
import java.util.zip.DataFormatException;

public class Hamster extends Pets {

    protected Hamster(String name, Date birthday, String owner) throws DataFormatException {
        super(name, birthday, owner);
    }

    protected Hamster(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Hamster(String name) throws DataFormatException {
        super(name);
    }


    @Override
    public String toString() {
        return super.toString() + " - хомяк";
    }
}