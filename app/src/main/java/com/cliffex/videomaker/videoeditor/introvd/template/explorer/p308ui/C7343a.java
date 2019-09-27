package com.introvd.template.explorer.p308ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout.LayoutParams;
import com.introvd.template.vivaexplorermodule.R;

/* renamed from: com.introvd.template.explorer.ui.a */
public class C7343a extends Dialog {
    public C7343a(Context context) {
        super(context, R.style.Explorer_music_extract_transparent_dialog);
        init();
    }

    private void init() {
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.xiaoying_music_extract_loadding_progressbar_dialog, null), new LayoutParams(-1, -1));
        getWindow().getAttributes().gravity = 17;
    }
}
