package Homeworks.HW1;

import java.util.Scanner; // Импортируем класс Scanner из пакета java.util

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для чтения ввода с консоли
        System.out.print("Введите Ваше имя: "); // Выводим сообщение для пользователя
        String name = scanner.nextLine(); // Читаем строку, введенную пользователем, и сохраняем ее имя в переменной name

        System.out.println("Привет, "+ name + "!"); // Выводим сообщение с новой строки, объединяя текст
        scanner.close(); // Закрываем объект Scanner, когда он больше не нужен
    }
}
