package com.introvd.template.explorer.music.item;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import java.io.Serializable;

/* renamed from: com.introvd.template.explorer.music.item.c */
public class C7301c implements Serializable {
    private Context context;
    private TemplateAudioCategory dBy;
    private MusicCategoryTabView dBz;
    private Fragment fragment;
    private int musicType;

    public C7301c(Context context2, TemplateAudioCategory templateAudioCategory, Fragment fragment2, int i) {
        this.context = context2;
        this.dBy = templateAudioCategory;
        this.fragment = fragment2;
        this.musicType = i;
    }

    public boolean axr() {
        StringBuilder sb = new StringBuilder();
        sb.append("categoryInfo.copyrightFlag = ");
        sb.append(this.dBy.copyrightFlag);
        LogUtilsV2.m14227d(sb.toString());
        return 1 == this.dBy.copyrightFlag;
    }

    public MusicCategoryTabView axs() {
        if (this.context == null) {
            return null;
        }
        if (this.dBz == null) {
            this.dBz = new MusicCategoryTabView(this.context, this.musicType);
            this.dBz.mo31897aq(getTitle(), this.dBy.coverUrl);
        }
        return this.dBz;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public String getId() {
        if (this.dBy == null) {
            return null;
        }
        return this.dBy.index;
    }

    public String getTitle() {
        if (this.dBy == null) {
            return null;
        }
        return this.dBy.name;
    }
}
