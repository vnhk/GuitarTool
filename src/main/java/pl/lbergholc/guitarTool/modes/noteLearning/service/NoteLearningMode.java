package pl.lbergholc.guitarTool.modes.noteLearning.service;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.Note;
import pl.lbergholc.guitarTool.model.View;
import pl.lbergholc.guitarTool.modes.model.Mode;
import pl.lbergholc.guitarTool.service.NotePlayer;

import java.util.List;
import java.util.Random;

public class NoteLearningMode implements Mode {
    private static final Logger LOGGER = Logger.getLogger(NoteLearningMode.class);
    private final int PLAY_TIME = 100;
    private List<Note> notes;
    private NotePlayer player;
    private View view;

    public NoteLearningMode(List<Note> notes, NotePlayer player, View consoleView) {
        this.notes = notes;
        this.player = player;
        this.view = consoleView;
    }

    @Override
    public void start() {
        view.info("Note Learning");
        Random randomNumberGenerator = new Random();
        int randomNumber = randomNumberGenerator.nextInt(notes.size());
        try {
            player.playNote(randomNumber, PLAY_TIME);
            view.info("Fret Number");
            String fretNumber = view.getMessageFromUser();
            view.info("String Number");
            String stringNumber = view.getMessageFromUser();

            if(isCorrectFretAndString(randomNumber, fretNumber, stringNumber)){
                view.info("Good");
            } else {
                view.info("It was " + notes.get(randomNumber));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean isCorrectFretAndString(int randomNumber, String fretNumber, String stringNumber) {
      return (fretNumber).equals(notes.get(randomNumber).getFretNumber()+"")&&(stringNumber).equals(notes.get(randomNumber).getStringNumber()+"");
    }
}
