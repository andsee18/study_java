package b02_oop;

import jdk.swing.interop.SwingInterOpUtils;

/**
 * Задача 3. Бронирование билетов на мероприятие
 * <p>
 * Спроектируй систему бронирования мест в небольшом кинозале. Задача должна
 * показать взаимодействие двух объектов: Event и Booking.
 * <p>
 * Создай класс Event:
 * - private String title;
 * - private int totalSeats;
 * - private int availableSeats;
 * - конструктор принимает название и количество мест;
 * - название не может быть пустым;
 * - количество мест должно быть больше нуля;
 * - availableSeats в начале равно totalSeats;
 * - добавь геттеры для названия и доступных мест;
 * - метод reserveSeat() уменьшает доступные места на 1 и возвращает true;
 * - если свободных мест нет, reserveSeat() возвращает false;
 * - метод cancelSeat() увеличивает доступные места не выше totalSeats
 * и возвращает результат операции.
 * <p>
 * Создай класс Booking:
 * - private Event event;
 * - private String customerName;
 * - private int seats;
 * - конструктор принимает мероприятие и имя клиента;
 * - null вместо мероприятия и пустое имя запрещены;
 * - seats в начале равно 0;
 * - reserve(int amount) пытается забронировать amount мест через Event;
 * - amount должен быть больше нуля;
 * - если нельзя забронировать все запрошенные места, операция не должна
 * оставлять частичное бронирование;
 * - cancel(int amount) отменяет ранее забронированные места;
 * - нельзя отменить больше мест, чем забронировано;
 * - добавь геттеры для имени клиента и количества его мест;
 * - printBooking() выводит название мероприятия, клиента и число мест.
 * <p>
 * Сценарий в Main:
 * 1. Создай мероприятие "Java Conference" на 3 места.
 * 2. Создай бронирование для клиента "Anna".
 * 3. Забронируй 2 места и выведи подтверждение.
 * 4. Попробуй забронировать еще 2 места.
 * 5. Отмени 1 место и выведи состояние бронирования.
 * 6. Выведи количество доступных мест мероприятия.
 * <p>
 * Ожидаемое поведение:
 * - бронирование 2 мест успешно;
 * - повторный запрос 2 мест отклонен целиком, потому что доступно только 1;
 * - после отмены 1 места у Anna остается 1 место;
 * - доступными снова становятся 2 места.
 */
public class Task03TicketBooking {
    public static void main(String[] args) {
        Event event1 = new Event("Java Conference", 3);
        Booking booking1 = new Booking(event1, "Anna");
        booking1.reserve(2);
        booking1.reserve(2);
        booking1.cancel(1);
        booking1.printBooking();
        System.out.println("свободных мест = " + event1.getAvailableSeats());
    }
}

class Booking {
    private Event event;
    private String customerName;
    private int seats;

    public void printBooking() {
        System.out.println("Название мероприятия: " + event.getTitle());
        System.out.println("Имя клиента: " + customerName);
        System.out.println("Число мест: " + seats);

    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeats() {
        return seats;
    }

    public Booking(Event event, String customerName) {
        if (event == null) {
            throw new IllegalArgumentException("Пустое мероприятие");
        }
        if (customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        }
        this.event = event;
        this.customerName = customerName;
        seats = 0;
    }

    public boolean reserve(int amount) {
        if (amount <= 0) {
            System.out.println("Неверное значение");
            return false;
        }
        while (amount > 0) {
            if (event.reserveSeat()) {
                amount--;
                seats++;
                if (amount > 0 && seats == event.getTotalSeats()) {
                    System.out.println("Недостаточное кол-во свободных мест.");
                    return false;
                }
            }
        }
        System.out.println("Места успешно забронированы!");
        return true;
    }

    public boolean cancel(int amount) {
        if (amount <= 0) {
            System.out.println("Неверное значение");
            return false;
        }
        while (amount > 0) {
            if (event.cancelSeat()) {
                amount--;
                seats--;
                if (amount > 0 && event.getAvailableSeats() == event.getTotalSeats()) {
                    System.out.println("Неверное значение");
                    return false;
                }
            }
        }
        System.out.println("Бронь успешно отменена!");
        return true;
    }

}

class Event {
    private String title;
    private int totalSeats;
    private int availableSeats;

    public int getTotalSeats() {
        return totalSeats;
    }

    public Event(String title, int totalSeats) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (totalSeats == 0) {
            throw new IllegalArgumentException("Кол-во мест должно быть > 0");
        }
        availableSeats = totalSeats;
        this.title = title;
        this.totalSeats = totalSeats;
    }


    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean reserveSeat() {
        if (availableSeats == 0) {
            return false;
        }
        availableSeats--;
        return true;
    }

    public boolean cancelSeat() {
        if (availableSeats == totalSeats) {
            return false;
        }
        availableSeats++;
        return true;
    }

}

