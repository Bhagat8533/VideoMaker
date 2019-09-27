package com.introvd.template.editor.advance;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.p375r.p376a.C8360a;
import com.introvd.template.p375r.p376a.C8360a.C8363b;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8726b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.editor.advance.h */
public class C5601h extends C8360a<StoryBoardItemInfo> {
    /* access modifiers changed from: private */
    public final Context bbr;
    /* access modifiers changed from: private */
    public final SparseArray<C5603a> cvf = new SparseArray<>();
    /* access modifiers changed from: private */
    public final C8720b cvg;

    /* renamed from: com.introvd.template.editor.advance.h$a */
    private class C5603a implements C8726b {
        C8363b cvk;
        final StoryBoardItemInfo cvl;
        private int key = -1;

        public C5603a(C8363b bVar, StoryBoardItemInfo storyBoardItemInfo, int i) {
            this.cvk = bVar;
            this.cvl = storyBoardItemInfo;
            this.key = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m15349a(C8363b bVar) {
            this.cvk = bVar;
        }

        private DynamicLoadingImageView acF() {
            if (this.cvk == null || this.cvk.flag != this.key) {
                return null;
            }
            return (DynamicLoadingImageView) this.cvk.mo33625n(R.id.download_progress);
        }

        private View acG() {
            if (this.cvk == null || this.cvk.flag != this.key) {
                return null;
            }
            return this.cvk.mo33625n(R.id.img_download_flag);
        }

        /* renamed from: gi */
        public boolean mo27537gi(String str) {
            if (str.equals(this.cvl.mFontInfo.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventSuc(C5601h.this.getContext(), this.cvl.mFontInfo.ttid, "Cover_Template_Download_Font", "editor", this.cvl.mFontInfo.strTitle, "font");
                DynamicLoadingImageView acF = acF();
                if (acF != null) {
                    acF.setVisibility(8);
                }
                this.cvl.mFontPath = C5601h.this.cvg.mo35113qf(this.cvl.mFontInfo.ttid);
                C5601h.this.notifyDataSetChanged();
                C5601h.this.cvf.remove(this.key);
                if (this.cvk != null && this.cvk.flag == this.key) {
                    View akM = this.cvk.akM();
                    if (akM != null) {
                        akM.performClick();
                    }
                }
            }
            return false;
        }

        /* renamed from: gj */
        public boolean mo27538gj(String str) {
            if (str.equals(this.cvl.mFontInfo.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventFail(C5601h.this.getContext(), this.cvl.mFontInfo.ttid, "Cover_Template_Download_Font", "editor", this.cvl.mFontInfo.strTitle);
                DynamicLoadingImageView acF = acF();
                if (acF != null) {
                    acF.setVisibility(0);
                }
                View acG = acG();
                if (acG != null) {
                    acG.setVisibility(0);
                }
                C5601h.this.cvf.remove(this.key);
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

    public C5601h(Context context, List<StoryBoardItemInfo> list, C8720b bVar) {
        super(context, list);
        mo33622uD(R.layout.editor_pick_cover_subtitle_font_item_layout);
        this.bbr = context;
        this.cvg = bVar;
    }

    /* renamed from: a */
    private void m15342a(int i, C8363b bVar) {
        int i2 = 8;
        bVar.mo33625n(R.id.edit_subtitle_font_add_local_layout).setVisibility(i == 0 ? 0 : 8);
        View n = bVar.mo33625n(R.id.edit_subtitle_font_item_layout);
        if (i != 0) {
            i2 = 0;
        }
        n.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15344a(C8726b bVar, TemplateInfo templateInfo) {
        if (this.cvg != null) {
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(templateInfo.strUrl));
            this.cvg.mo35103a(templateInfo.ttid, bVar);
            this.cvg.mo35111qd(templateInfo.ttid);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27530a(final com.introvd.template.p375r.p376a.C8360a.C8363b r9, final int r10) {
        /*
            r8 = this;
            java.util.List r0 = r8.mItemInfoList
            java.lang.Object r0 = r0.get(r10)
            com.introvd.template.sdk.model.editor.StoryBoardItemInfo r0 = (com.introvd.template.sdk.model.editor.StoryBoardItemInfo) r0
            r8.m15342a(r10, r9)
            int r1 = com.introvd.template.editor.R.id.edit_subtitle_font_item_download_layout
            android.view.View r1 = r9.mo33625n(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x001d
            com.introvd.template.editor.advance.h$1 r2 = new com.introvd.template.editor.advance.h$1
            r2.<init>(r10, r9, r0)
            r1.setOnClickListener(r2)
        L_0x001d:
            int r2 = com.introvd.template.editor.R.id.download_progress
            android.view.View r2 = r9.mo33625n(r2)
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r2 = (com.quvideo.mobile.component.imageview.DynamicLoadingImageView) r2
            int r3 = com.introvd.template.editor.R.drawable.xiaoying_cam_filter_download_loading
            com.introvd.template.common.imageloader.ImageLoader.loadImage(r3, r2)
            int r3 = com.introvd.template.editor.R.id.img_download_flag
            android.view.View r3 = r9.mo33625n(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.util.SparseArray<com.introvd.template.editor.advance.h$a> r4 = r8.cvf
            java.lang.Object r4 = r4.get(r10)
            com.introvd.template.editor.advance.h$a r4 = (com.introvd.template.editor.advance.C5601h.C5603a) r4
            r9.flag = r10
            r5 = 4
            r6 = 8
            r7 = 0
            if (r4 != 0) goto L_0x0049
            r2.setVisibility(r5)
            r3.setVisibility(r7)
            goto L_0x004f
        L_0x0049:
            r4.m15349a(r9)
            r3.setVisibility(r6)
        L_0x004f:
            r2 = 2
            if (r10 >= r2) goto L_0x0059
            r1.setVisibility(r6)
            r3.setVisibility(r6)
            goto L_0x0074
        L_0x0059:
            java.lang.String r2 = r0.mFontPath
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0063
            r2 = 0
            goto L_0x0065
        L_0x0063:
            r2 = 8
        L_0x0065:
            r1.setVisibility(r2)
            java.lang.String r1 = r0.mFontPath
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0071
            r6 = 0
        L_0x0071:
            r3.setVisibility(r6)
        L_0x0074:
            int r1 = com.introvd.template.editor.R.id.txtview_theme_name
            android.view.View r1 = r9.mo33625n(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = com.introvd.template.editor.R.id.img_theme_name
            android.view.View r9 = r9.mo33625n(r2)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            java.lang.String r2 = ""
            r3 = 1
            if (r10 != 0) goto L_0x0097
            android.content.Context r0 = r8.bbr
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.introvd.template.editor.R.string.xiaoying_str_ve_subtitle_font_more
            java.lang.String r2 = r0.getString(r2)
        L_0x0095:
            r3 = 0
            goto L_0x00c4
        L_0x0097:
            if (r10 != r3) goto L_0x00a6
            android.content.Context r0 = r8.bbr
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.introvd.template.editor.R.string.xiaoying_str_ve_subtitle_font_default_name
            java.lang.String r2 = r0.getString(r2)
            goto L_0x0095
        L_0x00a6:
            com.introvd.template.sdk.model.template.TemplateInfo r4 = r0.mFontInfo
            if (r4 == 0) goto L_0x00c1
            int r4 = r8.ajC()
            if (r4 != r10) goto L_0x00b2
            r4 = 1
            goto L_0x00b3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            com.introvd.template.template.e.b r6 = r8.cvg
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r0.mFontInfo
            java.lang.String r0 = r0.ttid
            android.graphics.Bitmap r0 = r6.mo35101A(r0, r4)
            r9.setImageBitmap(r0)
            goto L_0x00c4
        L_0x00c1:
            java.lang.String r2 = r0.mFontName
            goto L_0x0095
        L_0x00c4:
            r1.setText(r2)
            if (r3 == 0) goto L_0x00cb
            r0 = 4
            goto L_0x00cc
        L_0x00cb:
            r0 = 0
        L_0x00cc:
            r1.setVisibility(r0)
            if (r3 == 0) goto L_0x00d2
            r5 = 0
        L_0x00d2:
            r9.setVisibility(r5)
            int r9 = r8.ajC()
            if (r9 != r10) goto L_0x00ea
            android.content.Context r9 = r8.getContext()
            android.content.res.Resources r9 = r9.getResources()
            int r10 = com.introvd.template.editor.R.color.color_ff774e
            int r9 = r9.getColor(r10)
            goto L_0x00f8
        L_0x00ea:
            android.content.Context r9 = r8.getContext()
            android.content.res.Resources r9 = r9.getResources()
            int r10 = com.introvd.template.editor.R.color.white
            int r9 = r9.getColor(r10)
        L_0x00f8:
            r1.setTextColor(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5601h.mo27530a(com.introvd.template.r.a.a$b, int):void");
    }
}
