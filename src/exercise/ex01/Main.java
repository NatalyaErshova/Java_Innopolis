package exercise.ex01;

public class Main {
    public static void main(String[] args) {
        test(testFunc()); //вызвали процедуру, которая обращается к функции
        test("Hello"); //вызвали процедуру и ввели текст
    }

    static void test(String message) { //
        System.out.println(message); //процедура, печатающая сообщение
    }

    static String testFunc() { //функция
        return "Hello world";
    }
}
