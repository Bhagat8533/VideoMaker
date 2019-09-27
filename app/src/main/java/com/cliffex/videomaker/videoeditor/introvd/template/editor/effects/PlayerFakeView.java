package com.introvd.template.editor.effects;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.quickposition.QuickPositionPanel;
import com.introvd.template.editor.effects.quickposition.QuickPositionPanel.C6193a;
import com.introvd.template.editor.widget.HighLView;
import com.introvd.template.editor.widget.scalerotate.C7070b.C7073c;
import com.introvd.template.editor.widget.scalerotate.C7070b.C7074d;
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView;
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView.C7061a;
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView.C7063c;
import com.introvd.template.editor.widget.scalerotate.p295a.C7068c;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.util.List;

public class PlayerFakeView extends RelativeLayout {
    /* access modifiers changed from: private */
    public RelativeLayout cGA;
    private QuickPositionPanel cGB;
    private HighLView cGC;
    /* access modifiers changed from: private */
    public C5889a cGD;
    /* access modifiers changed from: private */
    public C5892d cGE;
    /* access modifiers changed from: private */
    public C5890b cGF;
    /* access modifiers changed from: private */
    public C5891c cGG;
    private C7073c cGH = new C7073c() {
        /* renamed from: a */
        public void mo28375a(RectF rectF, float f, int i) {
            if (PlayerFakeView.this.cGF != null) {
                PlayerFakeView.this.cGF.mo28388b(rectF, f, i);
            }
        }

        public void aiH() {
            if (PlayerFakeView.this.cGF != null) {
                PlayerFakeView.this.cGF.aiH();
            }
        }

        /* renamed from: mj */
        public void mo28377mj(int i) {
            if (PlayerFakeView.this.cGG != null) {
                PlayerFakeView.this.cGG.mo28389mj(i);
            }
        }
    };
    private C7074d cGI = new C7074d() {
        public void aan() {
            if (PlayerFakeView.this.cGD != null) {
                PlayerFakeView.this.cGD.aan();
            }
        }

        public void aiI() {
            if (PlayerFakeView.this.cGE != null) {
                PlayerFakeView.this.cGE.aiI();
            }
        }

        public void aiJ() {
            if (PlayerFakeView.this.cGD != null) {
                PlayerFakeView.this.cGD.aan();
            }
        }

        /* renamed from: cv */
        public int mo28381cv(int i, int i2) {
            if (PlayerFakeView.this.cGz == null || PlayerFakeView.this.cGy == null) {
                return -1;
            }
            int height = PlayerFakeView.this.cGz.getHeight() / 2;
            int width = i - (PlayerFakeView.this.cGz.getWidth() / 2);
            if (Math.abs(width) < 5 && Math.abs(i2 - height) < 5) {
                return 0;
            }
            if (Math.abs(width) < 5) {
                return 2;
            }
            return Math.abs(i2 - height) < 5 ? 1 : -1;
        }

        /* renamed from: cw */
        public void mo28382cw(int i, int i2) {
            if (PlayerFakeView.this.cGz != null && PlayerFakeView.this.cGy != null) {
                int width = PlayerFakeView.this.cGz.getWidth() / 2;
                int height = PlayerFakeView.this.cGz.getHeight() / 2;
                int i3 = i - width;
                if (Math.abs(i3) < 5 && Math.abs(i2 - height) < 5) {
                    PlayerFakeView.this.cGy.mo31001E(0, width - i, height - i2);
                } else if (Math.abs(i3) < 5) {
                    PlayerFakeView.this.cGy.mo31001E(2, width - i, 0);
                } else if (Math.abs(i2 - height) < 5) {
                    PlayerFakeView.this.cGy.mo31001E(1, 0, height - i2);
                } else {
                    PlayerFakeView.this.cGy.mo31001E(-1, 0, 0);
                }
            }
        }

        /* renamed from: eg */
        public void mo28383eg(boolean z) {
            if (PlayerFakeView.this.cGy != null) {
                ScaleRotateViewState scaleViewState = PlayerFakeView.this.cGy.getScaleViewState();
                if (scaleViewState != null) {
                    if (z) {
                        scaleViewState.setVerFlip(!scaleViewState.isVerFlip);
                    } else {
                        scaleViewState.setHorFlip(!scaleViewState.isHorFlip);
                    }
                    PlayerFakeView.this.mo28360d(scaleViewState);
                    PlayerFakeView.this.cGy.invalidate();
                    if (PlayerFakeView.this.cGE != null) {
                        PlayerFakeView.this.cGE.aiK();
                    }
                }
            }
        }

        /* renamed from: ff */
        public void mo28384ff(boolean z) {
            PlayerFakeView.this.cGA.setVisibility(z ? 0 : 8);
            PlayerFakeView.this.cGF;
        }
    };
    private C6193a cGJ = new C6193a() {
        /* renamed from: mk */
        public void mo28385mk(int i) {
            PlayerFakeView.this.mo28363mi(i);
        }
    };
    /* access modifiers changed from: private */
    public ScaleRotateView cGy;
    /* access modifiers changed from: private */
    public RelativeLayout cGz;
    private int groupId = 0;

    /* renamed from: com.introvd.template.editor.effects.PlayerFakeView$a */
    public interface C5889a {
        void aan();
    }

    /* renamed from: com.introvd.template.editor.effects.PlayerFakeView$b */
    public interface C5890b {
        void aiH();

        /* renamed from: b */
        void mo28388b(RectF rectF, float f, int i);
    }

    /* renamed from: com.introvd.template.editor.effects.PlayerFakeView$c */
    public interface C5891c {
        /* renamed from: mj */
        void mo28389mj(int i);
    }

    /* renamed from: com.introvd.template.editor.effects.PlayerFakeView$d */
    public interface C5892d {
        void aiI();

        void aiK();
    }

    public PlayerFakeView(Context context) {
        super(context);
    }

    public PlayerFakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerFakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void aiD() {
        this.cGy = new ScaleRotateView(getContext());
        this.cGy.setLayoutParams(new LayoutParams(-1, -1));
        this.cGz.addView(this.cGy);
        Resources resources = getContext().getResources();
        Drawable drawable = resources.getDrawable(R.drawable.editor_icon_effect_scale_rotate_view_zoom_n);
        Drawable drawable2 = resources.getDrawable(R.drawable.editor_icon_effect_scale_rotate_view_mirror_n);
        Drawable drawable3 = resources.getDrawable(R.drawable.editor_icon_effect_scale_rotate_view_mirror_vertical_n);
        Drawable drawable4 = resources.getDrawable(R.drawable.editor_icon_effect_scale_rotate_view_delete_n);
        Drawable drawable5 = resources.getDrawable(R.drawable.editor_icon_effect_scale_rotate_view_replace_n);
        this.cGy.setFlipDrawable(drawable2, drawable3);
        this.cGy.setAnchorDrawable(drawable, drawable4);
        this.cGy.setReplaceAnchorDrawable(drawable5);
        this.cGy.setDelListener(this.cGI);
        this.cGy.setDrawRectChangeListener(this.cGH);
    }

    /* renamed from: a */
    public void mo28354a(MSize mSize, MSize mSize2, boolean z, int i) {
        if (mSize2 != null && mSize != null) {
            LayoutInflater.from(getContext()).inflate(R.layout.editor_view_fakeview, this, true);
            this.cGz = (RelativeLayout) findViewById(R.id.editor_fake_layout);
            this.cGC = (HighLView) findViewById(R.id.editor_fake_highlight);
            this.cGA = (RelativeLayout) findViewById(R.id.auxiliary_line);
            this.cGB = (QuickPositionPanel) findViewById(R.id.text_quick_position);
            LayoutParams layoutParams = new LayoutParams(mSize2.width, mSize2.height);
            layoutParams.addRule(13, 1);
            this.cGz.setLayoutParams(layoutParams);
            this.cGz.invalidate();
            if (z) {
                aiD();
            }
            this.cGB.setPanelClickListener(this.cGJ);
            this.groupId = i;
            if (this.cGB.getParent() != null) {
                this.cGB.getParent().bringChildToFront(this.cGB);
            }
        }
    }

    /* renamed from: aL */
    public void mo28355aL(List<ScaleRotateViewState> list) {
        if (this.cGC != null && list != null) {
            this.cGC.setDataList(list);
            this.cGC.invalidate();
            this.cGC.setVisibility(0);
        }
    }

    public void adl() {
        if (this.cGy != null) {
            this.cGy.setVisibility(4);
            this.cGy.clear();
        }
    }

    public void aiE() {
        if (this.cGy != null) {
            this.cGy.setStretchDrawable(getContext().getResources().getDrawable(R.drawable.editor_icon_effect_scale_point));
        }
    }

    public void aiF() {
        if (this.cGy != null) {
            this.cGy.setWatermarkDeleteDrawable(getContext().getResources().getDrawable(R.drawable.editor_btn_watermark_delete));
        }
    }

    public void aiG() {
        if (this.cGC != null) {
            this.cGC.setVisibility(4);
        }
    }

    /* renamed from: d */
    public void mo28360d(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null && this.cGy != null) {
            this.cGy.setScaleViewState(scaleRotateViewState);
            this.cGy.setVisibility(0);
        }
    }

    public void destroy() {
        aiG();
        adl();
        if (this.cGy != null) {
            this.cGy.clear();
            this.cGy = null;
        }
    }

    public ScaleRotateView getScaleRotateView() {
        return this.cGy;
    }

    /* renamed from: mi */
    public void mo28363mi(int i) {
        float f;
        float f2;
        if (i >= 0 && i <= 8 && this.cGy != null) {
            RectF displayRec = this.cGy.getDisplayRec();
            if (displayRec != null) {
                float centerX = displayRec.centerX();
                float centerY = displayRec.centerY();
                switch (i) {
                    case 0:
                        f = ((float) this.cGz.getWidth()) / 2.0f;
                        f2 = ((float) this.cGz.getHeight()) / 2.0f;
                        break;
                    case 1:
                        f = (displayRec.right - displayRec.left) / 2.0f;
                        f2 = ((float) this.cGz.getHeight()) / 2.0f;
                        break;
                    case 2:
                        f = ((float) this.cGz.getWidth()) - ((displayRec.right - displayRec.left) / 2.0f);
                        f2 = ((float) this.cGz.getHeight()) / 2.0f;
                        break;
                    case 3:
                        f = (displayRec.right - displayRec.left) / 2.0f;
                        f2 = (displayRec.bottom - displayRec.top) / 2.0f;
                        break;
                    case 4:
                        f = ((float) this.cGz.getWidth()) - ((displayRec.right - displayRec.left) / 2.0f);
                        f2 = (displayRec.bottom - displayRec.top) / 2.0f;
                        break;
                    case 5:
                        f = (displayRec.right - displayRec.left) / 2.0f;
                        f2 = ((float) this.cGz.getHeight()) - ((displayRec.bottom - displayRec.top) / 2.0f);
                        break;
                    case 6:
                        f = ((float) this.cGz.getWidth()) - ((displayRec.right - displayRec.left) / 2.0f);
                        f2 = ((float) this.cGz.getHeight()) - ((displayRec.bottom - displayRec.top) / 2.0f);
                        break;
                    case 7:
                        f = ((float) this.cGz.getWidth()) / 2.0f;
                        f2 = (displayRec.bottom - displayRec.top) / 2.0f;
                        break;
                    case 8:
                        f = ((float) this.cGz.getWidth()) / 2.0f;
                        f2 = ((float) this.cGz.getHeight()) - ((displayRec.bottom - displayRec.top) / 2.0f);
                        break;
                    default:
                        f = displayRec.centerX();
                        f2 = displayRec.centerY();
                        break;
                }
                this.cGy.mo31001E(3, (int) (f - centerX), (int) (f2 - centerY));
            }
        }
    }

    public void setEnableFlip(boolean z) {
        if (this.cGy != null) {
            this.cGy.setEnableFlip(z);
        }
    }

    public void setGestureListener(C7061a aVar) {
        if (this.cGy != null && aVar != null) {
            this.cGy.setmOnGestureListener(aVar);
        }
    }

    public void setOnDelListener(C5889a aVar) {
        if (aVar != null) {
            this.cGD = aVar;
        }
    }

    public void setOnKeyFrameListener(C5891c cVar) {
        this.cGG = cVar;
    }

    public void setOnMoveListener(C5890b bVar) {
        this.cGF = bVar;
    }

    public void setOnReplaceListener(C5892d dVar) {
        this.cGE = dVar;
    }

    public void setQuickPositionPanelVisibility(boolean z) {
        if (this.cGB != null) {
            this.cGB.setVisibility(z ? 0 : 8);
        }
    }

    public void setScaleRotateViewDecoder(C7068c cVar) {
        if (this.cGy != null) {
            this.cGy.setScaleRotateViewDecoder(cVar);
        }
    }

    public void setSimpleMode(boolean z) {
        if (getScaleRotateView() != null) {
            getScaleRotateView().setSimpleMode(z);
        }
    }

    public void setTouchUpEvent(C7063c cVar) {
        this.cGy.setTouchUpEvent(cVar);
    }

    public void setViewPosition(Rect rect, float f) {
        if (getScaleRotateView() != null) {
            getScaleRotateView().setViewPosition(rect, f);
        }
    }
}
