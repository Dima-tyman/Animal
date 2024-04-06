import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.DataFormatException;


public abstract class Animal{
    private final static long MILISEC_IN_YEAR = 365L * 24 * 60 * 60 * 1000;

    private final String name;
    private final Date birthday;
    private final ArrayList<Commands> commands = new ArrayList<>();


    protected Animal(String name, Date birthday) throws DataFormatException {
        if (name == null) throw new NullPointerException();
        this.name = name;

        Date dateNow = new Date();
        if (birthday == null) birthday = dateNow;
        if (birthday.after(new Date())) throw new DataFormatException();
        this.birthday = birthday;
    }

    protected Animal(String name) throws DataFormatException {
        this(name, null);
    }


    protected void learnCommand(Commands[] commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    public int getAgeYear() {
        Date dateNow = new Date();
        return (int)((dateNow.getTime() - birthday.getTime()) / MILISEC_IN_YEAR);
    }


    public Date getBirthday() {
        return birthday;
    }

    protected ArrayList<Commands> getCommands() {
        return commands;
    }


    @Override
    public String toString() {
        return name + " (" + getAgeYear() + " year)";
    }
}