package exercise;

import java.util.HashMap;
import java.util.Map;

public class ex07 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(); //заводим карту, которая будет хранить фрукты и их количество
        map.put("Яблоко", 3);
        map.put("Банан", 5);
        map.put("Помидор", 2);
        int count = map.get("Банан"); //извлекаем количество бананов
        System.out.println(count); //выводим количество бананов
        map.put("Яблоко", 10); //новое количество яблок
        map.remove("Банан"); //удаляем бананы из карты
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s->%d%n", entry.getKey(), entry.getValue()); //по оставшимся позициям выводится количество и наименование
        }
    }
}
