package day19;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        try (InputStream is = Task1.class.getClassLoader().getResourceAsStream("resources/dushi.txt")) {
            if (is == null) {
                System.out.println("file not found");
            } else {
                Scanner scanner = new Scanner(is);
                scanner.useDelimiter("[.,:;()?!\"\\s–]+");
                Map<String, Integer> countMap = new HashMap<>(); // .constainsKey() - проверка на
                while (scanner.hasNext()) {                       // наличие ключа
                    String word = scanner.next().toLowerCase();  // .constainsValue() - по знач.
                    if (countMap.containsKey(word)) {
                        int value = countMap.get(word);
                        countMap.put(word, value + 1);
                    } else {
                        countMap.put(word, 1);
                    }
                }
                List<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
                // сразу поместили в наш лист все пары ключ значения countMap (entry);
                // указали тип вход данных как Map.Entry<String, Integer>.
                list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
                for (int i = 0; i < 100 && i < list.size(); i++) {
                    Map.Entry<String, Integer> entry = list.get(i);
                    String word = entry.getKey();
                    int value = entry.getValue();
                    System.out.println((i + 1) + ") " + word + " : " + value);
                }
                System.out.println("колво слова чичиков = "+countMap.get("чичиков"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

