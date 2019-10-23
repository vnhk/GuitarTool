package pl.lbergholc.guitarTool.model;

import java.io.BufferedInputStream;

public class Note {
    private int fretNumber;
    private int stringNumber;
    private BufferedInputStream musicStream;

    public Note(int fretNumber, int stringNumber, BufferedInputStream musicStream) {
        this.fretNumber = fretNumber;
        this.stringNumber = stringNumber;
        this.musicStream = musicStream;
    }

    public int getFretNumber() {
        return fretNumber;
    }

    public void setFretNumber(int fretNumber) {
        this.fretNumber = fretNumber;
    }

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }

    public BufferedInputStream getMusicStream() {
        return musicStream;
    }
}
