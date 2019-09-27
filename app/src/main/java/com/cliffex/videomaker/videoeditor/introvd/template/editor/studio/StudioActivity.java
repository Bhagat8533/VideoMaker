package com.introvd.template.editor.studio;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.base.utlisads.BannerAdmob;
import com.introvd.base.utlisads.CrashAll;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.editor.R;
import com.introvd.template.editor.studio.StudioFragment.C6884a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;

@C1942a(mo10417rZ = "/studio/entry")
public class StudioActivity extends EventActivity implements OnClickListener {
    private boolean diQ = true;
    /* access modifiers changed from: private */
    public View djD = null;
    private ImageView djE = null;
    private ImageView djF = null;
    private StudioFragment djG;
    private String djH = null;
    private boolean dji = false;

    private void ass() {
        Bundle bundle = new Bundle();
        bundle.putInt(StudioRouter.KEY_LIST_MODE, this.diQ ^ true ? 1 : 0);
        bundle.putBoolean("key_Is_ProjectSelectMode", this.dji);
        if (this.djG == null) {
            this.djG = (StudioFragment) C1919a.m5529sc().mo10355al(StudioRouter.FRAGMENT_URL).mo10412rX();
            this.djG.setArguments(bundle);
            this.djG.mo30521a((C6884a) new C6884a() {
                public void ast() {
                    if (StudioActivity.this.djD != null) {
                        StudioActivity.this.djD.setBackgroundResource(R.color.white);
                    }
                }
            });
            getSupportFragmentManager().beginTransaction().add(R.id.studio_recyclerview_container, (Fragment) this.djG).commitAllowingStateLoss();
            return;
        }
        this.djG.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().show(this.djG).commitAllowingStateLoss();
    }

    /* renamed from: hn */
    private void m20069hn(boolean z) {
        this.diQ = z;
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_preferences_studio_is_list_mode", this.diQ);
        if (z) {
            this.djF.setImageResource(R.drawable.editor_btn_draft_grid);
        } else {
            this.djF.setImageResource(R.drawable.editor_btn_draft_list);
        }
    }

    private void initUI() {
        this.djD = findViewById(R.id.studio_title_bar_layout);
        this.djE = (ImageView) findViewById(R.id.xiaoying_com_btn_left);
        this.djF = (ImageView) findViewById(R.id.xiaoying_com_btn_right);
        this.djF.setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.xiaoying_com_textview_title);
        this.djE.setImageResource(R.drawable.vivavideo_com_nav_back);
        this.djE.setOnClickListener(this);
        this.djF.setOnClickListener(this);
        if (this.dji) {
            textView.setText(this.djH);
        } else {
            textView.setText(R.string.xiaoying_str_ve_studio_title);
        }
        this.diQ = AppPreferencesSetting.getInstance().getAppSettingBoolean("key_preferences_studio_is_list_mode", true);
        m20069hn(this.diQ);
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf()) {
            if (view.equals(this.djE)) {
                finish();
            } else if (view.equals(this.djF)) {
                m20069hn(!this.diQ);
                if (this.djG != null) {
                    this.djG.mo30522ho(this.diQ);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CrashAll.loadAndshow(this, "las_StudioActivity");
        ActionFirebaseStarVlogs.actionMyStudioActivity(this);
        this.dji = getIntent().getBooleanExtra(StudioRouter.KEY_IS_PROJECT_SELECT_MODE, false);
        this.djH = getIntent().getStringExtra(StudioRouter.KEY_IS_CUSTOM_TITLE);
        setContentView(R.layout.editor_act_studio_layout);
        BannerAdmob.setupDataBannerAdmob(this);
        initUI();
        ass();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            C7680l.aAe().releasePosition(3);
            C7680l.aAe().releasePosition(2);
            C7680l.aAe().releasePosition(17);
        }
    }
}
