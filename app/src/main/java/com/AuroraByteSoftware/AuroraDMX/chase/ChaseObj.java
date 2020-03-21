package com.AuroraByteSoftware.AuroraDMX.chase;

import android.graphics.PorterDuff;

import com.AuroraByteSoftware.AuroraDMX.CueObj;
import com.AuroraByteSoftware.AuroraDMX.ui.chase.ChaseButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;

public class ChaseObj implements Serializable {

    private static final long serialVersionUID = -6835651116806619514L;
    // legacy variable, here for version upgrades
    private int fadeTime = Integer.MAX_VALUE;
    private int waitTime = Integer.MAX_VALUE;
    private double fadeTime_d = 5.0;
    private double waitTime_d = 5.0;
    private ArrayList<CueObj> cues;
    private int[] levels = new int[0];
    private transient ChaseButton button;
    private int highlight = 0;
    private boolean fadeInProgress = false;
    private String name = "";
    private transient Timer fadeTimer = null;
    private int buttonColor = 0;

    /**
     * makes android compiler happier
     */
    public ChaseObj() {
    }

    /**
     * @return the button
     */
    public ChaseButton getButton() {
        return button;
    }

    /**
     * @param button the button to set
     */
    public void setButton(ChaseButton button) {
        this.button = button;
    }

    public ChaseObj(String cueName, double a_fadeTime, double a_waitTime, ArrayList<CueObj> a_cues, ChaseButton a_button) {
        fadeTime_d = a_fadeTime;
        waitTime_d = a_waitTime;
        cues = a_cues;
        button = a_button;
        name = cueName;
    }

    /**
     * @return the fadeTime
     */
    public double getFadeTime() {
        if (fadeTime != Integer.MAX_VALUE) {
            fadeTime_d = fadeTime;
            fadeTime = Integer.MAX_VALUE;
        }
        return fadeTime_d;
    }

    /**
     * @param fadeUpTime2 the fadeTime to set
     */
    public void setFadeTime(double fadeUpTime2) {
        this.fadeTime_d = fadeUpTime2;
    }

    /**
     * @return the waitTime
     */
    public double getWaitTime() {
        if (waitTime != Integer.MAX_VALUE) {
            waitTime_d = waitTime;
            waitTime = Integer.MAX_VALUE;
        }
        return waitTime_d;
    }

    /**
     * @param waitTime the waitTime to set
     */
    public void setWaitTime(double waitTime) {
        this.waitTime_d = waitTime;
    }

    public int getHighlight() {
        return highlight;
    }

    /**
     * @return the fadeInProgress
     */
    public boolean isFadeInProgress() {
        return fadeInProgress;
    }

    /**
     * @param fadeInProgress the fadeInProgress to set
     */
    public void setFadeInProgress(boolean fadeInProgress) {
        this.fadeInProgress = fadeInProgress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getOriginalLevels() {
        return levels;
    }

    public void setOriginalLevels(int[] array) {
        levels = array;
    }

    public ArrayList<CueObj> getCues() {
        return cues;
    }

    public void setCues(ArrayList<CueObj> cues) {
        this.cues = cues;
    }

    public Timer getFadeTimer() {
        return fadeTimer;
    }

    public void setFadeTimer(Timer fadeTimer) {
        this.fadeTimer = fadeTimer;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
        if (buttonColor == 0)
            button.getButton().getBackground().clearColorFilter();
        else
            button.getButton().getBackground().setColorFilter(buttonColor, PorterDuff.Mode.MULTIPLY);
    }

    public int getButtonColor() {
        return buttonColor;
    }
}
