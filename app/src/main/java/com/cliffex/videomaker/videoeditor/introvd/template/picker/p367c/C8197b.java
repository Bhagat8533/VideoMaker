package com.introvd.template.picker.p367c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.explorer.p299d.C7157a;
import com.introvd.template.explorer.p299d.C7157a.C7162c;
import com.introvd.template.explorer.p299d.C7187d;
import com.introvd.template.explorer.p300e.C7211d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.picker.R;
import com.introvd.template.picker.p367c.C8192a.C8193a;
import com.introvd.template.picker.p367c.p368a.C8194a;
import com.introvd.template.picker.p367c.p368a.C8195b;
import com.introvd.template.picker.p367c.p368a.C8196c;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.gallery.SnsGalleryInfoListener;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.picker.c.b */
public class C8197b {
    private C1834l dYs;
    private C1834l dYt;
    /* access modifiers changed from: private */
    public C8211a dYu;
    /* access modifiers changed from: private */
    public Activity mActivity;

    /* renamed from: com.introvd.template.picker.c.b$a */
    private static class C8211a extends Handler {
        private WeakReference<C8197b> dYA;
        private WeakReference<Activity> dYB;

        public C8211a(C8197b bVar, Activity activity) {
            this.dYA = new WeakReference<>(bVar);
            this.dYB = new WeakReference<>(activity);
        }

        public void handleMessage(Message message) {
            final Activity activity = (Activity) this.dYB.get();
            C8197b bVar = (C8197b) this.dYA.get();
            if (activity != null && bVar != null) {
                switch (message.what) {
                    case 4097:
                        final String str = (String) message.obj;
                        C4586g.m11705a((Context) activity, "0%", (OnCancelListener) new OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                C7157a.m21184fY(activity).mo31634jm(str);
                            }
                        }, true);
                        break;
                    case 4098:
                        StringBuilder sb = new StringBuilder();
                        sb.append(message.arg1);
                        sb.append("%");
                        C4586g.m11713eJ(sb.toString());
                        break;
                    case 4099:
                        if (!activity.isFinishing()) {
                            C4586g.m11713eJ("100%");
                            C4586g.m11696Sm();
                            break;
                        }
                        break;
                    case 4100:
                        if (!activity.isFinishing()) {
                            C4586g.m11696Sm();
                            ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_network_inactive, 0);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.picker.c.b$b */
    public class C8213b implements C1518f<C1834l<? extends Throwable>, C1834l<?>> {
        /* access modifiers changed from: private */
        public final int bcK;
        /* access modifiers changed from: private */
        public final int bcN;
        /* access modifiers changed from: private */
        public int retryCount;

        public C8213b(int i, int i2) {
            this.bcN = i;
            this.bcK = i2;
        }

        /* renamed from: a */
        static /* synthetic */ int m23720a(C8213b bVar) {
            int i = bVar.retryCount + 1;
            bVar.retryCount = i;
            return i;
        }

        /* renamed from: b */
        public C1834l<?> apply(C1834l<? extends Throwable> lVar) {
            return lVar.mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Throwable, C1834l<?>>() {
                /* renamed from: o */
                public C1834l<?> apply(Throwable th) {
                    if (C8213b.m23720a(C8213b.this) > C8213b.this.bcN) {
                        return C1834l.m5263w(th);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Get Error, it will try after ");
                    sb.append(C8213b.this.bcK);
                    sb.append(" millisecond, retry count ");
                    sb.append(C8213b.this.retryCount);
                    LogUtils.m14222e("PickerDataController", sb.toString());
                    return C1834l.m5261d((long) C8213b.this.bcK, TimeUnit.MILLISECONDS);
                }
            });
        }
    }

    public C8197b(Activity activity) {
        this.mActivity = activity;
        this.dYu = new C8211a(this, activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C8215c m23691a(ExtMediaItem extMediaItem) {
        if (extMediaItem == null) {
            return null;
        }
        int GetFileMediaType = MediaFileUtils.GetFileMediaType(extMediaItem.path);
        C8216a aVar = new C8216a();
        if (MediaFileUtils.IsImageFileType(GetFileMediaType) || extMediaItem.mediaType == MediaType.MEDIA_TYPE_IMAGE) {
            aVar.mo33356my(extMediaItem.path);
            aVar.mo33359tg(0);
        } else if ((MediaFileUtils.IsVideoFileType(GetFileMediaType) || extMediaItem.duration > 0) && extMediaItem.mediaType != MediaType.MEDIA_TYPE_VIDEO) {
            aVar.mo33356my(extMediaItem.path);
            aVar.mo33359tg(1);
            aVar.mo33358tf((int) extMediaItem.duration);
        } else if (extMediaItem.mediaType == MediaType.MEDIA_TYPE_VIDEO) {
            aVar.mo33356my(extMediaItem.thumbUrl);
            aVar.mo33359tg(1);
            aVar.mo33358tf((int) extMediaItem.duration);
        }
        aVar.mo33357mz(extMediaItem.path);
        return aVar.aFL();
    }

    /* access modifiers changed from: private */
    /* renamed from: ca */
    public void m23695ca(List<MediaGroupItem> list) {
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

    /* access modifiers changed from: private */
    /* renamed from: cb */
    public void m23696cb(List<ExtMediaItem> list) {
        if (list != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int size = list.size() - 1; size > i; size--) {
                    if (((ExtMediaItem) list.get(size)).date == ((ExtMediaItem) list.get(i)).date || ((ExtMediaItem) list.get(size)).path.equals(((ExtMediaItem) list.get(i)).path)) {
                        list.remove(size);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public C8192a m23697f(MediaGroupItem mediaGroupItem) {
        Integer num = null;
        if (mediaGroupItem == null) {
            return null;
        }
        int a = C7149c.m21122a(mediaGroupItem);
        int b = C7149c.m21137b(mediaGroupItem);
        C8193a aVar = new C8193a();
        boolean z = true;
        C8193a td = aVar.mo33323td(mediaGroupItem.lNewItemCount > 0 ? 1 : 0);
        if (a <= 0) {
            z = false;
        }
        td.mo33318iT(z);
        ArrayList mediaItemList = mediaGroupItem.getMediaItemList();
        if (mediaItemList != null && mediaItemList.size() > 0 && !TextUtils.isEmpty(((ExtMediaItem) mediaItemList.get(0)).path)) {
            aVar.mo33319mv(((ExtMediaItem) mediaItemList.get(0)).path);
        } else if (!TextUtils.isEmpty(mediaGroupItem.coverPhotoUrl)) {
            aVar.mo33319mv(mediaGroupItem.coverPhotoUrl);
        }
        int i = a + b;
        if (i == 0) {
            aVar.mo33322tc(mediaGroupItem.mediaItemList.size());
        } else {
            aVar.mo33322tc(i);
        }
        aVar.mo33320mw(mediaGroupItem.strGroupDisplayName);
        if (C7211d.ayb() != null) {
            num = (Integer) C7211d.ayb().get(mediaGroupItem.strParentPath);
        }
        if (num != null) {
            aVar.mo33320mw(this.mActivity.getResources().getString(num.intValue()));
        }
        ArrayList arrayList = new ArrayList();
        if (mediaItemList != null) {
            Iterator it = mediaItemList.iterator();
            while (it.hasNext()) {
                arrayList.add(m23691a((ExtMediaItem) it.next()));
            }
        }
        aVar.mo33321mx(mediaGroupItem.albumId);
        aVar.mo33317cE(arrayList);
        return aVar.aFI();
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public void mo33331a(final int i, final C8195b bVar) {
        if (this.dYs != null) {
            this.dYs.mo10163e(C1820a.aVi());
        }
        this.dYs = C1834l.m5254a((C1839n<T>) new C1839n<List<MediaGroupItem>>() {
            /* renamed from: a */
            public void mo10177a(C1838m<List<MediaGroupItem>> mVar) {
                BROWSE_TYPE browse_type = BROWSE_TYPE.VIDEO;
                if (i == 0) {
                    browse_type = BROWSE_TYPE.PHOTO;
                }
                C7149c cVar = new C7149c();
                cVar.mo31610a((Context) C8197b.this.mActivity, MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, browse_type);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < cVar.getGroupCount(); i++) {
                    MediaGroupItem qE = cVar.mo31620qE(i);
                    if (qE != null) {
                        arrayList.add(qE);
                    }
                }
                mVar.mo9791K(arrayList);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<MediaGroupItem>, List<C8192a>>() {
            public List<C8192a> apply(List<MediaGroupItem> list) {
                ArrayList arrayList = new ArrayList();
                for (MediaGroupItem a : list) {
                    C8192a a2 = C8197b.this.m23697f(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C8213b<Object,Object>(20, 50));
        this.dYs.mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C8192a>>() {
            /* renamed from: R */
            public void mo9886K(List<C8192a> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("LocalFolderData onNext datasize:");
                sb.append(list.size());
                LogUtils.m14223i("PickerDataController", sb.toString());
                if (bVar != null) {
                    bVar.onSuccess(list);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("LocalFolderData onError msg:");
                sb.append(th.getMessage());
                LogUtils.m14223i("PickerDataController", sb.toString());
                if (bVar != null) {
                    bVar.onError(th);
                }
            }
        });
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public void mo33332a(final int i, final C8196c cVar) {
        if (this.dYt != null) {
            this.dYt.mo10163e(C1820a.aVi());
        }
        this.dYt = C1834l.m5254a((C1839n<T>) new C1839n<List<ExtMediaItem>>() {
            /* renamed from: a */
            public void mo10177a(C1838m<List<ExtMediaItem>> mVar) {
                BROWSE_TYPE browse_type = BROWSE_TYPE.VIDEO;
                if (i == 0) {
                    browse_type = BROWSE_TYPE.PHOTO;
                }
                C7149c cVar = new C7149c();
                cVar.mo31610a((Context) C8197b.this.mActivity, MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, browse_type);
                mVar.mo9791K(cVar.awy().mediaItemList);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<ExtMediaItem>, List<C8215c>>() {
            public List<C8215c> apply(List<ExtMediaItem> list) {
                ArrayList arrayList = new ArrayList();
                for (ExtMediaItem a : list) {
                    C8215c a2 = C8197b.this.m23691a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C8213b<Object,Object>(20, 50));
        this.dYt.mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C8215c>>() {
            /* renamed from: R */
            public void mo9886K(List<C8215c> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("LocalMediaData onNext datasize:");
                sb.append(list.size());
                LogUtils.m14223i("PickerDataController", sb.toString());
                if (cVar != null) {
                    cVar.onSuccess(list);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("LocalMediaData onError msg:");
                sb.append(th.getMessage());
                LogUtils.m14223i("PickerDataController", sb.toString());
                if (cVar != null) {
                    cVar.onError(th);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo33333a(Activity activity, final int i, MSize mSize, final C8196c cVar) {
        C7187d axT = C7187d.axT();
        axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
            public void onSyncAlbumsError() {
            }

            public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
                if (i == 0) {
                    if (list != null && list.size() != 0) {
                        ArrayList<C8192a> arrayList = new ArrayList<>();
                        ArrayList<MediaGroupItem> arrayList2 = new ArrayList<>();
                        for (MediaGroupItem mediaGroupItem : list) {
                            if (!"videos".equals(mediaGroupItem.strGroupDisplayName)) {
                                C8197b.this.m23696cb(mediaGroupItem.getMediaItemList());
                                arrayList2.add(mediaGroupItem);
                            }
                        }
                        for (MediaGroupItem a : arrayList2) {
                            C8192a a2 = C8197b.this.m23697f(a);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (C8192a aVar : arrayList) {
                            if (aVar.aFE() != null && aVar.aFE().size() > 0) {
                                arrayList3.addAll(aVar.aFE());
                            }
                        }
                        if (cVar != null) {
                            cVar.onSuccess(arrayList3);
                        }
                    } else if (cVar != null) {
                        cVar.onSuccess(new ArrayList());
                    }
                } else if (i != 1) {
                } else {
                    if (list != null && list.size() != 0) {
                        List arrayList4 = new ArrayList();
                        MediaGroupItem mediaGroupItem2 = null;
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MediaGroupItem mediaGroupItem3 = (MediaGroupItem) it.next();
                            if ("videos".equals(mediaGroupItem3.strGroupDisplayName)) {
                                mediaGroupItem2 = mediaGroupItem3;
                                break;
                            }
                        }
                        if (mediaGroupItem2 != null) {
                            C8197b.this.m23696cb(mediaGroupItem2.getMediaItemList());
                            C8192a a3 = C8197b.this.m23697f(mediaGroupItem2);
                            if (a3 != null) {
                                arrayList4 = a3.aFE();
                            }
                        }
                        if (cVar != null) {
                            cVar.onSuccess(arrayList4);
                        }
                    } else if (cVar != null) {
                        cVar.onSuccess(new ArrayList());
                    }
                }
            }

            public void onSyncMediaDataError() {
            }

            public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
                LogUtils.m14223i("PickerDataController", "InstagramMediaData:onSyncMediaDataSuccess");
            }
        });
        axT.mo31668a(31, activity, null, mSize);
    }

    /* renamed from: a */
    public void mo33334a(Activity activity, MSize mSize, final int i, final C8195b bVar) {
        C7187d axT = C7187d.axT();
        axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
            public void onSyncAlbumsError() {
                if (bVar != null) {
                    bVar.onError(null);
                }
            }

            public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
                ArrayList<MediaGroupItem> arrayList = new ArrayList<>();
                C8197b.this.m23695ca(list);
                if (i == 0) {
                    for (MediaGroupItem mediaGroupItem : list) {
                        if (!"videos".equals(mediaGroupItem.strGroupDisplayName)) {
                            boolean z = false;
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((MediaGroupItem) it.next()).strGroupDisplayName.equals(mediaGroupItem.strGroupDisplayName)) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (!z) {
                                arrayList.add(mediaGroupItem);
                            }
                        }
                    }
                    if (bVar != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaGroupItem a : arrayList) {
                            C8192a a2 = C8197b.this.m23697f(a);
                            if (a2 != null) {
                                arrayList2.add(a2);
                            }
                        }
                        bVar.onSuccess(arrayList2);
                    }
                } else if (i != 1) {
                } else {
                    if (list != null && list.size() != 0) {
                        ArrayList arrayList3 = new ArrayList();
                        MediaGroupItem mediaGroupItem2 = null;
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            MediaGroupItem mediaGroupItem3 = (MediaGroupItem) it2.next();
                            if ("videos".equals(mediaGroupItem3.strGroupDisplayName)) {
                                mediaGroupItem2 = mediaGroupItem3;
                                break;
                            }
                        }
                        if (mediaGroupItem2 != null) {
                            C8197b.this.m23696cb(mediaGroupItem2.getMediaItemList());
                            C8192a a3 = C8197b.this.m23697f(mediaGroupItem2);
                            if (a3 != null) {
                                arrayList3.add(a3);
                            }
                        }
                        if (bVar != null) {
                            bVar.onSuccess(arrayList3);
                        }
                    } else if (bVar != null) {
                        bVar.onSuccess(new ArrayList());
                    }
                }
            }

            public void onSyncMediaDataError() {
            }

            public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
            }
        });
        axT.mo31667a(28, activity, mSize);
    }

    /* renamed from: a */
    public void mo33335a(Activity activity, String str, MSize mSize, final C8196c cVar) {
        C7187d axT = C7187d.axT();
        axT.setSnsGalleryInfoListener(new SnsGalleryInfoListener() {
            public void onSyncAlbumsError() {
            }

            public void onSyncAlbumsSuccess(List<MediaGroupItem> list) {
            }

            public void onSyncMediaDataError() {
                if (cVar != null) {
                    cVar.onError(null);
                }
            }

            public void onSyncMediaDataSuccess(List<ExtMediaItem> list) {
                ArrayList arrayList = new ArrayList();
                for (ExtMediaItem a : list) {
                    C8215c a2 = C8197b.this.m23691a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                if (cVar != null) {
                    cVar.onSuccess(arrayList);
                }
            }
        });
        axT.mo31668a(28, activity, str, mSize);
    }

    /* renamed from: a */
    public void mo33336a(final String str, int i, int i2, final C8194a aVar) {
        boolean k = C4600l.m11739k(this.mActivity, true);
        C7157a fY = C7157a.m21184fY(this.mActivity);
        if (k) {
            fY.mo31633a((Handler) this.dYu);
            String a = fY.mo31632a(str, i, i2, new C7162c() {
                /* renamed from: aI */
                public void mo31639aI(long j) {
                    if (C8197b.this.dYu != null) {
                        C8197b.this.dYu.sendMessage(C8197b.this.dYu.obtainMessage(4097, str));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    sb.append("");
                    LogUtils.m14223i("PickerDataController", sb.toString());
                }

                public void axQ() {
                    if (C8197b.this.dYu != null) {
                        C8197b.this.dYu.sendEmptyMessage(4100);
                    }
                    if (aVar != null) {
                        aVar.onError();
                    }
                }

                /* renamed from: i */
                public void mo31641i(long j, int i) {
                    if (C8197b.this.dYu != null) {
                        C8197b.this.dYu.sendMessage(C8197b.this.dYu.obtainMessage(4098, i, 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onDownloading:");
                    sb.append(j);
                    sb.append("/");
                    sb.append(i);
                    LogUtils.m14223i("PickerDataController", sb.toString());
                }

                /* renamed from: i */
                public synchronized void mo31642i(long j, String str) {
                    if (C8197b.this.dYu != null) {
                        C8197b.this.dYu.sendMessage(C8197b.this.dYu.obtainMessage(4099, str));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (aVar != null) {
                            aVar.mo33325dV(str);
                        }
                    } else if (aVar != null) {
                        aVar.onError();
                    }
                    LogUtils.m14223i("PickerDataController", "onFinishDownload!!!");
                }
            });
            if (!TextUtils.isEmpty(a) && aVar != null) {
                aVar.mo33325dV(a);
                return;
            }
            return;
        }
        String a2 = fY.mo31632a(str, i, i2, null);
        if (TextUtils.isEmpty(a2)) {
            if (aVar != null) {
                aVar.onError();
            }
            ToastUtils.show((Context) this.mActivity, R.string.xiaoying_str_com_msg_network_inactive, 0);
        } else if (aVar != null) {
            aVar.mo33325dV(a2);
        }
    }

    /* renamed from: a */
    public void mo33337a(final List<String> list, final C8196c cVar) {
        C1834l.m5254a((C1839n<T>) new C1839n<List<ExtMediaItem>>() {
            /* renamed from: a */
            public void mo10177a(C1838m<List<ExtMediaItem>> mVar) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (String bT : list) {
                    ExtMediaItem bT2 = C7149c.m21141bT(C8197b.this.mActivity, bT);
                    if (bT2 != null) {
                        arrayList.add(bT2);
                    }
                }
                mVar.mo9791K(arrayList);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<ExtMediaItem>, List<C8215c>>() {
            public List<C8215c> apply(List<ExtMediaItem> list) {
                ArrayList arrayList = new ArrayList();
                for (ExtMediaItem a : list) {
                    C8215c a2 = C8197b.this.m23691a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C8213b<Object,Object>(20, 50)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C8215c>>() {
            /* renamed from: R */
            public void mo9886K(List<C8215c> list) {
                if (cVar != null) {
                    cVar.onSuccess(list);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                if (cVar != null) {
                    cVar.onError(th);
                }
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public void release() {
        if (this.dYs != null) {
            this.dYs.mo10163e(C1820a.aVi());
        }
        if (this.dYt != null) {
            this.dYt.mo10163e(C1820a.aVi());
        }
    }
}
