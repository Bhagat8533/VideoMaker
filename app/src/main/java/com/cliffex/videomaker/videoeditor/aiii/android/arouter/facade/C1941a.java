package com.aiii.android.arouter.facade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p095b.C1944b;
import com.aiii.android.arouter.facade.template.C1949c;
import com.aiii.android.arouter.p091c.C1919a;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.aiii.android.arouter.facade.a */
public final class C1941a extends RouteMeta {
    private int atb;
    private C1949c atc;
    private boolean atd;
    private Bundle ate;
    private int enterAnim;
    private int exitAnim;
    private int flags;
    private Bundle mBundle;
    private Object tag;
    private Uri uri;

    public C1941a() {
        this(null, null);
    }

    public C1941a(String str, String str2) {
        this(str, str2, null, null);
    }

    public C1941a(String str, String str2, Uri uri2, Bundle bundle) {
        this.flags = -1;
        this.atb = 300;
        setPath(str);
        setGroup(str2);
        mo10397c(uri2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mBundle = bundle;
    }

    /* renamed from: H */
    public Object mo10382H(Context context) {
        return mo10392a(context, (C1944b) null);
    }

    /* renamed from: a */
    public C1941a mo10383a(C1949c cVar) {
        this.atc = cVar;
        return this;
    }

    /* renamed from: a */
    public C1941a mo10384a(String str, byte b) {
        this.mBundle.putByte(str, b);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10385a(String str, double d) {
        this.mBundle.putDouble(str, d);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10386a(String str, long j) {
        this.mBundle.putLong(str, j);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10387a(String str, Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10388a(String str, Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10389a(String str, ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10390a(String str, short s) {
        this.mBundle.putShort(str, s);
        return this;
    }

    /* renamed from: a */
    public C1941a mo10391a(String str, boolean z) {
        this.mBundle.putBoolean(str, z);
        return this;
    }

    /* renamed from: a */
    public Object mo10392a(Context context, C1944b bVar) {
        return C1919a.m5529sc().mo10354a(context, this, -1, bVar);
    }

    /* renamed from: a */
    public void mo10393a(Activity activity, int i, C1944b bVar) {
        C1919a.m5529sc().mo10354a(activity, this, i, bVar);
    }

    /* renamed from: aZ */
    public C1941a mo10394aZ(int i, int i2) {
        this.enterAnim = i;
        this.exitAnim = i2;
        return this;
    }

    /* renamed from: b */
    public C1941a mo10395b(String str, float f) {
        this.mBundle.putFloat(str, f);
        return this;
    }

    /* renamed from: b */
    public void mo10396b(Activity activity, int i) {
        mo10393a(activity, i, null);
    }

    /* renamed from: c */
    public C1941a mo10397c(Uri uri2) {
        this.uri = uri2;
        return this;
    }

    /* renamed from: dD */
    public C1941a mo10398dD(int i) {
        this.flags = i;
        return this;
    }

    /* renamed from: f */
    public C1941a mo10399f(String str, String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    /* renamed from: g */
    public C1941a mo10400g(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public Bundle getExtras() {
        return this.mBundle;
    }

    public int getFlags() {
        return this.flags;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getTimeout() {
        return this.atb;
    }

    public Uri getUri() {
        return this.uri;
    }

    /* renamed from: h */
    public C1941a mo10406h(String str, int i) {
        this.mBundle.putInt(str, i);
        return this;
    }

    /* renamed from: rS */
    public Bundle mo10407rS() {
        return this.ate;
    }

    /* renamed from: rT */
    public int mo10408rT() {
        return this.enterAnim;
    }

    /* renamed from: rU */
    public int mo10409rU() {
        return this.exitAnim;
    }

    /* renamed from: rV */
    public C1949c mo10410rV() {
        return this.atc;
    }

    /* renamed from: rW */
    public boolean mo10411rW() {
        return this.atd;
    }

    /* renamed from: rX */
    public Object mo10412rX() {
        return mo10382H(null);
    }

    /* renamed from: rY */
    public C1941a mo10413rY() {
        this.atd = true;
        return this;
    }

    /* renamed from: s */
    public C1941a mo10414s(Object obj) {
        this.tag = obj;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postcard{uri=");
        sb.append(this.uri);
        sb.append(", tag=");
        sb.append(this.tag);
        sb.append(", mBundle=");
        sb.append(this.mBundle);
        sb.append(", flags=");
        sb.append(this.flags);
        sb.append(", timeout=");
        sb.append(this.atb);
        sb.append(", provider=");
        sb.append(this.atc);
        sb.append(", greenChannel=");
        sb.append(this.atd);
        sb.append(", optionsCompat=");
        sb.append(this.ate);
        sb.append(", enterAnim=");
        sb.append(this.enterAnim);
        sb.append(", exitAnim=");
        sb.append(this.exitAnim);
        sb.append("}\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
