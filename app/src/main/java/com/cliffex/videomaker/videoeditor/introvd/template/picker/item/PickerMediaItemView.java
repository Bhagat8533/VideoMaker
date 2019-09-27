package com.introvd.template.picker.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.picker.C8186b;
import com.introvd.template.picker.R;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p369d.C8217a;

public class PickerMediaItemView extends RelativeLayout {
    private ImageView dZr;
    private View dZs;
    private ImageButton dZt;
    private TextView dZu;
    private TextView ddh;

    public PickerMediaItemView(Context context) {
        this(context, null);
    }

    public PickerMediaItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PickerMediaItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.picker_media_item_layout, this, true);
        this.dZr = (ImageView) inflate.findViewById(R.id.iv_thumb);
        this.dZs = inflate.findViewById(R.id.item_foucs_bg);
        this.dZt = (ImageButton) inflate.findViewById(R.id.btn_item_status);
        this.ddh = (TextView) inflate.findViewById(R.id.duration);
        this.dZu = (TextView) inflate.findViewById(R.id.select_count);
    }

    /* renamed from: a */
    public void mo33381a(C8215c cVar) {
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.aFD())) {
                ImageLoader.loadImage(getContext(), cVar.aFD(), this.dZr);
            } else {
                this.dZr.setImageResource(R.drawable.xiaoying_com_default_pic_bg);
            }
            if (cVar.getDuration() > 0) {
                this.ddh.setVisibility(0);
                this.ddh.setText(C4580b.m11658eD(C4580b.m11637V((long) cVar.getDuration())));
            } else {
                this.ddh.setVisibility(8);
            }
            mo33385mD(cVar.aFK());
            mo33384mC(cVar.aFK());
            if (cVar.getSourceType() == 0) {
                mo33382an(C8186b.aFr().mo33300mr(cVar.aFK()), false);
            }
        }
    }

    /* renamed from: an */
    public void mo33382an(int i, boolean z) {
        if (i > 0) {
            if (!this.dZu.isShown()) {
                this.dZu.setVisibility(0);
            }
            TextView textView = this.dZu;
            StringBuilder sb = new StringBuilder();
            sb.append("x");
            sb.append(i);
            textView.setText(sb.toString());
            if (z) {
                C8217a.m23731dm(this.dZu).start();
            }
        }
    }

    public View getStatusBtn() {
        return this.dZt;
    }

    /* renamed from: mC */
    public void mo33384mC(String str) {
        this.dZt.setSelected(C8186b.aFr().mo33298mp(str));
    }

    /* renamed from: mD */
    public void mo33385mD(String str) {
        this.dZs.setVisibility(C8186b.aFr().mo33299mq(str) ? 0 : 8);
    }

    public void setStatusBtnClickListener(OnClickListener onClickListener) {
        this.dZt.setOnClickListener(onClickListener);
    }

    /* renamed from: y */
    public boolean mo33387y(int i, String str) {
        this.dZt.setSelected(!this.dZt.isSelected());
        if (this.dZt.isSelected()) {
            if (i == 0) {
                mo33382an(1, true);
            }
            C8186b.aFr().mo33295mm(str);
            return true;
        }
        this.dZu.setText("x1");
        this.dZu.setVisibility(8);
        C8186b.aFr().mo33296mn(str);
        return false;
    }
}
