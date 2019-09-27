package com.introvd.template.editor.preview.theme.p277b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.nav.C6184a;
import com.introvd.template.editor.p266h.C6414r;
import com.introvd.template.editor.preview.theme.C6656a;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p407e.C8739i;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.p131c.p132a.C2570b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import xiaoying.engine.base.QStyle;

/* renamed from: com.introvd.template.editor.preview.theme.b.b */
public class C6661b extends BaseItem<EffectInfoModel> {
    private int cDi;
    private DynamicLoadingImageView cDk;
    private ImageView cDm;
    private LinearLayout cDo;
    private DynamicLoadingImageView cDp;
    private TextView cDq;
    private TextView cpp;
    /* access modifiers changed from: private */
    public C6656a dch;
    private boolean ddA = false;
    private boolean ddB;
    private RelativeLayout dds;
    private RelativeLayout ddt;
    private RelativeLayout ddu;
    private RelativeLayout ddv;
    private ImageView ddw;
    private ImageView ddx;
    private ImageView ddy;
    private TextView ddz;

    public C6661b(Context context, EffectInfoModel effectInfoModel, C6656a aVar, boolean z) {
        super(context, effectInfoModel);
        this.dch = aVar;
        this.cDi = C4583d.m11670O(getContext(), 38);
        this.ddB = z;
    }

    private boolean aqr() {
        if (this.ddy == null || ((Long) this.ddy.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.ddv == null || ((Long) this.ddv.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.dch == null) {
            return false;
        }
        if (this.dch.apT()) {
            this.ddy.setVisibility(0);
            this.ddv.setVisibility(0);
        }
        return true;
    }

    private boolean aqs() {
        if (this.ddx == null || ((Long) this.ddx.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.ddw == null || ((Long) this.ddw.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.ddu == null || ((Long) this.ddu.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.cDo == null || ((Long) this.cDo.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId || this.cDq == null || ((Long) this.cDq.getTag()).longValue() != ((EffectInfoModel) getItemData()).mTemplateId) {
            return false;
        }
        boolean v = C8739i.m25530v(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        boolean bu = C8739i.m25522bu(((EffectInfoModel) getItemData()).mTemplateId);
        boolean u = C8739i.m25529u(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        boolean z = v || bu || (((EffectInfoModel) getItemData()).isbNeedDownload() && !((EffectInfoModel) getItemData()).isDownloading());
        boolean y = C8739i.m25533y(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        if (v || bu || u || y) {
            if (u) {
                this.ddx.setImageResource(R.drawable.editor_vip_icon_20_n);
            } else if (y) {
                this.ddx.setImageResource(R.drawable.editor_theme_time_limit_icon);
            } else {
                this.ddx.setImageResource(R.drawable.editor_lock_icon_20_n);
            }
            this.ddx.setVisibility(0);
        } else {
            this.ddx.setVisibility(8);
        }
        if (((EffectInfoModel) getItemData()).isbNeedDownload() && z) {
            this.ddw.setImageResource(R.drawable.editor_icon_download_nrm);
            this.ddw.setVisibility(0);
            this.ddu.setVisibility(0);
            this.cDo.setVisibility(8);
        } else if (((EffectInfoModel) getItemData()).isDownloading()) {
            this.ddw.setVisibility(8);
            this.ddu.setVisibility(0);
            this.cDo.setVisibility(0);
            TextView textView = this.cDq;
            StringBuilder sb = new StringBuilder();
            sb.append(this.dch.mo29970aF(((EffectInfoModel) getItemData()).mTemplateId));
            sb.append("%");
            textView.setText(sb.toString());
            if (!u) {
                this.ddx.setVisibility(8);
            }
        } else {
            this.ddw.setVisibility(8);
            this.ddu.setVisibility(8);
            this.cDo.setVisibility(8);
            if (!u && !y) {
                this.ddx.setVisibility(8);
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_listitem_theme;
    }

    /* renamed from: o */
    public boolean mo30048o(int i, String str) {
        if (i == 0) {
            ((EffectInfoModel) getItemData()).setDownloading(false);
            ((EffectInfoModel) getItemData()).setbNeedDownload(false);
            ((EffectInfoModel) getItemData()).setDownloaded(true);
            ((EffectInfoModel) getItemData()).mPath = str;
        } else if (i == 1) {
            ((EffectInfoModel) getItemData()).setDownloading(true);
        } else {
            ((EffectInfoModel) getItemData()).setDownloading(false);
        }
        return aqs();
    }

    /* renamed from: oQ */
    public boolean mo30049oQ(int i) {
        if (i < 0) {
            ((EffectInfoModel) getItemData()).setDownloading(false);
        } else {
            ((EffectInfoModel) getItemData()).setDownloading(true);
        }
        return aqs();
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        this.dds = (RelativeLayout) baseHolder.findViewById(R.id.rlThemeItem);
        this.ddt = (RelativeLayout) baseHolder.findViewById(R.id.theme_scene_container);
        this.cDk = (DynamicLoadingImageView) baseHolder.findViewById(R.id.item_cover);
        this.cDk.setCornerRadius((float) this.cDi);
        this.cDm = (ImageView) baseHolder.findViewById(R.id.bg_selected);
        this.ddu = (RelativeLayout) baseHolder.findViewById(R.id.rl_download);
        this.ddw = (ImageView) baseHolder.findViewById(R.id.icon_download);
        this.ddv = (RelativeLayout) baseHolder.findViewById(R.id.rl_edit);
        this.ddy = (ImageView) baseHolder.findViewById(R.id.icon_edit);
        this.ddx = (ImageView) baseHolder.findViewById(R.id.iv_theme_iap);
        this.cDo = (LinearLayout) baseHolder.findViewById(R.id.ll_progress);
        this.cDp = (DynamicLoadingImageView) baseHolder.findViewById(R.id.bg_download_progress);
        this.cDq = (TextView) baseHolder.findViewById(R.id.text_download_progress);
        this.cpp = (TextView) baseHolder.findViewById(R.id.item_name);
        this.ddz = (TextView) baseHolder.findViewById(R.id.theme_scene);
        ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, this.cDp);
        this.cDk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6661b.this.dch != null) {
                    C6661b.this.dch.mo29972j((EffectInfoModel) C6661b.this.getItemData());
                }
            }
        });
        C6414r.m18458f(this.ddt, C7689a.m22597aR(10.0f), C7689a.m22597aR(10.0f), 0, 0);
        this.ddt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6661b.this.dch != null) {
                    C6661b.this.dch.mo29974l((EffectInfoModel) C6661b.this.getItemData());
                }
            }
        });
        this.ddv.setVisibility(8);
        this.ddy.setVisibility(8);
        this.dds.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.ddx.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.ddw.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.ddu.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.ddy.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.ddv.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.cDo.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        this.cDq.setTag(Long.valueOf(((EffectInfoModel) getItemData()).mTemplateId));
        String str = ((EffectInfoModel) getItemData()).mName != null ? ((EffectInfoModel) getItemData()).mName : "";
        if (ParametersKeys.ORIENTATION_NONE.equals(str.toLowerCase())) {
            this.cpp.setText(R.string.xiaoying_str_ve_template_empty_title);
        } else {
            this.cpp.setText(str);
        }
        if (C3742b.m9111II().mo23169Jp()) {
            String str2 = ((EffectInfoModel) getItemData()).strSceneName;
            if (TextUtils.isEmpty(str2)) {
                this.ddt.setVisibility(8);
            } else if (!this.ddB) {
                this.ddt.setVisibility(0);
                this.ddz.setText(str2);
            } else {
                this.ddt.setVisibility(8);
            }
        } else {
            this.ddt.setVisibility(8);
        }
        if (((EffectInfoModel) getItemData()).mTemplateId == QStyle.NONE_THEME_TEMPLATE_ID) {
            this.cDk.setImageResource(R.drawable.xiaoying_cam_thumb_filter_none);
        } else if (!TextUtils.isEmpty(((EffectInfoModel) getItemData()).mThumbUrl)) {
            ImageLoader.loadImage(((EffectInfoModel) getItemData()).mThumbUrl, this.cDk);
        } else {
            C2570b.m7336hy(VivaBaseApplication.m8749FZ()).mo12209w(new C6184a(((EffectInfoModel) getItemData()).mPath, C4583d.m11671P(71.0f), C4583d.m11671P(71.0f))).mo12186g(this.cDk);
        }
        aqs();
        if (this.dch.mo29973k((EffectInfoModel) getItemData())) {
            this.cDm.setVisibility(0);
            aqr();
        } else {
            this.cDm.setVisibility(4);
        }
        if (!this.ddA) {
            this.ddA = true;
            C6664c.m19365a(getContext().getApplicationContext(), str, C8450a.m24469bn(((EffectInfoModel) getItemData()).mTemplateId), i - 2);
        }
    }
}
