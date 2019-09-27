package com.introvd.template.editor.p261g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.editor.g.b */
public class C6311b {
    private static Toast cVf;

    /* renamed from: b */
    public static void m18065b(Context context, boolean z, String str) {
        View view;
        if (cVf != null) {
            view = cVf.getView();
            cVf.cancel();
        } else {
            view = null;
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.editor_perform_toast_view_layout, null);
        }
        cVf = new Toast(context);
        cVf.setGravity(81, 0, C4583d.m11673ii(260));
        cVf.setDuration(0);
        TextView textView = (TextView) view.findViewById(R.id.tv_2);
        ((TextView) view.findViewById(R.id.tv_1)).setText(z ? R.string.xiaoying_str_editor_redo_title : R.string.xiaoying_str_editor_undo_title);
        if (str != null) {
            textView.setText(str);
        }
        cVf.setView(view);
        cVf.show();
    }
}
