package pl.lbergholc.guitarTool.modes;

import javazoom.jl.decoder.JavaLayerException;
import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.service.NotePlayer;
import pl.lbergholc.guitarTool.tabulature.model.Sound;
import pl.lbergholc.guitarTool.tabulature.model.Tab;
import pl.lbergholc.guitarTool.tabulature.utility.TabHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class TabPlayerMode {
    private static final Logger LOGGER = Logger.getLogger(TabPlayerMode.class);
    private NotePlayer player;
    private View view;

    public TabPlayerMode(NotePlayer player, View view) {
        this.player = player;
        this.view = view;
    }

    public void playTab(Tab tab) throws InterruptedException, IOException {
        List<Sound> sounds = tab.getSounds();

        Map<Note, List<InputStream>> noteInputStreams = TabHelper.getNoteInputStreams(tab);

        for (int i = 0; i < sounds.size(); i++) {
            List<Note> notes = Arrays.stream(sounds.get(i).getNotesInSound())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            for (int y = 0; y < notes.size(); y++) {
                InputStream stream = noteInputStreams.get(notes.get(y)).remove(0);
                int finalY = y;
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep((sounds.size() - finalY - 1) * 200);
                        player.playNote(stream);
                    } catch (JavaLayerException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
            Thread.sleep(sounds.get(i).getTimeOfSound() + 500);
        }


    }
}
