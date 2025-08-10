package exercise;

public class Person {
    private String firstName; //атрибуты, описывающие характеристики нашего типа данных Person
    private String lastName;
    private String thirdName;

    //вариант инициализации без конструктора
    //private String firstName = "defaultFirstName"; //атрибуты, описывающие характеристики нашего типа данных Person
    // private String lastName = "defaultLastName";
    //private String thirdName = "defaultThirdName";

    //public Person() { //собственный конструктор класса, в который добавили логику, как будут проинициализированы значения полей по умолчанию
        //this.firstName = "defaultFirstName";
        //this.lastName = "defaultLaststName";
        //this.thirdName = "defaultThirdName";

    //новый конструктор, чтобы указать обязательные для заполенения параметры по умолчанию
    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //геттеры и сеттеры можно убрать, когда есть конструктор с параметрами
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                '}';
    }
}
