package com.introvd.template.sdk.model.editor;

import android.graphics.Rect;
import lib.C12177i;
import xiaoying.utils.ITRCLyricsDecryptListener;

public class DataLyricsItem {
    public static String FONT_FAMILY_FILE = "/system/fonts/DroidSansFallback.ttf";
    public ITRCLyricsDecryptListener decryptor;
    public int nDstStartPos = 0;
    public int nLrcBgColor = 16777215;
    public int nLrcForeColor = 0;
    public int nLrcLength = C12177i.f6156l;
    public int nLrcStartPos = 0;
    public Rect rect = new Rect(1250, 9050, 8750, 9800);
    public String strLrcFontFile = FONT_FAMILY_FILE;
    public String strLrcTRCFile = "";
}
