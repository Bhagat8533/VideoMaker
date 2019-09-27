package com.introvd.template.explorer.music.local;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.explorer.p298c.C7141a;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.explorer.music.local.a */
public class C7319a {
    private List<DBTemplateAudioInfo> dCg;
    private C7149c dCh;
    private List<ExtMediaItem> dataList;

    /* renamed from: com.introvd.template.explorer.music.local.a$a */
    private static final class C7321a {
        /* access modifiers changed from: private */
        public static final C7319a dCi = new C7319a();
    }

    private C7319a() {
        this.dataList = new ArrayList();
        this.dCg = new ArrayList();
    }

    public static C7319a axF() {
        return C7321a.dCi;
    }

    /* renamed from: bS */
    private List<DBTemplateAudioInfo> m21597bS(List<ExtMediaItem> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        if (this.dCg == null) {
            this.dCg = new ArrayList();
        } else {
            this.dCg.clear();
        }
        int i = 0;
        for (ExtMediaItem extMediaItem : list) {
            DBTemplateAudioInfo dBTemplateAudioInfo = new DBTemplateAudioInfo();
            dBTemplateAudioInfo.index = String.valueOf(i);
            dBTemplateAudioInfo.categoryId = "-1";
            dBTemplateAudioInfo.audioUrl = extMediaItem.path;
            dBTemplateAudioInfo.musicFilePath = extMediaItem.path;
            dBTemplateAudioInfo.name = extMediaItem.displayTitle;
            dBTemplateAudioInfo.isDownloaded = true;
            dBTemplateAudioInfo.duration = (int) extMediaItem.duration;
            this.dCg.add(dBTemplateAudioInfo);
            i++;
        }
        return new ArrayList(this.dCg);
    }

    /* renamed from: O */
    public List<DBTemplateAudioInfo> mo31944O(Context context, boolean z) {
        if (!z && this.dCg != null && !this.dCg.isEmpty()) {
            return new ArrayList(this.dCg);
        }
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        } else {
            this.dataList.clear();
        }
        this.dCh = new C7149c();
        this.dCh.mo31610a(context, MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, BROWSE_TYPE.AUDIO);
        int groupCount = this.dCh.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            MediaGroupItem qE = this.dCh.mo31620qE(i);
            if (qE != null) {
                Iterator it = qE.mediaItemList.iterator();
                while (it.hasNext()) {
                    ExtMediaItem extMediaItem = (ExtMediaItem) it.next();
                    if (TextUtils.isEmpty(extMediaItem.path) || !extMediaItem.path.contains("/ini/dummy.mp3")) {
                        this.dataList.add(extMediaItem);
                    }
                }
            }
        }
        this.dCh.unInit();
        Collections.sort(this.dataList, new C7141a(1));
        return m21597bS(this.dataList);
    }
}
