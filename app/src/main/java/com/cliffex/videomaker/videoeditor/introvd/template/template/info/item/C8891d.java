package com.introvd.template.template.info.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.MSize;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8736g;
import com.introvd.template.template.p409g.C8762d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.template.info.item.d */
public class C8891d {
    private int aeD;
    private String eqj = "";
    public boolean erX = false;
    private int erY;
    private List<TemplateInfo> erZ;
    protected Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.template.info.item.d$a */
    protected class C8893a {
        RelativeLayout cJe;
        DynamicLoadingImageView cpn;
        TextView dIf;
        ImageView dJk;
        TextView eqh;
        TextView eqi;

        protected C8893a() {
        }
    }

    public C8891d(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        MSize screenSize = DeviceInfo.getScreenSize(context);
        this.aeD = screenSize.width / 3;
        this.erY = screenSize.width / 3;
        this.erZ = C8733e.aMa().aMe();
    }

    /* renamed from: a */
    public void mo35438a(C8893a aVar, final int i) {
        TemplateItemData templateItemData = (TemplateItemData) C8736g.aMg().aMe().get(i);
        if (templateItemData != null) {
            mo35439a(aVar.cpn, templateItemData);
            String str = templateItemData.strTitle;
            if (this.erZ != null && i >= 0 && i < this.erZ.size()) {
                Iterator it = this.erZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TemplateInfo templateInfo = (TemplateInfo) it.next();
                    if (templateInfo.ttid.equals(C8450a.m24469bn(templateItemData.lID))) {
                        str = templateInfo.strTitle;
                        break;
                    }
                }
            } else {
                str = C8762d.aMt().mo35241l(templateItemData.lID, C8450a.m24471c(Constants.getLocale()));
            }
            TextView textView = aVar.dIf;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
            if (!TextUtils.isEmpty(templateItemData.strScene)) {
                aVar.eqh.setVisibility(0);
                aVar.eqh.setText(templateItemData.strScene);
            } else {
                aVar.eqh.setVisibility(8);
            }
            if (!TextUtils.isEmpty(templateItemData.strIntro)) {
                aVar.eqi.setText(templateItemData.strIntro);
                aVar.eqi.setVisibility(0);
            } else {
                aVar.eqi.setText("");
                aVar.eqi.setVisibility(8);
            }
        }
        aVar.dJk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8891d.this.mHandler.sendMessage(C8891d.this.mHandler.obtainMessage(36872, i, 0, null));
            }
        });
    }

    /* renamed from: a */
    public void mo35439a(DynamicLoadingImageView dynamicLoadingImageView, TemplateItemData templateItemData) {
        if (!TextUtils.isEmpty(templateItemData.strIcon)) {
            ImageLoader.loadImage(this.mContext, templateItemData.strIcon, (ImageView) dynamicLoadingImageView);
            return;
        }
        Bitmap a = C8762d.aMt().mo35220a(templateItemData.lID, this.aeD, this.erY, C8501a.aJs().aJv());
        String templateExternalFile = C8762d.aMt().getTemplateExternalFile(templateItemData.lID, 0, 3);
        if (!TextUtils.isEmpty(templateExternalFile)) {
            ImageLoader.loadImage(templateExternalFile, dynamicLoadingImageView);
        } else if (a != null) {
            dynamicLoadingImageView.setImageBitmap(a);
        } else if (this.erX) {
            dynamicLoadingImageView.setImageResource(R.drawable.xiaoying_com_template_default_poster);
        } else {
            dynamicLoadingImageView.setImageResource(R.drawable.xiaoying_com_template_manage_default_thumbnail);
        }
    }

    public String aLP() {
        return this.eqj;
    }

    /* renamed from: pK */
    public void mo35441pK(String str) {
        this.eqj = str;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
