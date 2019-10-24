package pl.lbergholc.guitarTool.view;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.View;

import java.util.Scanner;

public class ConsoleView implements View {
    private static final Logger LOGGER = Logger.getLogger(ConsoleView.class);
    private Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public String getMessageFromUser() {
       return scanner.nextLine();
    }
}
