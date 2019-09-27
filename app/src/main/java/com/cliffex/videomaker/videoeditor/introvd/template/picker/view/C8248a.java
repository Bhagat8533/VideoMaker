package com.introvd.template.picker.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.introvd.template.picker.R;
import com.p131c.p132a.p133a.C2564c;

/* renamed from: com.introvd.template.picker.view.a */
public class C8248a extends PopupWindow implements OnClickListener {
    private View dJL;
    private TextView dZI;
    private TextView dZJ;
    private C8249a dZK;

    /* renamed from: com.introvd.template.picker.view.a$a */
    public interface C8249a {
        void azl();

        void azm();
    }

    public C8248a(Context context) {
        super(context);
        this.dJL = LayoutInflater.from(context).inflate(R.layout.picker_scaner_window_layout, null);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(-1));
        setContentView(this.dJL);
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.Picker_Scanner_Window_style);
        init();
    }

    private void init() {
        this.dZI = (TextView) this.dJL.findViewById(R.id.btn_scan_quick);
        this.dZJ = (TextView) this.dJL.findViewById(R.id.btn_scan_custom);
        this.dZI.setOnClickListener(this);
        this.dZJ.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo33402a(C8249a aVar) {
        this.dZK = aVar;
    }

    public void onClick(View view) {
        if (view.equals(this.dZI)) {
            C2564c.m7331dz(view);
            if (this.dZK != null) {
                this.dZK.azl();
            }
            dismiss();
            return;
        }
        C2564c.m7331dz(view);
        if (view.equals(this.dZJ)) {
            if (this.dZK != null) {
                this.dZK.azm();
            }
            dismiss();
        }
    }
}
