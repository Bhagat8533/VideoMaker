package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;

public class GradeUpHintView extends RelativeLayout {
    private ImageView bkp;
    private ImageView bkq;
    private TextView bkr;
    private TextView bks;
    /* access modifiers changed from: private */
    public C3769a bkt;

    /* renamed from: com.introvd.template.app.community.usergrade.GradeUpHintView$a */
    public interface C3769a {
        /* renamed from: bD */
        void mo23246bD(View view);

        /* renamed from: bE */
        void mo23247bE(View view);
    }

    public GradeUpHintView(Context context) {
        super(context);
        m9242Iu();
    }

    public GradeUpHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9242Iu();
    }

    public GradeUpHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9242Iu();
    }

    /* renamed from: Iu */
    private void m9242Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.user_gradeup_hint_view, this, true);
        this.bkp = (ImageView) findViewById(R.id.img_gradeup_hint);
        this.bkq = (ImageView) findViewById(R.id.btn_cancel);
        this.bkr = (TextView) findViewById(R.id.textview_grade);
        this.bks = (TextView) findViewById(R.id.btn_new_privilege);
        this.bkq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (GradeUpHintView.this.bkt != null) {
                    GradeUpHintView.this.bkt.mo23246bD(view);
                }
            }
        });
        this.bks.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (GradeUpHintView.this.bkt != null) {
                    GradeUpHintView.this.bkt.mo23247bE(view);
                }
            }
        });
    }

    /* renamed from: gs */
    public void mo23242gs(int i) {
        TextView textView = this.bkr;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        textView.setText(sb.toString());
    }

    public void setOnBtnClickListener(C3769a aVar) {
        this.bkt = aVar;
    }
}
