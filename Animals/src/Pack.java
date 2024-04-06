import java.util.Date;
import java.util.zip.DataFormatException;

public abstract class Pack extends Animal {
    private Integer maxWeight;


    protected Pack(String name, Date birthday, Integer maxWeight) throws DataFormatException {
        super(name, birthday);
        this.maxWeight = maxWeight;
    }

    protected Pack(String name, Date birthday) throws DataFormatException {
        this(name, birthday, null);
    }

    protected Pack(String name) throws DataFormatException {
        this(name, null);
    }


    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }
}
