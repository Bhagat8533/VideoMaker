package com.introvd.template.sdk.utils.p394b.p395a;

import xiaoying.engine.producer.QProducer.QProducerErrInfo;

/* renamed from: com.introvd.template.sdk.utils.b.a.b */
public class C8507b extends QProducerErrInfo {
    public String eiF;
    public int eiG;
    public int eiH;
    public int eiI;

    /* renamed from: a */
    public void mo34687a(QProducerErrInfo qProducerErrInfo) {
        this.mAPrcErr = qProducerErrInfo.mAPrcErr;
        this.mbTransition = qProducerErrInfo.mbTransition;
        this.mClipIndex = qProducerErrInfo.mClipIndex;
        this.mErrTime = qProducerErrInfo.mErrTime;
        this.mHWException = qProducerErrInfo.mHWException;
        this.mLeftClipIndex = qProducerErrInfo.mLeftClipIndex;
        this.mRightClipIndex = qProducerErrInfo.mRightClipIndex;
        this.mVDecErr = qProducerErrInfo.mVDecErr;
        this.mVPrcErr = qProducerErrInfo.mVPrcErr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExportErrModel{audioErr=");
        sb.append(this.eiG);
        sb.append(", videoDecErr=");
        sb.append(this.eiH);
        sb.append(", videoProcErr=");
        sb.append(this.eiI);
        sb.append(", mErrTime=");
        sb.append(this.mErrTime);
        sb.append(", mAPrcErr=");
        sb.append(this.mAPrcErr);
        sb.append(", mVDecErr=");
        sb.append(this.mVDecErr);
        sb.append(", mVPrcErr=");
        sb.append(this.mVPrcErr);
        sb.append(", mbTransition=");
        sb.append(this.mbTransition);
        sb.append(", mLeftClipIndex=");
        sb.append(this.mLeftClipIndex);
        sb.append(", mRightClipIndex=");
        sb.append(this.mRightClipIndex);
        sb.append(", mClipIndex=");
        sb.append(this.mClipIndex);
        sb.append(", mHWException=");
        sb.append(this.mHWException);
        sb.append(", stateUserData='");
        sb.append(this.eiF);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
