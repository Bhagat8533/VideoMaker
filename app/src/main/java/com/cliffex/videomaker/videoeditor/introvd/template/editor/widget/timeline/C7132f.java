package com.introvd.template.editor.widget.timeline;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.RangeUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.widget.timeline.f */
public class C7132f {
    private static final int dvQ = C4583d.m11671P(2.0f);
    private static final int dvR = (dvQ + C4583d.m11671P(2.0f));
    private static float dvS = ((float) C4583d.m11671P(1.0f));
    private int cuk;
    private RectF dvT;
    private List<Range> dvU;
    private List<Range> dvV;
    private List<Range> dvW;
    private List<Range> dvX;
    private List<Range> dvY;
    private VeGallery2 dvZ;
    private int dwa;
    private int dwb;
    private int dwc;
    private int dwd;
    private int dwe;
    private int mDuration;
    private Paint mPaint;
    private int top = 0;

    C7132f(VeGallery2 veGallery2, QStoryboard qStoryboard) {
        this.dvZ = veGallery2;
        this.mDuration = qStoryboard.getDuration();
        this.cuk = this.mDuration % 3000;
        this.dvU = m21096d(qStoryboard, 3);
        this.dvV = m21096d(qStoryboard, 20);
        this.dvW = m21096d(qStoryboard, 8);
        this.dvX = m21096d(qStoryboard, 6);
        this.dvY = m21096d(qStoryboard, 40);
        this.mPaint = new Paint();
        this.dvT = new RectF();
        this.mPaint.setAntiAlias(true);
        this.dwa = this.dvZ.getContext().getResources().getColor(R.color.color_FF4400);
        this.dwb = this.dvZ.getContext().getResources().getColor(R.color.color_03A62B);
        this.dwc = this.dvZ.getContext().getResources().getColor(R.color.color_00BFDC);
        this.dwd = this.dvZ.getContext().getResources().getColor(R.color.color_ffbd18);
        this.dwe = this.dvZ.getContext().getResources().getColor(R.color.color_809500ff);
    }

    /* renamed from: a */
    private void m21094a(List<Range> list, Canvas canvas, int i) {
        if (list != null && list.size() != 0) {
            for (Range b : list) {
                m21095b(canvas, b, this.top, i);
            }
            this.top += dvR;
        }
    }

    /* renamed from: b */
    private void m21095b(Canvas canvas, Range range, int i, int i2) {
        if (range != null && range.getmTimeLength() > 0 && this.dvZ != null) {
            int i3 = range.getmPosition();
            int limitValue = range.getLimitValue();
            int kE = C7116a.m20990kE(i3);
            int kE2 = C7116a.m20990kE(limitValue);
            if (kE2 > this.mDuration) {
                kE2 = this.mDuration;
            }
            int a = C7116a.m20963a(this.dvZ) + kE;
            canvas.save();
            canvas.translate((float) a, (float) i);
            int i4 = kE2 - kE;
            int count = this.dvZ.getCount();
            if (this.cuk > 0) {
                count--;
            }
            int childWidth = (count * this.dvZ.getChildWidth()) + ((C7116a.cuf * this.cuk) / 3000);
            if (i4 > childWidth) {
                i4 = childWidth;
            }
            this.dvT.set(0.0f, 0.0f, (float) i4, (float) dvQ);
            this.mPaint.setColor(i2);
            canvas.drawRoundRect(this.dvT, dvS, dvS, this.mPaint);
            canvas.restore();
        }
    }

    /* renamed from: d */
    private List<Range> m21096d(QStoryboard qStoryboard, int i) {
        ArrayList t = C8530i.m24764t(C8419a.m24325a(qStoryboard, i, (VeMSize) null));
        ArrayList arrayList = new ArrayList();
        if (t != null) {
            Iterator it = t.iterator();
            while (it.hasNext()) {
                VeRange veRange = (VeRange) it.next();
                arrayList.add(new Range(veRange.getmPosition(), veRange.getmTimeLength()));
            }
        }
        return RangeUtils.getRangesWithoutIntersection(arrayList);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo31591e(Canvas canvas, int i) {
        if (this.dvZ != null) {
            this.top = ((i - C7116a.cuf) / 2) + C7116a.cuf + dvR;
            m21094a(this.dvU, canvas, this.dwb);
            m21094a(this.dvV, canvas, this.dwc);
            m21094a(this.dvW, canvas, this.dwa);
            m21094a(this.dvX, canvas, this.dwd);
            m21094a(this.dvY, canvas, this.dwe);
        }
    }
}
