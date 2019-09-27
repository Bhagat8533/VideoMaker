package com.introvd.template.app.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.databinding.C0171f;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1898d;
import com.afollestad.materialdialogs.C1890f.C1899e;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.app.C3885h;
import com.introvd.template.app.model.SplashItemInfo;
import com.introvd.template.app.splash.C4361c;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.html.HtmlTagHandler;
import com.introvd.template.common.html.SpanTagHandler;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.datacenter.ProviderUtil;
import com.introvd.template.origin.route.C8150d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p310g.C7353a;
import com.introvd.template.perf.C8159a;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.performance.PerformanceServiceProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.ironsource.environment.ConnectivityService;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.rescue.C4905b;
import com.quvideo.rescue.p220c.p221a.C4910a;
import com.vivalab.p427a.C9268a;
import java.io.File;
import java.util.regex.Pattern;

public class ExtraHelpActivity extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public static final String[] biR = {"1.31.163.255", "173.104.72.25", "1.32.138.255", "1.9.240.255", "1.37.255.255", "200.180.201.106", "58.29.100.20", "88.150.157.84", "58.65.240.100", "1.1.127.255", "59.112.0.0", "62.3.0.1", "223.225.129.232", "41.176.100.100", "194.170.29.230", "168.187.244.62", "197.131.255.255", "212.57.20.169", "62.5.128.13", "188.103.19.120", "188.79.135.152", "89.227.214.131", "195.23.255.255", "1.20.0.0", "151.95.219.6"};
    private static final String[] biS = {"中国", "美国", "新加坡", "马拉西亚", "菲律宾", "巴西", "韩国", "英国", "印尼", "日本", "台湾", "沙特", "印度", "埃及", "阿联酋", "科威特", "摩洛哥", "Turkey", "俄罗斯", "德国", "西班牙", "法国", "葡萄牙", "泰国", "意大利"};
    private static final Pattern biV = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private View biT;
    /* access modifiers changed from: private */
    public C7353a biU;

    /* renamed from: HJ */
    private void m8978HJ() {
        StringBuilder HL = m8979HL();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append(HL.toString());
        sb.append("</body></html>");
        this.biU.coN.setText(HtmlTagHandler.fromHtml(sb.toString(), null, new SpanTagHandler(), new ClickableSpan() {
            public void onClick(View view) {
                Object tag = view.getTag(R.id.tag_link_url);
                if (tag instanceof String) {
                    String str = "";
                    if ("copy_auid".equals(tag)) {
                        str = UserServiceProxy.getUserId();
                    } else if ("copy_duid".equals(tag)) {
                        str = C4580b.m11653dz(ExtraHelpActivity.this.getApplicationContext());
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ClipboardManager clipboardManager = (ClipboardManager) ExtraHelpActivity.this.getSystemService("clipboard");
                        ClipData newPlainText = ClipData.newPlainText("copy", str);
                        if (clipboardManager != null) {
                            clipboardManager.setPrimaryClip(newPlainText);
                            ExtraHelpActivity extraHelpActivity = ExtraHelpActivity.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("copy success : ");
                            sb.append(str);
                            ToastUtils.show((Context) extraHelpActivity, sb.toString(), 0);
                        }
                    }
                }
            }
        }));
        this.biU.coN.setMovementMethod(new LinkMovementMethod());
    }

    /* renamed from: HL */
    private StringBuilder m8979HL() {
        String dx = C4580b.m11651dx(getApplicationContext());
        StringBuilder sb = new StringBuilder();
        String str = "IEditorService has not implementation.";
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            str = String.valueOf(iEditorService.getEngineVersion());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("countrycode=");
        sb2.append(AppStateModel.getInstance().getCountryCode());
        sb.append(sb2.toString());
        sb.append("<br/>");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("zone=");
        sb3.append(AppStateModel.getInstance().getZoneCode());
        sb.append(sb3.toString());
        sb.append("<br/>");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("socialstate=");
        sb4.append(AppStateModel.getInstance().isCommunitySupport());
        sb.append(sb4.toString());
        sb.append("<br/>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("modelname=");
        sb5.append(Build.MODEL);
        sb.append(sb5.toString());
        sb.append("<br/>");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("android ver:");
        sb6.append(VERSION.SDK_INT);
        sb6.append("-->");
        sb6.append(VERSION.CODENAME);
        sb.append(sb6.toString());
        sb.append("<br/>");
        StringBuilder sb7 = new StringBuilder();
        sb7.append("App_ver:");
        sb7.append(C4582c.m11667dD(getApplicationContext()));
        sb.append(sb7.toString());
        sb.append("<br/>");
        sb.append("App_ver_code:1");
        sb.append("<br/>");
        StringBuilder sb8 = new StringBuilder();
        sb8.append("channel:");
        sb8.append(dx);
        sb.append(sb8.toString());
        sb.append("<br/>");
        StringBuilder sb9 = new StringBuilder();
        sb9.append("手机厂商:");
        sb9.append(Build.MANUFACTURER);
        sb.append(sb9.toString());
        sb.append("<br/>");
        StringBuilder sb10 = new StringBuilder();
        sb10.append("Engine version:");
        sb10.append(str);
        sb.append(sb10.toString());
        String userId = UserServiceProxy.getUserId();
        String dz = C4580b.m11653dz(getApplicationContext());
        if (!TextUtils.isEmpty(userId)) {
            sb.append("<br/> 用户ID：");
            sb.append(userId);
            sb.append(" <a href='copy_auid' color='#8e8e93'>复制</a>");
        }
        if (!TextUtils.isEmpty(dz)) {
            sb.append("<br/> 设备ID：");
            sb.append(dz);
            sb.append(" <a href='copy_duid' color='#8e8e93'>复制</a>");
        }
        return sb;
    }

    /* renamed from: bO */
    private String m8987bO(Context context) {
        try {
            int ipAddress = ((WifiManager) context.getSystemService(ConnectivityService.NETWORK_TYPE_WIFI)).getConnectionInfo().getIpAddress();
            String format = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
            StringBuilder sb = new StringBuilder();
            sb.append("在PC浏览器打开http://");
            sb.append(format);
            sb.append(":9988即可查看事件上报");
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: by */
    public /* synthetic */ boolean m8988by(View view) {
        new C1895a(this).mo10315r("以二进制表示状态，以最低位为第一位，0表示否，1表示是; 第一位表示是否社区开启；第二位表示是否开启热门；第三位表示是否开启发现页。；第四位表示是否开启附近。；第五位表示是否开启消息页。第六位表示是否简化社区版，第七位表示是否开启学院").mo10281a((C1904j) C3704c.biX).mo10314qv();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: bz */
    public /* synthetic */ void m8989bz(View view) {
        int parseInt = C2575a.parseInt(this.biU.coG.getText().toString());
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_snsflag", parseInt);
        StringBuilder sb = new StringBuilder();
        sb.append("Applay SNS flag : ");
        sb.append(parseInt);
        sb.append(" \n 请重启app");
        ToastUtils.show((Context) this, sb.toString(), 1);
    }

    /* renamed from: dm */
    public static boolean m8990dm(String str) {
        return biV.matcher(str).matches();
    }

    /* access modifiers changed from: private */
    /* renamed from: gk */
    public void m8991gk(final int i) {
        new C1895a(this).mo10283a((CharSequence) "输入视频比特率调节比例值，浮点数，乘以 默认比特率作为实际比特率", (CharSequence) "1.0f", (C1898d) new C1898d() {
            /* renamed from: a */
            public void mo10327a(C1890f fVar, CharSequence charSequence) {
                ExtraHelpActivity extraHelpActivity = ExtraHelpActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("视频比特率 参数值：");
                sb.append(charSequence);
                ToastUtils.show((Context) extraHelpActivity, sb.toString(), 0);
                try {
                    float floatValue = Float.valueOf(charSequence.toString()).floatValue();
                    IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                    if (iEditorService != null) {
                        iEditorService.updateQualityParams(i, floatValue, floatValue, floatValue);
                    }
                } catch (Exception unused) {
                    ToastUtils.show((Context) ExtraHelpActivity.this, "视频比特率 参数值：请输入浮点数", 0);
                }
            }
        }).mo10314qv();
    }

    /* access modifiers changed from: protected */
    /* renamed from: HK */
    public void mo23037HK() {
        findViewById(R.id.btn_apk_info).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ExtraHelpActivity.this.startActivity(new Intent(ExtraHelpActivity.this, DebugInfoActivity.class));
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.logger_event_to_web);
        checkBox.setChecked(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_logger_event_to_web", false));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                compoundButton.setChecked(z);
                AppPreferencesSetting.getInstance().setAppSettingBoolean("key_logger_event_to_web", z);
                if (z) {
                    C9268a.m26955q(VivaBaseApplication.m8749FZ());
                    C9268a.m26956r(VivaBaseApplication.m8749FZ());
                } else {
                    C9268a.m26957s(VivaBaseApplication.m8749FZ());
                }
                UserBehaviorLog.setLoggerDebug(z);
            }
        });
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.ad_log_cb);
        checkBox2.setChecked(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_can_output_ad_log", false));
        checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                compoundButton.setChecked(z);
                VivaAdLog.setCanOutputLog(z);
                AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_can_output_ad_log", z);
            }
        });
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.faker_google_channel_cb);
        checkBox3.setChecked(PerformanceServiceProxy.getFakeGoogle());
        checkBox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (PerformanceServiceProxy.setFakeGoogle(z)) {
                    compoundButton.setChecked(z);
                } else {
                    ToastUtils.show((Context) ExtraHelpActivity.this, "sorry, not support!", 0);
                }
            }
        });
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.force_show_logo_watermark_cb);
        checkBox4.setChecked(UtilsPrefs.with(getApplicationContext(), EditorRouter.VIVA_EDITOR_PREF_FILENAME, true).readBoolean(EditorRouter.KEY_FORCE_SHOW_LOGO_WATERMARK, false));
        checkBox4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                compoundButton.setChecked(z);
                UtilsPrefs.with(ExtraHelpActivity.this.getApplicationContext(), EditorRouter.VIVA_EDITOR_PREF_FILENAME, true).writeBoolean(EditorRouter.KEY_FORCE_SHOW_LOGO_WATERMARK, z);
            }
        });
        ((Button) findViewById(R.id.btn_export_key_path)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4905b.m12542b(new C4910a() {
                    /* renamed from: F */
                    public void mo23043F(String str, String str2) {
                        File file = new File("/sdcard/XiaoYing/Performance/keypath/");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        ExtraHelpActivity extraHelpActivity = ExtraHelpActivity.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Export path = ");
                        sb.append(file);
                        ToastUtils.show((Context) extraHelpActivity, sb.toString(), 0);
                        FileUtils.copyDirectory(str, file.getPath());
                    }

                    /* renamed from: Fk */
                    public void mo23044Fk() {
                    }
                });
            }
        });
    }

    public void onClick(View view) {
        if (view.equals(this.biU.cot)) {
            String charSequence = this.biU.coF.getText().toString();
            if (!m8990dm(charSequence)) {
                this.biU.coF.setText("");
                ToastUtils.show(getApplicationContext(), "设置失败", 0);
                return;
            }
            ToastUtils.show(getApplicationContext(), "设置成功，需要重启App才能生效，确保用户没登录", 0);
            AppPreferencesSetting.getInstance().setAppSettingStr("app_ip_key", charSequence);
            C3885h.m9561Hs();
            new C8150d().mo33232R(getApplicationContext(), false);
        } else if (view.equals(this.biU.cov)) {
            SplashItemInfo cP = C4361c.m10978cP(getApplicationContext());
            StringBuilder sb = new StringBuilder();
            if (cP != null) {
                sb.append(cP.mEventCode);
                sb.append("\t");
                sb.append(cP.mTitle);
                sb.append("\t");
                sb.append(cP.mPublishTime);
                sb.append("\t");
                sb.append(cP.mExpireTime);
                sb.append("\n\r");
                sb.append(cP.mUrl);
            } else {
                sb.append("no splash yet");
            }
            this.biU.coN.setText(sb.toString());
        } else if (view.equals(this.biU.cox)) {
            C4361c.m10975cM(getApplicationContext());
        } else if (view.equals(this.biU.coF)) {
            new C1895a(this).mo10288aA(false).mo10287a((CharSequence[]) biS).mo10280a((C1899e) new C1899e() {
                /* renamed from: a */
                public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                    ExtraHelpActivity.this.biU.coF.setText(ExtraHelpActivity.biR[i]);
                }
            }).mo10313qu().show();
        } else if (this.biU.cos.equals(view)) {
            String obj = this.biU.coE.getText().toString();
            if (TextUtils.isEmpty(obj) || obj.length() != 8) {
                this.biU.coE.setText("");
            } else {
                AppPreferencesSetting.getInstance().setAppSettingStr("AppKey", obj);
            }
        } else if (this.biU.cou.equals(view)) {
            C4586g.m11705a((Context) this, "copying", (OnCancelListener) null, false);
            new Thread(new Runnable() {
                public void run() {
                    ProviderUtil.copyAllDatabaseToSD(ExtraHelpActivity.this);
                    ExtraHelpActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            C4586g.m11696Sm();
                            ToastUtils.show((Context) ExtraHelpActivity.this, "copy over", 0);
                        }
                    });
                }
            }).run();
        } else if (this.biU.cor.equals(view)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_ab_test_value", this.biU.coD.getText().toString());
            ToastUtils.show((Context) this, "保存成功,无需重启,立即生效.", 0);
        } else if (this.biT.equals(view)) {
            new C1895a(this).mo10283a((CharSequence) "输入图片质量的int值（0-100之间）", (CharSequence) "70", (C1898d) new C1898d() {
                /* renamed from: a */
                public void mo10327a(C1890f fVar, CharSequence charSequence) {
                    ExtraHelpActivity extraHelpActivity = ExtraHelpActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("图片质量参数值：");
                    sb.append(charSequence);
                    ToastUtils.show((Context) extraHelpActivity, sb.toString(), 0);
                    try {
                        ExtraHelpActivity.this.m8991gk(Integer.valueOf(charSequence.toString()).intValue());
                    } catch (Exception unused) {
                        ToastUtils.show((Context) ExtraHelpActivity.this, "图片质量参数值 需要整数值", 0);
                    }
                }
            }).mo10314qv();
        } else if (this.biU.coM.equals(view)) {
            new C1895a(this).mo10283a((CharSequence) "输入Config项的Key", (CharSequence) "", (C1898d) new C1898d() {
                String bja = "";

                /* renamed from: a */
                public void mo10327a(C1890f fVar, CharSequence charSequence) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onInput ");
                    sb.append(charSequence);
                    Log.e("yqg", sb.toString());
                    if (TextUtils.isEmpty(charSequence)) {
                        ToastUtils.show((Context) ExtraHelpActivity.this, "请求输入配置项的Key", 0);
                        return;
                    }
                    this.bja = charSequence.toString();
                    new C1895a(ExtraHelpActivity.this).mo10283a((CharSequence) "输入Config项的值", (CharSequence) "", (C1898d) new C1898d() {
                        /* renamed from: a */
                        public void mo10327a(C1890f fVar, CharSequence charSequence) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onInput ");
                            sb.append(charSequence);
                            Log.e("yqg", sb.toString());
                            ExtraHelpActivity extraHelpActivity = ExtraHelpActivity.this;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("config ");
                            sb2.append(C36934.this.bja);
                            sb2.append(RequestParameters.EQUAL);
                            sb2.append(charSequence);
                            ToastUtils.show((Context) extraHelpActivity, sb2.toString(), 0);
                            UtilsPrefs.with(ExtraHelpActivity.this.getApplicationContext(), AppRouter.VIVA_APP_PREF_FILENAME, true).write(C36934.this.bja, charSequence.toString());
                        }
                    }).mo10314qv();
                }
            }).mo10314qv();
        } else if (this.biU.coA.equals(view)) {
            C4560d.m11516RN().mo24802O(C2575a.parseLong(this.biU.coH.getText().toString()));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biU = (C7353a) C0171f.m361a(this, R.layout.activity_extra_help);
        this.biU.coF.setOnClickListener(this);
        this.biT = findViewById(R.id.btn_update_quality_param);
        this.biT.setOnClickListener(this);
        this.biU.cos.setOnClickListener(this);
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_ab_test_value", null);
        if (!TextUtils.isEmpty(appSettingStr)) {
            this.biU.coD.setText(appSettingStr);
        }
        this.biU.cor.setOnClickListener(this);
        this.biU.coA.setOnClickListener(this);
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_snsflag", 0);
        if (appSettingInt > 0) {
            EditText editText = this.biU.coG;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(appSettingInt);
            editText.setText(sb.toString());
        }
        this.biU.coB.setOnClickListener(new C3702a(this));
        this.biU.coB.setOnLongClickListener(new C3703b(this));
        String appSettingStr2 = AppPreferencesSetting.getInstance().getAppSettingStr("app_ip_key", "");
        if (!TextUtils.isEmpty(appSettingStr2)) {
            this.biU.coF.setText(appSettingStr2);
        }
        String appSettingStr3 = AppPreferencesSetting.getInstance().getAppSettingStr("AppKey", "");
        if (TextUtils.isEmpty(appSettingStr3)) {
            appSettingStr3 = C5206b.m14212dV(getApplicationContext());
        }
        this.biU.coE.setText(appSettingStr3);
        this.biU.cot.setOnClickListener(this);
        this.biU.cov.setOnClickListener(this);
        this.biU.cox.setOnClickListener(this);
        this.biU.coy.setOnClickListener(this);
        this.biU.cou.setOnClickListener(this);
        this.biU.coM.setOnClickListener(this);
        findViewById(R.id.btn_monitor_setting).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8159a.m23592aR(ExtraHelpActivity.this);
            }
        });
        TextView textView = (TextView) findViewById(R.id.logger_event_to_web_hint);
        String bO = m8987bO(this);
        if (bO != null) {
            textView.setText(bO);
        }
        m8978HJ();
        mo23037HK();
    }
}
