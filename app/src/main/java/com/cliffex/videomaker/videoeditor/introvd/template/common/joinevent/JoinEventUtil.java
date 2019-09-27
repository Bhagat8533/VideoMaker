package com.introvd.template.common.joinevent;

import android.content.Context;
import android.database.Cursor;
import com.introvd.template.datacenter.SocialConstDef;

public class JoinEventUtil {
    /* renamed from: a */
    private static JoinEventInfo m14393a(JoinEventInfo joinEventInfo, Cursor cursor) {
        joinEventInfo.nId = cursor.getInt(cursor.getColumnIndex("_id"));
        joinEventInfo.strActivityID = cursor.getString(cursor.getColumnIndex("activityID"));
        joinEventInfo.strEventTitle = cursor.getString(cursor.getColumnIndex("eventTitle"));
        joinEventInfo.strSnsInfo = cursor.getString(cursor.getColumnIndex(SocialConstDef.ACTIVITY_JOIN_SNSINFO));
        joinEventInfo.strTemplates = cursor.getString(cursor.getColumnIndex(SocialConstDef.ACTIVITY_JOIN_TEMPLATES));
        joinEventInfo.nTodoType = cursor.getInt(cursor.getColumnIndex("todo_type"));
        joinEventInfo.strTodoContent = cursor.getString(cursor.getColumnIndex("todo_content"));
        return joinEventInfo;
    }

    public static JoinEventInfo getJoinEventInfo(Context context, String str) {
        if (context == null) {
            return null;
        }
        JoinEventInfo joinEventInfo = new JoinEventInfo();
        boolean query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_ACTIVITY_JOIN_DETAIL), null, "activityID = ?", new String[]{str}, null);
        if (query == null) {
            return null;
        }
        try {
            query = query.moveToFirst();
            if (query) {
                JoinEventInfo a = m14393a(joinEventInfo, query);
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception unused) {
                    }
                }
                return a;
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused2) {
                }
            }
            return null;
        } finally {
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused3) {
                }
            }
        }
    }
}
