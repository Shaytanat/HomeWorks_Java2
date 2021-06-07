package DZ_03;

import java.util.Arrays;

public class Main {
    public static void inversionArray(Object[] array, int i, int j) {
        Object bufer = array[i];
        array[i] = array[j];
        array[j] = bufer;
    }

    public static void main(String[] args) throws Exception {
         String [] array = {"y", "r", "r", "a", "a"};
        System.out.println(Arrays.toString(array));
         inversionArray(array, 4, 0);
        System.out.println(Arrays.toString(array));

        Box<Apple> appleBox = new Box<>();
        for (int i=0; i<3; i++) {
            appleBox.addFruit(new Apple());
        }

        Box<Apple> appleBox2 = new Box<>();
        for (int i=0; i<3; i++) {
            appleBox2.addFruit(new Apple());
        }

        System.out.println(appleBox.compare(appleBox2));

        appleBox.sorteredBox(appleBox2);
        System.out.println("1-я коробка весит = " + appleBox.weightBox());
        System.out.println("2-я коробка весит = " + appleBox2.weightBox());

    }



}
