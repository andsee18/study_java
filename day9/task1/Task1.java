package day9.task1;

public class Task1 {
    public static void main(String[] args){
        Student student = new Student("Олег", "БПИ2305");
        Teacher teacher = new Teacher("Владислав", "Биология");
        student.getGroup();
        teacher.getSubjectName();
        student.printInfo();
        teacher.printInfo();
    }
}
