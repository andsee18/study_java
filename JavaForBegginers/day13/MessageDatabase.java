package JavaForBegginers.day13;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    public static List<Message> messages = new ArrayList<>();

    public static void addNewMessage(User u1, User u2, String text){
        Message mess = new Message(u1,u2,text);
        messages.add(mess);
    }

    public static List<Message> getMessages() {
        return messages;
    }
    public static void showDialog(User u1,User u2){
        for (Message dialog: messages){
            if ((dialog.getSender().equals(u1)&&dialog.getReceiver().equals(u2))||
                    (dialog.getSender().equals(u2)&&dialog.getReceiver().equals(u1))){
                System.out.println(dialog.getSender().getUsername() + " : " + dialog.getText());
            }
        }
    }
}
