package infrastructure;

public class ExceptionPassNumber extends Exception{
        private int num;

    public ExceptionPassNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ExceptionPassNumber{" +
                "num=" + num +
                '}';
    }
}
