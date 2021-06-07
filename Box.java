package DZ_03;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float weightBox() throws Exception {
       if (fruits.size() == 0) {
           throw new Exception("Коробка пустая");
       }

       return fruits.size() * fruits.get(0).weight;

    }

    public boolean compare(Box<?> box) throws Exception {
        return weightBox() == box.weightBox();
    }

    public void sorteredBox(Box<T> box) {
        fruits.addAll(box.fruits);
        box.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
