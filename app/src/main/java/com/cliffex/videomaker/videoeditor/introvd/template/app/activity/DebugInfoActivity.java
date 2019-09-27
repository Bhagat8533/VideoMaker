package com.introvd.template.app.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.common.debug.DebugToolsMgr;
import com.p131c.p132a.C2561a;

public class DebugInfoActivity extends EventActivity {
    /* renamed from: HI */
    private void m8977HI() {
        TextView textView = (TextView) findViewById(R.id.ac_debug_info_tv);
        StringBuilder sb = new StringBuilder("Release Build\n");
        sb.append("\n");
        sb.append("BuildConfig.APPLICATION_ID = ");
        sb.append("com.quvideo.xiaoying");
        sb.append("\n");
        sb.append("packageName = ");
        sb.append(C2561a.eJr);
        sb.append("\n");
        sb.append("VersionCode = ");
        sb.append(C2561a.eJq);
        sb.append("\n");
        sb.append("VersionName = ");
        sb.append(C2561a.bKL);
        sb.append("\n");
        sb.append("VERSION_TYPE_NORMAL = 1");
        sb.append("\n");
        sb.append("VERSION_TYPE_LITE_HUAWEI = 2");
        sb.append("\n");
        sb.append("VERSION_TYPE_PRO = 4");
        sb.append("\n");
        sb.append(",getVersionType = ");
        sb.append(C2561a.aOR());
        sb.append("\n");
        sb.append("TargetSDKVersion = ");
        sb.append(C2561a.eJs);
        sb.append("\n");
        textView.setText(sb);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug_info);
        findViewById(R.id.ac_debug_show_ue).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DebugToolsMgr.showUETools();
            }
        });
        findViewById(R.id.ac_debug_hide_ue).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DebugToolsMgr.hideUETools();
            }
        });
        m8977HI();
    }
}
