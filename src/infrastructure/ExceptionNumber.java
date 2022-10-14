package infrastructure;

public class ExceptionNumber extends Exception{
        private int num;

    public ExceptionNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ExceptionNumber{" +
                "num=" + num +
                '}';
    }
}
