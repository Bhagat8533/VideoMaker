package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.C7833b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class UserGradeInfoView extends RelativeLayout {
    private TextView blc;
    private TextView bld;
    private TextView ble;
    private View blf;
    private DynamicLoadingImageView blg;
    private TextView blh;

    public UserGradeInfoView(Context context) {
        super(context);
        m9252Iu();
    }

    public UserGradeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9252Iu();
    }

    public UserGradeInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9252Iu();
    }

    /* renamed from: ID */
    private void m9251ID() {
        TextView textView = (TextView) findViewById(R.id.user_vip_info);
        View findViewById = findViewById(R.id.user_to_be_vip);
        int aBC = C7833b.aBC();
        if (C7833b.m22830sj(aBC)) {
            textView.setText(getContext().getString(R.string.iap_vip_privilege_valid_date, new Object[]{C8048e.aBe().mo23624Mp()}));
            findViewById.setVisibility(8);
            textView.setVisibility(0);
        } else if (C7833b.m22831sk(aBC)) {
            textView.setText(R.string.iap_vip_renew_out_of_date);
            findViewById.setVisibility(8);
            textView.setVisibility(0);
        } else {
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C7897a.m23022b("Privilege", C7898b.dSW, new String[0]);
                    AdRouter.launchVipRenew(UserGradeInfoView.this.getContext());
                }
            });
            findViewById.setVisibility(0);
            textView.setVisibility(8);
        }
    }

    /* renamed from: Iu */
    private void m9252Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.user_grade_info_view, this, true);
        this.blc = (TextView) findViewById(R.id.textview_grade);
        this.bld = (TextView) findViewById(R.id.textview_exp);
        this.ble = (TextView) findViewById(R.id.textview_task);
        this.blf = findViewById(R.id.img_divider);
        this.blg = (DynamicLoadingImageView) findViewById(R.id.user_head_portrait);
        this.blh = (TextView) findViewById(R.id.user_name);
    }

    /* renamed from: a */
    public void mo23252a(C3800i iVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("LV ");
        sb.append(iVar.grade);
        this.blc.setText(sb.toString());
        Context context = getContext();
        int i = R.string.xiaoying_str_user_score_exp;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(iVar.score);
        sb2.append("/");
        sb2.append(iVar.nextGradeScore);
        this.bld.setText(context.getString(i, new Object[]{sb2.toString()}));
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            this.blh.setText(userInfo.nickname);
            this.blg.setOval(true);
            if (TextUtils.isEmpty(userInfo.avatarUrl)) {
                this.blg.setImage(R.drawable.xiaoying_com_default_avatar);
            } else {
                this.blg.setImageURI(userInfo.avatarUrl);
            }
        }
        if (TextUtils.isEmpty(iVar.nextGradeExtendInfo)) {
            this.blf.setVisibility(8);
            this.ble.setVisibility(8);
        } else {
            this.blf.setVisibility(0);
            this.ble.setVisibility(0);
            this.ble.setText(iVar.nextGradeExtendInfo);
        }
        m9251ID();
    }
}
