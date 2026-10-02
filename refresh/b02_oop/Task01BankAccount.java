package b02_oop;

/**
 * Задача 1. Банковский счет с лимитами
 * <p>
 * Спроектируй небольшой класс банковского счета. Счет должен защищать данные
 * владельца и не позволять проводить недопустимые операции.
 * <p>
 * Создай класс BankAccount:
 * - все поля должны быть private;
 * - String ownerName — имя владельца;
 * - double balance — текущий баланс;
 * - double dailyWithdrawLimit — максимальная сумма снятия за одну операцию.
 * <p>
 * Требования к конструктору:
 * - принимает имя владельца, начальный баланс и лимит снятия;
 * - пустое имя запрещено;
 * - начальный баланс не может быть отрицательным;
 * - лимит снятия должен быть больше нуля;
 * - при нарушении правила выбрасывай IllegalArgumentException.
 * <p>
 * Методы:
 * - геттер для имени владельца;
 * - геттер для текущего баланса;
 * - геттер и сеттер для лимита снятия;
 * - setter лимита не должен принимать значение меньше или равное нулю;
 * - deposit(double amount) — пополняет счет только на положительную сумму;
 * - withdraw(double amount) — снимает деньги, если сумма положительная,
 * не превышает лимит и не превышает текущий баланс;
 * - для недопустимой операции deposit/withdraw верни false и не меняй баланс;
 * - при успешной операции верни true;
 * - printStatement() — выводит имя владельца и текущий баланс.
 * <p>
 * Сценарий в Main:
 * 1. Создай счет владельца "Ivan" с балансом 1000 и лимитом снятия 600.
 * 2. Выведи исходное состояние счета.
 * 3. Выполни успешное пополнение на 250 и успешное снятие на 500.
 * 4. Попробуй снять 700 и пополнить счет на -50.
 * 5. Выведи результаты операций и итоговое состояние.
 * <p>
 * Ожидаемое поведение:
 * - пополнение на 250 и снятие на 500 успешны;
 * - снятие 700 запрещено из-за лимита;
 * - пополнение -50 запрещено;
 * - итоговый баланс равен 750.
 */
public class Task01BankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Ivan", 1000, 600);
        account1.printStatement();
        System.out.println(account1.deposit(250));
        System.out.println(account1.withdraw(500));
        System.out.println(account1.withdraw(700));
        System.out.println(account1.deposit(-50));
        account1.printStatement();

    }
}

class BankAccount {
    private String ownerName;
    private double balance;
    private double dailyWithdrawLimit;

    public BankAccount(String ownerName, double balance, double dailyWithdrawLimit) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        if (dailyWithdrawLimit <= 0) {
            throw new IllegalArgumentException("Лимит снятия должен быть больше нуля");
        }
        this.ownerName = ownerName;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public void setDailyWithdrawLimit(double dailyWithdrawLimit) {
        if (dailyWithdrawLimit <= 0) {
            throw new IllegalArgumentException("Лимит снятия должен быть больше нуля");
        }
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;

    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= dailyWithdrawLimit && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void printStatement() {
        System.out.println("Имя владельца: " + getOwnerName() + "; Баланс: " + getBalance());
    }
}
