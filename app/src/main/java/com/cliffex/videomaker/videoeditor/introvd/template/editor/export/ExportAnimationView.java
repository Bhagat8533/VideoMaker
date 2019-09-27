package com.introvd.template.editor.export;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.xyui.RoundedTextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class ExportAnimationView extends RelativeLayout {
    private ImageView cOg;
    private ImageView cOh;
    private RoundedTextView cOi;
    private TextView cOj;
    private TextView cOk;
    private TextView cOl;
    private TextView cOm;
    private TextView cOn;
    private View cOo;
    private C6245f cOp;
    /* access modifiers changed from: private */
    public C6195a cOq;
    private SpannableString cOr;

    /* renamed from: com.introvd.template.editor.export.ExportAnimationView$a */
    public interface C6195a {
        void alk();

        void all();

        void alm();

        /* renamed from: fH */
        void mo29022fH(boolean z);
    }

    public ExportAnimationView(Context context) {
        super(context);
        m17743Iu();
    }

    public ExportAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17743Iu();
    }

    public ExportAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17743Iu();
    }

    /* renamed from: Iu */
    private void m17743Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_export_anim_layout, this, true);
        this.cOg = (ImageView) findViewById(R.id.view_bg);
        this.cOi = (RoundedTextView) findViewById(R.id.btn_cancel);
        this.cOj = (TextView) findViewById(R.id.textview_hint);
        this.cOk = (TextView) findViewById(R.id.textview_hint2);
        this.cOl = (TextView) findViewById(R.id.textview_hint3);
        this.cOm = (TextView) findViewById(R.id.textview_hint4);
        this.cOo = findViewById(R.id.textview_hint_layout);
        this.cOn = (TextView) findViewById(R.id.textview_progress);
        this.cOh = (ImageView) findViewById(R.id.imgview_progress);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.vivavideo_upload_succeed_n);
        int O = C4583d.m11670O(getContext(), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
        this.cOp = new C6245f(O, C4583d.m11670O(getContext(), 2), decodeResource, C4583d.m11670O(getContext(), 20));
        this.cOp.setBounds(0, 0, O, O);
        this.cOh.setImageDrawable(this.cOp);
        this.cOr = new SpannableString("%");
        this.cOr.setSpan(new AbsoluteSizeSpan(18, true), 1, 1, 17);
        updateProgress(0);
        this.cOi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ExportAnimationView.this.cOq != null) {
                    ExportAnimationView.this.cOq.alk();
                }
            }
        });
    }

    public void setCancalBtnEnabled(boolean z) {
        this.cOi.setEnabled(z);
    }

    public void setListener(C6195a aVar) {
        this.cOq = aVar;
    }

    public void updateProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new AbsoluteSizeSpan(36, true), 0, spannableString.length(), 17);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString).append(this.cOr);
        this.cOn.setText(spannableStringBuilder);
        this.cOp.setProgress(i);
    }
}
