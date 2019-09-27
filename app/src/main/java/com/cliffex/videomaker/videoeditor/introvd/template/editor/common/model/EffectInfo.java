package com.introvd.template.editor.common.model;

public class EffectInfo {
    public int mChildIndex = 0;
    public String mEffectPath = "";

    public EffectInfo() {
    }

    public EffectInfo(String str) {
        this.mEffectPath = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EffectInfo effectInfo = (EffectInfo) obj;
        if (this.mChildIndex != effectInfo.mChildIndex) {
            return false;
        }
        if (this.mEffectPath != null) {
            z = this.mEffectPath.equals(effectInfo.mEffectPath);
        } else if (effectInfo.mEffectPath != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.mEffectPath != null ? this.mEffectPath.hashCode() : 0) * 31) + this.mChildIndex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stylePath:");
        sb.append(this.mEffectPath);
        sb.append(";bChildIndex=");
        sb.append(this.mChildIndex);
        return sb.toString();
    }
}
