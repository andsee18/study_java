package myTasks.serialization.task2;

import java.io.*;

public class Serilization implements Serializable {
    String name;
    int id;
    int age;
    public static final long SerialVersionUID = 1L;

    public Serilization(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void saveArray(Serilization sourceArray[]) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            oos.writeObject(sourceArray);
            System.out.println("массив успешно записан!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Serilization[] loadArray(Serilization array[]) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {
            Serilization[] loaded = (Serilization[]) ois.readObject();
            return loaded;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name  +
                " ID: " + id +
                " Возраст: " + age+"\n";
    }

}
