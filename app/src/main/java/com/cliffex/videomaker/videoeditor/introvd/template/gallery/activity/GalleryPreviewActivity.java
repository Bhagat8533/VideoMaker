package com.introvd.template.gallery.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.view.PagerAdapter;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.explorer.p299d.C7157a;
import com.introvd.template.explorer.p299d.C7157a.C7162c;
import com.introvd.template.gallery.C7431b;
import com.introvd.template.gallery.model.ImgPreviewDataItem;
import com.introvd.template.gallery.view.TouchImageView;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sns.SnsType;
import com.introvd.template.sns.gallery.ISnsGallery;
import com.introvd.template.xygallery.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p503cz.msebera.android.httpclient.HttpHost;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/MediaGallery/picpreview")
public class GalleryPreviewActivity extends FragmentActivity {
    /* access modifiers changed from: private */

    /* renamed from: K */
    public Handler f3542K = new C7399b(this);
    private C8522g bMM;
    private long bMw;
    private C8501a bOK;
    /* access modifiers changed from: private */
    public RelativeLayout cWp;
    /* access modifiers changed from: private */
    public ImageButton cXp = null;
    /* access modifiers changed from: private */
    public OnCheckedChangeListener cXs = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (GalleryPreviewActivity.this.dFD.intValue() >= 0) {
                GalleryPreviewActivity.this.m21810ig(z);
                GalleryPreviewActivity.this.f3542K.sendEmptyMessage(10020);
            }
        }
    };
    private int csj;
    private C5530d csp;
    /* access modifiers changed from: private */
    public ArrayList<ImgPreviewDataItem> dEq;
    /* access modifiers changed from: private */
    public Integer dFD = Integer.valueOf(-1);
    private MSize dFE;
    private boolean dFF = false;
    /* access modifiers changed from: private */
    public ArrayList<Integer> dFG = null;
    /* access modifiers changed from: private */
    public SparseArray<C7401c> dFH = null;
    /* access modifiers changed from: private */
    public View dFI;
    /* access modifiers changed from: private */
    public RelativeLayout dFJ;
    /* access modifiers changed from: private */
    public RelativeLayout dFK;
    /* access modifiers changed from: private */
    public CheckBox dFL;
    /* access modifiers changed from: private */
    public Button dFM;
    /* access modifiers changed from: private */
    public ImgPreviewDataItem dFN;
    /* access modifiers changed from: private */
    public boolean dFO;
    /* access modifiers changed from: private */
    public boolean dFP;
    C7157a dFQ = C7157a.m21184fY(this);
    /* access modifiers changed from: private */
    public boolean dFR = false;
    private boolean dFS = false;
    private OnPageChangeListener dFT = new OnPageChangeListener() {
        public void onPageScrollStateChanged(int i) {
            LogUtils.m14223i("GalleryPreviewActivity", "mPager onPageScrollStateChanged");
        }

        public void onPageScrolled(int i, float f, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPager onPageScrolled positionOffset=");
            sb.append(f);
            sb.append(";positionOffsetPixels=");
            sb.append(i2);
            LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
            if (GalleryPreviewActivity.this.dEq != null && GalleryPreviewActivity.this.dFI != null && GalleryPreviewActivity.this.dFD.intValue() >= 0 && GalleryPreviewActivity.this.dFD.intValue() < GalleryPreviewActivity.this.dEq.size()) {
                ImgPreviewDataItem imgPreviewDataItem = (ImgPreviewDataItem) GalleryPreviewActivity.this.dEq.get(GalleryPreviewActivity.this.dFD.intValue());
                if (imgPreviewDataItem != null && GalleryPreviewActivity.this.dFI != null && (GalleryPreviewActivity.this.dFI instanceof TouchImageView) && imgPreviewDataItem.isImage.booleanValue()) {
                    TouchImageView touchImageView = (TouchImageView) GalleryPreviewActivity.this.dFI;
                    if (touchImageView != null) {
                        touchImageView.azA();
                        touchImageView.postInvalidate();
                    }
                }
            }
        }

        public void onPageSelected(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPager onPageSelected itemIndex=");
            sb.append(i);
            LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
            Message obtainMessage = GalleryPreviewActivity.this.f3542K.obtainMessage(10301);
            obtainMessage.arg1 = i;
            GalleryPreviewActivity.this.f3542K.sendMessage(obtainMessage);
        }
    };
    private ImageView djE;
    /* access modifiers changed from: private */
    public boolean dlM = false;
    private PagerAdapter mAdapter;
    private ViewPager mPager;
    /* access modifiers changed from: private */

    /* renamed from: po */
    public OnClickListener f3543po = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                if (view.getId() == R.id.btn_back) {
                    GalleryPreviewActivity.this.f3542K.sendEmptyMessage(10012);
                } else if (view.equals(GalleryPreviewActivity.this.dFM)) {
                    GalleryPreviewActivity.this.dFR = false;
                    if (GalleryPreviewActivity.this.dFG == null || GalleryPreviewActivity.this.dEq == null) {
                        GalleryPreviewActivity.this.setResult(0);
                        GalleryPreviewActivity.this.finish();
                    } else {
                        GalleryPreviewActivity.this.ayt();
                    }
                } else if (view.equals(GalleryPreviewActivity.this.cXp)) {
                    UserBehaviorLog.onKVEvent(GalleryPreviewActivity.this, "Gallery_AddPhoto_Rotate", new HashMap());
                    GalleryPreviewActivity.this.ayx();
                } else if (view.equals(GalleryPreviewActivity.this.dFL) && !C4600l.m11739k(GalleryPreviewActivity.this, false) && GalleryPreviewActivity.this.dFN != null) {
                    if (TextUtils.isEmpty(GalleryPreviewActivity.this.dFQ.mo31632a(GalleryPreviewActivity.this.dFN.mRawFilePath, 0, GalleryPreviewActivity.this.dFN.snsType == SnsType.SNS_TYPE_FACEBOOK ? 28 : 31, null))) {
                        GalleryPreviewActivity.this.dFL.setChecked(false);
                        ToastUtils.show((Context) GalleryPreviewActivity.this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                    }
                }
            }
        }
    };

    /* renamed from: com.introvd.template.gallery.activity.GalleryPreviewActivity$a */
    private class C7397a extends PagerAdapter {
        C7397a() {
        }

        /* renamed from: cU */
        private void m21829cU(View view) {
            if (view instanceof TouchImageView) {
                StringBuilder sb = new StringBuilder();
                sb.append("setPrimaryItem run width=");
                sb.append(GalleryPreviewActivity.this.dFI.getWidth());
                sb.append(";height=");
                sb.append(GalleryPreviewActivity.this.dFI.getHeight());
                LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
                TouchImageView touchImageView = (TouchImageView) view;
                Drawable drawable = touchImageView.getDrawable();
                if (drawable != null) {
                    if (drawable instanceof TransitionDrawable) {
                        TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                        drawable = transitionDrawable.getDrawable(transitionDrawable.getNumberOfLayers() - 1);
                    }
                    if (drawable instanceof BitmapDrawable) {
                        touchImageView.setImageDrawable(drawable);
                        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                        if (bitmap != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("setPrimaryItem run2 width=");
                            sb2.append(bitmap.getWidth());
                            sb2.append(";height=");
                            sb2.append(bitmap.getHeight());
                            LogUtils.m14223i("GalleryPreviewActivity", sb2.toString());
                        }
                    }
                }
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof TouchImageView) {
                ((TouchImageView) obj).uninit();
            }
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            if (GalleryPreviewActivity.this.dEq == null) {
                return 0;
            }
            return GalleryPreviewActivity.this.dEq.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00a4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object instantiateItem(android.view.ViewGroup r5, int r6) {
            /*
                r4 = this;
                java.lang.String r0 = "GalleryPreviewActivity"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "instantiateItem run position="
                r1.append(r2)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                com.introvd.template.common.LogUtils.m14223i(r0, r1)
                if (r6 < 0) goto L_0x00a1
                com.introvd.template.gallery.activity.GalleryPreviewActivity r0 = com.introvd.template.gallery.activity.GalleryPreviewActivity.this
                java.util.ArrayList r0 = r0.dEq
                int r0 = r0.size()
                if (r6 >= r0) goto L_0x00a1
                com.introvd.template.gallery.activity.GalleryPreviewActivity r0 = com.introvd.template.gallery.activity.GalleryPreviewActivity.this
                java.util.ArrayList r0 = r0.dEq
                java.lang.Object r0 = r0.get(r6)
                com.introvd.template.gallery.model.ImgPreviewDataItem r0 = (com.introvd.template.gallery.model.ImgPreviewDataItem) r0
                java.lang.String r1 = r0.mRawFilePath
                int r1 = com.introvd.template.common.MediaFileUtils.GetFileMediaType(r1)
                boolean r1 = com.introvd.template.common.MediaFileUtils.IsImageFileType(r1)
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                r0.isImage = r2
                if (r1 != 0) goto L_0x004c
                java.lang.String r1 = r0.mRawFilePath
                java.lang.String r2 = "http"
                boolean r1 = r1.startsWith(r2)
                if (r1 == 0) goto L_0x00a1
            L_0x004c:
                com.introvd.template.gallery.activity.GalleryPreviewActivity$a$1 r1 = new com.introvd.template.gallery.activity.GalleryPreviewActivity$a$1
                r1.<init>()
                com.introvd.template.gallery.view.TouchImageView r2 = new com.introvd.template.gallery.view.TouchImageView
                android.content.Context r3 = r5.getContext()
                r2.<init>(r3)
                r3 = 0
                r2.setCropViewEnable(r3)
                r2.setOnClickListener(r1)
                r1 = -1
                r5.addView(r2, r1, r1)
                com.introvd.template.gallery.activity.GalleryPreviewActivity r5 = com.introvd.template.gallery.activity.GalleryPreviewActivity.this     // Catch:{ Exception -> 0x0085 }
                android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x0085 }
                com.c.a.e r5 = com.p131c.p132a.C2570b.m7336hy(r5)     // Catch:{ Exception -> 0x0085 }
                java.lang.String r0 = r0.mRawFilePath     // Catch:{ Exception -> 0x0085 }
                com.c.a.d r5 = r5.mo12195aO(r0)     // Catch:{ Exception -> 0x0085 }
                int r0 = com.introvd.template.xygallery.R.drawable.xiaoying_com_default_pic_bg     // Catch:{ Exception -> 0x0085 }
                com.c.a.d r5 = r5.mo12874wp(r0)     // Catch:{ Exception -> 0x0085 }
                int r0 = com.introvd.template.xygallery.R.drawable.xiaoying_com_default_pic_bg     // Catch:{ Exception -> 0x0085 }
                com.c.a.d r5 = r5.mo12875wq(r0)     // Catch:{ Exception -> 0x0085 }
                r5.mo12186g(r2)     // Catch:{ Exception -> 0x0085 }
                goto L_0x00a2
            L_0x0085:
                r5 = move-exception
                java.lang.String r0 = "GalleryPreviewActivity"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "error:"
                r1.append(r3)
                java.lang.String r5 = r5.getMessage()
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                com.introvd.template.common.LogUtils.m14222e(r0, r5)
                goto L_0x00a2
            L_0x00a1:
                r2 = 0
            L_0x00a2:
                if (r2 == 0) goto L_0x00ab
                java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
                r2.setTag(r5)
            L_0x00ab:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.activity.GalleryPreviewActivity.C7397a.instantiateItem(android.view.ViewGroup, int):java.lang.Object");
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void setPrimaryItem(View view, int i, Object obj) {
            StringBuilder sb = new StringBuilder();
            sb.append("setPrimaryItem run position=");
            sb.append(i);
            LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
            GalleryPreviewActivity.this.dFI = (View) obj;
            m21829cU(GalleryPreviewActivity.this.dFI);
        }
    }

    /* renamed from: com.introvd.template.gallery.activity.GalleryPreviewActivity$b */
    private static class C7399b extends Handler {
        private WeakReference<GalleryPreviewActivity> dFW = null;

        public C7399b(GalleryPreviewActivity galleryPreviewActivity) {
            this.dFW = new WeakReference<>(galleryPreviewActivity);
        }

        public void handleMessage(Message message) {
            final GalleryPreviewActivity galleryPreviewActivity = (GalleryPreviewActivity) this.dFW.get();
            if (galleryPreviewActivity != null) {
                switch (message.what) {
                    case ISnsGallery.VIDEO_MODE /*5633*/:
                        final String str = (String) message.obj;
                        if (C4600l.m11739k(galleryPreviewActivity, true)) {
                            C4586g.m11705a((Context) galleryPreviewActivity, "0%", (OnCancelListener) new OnCancelListener() {
                                public void onCancel(DialogInterface dialogInterface) {
                                    C7157a.m21184fY(galleryPreviewActivity).mo31634jm(str);
                                    galleryPreviewActivity.dFL.setChecked(false);
                                }
                            }, true);
                            break;
                        }
                        break;
                    case ISnsGallery.IMAGE_MODE /*5634*/:
                        StringBuilder sb = new StringBuilder();
                        sb.append(message.arg1);
                        sb.append("%");
                        C4586g.m11713eJ(sb.toString());
                        break;
                    case 5635:
                        if (!galleryPreviewActivity.isFinishing()) {
                            C4586g.m11713eJ("100%");
                            C4586g.m11696Sm();
                        }
                        if (galleryPreviewActivity.dFM != null && galleryPreviewActivity.dFR) {
                            galleryPreviewActivity.dFM.performClick();
                            break;
                        }
                    case 5636:
                        if (!galleryPreviewActivity.isFinishing()) {
                            C4586g.m11696Sm();
                            ToastUtils.show((Context) galleryPreviewActivity, R.string.xiaoying_str_com_msg_network_inactive, 1);
                            break;
                        }
                        break;
                    case 10012:
                        galleryPreviewActivity.ayv();
                        break;
                    case 10020:
                        if (galleryPreviewActivity.dFG.size() <= 0) {
                            galleryPreviewActivity.dFM.setText(galleryPreviewActivity.getString(R.string.xiaoying_str_ve_trim_confirm_btn_title));
                            break;
                        } else {
                            int i = R.string.xiaoying_str_ve_gallery_preview_ok_cnt;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("");
                            sb2.append(galleryPreviewActivity.dFG.size());
                            galleryPreviewActivity.dFM.setText(galleryPreviewActivity.getString(i, new Object[]{sb2.toString()}));
                            break;
                        }
                    case 10021:
                        galleryPreviewActivity.dFJ.setVisibility(0);
                        galleryPreviewActivity.dFM.setVisibility(0);
                        if (galleryPreviewActivity.dFP || galleryPreviewActivity.dFO) {
                            galleryPreviewActivity.dFL.setVisibility(8);
                            galleryPreviewActivity.cXp.setVisibility(8);
                        } else {
                            galleryPreviewActivity.dFL.setVisibility(0);
                            galleryPreviewActivity.cXp.setVisibility(0);
                        }
                        galleryPreviewActivity.dFL.setOnCheckedChangeListener(galleryPreviewActivity.cXs);
                        if (galleryPreviewActivity.dFG == null) {
                            galleryPreviewActivity.dFG = new ArrayList();
                        }
                        if (galleryPreviewActivity.dFH == null) {
                            galleryPreviewActivity.dFH = new SparseArray();
                        }
                        galleryPreviewActivity.dFM.setOnClickListener(galleryPreviewActivity.f3543po);
                        galleryPreviewActivity.cXp.setOnClickListener(galleryPreviewActivity.f3543po);
                        sendEmptyMessage(10020);
                        break;
                    case 10210:
                        if (!(galleryPreviewActivity.dEq != null && galleryPreviewActivity.dFD.intValue() >= 0 && galleryPreviewActivity.dFD.intValue() < galleryPreviewActivity.dEq.size())) {
                            sendEmptyMessage(101211);
                            break;
                        } else {
                            C4562a.m11533a(galleryPreviewActivity.dFK, false, true, 0);
                            C4562a.m11534b(galleryPreviewActivity.cWp, false, true, 0);
                            break;
                        }
                        break;
                    case 10301:
                        galleryPreviewActivity.m21820rf(message.arg1);
                        break;
                    case 66080:
                        if (!galleryPreviewActivity.dlM) {
                            sendEmptyMessageDelayed(66080, 200);
                            break;
                        }
                        break;
                    case 101211:
                        C4562a.m11533a(galleryPreviewActivity.dFK, true, true, 0);
                        C4562a.m11534b(galleryPreviewActivity.cWp, true, true, 0);
                        break;
                    case 101310:
                        if (galleryPreviewActivity.dFK.getVisibility() != 0) {
                            sendEmptyMessageDelayed(101211, 50);
                            break;
                        } else {
                            sendEmptyMessageDelayed(10210, 50);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.gallery.activity.GalleryPreviewActivity$c */
    private class C7401c {
        public RectF cropRect;
        public RectF dFZ;
        public boolean dGa;
        public float rotation;

        private C7401c() {
        }
    }

    /* renamed from: a */
    private void m21797a(View view, ImgPreviewDataItem imgPreviewDataItem) {
        if (view instanceof TouchImageView) {
            TouchImageView touchImageView = (TouchImageView) view;
            touchImageView.azA();
            touchImageView.invalidate();
        }
    }

    private void ayr() {
        this.mPager = (ViewPager) findViewById(R.id.pager_clips);
        this.mPager.addOnPageChangeListener(this.dFT);
        this.mAdapter = new C7397a();
        this.mPager.setAdapter(this.mAdapter);
        int count = this.mAdapter.getCount();
        this.mPager.setOffscreenPageLimit(3);
        int i = count - 1;
        if (this.dFD.intValue() < 0 || this.dFD.intValue() >= i) {
            this.dFD = Integer.valueOf(i);
        }
        this.mPager.setCurrentItem(this.dFD.intValue(), false);
        this.mPager.setPageMargin(C4583d.m11671P(0.0f));
        this.mAdapter.notifyDataSetChanged();
        this.mPager.setOnClickListener(this.f3543po);
    }

    private void ays() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        MSize mSize = new MSize(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        this.dFE = new MSize(mSize.width, mSize.height);
    }

    /* access modifiers changed from: private */
    public void ayt() {
        if (this.dFG.size() < 1) {
            this.dFR = true;
            m21810ig(true);
            if (this.dFS) {
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.dFG.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (this.dEq != null && this.dEq.size() > intValue) {
                arrayList.add((ImgPreviewDataItem) this.dEq.get(intValue));
            }
        }
        Intent intent = new Intent();
        intent.putExtra(MediaGalleryRouter.INTENT_IMAGE_LIST_KEY, arrayList);
        setResult(-1, intent);
        finish();
    }

    private void ayu() {
        if (this.mAdapter != null && this.mPager != null) {
            if (this.dFD.intValue() >= 0 && this.dFD.intValue() < this.dEq.size()) {
                ImgPreviewDataItem imgPreviewDataItem = (ImgPreviewDataItem) this.dEq.get(this.dFD.intValue());
                if (!(imgPreviewDataItem == null || this.dFI == null || !imgPreviewDataItem.isImage.booleanValue())) {
                    m21797a(this.dFI, imgPreviewDataItem);
                }
            }
            int childCount = this.mPager.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mPager.getChildAt(i);
                if (childAt != null && !childAt.equals(this.dFI)) {
                    int intValue = ((Integer) childAt.getTag()).intValue();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onConfigurationChanged position=");
                    sb.append(intValue);
                    LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
                    ImgPreviewDataItem imgPreviewDataItem2 = (ImgPreviewDataItem) this.dEq.get(intValue);
                    if (imgPreviewDataItem2 != null && imgPreviewDataItem2.isImage.booleanValue()) {
                        m21797a(childAt, imgPreviewDataItem2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void ayv() {
        finish();
    }

    private void ayw() {
        TextView textView = (TextView) findViewById(R.id.txtview_curindex);
        TextView textView2 = (TextView) findViewById(R.id.txtview_count);
        if (this.mPager != null) {
            int currentItem = this.mPager.getCurrentItem() + 1;
            if (this.dEq != null && this.dEq.size() == 0) {
                currentItem = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(currentItem);
            textView.setText(sb.toString());
            if (this.dEq != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(this.dEq.size());
                textView2.setText(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void ayx() {
        if (this.dFI != null && (this.dFI instanceof TouchImageView) && this.dEq != null) {
            TouchImageView touchImageView = (TouchImageView) this.dFI;
            float rotation = (touchImageView.getRotation() + 90.0f) % 360.0f;
            touchImageView.setRotation(rotation);
            C7401c cVar = (C7401c) this.dFH.get(this.dFD.intValue());
            if (cVar != null) {
                cVar.rotation = rotation;
                cVar.dGa = touchImageView.azG();
            }
            if (this.dFD.intValue() >= 0 && this.dFD.intValue() < this.dEq.size()) {
                ((ImgPreviewDataItem) this.dEq.get(this.dFD.intValue())).mRotate = Integer.valueOf((int) rotation);
            }
        }
    }

    /* renamed from: cT */
    private void m21803cT(View view) {
        LogUtils.m14223i("GalleryPreviewActivity", "resetPagerItem run");
        if (view != null) {
            if (!(view instanceof TouchImageView)) {
                ((ImageView) view.findViewById(R.id.imgview_thumb_preview)).setVisibility(0);
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.imgbtn_preview_play);
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.imgbtn_preview_pause);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativelayout_preview);
                if (imageButton != null) {
                    ((SurfaceView) relativeLayout.findViewById(R.id.previewview)).setVisibility(8);
                    imageButton.setVisibility(0);
                    imageButton2.setVisibility(8);
                    ((ViewGroup) view).requestTransparentRegion(imageButton);
                }
            }
            view.requestLayout();
            view.invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ig */
    public void m21810ig(boolean z) {
        if (this.dEq != null) {
            if (z) {
                if (!this.dFG.contains(this.dFD) && this.dFI != null && (this.dFI instanceof TouchImageView)) {
                    this.dFG.add(this.dFD);
                    TouchImageView touchImageView = (TouchImageView) this.dFI;
                    C7401c cVar = new C7401c();
                    cVar.dGa = touchImageView.azG();
                    cVar.rotation = touchImageView.getRotation();
                    if (touchImageView.azw()) {
                        cVar.cropRect = touchImageView.getCropViewRect();
                        cVar.dFZ = touchImageView.getDisplayImageRect();
                    } else {
                        cVar.cropRect = null;
                        cVar.dFZ = null;
                    }
                    this.dFH.put(this.dFD.intValue(), cVar);
                    this.dFN = (ImgPreviewDataItem) this.dEq.get(this.dFD.intValue());
                    this.dFN.mRotate = Integer.valueOf((int) touchImageView.getRotation());
                    if (this.dFN.snsType == null) {
                        this.dFN.snsType = SnsType.SNS_TYPE_LOCAL;
                    }
                    this.dFQ.mo31633a(this.f3542K);
                    if (this.dFN.mRawFilePath.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        this.dFS = true;
                        String a = this.dFQ.mo31632a(this.dFN.mRawFilePath, 0, this.dFN.snsType == SnsType.SNS_TYPE_FACEBOOK ? 28 : 31, new C7162c() {
                            /* renamed from: aI */
                            public void mo31639aI(long j) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(j);
                                sb.append("");
                                LogUtils.m14223i("download start", sb.toString());
                                if (GalleryPreviewActivity.this.f3542K != null) {
                                    GalleryPreviewActivity.this.f3542K.sendMessage(GalleryPreviewActivity.this.f3542K.obtainMessage(ISnsGallery.VIDEO_MODE, GalleryPreviewActivity.this.dFN.mRawFilePath));
                                }
                            }

                            public void axQ() {
                                if (GalleryPreviewActivity.this.f3542K != null) {
                                    GalleryPreviewActivity.this.f3542K.sendEmptyMessage(5636);
                                }
                            }

                            /* renamed from: i */
                            public void mo31641i(long j, int i) {
                                if (GalleryPreviewActivity.this.f3542K != null) {
                                    GalleryPreviewActivity.this.f3542K.sendMessage(GalleryPreviewActivity.this.f3542K.obtainMessage(ISnsGallery.IMAGE_MODE, i, 0, null));
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(j);
                                sb.append("/");
                                sb.append(i);
                                LogUtils.m14223i("downloading", sb.toString());
                            }

                            /* renamed from: i */
                            public void mo31642i(long j, String str) {
                                if (GalleryPreviewActivity.this.f3542K != null && GalleryPreviewActivity.this.dFN != null) {
                                    GalleryPreviewActivity.this.dFN.mRawFilePath = str;
                                    GalleryPreviewActivity.this.f3542K.sendMessage(GalleryPreviewActivity.this.f3542K.obtainMessage(5635, str));
                                }
                            }
                        });
                        if (!TextUtils.isEmpty(a)) {
                            this.dFN.mRawFilePath = a;
                            this.dFS = false;
                        }
                    } else {
                        this.dFS = false;
                    }
                }
            } else if (this.dFG.contains(this.dFD)) {
                this.dFG.remove(this.dFD);
                this.dFH.remove(this.dFD.intValue());
            }
        }
    }

    private void initUI() {
        this.djE = (ImageView) findViewById(R.id.btn_back);
        this.dFJ = (RelativeLayout) findViewById(R.id.layout_imgbtn_del_clip);
        this.dFK = (RelativeLayout) findViewById(R.id.btns_layout);
        this.cWp = (RelativeLayout) findViewById(R.id.relativelayout_tab_content);
        this.dFL = (CheckBox) findViewById(R.id.imgbtn_del_clip);
        this.dFM = (Button) findViewById(R.id.btn_confirm);
        this.cXp = (ImageButton) findViewById(R.id.imgbtn_ratate);
        ViewClickEffectMgr.addEffectForViews(GalleryPreviewActivity.class.getSimpleName(), this.cXp, this.dFM, this.djE);
        this.dFL.setOnClickListener(this.f3543po);
        this.djE.setOnClickListener(this.f3543po);
        C73954 r0 = new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.dFK.setOnTouchListener(r0);
        this.cWp.setOnTouchListener(r0);
        this.f3542K.sendEmptyMessage(10021);
    }

    /* access modifiers changed from: private */
    /* renamed from: rf */
    public void m21820rf(int i) {
        m21803cT(this.dFI);
        ayw();
        m21821rg(i);
        this.dFD = Integer.valueOf(i);
        if (this.f3542K != null) {
            this.f3542K.sendEmptyMessageDelayed(10021, 100);
        }
    }

    /* renamed from: rg */
    private void m21821rg(int i) {
        if (i >= 0) {
            this.dFL.setOnCheckedChangeListener(null);
            this.dFL.setChecked(this.dFG.contains(Integer.valueOf(i)));
            this.dFL.setOnCheckedChangeListener(this.cXs);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConfigurationChanged newConfig:");
        sb.append(configuration.orientation);
        LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
        super.onConfigurationChanged(configuration);
        ays();
        ayu();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LogUtils.m14223i("GalleryPreviewActivity", "onCreate :");
        super.onCreate(bundle);
        if (!SDCardManager.hasSDCard()) {
            finish();
            return;
        }
        if (NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        setVolumeControlStream(3);
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(23);
        this.dEq = new ArrayList<>(C7431b.aym().ayp());
        this.dFP = getIntent().getBooleanExtra(MediaGalleryRouter.INTENT_BUNDLE_IMAGE_PICKER, false);
        this.dFO = getIntent().getBooleanExtra(MediaGalleryRouter.INTENT_KEY_IS_SLIDESHOW_PICK, false);
        this.dFD = Integer.valueOf(getIntent().getIntExtra(MediaGalleryRouter.INTENT_BUNDLE_FOCUS_INDEX, 0));
        this.bMw = getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("MagicCode:");
        sb.append(this.bMw);
        LogUtils.m14223i("GalleryPreviewActivity", sb.toString());
        this.bMM = C8522g.aJA();
        this.bOK = C8501a.aJs();
        if (this.bOK == null || this.bMM == null) {
            finish();
            return;
        }
        C5530d dVar = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        this.csj = dVar.cnU;
        if (!C5530d.m14977kn(this.csj)) {
            this.csp = dVar;
            if (this.bMM != null && this.bMM.aHd() == null && this.bMM.ebQ <= 0) {
                boolean z = this.csp.cnX == 2;
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                String[] strArr = {"", ""};
                if (iEditorService != null) {
                    strArr = iEditorService.getCommonBehaviorParam();
                }
                this.bMM.mo34756b(getApplicationContext(), null, z, strArr[0], strArr[1]);
            }
        }
        ays();
        setContentView(R.layout.gallery_item_preview);
        initUI();
        ayr();
        ayw();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LogUtils.m14223i("GalleryPreviewActivity", "onDestroy :");
        this.mAdapter = null;
        this.bOK = null;
        if (this.f3542K != null) {
            this.f3542K.removeCallbacksAndMessages(null);
        }
        this.f3542K = null;
        this.mPager = null;
        this.bMM = null;
        QComUtils.resetInstanceMembers(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        this.f3542K.sendEmptyMessage(10012);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i("GalleryPreviewActivity", "onPause :");
        super.onPause();
        UserBehaviorLog.onPause(this);
        this.dFF = true;
        if (isFinishing()) {
            if (this.mPager != null) {
                this.mPager.setAdapter(null);
                this.mPager.removeAllViews();
            }
            if (this.dFL != null) {
                this.dFL.setOnCheckedChangeListener(null);
            }
            C7431b.aym().ayq();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LogUtils.m14223i("GalleryPreviewActivity", "onResume :");
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (this.dFF) {
            this.dFF = false;
        }
    }
}
