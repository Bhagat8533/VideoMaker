package com.introvd.template.app.youngermode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.JsonObject;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.youngermode.ItemPasswordLayout.C4536a;
import com.introvd.template.app.youngermode.p201a.C4549b;
import com.introvd.template.app.youngermode.p202b.C4556a;
import com.introvd.template.common.ResultListener;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.utils.UtilsKeyBord;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.router.AppRouter.YoungerModeParams;
import com.introvd.template.util.SpanUtils;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/XYyoungerSettingActivity")
public class XYyoungerSettingActivity extends EventActivity {
    /* access modifiers changed from: private */

    /* renamed from: Fs */
    public int f3407Fs;
    private TextView bJQ;
    private TextView bJR;
    /* access modifiers changed from: private */
    public TextView bJS;
    private TextView bJT;
    /* access modifiers changed from: private */
    public ItemPasswordLayout bJU;
    /* access modifiers changed from: private */
    public String bJV;
    private boolean bJW = true;
    private ImageView byK;

    /* renamed from: In */
    private void m11457In() {
        this.byK.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ResultListener RL = C4553b.m11491RJ().mo24786RL();
                if (RL != null) {
                    RL.onError(new Exception(C5878a.TAG));
                }
                XYyoungerSettingActivity.this.finish();
            }
        });
        this.bJT.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4545a.m11479dr(XYyoungerSettingActivity.this);
                if (XYyoungerSettingActivity.this.f3407Fs == 5) {
                    C4556a.m11512j(XYyoungerSettingActivity.this, "找回密码", "手动关闭");
                } else if (XYyoungerSettingActivity.this.f3407Fs == 4) {
                    C4556a.m11512j(XYyoungerSettingActivity.this, "找回密码", "宵禁");
                } else if (XYyoungerSettingActivity.this.f3407Fs == 3) {
                    C4556a.m11512j(XYyoungerSettingActivity.this, "找回密码", "超时");
                }
            }
        });
        this.bJU.setInputCompleteListener(new C4536a() {
            /* renamed from: RE */
            public void mo24770RE() {
                UtilsKeyBord.hideKeyBoard(XYyoungerSettingActivity.this, XYyoungerSettingActivity.this.bJU.getEditText());
                XYyoungerSettingActivity.this.bJS.setEnabled(true);
                XYyoungerSettingActivity.this.bJS.setSelected(true);
                if (XYyoungerSettingActivity.this.f3407Fs == 4 || XYyoungerSettingActivity.this.f3407Fs == 3) {
                    XYyoungerSettingActivity.this.bJV = XYyoungerSettingActivity.this.bJU.getStrPassword();
                    C4549b.m11487V(XYyoungerSettingActivity.this.bJV, "2").mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                        /* renamed from: a */
                        public void mo9883a(C1495b bVar) {
                        }

                        /* renamed from: a */
                        public void onSuccess(JsonObject jsonObject) {
                            if (jsonObject.get("state").getAsBoolean()) {
                                if (XYyoungerSettingActivity.this.f3407Fs == 4) {
                                    C4560d.m11516RN().mo24813cc(true);
                                    C4556a.m11512j(XYyoungerSettingActivity.this, "输入密码", "宵禁");
                                } else if (XYyoungerSettingActivity.this.f3407Fs == 3) {
                                    C4556a.m11512j(XYyoungerSettingActivity.this, "输入密码", "超时");
                                    if (C4545a.m11475RF()) {
                                        C4560d.m11516RN().mo24813cc(true);
                                    }
                                }
                                ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_allow_40_min);
                                C4560d.m11516RN().mo24809RR();
                                C4560d.m11516RN().mo24811ca(true);
                                C4553b.m11491RJ().mo24788bY(true);
                                XYyoungerSettingActivity.this.finish();
                                return;
                            }
                            ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_password_error);
                        }

                        public void onError(Throwable th) {
                        }
                    });
                }
            }

            public void delete() {
                XYyoungerSettingActivity.this.bJS.setEnabled(false);
                XYyoungerSettingActivity.this.bJS.setSelected(false);
            }
        });
        this.bJS.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (XYyoungerSettingActivity.this.f3407Fs == 1) {
                    XYyoungerSettingActivity.this.bJV = XYyoungerSettingActivity.this.bJU.getStrPassword();
                    C1487a.aUa().mo9777a(new Runnable() {
                        public void run() {
                            XYyoungerSettingActivity.this.bJU.clearText();
                            XYyoungerSettingActivity.this.f3407Fs = 2;
                            XYyoungerSettingActivity.this.m11460RI();
                        }
                    }, 500, TimeUnit.MILLISECONDS);
                    C4556a.m11506ad(XYyoungerSettingActivity.this, "第一次输入密码");
                } else if (XYyoungerSettingActivity.this.f3407Fs == 2) {
                    C4556a.m11506ad(XYyoungerSettingActivity.this, "再次输入密码");
                    if (!XYyoungerSettingActivity.this.bJV.equals(XYyoungerSettingActivity.this.bJU.getStrPassword())) {
                        ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_two_input_error);
                    } else {
                        C4549b.m11487V(XYyoungerSettingActivity.this.bJV, "1").mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                            /* renamed from: a */
                            public void mo9883a(C1495b bVar) {
                            }

                            /* renamed from: a */
                            public void onSuccess(JsonObject jsonObject) {
                                if (jsonObject.get("state").getAsBoolean()) {
                                    C4556a.m11510dt(XYyoungerSettingActivity.this);
                                    ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_open_success);
                                    C4553b.m11491RJ().mo24788bY(true);
                                    C4553b.m11491RJ().init(XYyoungerSettingActivity.this.getApplicationContext());
                                    C4560d.m11516RN().mo24812cb(false);
                                    C4560d.m11516RN().mo24811ca(true);
                                    C4553b.m11491RJ().mo24788bY(true);
                                    Intent intent = new Intent();
                                    intent.setAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_OPEN);
                                    LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                                    XYyoungerSettingActivity.this.finish();
                                }
                            }

                            public void onError(Throwable th) {
                            }
                        });
                    }
                } else if (XYyoungerSettingActivity.this.f3407Fs == 5) {
                    XYyoungerSettingActivity.this.bJV = XYyoungerSettingActivity.this.bJU.getStrPassword();
                    C4549b.m11487V(XYyoungerSettingActivity.this.bJV, "0").mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                        /* renamed from: a */
                        public void mo9883a(C1495b bVar) {
                        }

                        /* renamed from: a */
                        public void onSuccess(JsonObject jsonObject) {
                            if (jsonObject.get("state").getAsBoolean()) {
                                C4556a.m11512j(XYyoungerSettingActivity.this, "输入密码", "手动关闭");
                                C4560d.m11516RN().mo24813cc(false);
                                ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_close_mode);
                                C4560d.m11516RN().mo24811ca(false);
                                C4553b.m11491RJ().mo24788bY(false);
                                ResultListener RL = C4553b.m11491RJ().mo24786RL();
                                if (RL != null) {
                                    RL.onSuccess("success");
                                }
                                Intent intent = new Intent();
                                intent.setAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_CLOSE);
                                LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                                XYyoungerSettingActivity.this.finish();
                                return;
                            }
                            ToastUtils.shortShow((Context) XYyoungerSettingActivity.this, R.string.viva_younger_password_error);
                        }

                        public void onError(Throwable th) {
                        }
                    });
                }
            }
        });
    }

    /* renamed from: PN */
    private void m11458PN() {
        if (getIntent() != null) {
            this.f3407Fs = getIntent().getIntExtra(YoungerModeParams.INTENT_EXTRA_KEY_MODE_TYPE, 1);
        }
    }

    /* renamed from: RH */
    private void m11459RH() {
        switch (this.f3407Fs) {
            case 3:
                C4556a.m11508af(this, "超时");
                return;
            case 4:
                C4556a.m11508af(this, "宵禁");
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: RI */
    public void m11460RI() {
        switch (this.f3407Fs) {
            case 1:
                this.bJQ.setText(R.string.viva_younger_set_password);
                this.bJR.setText(R.string.viva_younger_open_content2);
                this.bJT.setVisibility(8);
                this.bJS.setVisibility(0);
                this.bJS.setEnabled(false);
                this.bJS.setSelected(false);
                return;
            case 2:
                this.bJQ.setText(R.string.viva_younger_sure_password);
                this.bJR.setText(R.string.viva_younger_open_content2);
                this.bJT.setVisibility(8);
                this.bJS.setVisibility(0);
                this.bJS.setEnabled(false);
                this.bJS.setSelected(false);
                return;
            case 3:
                this.bJQ.setText(R.string.viva_younger_input_password);
                this.bJR.setText(R.string.viva_younger_allow_time_content);
                this.bJT.setVisibility(0);
                this.bJS.setVisibility(8);
                this.byK.setVisibility(8);
                this.bJW = false;
                this.bJQ.setText(R.string.viva_younger_input_password);
                this.bJR.setText(R.string.viva_younger_allow_time_content);
                this.bJT.setVisibility(8);
                this.bJS.setVisibility(0);
                return;
            case 4:
                this.bJQ.setText(R.string.viva_younger_input_password);
                this.bJR.setText(R.string.viva_younger_allow_time_content2);
                this.bJT.setVisibility(0);
                this.bJS.setVisibility(8);
                this.byK.setVisibility(8);
                this.bJW = false;
                return;
            case 5:
                this.bJQ.setText(R.string.viva_younger_close_mode_title);
                this.bJR.setText(R.string.viva_younger_close_mode_content);
                this.bJT.setVisibility(0);
                this.bJS.setVisibility(0);
                this.bJS.setEnabled(false);
                this.bJS.setSelected(false);
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (this.bJW) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_younger_setting);
        m11458PN();
        this.byK = (ImageView) findViewById(R.id.younger_back);
        this.bJQ = (TextView) findViewById(R.id.younger_title);
        this.bJR = (TextView) findViewById(R.id.younger_subtitle);
        this.bJS = (TextView) findViewById(R.id.younger_finish_confirm);
        this.bJT = (TextView) findViewById(R.id.younger_forget_password);
        this.bJU = (ItemPasswordLayout) findViewById(R.id.younger_input_password);
        m11457In();
        m11460RI();
        try {
            String charSequence = this.bJT.getText().toString();
            String substring = charSequence.substring(0, charSequence.indexOf("？") + 1);
            String substring2 = charSequence.substring(charSequence.indexOf("？") + 1);
            SpanUtils spanUtils = new SpanUtils();
            spanUtils.mo35760B(substring).mo35760B(substring2).aNj().mo35767vH(getResources().getColor(R.color.color_ff5e13)).mo35766vG(17);
            this.bJT.setText(spanUtils.aNl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m11459RH();
    }
}
