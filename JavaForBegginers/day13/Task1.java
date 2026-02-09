package JavaForBegginers.day13;

public class Task1 {
    public static void main(String[] args) {
        User u1 = new User("Andrew");
        User u2 = new User("User");
        User u3 = new User("Who?");
        u1.sendMessage(u2,"Привет лол");
        u1.sendMessage(u2,"Привет лол 2");
        u2.sendMessage(u1,"Привет тоже");
        u2.sendMessage(u1,"Привет как дела");
        u2.sendMessage(u1,"Привет лцауаыва");
        u3.sendMessage(u1,"Привет пользваотель3");
        u3.sendMessage(u1,"как делишки");
        u3.sendMessage(u1,"лол");
        u1.sendMessage(u3,"Привет пользваотель1");
        u1.sendMessage(u3,"Привет все норм");
        u1.sendMessage(u3,"иди ты");
        u3.sendMessage(u1,"я скучаю по тебе");

        MessageDatabase.showDialog(u1,u3);





    }
}
