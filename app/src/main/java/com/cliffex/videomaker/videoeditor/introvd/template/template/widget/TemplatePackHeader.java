package com.introvd.template.template.widget;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8733e;

public class TemplatePackHeader extends RelativeLayout implements OnClickListener {
    private ImageView eux;
    private TextView euy;
    private Context mContext;
    private Handler mHandler;

    public TemplatePackHeader(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public TemplatePackHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public TemplatePackHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.v4_xiaoying_template_package_header_layout, this, true);
        this.eux = (ImageView) findViewById(R.id.img_bg);
        this.euy = (TextView) findViewById(R.id.text_info);
        LayoutParams layoutParams = (LayoutParams) this.eux.getLayoutParams();
        layoutParams.width = Constants.getScreenSize().width;
        layoutParams.height = (layoutParams.width * 4) / 9;
        this.eux.setLayoutParams(layoutParams);
    }

    public boolean aMv() {
        for (TemplateInfo templateInfo : C8733e.aMa().aMe()) {
            if (templateInfo.nState != 6 && templateInfo.nState != 3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public void mo35489b(TemplatePackageInfo templatePackageInfo) {
        if (!TextUtils.isEmpty(templatePackageInfo.strBannerUrl)) {
            ImageLoader.loadImage(this.eux.getContext(), templatePackageInfo.strBannerUrl, this.eux);
        }
        this.euy.setText(templatePackageInfo.strIntro);
    }

    public void onClick(View view) {
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
