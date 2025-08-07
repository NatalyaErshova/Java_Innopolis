package Homeworks.attestation01;
import java.util.*;

class Product {
    private final String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Продукт{" +
                "название='" + name + '\'' +
                ", стоимость=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

class Person {
    private String name;
    private int money;
    private List<Product> cart;

    public Person(String name, int money) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = name;
        this.money = money;
        this.cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product product) {
        if (product.getPrice() <= money) {
            cart.add(product);
            money -= product.getPrice();
            return true;
        } else {
            System.out.println("Недостаточно денег для покупки продукта: " + product.getName());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Покупатель{" +
                "имя='" + name + '\'' +
                ", деньги=" + money +
                ", пакет=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return money == person.money && name.equals(person.name) && cart.equals(person.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, cart);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите покупателей в формате 'Имя = Деньги';:");
        String personInput = scanner.nextLine();
        List<Person> persons = new ArrayList<>();

        String[] personEntries = personInput.split(";");

        for (String entry : personEntries) {
            entry = entry.trim();
            if (!entry.isEmpty()) {
                String[] parts = entry.split("=");
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                persons.add(new Person(name, money));
            }
        }

        System.out.println("Введите продукты в формате 'Продукт = Стоимость';:");
        String productInput = scanner.nextLine();
        List<Product> products = new ArrayList<>();

        String[] productEntries = productInput.split(";");

        for (String entry : productEntries) {
            entry = entry.trim();
            if (!entry.isEmpty()) {
                String[] parts = entry.split("=");
                String name = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());
                products.add(new Product(name, price));
            }
        }

        System.out.println("Введите покупки в формате 'Имя покупателя - Продукт'. Чтобы завершить ввод, введите 'END':");
        Map<String, List<Product>> purchaseResults = new HashMap<>();
        String purchaseInput;

        while (!(purchaseInput = scanner.nextLine()).equals("END")) {
            String[] parts = purchaseInput.split("-");
            String personName = parts[0].trim();
            String productName = parts[1].trim();

            Person person = findPersonByName(persons, personName);
            Product product = findProductByName(products, productName);

            if (person != null && product != null) {
                if (person.addProduct(product)) {
                    System.out.println(personName + " купил " + productName);
                    purchaseResults.putIfAbsent(personName, new ArrayList<>());
                    purchaseResults.get(personName).add(product);
                } else {
                    System.out.println(personName + " не может позволить себе " + productName);
                }
            } else {
                System.out.println("Неверное имя покупателя или название продукта.");
            }
        }

        // Итоги
        for (Person person : persons) {
            String name = person.getName();
            List<Product> purchasedProducts = purchaseResults.getOrDefault(name, Collections.emptyList());

            if (purchasedProducts.isEmpty()) {
                System.out.println(name + " Ничего не куплено");
            } else {
                StringBuilder purchasedProductsString = new StringBuilder();
                for (Product product : purchasedProducts) {
                    purchasedProductsString.append(product.getName()).append(", ");
                }
                purchasedProductsString.setLength(purchasedProductsString.length() - 2); // удаляем последнюю запятую
                System.out.println(name + " - " + purchasedProductsString);
            }
        }

        scanner.close();
    }

    private static Person findPersonByName(List<Person> persons, String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private static Product findProductByName(List<Product> products, String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
