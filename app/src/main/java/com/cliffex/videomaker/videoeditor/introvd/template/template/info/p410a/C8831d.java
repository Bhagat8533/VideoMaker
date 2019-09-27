package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.p414ui.view.RoundImageView;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.R;
import com.introvd.template.template.p404d.C8645a;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8652c;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8655f;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p408f.C8750d;
import com.introvd.template.template.widget.GroupHeader;
import com.introvd.template.template.widget.TemplateGroupHeader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.d */
public class C8831d extends BaseAdapter {
    /* access modifiers changed from: private */
    public List<C8653d> dataList;
    /* access modifiers changed from: private */
    public int epA = 0;
    private int epB;
    /* access modifiers changed from: private */
    public C8651b epC;
    List<C8653d> epD = new ArrayList();
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler;

    /* renamed from: pX */
    private LayoutInflater f3608pX;

    /* renamed from: com.introvd.template.template.info.a.d$a */
    class C8832a {
        RelativeLayout cJe;
        ImageView dze;
        C8653d emi;
        int epE = 14;
        ImageView epF;
        TextView epG;
        ProgressBar epH;
        Button epI;
        RelativeLayout epJ;
        RelativeLayout epK;
        int length;
        Handler mHandler;
        int width;

        public C8832a(Context context, RelativeLayout relativeLayout) {
            this.width = C8831d.m25930ap(context, this.epE);
            this.length = this.width;
            this.epJ = (RelativeLayout) relativeLayout.findViewById(R.id.template_caption_grid_layout_icon);
            this.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
            mo35345i(this.epJ, this.width, this.width);
            switch (C8831d.this.epA) {
                case 0:
                    this.dze = (RoundImageView) relativeLayout.findViewById(R.id.template_caption_grid_img_icon);
                    this.epI = (Button) relativeLayout.findViewById(R.id.template_caption_grid_btn_update);
                    this.epF = (ImageView) relativeLayout.findViewById(R.id.info_list_item_img_mask);
                    this.epH = (ProgressBar) relativeLayout.findViewById(R.id.progressbar_loading);
                    this.epK = (RelativeLayout) relativeLayout.findViewById(R.id.rl_download_button);
                    int i = (int) (((((float) this.width) * 1.0f) * 13.0f) / 18.0f);
                    mo35345i(this.dze, i, i);
                    mo35345i(this.epK, this.width, -1);
                    break;
                case 1:
                    this.epG = (TextView) relativeLayout.findViewById(R.id.text_delete);
                    this.dze = (RoundImageView) relativeLayout.findViewById(R.id.img_icon);
                    int i2 = (int) (((((float) this.width) * 1.0f) * 13.0f) / 18.0f);
                    mo35345i(this.dze, i2, i2);
                    mo35345i(this.epG, this.width, -1);
                    break;
            }
            if (this.dze != null) {
                ((RoundImageView) this.dze).setCornerRadius(C4583d.dpToPixel(context, 7.0f));
                this.dze.setScaleType(ScaleType.FIT_CENTER);
            }
        }

        public void ajH() {
            if (this.cJe != null) {
                this.cJe.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo35343b(C8653d dVar) {
            this.emi = dVar;
            if (this.emi != null && this.dze != null) {
                ImageLoader.loadImage(C8831d.this.mContext, this.emi.emo, this.dze);
                mo35346pI(this.emi.emo);
            }
        }

        /* renamed from: dw */
        public void mo35344dw() {
            if (this.cJe != null) {
                this.cJe.setVisibility(0);
            }
        }

        /* renamed from: i */
        public final void mo35345i(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.width = i;
            if (i2 != -1) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }

        /* renamed from: pI */
        public void mo35346pI(String str) {
            if (this.epI != null) {
                this.epI.setBackgroundColor(0);
            }
            if (C8831d.this.epA == 1) {
                final File file = new File(str);
                if (this.epG != null) {
                    this.epG.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (file.exists()) {
                                String string = C8831d.this.mContext.getResources().getString(R.string.xiaoying_str_ve_sticker);
                                C8978m.m26349hs(C8831d.this.mContext).mo10315r(C8831d.this.mContext.getResources().getString(R.string.xiaoying_str_template_delete_title, new Object[]{string})).mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_com_ok).mo10281a((C1904j) new C1904j() {
                                    public void onClick(C1890f fVar, C1885b bVar) {
                                        if (C8746a.etx != null) {
                                            int size = C8746a.etx.size();
                                            ArrayList arrayList = new ArrayList(C8746a.etx);
                                            Collections.copy(arrayList, C8746a.etx);
                                            for (int i = 0; i < size; i++) {
                                                if (file.getAbsolutePath().equals(((StoryBoardItemInfo) arrayList.get(i)).mEffectInfo.mPath)) {
                                                    C8746a.etx.remove(i);
                                                }
                                            }
                                            arrayList.clear();
                                        }
                                        file.delete();
                                        AppPreferencesSetting.getInstance().setAppSettingBoolean("giphy_list_change_flag", true);
                                        if (C8831d.this.dataList != null) {
                                            C8831d.this.dataList.remove(C8832a.this.emi);
                                        }
                                        if (C8831d.this.epC != null) {
                                            C8831d.this.epC.mo27626a(C8832a.this.emi);
                                        }
                                        C8831d.this.notifyDataSetChanged();
                                        C8522g.aJA().aJF();
                                    }
                                }).mo10313qu().show();
                            }
                        }
                    });
                }
            } else if (C8831d.this.epA == 0) {
                final File file2 = new File(C8645a.m25199ps(this.emi.emo));
                if (this.epI != null) {
                    if (file2.exists()) {
                        if (this.epI != null) {
                            this.epI.setVisibility(0);
                        }
                        this.epI.setBackgroundResource(R.drawable.editor_selector_giphy_btn_blue_bg);
                        this.epI.setText(R.string.xiaoying_str_template_state_apply);
                        this.epH.setProgress(0);
                        this.epI.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                if (C8832a.this.mHandler != null) {
                                    C8832a.this.mHandler.sendMessage(C8832a.this.mHandler.obtainMessage(36880, file2.getAbsolutePath()));
                                }
                            }
                        });
                    } else {
                        this.epI.setBackgroundResource(R.drawable.v5_xiaoying_template_btn_yellow_selector);
                        this.epI.setText(R.string.xiaoying_str_template_state_download);
                        this.epI.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                if (C4600l.m11739k(C8831d.this.mContext, false)) {
                                    C8832a.this.emi.isDownloading = true;
                                    if (C8832a.this.epH != null) {
                                        C8832a.this.epH.setProgress(0);
                                    }
                                    C8655f.aKE().mo34945a(C8831d.this.mContext, C8832a.this.emi, new C8652c() {
                                        private long epO = 0;

                                        public void auK() {
                                        }

                                        /* renamed from: iV */
                                        public void mo30967iV(String str) {
                                            if (C8746a.etx != null) {
                                                if (C8746a.etx.size() > 0) {
                                                    StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C8746a.etx.get(C8746a.etx.size() - 1);
                                                    if (storyBoardItemInfo.mEffectInfo != null && !storyBoardItemInfo.mEffectInfo.mPath.equals(str)) {
                                                        C8746a.etx.add(C8750d.m25574qy(str));
                                                    }
                                                } else {
                                                    C8746a.etx.add(C8750d.m25574qy(str));
                                                }
                                            }
                                            C8832a.this.emi.isDownloading = false;
                                            AppPreferencesSetting.getInstance().setAppSettingBoolean("giphy_list_change_flag", true);
                                            if (C8832a.this.mHandler != null) {
                                                C8832a.this.mHandler.sendEmptyMessage(36881);
                                            }
                                            long currentTimeMillis = ((System.currentTimeMillis() - this.epO) + 500) / 1000;
                                        }

                                        public void onStart() {
                                            LogUtils.m14223i("gifUrl", C8832a.this.emi.emn);
                                            this.epO = System.currentTimeMillis();
                                        }

                                        /* renamed from: q */
                                        public void mo30969q(int i, String str) {
                                            if (C8832a.this.epH != null) {
                                                C8832a.this.epH.setProgress(i);
                                            }
                                            C8832a.this.epI.setBackgroundColor(0);
                                            Button button = C8832a.this.epI;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(i);
                                            sb.append("%");
                                            button.setText(sb.toString());
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(i);
                                            sb2.append("");
                                            sb2.append(str);
                                            LogUtils.m14223i("process", sb2.toString());
                                        }
                                    }, C8832a.this.mHandler);
                                    return;
                                }
                                ToastUtils.show(C8831d.this.mContext, R.string.xiaoying_str_com_msg_network_inactive, 1);
                            }
                        });
                    }
                }
            }
        }

        public void setHandler(Handler handler) {
            this.mHandler = handler;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.d$b */
    class C8838b {
        TemplateGroupHeader epQ;
        GroupHeader epR;
        RelativeLayout epS;
        C8832a epT;
        C8832a epU;
        C8832a epV;
        RelativeLayout epp;
        RelativeLayout epq;
        LinearLayout epr;
        ImageView epw;
        ImageView epx;

        C8838b() {
        }
    }

    public C8831d(Context context, List<C8653d> list, int i) {
        this.mContext = context;
        this.f3608pX = LayoutInflater.from(context);
        this.dataList = list;
        this.epA = i;
        switch (i) {
            case 0:
                this.epB = R.layout.v5_xiaoying_giphy_list_item;
                return;
            case 1:
                this.epB = R.layout.v4_xiaoying_com_template_mgr_list_item;
                return;
            default:
                return;
        }
    }

    /* renamed from: ap */
    public static int m25930ap(Context context, int i) {
        return (Constants.getScreenSize().width / 3) - C4583d.m11670O(context, i);
    }

    /* renamed from: b */
    public void mo35334b(C8651b bVar) {
        this.epC = bVar;
    }

    public int getCount() {
        int i = 0;
        if (this.dataList == null) {
            return 0;
        }
        int size = this.dataList.size() / 3;
        if (this.dataList.size() % 3 > 0) {
            i = 1;
        }
        return i + size;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8838b bVar;
        List uU = getItem(i);
        if (view == null) {
            view = this.f3608pX.inflate(this.epB, null);
            bVar = new C8838b();
            switch (this.epA) {
                case 0:
                    bVar.epQ = (TemplateGroupHeader) view.findViewById(R.id.clip_title);
                    break;
                case 1:
                    bVar.epR = (GroupHeader) view.findViewById(R.id.clip_title);
                    break;
            }
            bVar.epr = (LinearLayout) view.findViewById(R.id.gridview);
            bVar.epp = (RelativeLayout) view.findViewById(R.id.clip_layout01);
            bVar.epq = (RelativeLayout) view.findViewById(R.id.clip_layout02);
            bVar.epS = (RelativeLayout) view.findViewById(R.id.clip_layout03);
            bVar.epw = (ImageView) view.findViewById(R.id.top_layout);
            bVar.epx = (ImageView) view.findViewById(R.id.bottom_layout);
            bVar.epT = new C8832a(this.mContext, bVar.epp);
            bVar.epU = new C8832a(this.mContext, bVar.epq);
            bVar.epV = new C8832a(this.mContext, bVar.epS);
            if (this.mHandler != null) {
                bVar.epT.setHandler(this.mHandler);
                bVar.epU.setHandler(this.mHandler);
                bVar.epV.setHandler(this.mHandler);
            }
            view.setTag(bVar);
        } else {
            bVar = (C8838b) view.getTag();
        }
        if (bVar == null) {
            return view;
        }
        if (bVar.epQ != null) {
            bVar.epQ.setVisibility(8);
        }
        if (bVar.epR != null) {
            bVar.epR.setVisibility(8);
        }
        if (uU != null) {
            if (uU.size() > 0) {
                bVar.epT.mo35343b((C8653d) uU.get(0));
                bVar.epT.mo35344dw();
                bVar.epU.ajH();
                bVar.epV.ajH();
            }
            if (uU.size() > 1) {
                bVar.epU.mo35343b((C8653d) uU.get(1));
                bVar.epT.mo35344dw();
                bVar.epU.mo35344dw();
                bVar.epV.ajH();
            }
            if (uU.size() > 2) {
                bVar.epV.mo35343b((C8653d) uU.get(2));
                bVar.epT.mo35344dw();
                bVar.epU.mo35344dw();
                bVar.epV.mo35344dw();
            }
        }
        return view;
    }

    public void setDataList(List<C8653d> list) {
        this.dataList = list;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    /* renamed from: uU */
    public List<C8653d> getItem(int i) {
        if (this.dataList != null && i < getCount()) {
            int i2 = i * 3;
            this.epD.clear();
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = i2 + i3;
                if (i4 >= this.dataList.size()) {
                    break;
                }
                this.epD.add((C8653d) this.dataList.get(i4));
            }
        }
        return this.epD;
    }
}
