package com.introvd.template.explorer.music.item;

import android.support.p021v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.explorer.ExplorerRouter.FileExplorerParams;
import com.introvd.template.vivaexplorermodule.R;

/* renamed from: com.introvd.template.explorer.music.item.b */
public class C7297b extends BaseItem<Void> {
    /* access modifiers changed from: private */
    public C7300a dBv;
    private boolean dBw;

    /* renamed from: com.introvd.template.explorer.music.item.b$a */
    public interface C7300a {
        void axq();
    }

    public C7297b(Fragment fragment, boolean z) {
        super(fragment.getActivity());
        this.dBw = z;
    }

    /* renamed from: a */
    public void mo31899a(C7300a aVar) {
        this.dBv = aVar;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.list_item_music_local_scan;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        baseHolder.findViewById(R.id.scan_container).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C7297b.this.getActivity() != null) {
                    VivaRouter.getRouterBuilder(FileExplorerParams.URL).mo10386a(CommonParams.INTENT_MAGIC_CODE, C7297b.this.getActivity().getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0)).mo10406h(FileExplorerParams.KEY_EXPLORER_FILE_TYPE, 1).mo10382H(C7297b.this.getActivity());
                    C7256a.m21416fV(C7297b.this.getActivity());
                }
            }
        });
        View findViewById = baseHolder.findViewById(R.id.music_search_entry_container);
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!(C7297b.this.getActivity() == null || C7297b.this.dBv == null)) {
                    C7297b.this.dBv.axq();
                }
            }
        });
        View findViewById2 = baseHolder.findViewById(R.id.scan_layout_type_a);
        View findViewById3 = baseHolder.findViewById(R.id.scan_layout_type_b);
        if (this.dBw) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(0);
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setVisibility(0);
        findViewById3.setVisibility(8);
    }
}
