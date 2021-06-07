public class MyArraySizeException extends Exception {
    public MyArraySizeException(int i) {
       super("Длина строки - " + i + " не равна 4");
    }
}
