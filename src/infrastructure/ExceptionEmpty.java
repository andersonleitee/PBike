package infrastructure;

public class ExceptionEmpty extends Exception{
    private int id;

    public ExceptionEmpty(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExceptionEmpty{" +
                "id=" + id +
                '}';
    }
}
