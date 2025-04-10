package Homework.Patterns;

import java.util.ArrayList;

// Класс-observer менеджера логистической компании, принимает сообщения и печатает лог
public class LogisticsManager implements Observer {
    private ArrayList<String> statusLog = new ArrayList<>();

    @Override
    public void submitStatus(String status) {
        statusLog.add(status);
    }

    public void printLog() {
        for (String s : statusLog) System.out.println(s);
    }
}
