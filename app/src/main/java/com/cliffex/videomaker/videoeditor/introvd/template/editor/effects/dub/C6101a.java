package com.introvd.template.editor.effects.dub;

import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.LogUtils;
import com.introvd.template.sdk.p381b.p382a.C8384a.C8385a;
import com.introvd.template.sdk.p381b.p382a.C8387c;
import java.util.Locale;
import p504io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.introvd.template.editor.effects.dub.a */
public class C6101a {
    private C8387c bPN = null;
    private long cKD = 0;

    private void akf() {
        C8385a aVar = new C8385a();
        aVar.set("audio-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(4)}));
        aVar.set("video-codec-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(0)}));
        aVar.set("audio-bitrate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(SettingsJsonConstants.SETTINGS_LOG_BUFFER_SIZE_DEFAULT)}));
        aVar.set("file-type", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(2)}));
        aVar.set("audio-channel-count", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(1)}));
        aVar.set("audio-sampling-rate", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE)}));
        aVar.set("audio-bits-persample", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(16)}));
        if (this.bPN != null) {
            this.bPN.mo33895a(aVar);
        }
    }

    public int akg() {
        init();
        this.bPN.stopRecording(true);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("end recording:");
        sb.append(currentTimeMillis - this.cKD);
        sb.append(", real file duration:");
        sb.append(getRecordDuration());
        LogUtils.m14222e("AudioRecorder", sb.toString());
        return 0;
    }

    public int getRecordDuration() {
        if (this.bPN == null) {
            return 0;
        }
        return this.bPN.getRecordDuration();
    }

    /* renamed from: hq */
    public int mo28858hq(String str) {
        init();
        if ((this.bPN.getState() & 4) != 0) {
            this.bPN.stopRecording(true);
        }
        this.bPN.mo33903nx(str);
        this.cKD = System.currentTimeMillis();
        LogUtils.m14222e("AudioRecorder", "start recording");
        this.bPN.mo33933jd(false);
        return 0;
    }

    public void init() {
        if (this.bPN == null) {
            this.bPN = new C8387c(null, -1, false);
            akf();
        }
    }

    public void unInit() {
        if (this.bPN != null) {
            this.bPN.aHw();
            this.bPN = null;
        }
    }
}
