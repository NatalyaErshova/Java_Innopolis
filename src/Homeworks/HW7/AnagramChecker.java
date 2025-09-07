package Homeworks.HW7;
import java.util.Scanner; // Импорт класса Scanner для чтения ввода
import java.util.Arrays; // Импорт класса Arrays для работы с массивами

/*
С консоли на вход подается две строки s и t. Необходимо вывести true, если одна
строка является валидной анаграммой другой строки, и false – если это не так.
Анаграмма – это слово, или фраза, образованная путем перестановки букв другого
слова или фразы, обычно с использованием всех исходных букв ровно один раз.
Для проверки:
● Бейсбол – бобслей
● Героин – регион
● Клоака – околка
 */
public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для чтения ввода с консоли

        System.out.print("Введите первую строку: ");
        String s = scanner.nextLine(); // Чтение первой строки из консоли

        System.out.print("Введите вторую строку: ");
        String t = scanner.nextLine(); // Чтение второй строки из консоли

        boolean result = isAnagram(s, t); // Вызов метода isAnagram для проверки являются ли строки анаграммами
        System.out.println(result); //выводим результат в консоль

        scanner.close(); // Закрытие Scanner для освобождения ресурсов
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // Если длины строк не равны
            return false; // Возвращаем сразу false
        }

        char[] sArray = s.toCharArray(); // Преобразуем строки в массивы символов
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray); //Сортируем символы
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray); // Сравниваем отсортированные массивы
    }
}