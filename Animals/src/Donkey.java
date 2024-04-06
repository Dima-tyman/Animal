import java.util.Date;
import java.util.zip.DataFormatException;

public class Donkey extends Pack {

    protected Donkey(String name, Date birthday, Integer maxWeight) throws DataFormatException {
        super(name, birthday, maxWeight);
    }

    protected Donkey(String name, Date birthday) throws DataFormatException {
        super(name, birthday);
    }

    protected Donkey(String name) throws DataFormatException {
        super(name);
    }


    @Override
    public String toString() {
        return super.toString() + " - осёл";
    }
}
