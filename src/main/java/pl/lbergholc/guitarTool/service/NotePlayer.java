package pl.lbergholc.guitarTool.service;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.Note;

import java.io.BufferedInputStream;
import java.util.List;

public class NotePlayer {
    private static final Logger LOGGER = Logger.getLogger(NotePlayer.class);
    private List<Note> notes;

    public NotePlayer(List<Note> notes) {
        this.notes = notes;
    }

    public void playNote(int noteNumber) throws JavaLayerException {
        LOGGER.info("playNote");

        BufferedInputStream musicStream = notes.get(noteNumber).getMusicStream();
        Player player = new Player(musicStream);
        player.play();
    }

    public void playNote(Note note) throws JavaLayerException {
        LOGGER.info("playNote");
        Player player = new Player(note.getMusicStream());
        player.play();
    }

    public void playNote(int noteNumber, int time) throws JavaLayerException {
        LOGGER.info("playNote");

        BufferedInputStream musicStream = notes.get(noteNumber).getMusicStream();
        Player player = new Player(musicStream);
        player.play(time);

    }
}
