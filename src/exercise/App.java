package exercise;

import java.util.ArrayList;
import java.util.List;

class Program {
    private String name;
    private int rating;
    private int viewers;

    public Program(String name, int rating, int viewers) {
        this.name = name;
        this.rating = rating;
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "Название программы " + name + "', руйтинг " + rating + ", число зрителей " + viewers + "}";
    }
}

class Channel {
    private String name;
    private int number;
    private Program program;

    public Channel(String name, int number, Program program) {
        this.name = name;
        this.number = number;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Название канала " + name + "', номер канала " + number + ", программа" + program + "}";
    }
}

class Television {
    private String brand;
    private int size;
    private boolean isTurnedOn;
    private List<Channel> channels;

    public Television(String brand, int size, boolean isTurnedOn) {
        this.brand = brand;
        this.size = size;
        this.isTurnedOn = isTurnedOn;
        this.channels = new ArrayList<>();
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Телевизор включен");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Телевизор выключен");
    }

    public void switchChannel(int channelNumber) {
        if (isTurnedOn) {
            if (channelNumber >= 0 && channelNumber < channels.size()) {
                Channel channel = channels.get(channelNumber);
                System.out.println("Переключен на канал: " + channel.getName());
            } else {
                System.out.println("Неверный номер канала");
            }
        } else {
            System.out.println("Tелевизор выключен");
        }
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public String toString() {
        return "Марка телевизора '" + brand + "', диагональ " + size + ", телевизор включен " + isTurnedOn + ", channels=" + channels + "}";
    }
}

public class App {
    public static void main(String[] args) {
        Television tv1 = new Television("Samsung", 55, false);
        Television tv2 = new Television("Sony", 42, true);

        Program program1 = new Program("News", 5, 1000000);
        Channel channel1 = new Channel("Channel 1", 1, program1);

        Program program2 = new Program("Movie", 8, 500000);
        Channel channel2 = new Channel("Channel 2", 2, program2);

        tv1.addChannel(channel1);
        tv2.addChannel(channel1);
        tv2.addChannel(channel2);

        System.out.println(tv1);
        System.out.println(tv2);

        tv1.turnOn();
        tv1.switchChannel(0);

        tv2.switchChannel(1);
    }
}