package com.introvd.template.editor.preview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.preview.adapter.C6548e;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.xyui.RoundCornerImageView;

public class ClipItemView extends RelativeLayout {
    RoundCornerImageView daH;
    TextView daI;
    TextView daJ;
    ImageView daK;
    ImageButton ddV;
    ImageButton ddW;
    ImageButton ddX;
    RelativeLayout ddY;
    RelativeLayout ddZ;
    TextView dea;
    LinearLayout deb;
    private int dec;

    public ClipItemView(Context context) {
        this(context, null);
    }

    public ClipItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dec = -1;
        m19454Oj();
    }

    /* renamed from: Oj */
    private void m19454Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_preview_clip_item_layout, this, true);
        this.daH = (RoundCornerImageView) inflate.findViewById(R.id.item_cover);
        this.ddZ = (RelativeLayout) inflate.findViewById(R.id.rl_item_info);
        this.daI = (TextView) inflate.findViewById(R.id.item_duration);
        this.daK = (ImageView) inflate.findViewById(R.id.iv_item_mask);
        this.ddV = (ImageButton) inflate.findViewById(R.id.item_delete_btn);
        this.ddW = (ImageButton) inflate.findViewById(R.id.item_select_btn);
        this.ddY = (RelativeLayout) inflate.findViewById(R.id.item_focus_layout);
        this.dea = (TextView) inflate.findViewById(R.id.item_multi_select_flag);
        this.daJ = (TextView) inflate.findViewById(R.id.item_order);
        this.deb = (LinearLayout) inflate.findViewById(R.id.transition_entrance_layout);
        this.ddX = (ImageButton) inflate.findViewById(R.id.transition_entrance_btn);
    }

    /* renamed from: b */
    public void mo30077b(int i, ClipItemInfo clipItemInfo, C6548e eVar) {
        if (eVar != null) {
            eVar.mo29861d(this.daH, i);
        }
        this.daK.setVisibility(clipItemInfo.isImage ? 0 : 8);
        this.daI.setText(C4580b.m11637V((long) ((int) clipItemInfo.lDuration)));
        mo30079gS(clipItemInfo.bFocus);
        mo30082oR(clipItemInfo.state);
        if (clipItemInfo.state == 3) {
            this.ddW.setSelected(clipItemInfo.bSelected);
        }
    }

    /* renamed from: gR */
    public void mo30078gR(boolean z) {
        this.ddW.setSelected(z);
    }

    /* renamed from: gS */
    public void mo30079gS(boolean z) {
        this.ddY.setVisibility(z ? 0 : 8);
    }

    /* renamed from: gT */
    public void mo30080gT(boolean z) {
        this.ddX.setAlpha(z ? 1.0f : 0.5f);
    }

    /* renamed from: o */
    public void mo30081o(boolean z, int i) {
        this.daJ.setText(String.valueOf(i));
        this.daJ.setVisibility(z ? 0 : 8);
    }

    /* renamed from: oR */
    public void mo30082oR(int i) {
        switch (i) {
            case 0:
                this.ddZ.setVisibility(0);
                this.ddV.setVisibility(0);
                this.ddW.setVisibility(8);
                this.dea.setVisibility(8);
                return;
            case 1:
                this.ddV.setVisibility(0);
                this.ddZ.setVisibility(0);
                this.dea.setVisibility(8);
                this.ddW.setVisibility(8);
                return;
            case 2:
                this.ddV.setVisibility(0);
                this.dea.setVisibility(0);
                this.ddZ.setVisibility(8);
                this.ddW.setVisibility(8);
                return;
            case 3:
                this.ddZ.setVisibility(0);
                this.ddW.setVisibility(0);
                this.ddV.setVisibility(8);
                this.dea.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: r */
    public void mo30083r(Bitmap bitmap) {
        try {
            if (bitmap.hashCode() != this.dec) {
                this.daH.setImageBitmap(bitmap);
                this.dec = bitmap.hashCode();
            }
        } catch (Exception unused) {
            this.daH.setImageBitmap(bitmap);
        }
    }

    /* renamed from: z */
    public void mo30084z(boolean z, boolean z2) {
        if (z) {
            this.deb.setVisibility(0);
            this.ddX.setImageResource(z2 ? R.drawable.editor_icon_clip_transition : R.drawable.editor_icon_clip_transition_normal);
            return;
        }
        this.deb.setVisibility(8);
        this.ddX.setImageResource(R.drawable.editor_icon_clip_transition_normal);
    }
}
