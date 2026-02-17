package myTasks.serialization.task1;

import java.io.*;

public class DevProgress implements Serializable {
    String taskName;
    int exercisesDone;
    transient String currentNotes;
    public static final long serialVersionUID = 1L;

    public DevProgress(String taskName, int exercisesDone, String currentNotes) {
        this.taskName = taskName;
        this.exercisesDone = exercisesDone;
        this.currentNotes = currentNotes;
    }

    public int getExercisesDone() {
        return exercisesDone;
    }

    public String getCurrentNotes() {
        return currentNotes;
    }

    public String getTaskName() {
        return taskName;
    }

    public void saveProgress() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("progress.bin"))) {
            oos.writeObject(this);
            System.out.println("Запись данных произошла успешно!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DevProgress loadProgress() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("progress.bin"))) {
            DevProgress loaded = (DevProgress) ois.readObject();
            System.out.println("данные успешно извлечены!");
            return loaded;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return "Задача: " + taskName +
                "Номер задачи: "+exercisesDone+
                "Состояние: "+ currentNotes+"\n";
    }

}
