package com.introvd.template.gallery.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import com.introvd.template.xygallery.R;

/* renamed from: com.introvd.template.gallery.view.a */
public class C7506a extends PopupWindow implements OnClickListener {
    private View dJL;
    private Button dJM;
    private Button dJN;
    private C7507a dJO;
    private Context mContext;

    /* renamed from: com.introvd.template.gallery.view.a$a */
    public interface C7507a {
        void azl();

        void azm();
    }

    public C7506a(Context context) {
        super(context);
        this.mContext = context;
        this.dJL = LayoutInflater.from(context).inflate(R.layout.gallery_include_scanner, null);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(-1));
        setContentView(this.dJL);
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.Gallery_Scanner_Window_style);
        init();
    }

    private void init() {
        this.dJM = (Button) this.dJL.findViewById(R.id.btn_edit_photo);
        this.dJN = (Button) this.dJL.findViewById(R.id.btn_edit_video);
        this.dJM.setOnClickListener(this);
        this.dJN.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo32291a(C7507a aVar) {
        this.dJO = aVar;
    }

    public void onClick(View view) {
        if (view.equals(this.dJM)) {
            if (this.dJO != null) {
                this.dJO.azl();
            }
            dismiss();
        } else if (view.equals(this.dJN)) {
            if (this.dJO != null) {
                this.dJO.azm();
            }
            dismiss();
        }
    }
}
