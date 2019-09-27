package com.introvd.template.editor.slideshow;

import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.editor.R;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.template.p409g.C8759b;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

@C1942a(mo10417rZ = "/Funny/themeTest")
public class SlideThemeTestActivity extends EventActivity {
    RecyclerView ama;
    private C8759b bOt;
    LinearLayout dfr;
    LinearLayout dfs;
    C6734a dft;
    List<C6737b> dfu = new ArrayList();
    List<C6737b> dfv = new ArrayList();

    /* renamed from: com.introvd.template.editor.slideshow.SlideThemeTestActivity$a */
    class C6734a extends C1008a<C6736a> {
        List<C6737b> dfx = new ArrayList();

        /* renamed from: com.introvd.template.editor.slideshow.SlideThemeTestActivity$a$a */
        class C6736a extends C1034u {
            TextView textView;

            public C6736a(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.theme_id);
            }
        }

        C6734a() {
        }

        /* renamed from: M */
        public C6736a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C6736a(LayoutInflater.from(SlideThemeTestActivity.this.getApplicationContext()).inflate(R.layout.funnt_theme_test_item_layout, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(C6736a aVar, int i) {
            final C6737b bVar = (C6737b) this.dfx.get(i);
            aVar.textView.setText(C8450a.m24469bn(bVar.cCN));
            aVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (SlideThemeTestActivity.this.dfr.isSelected()) {
                        FunnySlideRouter.launchFunnyEdit(SlideThemeTestActivity.this, bVar.cCN);
                    } else if (SlideThemeTestActivity.this.dfs.isSelected()) {
                        SlideshowRouter.launchSlideEditForTest(SlideThemeTestActivity.this, bVar.cCN);
                    }
                    SlideThemeTestActivity.this.finish();
                }
            });
        }

        /* renamed from: bz */
        public void mo30234bz(List<C6737b> list) {
            this.dfx = list;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.dfx.size();
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.SlideThemeTestActivity$b */
    class C6737b {
        long cCN;
        int dfA;

        public C6737b(int i, long j) {
            this.dfA = i;
            this.cCN = j;
        }
    }

    /* renamed from: a */
    private List<C6737b> m19551a(C8451b bVar) {
        ArrayList arrayList = new ArrayList();
        int count = this.bOt.getCount();
        for (int i = 0; i < count; i++) {
            EffectInfoModel vh = this.bOt.mo35214vh(i);
            if (vh != null && !vh.isbNeedDownload()) {
                int templateSubType = QTemplateIDUtils.getTemplateSubType(vh.mTemplateId);
                if (templateSubType == bVar.code) {
                    arrayList.add(new C6737b(templateSubType, vh.mTemplateId));
                }
            }
            if (vh != null) {
                String bn = C8450a.m24469bn(vh.mTemplateId);
                if (!TextUtils.isEmpty(bn) && bn.length() >= 6) {
                    if ("4".equalsIgnoreCase(bn.substring(bn.length() - 6, bn.length() - 5))) {
                        arrayList.add(new C6737b(QTemplateIDUtils.getTemplateSubType(vh.mTemplateId), vh.mTemplateId));
                    }
                }
            }
        }
        return arrayList;
    }

    public void aqU() {
        if (this.dfu.size() == 0) {
            this.dfu = m19551a(C8451b.FUNNY_THEME);
        }
        this.dft.mo30234bz(this.dfu);
    }

    public void aqV() {
        if (this.dfv.size() == 0) {
            this.dfv = m19551a(C8451b.STORY_THEME);
        }
        if (this.dfu.size() == 0) {
            this.dfu = m19551a(C8451b.FUNNY_THEME);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dfv);
        arrayList.addAll(this.dfu);
        this.dft.mo30234bz(arrayList);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_act_funny_theme_test);
        this.bOt = new C8759b(1);
        this.bOt.mo35196a(getApplicationContext(), -1, 0, true);
        this.ama = (RecyclerView) findViewById(R.id.rcview);
        this.ama.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.dft = new C6734a();
        this.ama.setAdapter(this.dft);
        this.dfr = (LinearLayout) findViewById(R.id.funny_layout);
        this.dfs = (LinearLayout) findViewById(R.id.story_layout);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                SlideThemeTestActivity.this.dfr.setSelected(true);
                SlideThemeTestActivity.this.dfs.setSelected(false);
                SlideThemeTestActivity.this.aqU();
            }
        }, this.dfr);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                SlideThemeTestActivity.this.dfs.setSelected(true);
                SlideThemeTestActivity.this.dfr.setSelected(false);
                SlideThemeTestActivity.this.aqV();
            }
        }, this.dfs);
    }
}
