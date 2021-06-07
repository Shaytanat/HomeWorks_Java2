import java.util.Arrays;

public class ArrayString {

    public static int sumArray(String[][] strings) throws MyArraySizeException, MyArrayDataException {

        if (strings.length != 4) {
           throw new MyArraySizeException(strings.length);
       }
        int k=-1; //Значение -1 для сохранения правильной индексации массива
       for (String[] array : strings) {
           k++;
           if (array.length != 4) {
               throw new MyArraySizeException(k);
           }
        }
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] strings = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "8", "7", "6", "3"},
                {"5", "4", "3", "2"},
        };
        System.out.println(sumArray(strings));

        //String[][] strings = {
        //        {"1", "2", "3", "4"},
        //        {"5", "6", "7", "8"},
        //        {"9", "8", "7", "6"},
        //        {"5", "df", "3", "2"},
        //};
        //System.out.println(sumArray(strings));

        //String[][] strings = {
        //        {"1", "2", "3", "4"},
        //        {"5", "6", "7", "8"},
        //        {"9", "8", "7", "6"},
        //        {"5", "4", "3", "2"},
        //};
        //System.out.println(sumArray(strings));
    }
}
