package exercise;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24
Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных значений в данном массиве и верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
Процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве
 */
public class ex03 {
    public static int[] fillArrayWithRandomNumber() { //создаем метод
        int size = 1000;
        int bound = 25;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
    public static double calculateUniquePercentage(int[] array) {
        Set<Integer> uniqieValues = new HashSet<>();

        for(int value : array) {
            uniqieValues.add(value);
        }

        int uniqueCount = uniqieValues.size();
        int totalCount = array.length;
        double percentage = (uniqueCount * 100) / totalCount;
        return percentage;
    }
    public static void main(String[] args) {
        int[] randomArray = fillArrayWithRandomNumber();
        double uniquePercent = calculateUniquePercentage(randomArray);
        System.out.printf("Процент уникальных значений в массиве: %.2f%%\n",uniquePercent);
    }
}
