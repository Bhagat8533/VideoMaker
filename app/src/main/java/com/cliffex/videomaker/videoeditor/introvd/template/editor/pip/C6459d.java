package com.introvd.template.editor.pip;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.pip.d */
public class C6459d {
    /* access modifiers changed from: private */
    public static final int cXu = C4583d.m11671P(60.0f);
    private static final int cXv = C8572y.m25087dI(C4583d.m11671P(45.0f), 4);
    private static final int cXw = C8572y.m25087dI((C4583d.m11671P(45.0f) * 16) / 9, 4);
    private C8759b bOt;
    /* access modifiers changed from: private */
    public RelativeLayout bWd = null;
    /* access modifiers changed from: private */
    public C6465a cWI;
    /* access modifiers changed from: private */
    public long cXA = 0;
    private View cXB = null;
    /* access modifiers changed from: private */
    public LinearLayout cXx = null;
    private Thread cXy;
    /* access modifiers changed from: private */
    public HashMap<Long, EffectInfoModel> cXz = new HashMap<>();
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.editor.pip.d$a */
    public interface C6465a {
        /* renamed from: a */
        void mo29536a(int i, long j, boolean z);
    }

    public C6459d(RelativeLayout relativeLayout, Handler handler) {
        this.bWd = relativeLayout;
        this.mHandler = handler;
        this.mContext = this.bWd.getContext();
        this.bOt = new C8759b(12);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m18674a(int i, Bitmap bitmap, EffectInfoModel effectInfoModel, final int i2, Context context) {
        int i3;
        View inflate = View.inflate(context, R.layout.editor_pip_style_list_item_layout, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.xiaoying_imagebtn_style_thumb);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_lock_flag);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.imgview_lock_bg);
        final Long valueOf = Long.valueOf(effectInfoModel.mTemplateId);
        if (16 != i2) {
            imageView.setVisibility(8);
            imageView = (ImageView) inflate.findViewById(R.id.xiaoying_imagebtn_style_thumb_16_9);
            imageView.setVisibility(0);
            i3 = (i * 16) / 9;
        } else {
            ((ImageView) inflate.findViewById(R.id.xiaoying_imagebtn_style_thumb_16_9)).setVisibility(8);
            i3 = i;
        }
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        if (effectInfoModel.isbNeedDownload()) {
            imageView2.setVisibility(0);
            imageView3.setVisibility(0);
        } else {
            imageView2.setVisibility(4);
            imageView3.setVisibility(4);
        }
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C6459d.this.m18683cI(view);
                if (C6459d.this.cWI != null) {
                    C6459d.this.cWI.mo29536a(i2, valueOf.longValue(), ((EffectInfoModel) C6459d.this.cXz.get(valueOf)).isbNeedDownload());
                }
            }
        });
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(i3, i);
        } else {
            layoutParams.width = i3;
            layoutParams.height = i;
        }
        inflate.setLayoutParams(layoutParams);
        inflate.setTag(valueOf);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m18675a(int i, boolean z, Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(i);
        float f = z ? 5.0f : 2.0f;
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        int P = C4583d.m11671P(17.0f + f + 1.0f);
        int P2 = C4583d.m11671P(55.0f);
        if (layoutParams == null) {
            layoutParams = new LayoutParams(P, P2);
        } else {
            layoutParams.width = P;
            layoutParams.height = P2;
        }
        imageView.setPadding(C4583d.m11671P(f), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* access modifiers changed from: private */
    /* renamed from: cI */
    public void m18683cI(View view) {
        if (this.cXB != null && !this.cXB.equals(view)) {
            ImageView imageView = (ImageView) this.cXB.findViewById(R.id.xiaoying_pip_stylelist_focus);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        if (view != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.xiaoying_pip_stylelist_focus);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        this.cXB = view;
    }

    /* access modifiers changed from: private */
    /* renamed from: od */
    public void m18688od(final int i) {
        this.bOt.mo35199a(this.mContext, -1, C8762d.aMt().mo35247vn(i), AppStateModel.getInstance().isInChina(), AppStateModel.getInstance().isInIndia());
        int count = this.bOt.getCount();
        if (count > 0) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    View view = null;
                    try {
                        if (i == 16) {
                            view = C6459d.this.m18675a(R.drawable.xiaoying_ve_pip_frame_group2, true, C6459d.this.mContext);
                        } else if (i == 8) {
                            view = C6459d.this.m18675a(R.drawable.xiaoying_ve_pip_frame_group1, true, C6459d.this.mContext);
                        }
                        C6459d.this.cXx.addView(view);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            for (int i2 = 0; i2 < count; i2++) {
                final EffectInfoModel vh = this.bOt.mo35214vh(i2);
                final long j = vh.mTemplateId;
                Bitmap bitmap = null;
                if (i == 16) {
                    bitmap = this.bOt.mo35193N(i2, cXv, cXv);
                } else if (i == 8) {
                    bitmap = this.bOt.mo35193N(i2, cXw, cXv);
                }
                final Bitmap bitmap2 = bitmap;
                Handler handler = this.mHandler;
                final int i3 = i;
                C64633 r3 = new Runnable() {
                    public void run() {
                        if (C6459d.this.mContext != null) {
                            View a = C6459d.this.m18674a(C6459d.cXu, bitmap2, vh, i3, C6459d.this.mContext);
                            C6459d.this.cXx.addView(a);
                            C6459d.this.cXz.put(Long.valueOf(j), vh);
                            if (C6459d.this.cXA == j) {
                                C6459d.this.m18683cI(a);
                            }
                        }
                    }
                };
                handler.post(r3);
            }
        }
    }

    /* renamed from: a */
    public void mo29630a(C6465a aVar) {
        this.cWI = aVar;
    }

    /* renamed from: aC */
    public void mo29631aC(long j) {
        this.cXA = j;
    }

    public void aob() {
        this.bWd = null;
        if (this.cXx != null) {
            this.cXx.removeAllViews();
            this.cXx = null;
        }
        if (this.bOt != null) {
            this.bOt.unInit();
            this.bOt = null;
        }
        if (this.cXy != null) {
            this.cXy.interrupt();
            this.cXy = null;
        }
        this.mContext = null;
        this.cXz = null;
    }

    public void aod() {
        this.cXx = (LinearLayout) this.bWd.findViewById(R.id.linearlayout_tools);
        this.cXz.clear();
        this.cXy = new Thread() {
            public void run() {
                C6459d.this.m18688od(16);
                C6459d.this.m18688od(8);
                if (C4580b.m11666qi()) {
                    C6459d.this.mHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (C6459d.this.bWd != null) {
                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) C6459d.this.bWd.findViewById(R.id.hscrollview_tools);
                                if (horizontalScrollView != null) {
                                    int measuredWidth = horizontalScrollView.getChildAt(0).getMeasuredWidth();
                                    if (measuredWidth != 0) {
                                        horizontalScrollView.scrollTo(measuredWidth, 0);
                                    }
                                }
                            }
                        }
                    }, 500);
                }
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        this.cXy.start();
    }

    /* renamed from: e */
    public void mo29634e(long j, int i) {
        if (this.cXx != null) {
            int childCount = this.cXx.getChildCount();
            View view = null;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.cXx.getChildAt(i2);
                Object tag = childAt.getTag();
                if ((tag instanceof Long) && ((Long) tag).longValue() == j) {
                    view = childAt;
                }
            }
            if (view != null) {
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.download_progress);
                if (progressBar != null) {
                    if (i >= 0) {
                        progressBar.setVisibility(0);
                        progressBar.setProgress(i);
                    } else {
                        progressBar.setProgress(0);
                        progressBar.setVisibility(4);
                    }
                    progressBar.invalidate();
                }
                if (i == -2) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_lock_flag);
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.invalidate();
                    }
                } else {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_lock_flag);
                    if (imageView2 != null) {
                        imageView2.setVisibility(4);
                        imageView2.invalidate();
                    }
                }
                view.invalidate();
            }
            if (i == -1) {
                EffectInfoModel effectInfoModel = (EffectInfoModel) this.cXz.get(Long.valueOf(j));
                if (effectInfoModel != null) {
                    if (effectInfoModel.isbNeedDownload()) {
                        effectInfoModel.setbNeedDownload(false);
                    }
                    effectInfoModel.setDownloading(false);
                }
            } else if (i >= 0 && i < 100) {
                EffectInfoModel effectInfoModel2 = (EffectInfoModel) this.cXz.get(Long.valueOf(j));
                if (effectInfoModel2 != null) {
                    effectInfoModel2.setDownloading(true);
                }
            }
        }
    }
}
