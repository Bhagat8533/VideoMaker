package com.aiii.android.arouter.p093e;

import android.text.TextUtils;
import android.util.Log;
import com.aiii.android.arouter.facade.template.C1948b;
import com.ironsource.sdk.constants.Constants.RequestParameters;

/* renamed from: com.aiii.android.arouter.e.b */
public class C1937b implements C1948b {
    private static boolean atX;
    private static boolean atY;
    private static boolean atZ;
    private String aua = "ARouter";

    public C1937b() {
    }

    public C1937b(String str) {
        this.aua = str;
    }

    /* renamed from: a */
    public static String m5565a(StackTraceElement stackTraceElement) {
        String str = " & ";
        StringBuilder sb = new StringBuilder(RequestParameters.LEFT_BRACKETS);
        if (atY) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb.append("ThreadId=");
            sb.append(id);
            sb.append(str);
            sb.append("ThreadName=");
            sb.append(name);
            sb.append(str);
            sb.append("FileName=");
            sb.append(fileName);
            sb.append(str);
            sb.append("ClassName=");
            sb.append(className);
            sb.append(str);
            sb.append("MethodName=");
            sb.append(methodName);
            sb.append(str);
            sb.append("LineNumber=");
            sb.append(lineNumber);
        }
        sb.append(" ] ");
        return sb.toString();
    }

    /* renamed from: aH */
    public void mo10376aH(boolean z) {
        atX = z;
    }

    /* renamed from: g */
    public void mo10377g(String str, String str2) {
        if (atX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = mo10381sl();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m5565a(stackTraceElement));
            Log.d(str, sb.toString());
        }
    }

    /* renamed from: h */
    public void mo10378h(String str, String str2) {
        if (atX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = mo10381sl();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m5565a(stackTraceElement));
            Log.i(str, sb.toString());
        }
    }

    /* renamed from: j */
    public void mo10379j(String str, String str2) {
        if (atX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = mo10381sl();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m5565a(stackTraceElement));
            Log.w(str, sb.toString());
        }
    }

    /* renamed from: k */
    public void mo10380k(String str, String str2) {
        if (atX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = mo10381sl();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m5565a(stackTraceElement));
            Log.e(str, sb.toString());
        }
    }

    /* renamed from: sl */
    public String mo10381sl() {
        return this.aua;
    }
}
