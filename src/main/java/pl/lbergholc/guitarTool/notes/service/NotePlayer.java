package pl.lbergholc.guitarTool.notes.service;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;

import java.io.InputStream;
import java.util.List;

public class NotePlayer {
    private static final Logger LOGGER = Logger.getLogger(NotePlayer.class);
    private List<Note> notes;

    public NotePlayer(List<Note> notes) {
        this.notes = notes;
    }

    public void playNote(InputStream musicStream) throws JavaLayerException {
        Player player = new Player(musicStream);
        player.play();
    }

    public void playNote(int noteNumber) throws JavaLayerException {

        InputStream musicStream = notes.get(noteNumber).getMusicStream();
        Player player = new Player(musicStream);
        player.play();
    }

    public void playNote(Note note) throws JavaLayerException {
        Player player = new Player(note.getMusicStream());
        player.play();
    }

    public void playNote(Note note, int time) throws JavaLayerException {
        Player player = new Player(note.getMusicStream());
        player.play(time);
    }

    public void playNote(int noteNumber, int time) throws JavaLayerException {

        InputStream musicStream = notes.get(noteNumber).getMusicStream();
        Player player = new Player(musicStream);
        player.play(time);
    }
}
