package com.introvd.template.editor.p266h;

import android.text.TextUtils;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.sdk.model.editor.DataItemClip;
import com.introvd.template.sdk.utils.p394b.C8533l.C8534a;

/* renamed from: com.introvd.template.editor.h.o */
public class C6410o extends C8534a {
    private C6411p deW;
    private String dll;
    private String dlm;
    private String dln;

    public C6410o(String str, String str2, String str3) {
        this.dll = str;
        this.dlm = str2;
        this.dln = str3;
    }

    private String atl() {
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            return userInfo.nickname;
        }
        return null;
    }

    /* renamed from: a */
    public void mo29459a(C6411p pVar) {
        this.deW = pVar;
    }

    public String ata() {
        return this.dll;
    }

    public String atb() {
        String str = "";
        if (this.deW != null) {
            DataItemClip aqJ = this.deW.aqJ();
            if (aqJ != null) {
                str = aqJ.strClipCity;
            }
        }
        return TextUtils.isEmpty(str) ? this.dlm : str;
    }

    public String atc() {
        String str = "";
        if (this.deW != null) {
            DataItemClip aqJ = this.deW.aqJ();
            if (aqJ != null) {
                str = aqJ.strCountry;
            }
        }
        return TextUtils.isEmpty(str) ? this.dlm : str;
    }

    public String atd() {
        String str = "";
        if (this.deW != null) {
            str = this.deW.aqI();
        }
        return TextUtils.isEmpty(str) ? this.dlm : str;
    }

    public String ate() {
        String str = "";
        if (this.deW != null) {
            DataItemClip aqJ = this.deW.aqJ();
            if (aqJ != null) {
                str = aqJ.strProvince;
            }
        }
        return TextUtils.isEmpty(str) ? this.dlm : str;
    }

    public String atf() {
        return (this.deW == null || TextUtils.isEmpty(this.deW.getUserName())) ? this.dln : this.deW.getUserName();
    }

    public String atg() {
        String atl = atl();
        return TextUtils.isEmpty(atl) ? this.dln : atl;
    }

    public String ath() {
        String atl = atl();
        return TextUtils.isEmpty(atl) ? this.dln : atl;
    }

    public String ati() {
        String atl = atl();
        return TextUtils.isEmpty(atl) ? this.dln : atl;
    }

    public String atj() {
        String atl = atl();
        return TextUtils.isEmpty(atl) ? this.dln : atl;
    }

    public String atk() {
        String atl = atl();
        return TextUtils.isEmpty(atl) ? this.dln : atl;
    }
}
