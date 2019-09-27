package com.introvd.template.explorer.music.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.explorer.music.MusicBaseFragment;
import com.introvd.template.vivaexplorermodule.R;
import java.io.Serializable;

/* renamed from: com.introvd.template.explorer.music.item.e */
public class C7307e implements Serializable {
    private Context context;
    private String dBT;
    private View dBU;
    private MusicBaseFragment dBV;
    private TextView textView;
    private int title;

    public C7307e(Context context2, int i, MusicBaseFragment musicBaseFragment) {
        this.context = context2;
        this.title = i;
        this.dBV = musicBaseFragment;
    }

    public MusicBaseFragment axC() {
        return this.dBV;
    }

    public String axD() {
        if (this.title == 0) {
            return "";
        }
        if (TextUtils.isEmpty(this.dBT)) {
            this.dBT = this.context.getString(this.title);
        }
        return this.dBT;
    }

    public View axE() {
        if (this.dBU == null) {
            this.dBU = LayoutInflater.from(this.context).inflate(R.layout.xiaoying_music_parent_tab_item_layout, null, true);
            this.textView = (TextView) this.dBU.findViewById(R.id.music_parent_tab_title);
            if (this.title == 0) {
                this.textView.setVisibility(8);
            } else {
                this.textView.setVisibility(0);
                this.textView.setText(axD());
            }
        }
        return this.dBU;
    }
}
