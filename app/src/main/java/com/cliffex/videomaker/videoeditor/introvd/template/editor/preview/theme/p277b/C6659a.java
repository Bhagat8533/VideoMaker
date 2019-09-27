package com.introvd.template.editor.preview.theme.p277b;

import android.support.p021v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.editor.preview.theme.p276a.C6657a;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.p383c.C8399c;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.editor.preview.theme.b.a */
public class C6659a extends BaseItem<C6657a> {
    public C6659a(FragmentActivity fragmentActivity, C6657a aVar) {
        super(fragmentActivity, aVar);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_listitem_get_more;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) baseHolder.findViewById(R.id.item_root_view);
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) baseHolder.findViewById(R.id.item_cover);
        ImageView imageView = (ImageView) baseHolder.findViewById(R.id.icon_new);
        dynamicLoadingImageView.setImageResource(R.drawable.xiaoying_cam_icon_filter_store);
        if (((C6657a) getItemData()).cDa) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        relativeLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TemplateRouter.startTemplateInfoActivityByTheme(C6659a.this.getActivity(), C8399c.ecX, ((C6657a) C6659a.this.getItemData()).isMVPrj ? 3 : 2);
            }
        });
    }
}
