package infrastructure;

public class ExceptionUnavailable extends Exception{
    private int id;

    public ExceptionUnavailable(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExceptionUnavailable{" +
                "id=" + id +
                '}';
    }
}
