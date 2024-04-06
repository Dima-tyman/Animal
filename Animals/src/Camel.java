import java.util.Date;
import java.util.zip.DataFormatException;

public class Camel extends Pack {

    protected Camel(String name, Date birthday, Integer maxWeight) throws DataFormatException {
        super(name, birthday, maxWeight);
    }

    protected Camel(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Camel(String name) throws DataFormatException {
        super(name);
    }
}
