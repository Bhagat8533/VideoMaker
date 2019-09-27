package com.introvd.template.template.category.p403a;

import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.Constants;
import com.introvd.template.common.p236ui.banner.LoopViewPager;
import com.introvd.template.common.p236ui.banner.LoopViewPager.PagerFormatData;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.category.TemplateCategoryActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.category.a.a */
public class C8641a extends BaseItem<List<BannerInfo>> {
    public LoopViewPager ekv;

    public C8641a(FragmentActivity fragmentActivity, List<BannerInfo> list) {
        super(fragmentActivity, list);
    }

    private List<PagerFormatData> aKm() {
        ArrayList arrayList = new ArrayList();
        PagerFormatData pagerFormatData = new PagerFormatData();
        pagerFormatData.f3453id = "younger id";
        pagerFormatData.imgUrl = "http://hybrid.xiaoying.tv/vcm/20190408/17263131/2019040817263131.png";
        pagerFormatData.todoCode = Integer.valueOf(610);
        pagerFormatData.name = "";
        pagerFormatData.todoContent = "{\"tcid\": \"5\", \"rollcode\": \"19040411170505\"}";
        pagerFormatData.description = "";
        arrayList.add(pagerFormatData);
        return arrayList;
    }

    /* renamed from: cN */
    public List<PagerFormatData> mo34943cN(List<BannerInfo> list) {
        IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
        if (iAppService != null ? iAppService.isYoungerMode() : false) {
            return aKm();
        }
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (BannerInfo bannerInfo : list) {
            PagerFormatData pagerFormatData = new PagerFormatData();
            StringBuilder sb = new StringBuilder();
            sb.append(bannerInfo.f3572id);
            sb.append("");
            pagerFormatData.f3453id = sb.toString();
            pagerFormatData.imgUrl = bannerInfo.strContentUrl;
            pagerFormatData.todoCode = Integer.valueOf(bannerInfo.todoType);
            pagerFormatData.name = bannerInfo.strContentTitle;
            pagerFormatData.todoContent = bannerInfo.strTodoContent;
            pagerFormatData.description = bannerInfo.strDesc;
            arrayList.add(pagerFormatData);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.v4_xiaoying_template_category_banner_layout;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        if (getActivity() != null) {
            List list = (List) getItemData();
            ImageView imageView = (ImageView) baseHolder.findViewById(R.id.template_default_img);
            this.ekv = (LoopViewPager) baseHolder.findViewById(R.id.template_viewpager);
            this.ekv.mBannerCode = 11;
            this.ekv.init(mo34943cN(list), true, true);
            if (getActivity() instanceof TemplateCategoryActivity) {
                SwipeRefreshLayout swipeRefreshLayout = ((TemplateCategoryActivity) getActivity()).dCq;
                this.ekv.handleCollision(new View[]{swipeRefreshLayout});
            }
            this.ekv.initIndicator(R.drawable.v5_xiaoying_materials_point_choose, R.drawable.v5_xiaoying_materials_point_unchoose, (LinearLayout) baseHolder.findViewById(R.id.template_pager_dot_layout));
            if (list.size() < 1) {
                if ("zh".equals(getActivity().getResources().getConfiguration().locale.getLanguage().toLowerCase())) {
                    imageView.setImageResource(R.drawable.v5_xiaoying_home_banner_default_cn);
                } else {
                    imageView.setImageResource(R.drawable.v5_xiaoying_home_banner_default_o);
                }
                this.ekv.setVisibility(8);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
                this.ekv.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) baseHolder.findViewById(R.id.template_pager_layout);
            new LayoutParams(-1, Constants.getScreenSize().width / 2);
        }
    }
}
