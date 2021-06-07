public class MyArrayDataException extends Throwable {

    public MyArrayDataException (int i, int j) {
        super("Элемент [" + i + "," + j + "] в массиве не является числом и не может быть суммирован");
    }

}
