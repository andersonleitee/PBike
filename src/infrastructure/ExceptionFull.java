package infrastructure;

public class ExceptionFull extends Exception{
    private int id;

    public ExceptionFull(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExceptionFull{" +
                "id=" + id +
                '}';
    }
}
