package JavaCollectionsFramework.hashmap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Задание 4 (Самое сложное - Custom Objects & Hashing): 
 * 1. Создайте внутри этого файла класс User (или Book) с двумя полями: id (целое число) и name (строка). 
 * 2. Создайте пустую коллекцию HashSet<User>.
 * 3. Создайте 3 объекта User, два из которых будут иметь абсолютно одинаковые `id` и `name`.
 * 4. Добавьте все 3 объекта в вашу коллекцию HashSet. Сделайте вывод размера коллекции и убедитесь, 
 *    что дубликат благополучно добавился. Как так вышло? 
 * 5. (Это самое главное): Вернитесь в класс User и переопределите методы equals() и hashCode() так, 
 *    чтобы любые два пользователя с одинаковым ID считались одинаковыми (независимо от имени).
 * 6. Запустите программу еще раз. Сейчас в коллекции должно стать на 1 объект меньше (дубликат не добавился).
 */
public class Task4 {
    public static void main(String[] args) {
        Set<User> hashSet = new HashSet<>();
        User user1 = new User(1,"Олег");
        User user2 = new User(1,"Олег");
        User user3 = new User(3,"Иван");
        hashSet.add(user1);
        hashSet.add(user2);
        hashSet.add(user3);
        System.out.println(hashSet.size());




    }
}

class User{
    private int id;
    private String name;
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

