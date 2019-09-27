package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.support.p024v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.vivacamera.R;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.view.CaptrueRatioImageView */
public class CaptrueRatioImageView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public static final List bXh = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
    /* access modifiers changed from: private */

    /* renamed from: Kj */
    public int f3439Kj = 0;
    /* access modifiers changed from: private */
    public int[] bSm = {R.drawable.xiaoying_cam_cap_ration_icon_9x16, R.drawable.xiaoying_cam_cap_ration_icon_3x4, R.drawable.xiaoying_cam_cap_ration_icon_1x1};
    /* access modifiers changed from: private */
    public C5166a bXg;

    /* renamed from: com.introvd.template.camera.ui.view.CaptrueRatioImageView$a */
    public interface C5166a {
        /* renamed from: js */
        void mo26154js(int i);
    }

    public CaptrueRatioImageView(Context context) {
        super(context);
        initState();
    }

    public CaptrueRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initState();
    }

    public CaptrueRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initState();
    }

    private void initState() {
        setImageResource(this.bSm[this.f3439Kj]);
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CaptrueRatioImageView.this.f3439Kj = (CaptrueRatioImageView.this.f3439Kj + 1) % CaptrueRatioImageView.bXh.size();
                int intValue = ((Integer) CaptrueRatioImageView.bXh.get(CaptrueRatioImageView.this.f3439Kj)).intValue();
                CaptrueRatioImageView.this.setImageResource(CaptrueRatioImageView.this.bSm[CaptrueRatioImageView.this.f3439Kj]);
                CaptrueRatioImageView.this.invalidate();
                if (CaptrueRatioImageView.this.bXg != null) {
                    CaptrueRatioImageView.this.bXg.mo26154js(intValue);
                }
            }
        });
    }

    public void setCameraRatioMode(int i) {
        if (i < 0 || i > 2) {
            i = 2;
        }
        if (this.f3439Kj != bXh.indexOf(Integer.valueOf(i))) {
            this.f3439Kj = bXh.indexOf(Integer.valueOf(i));
            setImageResource(this.bSm[this.f3439Kj]);
        }
    }

    public void setmOnTimerModeChangeListener(C5166a aVar) {
        this.bXg = aVar;
    }
}
