package Homeworks.HW7;
import java.util.ArrayList; // Импорт класса для работы со списками
import java.util.HashSet; // Импорт класса для работы с хэш-множествами
import java.util.Set; // Импорт интерфейса Set

/*
Реализовать метод, который на вход принимает ArrayList<T>, а возвращает набор
уникальных элементов этого массива. Решить, используя коллекции
 */
public class UniqueElements { // Объявление публичного класса UniqueElements

    public static <T> Set<T> getUniqueElements(ArrayList<T> list) { // Объявление универсального статического метода с параметром типа T
        // Метод принимает ArrayList элементов типа T и возвращает Set того же типа
        return new HashSet<>(list); // Создание нового объекта HashSet из переданного списка
        // Конструктор HashSet автоматически удаляет все дубликаты
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); // Создание нового объекта ArrayList для хранения целых чисел
        numbers.add(12);
        numbers.add(23);
        numbers.add(35);
        numbers.add(23);
        numbers.add(15);
        numbers.add(42);

        Set<Integer> uniqueNumbers = getUniqueElements(numbers); // Вызов метода getUniqueElements для получения уникальных элементов
        // Результат сохраняется в переменную uniqueNumbers типа Set<Integer>
        System.out.println("Уникальные элементы: " + uniqueNumbers); // Вывод результатов в консоль
    }
}
