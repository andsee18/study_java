package JavaCollectionsFramework.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Задание 3 (Очередь - Сложное):
 * Задача: Очередь пациентов в больницу.
 * В больнице скорой помощи есть очередь пациентов, к каждому пациенту
 * назначен класс Patient со свойствами:
 * - String name (Имя)
 * - int severity (Тяжесть травмы / состояния, от 1 до 5), где 5 - самое критическое
 * <p>
 * Реализуйте приоритетную очередь, чтобы пациенты с большей тяжестью обслуживались
 * врачом раньше пациентов с меньшей тяжестью, независимо от порядка их поступления.
 */
public class Task3 {
    public static void main(String[] args) {
        Queue<Patient> patients = new PriorityQueue<>();
        patients.offer(new Patient("Георгий", 3));
        patients.offer(new Patient("Дарья", 1));
        patients.offer(new Patient("Олег", 2));
        patients.offer(new Patient("Никита", 2));
        patients.offer(new Patient("Владимир", 5));

        while (!patients.isEmpty()) {
            System.out.println("обслужили пациента :" + patients.poll());
        }


    }
}

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient patient) {
        if (this.getSeverity() < patient.getSeverity()) {
            return 1;
        } else if (this.getSeverity() > patient.getSeverity()) {
            return -1;
        } else {
            return 0;
        }

    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", severity=" + severity +
                '}';
    }
}
