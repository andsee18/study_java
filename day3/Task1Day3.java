package day3;
import java.util.Scanner;
public class Task1Day3 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String string = scanner.nextLine();
            if ("Stop".equals(string)){
                System.out.println("выход из программы");
                break;
            } else switch (string) {
                case "Москва":
                case "Владивосток":
                case "Ростов":
                    System.out.println("Россия");
                    break;
                case "Рим":
                case "Милан":
                case "Турин":
                    System.out.println("Италия");
                    break;
                case "Ливерпуль":
                case "Манчестер":
                case "Лондон":
                    System.out.println("Англия");
                    break;
                case "Берлин":
                case "Мюнхен":
                case "Кёльн":
                    System.out.println("Германия");
                    break;
                default:
                    System.out.println("Неизвестная страна");

            }
        }
    }
}
