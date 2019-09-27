package com.introvd.template.gallery.p313c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.GallerySiriBehavior;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.explorer.model.GROUP_MEDIA_TYPE;
import com.introvd.template.explorer.p298c.C7142b;
import com.introvd.template.explorer.p298c.C7142b.C7147a;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.explorer.p298c.C7149c.C7155b;
import com.introvd.template.explorer.p299d.C7157a;
import com.introvd.template.explorer.p299d.C7187d;
import com.introvd.template.gallery.C7444c;
import com.introvd.template.gallery.adapter.C7423b;
import com.introvd.template.gallery.adapter.C7423b.C7426a;
import com.introvd.template.gallery.adapter.C7428c;
import com.introvd.template.gallery.adapter.C7430d;
import com.introvd.template.gallery.model.ImgPreviewDataItem;
import com.introvd.template.gallery.p314d.C7472a;
import com.introvd.template.gallery.view.C7506a;
import com.introvd.template.gallery.view.C7506a.C7507a;
import com.introvd.template.gallery.view.GalleryFooterViewV2;
import com.introvd.template.gallery.view.GalleryFooterViewV2.C7491a;
import com.introvd.template.gallery.view.WrapGridLayoutManager;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4602m;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.router.explorer.ExplorerRouter.FileExplorerParams;
import com.introvd.template.router.user.SnsAuthListener;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.gallery.SnsGalleryInfoListener;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.xygallery.R;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.BannerJSAdapter;
import com.p131c.p132a.C2561a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.player.QPlayer;
import xiaoying.utils.QError;

/* renamed from: com.introvd.template.gallery.c.b */
public class C7447b {
    /* access modifiers changed from: private */
    public Handler bLS;
    /* access modifiers changed from: private */
    public int cSj = 0;
    /* access modifiers changed from: private */
    public RecyclerView dFn;
    /* access modifiers changed from: private */
    public View dFo;
    /* access modifiers changed from: private */
    public int dGg;
    /* access modifiers changed from: private */
    public View dHE;
    /* access modifiers changed from: private */
    public RecyclerView dHI;
    /* access modifiers changed from: private */
    public C7423b dHJ;
    /* access modifiers changed from: private */
    public C7428c dHK;
    private GalleryFooterViewV2 dHL;
    /* access modifiers changed from: private */
    public C7506a dHM;
    /* access modifiers changed from: private */
    public C7149c dHN;
    /* access modifiers changed from: private */
    public C7149c dHO;
    /* access modifiers changed from: private */
    public boolean dHP = true;
    /* access modifiers changed from: private */
    public MediaGroupItem dHQ;
    private MediaGroupItem dHR;
    private MSize dHS;
    private View dHT;
    /* access modifiers changed from: private */
    public boolean dHU;
    /* access modifiers changed from: private */
    public long dHV;
    /* access modifiers changed from: private */
    public C7465a dHW = new C7465a(this);
    /* access modifiers changed from: private */
    public C7444c dHX;
    private long dHY = 0;
    /* access modifiers changed from: private */
    public boolean dqz;
    /* access modifiers changed from: private */
    public C7142b dyR;
    /* access modifiers changed from: private */
    public C7147a dyS = new C7147a() {
        public void awr() {
            if (!C7447b.this.dqz && C7447b.this.dHP) {
                C7447b.this.m22033ij(C7447b.this.mSourceType == 0);
            }
        }
    };
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public int mSourceType = -1;

    /* renamed from: com.introvd.template.gallery.c.b$a */
    private static class C7465a extends Handler {
        private WeakReference<C7447b> dIe;

        public C7465a(C7447b bVar) {
            this.dIe = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C7447b bVar = (C7447b) this.dIe.get();
            if (bVar != null) {
                switch (message.what) {
                    case QError.QERR_DISPLAY_INIT_FAIL /*20482*/:
                        ExtMediaItem de = bVar.dHO.mo31616de(message.arg1, message.arg2);
                        if (de != null) {
                            if (bVar.cSj != 6 && bVar.cSj != 8) {
                                if (bVar.cSj != 9) {
                                    if (bVar.bLS != null) {
                                        Message message2 = new Message();
                                        message2.what = QEffect.PROP_AUDIO_FRAME_FADEOUT;
                                        message2.obj = de;
                                        bVar.bLS.sendMessage(message2);
                                        break;
                                    }
                                } else {
                                    ExplorerRouter.launchVideoExtractActivity(bVar.mActivity, de.path, -1, 1);
                                    bVar.mActivity.finish();
                                    return;
                                }
                            } else {
                                C10021c.aZH().mo38492aA(new C7134a(de.path));
                                bVar.mActivity.finish();
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                    case 20483:
                        bVar.m22026di(message.arg1, message.arg2);
                        break;
                    case QPlayer.PROP_PLAYER_RANGE /*32769*/:
                        if (message.arg1 != 1) {
                            bVar.m22001a(0, null, (MediaGroupItem) message.obj);
                            break;
                        } else {
                            bVar.m22001a(1, (List) message.obj, (MediaGroupItem) null);
                            break;
                        }
                    case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                        if (message.obj instanceof MediaGroupItem) {
                            bVar.m22028e((MediaGroupItem) message.obj);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public C7447b(Activity activity, C7444c cVar, RecyclerView recyclerView, RecyclerView recyclerView2, View view) {
        this.mActivity = activity;
        this.dHX = cVar;
        this.dFn = recyclerView2;
        this.dHI = recyclerView;
        this.dHT = view;
        azf();
        ayl();
        azg();
        C7149c.m21131a((C7155b) new C7155b() {
            public void awF() {
                if (C7447b.this.dHJ != null) {
                    C7447b.this.dHJ.notifyDataSetChanged();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22001a(int i, List<MediaGroupItem> list, MediaGroupItem mediaGroupItem) {
        if (i == 1) {
            if (this.dHJ != null && list != null) {
                this.dFn.setVisibility(8);
                this.dHI.setVisibility(0);
                this.dHJ.mo32069bY(list);
            }
        } else if (mediaGroupItem != null) {
            m22023cb(mediaGroupItem.getMediaItemList());
            this.dHQ = mediaGroupItem;
            this.dHP = false;
            this.dHI.setVisibility(8);
            this.dFn.setVisibility(0);
            m22010a(C7444c.GALLERY_TAB_FACEBOOK);
            StringBuilder sb = new StringBuilder();
            sb.append("data size==");
            sb.append(this.dHQ.mediaItemList.size());
            LogUtils.m14222e("MediaGalleryController", sb.toString());
        }
    }

    /* renamed from: a */
    private void m22002a(final C7149c cVar, final boolean z) {
        C1834l.m5254a((C1839n<T>) new C1839n<C7149c>() {
            /* renamed from: a */
            public void mo10177a(C1838m<C7149c> mVar) throws Exception {
                C7149c cVar = new C7149c();
                cVar.mo31610a(C7447b.this.mActivity.getApplicationContext(), MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, z ? BROWSE_TYPE.VIDEO : BROWSE_TYPE.PHOTO);
                mVar.mo9791K(cVar);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C7149c, C1840o<C7149c>>() {
            /* renamed from: f */
            public C1840o<C7149c> apply(C7149c cVar) throws Exception {
                if (C7447b.this.dHX == C7444c.GALLERY_TAB_SYSTEM) {
                    MediaGroupItem awy = cVar.awy();
                    if (awy == null || awy.mediaItemList.size() == 0) {
                        return C1834l.m5263w(new RuntimeException("media data empty,please retry!"));
                    }
                } else if (C7447b.this.dHX == C7444c.GALLERY_TAB_OTHERS && cVar.getGroupCount() == 0) {
                    return C1834l.m5263w(new RuntimeException("folder data empty,please retry!"));
                }
                if (cVar != null) {
                    cVar.unInit();
                }
                if (z) {
                    GallerySiriBehavior.recordGalleryEnterEdit(C7447b.this.mActivity.getApplicationContext(), C7447b.this.cSj == 2 ? "add_more_clips" : "create_project", C7149c.dzz);
                } else {
                    GallerySiriBehavior.recordGalleryEnterMv(C7447b.this.mActivity.getApplicationContext(), C7447b.this.cSj == 2 ? "add_more_clips" : "create_project", C7149c.dzy);
                }
                return C1834l.m5257ah(cVar);
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C4602m<Object,Object>(10, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<C7149c>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: e */
            public void mo9886K(C7149c cVar) {
                if (!C7447b.this.dqz) {
                    C7447b.this.dHN = cVar;
                    if (C7447b.this.dHX == C7444c.GALLERY_TAB_SYSTEM || C7447b.this.dHX == C7444c.GALLERY_TAB_OTHERS) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - C7447b.this.dHV >= 500) {
                            C7447b.this.m22011a(C7447b.this.dHX, true);
                            C7447b.this.dHV = currentTimeMillis;
                        }
                    }
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                LogUtils.m14222e("MediaGalleryController", "---Data empty!!!");
                C7447b.this.dHK.mo32077d(null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22010a(C7444c cVar) {
        MediaGroupItem mediaGroupItem = new MediaGroupItem();
        switch (cVar) {
            case GALLERY_TAB_OTHERS:
                m22034ik(false);
                mediaGroupItem = this.dHQ;
                this.dHR = null;
                break;
            case GALLERY_TAB_SYSTEM:
                m22034ik(true);
                mediaGroupItem = this.dHR;
                break;
            case GALLERY_TAB_FACEBOOK:
                if (this.mSourceType == 0) {
                    m22034ik(true);
                } else {
                    m22034ik(false);
                }
                mediaGroupItem = this.dHQ;
                this.dHR = null;
                break;
            case GALLERY_TAB_INSTAGRAM:
                m22034ik(true);
                mediaGroupItem = this.dHQ;
                this.dHR = null;
                break;
        }
        m22025d(mediaGroupItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22011a(C7444c cVar, boolean z) {
        switch (cVar) {
            case GALLERY_TAB_OTHERS:
                this.dHI.setVisibility(0);
                this.dFn.setVisibility(8);
                this.dHT.setVisibility(8);
                if (this.dHJ.getItemCount() == 0) {
                    z = true;
                }
                if (z && this.dHN != null && !this.dHI.mo7832lm()) {
                    this.dHJ.mo32070bZ(this.dHN.awC());
                    this.dHJ.mo32067a(this.dHL);
                    return;
                }
                return;
            case GALLERY_TAB_SYSTEM:
                this.dHI.setVisibility(8);
                this.dFn.setVisibility(0);
                if (this.dHR == null || (z && this.dHN != null)) {
                    this.dHQ = this.dHN.awy();
                    this.dHR = this.dHQ;
                    if (this.dHR != null) {
                        this.dHP = false;
                        m22010a(C7444c.GALLERY_TAB_SYSTEM);
                        return;
                    }
                    return;
                }
                return;
            case GALLERY_TAB_FACEBOOK:
                this.dHI.setVisibility(8);
                this.dFn.setVisibility(8);
                this.dHT.setVisibility(8);
                if (SnsAuthServiceProxy.isAuthed(28)) {
                    m22019c(28, this.dHS);
                    return;
                } else {
                    m22013aj(28, true);
                    return;
                }
            case GALLERY_TAB_INSTAGRAM:
                this.dHI.setVisibility(8);
                this.dFn.setVisibility(8);
                this.dHT.setVisibility(8);
                if (SnsAuthServiceProxy.isAuthed(31)) {
                    m22050t(31, null);
                    return;
                } else {
                    m22013aj(31, true);
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: aj */
    private void m22013aj(final int i, boolean z) {
        int i2;
        if (this.dHE != null) {
            this.dHE.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            if (z) {
                this.dHE.setVisibility(0);
            } else {
                this.dHE.setVisibility(8);
            }
            TextView textView = (TextView) this.dHE.findViewById(R.id.layout_login_button);
            ImageView imageView = (ImageView) this.dHE.findViewById(R.id.layout_login_flag);
            TextView textView2 = (TextView) this.dHE.findViewById(R.id.layout_login_title);
            String str = null;
            if (i == 28) {
                str = "Facebook";
                i2 = R.drawable.gallery_icon_facebook;
            } else if (i == 31) {
                str = "Instagram";
                i2 = R.drawable.gallery_icon_instagram;
            } else {
                i2 = 0;
            }
            textView2.setText(this.mActivity.getString(R.string.xiaoying_str_sns_longin_tip, new Object[]{str}));
            imageView.setImageResource(i2);
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    if (i == 28) {
                        hashMap.put("which", "facebook");
                    } else if (i == 31) {
                        hashMap.put("which", "instagram");
                    }
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Online_login", hashMap);
                    if (C4600l.m11739k(C7447b.this.mActivity, false)) {
                        C7447b.this.m22046rv(i);
                    } else {
                        C4577f.m11626a((Context) C7447b.this.mActivity, 0, C7447b.this.dFo, R.string.xiaoying_str_com_msg_network_inactive);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void ayl() {
        if (this.dHK == null) {
            this.dHK = new C7428c(this.mActivity.getApplicationContext(), this.dHW);
            this.dFn.setAdapter(this.dHK);
        }
    }

    private void azf() {
        this.dHL = new GalleryFooterViewV2(this.mActivity.getApplicationContext());
        this.dHL.setOnFooterClickListener(new C7491a() {
            /* access modifiers changed from: private */
            public int azk() {
                return (C7447b.this.dGg != 2 && C7447b.this.mSourceType == 0) ? 2 : 4;
            }

            public void azj() {
                if (!C7447b.this.mActivity.isFinishing()) {
                    if (C7447b.this.dHM == null) {
                        C7447b.this.dHM = new C7506a(C7447b.this.mActivity.getApplicationContext());
                        C7447b.this.dHM.mo32291a(new C7507a() {
                            public void azl() {
                                if (C7447b.this.dyR == null) {
                                    C7447b.this.dyR = new C7142b(C7447b.this.mActivity, C74639.this.azk(), C7447b.this.dyS);
                                }
                                C7447b.this.dyR.awl();
                            }

                            public void azm() {
                                C7447b.this.dHU = true;
                                VivaRouter.getRouterBuilder(FileExplorerParams.URL).mo10406h(FileExplorerParams.KEY_EXPLORER_FILE_TYPE, C74639.this.azk()).mo10382H(C7447b.this.mActivity);
                            }
                        });
                    }
                    if (!C7447b.this.dHM.isShowing()) {
                        C7447b.this.dHM.showAtLocation(C7447b.this.dHI.getRootView(), 81, 0, 0);
                    }
                }
            }
        });
    }

    private void azg() {
        this.dHI.setLayoutManager(new WrapGridLayoutManager(this.mActivity.getApplicationContext(), 2));
        this.dHJ = new C7423b(this.mActivity.getApplicationContext());
        this.dHJ.mo32065a((C7426a) new C7426a() {
            /* renamed from: hk */
            public void mo32074hk(int i) {
                try {
                    C7447b.this.m22047rw(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (C74628.dGC[this.dHX.ordinal()] != 1) {
            this.dHJ.ayW();
        } else {
            this.dHJ.mo32067a(this.dHL);
        }
        this.dHI.setAdapter(this.dHJ);
        this.dHI.mo7733a((C1018h) new C7430d(2, this.mActivity.getResources().getDimensionPixelSize(R.dimen.gallery_folder_item_space), true));
        this.dHI.setHasFixedSize(true);
    }

    /* access modifiers changed from: private */
    public void azh() {
        if (this.bLS != null) {
            Message message = new Message();
            message.what = QEffect.PROP_AUDIO_FRAME_ADJUST_DB;
            message.obj = this.dHQ;
            this.bLS.sendMessage(message);
        }
    }

    /* renamed from: c */
    private void m22019c(int i, MSize mSize) {
        LogUtils.m14222e("MediaGalleryController", "------------>getFaceBookAlbums!!!");
        C7187d axT = C7187d.axT();
        axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
            public void onSyncAlbumsError() {
            }

            public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
                boolean z;
                if (C7447b.this.dHX == C7444c.GALLERY_TAB_FACEBOOK && !C7447b.this.dqz) {
                    ArrayList arrayList = new ArrayList();
                    C7447b.this.m22022ca(list);
                    if (C7447b.this.dGg == 2 || C7447b.this.mSourceType == 1) {
                        for (MediaGroupItem mediaGroupItem : list) {
                            if (!"videos".equals(mediaGroupItem.strGroupDisplayName)) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (((MediaGroupItem) it.next()).strGroupDisplayName.equals(mediaGroupItem.strGroupDisplayName)) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    arrayList.add(mediaGroupItem);
                                }
                            }
                        }
                        C7447b.this.dHW.removeMessages(QPlayer.PROP_PLAYER_RANGE);
                        C7447b.this.dHW.sendMessageDelayed(C7447b.this.dHW.obtainMessage(QPlayer.PROP_PLAYER_RANGE, 1, 0, arrayList), 300);
                    } else if (C7447b.this.mSourceType == 0) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            MediaGroupItem mediaGroupItem2 = (MediaGroupItem) it2.next();
                            if ("videos".equals(mediaGroupItem2.strGroupDisplayName)) {
                                C7447b.this.dHW.removeMessages(QPlayer.PROP_PLAYER_RANGE);
                                C7447b.this.dHW.sendMessageDelayed(C7447b.this.dHW.obtainMessage(QPlayer.PROP_PLAYER_RANGE, 0, 0, mediaGroupItem2), 300);
                                break;
                            }
                        }
                    }
                }
            }

            public void onSyncMediaDataError() {
            }

            public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
            }
        });
        axT.mo31667a(i, this.mActivity, mSize);
    }

    /* access modifiers changed from: private */
    /* renamed from: ca */
    public void m22022ca(List<MediaGroupItem> list) {
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                MediaGroupItem mediaGroupItem = (MediaGroupItem) list.get(i);
                String str = mediaGroupItem.strGroupDisplayName;
                if (!"9999".equals(mediaGroupItem.albumId) || !"videos".equals(str)) {
                    i++;
                } else {
                    list.remove(i);
                    list.add(0, mediaGroupItem);
                    return;
                }
            }
        }
    }

    /* renamed from: cb */
    private void m22023cb(List<ExtMediaItem> list) {
        if (list != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int size = list.size() - 1; size > i; size--) {
                    if (!(list.get(i) == null || list.get(size) == null || (((ExtMediaItem) list.get(size)).date != ((ExtMediaItem) list.get(i)).date && !TextUtils.equals(((ExtMediaItem) list.get(size)).path, ((ExtMediaItem) list.get(i)).path)))) {
                        list.remove(size);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m22025d(final MediaGroupItem mediaGroupItem) {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                if (C7447b.this.dHO != null) {
                    C7447b.this.dHO.unInit();
                }
                C7447b.this.dHO = new C7149c();
                C7447b.this.dHO.mo31609a(GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_DATE);
                C7447b.this.dHO.mo31611a(C7447b.this.mActivity.getApplicationContext(), mediaGroupItem);
                mVar.mo9791K(Boolean.valueOf(true));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (!C7447b.this.dqz) {
                    C7447b.this.dHP = false;
                    C7447b.this.dHI.setVisibility(8);
                    C7447b.this.dFn.setVisibility(0);
                    C7447b.this.ayl();
                    C7447b.this.dHK.mo32077d(C7447b.this.dHO);
                    if (mediaGroupItem != null && mediaGroupItem.lNewItemCount > 0) {
                        mediaGroupItem.lNewItemCount = 0;
                        C7472a.m22079a(C7447b.this.mActivity.getApplicationContext(), C7447b.this.dHO);
                    }
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: di */
    public void m22026di(int i, int i2) {
        if (this.dHO != null) {
            ExtMediaItem de = this.dHO.mo31616de(i, i2);
            if (de != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dHY > 1000) {
                    this.dHY = currentTimeMillis;
                    Message message = new Message();
                    message.what = QEffect.PROP_VIDEO_IE_CONFIGURE;
                    if (MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(de.path)) || de.mediaType == MediaType.MEDIA_TYPE_IMAGE) {
                        if (this.dHX == C7444c.GALLERY_TAB_FACEBOOK || this.dHX == C7444c.GALLERY_TAB_INSTAGRAM) {
                            Map<Long, MediaGroupItem> map = this.dHO.mMediaGroupMap;
                            if (map != null) {
                                this.dHQ.mediaItemList.clear();
                                ArrayList arrayList = new ArrayList(map.keySet());
                                Collections.sort(arrayList);
                                int size = arrayList.size();
                                while (true) {
                                    size--;
                                    if (size <= -1) {
                                        break;
                                    }
                                    MediaGroupItem mediaGroupItem = (MediaGroupItem) map.get(arrayList.get(size));
                                    if (mediaGroupItem != null) {
                                        this.dHQ.mediaItemList.addAll(mediaGroupItem.mediaItemList);
                                    }
                                }
                            }
                        }
                        ArrayList p = m22042p(this.dHQ.mediaItemList);
                        int df = this.dHO.mo31617df(i, i2);
                        message.obj = p;
                        message.arg1 = df;
                    } else {
                        message.obj = de;
                    }
                    if (this.bLS != null) {
                        this.bLS.sendMessage(message);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22028e(MediaGroupItem mediaGroupItem) {
        if (mediaGroupItem != null) {
            m22023cb(mediaGroupItem.getMediaItemList());
            this.dHQ = mediaGroupItem;
            this.dHP = false;
            this.dHI.setVisibility(8);
            this.dFn.setVisibility(0);
            if (this.dHK != null) {
                this.dHK.mo32077d(null);
            }
            m22010a(C7444c.GALLERY_TAB_INSTAGRAM);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ij */
    public void m22033ij(boolean z) {
        if (this.dHX == C7444c.GALLERY_TAB_FACEBOOK) {
            m22011a(C7444c.GALLERY_TAB_FACEBOOK, true);
        } else if (this.dHX == C7444c.GALLERY_TAB_INSTAGRAM) {
            m22011a(C7444c.GALLERY_TAB_INSTAGRAM, true);
        } else {
            m22002a(this.dHN, z);
        }
    }

    /* renamed from: ik */
    private void m22034ik(boolean z) {
        Message message = new Message();
        message.what = QEffect.PROP_AUDIO_FRAME_MIXPERCENT;
        message.obj = Boolean.valueOf(z);
        if (this.bLS != null) {
            this.bLS.sendMessage(message);
        }
    }

    /* renamed from: p */
    private ArrayList<ImgPreviewDataItem> m22042p(ArrayList<ExtMediaItem> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList<ImgPreviewDataItem> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ExtMediaItem extMediaItem = (ExtMediaItem) it.next();
            if (extMediaItem.mediaType == null || extMediaItem.mediaType != MediaType.MEDIA_TYPE_VIDEO) {
                ImgPreviewDataItem imgPreviewDataItem = new ImgPreviewDataItem();
                imgPreviewDataItem.mRawFilePath = extMediaItem.path;
                imgPreviewDataItem.snsType = extMediaItem.snsType;
                arrayList2.add(imgPreviewDataItem);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* renamed from: ru */
    public void m22045ru(int i) {
        if (i == 28) {
            m22019c(28, this.dHS);
        } else {
            m22050t(31, null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: rv */
    public void m22046rv(final int i) {
        SnsAuthServiceProxy.auth(this.mActivity, new Builder().snsType(i).snsAuthListener(new SnsAuthListener() {
            public void onAuthCancel(int i) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", "cancel");
                if (i == 28) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Facebook", hashMap);
                } else if (i == 31) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Instagram", hashMap);
                }
                C4577f.m11626a((Context) C7447b.this.mActivity, 0, C7447b.this.dFo, R.string.xiaoying_str_sns_gallery_longin_tip_cancel);
            }

            public void onAuthComplete(int i, Bundle bundle) {
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("name");
                }
                C7157a.dCF = str;
                C7447b.this.dHE.setVisibility(8);
                C7447b.this.m22045ru(i);
                C4577f.m11626a((Context) C7447b.this.mActivity, 0, C7447b.this.dFo, R.string.xiaoying_str_sns_gallery_longin_tip_success);
                HashMap hashMap = new HashMap();
                hashMap.put("result", "success");
                if (i == 28) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Facebook", hashMap);
                } else if (i == 31) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Instagram", hashMap);
                }
            }

            public void onAuthFail(int i, int i2, String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", BannerJSAdapter.FAIL);
                if (i == 28) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Facebook", hashMap);
                } else if (i == 31) {
                    UserBehaviorLog.onKVEvent(C7447b.this.mActivity.getApplicationContext(), "Gallery_Blind_Instagram", hashMap);
                }
                C4577f.m11626a((Context) C7447b.this.mActivity, 0, C7447b.this.dFo, R.string.xiaoying_str_sns_gallery_longin_tip_fail);
            }
        }));
        if (this.bLS != null) {
            Message message = new Message();
            message.what = QEffect.PROP_AUDIO_FRAME_REPEAT_MODE;
            message.obj = Integer.valueOf(i);
            this.bLS.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: rw */
    public void m22047rw(int i) {
        if ((this.dHX == C7444c.GALLERY_TAB_FACEBOOK || this.dHX == C7444c.GALLERY_TAB_INSTAGRAM) && !C4600l.m11739k(this.mActivity.getApplicationContext(), false)) {
            C4577f.m11626a((Context) this.mActivity, 0, this.dFo, R.string.xiaoying_str_com_msg_network_inactive);
            return;
        }
        if (this.dHX == C7444c.GALLERY_TAB_FACEBOOK && this.mSourceType == 1) {
            this.dHQ = this.dHJ.mo32071ro(i);
            if (!(this.dHQ == null || this.dHQ.mediaType == MediaType.MEDIA_TYPE_VIDEO)) {
                C7187d axT = C7187d.axT();
                axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
                    public void onSyncAlbumsError() {
                    }

                    public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
                    }

                    public void onSyncMediaDataError() {
                    }

                    public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
                        if (!C7447b.this.dqz && C7447b.this.dHQ != null) {
                            if (C7447b.this.dHK != null) {
                                C7447b.this.dHK.mo32077d(null);
                            }
                            if (C7447b.this.dHQ.mediaItemList != null) {
                                C7447b.this.dHQ.mediaItemList.clear();
                                C7447b.this.dHQ.mediaItemList.addAll(list);
                            } else if (list != null) {
                                C7447b.this.dHQ.mediaItemList = new ArrayList<>(list);
                            }
                            C7447b.this.azh();
                            C7447b.this.m22010a(C7444c.GALLERY_TAB_FACEBOOK);
                            if (C7447b.this.bLS != null) {
                                C7447b.this.bLS.sendEmptyMessage(QEffect.PROP_ORIGINAL_RANGE);
                            }
                        }
                    }
                });
                axT.mo31668a(28, this.mActivity, this.dHQ.albumId, this.dHS);
            }
        } else {
            if (this.dHJ != null && i >= 0 && i < this.dHJ.getItemCount()) {
                this.dHQ = this.dHJ.mo32071ro(i);
            }
            if (this.dHQ != null) {
                azh();
                m22010a(this.dHX);
                if (this.bLS != null) {
                    this.bLS.sendEmptyMessage(QEffect.PROP_ORIGINAL_RANGE);
                }
            }
        }
    }

    /* renamed from: t */
    private void m22050t(int i, String str) {
        LogUtils.m14222e("MediaGalleryController", "------------>getInsagramData!!!");
        C7187d axT = C7187d.axT();
        axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
            public void onSyncAlbumsError() {
            }

            public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
                if (C7447b.this.dHX == C7444c.GALLERY_TAB_INSTAGRAM && !C7447b.this.dqz) {
                    if (C7447b.this.dGg == 2 || C7447b.this.mSourceType == 1) {
                        for (MediaGroupItem mediaGroupItem : list) {
                            if (!"videos".equals(mediaGroupItem.strGroupDisplayName)) {
                                C7447b.this.dHW.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                                C7447b.this.dHW.sendMessageDelayed(C7447b.this.dHW.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR, mediaGroupItem), 300);
                            }
                        }
                    } else if (C7447b.this.mSourceType == 0) {
                        for (MediaGroupItem mediaGroupItem2 : list) {
                            if ("videos".equals(mediaGroupItem2.strGroupDisplayName)) {
                                C7447b.this.dHW.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                                C7447b.this.dHW.sendMessageDelayed(C7447b.this.dHW.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR, mediaGroupItem2), 300);
                            }
                        }
                    }
                }
            }

            public void onSyncMediaDataError() {
            }

            public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
            }
        });
        axT.mo31668a(i, this.mActivity, str, this.dHS);
    }

    /* renamed from: ai */
    public void mo32115ai(int i, boolean z) {
        if (this.dHE != null && this.dHE.isShown()) {
            this.mSourceType = i;
        } else if (this.mSourceType != i || this.dHU || z) {
            boolean z2 = false;
            this.dHU = false;
            this.mSourceType = i;
            if (this.dHT != null) {
                this.dHT.setVisibility(8);
            }
            if (this.mSourceType == 0) {
                z2 = true;
            }
            m22033ij(z2);
            if (this.dHL != null) {
                if (this.mSourceType == 0) {
                    this.dHL.setButtonText(R.string.xiaoying_str_ve_gallery_not_find_video_tip);
                } else {
                    this.dHL.setButtonText(R.string.xiaoying_str_ve_gallery_not_find_clip_tip);
                }
            }
        }
    }

    public void ayi() {
        this.dHI.setVisibility(0);
        this.dFn.setVisibility(8);
        this.dHT.setVisibility(8);
        this.dHP = true;
        if (this.dHK != null) {
            this.dHK.mo32077d(null);
        }
        if (this.dHJ != null) {
            this.dHJ.notifyDataSetChanged();
        }
    }

    public boolean ayj() {
        return this.dHP;
    }

    public boolean ayk() {
        if (this.dHX == C7444c.GALLERY_TAB_FACEBOOK || this.dHX == C7444c.GALLERY_TAB_INSTAGRAM) {
            return true;
        }
        boolean z = false;
        if (this.dFn.isShown()) {
            LayoutManager layoutManager = this.dFn.getLayoutManager();
            if (layoutManager != null && layoutManager.getChildCount() > 1) {
                z = true;
            }
            return z;
        } else if (!this.dHI.isShown()) {
            return false;
        } else {
            LayoutManager layoutManager2 = this.dHI.getLayoutManager();
            if (layoutManager2 != null && layoutManager2.getChildCount() > 1) {
                z = true;
            }
            return z;
        }
    }

    public void azi() {
        this.dqz = true;
        C7149c.awD();
        if (this.dHW != null) {
            this.dHW.removeCallbacksAndMessages(null);
            this.dHW = null;
        }
        if (this.dHO != null) {
            this.dHO.unInit();
            this.dHO = null;
        }
        if (this.dHN != null) {
            this.dHN.unInit();
            this.dHN = null;
        }
    }

    /* renamed from: cR */
    public void mo32120cR(View view) {
        this.dFo = view;
    }

    /* renamed from: cV */
    public void mo32121cV(View view) {
        this.dHE = view;
    }

    /* renamed from: e */
    public void mo32122e(int i, boolean z, int i2) {
        this.cSj = i2;
        this.dGg = i;
        if (!C2561a.aON() || !z) {
            this.dHS = new MSize(700, 700);
        } else {
            this.dHS = new MSize((int) QUtils.VIDEO_RES_720P_HEIGHT, (int) QUtils.VIDEO_RES_720P_WIDTH);
        }
    }

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
    }
}
