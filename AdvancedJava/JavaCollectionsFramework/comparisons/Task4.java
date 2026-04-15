package JavaCollectionsFramework.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Задание 4 (Самое сложное - Многоуровневая сортировка):
 * У вас есть класс `Player` с полями: `nickname` (String) и `rating` (int).
 * 1. Напишите компаратор (отдельный класс или анонимный), который
 * сортирует игроков по рейтингу (рейтинг по убыванию - самые скилловые идут первыми).
 * 2. НО, если рейтинг у двух игроков одинаковый, компаратор должен дополнительно
 * сортировать их по никнейму (в алфавитном порядке от А до Я).
 * 3. Создайте 4 игроков в списке, при этом двое из них должны иметь одинаковый рейтинг,
 * но разные ники (например, "Zebra" - 2000, "Alpha" - 2000).
 * 4. Отсортируйте список и выведите. Вы должны увидеть "Alpha" перед "Zebra", несмотря на 2000 рейтинга.
 * <p>
 * Подсказка: логику можно прописать в одном методе `compare()` через if-else,
 * либо использовать современные возможности Java 8 `Comparator.comparing(...).thenComparing(...)`.
 */
public class Task4 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Slon", 3000));
        players.add(new Player("ASDFGWE", 10000));
        players.add(new Player("ScaryFrog", 14662));
        players.add(new Player("Familiar200", 2847));
        players.add(new Player("TreeshKa_22", 9947));
        players.add(new Player("aWWWW", 9947));

        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                int res = Integer.compare(o2.getRating(), o1.getRating());
                if (res != 0) {
                    return res;
                }
                return o1.getNickname().compareTo(o2.getNickname());
            }
        });
        System.out.println(players);
    }
}

class Player {
    private String nickname;
    private int rating;

    public int getRating() {
        return rating;
    }

    public String getNickname() {
        return nickname;
    }

    Player(String nickname, int rating) {
        this.nickname = nickname;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "nickname= " + nickname + '\'' +
                ", rating= " + rating;
    }
}

