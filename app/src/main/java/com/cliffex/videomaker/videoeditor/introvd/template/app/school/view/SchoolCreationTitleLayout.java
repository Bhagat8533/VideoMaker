package com.introvd.template.app.school.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.creation.C3814a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class SchoolCreationTitleLayout extends ConstraintLayout {
    private DynamicLoadingImageView bAi;
    private DynamicLoadingImageView bAj;
    private TextView bAk;
    private View bol;

    public SchoolCreationTitleLayout(Context context) {
        super(context);
        m10700Iu();
    }

    public SchoolCreationTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10700Iu();
    }

    public SchoolCreationTitleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10700Iu();
    }

    /* renamed from: Iu */
    private void m10700Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.app_include_school_creation_title, this, true);
        this.bAk = (TextView) findViewById(R.id.tvTitle);
        this.bAi = (DynamicLoadingImageView) findViewById(R.id.btn_shuffle);
        this.bol = findViewById(R.id.btn_shuffle_dot);
        this.bAj = (DynamicLoadingImageView) findViewById(R.id.btn_vip);
        mo24265Kp();
    }

    /* renamed from: Kp */
    public void mo24265Kp() {
        C3814a.m9345a(this.bAj);
        C3814a.m9346a(this.bAi, this.bol);
    }

    public void setTitle(int i) {
        this.bAk.setText(i);
    }
}
