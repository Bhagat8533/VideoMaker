package com.introvd.template.explorer.music.item;

import android.support.p021v4.app.Fragment;
import android.text.TextUtils;
import android.widget.TextView;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.vivaexplorermodule.R;

/* renamed from: com.introvd.template.explorer.music.item.a */
public class C7296a extends BaseItem<String> {
    public C7296a(Fragment fragment) {
        super(fragment.getActivity());
    }

    public C7296a(Fragment fragment, String str) {
        super(fragment.getActivity(), str);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.list_item_loading;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        String str = (String) getItemData();
        if (!TextUtils.isEmpty(str)) {
            ((TextView) baseHolder.findViewById(R.id.list_item_music_load_more)).setText(str);
        }
    }
}
