package com.introvd.template.module.iap.business.p357f;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.p021v4.content.ContextCompat;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8059i;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.p341b.p343b.C7737e;
import com.introvd.template.module.p339c.C7689a;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1848s;
import p037b.p050b.C1849t;
import p037b.p050b.C1850u;
import p037b.p050b.C1851v;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.iap.business.f.a */
public class C7930a extends Dialog {
    /* access modifiers changed from: private */
    public final Activity activity;
    /* access modifiers changed from: private */
    public List<Integer> dUN;

    private C7930a(final Activity activity2, List<String> list, List<Integer> list2) {
        super(activity2, R.style.vivavideo_iap_dialog_common_style);
        setContentView(R.layout.iap_vip_dialog_export_check);
        this.activity = activity2;
        this.dUN = list2;
        m23073cp(list);
        findViewById(R.id.tv_btn_become_vip).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8049f.aBf().mo33097b(activity2, "platinum", null, "Privilege_group", -1);
                C7930a.this.cancel();
            }
        });
        findViewById(R.id.tv_btn_cancel).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7930a.this.cancel();
            }
        });
    }

    /* renamed from: a */
    private static String m23067a(Activity activity2, Integer num) {
        if (num.intValue() != C8059i.VIP_ALL.code) {
            if (num.intValue() == C8059i.VIP_THEME.code) {
                if (m23068a(C7825a.ALL_TEMPLATE)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_theme);
            } else if (num.intValue() == C8059i.VIP_FILTER.code) {
                if (m23068a(C7825a.ALL_TEMPLATE)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_filter);
            } else if (num.intValue() == C8059i.VIP_STICKER.code) {
                if (m23068a(C7825a.ALL_TEMPLATE)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_paster);
            } else if (num.intValue() == C8059i.VIP_MAGIC_SOUND.code) {
                if (m23068a(C7825a.MAGIC_SOUND)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_voice_changed);
            } else if (num.intValue() == C8059i.VIP_BACKGROUND.code) {
                if (m23068a(C7825a.CUSTOMIZED_BACKGROUND)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_item_custom_bg_title);
            } else if (num.intValue() == C8059i.VIP_ANIM_SUBTITLE.code) {
                if (m23068a(C7825a.ANIM_TITLE)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_item_animated_text_title);
            } else if (num.intValue() == C8059i.VIP_NORMAL_SUBTITLE.code) {
                if (m23068a(C7825a.ALL_TEMPLATE)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_caption);
            } else if (num.intValue() == C8059i.VIP_MOSAIC.code) {
                if (m23068a(C7825a.MOSAIC)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_ve_mosaic_title);
            } else if (num.intValue() == C8059i.VIP_MUSIC_EXTRACT.code) {
                if (m23068a(C7825a.AUDIO_EXTRA)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_template_audio_extract);
            } else if (num.intValue() == C8059i.VIP_DURATION_LIMIT.code) {
                if (m23068a(C7825a.DURATION_LIMIT) || m23068a(C7825a.ALL)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_apply_duration_limit);
            } else if (num.intValue() == C8059i.VIP_KEY_FRAME.code) {
                if (m23068a(C7825a.KEY_FRAME)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_template_key_frame);
            } else if (num.intValue() == C8059i.VIP_VIDEO_PARAM.code) {
                if (m23068a(C7825a.VIDEO_PARAM_ADJUST)) {
                    return null;
                }
                return activity2.getString(R.string.xiaoying_str_vip_item_adjust_title);
            } else if (num.intValue() != C8059i.VIP_CUSTOMIZE_WM.code || m23068a(C7825a.USER_WATER_MARK)) {
                return null;
            } else {
                return activity2.getString(R.string.xiaoying_str_editor_custom_watermark);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m23068a(C7825a aVar) {
        return C8072q.aBx().mo33072ku(aVar.getId());
    }

    private void aEj() {
        C1848s.m5324a((C1851v<T>) new C1851v<List<String>>() {
            /* renamed from: a */
            public void mo10201a(C1849t<List<String>> tVar) throws Exception {
                tVar.onSuccess(C7930a.m23071c(C7930a.this.activity, C7930a.this.dUN));
            }
        }).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<String>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
            }

            public void onSuccess(List<String> list) {
                if (list.isEmpty()) {
                    C7930a.this.cancel();
                    return;
                }
                RecyclerView recyclerView = (RecyclerView) C7930a.this.findViewById(R.id.lv_data);
                if (!(recyclerView == null || recyclerView.getAdapter() == null)) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        });
    }

    /* renamed from: b */
    public static C1848s<Boolean> m23069b(final Activity activity2, final List<Integer> list) {
        return C1848s.m5324a((C1851v<T>) new C1851v<List<String>>() {
            /* renamed from: a */
            public void mo10201a(C1849t<List<String>> tVar) throws Exception {
                tVar.onSuccess(C7930a.m23071c(activity2, list));
            }
        }).mo10194f(C1487a.aUa()).mo10199i(new C1518f<List<String>, Boolean>() {
            /* renamed from: K */
            public Boolean apply(List<String> list) throws Exception {
                if (list.isEmpty()) {
                    return Boolean.valueOf(false);
                }
                new C7930a(activity2, list, list).show();
                return Boolean.valueOf(true);
            }
        });
    }

    /* renamed from: c */
    static List<String> m23071c(Activity activity2, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (Integer a : list) {
            String a2 = m23067a(activity2, a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: cp */
    private void m23073cp(final List<String> list) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.activity));
        recyclerView.setAdapter(new C1008a() {
            public int getItemCount() {
                return list.size();
            }

            public void onBindViewHolder(C1034u uVar, int i) {
                ((TextView) uVar.itemView).setText((CharSequence) list.get(i));
            }

            public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
                TextView textView = new TextView(C7930a.this.activity);
                textView.setTextSize(14.0f);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                int ii = C7689a.m22599ii(2);
                int i2 = ii * 4;
                textView.setPadding(0, i2, 0, i2);
                textView.setCompoundDrawablePadding(ii * 3);
                if (VERSION.SDK_INT >= 17) {
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.iap_vip_dialog_export_data_circle, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iap_vip_dialog_export_data_circle, 0, 0, 0);
                }
                textView.setTextColor(ContextCompat.getColor(C7930a.this.activity, R.color.color_333333));
                return new C1034u(textView) {
                };
            }
        });
    }

    public void cancel() {
        C10021c.aZH().mo38496az(this);
        if (getWindow() != null && getWindow().getDecorView().getParent() != null) {
            super.cancel();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseReload(C7735c cVar) {
        aEj();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseResult(C7737e eVar) {
        if (eVar != null && eVar.isSuccess()) {
            aEj();
        }
    }

    public void show() {
        if (!this.activity.isFinishing() && getWindow() != null) {
            LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (((double) this.activity.getResources().getDisplayMetrics().widthPixels) * 0.8d);
            getWindow().setAttributes(attributes);
            this.activity.getWindow().getDecorView().post(new Runnable() {
                public void run() {
                    C7930a.super.show();
                    if (!C10021c.aZH().mo38495ay(C7930a.this)) {
                        C10021c.aZH().mo38494ax(C7930a.this);
                    }
                }
            });
        }
    }
}
