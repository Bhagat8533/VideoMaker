package com.introvd.template.editor.export;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p021v4.app.FragmentActivity;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.router.editor.export.ExportPrjInfo;
import com.introvd.template.router.editor.export.ExportVideoInfo;
import com.introvd.template.router.editor.export.IExportService;
import com.introvd.template.router.editor.export.IExportTpyeChoose;
import com.introvd.template.router.editor.export.PublishDetailInfo;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.C8572y;
import java.util.List;

@C1942a(mo10417rZ = "/XYVideoEditor/biz_video_export_service")
public class ExportServiceImpl implements IExportService {
    public boolean beginExportVideo(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g == null) {
            return false;
        }
        g.mo29058a(z, z2, str, z3, false);
        return true;
    }

    public boolean checkDurationOverLimit(FragmentActivity fragmentActivity, boolean z) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.mo29075fL(z);
        }
        return true;
    }

    public void clickChangeCover(FragmentActivity fragmentActivity, boolean z) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29074fK(z);
        }
    }

    public String getApplyThemeHexId(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alG() : "";
    }

    public String getApplyThemeName(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alH() : "";
    }

    public String getApplyThemeSubId(FragmentActivity fragmentActivity, String str) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.mo29077hH(str) : "";
    }

    public String getExportFileName(int i) {
        return ExportVideoFragment.getExportFileName(i);
    }

    public ExportPrjInfo getExportPrjInfo(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.aly();
        }
        return null;
    }

    public String getPrjCoverPath(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alx() : "";
    }

    public String getPrjEntrance(Context context, long j) {
        return C8404c.m24237bf(j);
    }

    public String getPrjExportUrl(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alv() : "";
    }

    public String getPrjThumbnailPath(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alw() : "";
    }

    public List<Integer> getProjectVIPList(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.alK();
        }
        return null;
    }

    public PublishDetailInfo getPublishDetailInfo(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.alJ();
        }
        return null;
    }

    public String getSubtitleEffectText(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        return g != null ? g.alB() : "";
    }

    public String getVideoCoverTitle(String str) {
        return C8572y.m25101oy(str);
    }

    public ExportVideoInfo getVideoInfoByExpType(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.alz();
        }
        return null;
    }

    public void handleBackClickJump(FragmentActivity fragmentActivity, int i, long j) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29079np(i);
        }
    }

    public void handleExport(FragmentActivity fragmentActivity, boolean z, String str, boolean z2) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29055a(z, str, z2);
        }
    }

    public void handleExportClick(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29056a(z, z2, str, z3);
        }
    }

    public void handleExportVideoActivityResult(FragmentActivity fragmentActivity, int i, int i2, Intent intent) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.onActivityResult(i, i2, intent);
        }
    }

    public boolean hasVIP(FragmentActivity fragmentActivity, int i) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.mo29080nr(i);
        }
        return false;
    }

    public void init(Context context) {
    }

    public boolean isExportSpaceEnough(FragmentActivity fragmentActivity, String str) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return g.mo29076hG(str);
        }
        return false;
    }

    public boolean isFunnyVideo(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return C8451b.m24480uq(g.alI());
        }
        return false;
    }

    public boolean isStoryVideo(FragmentActivity fragmentActivity) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            return C8451b.m24481ur(g.alI());
        }
        return false;
    }

    public String lauchPickCoverActivity(Activity activity, String str, String str2, String str3) {
        return ExportVideoFragment.lauchPickCoverActivity(activity, str, str2, str3);
    }

    public void loadCover(FragmentActivity fragmentActivity, int i, int i2, ImageView imageView) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29078n(imageView);
        }
    }

    public boolean registerExportVideoListener(FragmentActivity fragmentActivity, long j, long j2, boolean z) {
        return C6256j.alM().mo29182b(fragmentActivity, j, j2, z);
    }

    public boolean showExportChoose(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3, IExportTpyeChoose iExportTpyeChoose) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g == null) {
            return false;
        }
        g.mo29057a(z, z2, str, z3, iExportTpyeChoose);
        return true;
    }

    public void updatePublishDetailInfo(FragmentActivity fragmentActivity, PublishDetailInfo publishDetailInfo) {
        ExportVideoFragment g = C6256j.alM().mo29183g(fragmentActivity);
        if (g != null) {
            g.mo29054a(publishDetailInfo);
        }
    }
}
