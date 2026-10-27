package lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування MyArrayList ===");

        MyList<Number> numberList = new MyArrayList<>();
        numberList.add(10);
        numberList.add(20.5f);

        List<Integer> intList = new ArrayList<>();
        intList.add(100);
        intList.add(200);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);

        // Демонстрація роботи wildcard:
        numberList.addAll(intList);
        numberList.addAll(doubleList);

        System.out.print("Елементи numberList: ");
        for (int i = 0; i < numberList.size(); i++) {
            System.out.print(numberList.get(i) + " ");
        }
        System.out.println("\nРозмір списку: " + numberList.size());
    }
}