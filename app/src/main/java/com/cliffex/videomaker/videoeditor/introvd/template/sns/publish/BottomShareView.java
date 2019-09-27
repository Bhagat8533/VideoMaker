package com.introvd.template.sns.publish;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.SnsConfigMgr;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p414ui.view.HotFixRecyclerView;
import com.introvd.template.sns.OnIconClickListener;
import com.introvd.template.sns.SnsShareTypeUtil;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

public class BottomShareView extends RelativeLayout {
    public static final int BOTTOM_SHARE_MODE_COMMUNITY = 1;
    public static final int BOTTOM_SHARE_MODE_COMMUNITY_OVERSEA = 2;
    public static final int BOTTOM_SHARE_MODE_TOOL = 0;
    private Context mContext;
    private C1008a mShareIconAdapter;
    private HotFixRecyclerView rvShareSNS;
    private TextView tvShareTitle;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BottomShareMode {
    }

    public BottomShareView(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public BottomShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public BottomShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private List<Integer> getIconList(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            List<Integer> initOverSeaSnsList = SnsShareTypeUtil.initOverSeaSnsList(this.mContext.getApplicationContext());
            initOverSeaSnsList.add(Integer.valueOf(100));
            return initOverSeaSnsList;
        } else if (i == 1) {
            arrayList.add(Integer.valueOf(10));
            arrayList.add(Integer.valueOf(7));
            arrayList.add(Integer.valueOf(6));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(11));
            return arrayList;
        } else {
            List<Integer> loadSnsConfigInfos = SnsConfigMgr.loadSnsConfigInfos(this.mContext.getApplicationContext(), AppStateModel.getInstance().getCountryCode());
            if (loadSnsConfigInfos == null) {
                loadSnsConfigInfos = new ArrayList<>();
                if (AppStateModel.COUNTRY_CODE_Indonesia.equals(AppStateModel.getInstance().getCountryCode())) {
                    loadSnsConfigInfos.add(Integer.valueOf(45));
                }
                loadSnsConfigInfos.add(Integer.valueOf(31));
                loadSnsConfigInfos.add(Integer.valueOf(32));
                loadSnsConfigInfos.add(Integer.valueOf(28));
                loadSnsConfigInfos.add(Integer.valueOf(33));
                loadSnsConfigInfos.add(Integer.valueOf(26));
                loadSnsConfigInfos.add(Integer.valueOf(29));
                loadSnsConfigInfos.add(Integer.valueOf(7));
                loadSnsConfigInfos.add(Integer.valueOf(4));
            }
            List<Integer> list = loadSnsConfigInfos;
            list.add(Integer.valueOf(100));
            return list;
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(C10122R.C10126layout.layout_bottom_common_share_view, this, true);
        this.tvShareTitle = (TextView) findViewById(C10122R.C10124id.show_txt_info);
        this.rvShareSNS = (HotFixRecyclerView) findViewById(C10122R.C10124id.share_list_layout);
    }

    public void changeShareTitle(int i) {
        this.tvShareTitle.setText(i);
    }

    public void initData(int i, boolean z, OnIconClickListener onIconClickListener) {
        List iconList = getIconList(i);
        if (i == 0) {
            this.mShareIconAdapter = new OverseaShareAdapter(iconList, onIconClickListener);
        } else if (i == 1) {
            this.mShareIconAdapter = new SnSShareAdapter(iconList, z);
        } else {
            this.mShareIconAdapter = new OverseaShareAdapter(iconList, onIconClickListener);
        }
        this.rvShareSNS.setAdapter(this.mShareIconAdapter);
    }

    public void releaseAll() {
        if (this.rvShareSNS != null) {
            this.rvShareSNS.setAdapter(null);
        }
        this.mShareIconAdapter = null;
    }
}
