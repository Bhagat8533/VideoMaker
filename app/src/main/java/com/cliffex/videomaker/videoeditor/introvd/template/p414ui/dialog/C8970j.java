package com.introvd.template.p414ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.j */
public class C8970j extends Dialog implements OnClickListener {
    private TextView bCG;
    private ImageView cBk;
    private TextView cgS;
    private TextView cgU;
    private TextView exy;
    private C8971a exz;

    /* renamed from: com.introvd.template.ui.dialog.j$a */
    public interface C8971a {
        void buttonClick(int i);
    }

    public C8970j(Context context, C8971a aVar) {
        super(context, C10122R.style.xiaoying_style_com_dialog);
        this.exz = aVar;
        setContentView(C10122R.C10126layout.xiaoying_com_dialog_auto_export);
        if (getWindow() != null) {
            getWindow().setLayout(-1, -1);
        }
        this.bCG = (TextView) findViewById(C10122R.C10124id.export_title);
        this.cgS = (TextView) findViewById(C10122R.C10124id.export_content);
        this.exy = (TextView) findViewById(C10122R.C10124id.xiaoying_export_dialog_negative);
        this.cgU = (TextView) findViewById(C10122R.C10124id.xiaoying_export_dialog_positive);
        this.cBk = (ImageView) findViewById(C10122R.C10124id.imgview_icon);
        this.exy.setOnClickListener(this);
        this.cgU.setOnClickListener(this);
        aMZ();
    }

    private void aMZ() {
        try {
            Typeface create = Typeface.create("sans-serif-medium", 0);
            if (this.exy != null) {
                this.exy.setTypeface(create);
            }
            if (this.cgU != null) {
                this.cgU.setTypeface(create);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: bg */
    public void mo35614bg(String str, String str2) {
        if (this.exy != null) {
            this.exy.setText(str);
        }
        if (this.cgU != null) {
            this.cgU.setText(str2);
        }
    }

    public void onClick(View view) {
        if (view == this.exy) {
            dismiss();
            if (this.exz != null) {
                this.exz.buttonClick(0);
            }
        } else if (view == this.cgU) {
            dismiss();
            if (this.exz != null) {
                this.exz.buttonClick(1);
            }
        }
    }

    public void setDialogContent(String str) {
        if (this.cgS != null) {
            this.cgS.setText(str);
        }
    }

    public void setDialogIcon(int i) {
        if (i > 0) {
            this.cBk.setVisibility(0);
            this.cBk.setBackgroundResource(i);
        }
    }

    public void setDialogTitle(String str) {
        if (this.bCG != null) {
            this.bCG.setText(str);
        }
    }
}
