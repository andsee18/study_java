package JavaCollectionsFramework.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2 {
    // Задача 2:
    // Создай обобщенный класс корзины покупок ShoppingCart<T>, реализующий интерфейс Iterable<T>.
    // Внутри корзины элементы можно хранить в любом удобном виде (массив, список и т.д.).
    // Добавь метод для помещения новых элементов в корзину.
    // Реализуй итератор, который не только умеет проходить по элементам (hasNext, next), 
    // но и корректно поддерживает метод remove(), удаляя текущий элемент из твоей коллекции.
    // В методе main добавь несколько товаров в корзину, пройдись по ним итератором и удали определенные товары с помощью iterator.remove().
    // Выведи содержимое корзины до и после удаления, чтобы убедиться в правильности работы.

    public static void main(String[] args) {
        ShoppingCart<String> cart = new ShoppingCart<>();
        cart.addItem("Хлеб");
        cart.addItem("Молоко");
        cart.addItem("Яблоки");
        cart.addItem("Мясо");

        System.out.println("Корзина до удаления:");
        for (String item : cart) {
            System.out.println(item);
        }

        Iterator<String> iterator = cart.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Молоко") || item.equals("Яблоки")) {
                iterator.remove();
            }
        }

        System.out.println("\nКорзина после удаления:");
        for (String item : cart) {
            System.out.println(item);
        }
    }
}

class ShoppingCart<T> implements Iterable<T> {
    private List<T> items;

    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    public void addItem(T item){
        items.add(item);
    }
    
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    
    public class MyIterator implements Iterator<T> {
        private int currentIndex = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public T next() {
            canRemove = true;
            return items.get(currentIndex++);
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Метод remove() можно вызывать только после next()");
            }
            items.remove(--currentIndex);
            canRemove = false;
        }
    }
}
