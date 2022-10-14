package infrastructure;

public class ExceptionLength extends Exception{
        private int length;

    public ExceptionLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ExceptionLength{" +
                "length=" + length +
                '}';
    }
}
