package pl.lbergholc.guitarTool;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.Note;
import pl.lbergholc.guitarTool.model.View;
import pl.lbergholc.guitarTool.modes.noteLearning.service.NoteLearningMode;
import pl.lbergholc.guitarTool.service.NotePlayer;
import pl.lbergholc.guitarTool.utility.NoteLoader;
import pl.lbergholc.guitarTool.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<Note> notes = NoteLoader.load();
            NotePlayer player = new NotePlayer(notes);
            Scanner scanner = new Scanner(System.in);
            View consoleView = new ConsoleView(scanner);

            NoteLearningMode noteLearning = new NoteLearningMode(notes, player, consoleView);
            noteLearning.learnSounds(notes);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
