package com.introvd.template.editor.effects.bubble.p255a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8726b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.bubble.a.c */
public class C5924c extends C1008a<C5928b> {
    /* access modifiers changed from: private */
    public final Context bbr;
    /* access modifiers changed from: private */
    public C5927a cIZ;
    /* access modifiers changed from: private */
    public final SparseArray<C5929c> cvf = new SparseArray<>();
    /* access modifiers changed from: private */
    public final C8720b cvg;
    private int cwZ = -1;
    private List<StoryBoardItemInfo> mItemInfoList;

    /* renamed from: com.introvd.template.editor.effects.bubble.a.c$a */
    public interface C5927a {
        /* renamed from: z */
        void mo28545z(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.effects.bubble.a.c$b */
    public static class C5928b extends C1034u {
        RelativeLayout bSy;
        RelativeLayout cJc;
        RelativeLayout cJd;
        RelativeLayout cJe;
        DynamicLoadingImageView cJf;
        ImageView cJg;
        TextView cJh;
        ImageView cJi;
        public int flag;

        public C5928b(View view) {
            super(view);
        }
    }

    /* renamed from: com.introvd.template.editor.effects.bubble.a.c$c */
    private class C5929c implements C8726b {
        C5928b cJj;
        final StoryBoardItemInfo cvl;
        private int key;

        public C5929c(C5928b bVar, StoryBoardItemInfo storyBoardItemInfo, int i) {
            this.cJj = bVar;
            this.cvl = storyBoardItemInfo;
            this.key = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m16621a(C5928b bVar) {
            this.cJj = bVar;
        }

        private DynamicLoadingImageView acF() {
            if (this.cJj == null || this.cJj.flag != this.key) {
                return null;
            }
            return this.cJj.cJf;
        }

        private View acG() {
            if (this.cJj == null || this.cJj.flag != this.key) {
                return null;
            }
            return this.cJj.cJg;
        }

        /* renamed from: gi */
        public boolean mo27537gi(String str) {
            if (str.equals(this.cvl.mFontInfo.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventSuc(C5924c.this.bbr, this.cvl.mFontInfo.ttid, "Cover_Template_Download_Font", "editor", this.cvl.mFontInfo.strTitle, "font");
                DynamicLoadingImageView acF = acF();
                if (acF != null) {
                    acF.setVisibility(8);
                }
                this.cvl.mFontPath = C5924c.this.cvg.mo35113qf(this.cvl.mFontInfo.ttid);
                C5924c.this.notifyDataSetChanged();
                C5924c.this.cvf.remove(this.key);
                if (this.cJj != null && this.cJj.flag == this.key) {
                    RelativeLayout relativeLayout = this.cJj.bSy;
                    if (relativeLayout != null) {
                        relativeLayout.performClick();
                    }
                }
            }
            return false;
        }

        /* renamed from: gj */
        public boolean mo27538gj(String str) {
            if (str.equals(this.cvl.mFontInfo.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventFail(C5924c.this.bbr, this.cvl.mFontInfo.ttid, "Cover_Template_Download_Font", "editor", this.cvl.mFontInfo.strTitle);
                DynamicLoadingImageView acF = acF();
                if (acF != null) {
                    acF.setVisibility(0);
                }
                View acG = acG();
                if (acG != null) {
                    acG.setVisibility(0);
                }
                C5924c.this.cvf.remove(this.key);
            }
            return false;
        }

        /* renamed from: u */
        public boolean mo27539u(String str, int i) {
            if (str.equals(this.cvl.mFontInfo.ttid)) {
                View acG = acG();
                if (acG != null) {
                    acG.setVisibility(8);
                }
                DynamicLoadingImageView acF = acF();
                if (acF != null) {
                    acF.setVisibility(0);
                }
            }
            return false;
        }
    }

    public C5924c(Context context, List<StoryBoardItemInfo> list, C8720b bVar) {
        this.bbr = context;
        this.mItemInfoList = list;
        this.cvg = bVar;
    }

    /* renamed from: a */
    private void m16610a(int i, C5928b bVar) {
        int i2 = 8;
        bVar.cJd.setVisibility(i == 0 ? 0 : 8);
        RelativeLayout relativeLayout = bVar.cJe;
        if (i != 0) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16612a(C8726b bVar, TemplateInfo templateInfo) {
        if (this.cvg != null) {
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(templateInfo.strUrl));
            this.cvg.mo35103a(templateInfo.ttid, bVar);
            this.cvg.mo35111qd(templateInfo.ttid);
        }
    }

    /* renamed from: C */
    public C5928b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.bbr).inflate(R.layout.editor_effect_subtitle_font_item_layout, viewGroup, false);
        C5928b bVar = new C5928b(inflate);
        bVar.bSy = (RelativeLayout) inflate.findViewById(R.id.rl_font_item_layout);
        bVar.cJd = (RelativeLayout) inflate.findViewById(R.id.rl_subtitle_font_add_local_layout);
        bVar.cJe = (RelativeLayout) inflate.findViewById(R.id.rl_subtitle_font_item_layout);
        bVar.cJc = (RelativeLayout) inflate.findViewById(R.id.rl_subtitle_font_item_download_layout);
        bVar.cJf = (DynamicLoadingImageView) inflate.findViewById(R.id.div_font_download_progress);
        bVar.cJg = (ImageView) inflate.findViewById(R.id.iv_font_download_flag);
        bVar.cJh = (TextView) inflate.findViewById(R.id.tv_font_item_name);
        bVar.cJi = (ImageView) inflate.findViewById(R.id.iv_font_item);
        return bVar;
    }

    /* renamed from: a */
    public void mo28538a(C5927a aVar) {
        this.cIZ = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(final com.introvd.template.editor.effects.bubble.p255a.C5924c.C5928b r9, final int r10) {
        /*
            r8 = this;
            java.util.List<com.introvd.template.sdk.model.editor.StoryBoardItemInfo> r0 = r8.mItemInfoList
            java.lang.Object r0 = r0.get(r10)
            com.introvd.template.sdk.model.editor.StoryBoardItemInfo r0 = (com.introvd.template.sdk.model.editor.StoryBoardItemInfo) r0
            android.widget.RelativeLayout r1 = r9.bSy
            com.introvd.template.editor.effects.bubble.a.c$1 r2 = new com.introvd.template.editor.effects.bubble.a.c$1
            r2.<init>(r10)
            r1.setOnClickListener(r2)
            r8.m16610a(r10, r9)
            android.widget.RelativeLayout r1 = r9.cJc
            com.introvd.template.editor.effects.bubble.a.c$2 r2 = new com.introvd.template.editor.effects.bubble.a.c$2
            r2.<init>(r10, r9, r0)
            r1.setOnClickListener(r2)
            int r1 = com.introvd.template.editor.R.drawable.xiaoying_cam_filter_download_loading
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r2 = r9.cJf
            com.introvd.template.common.imageloader.ImageLoader.loadImage(r1, r2)
            android.util.SparseArray<com.introvd.template.editor.effects.bubble.a.c$c> r1 = r8.cvf
            java.lang.Object r1 = r1.get(r10)
            com.introvd.template.editor.effects.bubble.a.c$c r1 = (com.introvd.template.editor.effects.bubble.p255a.C5924c.C5929c) r1
            r9.flag = r10
            r2 = 4
            r3 = 8
            r4 = 0
            if (r1 != 0) goto L_0x0041
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r1 = r9.cJf
            r1.setVisibility(r2)
            android.widget.ImageView r1 = r9.cJg
            r1.setVisibility(r4)
            goto L_0x0049
        L_0x0041:
            r1.m16621a(r9)
            android.widget.ImageView r1 = r9.cJg
            r1.setVisibility(r3)
        L_0x0049:
            r1 = 2
            if (r10 >= r1) goto L_0x0057
            android.widget.RelativeLayout r1 = r9.cJc
            r1.setVisibility(r3)
            android.widget.ImageView r1 = r9.cJg
            r1.setVisibility(r3)
            goto L_0x0076
        L_0x0057:
            android.widget.RelativeLayout r1 = r9.cJc
            java.lang.String r5 = r0.mFontPath
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0063
            r5 = 0
            goto L_0x0065
        L_0x0063:
            r5 = 8
        L_0x0065:
            r1.setVisibility(r5)
            android.widget.ImageView r1 = r9.cJg
            java.lang.String r5 = r0.mFontPath
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0073
            r3 = 0
        L_0x0073:
            r1.setVisibility(r3)
        L_0x0076:
            java.lang.String r1 = ""
            r3 = 1
            if (r10 != 0) goto L_0x0089
            android.content.Context r0 = r8.bbr
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.introvd.template.editor.R.string.xiaoying_str_ve_subtitle_font_more
            java.lang.String r1 = r0.getString(r1)
        L_0x0087:
            r3 = 0
            goto L_0x00b6
        L_0x0089:
            if (r10 != r3) goto L_0x0098
            android.content.Context r0 = r8.bbr
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.introvd.template.editor.R.string.xiaoying_str_ve_subtitle_font_default_name
            java.lang.String r1 = r0.getString(r1)
            goto L_0x0087
        L_0x0098:
            com.introvd.template.sdk.model.template.TemplateInfo r5 = r0.mFontInfo
            if (r5 == 0) goto L_0x00b3
            int r5 = r8.cwZ
            if (r5 != r10) goto L_0x00a2
            r5 = 1
            goto L_0x00a3
        L_0x00a2:
            r5 = 0
        L_0x00a3:
            android.widget.ImageView r6 = r9.cJi
            com.introvd.template.template.e.b r7 = r8.cvg
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r0.mFontInfo
            java.lang.String r0 = r0.ttid
            android.graphics.Bitmap r0 = r7.mo35101A(r0, r5)
            r6.setImageBitmap(r0)
            goto L_0x00b6
        L_0x00b3:
            java.lang.String r1 = r0.mFontName
            goto L_0x0087
        L_0x00b6:
            android.widget.TextView r0 = r9.cJh
            r0.setText(r1)
            android.widget.TextView r0 = r9.cJh
            if (r3 == 0) goto L_0x00c1
            r1 = 4
            goto L_0x00c2
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r9.cJi
            if (r3 == 0) goto L_0x00ca
            r2 = 0
        L_0x00ca:
            r0.setVisibility(r2)
            android.widget.TextView r9 = r9.cJh
            int r0 = r8.cwZ
            if (r0 != r10) goto L_0x00e0
            android.content.Context r10 = r8.bbr
            android.content.res.Resources r10 = r10.getResources()
            int r0 = com.introvd.template.editor.R.color.color_ff774e
            int r10 = r10.getColor(r0)
            goto L_0x00ec
        L_0x00e0:
            android.content.Context r10 = r8.bbr
            android.content.res.Resources r10 = r10.getResources()
            int r0 = com.introvd.template.editor.R.color.white
            int r10 = r10.getColor(r0)
        L_0x00ec:
            r9.setTextColor(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.effects.bubble.p255a.C5924c.onBindViewHolder(com.introvd.template.editor.effects.bubble.a.c$b, int):void");
    }

    public int ajC() {
        return this.cwZ;
    }

    public Object getItem(int i) {
        if (this.mItemInfoList == null || i >= this.mItemInfoList.size()) {
            return null;
        }
        return this.mItemInfoList.get(i);
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    /* renamed from: kP */
    public void mo28542kP(int i) {
        this.cwZ = i;
    }
}
