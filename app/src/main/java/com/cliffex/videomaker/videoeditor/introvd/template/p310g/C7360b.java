package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.R;

/* renamed from: com.introvd.template.g.b */
public class C7360b extends C7353a {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final RelativeLayout coO;

    static {
        bqa.put(R.id.edittext_ip, 1);
        bqa.put(R.id.btn_apply_ip, 2);
        bqa.put(R.id.edittext_snsflag, 3);
        bqa.put(R.id.btn_snsflag_apply, 4);
        bqa.put(R.id.edittext_appkey, 5);
        bqa.put(R.id.btn_apply_appkey, 6);
        bqa.put(R.id.btn_cursp, 7);
        bqa.put(R.id.btn_getsp, 8);
        bqa.put(R.id.btn_mediacheck, 9);
        bqa.put(R.id.btn_apply_abtest_value, 10);
        bqa.put(R.id.editTextABTest, 11);
        bqa.put(R.id.btn_apk_info, 12);
        bqa.put(R.id.btn_update_quality_param, 13);
        bqa.put(R.id.setConfigParam, 14);
        bqa.put(R.id.btn_export_key_path, 15);
        bqa.put(R.id.btn_monitor_setting, 16);
        bqa.put(R.id.btn_copy_db, 17);
        bqa.put(R.id.et_set_younger_time, 18);
        bqa.put(R.id.btn_set_younger_time, 19);
        bqa.put(R.id.logger_event_to_web, 20);
        bqa.put(R.id.logger_event_to_web_hint, 21);
        bqa.put(R.id.ad_log_cb, 22);
        bqa.put(R.id.faker_google_channel_cb, 23);
        bqa.put(R.id.force_show_logo_watermark_cb, 24);
        bqa.put(R.id.txtview_appstate, 25);
    }

    public C7360b(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 26, bpZ, bqa));
    }

    private C7360b(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[22], objArr[12], objArr[10], objArr[6], objArr[2], objArr[17], objArr[7], objArr[15], objArr[8], objArr[9], objArr[16], objArr[19], objArr[4], objArr[13], objArr[11], objArr[5], objArr[1], objArr[3], objArr[18], objArr[23], objArr[24], objArr[20], objArr[21], objArr[14], objArr[25]);
        this.bqb = -1;
        this.coO = objArr[0];
        this.coO.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.bqb;
            this.bqb = 0;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 1;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
