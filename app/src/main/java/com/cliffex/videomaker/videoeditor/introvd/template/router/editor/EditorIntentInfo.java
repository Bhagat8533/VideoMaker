package com.introvd.template.router.editor;

import java.io.Serializable;
import java.util.HashMap;

public class EditorIntentInfo implements Serializable {
    public boolean autoPlay = false;
    public int baseMode = 0;
    public String from = "";
    public HashMap<String, String> paramMap = new HashMap<>();
    public int secondaryMode = -1;
    public int tabType = 0;
}
