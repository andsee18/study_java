package JavaForBegginers.day13;

import java.util.Date;

public class Message {
    User sender;
    User receiver;
    String text;
    Date date;
    public Message(User sender,User receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = new Date();
    }
    public Date getDate() {
        return date;
    }
    public String getText() {
        return text;
    }
    public User getReceiver() {
        return receiver;
    }
    public User getSender(){
        return sender;
    }
    public String toString(){
        return "FROM: "+ sender+ "\n" +
                "TO: "+ receiver+ "\n"+
                "ON: "+ date+ "\n" +
                text;
    }
}
