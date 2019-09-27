package com.introvd.template.app.p181e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.introvd.template.R;

/* renamed from: com.introvd.template.app.e.a */
public class C3871a extends Dialog implements OnClickListener {
    private ImageView bqg;
    private TextView bqh;
    private ProgressBar bqi;
    private TextView bqj;
    private C3872a bqk;

    /* renamed from: com.introvd.template.app.e.a$a */
    public interface C3872a {
        /* renamed from: KU */
        void mo23405KU();
    }

    public C3871a(Context context, int i) {
        super(context, i);
        init(context);
    }

    /* renamed from: KT */
    private void m9532KT() {
        this.bqg = (ImageView) findViewById(R.id.back_btn);
        this.bqh = (TextView) findViewById(R.id.progress_text);
        this.bqi = (ProgressBar) findViewById(R.id.progressbar);
        this.bqj = (TextView) findViewById(R.id.cancel_save_btn);
        this.bqj.getPaint().setFlags(8);
        this.bqg.setOnClickListener(this);
        this.bqj.setOnClickListener(this);
    }

    private void cancelDownload() {
        if (this.bqk != null) {
            dismiss();
            this.bqk.mo23405KU();
        }
    }

    /* renamed from: gE */
    private String m9533gE(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.xiaoying_str_viva_download_dialog_progress_text, new Object[]{Integer.valueOf(i)}));
        sb.append("%");
        return sb.toString();
    }

    private void init(Context context) {
        requestWindowFeature(1);
        setContentView(R.layout.app_dialog_download_source);
        setCanceledOnTouchOutside(false);
        ((Activity) context).getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        m9532KT();
    }

    /* renamed from: a */
    public void mo23402a(C3872a aVar) {
        this.bqk = aVar;
    }

    /* renamed from: gD */
    public void mo23403gD(int i) {
        this.bqi.setProgress(i);
        this.bqh.setText(m9533gE(i));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_btn) {
            dismiss();
        } else if (id == R.id.cancel_save_btn) {
            cancelDownload();
        }
    }
}
