package com.introvd.template.template.download;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p407e.C8735f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.template.download.e */
public class C8705e {
    private static C8705e elR;
    /* access modifiers changed from: private */
    public C8692b bMP = null;
    private Context bbr = null;
    private C8706a elQ = null;
    private volatile List<C8707b> mListeners;

    /* renamed from: com.introvd.template.template.download.e$a */
    private static class C8706a extends WeakHandler<C8705e> {
        public C8706a(C8705e eVar) {
            super(eVar);
        }

        public void handleMessage(Message message) {
            C8705e eVar = (C8705e) getOwner();
            if (eVar != null) {
                C8692b a = eVar.bMP;
                switch (message.what) {
                    case 4097:
                        switch (message.arg1) {
                            case 65281:
                                eVar.aKx();
                                break;
                            case 65283:
                                if (message.arg2 != 131072) {
                                    eVar.aKy();
                                    break;
                                } else {
                                    eVar.m25371pk((String) message.obj);
                                    break;
                                }
                        }
                    case 4098:
                    case 4101:
                        Bundle data = message.getData();
                        String string = data.getString("ttid");
                        if (TextUtils.isEmpty(string)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(data.getLong("ttid"));
                            sb.append("");
                            string = sb.toString();
                        }
                        int i = message.arg2;
                        switch (message.arg1) {
                            case 65281:
                                eVar.m25370pj(string);
                                break;
                            case 65282:
                                eVar.m25359Q(string, i);
                                break;
                            case 65283:
                                if (message.arg2 != 131072) {
                                    if (message.arg2 != 65536 && message.arg2 != 458752) {
                                        if (message.arg2 == 327680) {
                                            eVar.mo35083pi(string);
                                            break;
                                        }
                                    } else {
                                        eVar.m25374pn(string);
                                        break;
                                    }
                                } else if (a != null) {
                                    if (message.what == 4101) {
                                        message.getData().putString("RollId", string);
                                    }
                                    a.mo35059a((String) message.obj, 4099, (String) null, message.getData());
                                    eVar.m25372pl(string);
                                    break;
                                }
                                break;
                        }
                    case 4099:
                        Bundle data2 = message.getData();
                        String string2 = data2.getString("ttid");
                        if (TextUtils.isEmpty(string2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(data2.getLong("ttid"));
                            sb2.append("");
                            string2 = sb2.toString();
                        }
                        int i2 = message.arg2;
                        switch (message.arg1) {
                            case 65282:
                                eVar.m25359Q(string2, ((message.arg2 * 10) / 100) + 90);
                                break;
                            case 65283:
                                if (message.arg2 != 131072) {
                                    eVar.m25374pn(string2);
                                    break;
                                } else {
                                    eVar.m25359Q(string2, 100);
                                    eVar.m25373pm(string2);
                                    break;
                                }
                        }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.template.download.e$b */
    public interface C8707b {
        void arB();

        void arC();

        /* renamed from: iA */
        void mo30336iA(String str);

        /* renamed from: iB */
        void mo30337iB(String str);

        /* renamed from: iC */
        void mo30338iC(String str);

        /* renamed from: ix */
        void mo30340ix(String str);

        /* renamed from: iy */
        void mo30341iy(String str);

        /* renamed from: iz */
        void mo30342iz(String str);

        /* renamed from: w */
        void mo30344w(String str, int i);
    }

    private C8705e(Context context) {
        this.bbr = context.getApplicationContext();
        this.elQ = new C8706a(this);
        this.bMP = new C8692b(context.getApplicationContext(), this.elQ);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m25359Q(String str, int i) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30344w(str, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void aKx() {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.arB();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void aKy() {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.arC();
                }
            }
        }
    }

    /* renamed from: gZ */
    public static C8705e m25369gZ(Context context) {
        if (elR == null) {
            elR = new C8705e(context);
        }
        return elR;
    }

    /* access modifiers changed from: private */
    /* renamed from: pj */
    public void m25370pj(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30341iy(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pk */
    public void m25371pk(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30340ix(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pl */
    public void m25372pl(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30342iz(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pm */
    public void m25373pm(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30336iA(str);
                }
            }
        }
        C8735f.aMf().mo35153qn(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: pn */
    public void m25374pn(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30337iB(str);
                }
            }
        }
        C8735f.aMf().mo35153qn(str);
    }

    /* renamed from: po */
    private void m25375po(String str) {
        if (this.mListeners != null) {
            for (C8707b bVar : this.mListeners) {
                if (bVar != null) {
                    bVar.mo30338iC(str);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo35078a(EffectInfoModel effectInfoModel, String str) {
        long j = effectInfoModel.mTemplateId;
        String str2 = effectInfoModel.mName;
        Bundle bundle = new Bundle();
        bundle.putLong("ttid", j);
        String str3 = "";
        if (!TextUtils.isEmpty(effectInfoModel.getmUrl())) {
            str3 = C4605o.getHost(effectInfoModel.getmUrl());
            bundle.putString(C7234b.TAG, effectInfoModel.getmUrl());
        }
        int i = 4098;
        if ("type_roll".equals(str)) {
            i = 4101;
        }
        int a = this.bMP.mo35058a(j, i, bundle);
        String bn = C8450a.m24469bn(j);
        UserEventDurationRelaUtils.startDurationEvent(bn, a, str3);
        UserEventDurationRelaUtils.dummyXytDownloadStartEvent(this.bbr, str2, str, bn);
    }

    /* renamed from: a */
    public void mo35079a(C8707b bVar) {
        if (this.mListeners == null) {
            this.mListeners = new CopyOnWriteArrayList();
        }
        this.mListeners.add(bVar);
    }

    /* renamed from: b */
    public void mo35080b(C8707b bVar) {
        if (this.mListeners != null) {
            int indexOf = this.mListeners.indexOf(bVar);
            if (indexOf >= 0) {
                this.mListeners.remove(indexOf);
            }
        }
    }

    /* renamed from: b */
    public void mo35081b(String str, String str2, String str3, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("ttid", str);
        String str4 = "";
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString(C7234b.TAG, str3);
            str4 = Uri.parse(str3).getHost();
        }
        String str5 = str4;
        this.bMP.mo35060a(str, str2, 4098, (String) null, bundle);
        UserEventDurationRelaUtils.startDurationEvent(str, i, str5);
    }

    /* renamed from: ph */
    public void mo35082ph(String str) {
        this.bMP.mo35061a(str, (String) null, 4097, 5, (String) null);
    }

    /* renamed from: pi */
    public void mo35083pi(String str) {
        if (this.bMP != null) {
            this.bMP.mo35067pg(str);
            m25375po(str);
        }
    }

    /* renamed from: y */
    public void mo35084y(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("ttid", str);
        bundle.putString(C7234b.TAG, str3);
        this.bMP.mo35060a(str, str2, 4101, (String) null, bundle);
    }
}
