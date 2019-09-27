package com.introvd.template.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ToastUtils {
    static Toast bql = null;
    static String ccP = "";
    static WeakReference<Thread> ccQ;
    private static boolean ccR;

    /* renamed from: com.introvd.template.common.ToastUtils$a */
    private static class C5232a extends Handler {
        private Object ccS;
        private Method ccT;
        private Method ccU;

        C5232a(Object obj) {
            this.ccS = obj;
            try {
                this.ccT = obj.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});
                this.ccT.setAccessible(true);
                this.ccU = obj.getClass().getDeclaredMethod("handleHide", new Class[0]);
                this.ccU.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    IBinder iBinder = (IBinder) message.obj;
                    if (this.ccT != null) {
                        try {
                            this.ccT.invoke(this.ccS, new Object[]{iBinder});
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                            break;
                        } catch (BadTokenException e3) {
                            e3.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.ccU != null) {
                        try {
                            this.ccU.invoke(this.ccS, new Object[0]);
                            break;
                        } catch (IllegalAccessException e4) {
                            e4.printStackTrace();
                            break;
                        } catch (InvocationTargetException e5) {
                            e5.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (this.ccU != null) {
                        try {
                            this.ccU.invoke(this.ccS, new Object[0]);
                            break;
                        } catch (IllegalAccessException e6) {
                            e6.printStackTrace();
                            break;
                        } catch (InvocationTargetException e7) {
                            e7.printStackTrace();
                            break;
                        }
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    private static void m14265a(Toast toast) {
        int i = VERSION.SDK_INT;
        if (i >= 24 && i < 26 && !ccR) {
            m14266b(toast);
            ccR = true;
        }
    }

    /* renamed from: b */
    private static void m14266b(Toast toast) {
        try {
            Field declaredField = toast.getClass().getDeclaredField("mTN");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                Object obj = declaredField.get(toast);
                if (obj != null) {
                    Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                        declaredField2.set(obj, new C5232a(obj));
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void longShow(Context context, int i) {
        if (context != null) {
            try {
                show(context, context.getString(i), 1, 17);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void longShow(Context context, String str) {
        if (context != null) {
            show(context, str, 1, 17);
        }
    }

    public static void shortShow(Context context, int i) {
        if (context != null) {
            try {
                show(context, context.getString(i), 0, 17);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void shortShow(Context context, String str) {
        if (context != null) {
            show(context, str, 0, 17);
        }
    }

    public static void show(Context context, int i, int i2) {
        if (context != null) {
            try {
                String string = context.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    show(context, string, i2, 17);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void show(Context context, String str, int i) {
        show(context, str, i, 17);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A[Catch:{ Exception -> 0x0043 }] */
    @android.annotation.SuppressLint({"ShowToast"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void show(android.content.Context r2, java.lang.String r3, int r4, int r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            ccP = r3     // Catch:{ Exception -> 0x0043 }
            android.widget.Toast r1 = bql     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x0024
            java.lang.ref.WeakReference<java.lang.Thread> r1 = ccQ     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x0024
            java.lang.ref.WeakReference<java.lang.Thread> r1 = ccQ     // Catch:{ Exception -> 0x0043 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0043 }
            if (r1 == r0) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x0043 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0033
        L_0x0024:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0043 }
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r4)     // Catch:{ Exception -> 0x0043 }
            bql = r2     // Catch:{ Exception -> 0x0043 }
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x0043 }
            m14265a(r2)     // Catch:{ Exception -> 0x0043 }
        L_0x0033:
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x0043 }
            if (r2 == 0) goto L_0x0047
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x0043 }
            r3 = 0
            r2.setGravity(r5, r3, r3)     // Catch:{ Exception -> 0x0043 }
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x0043 }
            r2.show()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0047:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r0)
            ccQ = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.ToastUtils.show(android.content.Context, java.lang.String, int, int):void");
    }
}
