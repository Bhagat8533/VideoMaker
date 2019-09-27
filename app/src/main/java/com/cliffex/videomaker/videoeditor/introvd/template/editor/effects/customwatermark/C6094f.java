package com.introvd.template.editor.effects.customwatermark;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;

/* renamed from: com.introvd.template.editor.effects.customwatermark.f */
public class C6094f {
    /* renamed from: a */
    public static C6096h m17364a(C6096h hVar, MSize mSize, MSize mSize2) {
        if (mSize == null || mSize2 == null || hVar == null || hVar.cKy == null) {
            return hVar;
        }
        hVar.cKy.mPosInfo = m17365a(hVar.cKy.mPosInfo, new MSize(hVar.cKB, hVar.cKC), mSize);
        hVar.cKB = mSize.width;
        hVar.cKC = mSize.height;
        hVar.cKz = mSize2.width;
        hVar.cKA = mSize2.height;
        return hVar;
    }

    /* renamed from: a */
    public static StylePositionModel m17365a(StylePositionModel stylePositionModel, MSize mSize, MSize mSize2) {
        if (stylePositionModel == null || mSize == null || mSize2 == null || stylePositionModel.getmWidth() * stylePositionModel.getmHeight() == 0.0f || mSize.width * mSize.height == 0 || mSize2.height * mSize2.width == 0) {
            return stylePositionModel;
        }
        float f = ((stylePositionModel.getmWidth() * stylePositionModel.getmHeight()) / ((float) (mSize.width * mSize.height))) * ((float) (mSize2.width * mSize2.height));
        float f2 = stylePositionModel.getmWidth() / stylePositionModel.getmHeight();
        float sqrt = (float) Math.sqrt((double) (f * f2));
        float sqrt2 = (float) Math.sqrt((double) (f / f2));
        float f3 = stylePositionModel.getmCenterPosY() / ((float) mSize.height);
        float f4 = ((float) mSize2.width) * (stylePositionModel.getmCenterPosX() / ((float) mSize.width));
        float f5 = ((float) mSize2.height) * f3;
        stylePositionModel.setmWidth(sqrt);
        stylePositionModel.setmHeight(sqrt2);
        stylePositionModel.setmCenterPosX(f4);
        stylePositionModel.setmCenterPosY(f5);
        StringBuilder sb = new StringBuilder();
        sb.append("calculateNewPosInfo------->new centerX: ");
        sb.append(stylePositionModel.getmCenterPosX());
        sb.append("  new centerY: ");
        sb.append(stylePositionModel.getmCenterPosY());
        sb.append("  surface w: ");
        sb.append(mSize2.width);
        sb.append("  surface h: ");
        sb.append(mSize2.height);
        LogUtilsV2.m14227d(sb.toString());
        return stylePositionModel;
    }

    /* renamed from: a */
    public static StylePositionModel m17366a(ScaleRotateViewState scaleRotateViewState, MSize mSize) {
        StylePositionModel stylePositionModel = scaleRotateViewState.mPosInfo;
        if (stylePositionModel == null || stylePositionModel.getmWidth() == 0.0f || stylePositionModel.getmHeight() == 0.0f) {
            return stylePositionModel;
        }
        float f = stylePositionModel.getmWidth() / stylePositionModel.getmHeight();
        float f2 = (float) ((int) (((float) (mSize.width * mSize.height)) * 0.027777778f));
        float sqrt = (float) Math.sqrt((double) (f2 * f));
        float sqrt2 = (float) Math.sqrt((double) (f2 / f));
        stylePositionModel.setmWidth(sqrt);
        stylePositionModel.setmHeight(sqrt2);
        float f3 = (float) (((double) (mSize.width > mSize.height ? mSize.width : mSize.height)) * 0.018d);
        stylePositionModel.setmCenterPosX((((float) mSize.width) - (sqrt / 2.0f)) - f3);
        stylePositionModel.setmCenterPosY((((float) mSize.height) - (sqrt2 / 2.0f)) - f3);
        return stylePositionModel;
    }
}
