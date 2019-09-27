package com.introvd.template.sdk.database.p385a;

import android.text.TextUtils;
import com.introvd.template.sdk.database.model.DBProject;
import com.introvd.template.sdk.database.model.DBProjectDao;
import com.introvd.template.sdk.database.model.DBProjectDao.Properties;
import com.introvd.template.sdk.database.model.DaoSession;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p390f.C8445a;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.C8542c;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.VeMSize;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.p490a.p495e.C10006h;
import org.greenrobot.p490a.p495e.C10008j;

/* renamed from: com.introvd.template.sdk.database.a.c */
public class C8409c {
    private DBProjectDao edt;

    public C8409c(DaoSession daoSession) {
        this.edt = daoSession.getDBProjectDao();
    }

    /* renamed from: a */
    private C8445a m24257a(DBProject dBProject) {
        String str = dBProject.url;
        if (!C8548e.isFileExisted(str)) {
            return null;
        }
        C8445a aVar = new C8445a();
        aVar.strPrjURL = str;
        aVar._id = dBProject._id.longValue();
        aVar.strPrjExportURL = dBProject.export_url;
        aVar.iPrjClipCount = dBProject.clip_count;
        aVar.egs = dBProject.duration;
        aVar.strPrjThumbnail = dBProject.thumbnail;
        aVar.strCoverURL = dBProject.coverURL;
        aVar.strPrjVersion = dBProject.version;
        aVar.strCreateTime = dBProject.create_time;
        aVar.strModifyTime = dBProject.modify_time;
        aVar.iIsDeleted = dBProject.is_deleted;
        aVar.iIsModified = dBProject.is_modified;
        aVar.streamWidth = dBProject.streamWidth;
        aVar.streamHeight = dBProject.streamHeight;
        aVar.usedEffectTempId = dBProject.effectID;
        aVar.egt = dBProject.entrance;
        aVar.prjThemeType = dBProject.theme_type;
        return aVar;
    }

    public ArrayList<DataItemProject> aHH() {
        ArrayList<DataItemProject> arrayList = new ArrayList<>();
        List<DBProject> list = this.edt.queryBuilder().mo38464a(Properties.Is_deleted.mo38481aC(Integer.valueOf(0)), new C10008j[0]).mo38466b(Properties._id).bas().list();
        if (list == null) {
            return arrayList;
        }
        for (DBProject dBProject : list) {
            DataItemProject dataItemProject = new DataItemProject();
            dataItemProject._id = dBProject._id.longValue();
            dataItemProject.strPrjURL = dBProject.url;
            if (C8548e.isFileExisted(dataItemProject.strPrjURL)) {
                dataItemProject.strPrjExportURL = dBProject.export_url;
                dataItemProject.iPrjClipCount = dBProject.clip_count;
                dataItemProject.iPrjDuration = (int) dBProject.duration;
                dataItemProject.strPrjThumbnail = dBProject.thumbnail;
                dataItemProject.strCoverURL = dBProject.coverURL;
                dataItemProject.strPrjVersion = dBProject.version;
                dataItemProject.strCreateTime = dBProject.create_time;
                dataItemProject.strModifyTime = dBProject.modify_time;
                dataItemProject.iIsDeleted = dBProject.is_deleted;
                dataItemProject.iIsModified = dBProject.is_modified;
                dataItemProject.streamWidth = dBProject.streamWidth;
                dataItemProject.streamHeight = dBProject.streamHeight;
                dataItemProject.usedEffectTempId = dBProject.effectID;
                dataItemProject.todoCode = dBProject.todoCode;
                dataItemProject.editStatus = dBProject.editCode;
                dataItemProject.iCameraCode = dBProject.cameraCode;
                dataItemProject.entrance = dBProject.entrance;
                dataItemProject.videoTemplateInfo = dBProject.video_template_info;
                dataItemProject.nDurationLimit = dBProject.duration_limit;
                dataItemProject.prjThemeType = dBProject.theme_type;
                dataItemProject.strPrjTitle = dBProject.title;
                dataItemProject.strVideoDesc = dBProject.video_desc;
                dataItemProject.strActivityData = dBProject.activityData;
                dataItemProject.strExtra = dBProject.extras;
                arrayList.add(dataItemProject);
            }
        }
        return arrayList;
    }

    public String aHI() {
        List list = this.edt.queryBuilder().mo38464a(Properties.Is_deleted.mo38481aC(Integer.valueOf(0)), new C10008j[0]).mo38466b(Properties.Modify_time).bas().list();
        if (list == null) {
            return "";
        }
        String str = "";
        Calendar instance = Calendar.getInstance();
        instance.add(6, -1);
        Date time = instance.getTime();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DBProject dBProject = (DBProject) it.next();
            if (dBProject.theme_type != 1) {
                if (TextUtils.isEmpty(dBProject.export_url) || !C8548e.isFileExisted(dBProject.export_url) || dBProject.is_modified == 1) {
                    continue;
                } else {
                    try {
                        if (C8542c.m24982b(new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).parse(dBProject.modify_time), time)) {
                            str = dBProject.url;
                            break;
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: ao */
    public List<C8445a> mo33995ao(int i, boolean z) {
        C10006h queryBuilder = this.edt.queryBuilder();
        if (!z) {
            queryBuilder.mo38464a(Properties.Is_deleted.mo38481aC(Integer.valueOf(0)), Properties.Clip_count.mo38482aD(Integer.valueOf(0)));
        }
        List<DBProject> list = queryBuilder.mo38466b(Properties.Modify_time).bas().list();
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DBProject a : list) {
            C8445a a2 = m24257a(a);
            if (a2 != null && C8548e.isFileExisted(a2.strPrjURL)) {
                if (((i == 1 && C8446b.m24444g(a2)) || ((i == 2 && !C8446b.m24444g(a2)) || i == 0)) && !C8451b.m24480uq(a2.prjThemeType)) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: bd */
    public void mo33996bd(long j) {
        this.edt.deleteByKey(Long.valueOf(j));
    }

    /* renamed from: be */
    public String mo33997be(long j) {
        List list = this.edt.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return ((DBProject) list.get(0)).url;
    }

    /* renamed from: bf */
    public String mo33998bf(long j) {
        String str = "";
        List list = this.edt.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list != null && list.size() > 0) {
            str = ((DBProject) list.get(0)).entrance;
        }
        return TextUtils.isEmpty(str) ? "unknow" : str;
    }

    /* renamed from: bg */
    public int mo33999bg(long j) {
        List list = this.edt.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return -1;
        }
        return ((DBProject) list.get(0)).todoCode;
    }

    /* renamed from: c */
    public long mo34000c(DataItemProject dataItemProject) {
        if (dataItemProject == null) {
            return -1;
        }
        DBProject dBProject = new DBProject();
        dBProject.url = dataItemProject.strPrjURL;
        dBProject.export_url = dataItemProject.strPrjExportURL;
        dBProject.clip_count = dataItemProject.iPrjClipCount;
        dBProject.duration = (long) dataItemProject.iPrjDuration;
        dBProject.thumbnail = dataItemProject.strPrjThumbnail;
        dBProject.coverURL = dataItemProject.strCoverURL;
        dBProject.version = dataItemProject.strPrjVersion;
        dBProject.create_time = dataItemProject.strCreateTime;
        dBProject.modify_time = dataItemProject.strModifyTime;
        dBProject.is_deleted = dataItemProject.iIsDeleted;
        dBProject.is_modified = dataItemProject.iIsModified;
        dBProject.streamWidth = dataItemProject.streamWidth;
        dBProject.streamHeight = dataItemProject.streamHeight;
        dBProject.effectID = dataItemProject.usedEffectTempId;
        dBProject.editCode = dataItemProject.editStatus;
        dBProject.cameraCode = dataItemProject.iCameraCode;
        dBProject.extras = dataItemProject.strExtra;
        dBProject.duration_limit = dataItemProject.nDurationLimit;
        dBProject.theme_type = dataItemProject.prjThemeType;
        if (dataItemProject._id != -1) {
            dBProject._id = Long.valueOf(dataItemProject._id);
        }
        dataItemProject._id = this.edt.insertOrReplace(dBProject);
        return dataItemProject._id;
    }

    /* renamed from: j */
    public void mo34001j(long j, int i) {
        List list = this.edt.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list != null && list.size() > 0) {
            DBProject dBProject = (DBProject) list.get(0);
            dBProject.todoCode = i;
            this.edt.update(dBProject);
        }
    }

    /* renamed from: j */
    public void mo34002j(long j, String str) {
        List list = this.edt.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list != null && list.size() > 0) {
            DBProject dBProject = (DBProject) list.get(0);
            dBProject.entrance = str;
            this.edt.update(dBProject);
        }
    }

    /* renamed from: nB */
    public long mo34003nB(String str) {
        List list = this.edt.queryBuilder().mo38464a(Properties.Url.mo38481aC(str), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return -1;
        }
        return ((DBProject) list.get(0))._id.longValue();
    }

    /* renamed from: nC */
    public String mo34004nC(String str) {
        List list = this.edt.queryBuilder().mo38464a(Properties.Url.mo38481aC(str), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return ((DBProject) list.get(0)).coverURL;
    }

    /* renamed from: nD */
    public VeMSize mo34005nD(String str) {
        VeMSize veMSize = new VeMSize();
        if (!TextUtils.isEmpty(str)) {
            List list = this.edt.queryBuilder().mo38464a(Properties.Url.mo38481aC(str), new C10008j[0]).bas().list();
            if (list != null && list.size() > 0) {
                veMSize.width = ((DBProject) list.get(0)).streamWidth;
                veMSize.height = ((DBProject) list.get(0)).streamHeight;
            }
        }
        return veMSize;
    }

    /* renamed from: nE */
    public List<DBProject> mo34006nE(String str) {
        return this.edt.queryBuilder().mo38464a(Properties.Url.mo38481aC(str), new C10008j[0]).bas().list();
    }
}
