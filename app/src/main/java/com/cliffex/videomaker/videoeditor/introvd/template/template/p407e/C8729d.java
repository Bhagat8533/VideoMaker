package com.introvd.template.template.p407e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.template.R;

/* renamed from: com.introvd.template.template.e.d */
public class C8729d {
    private View bwy;
    private TextView esE;
    private TextView esF;
    private View esG;
    private View esH;
    /* access modifiers changed from: private */
    public C8732a esI;
    private Context mContext;

    /* renamed from: com.introvd.template.template.e.d$a */
    public interface C8732a {
        void aLb();

        void aLc();
    }

    public C8729d(Context context, View view, C8732a aVar) {
        this.mContext = context;
        this.bwy = view;
        this.esI = aVar;
        init();
    }

    /* access modifiers changed from: private */
    public void aLY() {
        this.esF.setTextColor(this.mContext.getResources().getColor(R.color.color_bdbdbd));
        this.esE.setTextColor(this.mContext.getResources().getColor(R.color.color_ff774e));
        this.esH.setVisibility(4);
        this.esG.setVisibility(0);
    }

    private void init() {
        if (this.bwy != null && this.mContext != null) {
            this.esE = (TextView) this.bwy.findViewById(R.id.left_button);
            this.esF = (TextView) this.bwy.findViewById(R.id.right_button);
            this.esG = this.bwy.findViewById(R.id.left_line);
            this.esH = this.bwy.findViewById(R.id.right_line);
            if (this.esF != null) {
                this.esF.setTextColor(this.mContext.getResources().getColor(R.color.color_bdbdbd));
                this.esH.setVisibility(4);
            }
            if (this.esE != null) {
                this.esE.setTextColor(this.mContext.getResources().getColor(R.color.color_ff774e));
                this.esG.setVisibility(0);
            }
            if (this.esI != null) {
                if (this.esE != null) {
                    this.esE.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            C8729d.this.aLY();
                            C8729d.this.esI.aLc();
                        }
                    });
                }
                if (this.esF != null) {
                    this.esF.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            C8729d.this.aLZ();
                            C8729d.this.esI.aLb();
                        }
                    });
                }
            }
        }
    }

    public void aLZ() {
        this.esE.setTextColor(this.mContext.getResources().getColor(R.color.color_bdbdbd));
        this.esF.setTextColor(this.mContext.getResources().getColor(R.color.color_ff774e));
        this.esH.setVisibility(0);
        this.esG.setVisibility(4);
    }
}
