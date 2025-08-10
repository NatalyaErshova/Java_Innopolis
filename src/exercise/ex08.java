package exercise;
//создать структуру для хранения номеров паспортов и фамилий сотрудников организации

import java.util.HashMap;
import java.util.Map;

public class ex08 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(); //заводим карту, которая будет хранить фрукты и их количество
        map.put("123456", "Иванов");
        map.put("321456", "Васильев");
        map.put("234561", "Петрова");
        map.put("234432", "Иванов");
        map.put("654321", "Петрова");
        map.put("345678", "Иванов");
        String name = "Иванов";
        for (Map.Entry<String,String> entry : map.entrySet()) {
            String pasportNumber = entry.getKey();
            String pasportName = entry.getValue();
            if(pasportName.equals(name)) {
                System.out.printf("%s->%s", pasportNumber, pasportName);
            }
        }
    }
}
