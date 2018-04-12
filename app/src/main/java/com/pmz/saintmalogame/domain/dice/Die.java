package com.pmz.saintmalogame.domain.dice;

public class Die {

    private String face;
    private boolean locked;

    public Die() {
        locked = false;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


}
