package com.introvd.template.sdk.p381b;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import com.introvd.template.sdk.utils.C8554j;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.sdk.b.b */
public class C8392b {
    private static C8392b ebU;
    private int ebV;
    private CameraInfo[] ebW;
    private WeakReference<Camera> ebX = null;

    private C8392b() {
    }

    public static C8392b aHk() {
        if (ebU == null) {
            ebU = new C8392b();
        }
        return ebU;
    }

    /* renamed from: a */
    public void mo33943a(Camera camera) {
        this.ebX = new WeakReference<>(camera);
        if (camera != null) {
            this.ebV = Camera.getNumberOfCameras();
            this.ebW = new CameraInfo[this.ebV];
            for (int i = 0; i < this.ebV; i++) {
                this.ebW[i] = new CameraInfo();
                try {
                    Camera.getCameraInfo(i, this.ebW[i]);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public Camera aHl() {
        return (Camera) this.ebX.get();
    }

    public void autoFocus(AutoFocusCallback autoFocusCallback) {
        Camera camera = (Camera) this.ebX.get();
        if (camera != null) {
            try {
                camera.autoFocus(autoFocusCallback);
            } catch (Exception unused) {
            }
        }
    }

    public Parameters getParameters() {
        Parameters parameters;
        Camera camera = (Camera) this.ebX.get();
        if (camera == null) {
            return null;
        }
        try {
            parameters = camera.getParameters();
        } catch (Exception unused) {
            parameters = null;
        }
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        if (parameters != null && this.ebX != null) {
            Camera camera = (Camera) this.ebX.get();
            if (camera != null) {
                try {
                    camera.setParameters(parameters);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exception:");
                    sb.append(e.getMessage());
                    C8554j.m25007e("CameraMgr", sb.toString());
                }
            }
        }
    }
}
