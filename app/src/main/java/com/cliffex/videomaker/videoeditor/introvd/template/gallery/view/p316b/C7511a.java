package com.introvd.template.gallery.view.p316b;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.xygallery.R;

/* renamed from: com.introvd.template.gallery.view.b.a */
public class C7511a extends Dialog {

    /* renamed from: Jn */
    private View f3553Jn;
    private TextView dLc = ((TextView) this.f3553Jn.findViewById(R.id.new_feature_text));
    private TextView dLd = ((TextView) this.f3553Jn.findViewById(R.id.new_feature_version));
    private TextView dLe = ((TextView) this.f3553Jn.findViewById(R.id.btn_confirm));
    private Context mContext;

    public C7511a(Context context) {
        super(context, R.style.xiaoying_style_com_dialog);
        this.mContext = context;
        this.f3553Jn = LayoutInflater.from(context).inflate(R.layout.gallery_include_dialog_tip_with_icon, null);
        this.dLe.setTextColor(this.mContext.getResources().getColor(R.color.black));
        this.dLe.setVisibility(0);
        this.dLe.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C7511a.this.isShowing()) {
                    C7511a.this.dismiss();
                }
            }
        });
    }

    /* renamed from: jN */
    public void mo32296jN(String str) {
        if (this.dLe != null) {
            this.dLe.setText(str);
        }
    }

    public void setContent(String str) {
        if (this.dLc != null) {
            this.dLc.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.dLd != null) {
            this.dLd.setText(str);
        }
    }

    public void show() {
        if (this.f3553Jn != null) {
            setContentView(this.f3553Jn);
        }
        super.show();
    }
}
