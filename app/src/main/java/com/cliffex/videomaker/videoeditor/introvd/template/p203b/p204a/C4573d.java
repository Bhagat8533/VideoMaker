package com.introvd.template.p203b.p204a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.introvd.template.b.a.d */
public class C4573d extends Handler {
    private final Queue<C4576e> bLu;
    private final LayoutParams bLv;

    /* renamed from: com.introvd.template.b.a.d$a */
    private static class C4575a {
        /* access modifiers changed from: private */
        public static final C4573d bLz = new C4573d();
    }

    private C4573d() {
        this.bLu = new LinkedBlockingQueue();
        this.bLv = new LayoutParams();
    }

    /* renamed from: SD */
    public static C4573d m11591SD() {
        return C4575a.bLz;
    }

    /* renamed from: SE */
    private void m11592SE() {
        if (!this.bLu.isEmpty()) {
            C4576e eVar = (C4576e) this.bLu.poll();
            while (eVar != null) {
                View anchorView = eVar.getAnchorView();
                if (anchorView != null && !m11600ce(anchorView)) {
                    break;
                }
                this.bLu.poll();
                eVar = (C4576e) this.bLu.peek();
            }
            if (eVar != null) {
                if (!eVar.isShowing()) {
                    m11596a(eVar, 109528);
                } else {
                    m11597a(eVar, 109527, m11593a(eVar));
                }
            }
        }
    }

    /* renamed from: a */
    private long m11593a(C4576e eVar) {
        return eVar.mo24856SM() + eVar.mo24855SL();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11596a(C4576e eVar, int i) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = eVar;
        sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11597a(C4576e eVar, int i, long j) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = eVar;
        sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: b */
    private void m11598b(final C4576e eVar) {
        if (!eVar.isShowing()) {
            final View contentView = eVar.getContentView();
            if (!m11600ce(contentView)) {
                try {
                    if (contentView.getParent() == null && !m11600ce(contentView)) {
                        contentView.setVisibility(4);
                        m11604h(eVar).addView(contentView, m11599c(eVar));
                    }
                    contentView.requestLayout();
                    ViewTreeObserver viewTreeObserver = contentView.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                            @TargetApi(16)
                            public void onGlobalLayout() {
                                contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                C4573d.this.m11596a(eVar, 109529);
                                if (!eVar.mo24858SO()) {
                                    C4573d.this.m11597a(eVar, 109530, eVar.mo24856SM() + eVar.mo24853SJ());
                                }
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: c */
    private LayoutParams m11599c(C4576e eVar) {
        if (eVar != null) {
            C4572c SN = eVar.mo24857SN();
            this.bLv.x = SN.getX();
            this.bLv.y = SN.getY();
            this.bLv.type = 1002;
            this.bLv.format = 1;
            this.bLv.width = -1;
            this.bLv.gravity = 51;
            this.bLv.height = -2;
            this.bLv.token = eVar.getAnchorView().getWindowToken();
            this.bLv.flags = eVar.mo24859SP();
            return this.bLv;
        }
        throw new IllegalArgumentException("Toast can't be null");
    }

    /* renamed from: ce */
    private boolean m11600ce(View view) {
        boolean z = true;
        if (view == null) {
            return true;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            z = ((Activity) context).isFinishing();
        }
        return z;
    }

    /* renamed from: d */
    private void m11601d(C4576e eVar) {
        eVar.mo24851SH();
        eVar.getContentView().setVisibility(0);
    }

    /* renamed from: f */
    private void m11602f(C4576e eVar) {
        View contentView = eVar.getContentView();
        if (contentView != null && contentView.getParent() != null) {
            m11604h(eVar).removeView(contentView);
            C4576e eVar2 = (C4576e) this.bLu.poll();
            if (eVar2 != null) {
                eVar2.destroy();
            }
        }
    }

    /* renamed from: g */
    private void m11603g(C4576e eVar) {
        eVar.mo24852SI();
    }

    /* renamed from: h */
    private WindowManager m11604h(C4576e eVar) {
        return (WindowManager) eVar.getContext().getSystemService("window");
    }

    /* renamed from: a */
    public void mo24847a(C4576e eVar, boolean z) {
        if (this.bLu.size() < 1 || z) {
            this.bLu.add(eVar);
            m11592SE();
        }
    }

    /* renamed from: e */
    public void mo24848e(C4576e eVar) {
        View contentView = eVar.getContentView();
        if (contentView != null && contentView.getParent() != null) {
            m11596a(eVar, 109531);
            m11597a(eVar, 109532, eVar.mo24854SK());
            m11597a(eVar, 109527, eVar.mo24854SK());
        }
    }

    public void handleMessage(Message message) {
        C4576e eVar = (C4576e) message.obj;
        switch (message.what) {
            case 109527:
                m11592SE();
                return;
            case 109528:
                m11598b(eVar);
                return;
            case 109529:
                m11601d(eVar);
                return;
            case 109530:
                mo24848e(eVar);
                return;
            case 109531:
                m11603g(eVar);
                return;
            case 109532:
                m11602f(eVar);
                return;
            default:
                return;
        }
    }
}
