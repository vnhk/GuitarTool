package pl.lbergholc.guitarTool.modes;

import javazoom.jl.decoder.JavaLayerException;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.service.NotePlayer;
import pl.lbergholc.guitarTool.tabulature.TabHelper;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class TabPlayerMode {
    private static final Logger LOGGER = Logger.getLogger(TabPlayerMode.class);
    private NotePlayer player;
    private View view;

    public TabPlayerMode(NotePlayer player, View view) {
        this.player = player;
        this.view = view;
    }

    public void playTab(Tab tab) throws InterruptedException, IOException {
        List<Note> notes = tab.getNotes();

        Map<Note, List<InputStream>> noteInputStreams = TabHelper.getNoteInputStreams(tab);

        for (Note note : notes) {
            InputStream stream = noteInputStreams.get(note).remove(0);
            Thread thread = new Thread(() -> {
                try {
                    player.playNote(stream);
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(700);

        }
    }


}
