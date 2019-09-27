package com.introvd.template.editor.studio;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.C0986b;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6414r;
import com.introvd.template.editor.studio.C6913d.C6924a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.p390f.C8445a;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.C8558m;
import com.p131c.p132a.p135c.C2575a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.editor.studio.b */
public class C6899b extends C4417b<C8445a> {
    private ViewAdsListener bFF = new ViewAdsListener() {
        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            if (z && C6899b.this.diR != null) {
                C6899b.this.diR.asr();
            }
        }
    };
    private View cSw;
    private Context context;
    private boolean diH = false;
    /* access modifiers changed from: private */
    public C6912c diI = null;
    private int diJ;
    private boolean diQ = true;
    /* access modifiers changed from: private */
    public C6924a diR;
    private int diS = -1;
    private final int diT = 390;
    private boolean diU;

    /* renamed from: com.introvd.template.editor.studio.b$a */
    private class C6909a extends C1034u {
        private C6909a(View view) {
            super(view);
        }
    }

    /* renamed from: com.introvd.template.editor.studio.b$b */
    private class C6910b extends C1034u {
        public C6910b(View view) {
            super(view);
        }
    }

    /* renamed from: com.introvd.template.editor.studio.b$c */
    private class C6911c extends C1034u {
        /* access modifiers changed from: private */
        public RelativeLayout bHN;
        /* access modifiers changed from: private */
        public ImageView diN;
        /* access modifiers changed from: private */
        public ImageView diO;
        /* access modifiers changed from: private */
        public TextView diP;
        /* access modifiers changed from: private */
        public View diX;
        /* access modifiers changed from: private */
        public TextView diY;
        /* access modifiers changed from: private */
        public TextView diZ;
        /* access modifiers changed from: private */
        public TextView dja;
        /* access modifiers changed from: private */
        public TextView djb;
        /* access modifiers changed from: private */
        public TextView djc;
        /* access modifiers changed from: private */
        public TextView djd;
        /* access modifiers changed from: private */
        public ImageView dje;
        /* access modifiers changed from: private */
        public ImageView djf;
        /* access modifiers changed from: private */
        public TextView djg;

        public C6911c(View view) {
            super(view);
            this.diX = view.findViewById(R.id.xiaoying_studio_item_layout);
            this.diN = (ImageView) view.findViewById(R.id.xiaoying_studio_img_project_thumb);
            this.diY = (TextView) view.findViewById(R.id.xiaoying_studio_textview_exported);
            this.diZ = (TextView) view.findViewById(R.id.xiaoying_studio_textview_create_time);
            this.dja = (TextView) view.findViewById(R.id.xiaoying_studio_textview_create_time_mm);
            this.diO = (ImageView) view.findViewById(R.id.xiaoying_studio_img_delete);
            this.djb = (TextView) view.findViewById(R.id.xiaoying_studio_textview_video_des);
            this.diP = (TextView) view.findViewById(R.id.studio_item_time_duration);
            this.djc = (TextView) view.findViewById(R.id.xiaoying_studio_textview_clip_count);
            this.bHN = (RelativeLayout) view.findViewById(R.id.xiaoying_studio_layout_top);
            this.djd = (TextView) view.findViewById(R.id.xiaoying_studio_publish_btn);
            this.dje = (ImageView) view.findViewById(R.id.xiaoying_studio_publish_btn_intel);
            this.djf = (ImageView) view.findViewById(R.id.xiaoying_studio_img_more);
            this.djg = (TextView) view.findViewById(R.id.studio_item_slide_flag);
            ViewClickEffectMgr.addEffectForViews(C6899b.class.getSimpleName(), this.djf);
        }
    }

    public C6899b(Context context2) {
        this.context = context2;
        int P = C4583d.m11671P(65.0f);
        if (Constants.getScreenSize() != null) {
            this.diJ = (Constants.getScreenSize().width - P) / 2;
        } else {
            this.diJ = 0;
        }
        C7589a.m22363h(m20113hi(this.diQ), this.bFF);
    }

    /* renamed from: U */
    private void m20107U(Object obj) {
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        HashMap hashMap = new HashMap();
        String W = C7591a.m22370W(Integer.valueOf(intValue));
        hashMap.put("platform", W);
        String str = this.diQ ? "Ad_Studio_List_Show" : "Ad_Studio_Grid_Show";
        UserBehaviorLog.onKVEvent(this.context, str, hashMap);
        C7592b.m22379F(this.context, str, W);
    }

    /* renamed from: a */
    private void m20109a(RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(m20114pt(i));
                    layoutParams.setMarginEnd(m20115pu(i));
                } else {
                    layoutParams.setMargins(m20114pt(i), layoutParams.topMargin, m20115pu(i), layoutParams.bottomMargin);
                }
                relativeLayout.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: b */
    public static String[] m20112b(String str, Context context2) {
        String str2 = str;
        Context context3 = context2;
        String[] strArr = new String[5];
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(6, -1);
            Calendar instance3 = Calendar.getInstance();
            int parseInt = C2575a.parseInt(str2.substring(0, 4));
            int parseInt2 = C2575a.parseInt(str2.substring(5, 7));
            int parseInt3 = C2575a.parseInt(str2.substring(8, 10));
            int parseInt4 = C2575a.parseInt(str2.substring(11, 13));
            int parseInt5 = C2575a.parseInt(str2.substring(14, 16));
            int parseInt6 = C2575a.parseInt(str2.substring(17, 19));
            instance3.get(14);
            instance3.set(parseInt, parseInt2 - 1, parseInt3, parseInt4, parseInt5, parseInt6);
            if (instance3.get(1) == instance.get(1) && instance3.get(6) == instance.get(6)) {
                strArr[0] = context3.getString(C10122R.string.xiaoying_str_com_time_today);
                strArr[1] = context3.getString(C10122R.string.xiaoying_str_com_time_today);
                return strArr;
            } else if (instance3.get(1) == instance2.get(1) && instance3.get(6) == instance2.get(6)) {
                strArr[0] = context3.getString(C10122R.string.xiaoying_str_com_time_yesterday);
                strArr[1] = context3.getString(C10122R.string.xiaoying_str_com_time_yesterday);
                return strArr;
            } else if (instance3.get(1) == instance.get(1)) {
                String[] split = new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(instance3.getTime()).split("/");
                if (split.length == 3) {
                    strArr[2] = split[0];
                    strArr[3] = split[1];
                    strArr[4] = split[2];
                }
                strArr[1] = new SimpleDateFormat("MM/dd", Locale.US).format(instance3.getTime());
                return strArr;
            } else {
                String str3 = "MM/dd/yyyy";
                String[] split2 = new SimpleDateFormat(str3, Locale.US).format(instance3.getTime()).split("/");
                if (split2.length == 3) {
                    strArr[2] = split2[0];
                    strArr[3] = split2[1];
                    strArr[4] = split2[2];
                }
                strArr[1] = new SimpleDateFormat(str3, Locale.US).format(instance3.getTime());
                return strArr;
            }
        } catch (Exception unused) {
            return strArr;
        }
    }

    /* renamed from: hi */
    private int m20113hi(boolean z) {
        return z ? 2 : 3;
    }

    /* renamed from: pt */
    private int m20114pt(int i) {
        if (this.cSw != null && i >= this.diS) {
            i++;
        }
        return i % 2 == 0 ? C4583d.m11671P(20.0f) : C4583d.m11671P(10.0f);
    }

    /* renamed from: pu */
    private int m20115pu(int i) {
        if (this.cSw != null && i >= this.diS) {
            i++;
        }
        return i % 2 == 0 ? C4583d.m11671P(15.0f) : C4583d.m11671P(20.0f);
    }

    /* renamed from: pv */
    private synchronized void m20116pv(int i) {
        if (this.cSw != null && (-1 == this.diS || this.diS >= this.mList.size())) {
            Random random = new Random();
            if (i >= 4) {
                this.diS = random.nextInt(3) + 1;
            } else if (i > 0 && i < 4) {
                this.diS = random.nextInt(i) + 1;
            }
        }
    }

    /* renamed from: a */
    public void mo30546a(C6912c cVar) {
        this.diI = cVar;
    }

    /* renamed from: a */
    public void mo30547a(C6924a aVar) {
        this.diR = aVar;
    }

    public List<C8445a> getDataList() {
        return this.mList;
    }

    public int getItemCount() {
        int i = (isSupportHeaderItem() ? 1 : 0) + (isSupportFooterItem() ? 1 : 0);
        if (this.mList != null) {
            i += this.mList.size();
        }
        m20116pv(isSupportFooterItem() ? i - 1 : i);
        return this.cSw != null ? i + 1 : i;
    }

    public int getItemViewType(int i) {
        if (this.diS != getRealItemPosition(i) || this.cSw == null) {
            return super.getItemViewType(i);
        }
        return 390;
    }

    /* renamed from: hg */
    public void mo30548hg(boolean z) {
        this.diQ = z;
    }

    /* renamed from: hh */
    public void mo30549hh(boolean z) {
        this.diH = z;
    }

    public boolean isSupportFooterItem() {
        return true;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager.mo7557kr() > 0) {
                gridLayoutManager.mo7544a(new C0986b() {
                    /* renamed from: bU */
                    public int mo7575bU(int i) {
                        return C6899b.this.isFooterItem(i) ? 2 : 1;
                    }
                });
            }
        }
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        if (!(uVar instanceof C6909a)) {
            final int i2 = (this.cSw == null || this.diS == -1 || i <= this.diS) ? i : i - 1;
            final C8445a aVar = (C8445a) getListItem(i2, true);
            if (aVar != null) {
                C6911c cVar = (C6911c) uVar;
                cVar.diX.setTag(Integer.valueOf(i2));
                cVar.diX.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (!C4580b.m11632Sf() && C6899b.this.diI != null) {
                            C6899b.this.diI.mo30557a(aVar);
                        }
                    }
                });
                cVar.diX.setOnLongClickListener(new OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return true;
                    }
                });
                if (!this.diQ) {
                    m20109a(cVar.bHN, i2);
                    LayoutParams layoutParams = (LayoutParams) cVar.bHN.getLayoutParams();
                    layoutParams.width = this.diJ;
                    layoutParams.height = this.diJ;
                    cVar.bHN.setLayoutParams(layoutParams);
                }
                String str = aVar.strPrjThumbnail;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(FileUtils.fileSize(str));
                ImageLoader.loadImageWithSignature(this.context, str, cVar.diN, sb.toString());
                if (C8446b.m24444g(aVar)) {
                    cVar.diY.setVisibility(0);
                } else {
                    cVar.diY.setVisibility(4);
                }
                TextView e = cVar.djc;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(aVar.iPrjClipCount);
                e.setText(sb2.toString());
                cVar.diP.setText(C4580b.m11637V(aVar.egs));
                boolean isCommunitySupport = AppStateModel.getInstance().isCommunitySupport();
                if (this.diQ) {
                    String str2 = aVar.strDesc;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.context.getResources().getString(R.string.xiaoying_str_studio_no_video_des);
                    }
                    if (!isCommunitySupport) {
                        cVar.djb.setVisibility(8);
                    } else {
                        ((LayoutParams) cVar.diP.getLayoutParams()).bottomMargin = C4583d.m11670O(this.context, 3);
                        cVar.djb.setText(str2);
                        cVar.djb.setVisibility(0);
                    }
                } else {
                    cVar.djb.setVisibility(8);
                }
                String[] b = m20112b(aVar.strCreateTime, this.context);
                if (!TextUtils.isEmpty(b[1])) {
                    cVar.diZ.setText(b[1]);
                }
                cVar.dja.setVisibility(8);
                if (C8451b.m24477un(aVar.prjThemeType)) {
                    cVar.djg.setVisibility(0);
                    String og = C8558m.m25024og(aVar.strExtra);
                    if (!TextUtils.isEmpty(og)) {
                        cVar.djg.setText(og);
                    }
                } else {
                    cVar.djg.setVisibility(8);
                }
                if (!this.diQ) {
                    if (this.diH) {
                        cVar.djd.setVisibility(8);
                    } else {
                        cVar.djd.setVisibility(0);
                        cVar.djd.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                if (C6899b.this.diI != null) {
                                    C6899b.this.diI.mo30559b(aVar);
                                }
                            }
                        });
                    }
                    int dpFloatToPixel = C4583d.dpFloatToPixel(this.context, 15.0f);
                    C6414r.m18458f(cVar.djf, dpFloatToPixel, dpFloatToPixel, dpFloatToPixel, dpFloatToPixel);
                    if (this.diH) {
                        cVar.djf.setVisibility(8);
                    } else {
                        cVar.djf.setVisibility(0);
                        cVar.djf.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                if (C6899b.this.diI != null) {
                                    C6899b.this.diI.mo30558a(aVar, i2);
                                }
                            }
                        });
                    }
                } else if (!isCommunitySupport) {
                    cVar.djd.setVisibility(8);
                    cVar.dje.setVisibility(0);
                    cVar.dje.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (C6899b.this.diI != null) {
                                C6899b.this.diI.mo30559b(aVar);
                            }
                        }
                    });
                } else if (this.diH) {
                    cVar.djd.setVisibility(8);
                    cVar.dje.setVisibility(8);
                } else {
                    cVar.djd.setVisibility(0);
                    cVar.djd.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (C6899b.this.diI != null) {
                                C6899b.this.diI.mo30559b(aVar);
                            }
                        }
                    });
                    cVar.dje.setVisibility(8);
                }
                if (this.diH) {
                    if (this.diQ) {
                        cVar.diO.setVisibility(8);
                    }
                } else if (this.diQ) {
                    cVar.diO.setTag(Integer.valueOf(i));
                    cVar.diO.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (C6899b.this.diI != null) {
                                C6899b.this.diI.mo30558a(aVar, i2);
                            }
                        }
                    });
                }
            }
        } else if (this.cSw != null && this.diS != -1) {
            RelativeLayout relativeLayout = (RelativeLayout) this.cSw.findViewById(R.id.rl_ad_container);
            if (!this.diQ && relativeLayout != null) {
                m20109a(relativeLayout, i);
            }
            if (!this.diU) {
                this.diU = true;
                m20107U(this.cSw.getTag());
            }
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return new C6910b(LayoutInflater.from(this.context).inflate(R.layout.editor_studio_recyclerview_item_layout, null));
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        if (i != 390 || this.cSw == null) {
            return this.diQ ? new C6911c(LayoutInflater.from(this.context).inflate(R.layout.editor_studio_listview_item_layout, null)) : new C6911c(LayoutInflater.from(this.context).inflate(R.layout.editor_studio_gridview_item_layout, null));
        }
        if (this.cSw.getParent() != null && (this.cSw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.cSw.getParent()).removeView(this.cSw);
        }
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(this.cSw);
        return new C6909a(frameLayout);
    }

    public void removeItem(int i) {
        if (this.mList != null && this.mList.size() - 1 >= i) {
            this.mList.remove(i);
        }
        if (!(this.cSw == null || this.diS == -1 || i >= this.diS)) {
            this.diS--;
        }
        notifyDataSetChanged();
    }

    public void setDataList(List<C8445a> list) {
        this.cSw = C7589a.getAdView(this.context, m20113hi(this.diQ));
        super.setDataList(list);
    }
}
