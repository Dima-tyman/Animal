import java.util.Date;
import java.util.zip.DataFormatException;

public class Cats extends Pets {

    protected Cats(String name, Date birthday, String owner) throws DataFormatException {
        super(name, birthday, owner);
    }

    protected Cats(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Cats(String name) throws DataFormatException {
        super(name);
    }
}