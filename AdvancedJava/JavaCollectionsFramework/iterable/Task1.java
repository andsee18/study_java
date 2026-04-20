package JavaCollectionsFramework.iterable;

import java.util.Iterator;

public class Task1 {
    // Задача 1:
    // Создай класс NumberCollection, который будет хранить внутри себя массив целых чисел.
    // Этот класс должен реализовывать интерфейс Iterable<Integer>.
    // Напиши свой собственный итератор (внутренний класс), который будет проходить по всем элементам массива по порядку.
    // В методе main создай экземпляр NumberCollection, наполни его числами и выведи их на экран, используя цикл for-each.
    
    public static void main(String[] args) {
        NumberCollection nc = new NumberCollection(2,7,0,543,66,33,74);
        
        for (Integer num : nc) {
            System.out.println(num);
        }
    }
}

class NumberCollection implements Iterable<Integer> {
    int[] numbers;

    public NumberCollection(int... numbers){
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NumberIterator();
    }

    private class NumberIterator implements Iterator<Integer>{
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < numbers.length;
        }

        @Override
        public Integer next() {
            return numbers[currentIndex++];
        }
    }
}
