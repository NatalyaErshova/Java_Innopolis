package exercise;
//Вывести все числа от одного до 19. Если делится на 3, то пропустить. Если больше 15, то остановить.
public class ex06 {
    public static void main(String[] args) {
        for(int i = 1; i <= 20; i++) {
            if(i%3==0) {
                continue;
            }
            if (i > 15) {
                break;
            }
            System.out.println(i);
        }
    }
}
