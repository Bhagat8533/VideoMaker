package com.introvd.template.app.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.p236ui.Switch;

/* renamed from: com.introvd.template.app.setting.d */
class C4328d {
    RelativeLayout bBG;
    RelativeLayout bBH;
    RelativeLayout bBI;
    RelativeLayout bBJ;
    RelativeLayout bBK;
    RelativeLayout bBL;
    RelativeLayout bBM;
    RelativeLayout bBN;
    RelativeLayout bBO;
    RelativeLayout bBP;
    TextView bBQ;
    TextView bBR;
    TextView bBS;
    TextView bBT;
    TextView bBU;
    TextView bBV;
    TextView bBW;
    TextView bBX;
    TextView bBY;
    TextView bBZ;
    LinearLayout bCA;
    LinearLayout bCB;
    LinearLayout bCC;
    View bCD;
    View bCE;
    TextView bCa;
    TextView bCb;
    TextView bCc;
    TextView bCd;
    TextView bCe;
    TextView bCf;
    TextView bCg;
    TextView bCh;
    TextView bCi;
    TextView bCj;
    TextView bCk;
    TextView bCl;
    TextView bCm;
    TextView bCn;
    TextView bCo;
    TextView bCp;
    TextView bCq;
    TextView bCr;
    TextView bCs;
    Switch bCt;
    Switch bCu;
    Switch bCv;
    Switch bCw;
    Switch bCx;
    LinearLayout bCy;
    LinearLayout bCz;

    C4328d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo24375b(OnClickListener onClickListener) {
        this.bBN.setOnClickListener(onClickListener);
        this.bCD.setOnClickListener(onClickListener);
        this.bCE.setOnClickListener(onClickListener);
        this.bBQ.setOnClickListener(onClickListener);
        this.bBR.setOnClickListener(onClickListener);
        this.bBS.setOnClickListener(onClickListener);
        this.bBT.setOnClickListener(onClickListener);
        this.bBH.setOnClickListener(onClickListener);
        this.bBI.setOnClickListener(onClickListener);
        this.bBJ.setOnClickListener(onClickListener);
        this.bBW.setOnClickListener(onClickListener);
        this.bBX.setOnClickListener(onClickListener);
        this.bBY.setOnClickListener(onClickListener);
        this.bBZ.setOnClickListener(onClickListener);
        this.bCd.setOnClickListener(onClickListener);
        this.bBL.setOnClickListener(onClickListener);
        this.bBO.setOnClickListener(onClickListener);
        this.bCa.setOnClickListener(onClickListener);
        this.bCb.setOnClickListener(onClickListener);
        this.bCc.setOnClickListener(onClickListener);
        this.bBG.setOnClickListener(onClickListener);
        this.bCe.setOnClickListener(onClickListener);
        this.bCf.setOnClickListener(onClickListener);
        this.bCi.setOnClickListener(onClickListener);
        this.bCk.setOnClickListener(onClickListener);
        this.bCj.setOnClickListener(onClickListener);
        this.bBM.setOnClickListener(onClickListener);
        this.bCA.setOnClickListener(onClickListener);
        this.bCB.setOnClickListener(onClickListener);
        this.bCo.setOnClickListener(onClickListener);
        this.bCp.setOnClickListener(onClickListener);
        this.bCr.setOnClickListener(onClickListener);
        this.bCh.setOnClickListener(onClickListener);
        this.bBP.setOnClickListener(onClickListener);
        if (this.bCs != null) {
            this.bCs.setOnClickListener(onClickListener);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bS */
    public void mo24376bS(View view) {
        this.bCD = view.findViewById(R.id.setting_back);
        this.bCE = view.findViewById(R.id.imgview_workmode);
        this.bBQ = (TextView) view.findViewById(R.id.setting_receive_notification_text);
        this.bBR = (TextView) view.findViewById(R.id.setting_bind_sns_text);
        this.bCy = (LinearLayout) view.findViewById(R.id.setting_privacy_content_ll);
        this.bBG = (RelativeLayout) view.findViewById(R.id.setting_hide_location_rl);
        this.bCt = (Switch) view.findViewById(R.id.setting_hide_location_checkbox);
        this.bBS = (TextView) view.findViewById(R.id.setting_im_text);
        this.bBT = (TextView) view.findViewById(R.id.setting_black_list_text);
        this.bBH = (RelativeLayout) view.findViewById(R.id.setting_privacy_rl);
        this.bCu = (Switch) view.findViewById(R.id.setting_privacy_checkbox);
        this.bBI = (RelativeLayout) view.findViewById(R.id.setting_watermark_show_rl);
        this.bCv = (Switch) view.findViewById(R.id.setting_watermark_show_checkbox);
        this.bCq = (TextView) view.findViewById(R.id.setting_watermark_show_text);
        this.bBJ = (RelativeLayout) view.findViewById(R.id.setting_hardware_acc_rl);
        this.bCw = (Switch) view.findViewById(R.id.setting_hardware_acc_checkbox);
        this.bBU = (TextView) view.findViewById(R.id.setting_save_location_desc);
        this.bBV = (TextView) view.findViewById(R.id.setting_save_location_content);
        this.bBW = (TextView) view.findViewById(R.id.setting_camera_orientation_text);
        this.bBX = (TextView) view.findViewById(R.id.setting_international_sns_text);
        this.bBY = (TextView) view.findViewById(R.id.setting_recommend_viva_text);
        this.bBZ = (TextView) view.findViewById(R.id.setting_to_be_vip_text);
        this.bCa = (TextView) view.findViewById(R.id.setting_restore_purchases_text);
        this.bCb = (TextView) view.findViewById(R.id.setting_vip_unsign_text);
        this.bCc = (TextView) view.findViewById(R.id.setting_private_clause);
        this.bCd = (TextView) view.findViewById(R.id.setting_share_app_text);
        this.bCz = (LinearLayout) view.findViewById(R.id.setting_login_out_ll);
        this.bCe = (TextView) view.findViewById(R.id.setting_login_out_text);
        this.bBK = (RelativeLayout) view.findViewById(R.id.setting_follow_sns_rl_title);
        this.bCf = (TextView) view.findViewById(R.id.setting_follow_sns_instagram_text);
        this.bCg = (TextView) view.findViewById(R.id.setting_feedback_text);
        this.bCi = (TextView) view.findViewById(R.id.setting_follow_sns_facebook_text);
        this.bCk = (TextView) view.findViewById(R.id.setting_follow_sns_twitter_text);
        this.bCj = (TextView) view.findViewById(R.id.setting_follow_sns_line_text);
        this.bBL = (RelativeLayout) view.findViewById(R.id.setting_feedback_rl);
        this.bBO = (RelativeLayout) view.findViewById(R.id.rl_feedback_and_service);
        this.bCr = (TextView) view.findViewById(R.id.setting_bind_account);
        this.bBP = (RelativeLayout) view.findViewById(R.id.setting_younger_mode_rl);
        this.bCx = (Switch) view.findViewById(R.id.setting_younger_mode_checkbox);
        this.bBM = (RelativeLayout) view.findViewById(R.id.setting_save_location_rl);
        this.bBN = (RelativeLayout) view.findViewById(R.id.setting_about_viva_ll);
        this.bCl = (TextView) view.findViewById(R.id.setting_about_viva_new_flag);
        this.bCA = (LinearLayout) view.findViewById(R.id.setting_ll_choose_language);
        this.bCB = (LinearLayout) view.findViewById(R.id.setting_ll_choose_locale);
        this.bCm = (TextView) view.findViewById(R.id.setting_language_value);
        this.bCn = (TextView) view.findViewById(R.id.setting_locale_value);
        this.bCh = (TextView) view.findViewById(R.id.setting_network_text);
        this.bCC = (LinearLayout) view.findViewById(R.id.layout_data_collection);
        this.bCo = (TextView) view.findViewById(R.id.tv_collection_perm);
        this.bCp = (TextView) view.findViewById(R.id.tv_delete_usage_data);
        this.bCs = (TextView) view.findViewById(R.id.setting_wallet_text);
    }
}
