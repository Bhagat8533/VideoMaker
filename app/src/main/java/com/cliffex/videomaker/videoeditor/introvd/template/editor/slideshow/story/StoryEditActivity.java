package com.introvd.template.editor.slideshow.story;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener;
import com.introvd.template.common.bitmapfun.util.ImageWorkerFactory;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.p278a.C6740c;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.editor.slideshow.story.p285a.C6848a;
import com.introvd.template.editor.slideshow.story.p286b.C6850a;
import com.introvd.template.editor.slideshow.story.p286b.C6852c;
import com.introvd.template.editor.slideshow.story.view.SlideMaterialModule;
import com.introvd.template.editor.slideshow.story.view.SlideMaterialView;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.AppRouter.CommonWebPageParams;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.slide.model.SlideModuleData;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.sdk.utils.C8564s;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@C1942a(mo10417rZ = "/Story/Editor")
public class StoryEditActivity extends EventActivity implements OnClickListener, C6850a {
    /* access modifiers changed from: private */
    public static final String TAG = "StoryEditActivity";
    private boolean bTs;
    private ImageFetcherWithListener dgb;
    LinearLayout dic;
    TextView did;
    TextView die;
    ImageButton dif;
    /* access modifiers changed from: private */
    public C6852c dig;
    /* access modifiers changed from: private */
    public int dih;
    private List<SlideModuleData> dii = new ArrayList();
    private Map<Integer, Map<Integer, TrimedClipItemDataModel>> dij = new LinkedHashMap();
    private C6848a dik = new C6848a() {
        /* renamed from: cU */
        public void mo30467cU(int i, int i2) {
            String access$000 = StoryEditActivity.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("SlideModule onItemAdd ###Module:");
            sb.append(i);
            sb.append(",itemIndex:");
            sb.append(i2);
            LogUtils.m14223i(access$000, sb.toString());
            StoryEditActivity.this.dih = i;
            StoryEditActivity.this.m19972po(i);
        }

        /* renamed from: cV */
        public void mo30468cV(int i, int i2) {
            String access$000 = StoryEditActivity.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("SlideModule onItemDelete ###Module:");
            sb.append(i);
            sb.append(",itemIndex:");
            sb.append(i2);
            LogUtils.m14223i(access$000, sb.toString());
            StoryEditActivity.this.dig.mo30476f(StoryEditActivity.this, i, i2);
        }

        /* renamed from: cW */
        public void mo30469cW(int i, int i2) {
            String access$000 = StoryEditActivity.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("SlideModule onItemPreview ###Module:");
            sb.append(i);
            sb.append(",itemIndex:");
            sb.append(i2);
            LogUtils.m14223i(access$000, sb.toString());
            StoryEditActivity.this.dih = i;
            StoryEditActivity.this.m19972po(i);
        }
    };
    private TODOParamModel todoParamModel;

    private void arc() {
        if (this.dgb == null) {
            int dpFloatToPixel = C4583d.dpFloatToPixel(this, 100.0f);
            int dpFloatToPixel2 = C4583d.dpFloatToPixel(this, 100.0f);
            this.dgb = ImageWorkerFactory.CreateImageWorker(this, dpFloatToPixel, dpFloatToPixel2, "gallery_thumbnails", Utils.calculateBitmapCacheSize(20, dpFloatToPixel, dpFloatToPixel2), 100);
            this.dgb.setGlobalImageWorker(null);
            this.dgb.setImageFadeIn(2);
            this.dgb.setErrorImage(R.drawable.xiaoying_com_gallery_failed_icon);
            this.dgb.setLoadMode(65538);
        }
    }

    private void ase() {
        for (int i = 0; i < this.dii.size(); i++) {
            SlideMaterialModule slideMaterialModule = new SlideMaterialModule(this);
            slideMaterialModule.mo30508a((SlideModuleData) this.dii.get(i), i);
            slideMaterialModule.setExternalCallback(this.dik);
            if (i == this.dii.size() - 1) {
                slideMaterialModule.asp();
            }
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.topMargin = C4583d.m11670O(this, 15);
            this.dic.addView(slideMaterialModule, layoutParams);
            this.dij.put(Integer.valueOf(i), new LinkedHashMap());
        }
        try {
            String j = C8460a.m24498j(new JSONObject(this.todoParamModel.mJsonParam));
            if (!TextUtils.isEmpty(j)) {
                this.die.setText(j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void asf() {
        if (asj().size() <= 0) {
            C6781a.asc().mo30315fv(getApplicationContext());
            asi();
        } else if (this.dig != null) {
            this.dig.mo30478fx(this);
        }
    }

    private ArrayList<TrimedClipItemDataModel> asj() {
        ArrayList<TrimedClipItemDataModel> arrayList = new ArrayList<>();
        if (this.dij.size() > 0) {
            for (Map map : this.dij.values()) {
                if (map.size() > 0) {
                    arrayList.addAll(map.values());
                }
            }
        }
        return arrayList;
    }

    private void ask() {
        this.did.setSelected(asj().size() == asl());
    }

    private void initUI() {
        this.dic = (LinearLayout) findViewById(R.id.module_container);
        this.did = (TextView) findViewById(R.id.btn_preview);
        this.dif = (ImageButton) findViewById(R.id.btn_back);
        this.die = (TextView) findViewById(R.id.tv_title);
        this.dif.setOnClickListener(this);
        this.did.setOnClickListener(this);
    }

    /* renamed from: j */
    private void m19971j(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (trimedClipItemDataModel != null) {
            Bitmap Y = !trimedClipItemDataModel.isImage.booleanValue() ? C8564s.aJi().mo34802Y(trimedClipItemDataModel.mThumbKey) : null;
            if (Y == null) {
                String str = trimedClipItemDataModel.mRawFilePath;
                if (!TextUtils.isEmpty(trimedClipItemDataModel.mExportPath)) {
                    str = trimedClipItemDataModel.mExportPath;
                }
                Y = this.dgb.syncLoadImage(str, null);
            }
            if (Y != null) {
                trimedClipItemDataModel.mThumbnail = Y;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: po */
    public void m19972po(int i) {
        int i2;
        ArrayList arrayList = new ArrayList(((Map) this.dij.get(Integer.valueOf(i))).values());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((TrimedClipItemDataModel) it.next()).mThumbnail = null;
        }
        int materialNum = (this.dii.size() <= 0 || i < 0 || i >= this.dii.size()) ? 1 : ((SlideModuleData) this.dii.get(i)).getMaterialNum();
        if (this.todoParamModel != null) {
            try {
                i2 = C8460a.m24497i(new JSONObject(this.todoParamModel.mJsonParam));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            GalleryRouter.getInstance().launchSlideshowPicker(this, arrayList, false, materialNum, i2);
        }
        i2 = 0;
        GalleryRouter.getInstance().launchSlideshowPicker(this, arrayList, false, materialNum, i2);
    }

    public String aqP() {
        if (this.todoParamModel != null) {
            try {
                return C8460a.m24501m(new JSONObject(this.todoParamModel.mJsonParam));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Long asg() {
        if (this.todoParamModel != null) {
            try {
                return C8460a.m24499k(new JSONObject(this.todoParamModel.mJsonParam));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void ash() {
        SlideshowRouter.launchSlideshowPreview(this, true);
        asi();
    }

    public void asi() {
        finish();
    }

    public int asl() {
        int i = 0;
        if (this.dii.size() > 0) {
            for (SlideModuleData materialNum : this.dii) {
                i += materialNum.getMaterialNum();
            }
        }
        return i;
    }

    /* renamed from: cT */
    public void mo30465cT(int i, int i2) {
        View childAt = this.dic.getChildAt(i);
        if (childAt != null && (childAt instanceof SlideMaterialModule)) {
            SlideMaterialView ps = ((SlideMaterialModule) childAt).mo30511ps(i2);
            if (ps != null) {
                ps.setMaterialData(null);
            }
        }
        this.dih = i;
        ((Map) this.dij.get(Integer.valueOf(i))).remove(Integer.valueOf(i2));
        ask();
        C6740c.m19586ft(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 36865) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY);
                if (parcelableArrayList != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (parcelableArrayList.size() > 0) {
                        for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                            m19971j((TrimedClipItemDataModel) parcelableArrayList.get(i3));
                            linkedHashMap.put(Integer.valueOf(i3), parcelableArrayList.get(i3));
                        }
                    }
                    this.dij.put(Integer.valueOf(this.dih), linkedHashMap);
                    View childAt = this.dic.getChildAt(this.dih);
                    if (childAt instanceof SlideMaterialModule) {
                        SlideMaterialModule slideMaterialModule = (SlideMaterialModule) childAt;
                        for (int i4 = 0; i4 < slideMaterialModule.getMaterialItemCount(); i4++) {
                            SlideMaterialView ps = slideMaterialModule.mo30511ps(i4);
                            if (ps != null) {
                                ps.setMaterialData((TrimedClipItemDataModel) linkedHashMap.get(Integer.valueOf(i4)));
                            }
                        }
                    }
                    ask();
                }
            }
        }
    }

    public void onBackPressed() {
        asf();
    }

    public void onClick(View view) {
        if (view == this.dif) {
            C2564c.m7327dA(this.dif);
            asf();
        } else if (view == this.did) {
            C2564c.m7330dy(this.did);
            if (asj().size() < asl()) {
                this.dig.mo30477fw(this);
                return;
            }
            C6740c.m19582a(getApplicationContext(), this.dii.size(), this.dij);
            Long asg = asg();
            if (asg != null) {
                C6740c.m19583bP(getApplicationContext(), C8450a.m24469bn(asg.longValue()));
            }
            this.dig.mo30480m(asj());
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(CommonWebPageParams.ACTION_FINISH_WEB_ACTIVITY));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_story_edit_layout);
        this.todoParamModel = (TODOParamModel) getIntent().getParcelableExtra(CommonParams.INTENT_KEY_TODOPARAM_MODEL);
        Long valueOf = Long.valueOf(0);
        try {
            if (this.todoParamModel != null) {
                JSONObject jSONObject = new JSONObject(this.todoParamModel.mJsonParam);
                this.dii = C8460a.m24496h(jSONObject);
                Long k = C8460a.m24499k(jSONObject);
                try {
                    C6740c.m19584bQ(getApplicationContext(), C8460a.m24498j(jSONObject));
                    valueOf = k;
                } catch (JSONException e) {
                    e = e;
                    valueOf = k;
                    e.printStackTrace();
                    initUI();
                    this.dig = new C6852c();
                    this.dig.attachView((C6850a) this);
                    this.dig.mo30479h(this, valueOf.longValue());
                    ase();
                    arc();
                }
            } else {
                finish();
            }
        } catch (JSONException e2) {
            e = e2;
        }
        initUI();
        this.dig = new C6852c();
        this.dig.attachView((C6850a) this);
        this.dig.mo30479h(this, valueOf.longValue());
        ase();
        arc();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.dgb != null) {
            this.dgb.clearMemoryCache(true);
            ImageWorkerFactory.DestroyImageWorker(this.dgb);
            this.dgb = null;
        }
        if (this.dig != null) {
            this.dig.release();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.bTs = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.bTs = false;
    }
}
