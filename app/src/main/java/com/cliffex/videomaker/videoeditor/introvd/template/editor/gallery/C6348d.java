package com.introvd.template.editor.gallery;

import android.text.TextUtils;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.sdk.editor.cache.C8442c;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* renamed from: com.introvd.template.editor.gallery.d */
public class C6348d {
    private static C6348d cTg;
    private List<TrimedClipItemDataModel> cTh = new ArrayList();
    private final List<String> cTi = new ArrayList();
    private final Map<String, C8442c> cTj = new HashMap();
    private int cTk = 0;

    private C6348d() {
    }

    public static C6348d amK() {
        if (cTg == null) {
            cTg = new C6348d();
        }
        return cTg;
    }

    /* renamed from: hZ */
    private TrimedClipItemDataModel m18214hZ(String str) {
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (TextUtils.equals(str, trimedClipItemDataModel.mRawFilePath)) {
                return trimedClipItemDataModel;
            }
        }
        return null;
    }

    /* renamed from: ia */
    private boolean m18215ia(String str) {
        return this.cTi.contains(str);
    }

    /* renamed from: a */
    public void mo29363a(String str, C8442c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            this.cTj.put(str, cVar);
        }
    }

    public int amL() {
        return this.cTk;
    }

    public int amM() {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (trimedClipItemDataModel.isImage.booleanValue()) {
                i += trimedClipItemDataModel.repeatCount.intValue();
            }
        }
        return i;
    }

    public int amN() {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (trimedClipItemDataModel != null) {
                i += trimedClipItemDataModel.repeatCount.intValue();
            }
        }
        return i;
    }

    public List<TrimedClipItemDataModel> amO() {
        if (this.cTh == null) {
            this.cTh = new ArrayList();
        }
        return this.cTh;
    }

    public boolean amP() {
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (trimedClipItemDataModel.isImage.booleanValue() && !FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                return true;
            }
            if (trimedClipItemDataModel.bNeedTranscode) {
                return true;
            }
        }
        return false;
    }

    public int amQ() {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if ((!trimedClipItemDataModel.isImage.booleanValue() || FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) && !trimedClipItemDataModel.bNeedTranscode) {
                i += trimedClipItemDataModel.repeatCount.intValue();
            }
        }
        return i;
    }

    public int amR() {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (trimedClipItemDataModel.isImage.booleanValue()) {
                i += trimedClipItemDataModel.repeatCount.intValue() * 3000;
            } else {
                VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                if (veRange != null && veRange.getmTimeLength() > 0) {
                    i += veRange.getmTimeLength();
                }
            }
        }
        return i;
    }

    public int amS() {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (!trimedClipItemDataModel.isImage.booleanValue() && trimedClipItemDataModel.bNeedTranscode) {
                VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                if (veRange != null && veRange.getmTimeLength() > 0) {
                    i += veRange.getmTimeLength();
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public void mo29372b(String str, C8442c cVar) {
        if (!m18215ia(str) && cVar != null) {
            TrimedClipItemDataModel hZ = m18214hZ(str);
            if (hZ != null) {
                if (!(hZ.mVeRangeInRawVideo == null || cVar.mVeRange == null)) {
                    hZ.mVeRangeInRawVideo.setmPosition(cVar.mVeRange.getmPosition());
                    hZ.mVeRangeInRawVideo.setmTimeLength(cVar.mVeRange.getmTimeLength());
                }
                hZ.mRotate = Integer.valueOf(cVar.aHX());
            }
        }
    }

    /* renamed from: e */
    public void mo29373e(TrimedClipItemDataModel trimedClipItemDataModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("selectMediaItem = ");
        sb.append(trimedClipItemDataModel);
        LogUtilsV2.m14227d(sb.toString());
        if (mo29380ic(trimedClipItemDataModel.mRawFilePath) <= 0) {
            this.cTh.add(trimedClipItemDataModel);
        }
    }

    /* renamed from: f */
    public void mo29374f(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (m18215ia(trimedClipItemDataModel.mRawFilePath)) {
            this.cTh.add(trimedClipItemDataModel);
        } else {
            this.cTi.add(trimedClipItemDataModel.mRawFilePath);
        }
    }

    /* renamed from: fX */
    public int mo29375fX(boolean z) {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (z) {
                if (trimedClipItemDataModel.isImage.booleanValue()) {
                    i++;
                }
            } else if (!trimedClipItemDataModel.isImage.booleanValue() && trimedClipItemDataModel.bNeedTranscode) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: hW */
    public void mo29376hW(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("repeatMediaItem ");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        TrimedClipItemDataModel hZ = m18214hZ(str);
        if (hZ != null) {
            hZ.repeatCount = Integer.valueOf(hZ.repeatCount.intValue() + 1);
        }
    }

    /* renamed from: hX */
    public C8442c mo29377hX(String str) {
        return (C8442c) this.cTj.get(str);
    }

    /* renamed from: hY */
    public void mo29378hY(String str) {
        if (!TextUtils.isEmpty(str)) {
            ListIterator listIterator = this.cTh.listIterator();
            while (true) {
                if (listIterator.hasNext()) {
                    if (TextUtils.equals(str, ((TrimedClipItemDataModel) listIterator.next()).mRawFilePath)) {
                        listIterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.cTi.remove(str);
            this.cTj.remove(str);
        }
    }

    /* renamed from: ib */
    public int mo29379ib(String str) {
        if (m18215ia(str)) {
            return mo29380ic(str);
        }
        return 0;
    }

    /* renamed from: ic */
    public int mo29380ic(String str) {
        int i = 0;
        for (TrimedClipItemDataModel trimedClipItemDataModel : this.cTh) {
            if (TextUtils.equals(str, trimedClipItemDataModel.mRawFilePath)) {
                i += trimedClipItemDataModel.repeatCount.intValue();
                if (trimedClipItemDataModel.isImage.booleanValue()) {
                    break;
                }
            }
        }
        return i;
    }

    /* renamed from: nB */
    public void mo29381nB(int i) {
        this.cTk = i;
    }

    public void reset() {
        this.cTh.clear();
        this.cTi.clear();
        this.cTj.clear();
    }
}
