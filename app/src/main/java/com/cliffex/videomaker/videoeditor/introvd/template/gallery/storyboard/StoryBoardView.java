package com.introvd.template.gallery.storyboard;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.p236ui.SpannableTextView;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p375r.C8359a;
import com.introvd.template.p375r.C8364b;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.xygallery.R;
import com.p131c.p132a.p133a.C2564c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class StoryBoardView extends RelativeLayout implements OnItemClickListener {
    /* access modifiers changed from: private */
    public boolean blp = false;
    private RelativeLayout bua;
    private ArrayList<StoryBoardItemInfo> cwG;
    /* access modifiers changed from: private */
    public C8359a dIZ;
    private int dIy;
    private TextView dJA;
    private boolean dJB = false;
    /* access modifiers changed from: private */
    public C7484b dJC = null;
    private ClipDragGridView dJn;
    private C7485a dJo;
    /* access modifiers changed from: private */
    public RelativeLayout dJp;
    /* access modifiers changed from: private */
    public RelativeLayout dJq;
    private SpannableTextView dJr = null;
    public ImageView dJs;
    private Button dJt;
    private boolean dJu = true;
    private int dJv;
    private int dJw;
    private Animation dJx = null;
    private Animation dJy = null;
    private boolean dJz = true;
    /* access modifiers changed from: private */

    /* renamed from: ei */
    public int f3547ei = -1;

    /* renamed from: ek */
    private int f3548ek = -1;

    /* renamed from: gU */
    private int f3549gU = 4;
    private Context mContext;
    private Handler mHandler = new C7483a(this);

    /* renamed from: po */
    private OnClickListener f3550po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(StoryBoardView.this.dJq)) {
                StoryBoardView.this.mo32174ir(!StoryBoardView.this.blp);
                if (StoryBoardView.this.dJC != null) {
                    StoryBoardView.this.dJC.ayV();
                }
            } else if (view.equals(StoryBoardView.this.dJs)) {
                C2564c.m7327dA(StoryBoardView.this.dJs);
                if (StoryBoardView.this.dJC != null) {
                    StoryBoardView.this.dJC.ayU();
                }
            }
        }
    };

    /* renamed from: com.introvd.template.gallery.storyboard.StoryBoardView$a */
    private static class C7483a extends Handler {
        private WeakReference<StoryBoardView> dJF;

        public C7483a(StoryBoardView storyBoardView) {
            this.dJF = new WeakReference<>(storyBoardView);
        }

        public void handleMessage(Message message) {
            StoryBoardView storyBoardView = (StoryBoardView) this.dJF.get();
            if (storyBoardView != null) {
                switch (message.what) {
                    case 12289:
                        if (storyBoardView.dIZ != null) {
                            storyBoardView.dIZ.mo32042dh(message.arg1, message.arg2);
                            break;
                        }
                        break;
                    case 12290:
                        storyBoardView.m22136rG(message.arg1);
                        break;
                    case 12291:
                        storyBoardView.azs();
                        break;
                    case 12292:
                        storyBoardView.m22137rH(message.arg1);
                        break;
                    case 12293:
                        int i = message.arg1;
                        if (storyBoardView.dIZ != null) {
                            storyBoardView.dIZ.mo32057rk(i);
                            break;
                        }
                        break;
                    case 12294:
                        int i2 = message.arg1;
                        if (storyBoardView.dIZ != null && (storyBoardView.dIZ instanceof C8364b)) {
                            ((C8364b) storyBoardView.dIZ).mo32058rl(i2);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.gallery.storyboard.StoryBoardView$b */
    public interface C7484b {
        void ayU();

        void ayV();
    }

    public StoryBoardView(Context context) {
        super(context);
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.gallery_include_storyboard_view, this, true);
        int i = Constants.getScreenSize().width;
        if (!isInEditMode()) {
            this.dIy = ((i - C4583d.m11670O(this.mContext, 13)) / 4) / 2;
            this.f3548ek = (this.dIy * 6) + (getMagrinPx() * 3);
            if (Constants.getDeviceDensity() <= 1.5f) {
                this.f3547ei = ((int) (((float) this.dIy) * 2.5f)) + getMagrinPx();
            } else if (((float) Constants.getScreenSize().width) / ((float) Constants.getScreenSize().height) > 0.648f) {
                this.f3547ei = (this.dIy * 2) + getMagrinPx();
            } else {
                this.f3547ei = (this.dIy * 3) + (getMagrinPx() * 2);
            }
        }
    }

    public StoryBoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        if (!isInEditMode()) {
            LayoutInflater.from(this.mContext).inflate(R.layout.gallery_include_storyboard_view, this, true);
            this.dIy = ((Constants.getScreenSize().width - C4583d.m11670O(this.mContext, 13)) / 4) / 2;
            this.f3548ek = (this.dIy * 6) + (getMagrinPx() * 3);
            if (Constants.getDeviceDensity() <= 1.5f) {
                this.f3547ei = ((int) (((float) this.dIy) * 2.5f)) + getMagrinPx();
            } else if (((float) Constants.getScreenSize().width) / ((float) Constants.getScreenSize().height) > 0.648f) {
                this.f3547ei = (this.dIy * 2) + getMagrinPx();
            } else {
                this.f3547ei = (this.dIy * 3) + (getMagrinPx() * 2);
            }
        }
    }

    /* renamed from: a */
    private void m22126a(C7485a aVar) {
        int i;
        this.bua = (RelativeLayout) findViewById(R.id.view_title);
        this.dJn = (ClipDragGridView) findViewById(R.id.clipgridview);
        if (this.f3549gU != 4 && this.f3549gU > 0) {
            this.dJn.setNumColumns(this.f3549gU);
            int O = (Constants.getScreenSize().width - C4583d.m11670O(this.mContext, 13)) / this.f3549gU;
            if (this.f3549gU == 2) {
                this.dJn.setBackgroundColor(-1710619);
                this.dJn.setVerticalSpacing(2);
                this.dJn.setHorizontalSpacing(2);
                O = Constants.getScreenSize().width / this.f3549gU;
                i = C4583d.m11670O(this.mContext, 40);
            } else {
                i = O;
            }
            aVar.mo32213rA(O);
            aVar.mo32214rB(i);
        }
        this.dJq = (RelativeLayout) findViewById(R.id.layout_body);
        this.dJt = (Button) findViewById(R.id.btn_expand);
        this.dJp = (RelativeLayout) findViewById(R.id.view_content);
        this.dJr = (SpannableTextView) findViewById(R.id.xiaoying_com_storyboard_clip_count);
        this.dJA = (TextView) findViewById(R.id.txt_drag_tips);
        this.dJs = (ImageView) findViewById(R.id.xiaoying_com_storyboard_next_btn);
        this.dJq.setOnClickListener(this.f3550po);
        this.dJs.setOnClickListener(this.f3550po);
        this.dJo = aVar;
        this.dJo.setList(this.cwG);
        this.dJo.setHandler(this.mHandler);
        this.dJo.mo32212io(this.dJu);
        this.dJn.setAdapter(this.dJo);
        this.dJn.setOnItemClickListener(this);
        LayoutParams layoutParams = (LayoutParams) this.dJp.getLayoutParams();
        layoutParams.height = this.f3547ei;
        this.dJp.setLayoutParams(layoutParams);
        m22134iq(true);
        this.dJv = R.string.xiaoying_str_ve_clip_selected_count;
        mo32169fp();
    }

    /* access modifiers changed from: private */
    public void azs() {
        if (this.dJo != null) {
            this.dJo.mo32217rz(-1);
            this.dJo.mo32210im(true);
            this.dJo.mo32211in(false);
        }
        if (this.dJn != null) {
            this.dJn.setLock(false);
        }
    }

    private void azt() {
        LayoutParams layoutParams = (LayoutParams) this.dJp.getLayoutParams();
        this.blp = true;
        layoutParams.height = this.f3548ek;
        this.dJp.setLayoutParams(layoutParams);
        if (this.dJz) {
            if (!this.dJB) {
                mo32165WV();
            }
            this.dJx.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    StoryBoardView.this.setArrowUpOrDown(false);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(this.dJx);
        }
    }

    private void azu() {
        final LayoutParams layoutParams = (LayoutParams) this.dJp.getLayoutParams();
        this.blp = false;
        if (!this.dJz) {
            layoutParams.height = this.f3547ei;
            this.dJp.setLayoutParams(layoutParams);
            return;
        }
        if (!this.dJB) {
            mo32165WV();
        }
        startAnimation(this.dJy);
        this.dJy.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                layoutParams.height = StoryBoardView.this.f3547ei;
                StoryBoardView.this.setArrowUpOrDown(true);
                StoryBoardView.this.dJp.setLayoutParams(layoutParams);
                StoryBoardView.this.clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private final int getMagrinPx() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.story_board_grid_verticalSpacing);
    }

    /* renamed from: iq */
    private void m22134iq(boolean z) {
        this.dJA.setText(R.string.xiaoying_str_ve_clip_drag_tip);
        this.dJA.setVisibility(z ? 0 : 8);
    }

    /* renamed from: rE */
    private void m22135rE(int i) {
        if (this.dJo.azo()) {
            if (i <= this.dJn.getChildCount() - 1) {
                this.dJo.mo32210im(false);
            } else {
                this.dJo.mo32210im(true);
            }
            this.dJn.setLock(true);
            mo32176rF(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: rG */
    public void m22136rG(int i) {
        if (this.dJo == null || i < 0 || i >= this.dJo.getCount()) {
            LogUtils.m14222e("StoryBoardView", "The index is out of range!");
            return;
        }
        this.dJo.mo32217rz(i);
        m22135rE(i);
        if (this.dIZ != null) {
            this.dIZ.mo32043rh(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: rH */
    public void m22137rH(int i) {
        if (this.dJo == null || i < 0 || i >= this.dJo.getCount()) {
            LogUtils.m14222e("StoryBoardView", "The index is out of range!");
            return;
        }
        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) this.cwG.get(i);
        if (storyBoardItemInfo != null && this.dIZ != null && (this.dIZ instanceof C8364b)) {
            if (storyBoardItemInfo.bAudioEnable) {
                storyBoardItemInfo.bAudioOn = !storyBoardItemInfo.bAudioOn;
                mo32169fp();
            }
            ((C8364b) this.dIZ).mo32053d(i, storyBoardItemInfo.bAudioOn, storyBoardItemInfo.bAudioEnable);
        }
    }

    /* renamed from: WV */
    public void mo32165WV() {
        int height = this.bua.getHeight();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, ((float) (this.f3548ek - this.f3547ei)) / ((float) (this.f3548ek + height)), 1, 0.0f);
        this.dJx = translateAnimation;
        this.dJx.setDuration(300);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, ((float) (this.f3548ek - this.f3547ei)) / ((float) (height + this.f3548ek)));
        this.dJy = translateAnimation2;
        this.dJy.setDuration(300);
        this.dJy.setFillAfter(true);
    }

    public void azv() {
        if (this.dJn != null && this.dJo != null && this.dJo.getCount() != 0) {
            this.dJn.setSelection(0);
        }
    }

    /* renamed from: b */
    public void mo32167b(StoryBoardItemInfo storyBoardItemInfo) {
        this.cwG.add(storyBoardItemInfo);
        this.dJn.setSelection(this.dJn.getAdapter().getCount() - 1);
    }

    public void destroy() {
        if (this.cwG != null) {
            this.cwG.clear();
        }
    }

    /* renamed from: fp */
    public void mo32169fp() {
        this.dJo.notifyDataSetChanged();
        int count = this.dJo.getCount();
        int i = (count > 1 || this.dJw <= 0) ? this.dJv : this.dJw;
        String string = this.mContext.getString(i, new Object[]{Integer.valueOf(count)});
        String string2 = this.mContext.getString(i);
        int indexOf = string2.indexOf("%d");
        int length = indexOf + String.valueOf(count).length();
        if (!string2.contains("%d") || length > string.length()) {
            this.dJr.setText(string);
        } else {
            this.dJr.setSpanText(string, indexOf, length, this.mContext.getResources().getColor(R.color.color_ff5e13), null);
        }
        if (this.dJo.getCount() >= 2) {
            m22134iq(true);
        } else {
            m22134iq(false);
        }
    }

    public int getFocusIndex() {
        if (this.dJo != null) {
            return this.dJo.getFocusIndex();
        }
        return 0;
    }

    public GridView getGridView() {
        return this.dJn;
    }

    public int getItemCount() {
        if (this.dJo != null) {
            return this.dJo.getCount();
        }
        return 0;
    }

    public int getItemWidth() {
        return this.dIy * 2;
    }

    /* renamed from: ir */
    public void mo32174ir(boolean z) {
        if (z && !this.blp) {
            azt();
        } else if (!z && this.blp) {
            azu();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.dIZ != null) {
            this.dIZ.mo32054hk(this.dJo.mo32215rx(i));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: rF */
    public void mo32176rF(int i) {
        this.cwG.remove(i);
        mo32169fp();
        if (this.dJo.getCount() == 0) {
            azs();
        }
    }

    public void scrollToPosition(int i) {
        int i2;
        int[] iArr = new int[2];
        this.dJn.getLocationOnScreen(iArr);
        int i3 = i / 4;
        if (!(this.dJn == null || this.dJo == null || this.dJo.getCount() == 0)) {
            View childAt = this.dJn.getChildAt(0);
            if (childAt != null) {
                int firstVisiblePosition = i3 - (this.dJn.getFirstVisiblePosition() / 4);
                if (firstVisiblePosition == 0) {
                    int[] iArr2 = new int[2];
                    childAt.getLocationOnScreen(iArr2);
                    i2 = iArr2[1] - iArr[1];
                } else {
                    int[] iArr3 = new int[2];
                    childAt.getLocationOnScreen(iArr3);
                    i2 = iArr3[1] - iArr[1];
                }
                this.dJn.smoothScrollBy(i2 + (firstVisiblePosition * ((this.dIy * 2) + getMagrinPx())), 1000);
            }
        }
    }

    public void setAdapter(C7485a aVar) {
        this.cwG = new ArrayList<>();
        m22126a(aVar);
    }

    public void setArrowUpOrDown(boolean z) {
        if (z) {
            this.dJt.setBackgroundResource(R.drawable.gallery_icon_clip_edit_up);
        } else {
            this.dJt.setBackgroundResource(R.drawable.xiaoying_ve_clip_edit_down);
        }
    }

    public void setCountInfoTextId(int i, int i2) {
        this.dJv = i;
        this.dJw = i2;
    }

    public void setDragEnabled(boolean z) {
        if (this.dJn != null) {
            this.dJn.setDragEnabled(z);
        }
    }

    public void setDragListener(C8359a aVar) {
        this.dIZ = aVar;
        this.dJn.setDragListener(this.dIZ);
    }

    public void setFocusIndex(int i) {
        if (this.dJo == null || i < 0 || i >= this.dJo.getCount()) {
            LogUtils.m14222e("StoryBoardView", "The index is out of range!");
        } else {
            this.dJo.mo32216ry(i);
        }
    }

    public void setMaxHeight(int i) {
        this.f3548ek = i;
    }

    public void setMinHeight(int i) {
        this.f3547ei = i;
        LayoutParams layoutParams = (LayoutParams) this.dJp.getLayoutParams();
        layoutParams.height = this.f3547ei;
        this.dJp.setLayoutParams(layoutParams);
    }

    public void setNextBtnEnable(boolean z) {
        this.dJs.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setShowIndexText(boolean z) {
        this.dJu = z;
        if (this.dJo != null) {
            this.dJo.mo32212io(z);
        }
    }

    public void setStoryBoardListener(C7484b bVar) {
        this.dJC = bVar;
    }

    public void setTitleBtnText(int i) {
        this.dJs.setBackgroundResource(R.drawable.xiaoying_com_trans_bg);
    }

    public void setTitleHeight(int i) {
        LayoutParams layoutParams = (LayoutParams) this.bua.getLayoutParams();
        layoutParams.height = i;
        layoutParams.addRule(10);
        this.bua.setLayoutParams(layoutParams);
    }

    public void setVerticalSpacing(int i) {
        this.dJn.setVerticalSpacing(i);
    }

    public void setmNumColumns(int i) {
        this.f3549gU = i;
    }
}
