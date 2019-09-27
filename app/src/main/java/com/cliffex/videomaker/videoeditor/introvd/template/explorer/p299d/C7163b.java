package com.introvd.template.explorer.p299d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.eiii.AccessToken;
import com.eiii.GraphRequest;
import com.eiii.GraphRequest.Callback;
import com.eiii.GraphResponse;
import com.eiii.HttpMethod;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.SnsType;
import com.introvd.template.sns.gallery.ISnsGallery;
import com.introvd.template.sns.gallery.SnsGalleryInfoListener;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.vivaexplorermodule.R;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.explorer.d.b */
public class C7163b implements ISnsGallery {
    private static final String TAG = "b";
    /* access modifiers changed from: private */
    public static Map<String, List<ExtMediaItem>> dCS = new HashMap();
    /* access modifiers changed from: private */
    public ArrayList<ExtMediaItem> ckD = new ArrayList<>();
    /* access modifiers changed from: private */
    public SnsGalleryInfoListener dCP;
    private List<C7180a> dCQ = new ArrayList();
    /* access modifiers changed from: private */
    public List<MediaGroupItem> dCR = new ArrayList();
    /* access modifiers changed from: private */
    public String dCT;
    /* access modifiers changed from: private */
    public String dCU;
    /* access modifiers changed from: private */
    public String dCV;
    /* access modifiers changed from: private */
    public String dCW;
    private String dCX;
    private String dCY;
    private boolean dCZ = true;
    /* access modifiers changed from: private */
    public boolean dDa = true;
    /* access modifiers changed from: private */
    public String dDb;
    /* access modifiers changed from: private */
    public MSize dDc;
    private MSize dDd;
    /* access modifiers changed from: private */
    public volatile boolean dDe = false;
    private volatile boolean dDf = false;
    /* access modifiers changed from: private */
    public MediaGroupItem dDg = new MediaGroupItem();
    /* access modifiers changed from: private */
    public List<ExtMediaItem> dDh;
    /* access modifiers changed from: private */
    public List<ExtMediaItem> dDi;
    /* access modifiers changed from: private */
    public ExecutorService executorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Handler mHandler = new C7181b(this);

    /* renamed from: com.introvd.template.explorer.d.b$a */
    class C7180a {
        public String ceO;
        public int dDq;
        public int mHeight;
        public int mWidth;

        public C7180a(int i, int i2, String str, int i3) {
            this.mHeight = i;
            this.mWidth = i2;
            this.ceO = str;
            this.dDq = i3;
        }
    }

    /* renamed from: com.introvd.template.explorer.d.b$b */
    private static class C7181b extends Handler {
        private final WeakReference<C7163b> bNh;

        public C7181b(C7163b bVar) {
            this.bNh = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C7163b bVar = (C7163b) this.bNh.get();
            int i = message.what;
            switch (i) {
                case 4097:
                    C4586g.m11704a((Context) (Activity) message.obj, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null, true);
                    return;
                case 4098:
                    Activity activity = (Activity) message.obj;
                    if (activity != null && !activity.isFinishing()) {
                        C4586g.m11696Sm();
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case 5889:
                            bVar.getAlbums((Activity) message.obj, bVar.dDc);
                            return;
                        case 5890:
                            bVar.getMediaData((Activity) message.obj, bVar.dDb, bVar.dDc);
                            return;
                        case 5891:
                            bVar.axR();
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m21204a(com.eiii.GraphResponse r24, java.lang.String r25, com.introvd.template.common.MSize r26, android.app.Activity r27) {
        /*
            r23 = this;
            r7 = r23
            r8 = r25
            r9 = r26
            r10 = r27
            java.util.Map<java.lang.String, java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem>> r0 = dCS
            java.lang.Object r0 = r0.get(r8)
            java.util.List r0 = (java.util.List) r0
            r7.dDi = r0
            java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r7.dDi
            if (r0 != 0) goto L_0x001d
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.dDi = r0
        L_0x001d:
            r0 = 0
            if (r24 == 0) goto L_0x0026
            org.json.JSONObject r1 = r24.getJSONObject()
            r11 = r1
            goto L_0x0027
        L_0x0026:
            r11 = r0
        L_0x0027:
            if (r11 == 0) goto L_0x002f
            java.lang.String r0 = "data"
            org.json.JSONArray r0 = r11.optJSONArray(r0)
        L_0x002f:
            r12 = r0
            if (r12 == 0) goto L_0x0130
            r14 = 0
        L_0x0033:
            int r0 = r12.length()
            if (r14 >= r0) goto L_0x0130
            org.json.JSONObject r0 = r12.getJSONObject(r14)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "id"
            java.lang.String r15 = r0.optString(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "name"
            java.lang.String r6 = r0.optString(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "picture"
            java.lang.String r5 = r0.optString(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "created_time"
            java.lang.String r16 = r0.optString(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "images"
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x0113
            java.util.List<com.introvd.template.explorer.d.b$a> r1 = r7.dCQ     // Catch:{ Exception -> 0x0116 }
            r1.clear()     // Catch:{ Exception -> 0x0116 }
            r4 = 0
        L_0x0063:
            int r1 = r0.length()     // Catch:{ Exception -> 0x0116 }
            if (r4 >= r1) goto L_0x00a6
            org.json.JSONObject r1 = r0.getJSONObject(r4)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = "height"
            int r3 = r1.getInt(r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = "width"
            int r17 = r1.getInt(r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = "source"
            java.lang.String r18 = r1.getString(r2)     // Catch:{ Exception -> 0x0116 }
            com.introvd.template.explorer.d.b$a r2 = new com.introvd.template.explorer.d.b$a     // Catch:{ Exception -> 0x0116 }
            int r19 = r3 * r17
            r1 = r2
            r13 = r2
            r2 = r23
            r20 = r4
            r4 = r17
            r21 = r0
            r0 = r5
            r5 = r18
            r22 = r12
            r12 = r6
            r6 = r19
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x0111 }
            java.util.List<com.introvd.template.explorer.d.b$a> r1 = r7.dCQ     // Catch:{ Exception -> 0x0111 }
            r1.add(r13)     // Catch:{ Exception -> 0x0111 }
            int r4 = r20 + 1
            r5 = r0
            r6 = r12
            r0 = r21
            r12 = r22
            goto L_0x0063
        L_0x00a6:
            r0 = r5
            r22 = r12
            r12 = r6
            int r1 = r9.height     // Catch:{ Exception -> 0x0111 }
            int r2 = r9.width     // Catch:{ Exception -> 0x0111 }
            int r1 = r1 * r2
            java.util.List<com.introvd.template.explorer.d.b$a> r2 = r7.dCQ     // Catch:{ Exception -> 0x0111 }
            int r1 = r7.m21220j(r1, r2)     // Catch:{ Exception -> 0x0111 }
            java.util.List<com.introvd.template.explorer.d.b$a> r2 = r7.dCQ     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.explorer.d.b$a r2 = (com.introvd.template.explorer.p299d.C7163b.C7180a) r2     // Catch:{ Exception -> 0x0111 }
            java.lang.String r2 = r2.ceO     // Catch:{ Exception -> 0x0111 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0111 }
            r3.<init>()     // Catch:{ Exception -> 0x0111 }
            java.util.List<com.introvd.template.explorer.d.b$a> r4 = r7.dCQ     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.explorer.d.b$a r4 = (com.introvd.template.explorer.p299d.C7163b.C7180a) r4     // Catch:{ Exception -> 0x0111 }
            int r4 = r4.mHeight     // Catch:{ Exception -> 0x0111 }
            r3.append(r4)     // Catch:{ Exception -> 0x0111 }
            java.lang.String r4 = "*"
            r3.append(r4)     // Catch:{ Exception -> 0x0111 }
            java.util.List<com.introvd.template.explorer.d.b$a> r4 = r7.dCQ     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.explorer.d.b$a r1 = (com.introvd.template.explorer.p299d.C7163b.C7180a) r1     // Catch:{ Exception -> 0x0111 }
            int r1 = r1.mWidth     // Catch:{ Exception -> 0x0111 }
            r3.append(r1)     // Catch:{ Exception -> 0x0111 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.videoeditor.model.ExtMediaItem r3 = new com.introvd.template.videoeditor.model.ExtMediaItem     // Catch:{ Exception -> 0x0111 }
            r3.<init>()     // Catch:{ Exception -> 0x0111 }
            r3.title = r15     // Catch:{ Exception -> 0x0111 }
            r3.path = r2     // Catch:{ Exception -> 0x0111 }
            r3.resolution = r1     // Catch:{ Exception -> 0x0111 }
            long r1 = m21222jo(r16)     // Catch:{ Exception -> 0x0111 }
            r3.date = r1     // Catch:{ Exception -> 0x0111 }
            r3.artist = r12     // Catch:{ Exception -> 0x0111 }
            r3.album = r8     // Catch:{ Exception -> 0x0111 }
            r1 = 0
            r3.lFlag = r1     // Catch:{ Exception -> 0x0111 }
            r3.thumbUrl = r0     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.sns.MediaType r0 = com.introvd.template.sns.MediaType.MEDIA_TYPE_IMAGE     // Catch:{ Exception -> 0x0111 }
            r3.mediaType = r0     // Catch:{ Exception -> 0x0111 }
            com.introvd.template.sns.SnsType r0 = com.introvd.template.sns.SnsType.SNS_TYPE_FACEBOOK     // Catch:{ Exception -> 0x0111 }
            r3.snsType = r0     // Catch:{ Exception -> 0x0111 }
            java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r7.dDi     // Catch:{ Exception -> 0x0111 }
            r0.add(r3)     // Catch:{ Exception -> 0x0111 }
            goto L_0x012a
        L_0x0111:
            r0 = move-exception
            goto L_0x0119
        L_0x0113:
            r22 = r12
            goto L_0x012a
        L_0x0116:
            r0 = move-exception
            r22 = r12
        L_0x0119:
            com.introvd.template.sns.gallery.SnsGalleryInfoListener r1 = r7.dCP
            if (r1 == 0) goto L_0x0127
            android.os.Handler r1 = r7.mHandler
            com.introvd.template.explorer.d.b$7 r2 = new com.introvd.template.explorer.d.b$7
            r2.<init>()
            r1.post(r2)
        L_0x0127:
            r0.printStackTrace()
        L_0x012a:
            int r14 = r14 + 1
            r12 = r22
            goto L_0x0033
        L_0x0130:
            java.lang.String r0 = "paging"
            org.json.JSONObject r0 = com.introvd.template.explorer.p299d.C7190g.m21252c(r11, r0)
            java.lang.String r1 = "next"
            java.lang.String r1 = com.introvd.template.explorer.p299d.C7190g.m21251b(r0, r1)
            java.lang.String r2 = "cursors"
            org.json.JSONObject r0 = com.introvd.template.explorer.p299d.C7190g.m21252c(r0, r2)
            java.lang.String r2 = "after"
            java.lang.String r0 = com.introvd.template.explorer.p299d.C7190g.m21251b(r0, r2)
            com.introvd.template.sns.gallery.SnsGalleryInfoListener r2 = r7.dCP
            if (r2 == 0) goto L_0x018c
            java.util.Map<java.lang.String, java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem>> r2 = dCS
            boolean r2 = r2.containsKey(r8)
            if (r2 != 0) goto L_0x016a
            java.util.Map<java.lang.String, java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem>> r2 = dCS
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem> r4 = r7.dDi
            r3.<init>(r4)
            r2.put(r8, r3)
            java.util.concurrent.ExecutorService r2 = r7.executorService
            com.introvd.template.explorer.d.b$8 r3 = new com.introvd.template.explorer.d.b$8
            r3.<init>()
            r2.execute(r3)
        L_0x016a:
            java.util.List<com.introvd.template.videoeditor.model.ExtMediaItem> r2 = r7.dDi
            if (r2 != 0) goto L_0x0175
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r7.dDi = r2
        L_0x0175:
            android.os.Handler r2 = r7.mHandler
            com.introvd.template.explorer.d.b$9 r3 = new com.introvd.template.explorer.d.b$9
            r3.<init>()
            r2.post(r3)
            android.os.Handler r2 = r7.mHandler
            android.os.Handler r3 = r7.mHandler
            r4 = 4098(0x1002, float:5.743E-42)
            android.os.Message r3 = r3.obtainMessage(r4, r10)
            r2.sendMessage(r3)
        L_0x018c:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x01ad
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01ad
            boolean r2 = r7.dDe
            if (r2 != 0) goto L_0x01ad
            r7.dCX = r1
            r7.dCY = r0
            android.os.Handler r0 = r7.mHandler
            android.os.Handler r1 = r7.mHandler
            r2 = 5890(0x1702, float:8.254E-42)
            android.os.Message r1 = r1.obtainMessage(r2, r10)
            r0.sendMessage(r1)
        L_0x01ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p299d.C7163b.m21204a(com.eiii.GraphResponse, java.lang.String, com.introvd.template.common.MSize, android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21210c(final MediaGroupItem mediaGroupItem) {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Bundle bundle = new Bundle();
        bundle.putString("fields", "picture");
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(mediaGroupItem.coverPhotoUrl);
        GraphRequest graphRequest = new GraphRequest(currentAccessToken, sb.toString(), bundle, null, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (graphResponse != null) {
                    try {
                        if (graphResponse.getJSONObject() != null) {
                            JSONObject jSONObject = new JSONObject(graphResponse.getJSONObject().toString());
                            mediaGroupItem.coverPhotoUrl = jSONObject.optString("picture");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        if (C7163b.this.dCP != null) {
                            C7163b.this.mHandler.post(new Runnable() {
                                public void run() {
                                    C7163b.this.dCP.onSyncAlbumsError();
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                if (C7163b.this.dCP != null) {
                    C7163b.this.mHandler.post(new Runnable() {
                        public void run() {
                            C7163b.this.dCP.onSyncAlbumsSuccess(C7163b.this.dCR);
                        }
                    });
                }
            }
        });
        graphRequest.executeAsync();
    }

    /* renamed from: h */
    private boolean m21217h(MSize mSize) {
        boolean z = false;
        if (mSize == null) {
            return false;
        }
        if (!(this.dDd != null && this.dDd.width == mSize.width && this.dDd.height == mSize.height)) {
            z = true;
            this.dDd = this.dDc;
            this.dDc = mSize;
        }
        return z;
    }

    /* renamed from: j */
    private int m21220j(int i, List<C7180a> list) {
        int i2 = 0;
        int abs = Math.abs(((C7180a) list.get(0)).dDq - i);
        for (int i3 = 1; i3 < list.size(); i3++) {
            int abs2 = Math.abs(((C7180a) list.get(i3)).dDq - i);
            if (abs2 < abs) {
                i2 = i3;
                abs = abs2;
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: jo */
    public static long m21222jo(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.parse(str).getTime();
    }

    public void axR() {
        this.dDe = false;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id, length, picture, created_time, source");
        bundle.putString("type", "uploaded");
        if (TextUtils.isEmpty(this.dCV) || TextUtils.isEmpty(this.dCW)) {
            this.ckD.clear();
        } else {
            bundle.putString("after", this.dCW);
            this.dCV = "";
        }
        GraphRequest graphRequest = new GraphRequest(currentAccessToken, "/me/videos", bundle, null, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            String optString2 = jSONObject2.optString("picture");
                            int optInt = jSONObject2.optInt("length");
                            String optString3 = jSONObject2.optString("source");
                            String optString4 = jSONObject2.optString("created_time");
                            ExtMediaItem extMediaItem = new ExtMediaItem();
                            extMediaItem.thumbUrl = optString2;
                            extMediaItem.path = optString3;
                            extMediaItem.title = optString;
                            extMediaItem.duration = (long) (optInt * 1000);
                            extMediaItem.mediaType = MediaType.MEDIA_TYPE_VIDEO;
                            extMediaItem.snsType = SnsType.SNS_TYPE_FACEBOOK;
                            extMediaItem.album = "9999";
                            extMediaItem.date = C7163b.m21222jo(optString4);
                            extMediaItem.lFlag = 0;
                            C7163b.this.ckD.add(extMediaItem);
                        }
                    }
                    if (C7163b.this.ckD != null && C7163b.this.ckD.size() > 0) {
                        if (!C7163b.this.dCR.contains(C7163b.this.dDg)) {
                            C7163b.this.dDg.coverPhotoUrl = ((ExtMediaItem) C7163b.this.ckD.get(0)).thumbUrl;
                            C7163b.this.dDg.countForSns = C7163b.this.ckD.size();
                            C7163b.this.dDg.strGroupDisplayName = "videos";
                            C7163b.this.dDg.mediaItemList = C7163b.this.ckD;
                            C7163b.this.dDg.albumId = "9999";
                            C7163b.this.dDg.mediaType = MediaType.MEDIA_TYPE_VIDEO;
                            C7163b.this.dCR.add(C7163b.this.dDg);
                        } else {
                            C7163b.this.dDg.countForSns = C7163b.this.ckD.size();
                        }
                    }
                    if (C7163b.this.dCP != null) {
                        if (C7163b.this.executorService != null) {
                            C7163b.this.executorService.execute(new Runnable() {
                                public void run() {
                                    C7157a.m21187g(28, C7163b.this.dCR);
                                }
                            });
                        }
                        C7163b.this.mHandler.post(new Runnable() {
                            public void run() {
                                C7163b.this.dCP.onSyncAlbumsSuccess(C7163b.this.dCR);
                            }
                        });
                    }
                    JSONObject c = C7190g.m21252c(jSONObject, "paging");
                    String b = C7190g.m21251b(c, "next");
                    String b2 = C7190g.m21251b(C7190g.m21252c(c, "cursors"), "after");
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(b2) && !C7163b.this.dDe) {
                        C7163b.this.dCV = b;
                        C7163b.this.dCW = b2;
                        C7163b.this.mHandler.sendEmptyMessage(5891);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        graphRequest.executeAsync();
    }

    public void getAlbums(final Activity activity, MSize mSize) {
        boolean z = false;
        this.dDe = false;
        this.dDf = C4600l.m11739k(activity, false);
        if (TextUtils.isEmpty(C7157a.dCE)) {
            C7157a.dCE = AccessToken.getCurrentAccessToken().getUserId();
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4097, activity));
        if (!this.dDf) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_network_inactive, 1);
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Bundle bundle = new Bundle();
        bundle.putString("fields", "cover_photo,privacy,name,id,count,type,created_time");
        if (!TextUtils.isEmpty(this.dCT) && !TextUtils.isEmpty(this.dCU)) {
            bundle.putString("after", this.dCU);
            this.dCT = "";
            z = true;
        }
        if (this.dDf && (C7190g.m21249ae(activity, 28) || m21217h(mSize) || z || this.dCR == null || this.dCR.size() < 1)) {
            if (this.dCZ && !z) {
                axR();
            }
            dCS.clear();
            if (this.dCR != null && !z) {
                this.dCR.clear();
            }
            GraphRequest graphRequest = new GraphRequest(currentAccessToken, "/me/albums", bundle, HttpMethod.GET, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    C7190g.m21248a((Context) activity, true, 28, (C7188e) null, true);
                    if (graphResponse != null) {
                        try {
                            if (graphResponse.getJSONObject() != null) {
                                JSONObject jSONObject = new JSONObject(graphResponse.getJSONObject().toString());
                                JSONArray jSONArray = jSONObject.getJSONArray("data");
                                for (int i = 0; i < jSONArray.length() && C7163b.this.dDa; i++) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                    String optString = jSONObject2.optString("id");
                                    String optString2 = jSONObject2.optString("name");
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("cover_photo");
                                    int optInt = jSONObject2.optInt(SocialConstDef.SEARCH_HISTORY_COUNT);
                                    String optString3 = jSONObject2.optString("created_time");
                                    if (optInt > 0 && optJSONObject != null) {
                                        String optString4 = optJSONObject.optString("id");
                                        MediaGroupItem mediaGroupItem = new MediaGroupItem();
                                        mediaGroupItem.coverPhotoUrl = optString4;
                                        mediaGroupItem.countForSns = optInt;
                                        mediaGroupItem.albumId = optString;
                                        mediaGroupItem.strGroupDisplayName = optString2;
                                        mediaGroupItem.strParentPath = "/net";
                                        mediaGroupItem.mediaType = MediaType.MEDIA_TYPE_IMAGE;
                                        mediaGroupItem.lGroupTimestamp = C7163b.m21222jo(optString3);
                                        C7163b.this.dCR.add(mediaGroupItem);
                                        C7163b.this.m21210c(mediaGroupItem);
                                    }
                                }
                                if (C7163b.this.dCP != null) {
                                    C7163b.this.mHandler.post(new Runnable() {
                                        public void run() {
                                            C7163b.this.dCP.onSyncAlbumsSuccess(C7163b.this.dCR);
                                        }
                                    });
                                    if (C7163b.this.executorService != null) {
                                        C7163b.this.executorService.execute(new Runnable() {
                                            public void run() {
                                                C7157a.m21187g(28, C7163b.this.dCR);
                                            }
                                        });
                                    }
                                }
                                JSONObject c = C7190g.m21252c(jSONObject, "paging");
                                String b = C7190g.m21251b(c, "next");
                                String b2 = C7190g.m21251b(C7190g.m21252c(c, "cursors"), "after");
                                if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(b2) && !C7163b.this.dDe) {
                                    C7163b.this.dCT = b;
                                    C7163b.this.dCU = b2;
                                    C7163b.this.mHandler.sendMessage(C7163b.this.mHandler.obtainMessage(5889, activity));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (C7163b.this.dCP != null) {
                                C7163b.this.mHandler.post(new Runnable() {
                                    public void run() {
                                        C7163b.this.dCP.onSyncAlbumsError();
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(C7163b.this.dCT)) {
                        C7163b.this.mHandler.sendMessage(C7163b.this.mHandler.obtainMessage(4098, activity));
                        C7190g.m21248a((Context) activity, true, 28, (C7188e) null, true);
                    }
                }
            });
            graphRequest.executeAsync();
        } else if (this.dCP != null) {
            if (this.dCR == null || this.dCR.size() < 1) {
                this.dCR = C7157a.m21191qW(28);
            }
            if (this.dCR == null) {
                this.dCR = new ArrayList();
            }
            this.mHandler.post(new Runnable() {
                public void run() {
                    C7163b.this.dCP.onSyncAlbumsSuccess(C7163b.this.dCR);
                }
            });
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, activity));
        }
    }

    public synchronized void getMediaData(final Activity activity, final String str, final MSize mSize) {
        boolean z = false;
        this.dDe = false;
        this.dDb = str;
        this.dDc = mSize;
        if (TextUtils.isEmpty(C7157a.dCE)) {
            C7157a.dCE = AccessToken.getCurrentAccessToken().getUserId();
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4097, activity));
        this.dDf = C4600l.m11739k(activity, false);
        if (!this.dDf) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_network_inactive, 1);
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(str);
        sb.append("/photos");
        String sb2 = sb.toString();
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id, created_time, name, picture, images");
        if (!TextUtils.isEmpty(this.dCX) && !TextUtils.isEmpty(this.dCY)) {
            bundle.putString("after", this.dCY);
            this.dCX = "";
            z = true;
        }
        this.dDh = (List) dCS.get(str);
        if ((this.dDh == null || this.dDh.size() <= 0 || z) && this.dDf) {
            GraphRequest graphRequest = new GraphRequest(currentAccessToken, sb2, bundle, null, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    C7163b.this.m21204a(graphResponse, str, mSize, activity);
                }
            });
            graphRequest.executeAsync();
        } else if (this.dCP != null) {
            if (dCS == null || dCS.size() < 1) {
                dCS = C7157a.m21192qX(28);
            }
            if (dCS == null) {
                dCS = new HashMap();
            }
            this.dDh = (List) dCS.get(str);
            if (this.dDh == null) {
                this.dDh = new ArrayList();
            }
            this.mHandler.post(new Runnable() {
                public void run() {
                    C7163b.this.dCP.onSyncMediaDataSuccess(C7163b.this.dDh);
                }
            });
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, activity));
        }
    }

    public void setSnsGalleryInfoListener(SnsGalleryInfoListener snsGalleryInfoListener) {
        this.dCP = snsGalleryInfoListener;
    }

    public void stopFectchData() {
        this.dDe = true;
    }

    public void updateShowMode(int i) {
        switch (i) {
            case ISnsGallery.BOTH_MODE /*5632*/:
                this.dCZ = true;
                this.dDa = true;
                return;
            case ISnsGallery.VIDEO_MODE /*5633*/:
                this.dDa = false;
                this.dCZ = true;
                return;
            case ISnsGallery.IMAGE_MODE /*5634*/:
                this.dDa = true;
                this.dCZ = false;
                return;
            default:
                return;
        }
    }
}
