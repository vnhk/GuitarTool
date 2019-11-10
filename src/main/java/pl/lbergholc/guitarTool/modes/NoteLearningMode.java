package pl.lbergholc.guitarTool.modes;

import javazoom.jl.decoder.JavaLayerException;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.service.NotePlayer;
import pl.lbergholc.guitarTool.notes.utility.NoteLoader;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NoteLearningMode {
    private static final Logger LOGGER = Logger.getLogger(NoteLearningMode.class);
    private List<Note> notes;
    private NotePlayer player;
    private View view;

    public NoteLearningMode(List<Note> notes, NotePlayer player, View consoleView) {
        this.notes = notes;
        this.player = player;
        this.view = consoleView;
    }

    public void learnSounds(List<Note> notesToLearn) throws JavaLayerException, FileNotFoundException {
        Collections.shuffle(notesToLearn);
        for (Note note : notesToLearn) {
            view.info(note.toString());
            player.playNote(NoteLoader.getMusicStream(note.getFretNumber(), note.getStringNumber(), note.getSoundSymbol()));
        }
    }

    public void learnSounds(String soundSymbol) {
        List<Note> notesWithCSound = notes.stream()
                .filter(note -> note.getSoundSymbol().equals(soundSymbol))
                .collect(Collectors.toList());

        try {
            learnSounds(notesWithCSound);
        } catch (JavaLayerException | FileNotFoundException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testGame() {
        view.info("Note Learning");
        Random randomNumberGenerator = new Random();
        int randomNumber = randomNumberGenerator.nextInt(notes.size());
        try {
            Note note = notes.get(randomNumber);
            player.playNote(NoteLoader.getMusicStream(note.getFretNumber(), note.getStringNumber(), note.getSoundSymbol()));
            view.info("Fret Number");
            String fretNumber = view.getMessageFromUser();
            view.info("String Number");
            String stringNumber = view.getMessageFromUser();

            if (isCorrectFretAndString(randomNumber, fretNumber, stringNumber)) {
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
        return (fretNumber).equals(notes.get(randomNumber).getFretNumber() + "") && (stringNumber).equals(notes.get(randomNumber).getStringNumber() + "");
    }
}
