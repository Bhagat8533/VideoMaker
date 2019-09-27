package com.introvd.template.p309f;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.f.d */
public class C7350d {
    /* renamed from: a */
    public static Cursor m21689a(ContentResolver contentResolver, boolean z, int i) {
        Uri withAppendedPath = Uri.withAppendedPath(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_RAW_JOIN), "Publish left outer join Task");
        String[] strArr = {"Task._id AS TaskID", "Task.main_type", "Task.sub_type", "Task.state", "Task.sub_state", "Task.progress_1", "Task.progress_2", "Task.user_data", "Task.start_time", "Publish.project_title", "Publish.project_url", "Publish.video_thumbnail_local_url", "Publish.video_thumbnail_remote_url", "Publish.video_thumbnail_big", "Publish.video_poster_local_url", "Publish.video_poster_remote_url", "Publish.video_xy_page_url", "Publish.video_desc", "Publish.video_local_url", "Publish._id AS PublishID", "Publish.permission"};
        String str = "Task.user_data = Publish._id";
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" AND Publish._id = ");
            sb.append(i);
            str = sb.toString();
        }
        return contentResolver.query(withAppendedPath, strArr, str, null, "Task._id desc");
    }
}
