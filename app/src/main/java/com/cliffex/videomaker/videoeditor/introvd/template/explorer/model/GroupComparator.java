package com.introvd.template.explorer.model;

import android.os.Environment;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.io.File;
import java.util.Comparator;
import java.util.Map;

public class GroupComparator implements Comparator<Long> {
    final GROUP_MEDIA_TYPE mGroupType;
    final Map<Long, MediaGroupItem> mMediaGroupMap;
    final String mStrCameraPath;
    final String mStrXYVideoCreation;
    final String mStrXYVideoPath;

    public GroupComparator(Map<Long, MediaGroupItem> map, GROUP_MEDIA_TYPE group_media_type, String str) {
        this.mMediaGroupMap = map;
        this.mGroupType = group_media_type;
        if (str == null) {
            this.mStrXYVideoPath = null;
        } else if (str.endsWith("/")) {
            this.mStrXYVideoPath = str;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            this.mStrXYVideoPath = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb2.append(File.separator);
        sb2.append("Camera/");
        this.mStrCameraPath = sb2.toString();
        this.mStrXYVideoCreation = CommonConfigure.APP_DEFAULT_EXPORT_PATH;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compare(java.lang.Long r5, java.lang.Long r6) {
        /*
            r4 = this;
            com.introvd.template.explorer.model.GROUP_MEDIA_TYPE r0 = r4.mGroupType
            com.introvd.template.explorer.model.GROUP_MEDIA_TYPE r1 = com.introvd.template.explorer.model.GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_FOLDER
            if (r0 != r1) goto L_0x008b
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r4.mMediaGroupMap
            java.lang.Object r5 = r0.get(r5)
            com.introvd.template.videoeditor.model.MediaGroupItem r5 = (com.introvd.template.videoeditor.model.MediaGroupItem) r5
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r4.mMediaGroupMap
            java.lang.Object r6 = r0.get(r6)
            com.introvd.template.videoeditor.model.MediaGroupItem r6 = (com.introvd.template.videoeditor.model.MediaGroupItem) r6
            r0 = 1
            r1 = -1
            if (r5 == 0) goto L_0x0089
            if (r6 == 0) goto L_0x0089
            java.lang.String r2 = r4.mStrXYVideoPath
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r4.mStrXYVideoPath
            java.lang.String r3 = r5.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x002c
        L_0x002a:
            r2 = -1
            goto L_0x0078
        L_0x002c:
            java.lang.String r2 = r4.mStrXYVideoPath
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r4.mStrXYVideoPath
            java.lang.String r3 = r6.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x003c
        L_0x003a:
            r2 = 1
            goto L_0x0078
        L_0x003c:
            java.lang.String r2 = r4.mStrXYVideoCreation
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r4.mStrXYVideoCreation
            java.lang.String r3 = r5.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x004b
            goto L_0x002a
        L_0x004b:
            java.lang.String r2 = r4.mStrXYVideoCreation
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = r4.mStrXYVideoCreation
            java.lang.String r3 = r6.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x005a
            goto L_0x003a
        L_0x005a:
            java.lang.String r2 = r4.mStrCameraPath
            java.lang.String r3 = r5.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x0065
            goto L_0x002a
        L_0x0065:
            java.lang.String r2 = r4.mStrCameraPath
            java.lang.String r3 = r6.strParentPath
            int r2 = r2.compareTo(r3)
            if (r2 != 0) goto L_0x0070
            goto L_0x003a
        L_0x0070:
            java.lang.String r2 = r5.strGroupDisplayName
            java.lang.String r3 = r6.strGroupDisplayName
            int r2 = r2.compareToIgnoreCase(r3)
        L_0x0078:
            boolean r5 = r5.isVirtualFile()
            if (r5 == 0) goto L_0x0080
            r0 = -1
            goto L_0x008f
        L_0x0080:
            boolean r5 = r6.isVirtualFile()
            if (r5 == 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            r0 = r2
            goto L_0x008f
        L_0x0089:
            r0 = 0
            goto L_0x008f
        L_0x008b:
            int r0 = r6.compareTo(r5)
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.model.GroupComparator.compare(java.lang.Long, java.lang.Long):int");
    }
}
