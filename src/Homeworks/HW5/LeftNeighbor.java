package Homeworks.HW5;

import java.util.Scanner;

class LeftNeighbor { //объявляем новый класс
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in); //создаем объект Scanner, который будет считывать ввод с консоли
        System.out.println("Введите маленькую букву английского алфавита");  //Выводим сообщение на экран
        String input=scanner.next(); //считываем ввод пользователя и сохраняем его в строковой переменной input
        char letter= input.charAt(0); // извлекаем первый символ из введённой строки input и сохраняем его в переменной letter типа char

        String keyboardRing="qwertyuiopasdfghjklzxcvbnm"; // объявляем строку keyboardRing, которая содержит все маленькие буквы английского алфавита в порядке, как на клавиатуре
        int index=keyboardRing.indexOf(letter); // находим индекс введённой буквы letter в строке keyboardRing и сохраняем его в переменной index. Если буква не найдена, будет возвращен -1.
        int leftIndex=(index-1+keyboardRing.length()) % keyboardRing.length(); // вычисляем индекс буквы, находящейся слева от введённой буквы. Для этого берётся index текущей буквы, отнимается 1 (перемещение влево по кольцу), добавляется длина keyboardRing и затем берётся остаток от деления на длину, чтобы обойти кольцо
        char leftNeighbor=keyboardRing.charAt(leftIndex);
        System.out.println("Буква слева на клавиатуре: "+leftNeighbor); // выводим на экран букву, которая находится слева от введённой буквы на QWERTY-клавиатуре
        scanner.next();
    }
}
