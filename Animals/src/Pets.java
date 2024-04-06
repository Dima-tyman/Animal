import java.util.Date;
import java.util.zip.DataFormatException;

public abstract class Pets extends Animal {
    private String owner;


    protected Pets(String name, Date birthday, String owner) throws DataFormatException {
        super(name, birthday);
        this.owner = owner;
    }

    protected Pets(String name, Date birthday) throws DataFormatException {
        this(name, birthday, null);
    }

    protected Pets(String name) throws DataFormatException {
        this(name, null);
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
