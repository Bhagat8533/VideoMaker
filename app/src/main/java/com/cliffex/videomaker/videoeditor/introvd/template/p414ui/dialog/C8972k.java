package com.introvd.template.p414ui.dialog;

/* renamed from: com.introvd.template.ui.dialog.k */
public enum C8972k {
    START,
    CENTER,
    END;
    
    private static final boolean alU = false;

    public int getTextAlignment() {
        switch (this) {
            case CENTER:
                return 4;
            case END:
                return 6;
            default:
                return 5;
        }
    }

    /* renamed from: qk */
    public int mo35620qk() {
        switch (this) {
            case START:
                return alU ? 8388611 : 3;
            case CENTER:
                return 1;
            case END:
                return alU ? 8388613 : 5;
            default:
                throw new IllegalStateException("Invalid gravity constant");
        }
    }
}
