package JavaForBegginers.day06;

public class Task3Day6 {
    public static void main(String[] args){
        Teacher teacher = new Teacher("Владислав","Биология");
        Student student = new Student("Андрей");
        teacher.evaluate(student);
    }
}

class Teacher {
    private String name;
    private String lesson;

    public Teacher (String name, String lesson){
        this.name = name;
        this.lesson = lesson;
    }
    public void evaluate(Student student) {
        int x = (int) (Math.random()*4)+2;
        String s = String.valueOf(x);
        switch(s){
            case "2":
                s = "неуд";
                break;
            case "3":
                s = "уд";
                break;
            case "4":
                s = "хорошо";
                break;
            case "5":
                s = "отлично";
                break;
            default:
                System.out.println("ошибка");
        }
        System.out.println("преподаватель " + this.name + " оценил студента с именем " + student.getName() + " по предмету "+ this.lesson+ " на оценку "+ s);
    }

}

class Student {
    private String name;
    public Student(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}