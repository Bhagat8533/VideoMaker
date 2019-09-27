package com.introvd.template.sdk.model.editor;

public class SymbolStringInfo {
    private boolean isSymbolStr = true;
    private int mEndPSPosInOriString = -1;
    private int mStartPSPosInOriString = -1;
    private String mSymbolString = null;

    public int getmEndPSPosInOriString() {
        return this.mEndPSPosInOriString;
    }

    public int getmStartPSPosInOriString() {
        return this.mStartPSPosInOriString;
    }

    public String getmSymbolString() {
        return this.mSymbolString;
    }

    public boolean isSymbolStr() {
        return this.isSymbolStr;
    }

    public void setSymbolStr(boolean z) {
        this.isSymbolStr = z;
    }

    public void setmEndPSPosInOriString(int i) {
        this.mEndPSPosInOriString = i;
    }

    public void setmStartPSPosInOriString(int i) {
        this.mStartPSPosInOriString = i;
    }

    public void setmSymbolString(String str) {
        this.mSymbolString = str;
    }
}
