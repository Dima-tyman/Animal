import java.util.Date;
import java.util.zip.DataFormatException;

public class Horse extends Pack {

    protected Horse(String name, Date birthday, Integer maxWeight) throws DataFormatException {
        super(name, birthday, maxWeight);
    }

    protected Horse(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Horse(String name) throws DataFormatException {
        super(name);
    }
}
