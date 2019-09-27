package com.introvd.template.explorer.music.item;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.crash.C5523b;
import com.introvd.template.explorer.music.C7255a;
import com.introvd.template.explorer.music.download.DownloadSubFragment;
import com.introvd.template.explorer.music.local.LocalSubFragment;
import com.introvd.template.explorer.music.online.OnlineSubFragment;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p304b.C7265d;
import com.introvd.template.explorer.music.p305c.C7272a;
import com.introvd.template.explorer.music.p306d.C7273a;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.plugin.downloader.C8251a;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.vivaexplorermodule.R;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.explorer.music.item.d */
public class C7302d extends BaseItem<DBTemplateAudioInfo> {
    /* access modifiers changed from: private */
    public C8682a dAS;
    public int dBA = 1;
    /* access modifiers changed from: private */
    public int dBB;
    /* access modifiers changed from: private */
    public boolean dBC;
    /* access modifiers changed from: private */
    public boolean dBD;
    private DynamicLoadingImageView dBE;
    private TextView dBF;
    private RelativeLayout dBG;
    /* access modifiers changed from: private */
    public ProgressWheel dBH;
    /* access modifiers changed from: private */
    public ImageView dBI;
    /* access modifiers changed from: private */
    public TextView dBJ;
    private ImageView dBK;
    /* access modifiers changed from: private */
    public ImageView dBL;
    private View dBM;
    /* access modifiers changed from: private */
    public C7308f dBN;
    private C1495b dBO;
    /* access modifiers changed from: private */
    public Fragment fragment;
    public boolean isDownloading;

    public C7302d(Fragment fragment2, DBTemplateAudioInfo dBTemplateAudioInfo) {
        super(fragment2.getActivity(), dBTemplateAudioInfo);
        boolean z = true;
        this.fragment = fragment2;
        if (dBTemplateAudioInfo.musicType == 0) {
            this.dBN = new C7308f(this);
        }
        this.dAS = C8688b.aKs().aKt();
        if (fragment2 instanceof OnlineSubFragment) {
            this.dBB = 1;
        } else if (fragment2 instanceof DownloadSubFragment) {
            if (((DownloadSubFragment) fragment2).chW != 1) {
                z = false;
            }
            this.dBC = z;
            this.dBB = 2;
        } else if (fragment2 instanceof LocalSubFragment) {
            this.dBB = 3;
        }
    }

    /* renamed from: a */
    private C1517e<C8312a> m21537a(final ProgressWheel progressWheel, final View view) {
        return new C1517e<C8312a>() {
            /* renamed from: a */
            public void accept(C8312a aVar) {
                if (String.valueOf(progressWheel.getTag()).equals(aVar.getUrl())) {
                    switch (aVar.getFlag()) {
                        case 9990:
                            C7302d.this.axA();
                            break;
                        case 9991:
                            C7302d.this.isDownloading = true;
                            view.setVisibility(8);
                            progressWheel.setVisibility(0);
                            progressWheel.setProgress(0);
                            break;
                        case 9992:
                            view.setVisibility(8);
                            progressWheel.setVisibility(0);
                            progressWheel.setProgress((int) aVar.aGe().aGl());
                            StringBuilder sb = new StringBuilder();
                            sb.append("====downloading ");
                            sb.append(aVar.getUrl());
                            LogUtilsV2.m14227d(sb.toString());
                            break;
                        case 9993:
                            break;
                        case 9994:
                            C7302d.this.axA();
                            C7302d.this.isDownloading = false;
                            progressWheel.setVisibility(8);
                            view.setVisibility(8);
                            DBTemplateAudioInfo dBTemplateAudioInfo = (DBTemplateAudioInfo) C7302d.this.getItemData();
                            if (dBTemplateAudioInfo != null) {
                                C7256a.m21411c(dBTemplateAudioInfo.musicType, C7302d.this.fragment.getActivity(), dBTemplateAudioInfo.getName(), dBTemplateAudioInfo.getCategoryName(), "success");
                                C7256a.m21408b(C7302d.this.fragment.getActivity(), dBTemplateAudioInfo.musicType, dBTemplateAudioInfo.getName(), dBTemplateAudioInfo.getCategoryName());
                                dBTemplateAudioInfo.isDownloaded = true;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(aVar.getPath());
                                sb2.append(aVar.getName());
                                dBTemplateAudioInfo.musicFilePath = sb2.toString();
                                long currentTimeMillis = System.currentTimeMillis();
                                dBTemplateAudioInfo.order = currentTimeMillis;
                                dBTemplateAudioInfo.createTime = currentTimeMillis;
                            }
                            if (C7302d.this.dAS != null) {
                                C7302d.this.dAS.mo35006a(dBTemplateAudioInfo);
                                C7272a.m21453b(((DBTemplateAudioInfo) C7302d.this.getItemData()).categoryId, ((DBTemplateAudioInfo) C7302d.this.getItemData()).index, 1);
                            }
                            if (C7302d.this.dBA == 3) {
                                C7302d.this.mo31919qQ(3);
                                break;
                            }
                            break;
                        case 9995:
                            DBTemplateAudioInfo dBTemplateAudioInfo2 = (DBTemplateAudioInfo) C7302d.this.getItemData();
                            if (dBTemplateAudioInfo2 != null) {
                                C7256a.m21411c(dBTemplateAudioInfo2.musicType, C7302d.this.fragment.getActivity(), dBTemplateAudioInfo2.getName(), dBTemplateAudioInfo2.getCategoryName(), ParametersKeys.FAILED);
                                C7256a.m21412c(C7302d.this.fragment.getActivity(), dBTemplateAudioInfo2.musicType, dBTemplateAudioInfo2.getName(), dBTemplateAudioInfo2.getCategoryName());
                                break;
                            }
                            break;
                    }
                    C7302d.this.axA();
                    C7302d.this.isDownloading = false;
                    progressWheel.setProgress(0);
                    progressWheel.setVisibility(8);
                    view.setVisibility(0);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21539a(String str, ProgressWheel progressWheel, View view) {
        if (this.fragment instanceof OnlineSubFragment) {
            OnlineSubFragment onlineSubFragment = (OnlineSubFragment) this.fragment;
            C1495b bVar = (C1495b) onlineSubFragment.cLq.get(str);
            if (bVar != null && !bVar.aAy()) {
                bVar.dispose();
            }
            try {
                if (getActivity() != null) {
                    this.dBO = C8251a.m23820gI(getActivity().getApplicationContext()).mo33405mE(str).mo10168g(m21537a(progressWheel, view));
                }
                onlineSubFragment.cLq.put(str, this.dBO);
            } catch (NoSuchMethodError e) {
                C5523b.logException(e);
            }
        }
    }

    /* renamed from: ar */
    private String m21541ar(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String upperCase = str.toUpperCase();
        String upperCase2 = str2.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int indexOf = upperCase.indexOf(upperCase2);
        if (indexOf == -1) {
            return "";
        }
        while (indexOf != -1) {
            try {
                sb.append(str.substring(i, indexOf));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<font color =#FF5E13>");
                sb2.append(str.substring(indexOf, str2.length() + indexOf));
                sb2.append("</font>");
                sb.append(sb2.toString());
                i = str2.length() + indexOf;
                indexOf = upperCase.indexOf(upperCase2, indexOf + str2.length());
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        sb.append(str.substring(i, str.length()));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void axA() {
        if (this.dBO != null && !this.dBO.aAy()) {
            this.dBO.dispose();
        }
    }

    private boolean axB() {
        return this.dBG != null && this.dBG.getTag().equals(getItemData());
    }

    private void axt() {
        if (awP() != 2 || axy() == 3 || axy() == 4) {
            this.dBL.setVisibility(8);
            this.dBK.setVisibility(8);
            return;
        }
        this.dBI.setVisibility(8);
        if (this.dBC) {
            this.dBL.setVisibility(0);
            this.dBK.setVisibility(8);
            if (axz()) {
                this.dBL.setImageResource(R.drawable.xiaoying_music_item_check_selected);
            } else {
                this.dBL.setImageResource(R.drawable.xiaoying_music_item_check_normal);
            }
        } else {
            this.dBL.setVisibility(8);
            this.dBK.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void axu() {
        if (this.dBB != 3 && !this.isDownloading) {
            DBTemplateAudioInfo dBTemplateAudioInfo = (DBTemplateAudioInfo) getItemData();
            if (dBTemplateAudioInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(C7255a.dAf);
                sb.append(C7213f.m21302jv(dBTemplateAudioInfo.audioUrl));
                String sb2 = sb.toString();
                if (C7272a.m21454jj(sb2) && !isDownloaded()) {
                    dBTemplateAudioInfo.isDownloaded = true;
                    dBTemplateAudioInfo.musicFilePath = sb2;
                    this.dAS.mo35006a((DBTemplateAudioInfo) getItemData());
                    C7272a.m21453b(((DBTemplateAudioInfo) getItemData()).categoryId, ((DBTemplateAudioInfo) getItemData()).index, 1);
                } else if (!C7272a.m21454jj(dBTemplateAudioInfo.musicFilePath) && isDownloaded()) {
                    this.dAS.mo35009pb(dBTemplateAudioInfo.index);
                }
                axx();
            }
        }
    }

    private void axx() {
        if (getItemData() != null) {
            if (((DBTemplateAudioInfo) getItemData()).isDownloaded) {
                this.dBH.setVisibility(8);
                this.dBI.setVisibility(8);
            } else {
                this.dBH.setProgress(0);
                this.dBH.setVisibility(8);
                this.dBI.setVisibility(0);
            }
        }
    }

    public int awP() {
        return this.dBB;
    }

    public void axv() {
        switch (this.dBA) {
            case 2:
                mo31917qO(1);
                return;
            case 3:
                mo31917qO(4);
                return;
            case 4:
                mo31917qO(3);
                return;
            default:
                if (isDownloaded()) {
                    mo31917qO(3);
                    return;
                } else {
                    mo31917qO(2);
                    return;
                }
        }
    }

    public void axw() {
        this.dBA = 1;
        if (axB()) {
            mo31919qQ(this.dBA);
            axt();
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin closeViewAndStopPlayMusic close name = ");
            sb.append(((DBTemplateAudioInfo) getItemData()).getName());
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    public int axy() {
        return this.dBA;
    }

    public boolean axz() {
        return this.dBD;
    }

    /* renamed from: b */
    public void mo31913b(DynamicLoadingImageView dynamicLoadingImageView) {
        dynamicLoadingImageView.setImage(R.drawable.xiaoying_music_item_loading);
        dynamicLoadingImageView.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.xiaoying_anim_rotate_loading));
        dynamicLoadingImageView.setVisibility(0);
    }

    public int getLayoutId() {
        return R.layout.list_item_music;
    }

    /* renamed from: ie */
    public void mo31914ie(boolean z) {
        this.dBC = z;
        if (this.dBC) {
            axw();
        }
        int i = 0;
        this.dBD = false;
        if (this.dBG != null && this.dBG.getTag().equals(getItemData())) {
            this.dBK.setVisibility(z ? 8 : 0);
            ImageView imageView = this.dBL;
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
            this.dBL.setImageResource(R.drawable.xiaoying_music_item_check_normal);
        }
    }

    public boolean isDownloaded() {
        return getItemData() != null && ((DBTemplateAudioInfo) getItemData()).isDownloaded && !this.isDownloading;
    }

    public void onBindView(BaseHolder baseHolder, int i) {
        final DBTemplateAudioInfo dBTemplateAudioInfo = (DBTemplateAudioInfo) getItemData();
        if (dBTemplateAudioInfo != null) {
            this.dBG = (RelativeLayout) baseHolder.findViewById(R.id.music_item_above_layout);
            if (this.dBG != null) {
                this.dBG.setTag(dBTemplateAudioInfo);
                TextView textView = (TextView) baseHolder.findViewById(R.id.music_item_name);
                TextView textView2 = (TextView) baseHolder.findViewById(R.id.music_item_author);
                this.dBF = (TextView) baseHolder.findViewById(R.id.music_item_time);
                this.dBE = (DynamicLoadingImageView) baseHolder.findViewById(R.id.music_item_waveform);
                this.dBH = (ProgressWheel) baseHolder.findViewById(R.id.music_item_progress);
                this.dBI = (ImageView) baseHolder.findViewById(R.id.music_item_download);
                this.dBL = (ImageView) baseHolder.findViewById(R.id.music_item_check_box);
                this.dBK = (ImageView) baseHolder.findViewById(R.id.music_item_move);
                this.dBM = baseHolder.findViewById(R.id.list_item_music_divider);
                ViewStub viewStub = (ViewStub) baseHolder.findViewById(R.id.music_item_player);
                View findViewById = baseHolder.findViewById(R.id.music_item_play_layout);
                if (this.dBN != null) {
                    this.dBN.mo31929a(viewStub, findViewById);
                }
                this.dBJ = (TextView) baseHolder.findViewById(R.id.music_item_use);
                if (TextUtils.isEmpty(C7273a.dCz)) {
                    textView.setText(dBTemplateAudioInfo.getName());
                } else {
                    textView.setText(Html.fromHtml(m21541ar(dBTemplateAudioInfo.getName(), C7273a.dCz)));
                }
                if (TextUtils.isEmpty(dBTemplateAudioInfo.getAuthor())) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(dBTemplateAudioInfo.getAuthor());
                }
                if (!TextUtils.isEmpty(dBTemplateAudioInfo.timeStr)) {
                    this.dBF.setText(dBTemplateAudioInfo.timeStr);
                } else {
                    dBTemplateAudioInfo.timeStr = C4584e.m11685ij(dBTemplateAudioInfo.duration / 1000);
                    this.dBF.setText(dBTemplateAudioInfo.timeStr);
                }
                axt();
                mo31919qQ(this.dBA);
                axx();
                this.dBH.setTag(dBTemplateAudioInfo.audioUrl);
                this.dBJ.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (!C4580b.m11645bM(1000, C7302d.this.dBJ.hashCode())) {
                            if (C7302d.this.dBN == null || C7302d.this.dBN.dBX - C7302d.this.dBN.dBW >= 500) {
                                DBTemplateAudioInfo dBTemplateAudioInfo = (DBTemplateAudioInfo) C7302d.this.getItemData();
                                MusicDataItem musicDataItem = new MusicDataItem();
                                musicDataItem.title = dBTemplateAudioInfo.getName();
                                musicDataItem.filePath = dBTemplateAudioInfo.musicFilePath;
                                if (((DBTemplateAudioInfo) C7302d.this.getItemData()).musicType == 1) {
                                    musicDataItem.startTimeStamp = 0;
                                    musicDataItem.currentTimeStamp = 0;
                                    musicDataItem.stopTimeStamp = dBTemplateAudioInfo.getDuration();
                                } else {
                                    musicDataItem.startTimeStamp = C7302d.this.dBN.dBW;
                                    musicDataItem.currentTimeStamp = C7302d.this.dBN.dBW;
                                    musicDataItem.stopTimeStamp = C7302d.this.dBN.dBX;
                                    C7256a.m21406a(C7302d.this.getContext(), C7302d.this.dBB, dBTemplateAudioInfo.name, dBTemplateAudioInfo.categoryName);
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("Jamin click add = ");
                                sb.append(new Gson().toJson((Object) musicDataItem));
                                LogUtilsV2.m14227d(sb.toString());
                                C7273a.dCz = "";
                                C7273a.m21457av(C7302d.this.getActivity());
                                C10021c.aZH().mo38492aA(new C7265d(musicDataItem));
                                return;
                            }
                            ToastUtils.show((Context) C7302d.this.getActivity(), R.string.xiaoying_str_ve_msg_music_len_invalid, 0);
                        }
                    }
                });
                this.dBI.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && C4600l.m11739k(C7302d.this.fragment.getActivity(), true)) {
                            C7302d.this.axu();
                            if (!C7302d.this.isDownloaded()) {
                                C7302d.this.dBI.setVisibility(8);
                                String str = C7255a.dAf;
                                String jv = C7213f.m21302jv(dBTemplateAudioInfo.audioUrl);
                                C7256a.m21407b(dBTemplateAudioInfo.musicType, C7302d.this.fragment.getActivity(), dBTemplateAudioInfo.getName(), dBTemplateAudioInfo.getCategoryName());
                                StringBuilder sb = new StringBuilder();
                                sb.append("====start_download , ");
                                sb.append(dBTemplateAudioInfo.audioUrl);
                                sb.append(", dir = ");
                                sb.append(str);
                                sb.append(", newFilePath = ");
                                sb.append(jv);
                                LogUtilsV2.m14227d(sb.toString());
                                C8251a.m23820gI(C7302d.this.getActivity().getApplicationContext()).mo33410tl(1).mo33409t(dBTemplateAudioInfo.audioUrl, jv, str).aTR();
                                C7302d.this.m21539a(dBTemplateAudioInfo.audioUrl, C7302d.this.dBH, C7302d.this.dBI);
                            }
                        }
                    }
                });
                if (!isDownloaded()) {
                    m21539a(dBTemplateAudioInfo.audioUrl, this.dBH, this.dBI);
                }
                this.dBG.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (!C7302d.this.isDownloaded() && !C4600l.m11739k(C7302d.this.fragment.getActivity(), true)) {
                            return;
                        }
                        if (C7302d.this.awP() == 2 && C7302d.this.dBC) {
                            C7302d.this.dBD = true ^ C7302d.this.dBD;
                            C7302d.this.dBL.setImageResource(C7302d.this.dBD ? R.drawable.xiaoying_music_item_check_selected : R.drawable.xiaoying_music_item_check_normal);
                        } else if (!C4580b.m11664ig(300)) {
                            if (!TextUtils.isEmpty(C7273a.dCz)) {
                                C7256a.m21418fX(VivaBaseApplication.m8749FZ());
                            }
                            C7302d.this.axu();
                            C7302d.this.axv();
                        }
                    }
                });
            }
        }
    }

    public void pause() {
        mo31919qQ(4);
    }

    /* renamed from: qO */
    public void mo31917qO(int i) {
        this.dBA = i;
        switch (i) {
            case 2:
            case 3:
                if (getItemData() != null) {
                    if (this.dBN != null) {
                        C7272a.m21451a(awP(), (DBTemplateAudioInfo) getItemData(), 1, this.dBN.dBW, this.dBN.dBX);
                        break;
                    } else {
                        C7272a.m21451a(awP(), (DBTemplateAudioInfo) getItemData(), 1, 0, ((DBTemplateAudioInfo) getItemData()).duration);
                        break;
                    }
                } else {
                    return;
                }
            case 4:
                C7272a.m21450a(awP(), (DBTemplateAudioInfo) getItemData(), 2);
                break;
            default:
                if (!isDownloaded()) {
                    C7272a.m21450a(awP(), (DBTemplateAudioInfo) getItemData(), 3);
                    break;
                } else {
                    C7272a.m21450a(awP(), (DBTemplateAudioInfo) getItemData(), 2);
                    break;
                }
        }
        mo31919qQ(this.dBA);
        axt();
    }

    /* renamed from: qP */
    public void mo31918qP(int i) {
        switch (i) {
            case 2:
            case 3:
                this.dBF.setVisibility(4);
                if (2 == i) {
                    mo31913b(this.dBE);
                } else {
                    this.dBE.setVisibility(0);
                    this.dBE.setImage(R.drawable.music_item_wave);
                    this.dBE.clearAnimation();
                }
                if (isDownloaded()) {
                    this.dBM.setVisibility(8);
                    this.dBJ.setVisibility(0);
                } else {
                    this.dBJ.setVisibility(8);
                }
                this.dBK.setVisibility(8);
                this.dBL.setVisibility(8);
                return;
            case 4:
                this.dBF.setVisibility(0);
                this.dBE.setVisibility(8);
                if (isDownloaded()) {
                    this.dBJ.setVisibility(0);
                    return;
                } else {
                    this.dBJ.setVisibility(8);
                    return;
                }
            default:
                this.dBF.setVisibility(0);
                if (this.dBE.getVisibility() != 8) {
                    this.dBE.setVisibility(8);
                }
                this.dBM.setVisibility(0);
                this.dBJ.setVisibility(8);
                return;
        }
    }

    /* renamed from: qQ */
    public void mo31919qQ(int i) {
        this.dBA = i;
        mo31918qP(i);
        if (this.dBN != null) {
            this.dBN.mo31931qT(i);
        }
    }

    /* renamed from: qR */
    public void mo31920qR(int i) {
        if (this.dBN != null && i > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin updateProgress = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            this.dBN.updateProgress(i);
        }
    }

    /* renamed from: qS */
    public void mo31921qS(int i) {
        this.dBA = 3;
        if (this.dBN != null && i >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin  duration = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            this.dBN.mo31930qS(i);
        }
        if (this.dBE != null && axB()) {
            this.dBE.setImage(R.drawable.music_item_wave);
            this.dBE.setVisibility(0);
            this.dBE.clearAnimation();
        }
    }
}
