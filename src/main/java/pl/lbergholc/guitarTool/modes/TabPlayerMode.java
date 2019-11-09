package pl.lbergholc.guitarTool.modes;

import javazoom.jl.decoder.JavaLayerException;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.service.NotePlayer;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.util.List;

public class TabPlayerMode {
    private static final Logger LOGGER = Logger.getLogger(TabPlayerMode.class);
    private NotePlayer player;
    private View view;

    public TabPlayerMode(NotePlayer player, View view) {
        this.player = player;
        this.view = view;
    }

    public void playTab(Tab tab) throws JavaLayerException {
        List<Note> notes = tab.getNotes();

        for (Note note : notes) {
            player.playNote(note,65);
        }
    }


}
