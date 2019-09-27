package com.introvd.template.editor.slideshow.p281d;

import android.content.Context;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.slide.ProjectSaveService;
import java.io.File;
import java.util.ArrayList;
import xiaoying.engine.slideshowsession.QSlideShowSession;

/* renamed from: com.introvd.template.editor.slideshow.d.a */
public class C6781a {
    private static C6781a dhS;
    private C8468c dfV = C8468c.aIQ();
    private String dhT = "";
    private String dhU = "";
    private long dhr = 0;

    private C6781a() {
    }

    public static C6781a asc() {
        if (dhS == null) {
            dhS = new C6781a();
        }
        return dhS;
    }

    /* renamed from: a */
    public void mo30312a(Context context, boolean z, ArrayList<TrimedClipItemDataModel> arrayList) {
        ProjectSaveService.m24486a(context, z, arrayList, this.dhT, false, this.dhr, context.getString(R.string.xiaoying_str_ve_default_back_cover_text), context.getString(R.string.xiaoying_str_ve_default_prj_title_text), this.dhU);
    }

    /* renamed from: a */
    public void mo30313a(C8451b bVar, long j, String str) {
        this.dhr = j;
        this.dhU = str;
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.getMediaSavePath());
        sb.append(C8468c.aIR());
        sb.append(File.separator);
        this.dhT = sb.toString();
        String fileName = FileUtils.getFileName(this.dhT);
        this.dfV.ebQ = -1;
        this.dfV.mo34603a(bVar, fileName, str);
        QSlideShowSession aIT = this.dfV.aIT();
        if (aIT != null && j != 0) {
            aIT.SetTheme(j);
        }
    }

    public String asd() {
        return this.dhT;
    }

    /* renamed from: fv */
    public void mo30315fv(Context context) {
        if (this.dfV != null) {
            DataItemProject aHe = this.dfV.aHe();
            if (aHe != null) {
                this.dfV.mo33875a(context, aHe.strPrjURL, 3, true);
            }
        }
    }
}
