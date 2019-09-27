package com.introvd.template.app.setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;

public class SettingBaseActivity extends PreferenceActivity implements OnClickListener {
    public int bBk = 0;
    private ImageView bCF;
    private TextView bCG;
    private ImageView bvn;

    /* renamed from: bI */
    public void mo24354bI(int i, int i2) {
        if (i != -1) {
            addPreferencesFromResource(i);
        }
        this.bCG.setText(i2);
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
            overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        } else if (view.equals(this.bCF)) {
            this.bBk++;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v4_setting_layout);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bCF = (ImageView) findViewById(R.id.imgview_workmode);
        this.bvn.setOnClickListener(this);
        this.bCF.setOnClickListener(this);
        this.bCG = (TextView) findViewById(R.id.text_title);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
