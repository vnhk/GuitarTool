package pl.lbergholc.guitarTool;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.Note;

import java.util.List;
import java.util.Random;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<Note> notes = NoteLoader.load();
            NotePlayer player = new NotePlayer(notes);

            Random randomNumberGenerator = new Random();
            int randomNumber = randomNumberGenerator.nextInt(notes.size());

            player.playNote(randomNumber);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
