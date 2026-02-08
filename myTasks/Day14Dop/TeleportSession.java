package myTasks.Day14Dop;

public class TeleportSession {
    private int id;
    private String personName;
    private double energy;
    private boolean isComplete;

    public TeleportSession(int id,String personName,double energy){
        this.id = id;
        this.personName = personName;
        this.energy = energy;
        isComplete = false;
    }

    @Override
    public String toString() {
        return "TeleportSession{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", energy=" + energy +
                ", isComplete=" + isComplete +
                '}';
    }
}
