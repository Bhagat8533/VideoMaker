package com.introvd.template.app.creation.testb;

import android.content.Context;
import com.introvd.template.R;
import com.introvd.template.app.creation.testb.C3843b.C3845a;
import com.introvd.template.router.todoCode.TodoConstants;
import com.p131c.p132a.C2561a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.app.creation.testb.c */
public class C3846c {
    private List<C3843b> bpw = new ArrayList();
    private List<C3843b> bpx = new ArrayList();
    private Context mContext;

    public C3846c(Context context) {
        this.mContext = context;
        m9472KP();
        m9473KQ();
    }

    /* renamed from: KP */
    private void m9472KP() {
        C3843b KO = new C3845a().mo23374gy(1).mo23373gB(408).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_com_home_edit_photo)).mo23372gA(R.drawable.creation_mv_tool_bg).mo23375gz(R.drawable.creation_mv_tool_icon).mo23370KO();
        C3843b KO2 = new C3845a().mo23374gy(1).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_com_home_edit_more)).mo23373gB(401).mo23372gA(R.drawable.creation_edit_tool_bg).mo23375gz(R.drawable.creation_edit_tool_icon).mo23370KO();
        C3843b KO3 = new C3845a().mo23374gy(3).mo23373gB(605).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_template_title)).mo23372gA(R.drawable.creation_template_tool_bg).mo23375gz(R.drawable.creation_template_tool_icon).mo23370KO();
        C3843b KO4 = new C3845a().mo23374gy(4).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_com_more)).mo23372gA(R.drawable.creation_more_tool_bg).mo23375gz(R.drawable.creation_more_tool_icon).mo23370KO();
        this.bpw.add(KO);
        this.bpw.add(KO2);
        this.bpw.add(KO3);
        this.bpw.add(KO4);
    }

    /* renamed from: KQ */
    private void m9473KQ() {
        C3843b KO = new C3845a().mo23374gy(2).mo23373gB(TodoConstants.TODO_TYPE_VIDEO_FETCHER).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_tool_video_download_title)).mo23372gA(R.drawable.creation_video_download_tool_bg).mo23375gz(R.drawable.creation_video_download_tool_icon).mo23370KO();
        C3843b KO2 = new C3845a().mo23374gy(2).mo23373gB(TodoConstants.TODO_TYPE_FUNNY_VIDEO).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_tool_funny_edit_title)).mo23372gA(R.drawable.creation_funny_edit_tool_bg).mo23375gz(R.drawable.creation_funny_edit_tool_icon).mo23370KO();
        C3843b KO3 = new C3845a().mo23374gy(2).mo23373gB(TodoConstants.TODO_TYPE_CAMERA_MODE_MV6).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_cam_camera_mode_mv)).mo23372gA(R.drawable.creation_music_camera_tool_bg).mo23375gz(R.drawable.creation_music_camera_tool_icon).mo23370KO();
        C3843b KO4 = new C3845a().mo23374gy(2).mo23373gB(TodoConstants.TODO_TYPE_CAMERA_MODE_FB6).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_cam_camera_mode_face_beauty)).mo23372gA(R.drawable.creation_facial_camera_tool_bg).mo23375gz(R.drawable.creation_facial_camera_tool_icon).mo23370KO();
        C3843b KO5 = new C3845a().mo23374gy(2).mo23373gB(TodoConstants.TODO_TYPE_CAMERA_MODE_PIP).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_cam_camera_mode_pip)).mo23372gA(R.drawable.creation_pip_camera_tool_bg).mo23375gz(R.drawable.creation_pip_camera_tool_icon).mo23370KO();
        C3843b KO6 = new C3845a().mo23374gy(2).mo23373gB(409).mo23371ds(this.mContext.getResources().getString(R.string.xiaoying_str_com_home_edit_pip)).mo23372gA(R.drawable.creation_pip_edit_tool_bg).mo23375gz(R.drawable.creation_pip_edit_tool_icon).mo23370KO();
        if (!C2561a.aOS()) {
            this.bpx.add(KO);
            this.bpx.add(KO2);
        }
        this.bpx.add(KO3);
        this.bpx.add(KO4);
        this.bpx.add(KO5);
        this.bpx.add(KO6);
    }

    /* renamed from: KE */
    public List<C3843b> mo23376KE() {
        return this.bpw;
    }

    /* renamed from: KF */
    public List<C3843b> mo23377KF() {
        return this.bpx;
    }
}
