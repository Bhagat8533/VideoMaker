package com.introvd.template.app.creation.testb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.R;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p414ui.view.RoundImageView;
import java.util.List;

public class CreationDraftView extends RelativeLayout {
    RelativeLayout bpk;
    RelativeLayout bpl;
    RelativeLayout bpm;
    RoundImageView bpn;
    RoundImageView bpo;
    RoundImageView bpp;
    private Context context;

    public CreationDraftView(Context context2) {
        this(context2, null);
    }

    public CreationDraftView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public CreationDraftView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.creation_draft_view_layout, this, true);
        this.bpk = (RelativeLayout) inflate.findViewById(R.id.draft_item_1);
        this.bpl = (RelativeLayout) inflate.findViewById(R.id.draft_item_2);
        this.bpm = (RelativeLayout) inflate.findViewById(R.id.draft_item_3);
        this.bpn = (RoundImageView) inflate.findViewById(R.id.item_1_cover);
        this.bpo = (RoundImageView) inflate.findViewById(R.id.item_2_cover);
        this.bpp = (RoundImageView) inflate.findViewById(R.id.item_3_cover);
    }

    /* renamed from: S */
    public void mo23335S(List<String> list) {
        if (list.size() <= 0) {
            this.bpk.setVisibility(8);
            this.bpl.setVisibility(8);
            this.bpm.setVisibility(8);
        } else if (list.size() == 1) {
            this.bpk.setVisibility(0);
            this.bpl.setVisibility(8);
            this.bpm.setVisibility(8);
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("file://");
            sb.append((String) list.get(0));
            ImageLoader.loadImage(context2, sb.toString(), (ImageView) this.bpn);
        } else if (list.size() == 2) {
            this.bpk.setVisibility(0);
            this.bpl.setVisibility(0);
            this.bpm.setVisibility(8);
            Context context3 = this.context;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("file://");
            sb2.append((String) list.get(0));
            ImageLoader.loadImage(context3, sb2.toString(), (ImageView) this.bpn);
            Context context4 = this.context;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("file://");
            sb3.append((String) list.get(1));
            ImageLoader.loadImage(context4, sb3.toString(), (ImageView) this.bpo);
        } else {
            this.bpk.setVisibility(0);
            this.bpl.setVisibility(0);
            this.bpm.setVisibility(0);
            Context context5 = this.context;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("file://");
            sb4.append((String) list.get(0));
            ImageLoader.loadImage(context5, sb4.toString(), (ImageView) this.bpn);
            Context context6 = this.context;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("file://");
            sb5.append((String) list.get(1));
            ImageLoader.loadImage(context6, sb5.toString(), (ImageView) this.bpo);
            Context context7 = this.context;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("file://");
            sb6.append((String) list.get(2));
            ImageLoader.loadImage(context7, sb6.toString(), (ImageView) this.bpp);
        }
    }
}
