package JavaCollectionsFramework.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Задание 2 (Среднее - Comparable):
 * 1. Создайте в этом файле класс `Book` (Книга) с двумя полями: `title` (Лев Толстой, Пушкин и тд) и `year` (год издания).
 * 2. Сделайте класс `Book` реализующим интерфейс `Comparable<Book>`.
 * 3. Переопределите метод `compareTo(Book o)`: естественная (основная) сортировка книг 
 *    должна быть по году издания (по возрастанию: от самых старых к самым новым).
 * 4. В main добавьте в список несколько книг и отсортируйте через `Collections.sort(books)`. 
 *    Компаратор туда передавать не надо, так как класс сам стал Comparable!
 */
public class Task2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Первая книга",2003));
        books.add(new Book("Вторая книга",2022));
        books.add(new Book("Третья книга",1999));
        books.add(new Book("Четвёртая книга",1967));
        books.add(new Book("Пятая книга",2007));

        Collections.sort(books);
        System.out.println(books);

        
    }
}

class Book implements Comparable<Book>{
    private String title;
    private int year;
    public Book(String title,int year){
        this.title = title;
        this.year= year;

    }

    @Override
    public int compareTo(Book o) {
        if (this.getYear()>o.getYear()){
            return 1;
        } else if (this.getYear()<o.getYear()){
            return -1;
        } else {
            return 0;
        }
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

