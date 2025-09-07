package exercise;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

// Написать метод, который переведет число из римского формата записи в арабский.
// Например, MMXXII = 2022
// IX -> 1<10 10 -1 =9
// XIII -> 10+1+1+1 = 13
public class Ex10 {
    public static int romanToArabic(String roman) {
        // Создаем статический метод romanToArabic,
        // который принимает строку roman (римское число) и возвращает целое число.
        Map<Character, Integer> romanMap = new HashMap<>();
        //Создаем HashMap romanMap для сопоставления римских цифр с арабскими числами.
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        // Заполняем romanMap значениями для римских цифр I, V, X, L, C, D, M и их соответствующими арабскими числами.

        int result = 0;
        // Инициализируем переменную result, которая будет содержать результат преобразования.
        int lenght = roman.length();
        // Получаем длину строки roman.

        for(int i=0; i<lenght-1;i++) {
            //Запускаем цикл for для обхода каждого символа в строке roman.
            char currentChar = roman.charAt(i);
            char nextChar = roman.charAt(i+1);
            // Получаем текущий символ и следующий символ в строке.

            int currentVal = romanMap.get(currentChar);
            int nextVal = romanMap.get(nextChar);
            // Получаем арабские значения для текущего и следующего символов из romanMap.

            if(currentVal<nextVal) {
                result-=currentVal;
                //Проверяем, если текущее значение меньше следующего, то вычитаем текущее значение из результата, иначе добавляем его.
            } else {
                result+=currentVal;
            }
        }
        result+=romanMap.get(roman.charAt(lenght-1));
        // Добавляем значение последнего символа к результату.

        return result;
        //Возвращаем результат
    }

    public static void main(String[] args) {
        //Создаем статический метод main для запуска программы
        String[] examples = {
                //Создаем массив examples с несколькими римскими числами.
                "MMXXII",
                "IV",
                "XL",
                "XCIX",
                "MCMXCIV"
        };

        for (String roman : examples) {
            //Запускаем цикл for для каждого римского числа из examples.
            int arabic = romanToArabic(roman);
            // Преобразуем римское число в арабское, используя метод romanToArabic.
            System.out.printf("%s->%d%n",roman,arabic);
            // "%s->%d%n" - форматирование строки, в которой %s будет заменено на значение строки,
            // %d на целое число, а %n на перевод строки.
        }
    }
}
