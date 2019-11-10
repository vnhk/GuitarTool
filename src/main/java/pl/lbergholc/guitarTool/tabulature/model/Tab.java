package pl.lbergholc.guitarTool.tabulature.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Tab implements Serializable {
    private String tabName;
    private String creatorName;
    private String tuning;
    private List<Sound> sounds = new LinkedList<>();

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
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
