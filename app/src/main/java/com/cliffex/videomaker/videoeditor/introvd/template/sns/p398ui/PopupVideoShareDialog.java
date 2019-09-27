package com.introvd.template.sns.p398ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.app.p199v5.common.C4417b.C4418a;
import com.introvd.template.common.Constants;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo;
import com.introvd.template.sns.biz.C8582R;
import com.introvd.template.xyui.viewpager.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.sns.ui.PopupVideoShareDialog */
public class PopupVideoShareDialog extends Dialog implements OnClickListener {
    private static final int ANIM_DURTION_TIME = 200;
    public static final int INDEX_CLICK_CANCEL = 99;
    private static final int MAX_ITEM_COUNT = 8;
    private static final int VIEW_PAGER_ORIENTATION_HORIZONTAL_HEIGHT = 110;
    private static final int VIEW_PAGER_ORIENTATION_VERTICAL_HEIGHT = 200;
    private int edgePadding = -1;
    private LinearLayout mBodyLayout;
    private LinearLayout mDotLayout;
    /* access modifiers changed from: private */
    public ImageView[] mDotViewArray;
    private Animation mHideAlphaAnim;
    private Animation mHideAnim;
    private ImageView mImgBg;
    private Animation mShowAlphaAnim;
    private Animation mShowAnim;
    private TextView mTvCancel;
    private XYViewPager mViewPager;
    private ArrayList<View> mViewPagerList;
    private LinearLayout personOpLayout;
    /* access modifiers changed from: private */
    public PopupVideoShareInfo popupVideoShareInfo;

    /* renamed from: com.introvd.template.sns.ui.PopupVideoShareDialog$SpacesItemDecoration */
    public class SpacesItemDecoration extends C1018h {
        public SpacesItemDecoration() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
            rect.top = C4583d.m11670O(PopupVideoShareDialog.this.getContext(), 20);
        }
    }

    public PopupVideoShareDialog(Context context) {
        super(context, C8582R.style.xiaoying_myTranslucent);
    }

    private int getPadding() {
        if (this.edgePadding < 0) {
            this.edgePadding = (Constants.getScreenSize().width - (C4583d.m11670O(getContext(), 27) * 8)) / 10;
        }
        return this.edgePadding;
    }

    private void initUI() {
        this.mImgBg = (ImageView) findViewById(C8582R.C8584id.img_background);
        this.mBodyLayout = (LinearLayout) findViewById(C8582R.C8584id.body_layout);
        this.mViewPager = (XYViewPager) findViewById(C8582R.C8584id.view_pager);
        this.personOpLayout = (LinearLayout) findViewById(C8582R.C8584id.person_op_layout);
        this.mDotLayout = (LinearLayout) findViewById(C8582R.C8584id.dot_layout);
        this.mTvCancel = (TextView) findViewById(C8582R.C8584id.tv_cancel);
        this.mTvCancel.setTag(Integer.valueOf(99));
        this.mTvCancel.setOnClickListener(this);
        this.mImgBg.setOnClickListener(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mShowAnim = translateAnimation;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.mHideAnim = translateAnimation2;
        this.mShowAlphaAnim = new AlphaAnimation(0.0f, 1.0f);
        this.mHideAlphaAnim = new AlphaAnimation(1.0f, 0.0f);
        this.mShowAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mHideAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mShowAlphaAnim.setDuration(100);
        this.mHideAlphaAnim.setDuration(200);
        this.mShowAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mHideAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mShowAnim.setDuration(200);
        this.mHideAnim.setDuration(200);
        this.mHideAnim.setFillAfter(true);
        this.mHideAlphaAnim.setFillAfter(true);
        this.mHideAnim.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                PopupVideoShareDialog.this.dismiss();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        initViewPager();
        this.mImgBg.startAnimation(this.mShowAlphaAnim);
        this.mBodyLayout.startAnimation(this.mShowAnim);
    }

    private void initViewItem(List<MyResolveInfo> list, final int i) {
        RecyclerView recyclerView = new RecyclerView(getContext());
        PopupVideoShareAdapter popupVideoShareAdapter = new PopupVideoShareAdapter(getPadding());
        popupVideoShareAdapter.setDataList(list);
        this.mViewPager.setPadding(getPadding(), 0, getPadding(), 0);
        this.personOpLayout.setPadding(getPadding(), 0, getPadding(), 0);
        int i2 = 110;
        int i3 = 4;
        int i4 = 1;
        if (getContext().getResources().getConfiguration().orientation != 1) {
            i3 = 1;
            i4 = 0;
        } else if (list.size() > 4 || i != 0) {
            i2 = 200;
        }
        if (this.mViewPager != null) {
            this.mViewPager.getLayoutParams().height = C4583d.m11670O(getContext(), i2);
            this.mViewPager.requestLayout();
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i3, i4));
        recyclerView.setAdapter(popupVideoShareAdapter);
        recyclerView.mo7733a((C1018h) new SpacesItemDecoration());
        popupVideoShareAdapter.setItemListener(new C4418a() {
            public void onItemClicked(int i) {
                int i2 = i + (i * 8);
                if (PopupVideoShareDialog.this.popupVideoShareInfo.onPopupItemClickListener != null && i2 < PopupVideoShareDialog.this.popupVideoShareInfo.myResolveInfoList.size()) {
                    PopupVideoShareDialog.this.popupVideoShareInfo.onPopupItemClickListener.onItemClick((MyResolveInfo) PopupVideoShareDialog.this.popupVideoShareInfo.myResolveInfoList.get(i2));
                    PopupVideoShareDialog.this.hide(false);
                }
            }
        });
        this.mViewPagerList.add(recyclerView);
    }

    public void dismiss() {
        super.dismiss();
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(false);
        }
    }

    public void hide() {
        super.hide();
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(false);
        }
    }

    public void hide(boolean z) {
        if (z) {
            this.mBodyLayout.clearAnimation();
            this.mImgBg.startAnimation(this.mHideAlphaAnim);
            this.mBodyLayout.startAnimation(this.mHideAnim);
        } else {
            dismiss();
        }
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(false);
        }
    }

    public void initViewPager() {
        this.mViewPagerList = new ArrayList<>();
        int size = this.popupVideoShareInfo.myResolveInfoList != null ? this.popupVideoShareInfo.myResolveInfoList.size() : 0;
        int i = ((size - 1) / 8) + 1;
        if (this.popupVideoShareInfo.myResolveInfoList != null) {
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 == i - 1) {
                    initViewItem(this.popupVideoShareInfo.myResolveInfoList.subList(i2 * 8, size), i2);
                } else {
                    int i3 = i2 * 8;
                    initViewItem(this.popupVideoShareInfo.myResolveInfoList.subList(i3, i3 + 8), i2);
                }
            }
        }
        if (i > 1) {
            this.mDotViewArray = new ImageView[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.mDotViewArray[i4] = new ImageView(getContext());
                this.mDotViewArray[i4].setImageResource(C8582R.C8583drawable.video_share_viewpager_dot);
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                if (i4 > 0) {
                    if (VERSION.SDK_INT >= 17) {
                        layoutParams.setMarginStart(C4583d.m11670O(getContext(), 6));
                    } else {
                        layoutParams.leftMargin = C4583d.m11670O(getContext(), 6);
                    }
                }
                this.mDotLayout.addView(this.mDotViewArray[i4], layoutParams);
            }
            this.mDotViewArray[0].setSelected(true);
            this.mDotLayout.setVisibility(0);
        } else {
            this.mDotLayout.setVisibility(8);
        }
        this.mViewPager.setAdapter(new ViewPagerAdapter(this.mViewPagerList));
        this.mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (PopupVideoShareDialog.this.mDotViewArray != null) {
                    for (ImageView selected : PopupVideoShareDialog.this.mDotViewArray) {
                        selected.setSelected(false);
                    }
                    PopupVideoShareDialog.this.mDotViewArray[i].setSelected(true);
                }
            }
        });
    }

    public void onBackPressed() {
        if (isShowing()) {
            hide(true);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.mTvCancel)) {
            hide(true);
        } else if (view.equals(this.mImgBg)) {
            hide(true);
        }
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8582R.C8586layout.sns_popup_video_share);
        initUI();
    }

    public void setPopupVideoShareInfo(PopupVideoShareInfo popupVideoShareInfo2) {
        this.popupVideoShareInfo = popupVideoShareInfo2;
    }

    public void show() {
        super.show();
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(true);
        }
    }

    public void show(boolean z) {
        super.show();
        if (!(!z || this.mBodyLayout == null || this.mImgBg == null)) {
            this.mImgBg.startAnimation(this.mShowAlphaAnim);
            this.mBodyLayout.startAnimation(this.mShowAnim);
        }
        if (this.popupVideoShareInfo.onPopShowListener != null) {
            this.popupVideoShareInfo.onPopShowListener.onShow(true);
        }
    }

    public void uninit() {
    }
}
