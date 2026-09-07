package repeat.september1;

import jdk.jshell.PersistentSnippet;

import java.util.Objects;

/**
 * ЗАДАЧА 4: Поиск и удаление элементов
 * 
 * УСЛОВИЕ:
 * 1. Создай класс Person с полями name и age
 * 2. Переопредели equals() - сравни по name и age
 * 3. Создай список из 3 человек
 * 4. Проверь contains() с объектом из списка
 * 5. Проверь contains() с новым объектом Person("Боб", 30)
 * 6. Удали человека по значению используя remove(Object)
 * 7. Выведи результаты
 */
public class Task4_SearchOperations {
    public static void main(String[] args) {

        // TODO: напиши код здесь
    }
}
class Person{
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}