package Homeworks.HW4;

import java.util.Scanner;

class Телевизор {
    private String марка;
    private int размер; // размер в дюймах
    private boolean смарт;

    public Телевизор(String марка, int размер, boolean смарт) {
        this.марка = марка;
        this.размер = размер;
        this.смарт = смарт;
    }

    public String getМарка() {
        return марка;
    }

    public int getРазмер() {
        return размер;
    }

    public boolean isСмарт() {
        return смарт;
    }

    public void показатьИнформацию() {
        System.out.println("Марка: " + марка);
        System.out.println("Размер: " + размер + " дюймов");
        System.out.println("Смарт: " + (смарт ? "Да" : "Нет"));
        System.out.println("-----------------------------");
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Создание телевизора 1:");
        System.out.print("Введите марку: ");
        String марка1 = scanner.nextLine();
        System.out.print("Введите размер (дюймы): ");
        int размер1 = scanner.nextInt();
        System.out.print("Это смарт телевизор? (да/нет): ");
        boolean смарт1 = scanner.next().equalsIgnoreCase("да");
        scanner.nextLine(); // очищаем буфер

        Телевизор телевизор1 = new Телевизор(марка1, размер1, смарт1);

        System.out.println("Создание телевизора 2:");
        System.out.print("Введите марку: ");
        String марка2 = scanner.nextLine();
        System.out.print("Введите размер (дюймы): ");
        int размер2 = scanner.nextInt();
        System.out.print("Это смарт телевизор? (да/нет): ");
        boolean смарт2 = scanner.next().equalsIgnoreCase("да");
        scanner.nextLine(); // очищаем буфер

        Телевизор телевизор2 = new Телевизор(марка2, размер2, смарт2);

        System.out.println("\nИнформация о телевизорах:");
        телевизор1.показатьИнформацию();
        телевизор2.показатьИнформацию();

        scanner.close();
    }
}