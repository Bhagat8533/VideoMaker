package com.aiii.sdk.android.oss.model;

import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = -1942759024112448066L;
    private String displayName;

    /* renamed from: id */
    private String f3224id;

    public Owner() {
        this(null, null);
    }

    public Owner(String str, String str2) {
        this.f3224id = str;
        this.displayName = str2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String id = owner.getId();
        String displayName2 = owner.getDisplayName();
        String id2 = getId();
        String displayName3 = getDisplayName();
        if (id == null) {
            id = "";
        }
        if (displayName2 == null) {
            displayName2 = "";
        }
        if (id2 == null) {
            id2 = "";
        }
        if (displayName3 == null) {
            displayName3 = "";
        }
        if (id.equals(id2) && displayName2.equals(displayName3)) {
            z = true;
        }
        return z;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.f3224id;
    }

    public int hashCode() {
        if (this.f3224id != null) {
            return this.f3224id.hashCode();
        }
        return 0;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.f3224id = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Owner [name=");
        sb.append(getDisplayName());
        sb.append(",id=");
        sb.append(getId());
        sb.append(RequestParameters.RIGHT_BRACKETS);
        return sb.toString();
    }
}
