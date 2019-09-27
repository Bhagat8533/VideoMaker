package com.introvd.template.systemevent;

import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* renamed from: com.introvd.template.systemevent.b */
public class C8605b extends FileObserver {
    String csh;
    C8606a ejV;
    Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.introvd.template.systemevent.b$a */
    public interface C8606a {
        /* renamed from: z */
        void mo34894z(int i, String str);
    }

    /* renamed from: com.introvd.template.systemevent.b$b */
    class C8607b implements Runnable {
        int ejW;
        String mPath;

        C8607b(int i, String str) {
            this.ejW = i;
            this.mPath = str;
        }

        public void run() {
            if (C8605b.this.ejV != null && !TextUtils.isEmpty(this.mPath)) {
                C8605b.this.ejV.mo34894z(this.ejW, this.mPath);
            }
        }
    }

    public C8605b(String str, C8606a aVar) {
        super(str, 3652);
        this.csh = str;
        this.ejV = aVar;
    }

    /* renamed from: oY */
    private String m25113oY(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null || str.length() <= 0) {
            stringBuffer.append(this.csh);
        } else {
            stringBuffer.append(this.csh);
            if ('/' != stringBuffer.charAt(stringBuffer.length() - 1)) {
                stringBuffer.append("/");
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public String getPath() {
        return this.csh;
    }

    public void onEvent(int i, String str) {
        if (this.csh != null && this.ejV != null) {
            this.mHandler.post(new C8607b(i, m25113oY(str)));
        }
    }
}
