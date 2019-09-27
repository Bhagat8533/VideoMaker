package com.introvd.template.editor.widget.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.timeline.VePIPGallery.C7113e;

@SuppressLint({"WrongCall"})
public class VeGallery2 extends VePIPGallery {

    /* renamed from: com.introvd.template.editor.widget.timeline.VeGallery2$a */
    public interface C7105a extends C7113e {
        /* renamed from: x */
        boolean mo31421x(MotionEvent motionEvent);
    }

    public VeGallery2(Context context) {
        this(context, null);
    }

    public VeGallery2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842864);
    }

    public VeGallery2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aML.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VeGallery, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.VeGallery_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.VeGallery_android_animationDuration, -1);
        if (i3 > 0) {
            setAnimationDuration(i3);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.VeGallery_android_spacing, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(R.styleable.VeGallery_android_unselectedAlpha, 0.5f));
        obtainStyledAttributes.recycle();
        setStaticTransformationsEnabled(true);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"WrongCall"})
    /* renamed from: ae */
    public void mo31183ae(int i, boolean z) {
        int i2 = this.dnL.left;
        int right = ((getRight() - getLeft()) - this.dnL.left) - this.dnL.right;
        int count = getCount();
        if (this.bXu) {
            handleDataChanged();
        }
        if (this.aaE == 0 || this.f3534SZ == null) {
            atX();
            this.dnS = 0;
            if (this.dvA != null) {
                this.dvA.mo31526cw(this);
            }
            return;
        }
        if (this.doO >= 0) {
            this.dod = this.doO;
        }
        if (this.dod >= 0) {
            setSelectedPositionInt(this.dod);
        }
        atY();
        detachAllViewsFromParent();
        this.dou = 0;
        this.dot = 0;
        this.dnS = this.dof;
        View c = mo31434c(this.dof, 0, 0, true);
        if (this.doH) {
            int i3 = i2 + (right / 2);
            if (this.doI || this.doL <= 0) {
                c.offsetLeftAndRight(i3);
            } else if (this.doL > 0) {
                if (this.dof >= this.doL && this.dof < count - this.doL && count >= (this.doL * 2) + 1) {
                    c.offsetLeftAndRight(i3);
                } else if (this.dof < this.doL || count < (this.doL * 2) + 1) {
                    c.offsetLeftAndRight((this.doK * this.dof) + getPaddingLeft());
                } else {
                    int i4 = (this.dof - (count - this.doL)) + 1;
                    if (i4 > 0) {
                        c.offsetLeftAndRight((this.doK * (this.doL + i4)) + getPaddingLeft());
                    }
                }
            }
        } else if (this.doO >= 0) {
            c.offsetLeftAndRight(this.dnL.left + this.doP);
        } else {
            c.offsetLeftAndRight(this.dnL.left);
        }
        if (this.dpi) {
            auk();
        } else {
            aum();
            aul();
        }
        if (!this.doW) {
            this.dwg.clear();
        }
        if (this.dvA != null) {
            this.dvA.mo31526cw(this);
            setSelectionInfoOnLayout(0, getCenterOfGallery() - getPaddingLeft());
            requestLayout();
        }
        if (!this.dpm) {
            this.doO = -1;
            this.doP = -1;
        }
        invalidate();
        auc();
        this.bXu = false;
        this.dnX = false;
        setNextSelectedPositionInt(this.dof);
        auq();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ag */
    public int mo31418ag(int i, boolean z) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        boolean z2 = i < 0;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r = mo31420r(z2, i);
        if (r != 0) {
            if (r >= width) {
                r = width - 1;
            }
            int i2 = -width;
            if (r <= i2) {
                r = i2 + 1;
            }
            mo31477pR(r);
            mo31459hw(z2);
            if (z2) {
                aum();
            } else {
                aul();
            }
            this.dwg.clear();
            if (this.doH) {
                auj();
            }
            mo31419pQ(r);
            if (this.dxB != null) {
                if (this.doG && z) {
                    this.dxB.mo31522cv(this);
                    this.doG = false;
                }
                if (z) {
                    this.doJ = true;
                }
                this.dxB.mo31525y(this, r);
            }
            invalidate();
        }
        if (r != i) {
            this.dxA.mo31511hB(false);
            aui();
            this.dop = true;
        } else {
            this.dop = false;
        }
        return r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: pQ */
    public void mo31419pQ(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onGalleryMoved moveDistance=");
        sb.append(i);
        LogUtils.m14223i("VeGallery2", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo31420r(boolean z, int i) {
        int i2 = 0;
        View childAt = getChildAt((z ? this.aaE - 1 : 0) - this.dnS);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int centerOfGallery = this.doI ? getCenterOfGallery() : 0;
        if (childAt != null) {
            int cM = this.doI ? m20916cM(childAt) : 0;
            if (z) {
                if (this.doI) {
                    if (this.doH) {
                        if (cM <= centerOfGallery) {
                            return 0;
                        }
                    } else if (childAt.getRight() <= this.doS + centerOfGallery) {
                        return 0;
                    }
                } else if (childAt.getRight() <= width) {
                    return 0;
                }
            } else if (this.doI) {
                if (this.doH) {
                    if (cM >= centerOfGallery) {
                        return 0;
                    }
                } else if (childAt.getLeft() >= this.doR + centerOfGallery) {
                    return 0;
                }
            } else if (childAt.getLeft() >= paddingLeft) {
                return 0;
            }
            if (this.doI) {
                int i3 = this.doH ? centerOfGallery - cM : z ? (centerOfGallery - childAt.getRight()) + this.doS : (centerOfGallery - childAt.getLeft()) + this.doR;
                return z ? Math.max(i3, i) : Math.min(i3, i);
            }
            return z ? Math.max(width - childAt.getRight(), i) : Math.min(paddingLeft - childAt.getLeft(), i);
        } else if (this.doI && this.doH) {
            return i;
        } else {
            if (z) {
                int lastVisiblePosition = getLastVisiblePosition();
                View childAt2 = getChildAt(lastVisiblePosition - this.dnS);
                if (lastVisiblePosition < this.aaE - 1) {
                    i2 = ((this.aaE - 1) - lastVisiblePosition) * this.doK;
                }
                int right = i2 + (childAt2.getRight() - width) + (this.doq * ((this.aaE - 1) - lastVisiblePosition));
                if (this.doI) {
                    right += centerOfGallery - paddingLeft;
                }
                if (this.doH) {
                    right -= this.doK / 2;
                }
                return Math.max(-(right - this.doS), i);
            }
            int i4 = (this.dnS * this.doK) + (-getChildAt(0).getLeft()) + paddingLeft + (this.doq * this.dnS);
            if (this.doI) {
                i4 += centerOfGallery - paddingLeft;
            }
            if (this.doH) {
                i4 -= this.doK / 2;
            }
            return Math.min(i4 + this.doR, i);
        }
    }
}
