package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> outPut = new ArrayList<>();
        List<String> botPhrases = getBotAnswer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу:\r");
        String botAnswer;
        String userAnswer = scanner.nextLine();
        boolean isStopped = false;
        while (!userAnswer.equals(OUT)) {
            outPut.add(userAnswer);
            if (userAnswer.equals(STOP)) {
                isStopped = true;
            }
            if (userAnswer.equals(CONTINUE)) {
                isStopped = false;
            }
            if (!isStopped) {
                botAnswer = botPhrases.get(new Random().nextInt(botPhrases.size()));
                System.out.println(botAnswer);
                outPut.add(botAnswer);
            }
            userAnswer = scanner.nextLine();
        }
        outPut.add(userAnswer);
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(path)))) {
            outPut.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getBotAnswer() {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(botAnswers))) {
            bufferedReader.lines().forEach(list::add);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chatLog.txt", "botAnswers.txt");
        cc.run();
    }
}