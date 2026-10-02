package b02_oop;

/**
 * Задача 2. Корзина интернет-магазина
 * <p>
 * Спроектируй корзину, которая умеет добавлять товары, считать общую стоимость
 * и применять скидку. На этом этапе используй обычный массив товаров или
 * фиксированный лимит элементов; коллекции пока не используй.
 * <p>
 * Создай класс Product:
 * - private String name;
 * - private double price;
 * - private int quantity;
 * - конструктор принимает все три значения;
 * - имя не может быть пустым;
 * - цена должна быть больше нуля;
 * - количество не может быть меньше нуля;
 * - для каждого поля сделай необходимые геттеры;
 * - сеттеры допускаются только там, где ты можешь сохранить проверки
 * (нельзя разрешать отрицательную цену или количество).
 * <p>
 * Создай класс ShoppingCart:
 * - товары должны храниться внутри корзины;
 * - вместимость корзины — 5 товаров;
 * - добавление товара выполняется методом addProduct(Product product);
 * - null и добавление при заполненной корзине должны отклоняться;
 * - метод должен возвращать boolean: успешность добавления;
 * - getTotalPrice() возвращает сумму price * quantity всех товаров;
 * - applyDiscount(double percent) применяет скидку от 0 до 100 процентов;
 * - недопустимый процент скидки не должен менять корзину;
 * - printReceipt() выводит товары, их количество, стоимость каждой позиции
 * и итоговую стоимость.
 * <p>
 * Не делай поля Product и ShoppingCart public. Внешний код должен работать
 * с объектами только через конструкторы, геттеры и методы.
 * <p>
 * Сценарий в Main:
 * 1. Создай товары "Keyboard" за 3000 рублей в количестве 1,
 * "Mouse" за 1500 рублей в количестве 2 и "USB cable" за 500 рублей
 * в количестве 3.
 * 2. Создай корзину и добавь в нее все товары.
 * 3. Выведи общую стоимость до скидки.
 * 4. Примени скидку 10 процентов.
 * 5. Выведи чек.
 * 6. Попробуй добавить null и применить скидку 150 процентов.
 * <p>
 * Ожидаемое поведение:
 * - добавление трех товаров успешно;
 * - сумма до скидки равна 7500 рублей;
 * - сумма после скидки равна 6750 рублей;
 * - null и скидка 150 процентов отклоняются без поломки корзины.
 */
public class Task02ShoppingCart {
    public static void main(String[] args) {
        Product product1 = new Product("Keyboard", 3000, 1);
        Product product2 = new Product("Mouse", 1500, 2);
        Product product3 = new Product("USB cable", 500, 3);
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println(shoppingCart.addProduct(product1));
        System.out.println(shoppingCart.addProduct(product2));
        System.out.println(shoppingCart.addProduct(product3));
        System.out.println(shoppingCart.getTotalPrice());
        shoppingCart.applyDiscount(10);
        shoppingCart.printReceipt();
        System.out.println(shoppingCart.addProduct(null));
        shoppingCart.applyDiscount(150);


    }
}

class ShoppingCart {
    private Product[] basket = new Product[5];
    private double discount = 0;

    public boolean addProduct(Product product) {
        if (product == null)
            return false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return true;
            }
        }
        return false;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Product i : basket) {
            if (i != null) {
                sum += i.getPrice() * i.getQuantity();
            }
        }
        if (discount != 0) {
            return sum - (sum * discount);
        }
        return sum;
    }


    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Неверное значение");
            return;
        }
        discount = percent / 100;
    }

    public void printReceipt() {
        for (int i = 0; i < basket.length; i++) {
            Product product = basket[i];
            if (basket[i] != null) {
                System.out.print(product.getName() + " ");
                System.out.print(product.getQuantity() * product.getPrice() + " ");
            }
        }
        System.out.println("Итоговая сумма = " + getTotalPrice());
    }

}


class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть Empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть > 0");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Кол-во не может быть < 0");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("цена неверна");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("кол-во неверно");
        }
        this.quantity = quantity;
    }

}
