package Homeworks.HW3;

import java.util.Random;

public class Ex2 {

    public static void main(String[] args) {
        Random random = new Random();

        // Генерация случайного выбора для Васи и Пети
        int vasyaChoice = random.nextInt(3); // 0 - Камень, 1 - Ножницы, 2 - Бумага
        int petyaChoice = random.nextInt(3); // 0 - Камень, 1 - Ножницы, 2 - Бумага

        System.out.println("Вася выбрал: " + getChoiceName(vasyaChoice));
        System.out.println("Петя выбрал: " + getChoiceName(petyaChoice));

        // Определение победителя
        String result = determineWinner(vasyaChoice, petyaChoice);
        System.out.println(result);
    }

    private static String getChoiceName(int choice) {
        switch (choice) {
            case 0:
                return "Камень";
            case 1:
                return "Ножницы";
            case 2:
                return "Бумага";
            default:
                return "Неверный выбор";
        }
    }

    private static String determineWinner(int vasyaChoice, int petyaChoice) {
        if (vasyaChoice == petyaChoice) {
            return "Ничья!";
        } else if ((vasyaChoice == 0 && petyaChoice == 1) || // Камень ломает Ножницы
                (vasyaChoice == 1 && petyaChoice == 2) || // Ножницы режут Бумагу
                (vasyaChoice == 2 && petyaChoice == 0)) { // Бумага закрывает Камень
            return "Вася выиграл!";
        } else {
            return "Петя выиграл!";
        }
    }
}
