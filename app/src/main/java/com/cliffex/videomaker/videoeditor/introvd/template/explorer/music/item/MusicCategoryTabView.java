package com.introvd.template.explorer.music.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.vivaexplorermodule.R;

@SuppressLint({"ViewConstructor"})
public class MusicCategoryTabView extends RelativeLayout {
    TextView dhx;
    ImageView dhy;
    private int musicType;

    public MusicCategoryTabView(Context context, int i) {
        super(context);
        this.musicType = i;
        init();
    }

    private void init() {
        if (this.musicType != 1) {
            LayoutInflater.from(getContext()).inflate(R.layout.explorer_music_child_tab_item_layout_default, this, true);
            this.dhx = (TextView) findViewById(R.id.music_child_tab_title);
            return;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.xiaoying_music_child_tab_item_layout, this, true);
        this.dhx = (TextView) findViewById(R.id.music_child_tab_title);
        this.dhy = (ImageView) findViewById(R.id.music_child_tab_icon);
        this.dhy.setVisibility(0);
        this.dhy.setAlpha(0.5f);
    }

    /* renamed from: aq */
    public void mo31897aq(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.dhx.setText(str);
        }
        if (this.dhy != null && !TextUtils.isEmpty(str2)) {
            ImageLoader.loadImage(getContext(), str2, this.dhy);
        }
    }

    public void setSelect(boolean z) {
        if (this.dhy != null) {
            this.dhy.setAlpha(z ? 1.0f : 0.5f);
        }
        this.dhx.getPaint().setFakeBoldText(z);
    }
}
