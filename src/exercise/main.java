package exercise;

public class main {
    public static void main(String[] args) {  //метод
        Person myPerson = new Person("Наталья", "Ершова"); //инициализация класса, создаем экземпляр класса (объект)
        //в скобочках конструктор класса по умолчанию (дефолтный конструктор)
        //переменная myPerson, которая имеет тип данных Person. Создаем ссылку в области памяти Heap
        // new Person() - выделение места в хипе
        //переменная myPerson хранит ссылку на место в памяти под инициализацию объекта
        // System.out.println(myPerson.firstName); //не работает, если поля класса приватные
        System.out.println(myPerson);
        myPerson.setFirstName("Наталья");
        myPerson.setLastName("Ершова");
        myPerson.setThirdName("Владимировна");
        System.out.println(myPerson);
        System.out.println(myPerson.getFirstName());
    }
}
