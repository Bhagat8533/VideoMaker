package com.introvd.template.editor.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.p031a.C1072a;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.common.title.C5866b;
import com.introvd.template.editor.common.title.EditorTitle;
import com.introvd.template.editor.slideshow.adapter.C6741a;
import com.introvd.template.editor.slideshow.adapter.C6742b;
import com.introvd.template.editor.slideshow.model.SlideModel;
import com.introvd.template.editor.slideshow.model.SlideNodeModel;
import com.introvd.template.editor.slideshow.p278a.C6739b;
import com.introvd.template.editor.slideshow.p279b.C6753a;
import com.introvd.template.editor.slideshow.p279b.C6754b;
import com.introvd.template.editor.slideshow.p279b.C6755c;
import com.introvd.template.editor.slideshow.p280c.C6756a;
import com.introvd.template.editor.slideshow.p280c.C6757b;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.p415a.C8986a;
import com.introvd.template.p414ui.view.p415a.C8986a.C8988b;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.xyui.C9136a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import xiaoying.engine.base.QTextAnimationInfo;

@C1942a(mo10417rZ = "/Slide/Editor")
public class SlideEditorActivity extends EventActivity implements OnClickListener, C6756a {
    /* access modifiers changed from: private */
    public C9136a bML;
    private SeekBar cAF;
    private RelativeLayout cWk;
    private ImageButton cYA;
    private boolean cyM = true;
    private RelativeLayout dfa;
    private RecyclerView dfb;
    private TextView dfc;
    private TextView dfd;
    private TextView dfe;
    private SlideSubTextView dff;
    private EditorTitle dfg;
    /* access modifiers changed from: private */
    public C6742b dfh;
    /* access modifiers changed from: private */
    public C6757b dfi;
    private ArrayList<TrimedClipItemDataModel> dfj;
    private TODOParamModel todoParamModel;

    /* renamed from: Oj */
    private void m19526Oj() {
        this.dfg = (EditorTitle) findViewById(R.id.slide_title_view);
        this.dff = (SlideSubTextView) findViewById(R.id.text_edit_view);
        this.dfa = (RelativeLayout) findViewById(R.id.surface_layout);
        this.dfe = (TextView) findViewById(R.id.tv_drag_tip);
        aqL();
        aom();
        this.dfg.setTitleListener(new C5866b() {
            public void ahD() {
                if (SlideEditorActivity.this.dfi != null) {
                    if (!TextUtils.isEmpty(SlideEditorActivity.this.dfi.mo30263BB())) {
                        C6739b.m19581j(SlideEditorActivity.this.getApplicationContext(), C8450a.m24469bn(SlideEditorActivity.this.dfi.are()), SlideEditorActivity.this.dfi.mo30263BB(), "剪辑页按钮");
                    }
                    SlideEditorActivity.this.dfi.arp();
                }
            }

            public void ahE() {
                if (SlideEditorActivity.this.dfi != null) {
                    SlideEditorActivity.this.dfi.aro();
                }
            }

            public void onBack() {
                SlideEditorActivity.this.dfi.arn();
            }
        });
        this.dfa.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SlideEditorActivity.this.dfi != null) {
                    SlideEditorActivity.this.dfi.pause();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19529a(SlideNodeModel slideNodeModel) {
        if (this.dff != null) {
            this.dff.mo30220by(Arrays.asList(slideNodeModel.getTextAnimInfoArray()));
            this.dff.setTextEditCallback(new C6755c() {
                /* renamed from: a */
                public void mo30218a(QTextAnimationInfo qTextAnimationInfo, boolean z) {
                    if (SlideEditorActivity.this.dfi != null) {
                        SlideEditorActivity.this.dfi.mo30266a(qTextAnimationInfo);
                        SlideEditorActivity.this.dfi.setAutoPlayWhenReady(z);
                    }
                }

                /* renamed from: ab */
                public void mo30219ab(int i, boolean z) {
                    if (SlideEditorActivity.this.dfi != null) {
                        SlideEditorActivity.this.dfi.mo30285pd(i);
                        if (z) {
                            SlideEditorActivity.this.dfi.play();
                        }
                    }
                }
            });
            if (!this.dff.isShowing()) {
                this.dff.show();
            }
        }
    }

    private void abu() {
        MSize surfaceSize = this.dfi.getSurfaceSize();
        if (surfaceSize != null) {
            LayoutParams layoutParams = new LayoutParams(surfaceSize.width, surfaceSize.height);
            layoutParams.addRule(13);
            this.dfa.setLayoutParams(layoutParams);
            this.dfa.invalidate();
        }
    }

    private void aom() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.player_seek_view_stub);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            this.cWk = (RelativeLayout) inflate.findViewById(R.id.relativelayout_seekbar);
            this.cAF = (SeekBar) inflate.findViewById(R.id.seekbar_simple_edit);
            this.dfc = (TextView) inflate.findViewById(R.id.txtview_cur_time);
            this.dfd = (TextView) inflate.findViewById(R.id.txtview_duration);
            this.cYA = (ImageButton) inflate.findViewById(R.id.seekbar_play);
            this.cYA.setOnClickListener(this);
            this.cWk.bringToFront();
        }
    }

    private void aqL() {
        this.dfb = (RecyclerView) findViewById(R.id.rc_scene);
        this.dfb.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.dfb.mo7733a((C1018h) new C6741a(C4583d.m11671P(10.0f)));
    }

    /* access modifiers changed from: private */
    public void aqM() {
        if (this.bML == null) {
            this.bML = new C9136a(this);
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.dfb.getLayoutManager();
        if (linearLayoutManager != null) {
            this.bML.mo36087f(linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstCompletelyVisibleItemPosition()), 3, C4580b.m11666qi());
            this.bML.mo36086dt(getResources().getString(R.string.xiaoying_str_slide_edit_insert_file_tip));
            this.bML.mo36085dT(0, C4583d.m11671P(36.0f));
        }
    }

    /* renamed from: a */
    public void mo30196a(int i, TrimedClipItemDataModel trimedClipItemDataModel) {
        if (this.dfh != null) {
            this.dfh.mo30247b(i, trimedClipItemDataModel);
        }
        this.dfg.mo28282eU(this.dfi.arl());
    }

    public void abA() {
        finish();
    }

    public ArrayList<TrimedClipItemDataModel> aqN() {
        return this.dfj;
    }

    public long aqO() {
        try {
            return this.todoParamModel != null ? C8460a.m24499k(new JSONObject(this.todoParamModel.mJsonParam)).longValue() : getIntent().getLongExtra(SlideshowRouter.KEY_INTENT_APPLY_THEME_ID, 0);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
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

    public TODOParamModel aqQ() {
        return this.todoParamModel;
    }

    public String aqR() {
        return this.todoParamModel != null ? C8460a.m24503o(this.todoParamModel.getJsonObj()) : "";
    }

    public RelativeLayout aqS() {
        return this.dfa;
    }

    public ArrayList<TrimedClipItemDataModel> aqT() {
        if (this.dfh == null) {
            return null;
        }
        List<SlideNodeModel> aqW = this.dfh.aqW();
        ArrayList<TrimedClipItemDataModel> arrayList = new ArrayList<>();
        for (SlideNodeModel dataModel : aqW) {
            arrayList.add(dataModel.getDataModel());
        }
        return arrayList;
    }

    /* renamed from: bx */
    public void mo30205bx(List<SlideNodeModel> list) {
        if (list != null && list.size() > 0) {
            if (this.dfh == null) {
                this.dfh = new C6742b(this);
                this.dfh.mo30244a((C6754b) new C6753a() {
                    /* renamed from: a */
                    public void mo30215a(int i, SlideModel slideModel) {
                        if (slideModel instanceof SlideNodeModel) {
                            if (SlideEditorActivity.this.bML != null) {
                                SlideEditorActivity.this.bML.aNX();
                            }
                            SlideEditorActivity.this.dfi.mo30286pe(i);
                            SlideNodeModel slideNodeModel = (SlideNodeModel) slideModel;
                            SlideEditorActivity.this.dfi.mo30285pd(slideNodeModel.getPreviewPos());
                            if (slideNodeModel.isFocus()) {
                                ArrayList arrayList = new ArrayList();
                                TrimedClipItemDataModel dataModel = slideNodeModel.getDataModel();
                                if (dataModel != null && !TextUtils.isEmpty(dataModel.mRawFilePath) && !TextUtils.isEmpty(SlideEditorActivity.this.dfi.mo30263BB())) {
                                    SlideEditorActivity.this.dfi;
                                    if (!TextUtils.isEmpty(C6757b.dfU)) {
                                        SlideEditorActivity.this.dfi;
                                        if (C6757b.dfU.equalsIgnoreCase(dataModel.mRawFilePath)) {
                                            C6739b.m19572a(SlideEditorActivity.this.getApplicationContext(), C8450a.m24469bn(SlideEditorActivity.this.dfi.are()), SlideEditorActivity.this.dfi.mo30263BB(), i + 1, SlideEditorActivity.this.dfh.getItemCount());
                                        }
                                    }
                                }
                                if (dataModel != null) {
                                    boolean z = false;
                                    if (!TextUtils.isEmpty(dataModel.mRawFilePath)) {
                                        z = SlideEditorActivity.this.dfi.mo30280iu(dataModel.mRawFilePath);
                                    }
                                    if (z) {
                                        arrayList.add(slideNodeModel.getDataModel());
                                    }
                                }
                                GalleryRouter.getInstance().launchSlideshowPicker(SlideEditorActivity.this, arrayList, SlideEditorActivity.this.dfi.ahI(), 1, slideNodeModel.getDurationLimit());
                            }
                        }
                    }

                    /* renamed from: b */
                    public void mo30216b(int i, SlideModel slideModel) {
                        if (slideModel instanceof SlideNodeModel) {
                            C6739b.m19578fr(SlideEditorActivity.this.getApplicationContext());
                            SlideNodeModel slideNodeModel = (SlideNodeModel) slideModel;
                            SlideEditorActivity.this.m19529a(slideNodeModel);
                            SlideEditorActivity.this.dfi.mo30285pd(slideNodeModel.getPreviewPos());
                        }
                    }
                });
                this.dfb.setAdapter(this.dfh);
                C8986a aVar = new C8986a(this.dfh, false);
                aVar.mo35758a(new C8988b() {
                    /* renamed from: D */
                    public void mo29870D(View view, int i) {
                        SlideEditorActivity.this.dfi.pause();
                        Vibrator vibrator = (Vibrator) view.getContext().getSystemService("vibrator");
                        if (vibrator != null) {
                            vibrator.vibrate(100);
                        }
                    }

                    /* renamed from: cM */
                    public void mo29871cM(int i, int i2) {
                        C6739b.m19571N(SlideEditorActivity.this.getApplicationContext(), i != i2);
                        if (i != i2 && !SlideEditorActivity.this.isFinishing()) {
                            SlideEditorActivity.this.dfi.mo30277cR(i, i2);
                        }
                    }
                });
                new C1072a(aVar).mo8593a(this.dfb);
            }
            this.dfh.mo30248bA(list);
            this.dfb.postDelayed(new Runnable() {
                public void run() {
                    if (!C5842b.ahj()) {
                        SlideEditorActivity.this.aqM();
                        C5842b.m16340eT(true);
                    }
                }
            }, 500);
        }
    }

    /* renamed from: cP */
    public void mo30206cP(int i, int i2) {
        if (this.cAF != null) {
            this.cAF.setMax(i);
            this.cAF.setProgress(i2);
            this.cAF.setOnSeekBarChangeListener(this.dfi.arj());
        }
        if (this.dfd != null && this.dfc != null) {
            this.dfd.setText(C4580b.m11637V((long) i));
            this.dfc.setText(C4580b.m11637V((long) i2));
        }
    }

    /* renamed from: cQ */
    public void mo30207cQ(int i, int i2) {
        if (i == 3) {
            this.cYA.setSelected(true);
        } else {
            this.cYA.setSelected(false);
        }
    }

    /* renamed from: gY */
    public void mo30208gY(boolean z) {
        if (z) {
            this.dfg.mo28282eU(this.dfi.arl());
            C6739b.m19580i(getApplicationContext(), C8450a.m24469bn(this.dfi.are()), aqR(), this.cyM ? "Edit" : "Draft");
            SurfaceView surfaceView = new SurfaceView(this);
            this.dfa.addView(surfaceView, new LayoutParams(-1, -1));
            this.dfi.mo30276b(surfaceView.getHolder());
            abu();
            return;
        }
        this.dfi.aoe();
        C6781a.asc().mo30315fv(getApplicationContext());
        abA();
    }

    public Activity getActivity() {
        return this;
    }

    public int getFocusIndex() {
        return this.dfh.aqX();
    }

    /* renamed from: oZ */
    public void mo30211oZ(int i) {
        if (this.dfh != null) {
            this.dfh.mo30249pa(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 36865) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY);
                if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                    this.dfi.mo30264a(getApplicationContext(), (TrimedClipItemDataModel) parcelableArrayList.get(0));
                }
            }
        }
    }

    public void onBackPressed() {
        if (this.dff.isShowing()) {
            this.dff.hide();
        } else {
            this.dfi.arn();
        }
    }

    public void onClick(View view) {
        if (view != this.cYA) {
            return;
        }
        if (this.cYA.isSelected()) {
            this.dfi.pause();
        } else {
            this.dfi.play();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_slide_editor);
        this.cyM = getIntent().getBooleanExtra(SlideshowRouter.KEY_INTENT_PRJ_NEW_FLAG, true);
        this.todoParamModel = (TODOParamModel) getIntent().getParcelableExtra(CommonParams.INTENT_KEY_TODOPARAM_MODEL);
        this.dfj = getIntent().getParcelableArrayListExtra(SlideshowRouter.KEY_INTENT_SLIDE_FILE_MODEL_LIST);
        boolean booleanExtra = getIntent().getBooleanExtra(SlideshowRouter.KEY_INTENT_AUTO_PLAY, false);
        m19526Oj();
        this.dfi = new C6757b();
        this.dfi.attachView((C6756a) this);
        this.dfi.init(this, this.cyM);
        this.dfi.setAutoPlayWhenReady(booleanExtra);
        if (this.todoParamModel != null) {
            this.dfi.mo30284pc(this.todoParamModel.getPageFromParam());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.dfi.release();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.dfi.onActivityPause();
        if (this.bML != null) {
            this.bML.aNX();
        }
        if (isFinishing()) {
            this.dfi.aoe();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.dfi.onActivityResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!TextUtils.isEmpty(this.dfi.mo30263BB())) {
            C6739b.m19570C(getApplicationContext(), C8450a.m24469bn(this.dfi.are()), this.dfi.mo30263BB());
        }
    }

    public void updateProgress(int i) {
        this.cAF.setProgress(i);
        this.dfc.setText(C4580b.m11637V((long) i));
    }
}
