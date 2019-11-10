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
}
