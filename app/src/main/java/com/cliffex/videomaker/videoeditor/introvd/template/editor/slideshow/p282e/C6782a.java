package com.introvd.template.editor.slideshow.p282e;

import android.text.TextUtils;
import com.introvd.template.common.FileUtils;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.slide.p392a.C8466c;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QSlideShowSceCfgInfo;
import xiaoying.engine.base.QStyle.QSlideShowSceCfgItem;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.slideshowsession.QSlideShowSession.QImageSourceInfo;
import xiaoying.engine.slideshowsession.QSlideShowSession.QSourceInfoNode;
import xiaoying.engine.slideshowsession.QSlideShowSession.QVideoSourceInfo;
import xiaoying.engine.slideshowsession.QSlideShowSession.QVirtualSourceInfoNode;

/* renamed from: com.introvd.template.editor.slideshow.e.a */
public class C6782a {
    /* renamed from: a */
    public static boolean m19746a(QSlideShowSession qSlideShowSession, QVirtualSourceInfoNode qVirtualSourceInfoNode, TrimedClipItemDataModel trimedClipItemDataModel) {
        if (qSlideShowSession == null || qVirtualSourceInfoNode == null || trimedClipItemDataModel == null || !FileUtils.isFileExisted(trimedClipItemDataModel.mRawFilePath)) {
            return false;
        }
        QSourceInfoNode qSourceInfoNode = new QSourceInfoNode();
        qSourceInfoNode.mstrSourceFile = trimedClipItemDataModel.mRawFilePath;
        qSourceInfoNode.mSourceType = C8466c.m24517nT(qSourceInfoNode.mstrSourceFile);
        if (qSourceInfoNode.mSourceType == 1) {
            QImageSourceInfo qImageSourceInfo = new QImageSourceInfo();
            qSourceInfoNode.mSourceInfoObj = qImageSourceInfo;
            qImageSourceInfo.mFaceCenterX = 5000;
            qImageSourceInfo.mFaceCenterY = 5000;
            qImageSourceInfo.mbFaceDetected = true;
        } else if (qSourceInfoNode.mSourceType == 2) {
            QVideoSourceInfo qVideoSourceInfo = new QVideoSourceInfo();
            qSourceInfoNode.mSourceInfoObj = qVideoSourceInfo;
            qVideoSourceInfo.mSrcRange = new QRange(0, -1);
            if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
                qVideoSourceInfo.mSrcRange = new QRange(trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition(), trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength());
            }
        }
        qSlideShowSession.UpdateVirtualSource(qVirtualSourceInfoNode, qSourceInfoNode);
        qSlideShowSession.RefreshSourceList();
        return true;
    }

    /* renamed from: iI */
    public static QSlideShowSceCfgItem[] m19747iI(String str) {
        int i;
        QSlideShowSceCfgItem[] qSlideShowSceCfgItemArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, 1) == 0) {
            QSlideShowSceCfgInfo slideShowSceCfgInfo = qStyle.getSlideShowSceCfgInfo();
            if (slideShowSceCfgInfo != null) {
                int length = slideShowSceCfgInfo.mCoverItem != null ? slideShowSceCfgInfo.mCoverItem.length + 0 : 0;
                if (slideShowSceCfgInfo.mBodyItem != null) {
                    length += slideShowSceCfgInfo.mBodyItem.length;
                }
                if (slideShowSceCfgInfo.mBackCoverItem != null) {
                    length += slideShowSceCfgInfo.mBackCoverItem.length;
                }
                qSlideShowSceCfgItemArr = new QSlideShowSceCfgItem[length];
                if (slideShowSceCfgInfo.mCoverItem != null) {
                    System.arraycopy(slideShowSceCfgInfo.mCoverItem, 0, qSlideShowSceCfgItemArr, 0, slideShowSceCfgInfo.mCoverItem.length);
                    i = slideShowSceCfgInfo.mCoverItem.length + 0;
                } else {
                    i = 0;
                }
                if (slideShowSceCfgInfo.mBodyItem != null) {
                    System.arraycopy(slideShowSceCfgInfo.mBodyItem, 0, qSlideShowSceCfgItemArr, i, slideShowSceCfgInfo.mBodyItem.length);
                    i += slideShowSceCfgInfo.mBodyItem.length;
                }
                if (slideShowSceCfgInfo.mBackCoverItem != null) {
                    System.arraycopy(slideShowSceCfgInfo.mBackCoverItem, 0, qSlideShowSceCfgItemArr, i, slideShowSceCfgInfo.mBackCoverItem.length);
                }
            }
        }
        qStyle.destroy();
        return qSlideShowSceCfgItemArr;
    }
}
