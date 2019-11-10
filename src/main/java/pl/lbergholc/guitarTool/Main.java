package pl.lbergholc.guitarTool;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.modes.TabCreatorMode;
import pl.lbergholc.guitarTool.modes.TabPlayerMode;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.service.NotePlayer;
import pl.lbergholc.guitarTool.notes.utility.NoteLoader;
import pl.lbergholc.guitarTool.tabulature.model.Tab;
import pl.lbergholc.guitarTool.tabulature.utility.TabHelper;
import pl.lbergholc.guitarTool.view.ConsoleView;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<Note> notes = NoteLoader.loadAll();
            Collections.sort(notes);

            NotePlayer player = new NotePlayer(notes);
            Scanner scanner = new Scanner(System.in);
            View consoleView = new ConsoleView(scanner);

            TabCreatorMode tabCreatorMode = new TabCreatorMode(notes, consoleView);
            TabPlayerMode tabPlayerMode = new TabPlayerMode(player, consoleView);

            Tab tab = tabCreatorMode.createTab();
            tabPlayerMode.playTab(tab);
            TabHelper.saveTab("tab", tab);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
