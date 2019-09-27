package com.introvd.template.template.category.p403a;

import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.category.C8640a;
import com.introvd.template.template.info.AnimateFrameActivity;
import com.introvd.template.template.info.FontListActivity;
import com.introvd.template.template.info.TemplateInfoActivity;
import com.introvd.template.template.info.filter.FilterActivity;
import com.introvd.template.template.p407e.C8735f;
import java.util.HashMap;

/* renamed from: com.introvd.template.template.category.a.b */
public class C8642b extends BaseItem<C8640a> {
    public long dGo;

    public C8642b(FragmentActivity fragmentActivity, C8640a aVar) {
        super(fragmentActivity, aVar);
        this.dGo = fragmentActivity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: gY */
    public void m25184gY(String str) {
        HashMap hashMap = new HashMap();
        if (str.equals(C8399c.ecX)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_theme");
        } else if (str.equals(C8399c.ecY)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_filter");
        } else if (str.equals(C8399c.ecZ)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_transition");
        } else if (str.equals(C8399c.eda)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_poster");
        } else if (str.equals(C8399c.edb)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_title");
        } else if (str.equals(C8399c.edc)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_music");
        } else if (str.equals(C8399c.edd)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_fx");
        } else if (str.equals(C8399c.ede)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_sticker");
        } else if (str.equals(C8399c.edf)) {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "MC_font");
        } else {
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "unknow");
        }
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Template_Enter_New_Version", hashMap);
        C8345d.m24070l(VivaBaseApplication.m8749FZ(), str, false);
        Intent intent = str.equals(C8399c.ecY) ? new Intent(getActivity(), FilterActivity.class) : str.equals(C8399c.edf) ? new Intent(getActivity(), FontListActivity.class) : C8399c.edd.equals(str) ? new Intent(getActivity(), AnimateFrameActivity.class) : new Intent(getActivity(), TemplateInfoActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, this.dGo);
        bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, str);
        intent.putExtra(TemplateRouter.INTENT_EXTRA_BOOLEAN_FROM_MATERIAL, true);
        intent.putExtras(bundle);
        if (getActivity() != null) {
            getActivity().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.v5_xiaoying_template_category_list_item;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        final C8640a aVar = (C8640a) getItemData();
        if (aVar != null) {
            TextView textView = (TextView) baseHolder.findViewById(R.id.template_list_item_txt_title);
            TextView textView2 = (TextView) baseHolder.findViewById(R.id.template_list_item_txt_total);
            ImageView imageView = (ImageView) baseHolder.findViewById(R.id.template_list_item_img_icon);
            ImageView imageView2 = (ImageView) baseHolder.findViewById(R.id.template_list_item_img_detail);
            ImageView imageView3 = (ImageView) baseHolder.findViewById(R.id.template_list_item_img_mask);
            TextView textView3 = (TextView) baseHolder.findViewById(R.id.template_list_item_txt_new_count);
            RelativeLayout relativeLayout = (RelativeLayout) baseHolder.findViewById(R.id.item_layout);
            textView.setText(aVar.title);
            if (!C8735f.aMf().mo35143aq(getActivity(), aVar.tcid) || aVar.ekn <= 0 || C8399c.edf.equals(aVar.tcid)) {
                textView2.setVisibility(4);
            } else {
                textView2.setVisibility(0);
                textView2.setText(String.valueOf(aVar.ekn));
            }
            imageView.setImageResource(aVar.ekm);
            if (!TextUtils.isEmpty(aVar.iconUrl)) {
            }
            relativeLayout.setTag(aVar.tcid);
            relativeLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8642b.this.m25184gY(aVar.tcid);
                }
            });
        }
    }
}
