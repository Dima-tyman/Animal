import java.io.Closeable;
import java.io.IOException;

public class Counter implements Closeable {

    private Integer count;

    public Counter() {
        this.count = 0;
    }

    public void add() throws IOException {
        isClose();
        this.count++;
    }

    public void remove() throws IOException {
        isClose();
        this.count--;
    }

    private void isClose() throws IOException {
        if (this.count == null) throw new IOException();
    }

    public Integer getCount() {
        return this.count;
    }

    @Override
    public void close() throws IOException {
        this.count = null;
    }
}
