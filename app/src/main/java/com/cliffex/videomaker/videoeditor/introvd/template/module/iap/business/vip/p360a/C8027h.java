package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.BadTokenException;
import android.widget.TextView;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.vip.a.h */
public class C8027h extends Dialog {
    private static Map<String, C8032c> dUH = new HashMap();
    /* access modifiers changed from: private */
    public Activity activity;
    private View bwy;
    /* access modifiers changed from: private */
    public String dQN = "close";
    /* access modifiers changed from: private */
    public OnDismissListener dUI;

    /* renamed from: po */
    private OnClickListener f3562po = new OnClickListener() {
        public void onClick(View view) {
            if (view.getId() == R.id.tv_upgrade) {
                C8027h.this.dQN = "become vip";
                C8049f.aBf().mo33097b(C8027h.this.activity, "platinum", null, "iap_restore", -1);
            }
            C8027h.this.aEf();
        }
    };

    /* renamed from: com.introvd.template.module.iap.business.vip.a.h$a */
    private static class C8030a extends C1008a<C8031b> {
        private Context context;
        private List<C8032c> dUK;

        C8030a(Context context2, List<C8032c> list) {
            this.context = context2;
            this.dUK = list;
        }

        /* renamed from: W */
        public C8031b onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.iap_vip_dialog_purchase_detail_item, viewGroup, false);
            C8031b bVar = new C8031b(inflate);
            bVar.dUL = inflate.findViewById(R.id.iv_item_available);
            bVar.cpp = (TextView) inflate.findViewById(R.id.tv_item_name);
            return bVar;
        }

        /* renamed from: a */
        public void onBindViewHolder(C8031b bVar, int i) {
            C8032c cVar = (C8032c) this.dUK.get(i);
            if (cVar != null) {
                String str = cVar.name;
                if (C7825a.ALL_TEMPLATE.getId().equals(cVar.goodsId) && cVar.aLx) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.context.getString(R.string.xiaoying_str_iap_vip_only_purchased_template));
                    str = sb.toString();
                }
                bVar.cpp.setText(str);
                bVar.dUL.setEnabled(cVar.aLx);
            }
        }

        public int getItemCount() {
            if (this.dUK != null) {
                return this.dUK.size();
            }
            return 0;
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.vip.a.h$b */
    private static class C8031b extends C1034u {
        TextView cpp;
        View dUL;

        C8031b(View view) {
            super(view);
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.vip.a.h$c */
    private static class C8032c implements Comparable<C8032c> {
        boolean aLx;
        String goodsId;
        String name;
        int order;

        C8032c(int i, String str, String str2) {
            this.goodsId = str;
            this.order = i;
            this.name = str2;
        }

        /* renamed from: a */
        public int compareTo(C8032c cVar) {
            if (this.aLx && cVar.aLx) {
                return this.order - cVar.order;
            }
            if (this.aLx) {
                return -1;
            }
            if (cVar.aLx) {
                return 1;
            }
            return this.order - cVar.order;
        }
    }

    static {
        aEe();
    }

    C8027h(Activity activity2, final String str) {
        super(activity2, R.style.vivavideo_iap_dialog_com_style);
        this.activity = activity2;
        this.bwy = LayoutInflater.from(activity2).inflate(R.layout.iap_vip_dialog_purchase_detail, null);
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                HashMap hashMap = new HashMap();
                hashMap.put("button", C8027h.this.dQN);
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
                C8048e.aBe().mo23653g("IAPrestore_Pop_Click", hashMap);
                if (C8027h.this.dUI != null) {
                    C8027h.this.dUI.onDismiss(dialogInterface);
                }
            }
        });
        initUI();
    }

    private static void aEe() {
        Context context = C8048e.aBe().getContext();
        dUH.put(C7825a.WATER_MARK.getId(), new C8032c(1, C7825a.WATER_MARK.getId(), context.getString(R.string.xiaoying_str_vip_item_water_mark_title)));
        dUH.put(C7825a.DURATION_LIMIT.getId(), new C8032c(2, C7825a.DURATION_LIMIT.getId(), context.getString(R.string.xiaoying_str_vip_item_duration_limie_title)));
        dUH.put(C7825a.HD.getId(), new C8032c(3, C7825a.HD.getId(), context.getString(R.string.xiaoying_str_vip_item_hd_title)));
        dUH.put(C7825a.ALL_TEMPLATE.getId(), new C8032c(4, C7825a.ALL_TEMPLATE.getId(), context.getString(R.string.xiaoying_str_iap_vip_purchase_list_template)));
        dUH.put(C7825a.AD.getId(), new C8032c(5, C7825a.AD.getId(), context.getString(R.string.xiaoying_str_vip_item_ad_title)));
        dUH.put(C7825a.VIDEO_PARAM_ADJUST.getId(), new C8032c(6, C7825a.VIDEO_PARAM_ADJUST.getId(), context.getString(R.string.xiaoying_str_vip_item_adjust_title)));
        dUH.put(C7825a.ANIM_TITLE.getId(), new C8032c(7, C7825a.ANIM_TITLE.getId(), context.getString(R.string.xiaoying_str_vip_item_animated_text_title)));
        dUH.put(C7825a.CUSTOMIZED_BACKGROUND.getId(), new C8032c(8, C7825a.CUSTOMIZED_BACKGROUND.getId(), context.getString(R.string.xiaoying_str_vip_item_custom_bg_title)));
        dUH.put(C7825a.MOSAIC.getId(), new C8032c(9, C7825a.MOSAIC.getId(), context.getString(R.string.xiaoying_str_ve_mosaic_title)));
        dUH.put(C7825a.MAGIC_SOUND.getId(), new C8032c(10, C7825a.MAGIC_SOUND.getId(), context.getString(R.string.xiaoying_str_clip_func_magic_sound)));
        dUH.put(C7825a.USER_WATER_MARK.getId(), new C8032c(11, C7825a.USER_WATER_MARK.getId(), context.getString(R.string.xiaoying_str_editor_custom_watermark)));
        dUH.put(C7825a.HD_2k.getId(), new C8032c(12, C7825a.HD_2k.getId(), context.getString(R.string.viva_publish_2k_item_title)));
        dUH.put(C7825a.HD_4k.getId(), new C8032c(13, C7825a.HD_4k.getId(), context.getString(R.string.viva_publish_4k_item_title)));
        dUH.put(C7825a.KEY_FRAME.getId(), new C8032c(14, C7825a.KEY_FRAME.getId(), context.getString(R.string.xiaoying_str_template_key_frame)));
        dUH.put(C7825a.AUDIO_EXTRA.getId(), new C8032c(15, C7825a.AUDIO_EXTRA.getId(), context.getString(R.string.xiaoying_str_template_audio_extract)));
    }

    /* access modifiers changed from: private */
    public void aEf() {
        if (isShowing() && !this.activity.isFinishing()) {
            try {
                dismiss();
            } catch (BadTokenException unused) {
            }
        }
    }

    private void aEg() {
        for (C8032c cVar : dUH.values()) {
            if (cVar != null) {
                cVar.aLx = false;
            }
        }
    }

    private void initUI() {
        this.bwy.findViewById(R.id.iv_close).setOnClickListener(this.f3562po);
        this.bwy.findViewById(R.id.tv_upgrade).setOnClickListener(this.f3562po);
        RecyclerView recyclerView = (RecyclerView) this.bwy.findViewById(R.id.rv_list);
        recyclerView.setAdapter(new C8030a(getContext(), aDY()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    public List<C8032c> aDY() {
        List<String> aBb = C8045d.aAZ().aBb();
        if (aBb == null || aBb.isEmpty()) {
            return null;
        }
        aEg();
        for (String str : aBb) {
            C8032c cVar = (C8032c) dUH.get(str);
            if (cVar != null) {
                cVar.aLx = true;
            }
        }
        ArrayList arrayList = new ArrayList(dUH.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public void aEh() {
        this.dUI = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo33042d(OnDismissListener onDismissListener) {
        this.dUI = onDismissListener;
    }

    public void show() {
        setContentView(this.bwy);
        super.show();
    }
}
