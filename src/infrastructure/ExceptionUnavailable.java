package infrastructure;

public class ExceptionUnavailable extends Exception{
        private int id;

    public ExceptionPassNumber(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExceptionUnavailable{" +
                "id=" + id +
                '}';
    }
}
