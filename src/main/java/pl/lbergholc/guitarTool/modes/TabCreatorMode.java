package pl.lbergholc.guitarTool.modes;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.utility.NoteHelper;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.util.List;
import java.util.Optional;

public class TabCreatorMode {
    private static final Logger LOGGER = Logger.getLogger(TabCreatorMode.class);
    private List<Note> notes;
    private View view;
    private final String NOTE_DOES_NOT_EXIST = "Note does not exist";
    private final String NOTE_ADDED = "Note was added";


    public TabCreatorMode(List<Note> notes, View view) {
        this.notes = notes;
        this.view = view;
    }

    public Tab createTab() {
        Tab tab = new Tab();

        while(true) {

            view.info("click q to exit");
            String messageFromUser = view.getMessageFromUser();
            if(messageFromUser.equals("q")){
                break;
            }

            view.info("Type fret number of note");
            String fret = view.getMessageFromUser();
            view.info("Type string number of note");
            String string = view.getMessageFromUser();

            int fretNumber = Integer.parseInt(fret);
            int stringNumber = Integer.parseInt(string);

            Optional<Note> note = NoteHelper.findNote(notes, fretNumber, stringNumber);

            if(note.isEmpty()) {
                LOGGER.debug(fret);
                LOGGER.debug(string);
                LOGGER.error(NOTE_DOES_NOT_EXIST);
                view.info(NOTE_DOES_NOT_EXIST);
            } else {
               tab.getNotes().add(note.get());
               view.info(NOTE_ADDED);
            }
        }
        return tab;
    }
}
