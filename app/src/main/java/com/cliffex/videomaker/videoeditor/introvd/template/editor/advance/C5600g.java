package com.introvd.template.editor.advance;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.advance.g */
public class C5600g extends Dialog implements OnClickListener {
    private TextView cvd;
    private ImageView cve;

    public C5600g(Context context) {
        super(context, R.style.xiaoying_style_com_dialog);
        View inflate = LayoutInflater.from(context).inflate(R.layout.editor_subtitle_add_font_dialog_layout, null);
        this.cvd = (TextView) inflate.findViewById(R.id.edit_subtitle_font_dialog_ok_button);
        this.cve = (ImageView) inflate.findViewById(R.id.edit_subtitle_font_dialog_cancel_button);
        this.cvd.setOnClickListener(this);
        this.cve.setOnClickListener(this);
        ViewClickEffectMgr.addEffectForViews("AdvanceEditorSubtitleV4", this.cve, this.cvd);
        setContentView(inflate);
    }

    public void onClick(View view) {
        if (view.equals(this.cve) || view.equals(this.cvd)) {
            dismiss();
        }
    }
}
