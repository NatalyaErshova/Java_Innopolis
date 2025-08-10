package exercise;

import java.time.LocalDate;
import java.time.Period;

/* Придумайте структура класса Кот. Какие поля и методы будут актуальны для приложения,
которое является информационной системой ветеринарной клиники
Добейтесь того, чтобы при выводе на консоль объекта типа Cat, выводилась его кличка,
цвет и возраст.
 */
class Cat {
    private String name;
    private String color;
    private LocalDate birthDate;

    public Cat(String name, String color, LocalDate birthDate) {
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
    }
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        int age = getAge();
        String yearsWord;
        if ((age % 10 == 1) && (age % 100 != 11)) {
            yearsWord = "год";
        } else if ((age % 10 >= 2) && (age % 10 <= 4) && (age % 100 < 12 || age % 100 > 14)) {
            yearsWord = "года";
        } else {
            yearsWord = "лет";
        }
        return String.format("%s (%s), %d %s", name, color, age,yearsWord);
    }
}

public class ex04 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мизуки", "серая", LocalDate.of(2022, 11, 1));
        Cat cat2 = new Cat("Мурзик", "рыжий", LocalDate.of(2015, 05, 7));
        System.out.println(cat1);
        System.out.println(cat2);
    }
}
