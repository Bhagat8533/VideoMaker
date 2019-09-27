package com.introvd.template.editor.preview.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p414ui.view.ProgressBarWithIndicator;

/* renamed from: com.introvd.template.editor.preview.view.a */
public class C6686a extends Dialog implements OnClickListener {
    private TextView bHR = null;
    private View cOt = null;
    private TextView deg = null;
    private ProgressBarWithIndicator deh;
    private boolean dei = false;

    public C6686a(Context context) {
        super(context, R.style.xiaoying_style_com_dialog);
        onCreate();
    }

    private void onCreate() {
        this.cOt = LayoutInflater.from(getContext()).inflate(R.layout.editor_dialog_reverse_progress, null);
        this.deh = (ProgressBarWithIndicator) this.cOt.findViewById(R.id.xiaoying_ve_basic_tool_progressbar);
        this.deh.setProgress(0);
        this.deg = (TextView) this.cOt.findViewById(R.id.xiaoying_ve_basic_tool_dialog_candel_button);
        this.deg.setOnClickListener(this);
        this.bHR = (TextView) this.cOt.findViewById(R.id.xiaoying_ve_basic_tool_description);
        setContentView(this.cOt);
    }

    public void onClick(View view) {
        if (view.equals(this.deg)) {
            cancel();
        }
    }

    public void setProgress(int i) {
        if (i > 0 || this.dei) {
            this.deg.setEnabled(true);
            setCancelable(true);
        } else {
            this.deg.setEnabled(false);
            setCancelable(false);
        }
        this.deh.setProgress(i);
    }

    public void show() {
        super.show();
    }
}
