package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> items;

    @SafeVarargs
    Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }


    public void addFruit(T... items) {
        this.items.addAll(Arrays.asList(items));
    }


    public void removeFruit(T... items) {
        for (T item: items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    private void clear() {
        items.clear();
    }

    private float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item: items) weight += item.getWeight();
        return weight;
    }

    boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    void transfer(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }
}
