package com.introvd.template.explorer.model;

public enum GROUP_MEDIA_TYPE {
    GROUP_MEDIA_TYPE_DATE(1),
    GROUP_MEDIA_TYPE_FOLDER(2),
    GROUP_MEDIA_TYPE_TITLE(3);

    private GROUP_MEDIA_TYPE(int i) {
    }

    public static GROUP_MEDIA_TYPE getType(int i) {
        switch (i) {
            case 1:
                return GROUP_MEDIA_TYPE_DATE;
            case 2:
                return GROUP_MEDIA_TYPE_FOLDER;
            case 3:
                return GROUP_MEDIA_TYPE_TITLE;
            default:
                return GROUP_MEDIA_TYPE_FOLDER;
        }
    }

    public String getName() {
        return name();
    }
}
