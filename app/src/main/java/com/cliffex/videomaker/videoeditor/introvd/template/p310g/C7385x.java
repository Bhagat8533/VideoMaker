package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.p009a.C0165a;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.VideoInfo;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.x */
public class C7385x extends C7384w {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.viewDivider, 7);
    }

    public C7385x(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, bpZ, bqa));
    }

    private C7385x(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (DynamicLoadingImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[6], (RoundedTextView) objArr[3], (RoundedTextView) objArr[4], (View) objArr[7]);
        this.bqb = -1;
        this.cpr.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cqv.setTag(null);
        this.cqr.setTag(null);
        this.cqw.setTag(null);
        this.cqx.setTag(null);
        this.cqy.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: a */
    public void mo32015a(VideoInfo videoInfo) {
        this.cqz = videoInfo;
        synchronized (this) {
            this.bqb |= 1;
        }
        notifyPropertyChanged(C4672d.info);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String str;
        CharSequence charSequence4;
        String str2;
        synchronized (this) {
            j = this.bqb;
            this.bqb = 0;
        }
        VideoInfo videoInfo = this.cqz;
        int i2 = 0;
        String str3 = null;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (videoInfo != null) {
                charSequence3 = videoInfo.formatWatchCount();
                String formatUserName = videoInfo.formatUserName();
                String keyword = videoInfo.getKeyword(1);
                charSequence = videoInfo.getKeyword(0);
                str2 = videoInfo.getCoverUrl();
                String str4 = keyword;
                charSequence2 = videoInfo.getTitle();
                charSequence4 = formatUserName;
                str3 = str4;
            } else {
                charSequence4 = null;
                charSequence3 = null;
                charSequence2 = null;
                charSequence = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            boolean isEmpty2 = TextUtils.isEmpty(charSequence);
            if (i3 != 0) {
                j = isEmpty ? j | 8 : j | 4;
            }
            if ((j & 3) != 0) {
                j = isEmpty2 ? j | 32 : j | 16;
            }
            i = isEmpty ? 8 : 0;
            if (isEmpty2) {
                i2 = 8;
            }
            str = str3;
            str3 = str2;
        } else {
            charSequence4 = null;
            str = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
            i = 0;
        }
        if ((j & 3) != 0) {
            C7387z.m21770b(this.cpr, str3);
            C0165a.m348a(this.cqv, charSequence2);
            C0165a.m348a(this.cqr, charSequence3);
            C0165a.m348a(this.cqw, charSequence4);
            C0165a.m348a((TextView) this.cqx, charSequence);
            this.cqx.setVisibility(i2);
            C0165a.m348a((TextView) this.cqy, (CharSequence) str);
            this.cqy.setVisibility(i);
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 2;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.info != i) {
            return false;
        }
        mo32015a((VideoInfo) obj);
        return true;
    }
}
