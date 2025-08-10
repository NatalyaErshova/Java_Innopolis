package exercise;
//арифметические операции

public class ex05 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int sum = a+b+c;
        double average = sum / 3.0;
        boolean allPositive = (a > 0) && (b > 0) && (c > 0);
        String label = (average >= 10) ? "Большое": "Маленькое";
        System.out.println(sum);
        System.out.println(average);
        System.out.println(allPositive);
        System.out.println(label);
    }
}
