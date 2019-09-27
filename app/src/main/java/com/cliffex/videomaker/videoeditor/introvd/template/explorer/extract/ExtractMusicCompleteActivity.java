package com.introvd.template.explorer.extract;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.vivaexplorermodule.R;
import com.introvd.template.xyui.C9163c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

@LDPProtect
@C1942a(mo10417rZ = "/Explorer/MusicDirectExtract")
public class ExtractMusicCompleteActivity extends EventActivity implements C7237d {
    public static final String TAG = "ExtractMusicCompleteActivity";
    private SeekBar cAF;
    private String csh;
    private ImageView dyb;
    private TextView dyc;
    private ImageView dyd;
    private TextView dye;
    private TextView dyf;
    /* access modifiers changed from: private */
    public EditText dyg;
    private TextView dyh;
    private TextView dyi;
    private TextView dyj;
    private View dyk;
    private TextView dyl;
    private TextView dym;
    /* access modifiers changed from: private */
    public boolean dyn = false;
    private String dyo;
    private String dyp;
    /* access modifiers changed from: private */
    public C7234b dyq;

    /* renamed from: Oj */
    private void m21314Oj() {
        this.dyb = (ImageView) findViewById(R.id.title_bar_left_btn);
        this.dyc = (TextView) findViewById(R.id.title_bar_title);
        this.dyd = (ImageView) findViewById(R.id.play_pause_btn);
        this.cAF = (SeekBar) findViewById(R.id.seekbar_simple_music);
        this.dye = (TextView) findViewById(R.id.play_music_duration);
        this.dyf = (TextView) findViewById(R.id.file_name_text);
        this.dyg = (EditText) findViewById(R.id.file_name_edittext);
        this.dyh = (TextView) findViewById(R.id.rename_btn);
        this.dyi = (TextView) findViewById(R.id.save_success_label);
        this.dyj = (TextView) findViewById(R.id.save_path_text);
        this.dyl = (TextView) findViewById(R.id.save_btn);
        this.dyk = findViewById(R.id.edittext_line);
        this.dym = (TextView) findViewById(R.id.discard_and_quit_btn);
    }

    private void avW() {
        this.dyo = getIntent().getStringExtra(ExplorerRouter.INTENT_KEY_MUSIC_DIRECT_EXTRACT_FILE_PATH);
        this.csh = this.dyo;
        this.dyp = this.dyo;
    }

    private void awa() {
        this.dyc.setText(getResources().getString(R.string.xiaoying_music_extract_success_text));
    }

    private void awb() {
        this.dyq = new C7234b();
        this.dyq.attachView((C7237d) this);
        this.dyq.mo31743eg(this.csh);
    }

    private void awc() {
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicCompleteActivity.this.finish();
            }
        }, this.dyb);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicCompleteActivity.this.awg();
            }
        }, this.dyd);
        this.cAF.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (ExtractMusicCompleteActivity.this.dyq != null && ExtractMusicCompleteActivity.this.dyn) {
                    ExtractMusicCompleteActivity.this.dyq.seekTo(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                ExtractMusicCompleteActivity.this.dyn = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                ExtractMusicCompleteActivity.this.dyn = false;
            }
        });
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicCompleteActivity.this.m21320cP(view);
            }
        }, this.dyl);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicCompleteActivity.this.awd();
            }
        }, this.dyh);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicCompleteActivity.this.awf();
                ExtractMusicCompleteActivity.this.setResult(-1);
                ExtractMusicCompleteActivity.this.finish();
            }
        }, this.dym);
    }

    /* access modifiers changed from: private */
    public void awd() {
        if (this.dyf != null && this.dyg != null) {
            int i = 8;
            int i2 = 0;
            boolean z = 8 == this.dyf.getVisibility();
            if (!z) {
                if (!TextUtils.isEmpty(this.dyf.getText()) && !TextUtils.isEmpty(this.dyf.getText().toString()) && !TextUtils.isEmpty(this.dyf.getText().toString().trim())) {
                    String replace = this.dyf.getText().toString().trim().replace(".m4a", "");
                    this.dyg.setText(replace);
                    m21324s(true, replace.length());
                } else {
                    return;
                }
            } else if (TextUtils.isEmpty(this.dyg.getText()) || TextUtils.isEmpty(this.dyg.getText().toString()) || TextUtils.isEmpty(this.dyg.getText().toString().trim())) {
                ToastUtils.show(getApplicationContext(), getResources().getString(R.string.xiaoying_music_extract_rename_empty_toast_text), 0);
                return;
            } else {
                m21324s(false, 0);
                String trim = this.dyg.getText().toString().trim();
                TextView textView = this.dyf;
                StringBuilder sb = new StringBuilder();
                sb.append(trim);
                sb.append(".m4a");
                textView.setText(sb.toString());
                String fileParentPath = FileUtils.getFileParentPath(this.csh);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(fileParentPath);
                sb2.append(trim);
                sb2.append(".m4a");
                this.dyp = sb2.toString();
                if (FileUtils.renameFile(this.csh, this.dyp)) {
                    this.csh = this.dyp;
                }
            }
            this.dyf.setVisibility(z ? 0 : 8);
            EditText editText = this.dyg;
            if (!z) {
                i = 0;
            }
            editText.setVisibility(i);
            View view = this.dyk;
            if (z) {
                i2 = 4;
            }
            view.setVisibility(i2);
            this.dyh.setText(z ? getResources().getString(R.string.xiaoying_music_extract_rename_text) : getResources().getString(R.string.xiaoying_str_com_ok));
        }
    }

    private void awe() {
        if (!TextUtils.isEmpty(this.dyp)) {
            String fileNameWithFormat = FileUtils.getFileNameWithFormat(this.dyp);
            StringBuilder sb = new StringBuilder();
            sb.append(C8401d.anh());
            sb.append(fileNameWithFormat);
            String sb2 = sb.toString();
            boolean z = true;
            if (!TextUtils.isEmpty(this.dyp) && !TextUtils.isEmpty(sb2) && !this.dyp.equalsIgnoreCase(sb2)) {
                z = FileUtils.copyFile(this.dyp, sb2);
            }
            m21323hV(z);
            if (z) {
                this.csh = sb2;
                this.dyp = sb2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void awf() {
        if (!TextUtils.isEmpty(this.dyp) && !TextUtils.isEmpty(C8401d.anh()) && FileUtils.getFileParentPath(this.dyp).equalsIgnoreCase(FileUtils.getFileParentPath(this.dyo))) {
            FileUtils.deleteFile(this.dyp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cP */
    public void m21320cP(View view) {
        if (!C8072q.aBx().mo33072ku(C7825a.AUDIO_EXTRA.getId())) {
            C8049f.aBf().mo33097b(this, C8070o.aBw(), C7825a.AUDIO_EXTRA.getId(), "Export_music_extraction", -1);
            return;
        }
        awe();
    }

    /* renamed from: hV */
    private void m21323hV(boolean z) {
        if (z) {
            awf();
            this.dyi.setVisibility(0);
            this.dyj.setVisibility(0);
            this.dyj.setText(getResources().getString(R.string.xiaoying_musci_extract_direct_save_path_text, new Object[]{C8401d.anh()}));
            return;
        }
        this.dyi.setVisibility(0);
        this.dyi.setText(getResources().getString(R.string.xiaoying_music_extract_direct_save_fail_text));
        this.dyj.setVisibility(4);
    }

    private void initData() {
        if (!TextUtils.isEmpty(this.csh)) {
            this.dyf.setText(FileUtils.getFileNameWithFormat(this.csh));
        }
    }

    /* renamed from: s */
    private void m21324s(boolean z, int i) {
        if (z) {
            this.dyg.setSelection(i);
            this.dyg.postDelayed(new Runnable() {
                public void run() {
                    ExtractMusicCompleteActivity.this.dyg.setFocusable(true);
                    ExtractMusicCompleteActivity.this.dyg.setFocusableInTouchMode(true);
                    ExtractMusicCompleteActivity.this.dyg.requestFocus();
                    ((InputMethodManager) ExtractMusicCompleteActivity.this.getSystemService("input_method")).showSoftInput(ExtractMusicCompleteActivity.this.dyg, 1);
                }
            }, 200);
            return;
        }
        this.dyg.clearFocus();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.dyg.getWindowToken(), 0);
    }

    public void awg() {
        if (this.dyd != null && this.dyq != null) {
            if (this.dyd.isSelected()) {
                this.dyd.setSelected(false);
                this.dyq.pause();
            } else {
                this.dyd.setSelected(true);
                this.dyq.play();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.explorer_extract_music_direct_layout);
        avW();
        m21314Oj();
        awa();
        awc();
        awb();
        initData();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.dyq != null) {
            this.dyq.onActivityDestory();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.dyq != null) {
            this.dyq.onActivityPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.dyq != null) {
            this.dyq.onActivityResume();
        }
    }

    /* renamed from: qy */
    public void mo31710qy(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        if (i == 100) {
            this.dyd.setSelected(false);
        }
        if (this.cAF != null) {
            this.cAF.setProgress(i);
        }
    }

    /* renamed from: qz */
    public void mo31711qz(int i) {
        String str = "00:00";
        if (this.dye != null) {
            if (i > 0) {
                str = C9163c.m26664kg(i);
            }
            this.dye.setText(str);
        }
    }
}
