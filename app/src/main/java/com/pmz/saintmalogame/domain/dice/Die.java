package com.pmz.saintmalogame.domain.dice;

import com.pmz.saintmalogame.enums.DieType;

public class Die {

    private DieType type;
    private boolean locked;

    public Die() {
        locked = false;
    }

    public DieType getType() {
        return type;
    }

    public void setType(DieType type) {
        this.type = type;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


}
