package com.introvd.template.gallery.storyboard;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import java.util.List;

/* renamed from: com.introvd.template.gallery.storyboard.a */
abstract class C7485a extends BaseAdapter {
    public int bvC = -1;
    public int cEs = -1;
    public int cwZ = -1;
    public LayoutInflater dIk;
    public int dIl = -1;
    public boolean dIm = false;
    public boolean dIn = false;
    private boolean dIo = false;
    public boolean dIp = true;
    public boolean dIq = false;
    public int dIr = -1;
    private boolean dIs = true;
    public Context mContext;
    public Handler mHandler;
    public List<StoryBoardItemInfo> mItemInfoList;

    public C7485a(Context context) {
        this.mContext = context;
        this.dIk = LayoutInflater.from(context);
        int width = (((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - C4583d.m11670O(this.mContext, 13)) / 4;
        this.cEs = width;
        this.bvC = width;
    }

    /* renamed from: H */
    public Animation mo32201H(int i, int i2, int i3) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) i, 1, 0.0f, 0, (float) i2, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset((long) i3);
        return translateAnimation;
    }

    public void azn() {
        if (!this.dIo && this.dIm) {
            this.dIo = true;
        }
        this.dIl = -1;
    }

    public boolean azo() {
        return this.dIp;
    }

    /* renamed from: c */
    public void mo32204c(View view, int i, int i2, int i3) {
        Animation H = i % 4 == 3 ? mo32201H((-i2) * 3, i3, (i - this.dIr) * 10) : mo32201H(i2, 0, (i - this.dIr) * 10);
        H.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (!C7485a.this.dIq) {
                    C7485a.this.dIq = true;
                    C7485a.this.mHandler.sendMessageDelayed(C7485a.this.mHandler.obtainMessage(12291), 400);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(H);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        return;
     */
    /* renamed from: dj */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo32205dj(int r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 < 0) goto L_0x0057
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r0 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            int r0 = r0.size()     // Catch:{ all -> 0x0054 }
            if (r4 >= r0) goto L_0x0057
            if (r5 < 0) goto L_0x0057
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r0 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            int r0 = r0.size()     // Catch:{ all -> 0x0054 }
            if (r5 < r0) goto L_0x0016
            goto L_0x0057
        L_0x0016:
            r3.dIl = r5     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r3.getItem(r4)     // Catch:{ all -> 0x0054 }
            if (r4 >= r5) goto L_0x002d
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r1 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            int r2 = r5 + 1
            com.introvd.template.sdk.model.editor.StoryBoardItemInfo r0 = (com.introvd.template.sdk.model.editor.StoryBoardItemInfo) r0     // Catch:{ all -> 0x0054 }
            r1.add(r2, r0)     // Catch:{ all -> 0x0054 }
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r0 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            r0.remove(r4)     // Catch:{ all -> 0x0054 }
            goto L_0x003b
        L_0x002d:
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r1 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            com.introvd.template.sdk.model.editor.StoryBoardItemInfo r0 = (com.introvd.template.sdk.model.editor.StoryBoardItemInfo) r0     // Catch:{ all -> 0x0054 }
            r1.add(r5, r0)     // Catch:{ all -> 0x0054 }
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r0 = r3.mItemInfoList     // Catch:{ all -> 0x0054 }
            int r1 = r4 + 1
            r0.remove(r1)     // Catch:{ all -> 0x0054 }
        L_0x003b:
            r0 = 1
            r3.dIm = r0     // Catch:{ all -> 0x0054 }
            android.os.Handler r0 = r3.mHandler     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x004f
            android.os.Handler r0 = r3.mHandler     // Catch:{ all -> 0x0054 }
            android.os.Handler r1 = r3.mHandler     // Catch:{ all -> 0x0054 }
            r2 = 12289(0x3001, float:1.722E-41)
            android.os.Message r4 = r1.obtainMessage(r2, r4, r5)     // Catch:{ all -> 0x0054 }
            r0.sendMessage(r4)     // Catch:{ all -> 0x0054 }
        L_0x004f:
            r3.notifyDataSetChanged()     // Catch:{ all -> 0x0054 }
            monitor-exit(r3)
            return
        L_0x0054:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0057:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.storyboard.C7485a.mo32205dj(int, int):void");
    }

    public int getCount() {
        if (this.mItemInfoList == null) {
            return 0;
        }
        if (this.mItemInfoList.size() > 0 && this.cwZ == -1) {
            this.cwZ = 0;
        }
        return this.mItemInfoList.size();
    }

    public int getFocusIndex() {
        return this.cwZ;
    }

    public abstract Object getItem(int i);

    /* renamed from: il */
    public void mo32209il(boolean z) {
        this.dIn = z;
    }

    /* renamed from: im */
    public void mo32210im(boolean z) {
        this.dIp = z;
    }

    /* renamed from: in */
    public void mo32211in(boolean z) {
        this.dIq = z;
    }

    /* renamed from: io */
    public void mo32212io(boolean z) {
        this.dIs = z;
    }

    /* renamed from: rA */
    public void mo32213rA(int i) {
        this.bvC = i;
    }

    /* renamed from: rB */
    public void mo32214rB(int i) {
        this.cEs = i;
    }

    /* renamed from: rx */
    public int mo32215rx(int i) {
        return i;
    }

    /* renamed from: ry */
    public void mo32216ry(int i) {
        this.cwZ = i;
    }

    /* renamed from: rz */
    public void mo32217rz(int i) {
        this.dIr = i;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void setList(List<StoryBoardItemInfo> list) {
        this.mItemInfoList = list;
    }
}
