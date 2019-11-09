package pl.lbergholc.guitarTool.tabulature.model;

import pl.lbergholc.guitarTool.notes.model.Note;

import java.util.ArrayList;
import java.util.List;

public class Tab {
    private List<Note> notes = new ArrayList<>();
    private String tabName;
    private String creatorName;
    private String tuning;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTuning() {
        return tuning;
    }

    public void setTuning(String tuning) {
        this.tuning = tuning;
    }
}
