package com.introvd.template.editor.provider;

import com.introvd.template.editor.base.BaseEditorActivity;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.filter.FilterOpsView;
import com.introvd.template.editor.clipedit.paramadjust.ParamAdjustOpsView;
import com.introvd.template.editor.clipedit.ratioadjust.RatioAdjustOpsView;
import com.introvd.template.editor.clipedit.sound.MagicSoundOpsView;
import com.introvd.template.editor.clipedit.speed.SpeedOpsView;
import com.introvd.template.editor.clipedit.spilt.SplitOperationView;
import com.introvd.template.editor.clipedit.transition.TransitionOpsView;
import com.introvd.template.editor.clipedit.trim.PicTrimOperationView;
import com.introvd.template.editor.clipedit.trim.TrimAndCutOperationView;
import com.introvd.template.editor.effects.bubble.sticker.StickerOperationView;
import com.introvd.template.editor.effects.bubble.subtitle.SubtitleOperationView;
import com.introvd.template.editor.effects.collage.CollageOpsView;
import com.introvd.template.editor.effects.customwatermark.CustomWaterMarkOperationView;
import com.introvd.template.editor.effects.dub.DubOperationView;
import com.introvd.template.editor.effects.mosaic.MosaicOperationView;
import com.introvd.template.editor.effects.music.MusicOperationView;
import com.introvd.template.editor.effects.p257fx.FxOperationView;
import com.introvd.template.editor.fast.FastPreviewOpsView;
import com.introvd.template.editor.gifmaker.GifMakerOpsView;
import com.introvd.template.editor.preview.BasePreviewOpsView;
import com.introvd.template.editor.preview.CustomAddOpsView;
import com.introvd.template.editor.preview.PreviewOpsView;
import com.introvd.template.editor.preview.theme.duration.ThemeDurationView;
import com.introvd.template.editor.preview.theme.music.ThemeMusicView;
import com.introvd.template.editor.preview.theme.themetitle.ThemeTitleView;
import com.introvd.template.router.editor.EditorModes;

/* renamed from: com.introvd.template.editor.provider.g */
public class C6712g {
    /* renamed from: a */
    public static BasePreviewOpsView m19491a(BaseEditorActivity baseEditorActivity, int i) {
        switch (i) {
            case 0:
                return new PreviewOpsView(baseEditorActivity);
            case 1:
                return new GifMakerOpsView(baseEditorActivity);
            case 2:
                return new FastPreviewOpsView(baseEditorActivity);
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static BaseOperationView m19492b(BaseEditorActivity baseEditorActivity, int i) {
        if (i != -1) {
            if (i == 4) {
                return new CustomAddOpsView(baseEditorActivity);
            }
            if (i == 1014) {
                return new PicTrimOperationView(baseEditorActivity);
            }
            if (i != 1017) {
                if (i == 1019) {
                    return new MagicSoundOpsView(baseEditorActivity);
                }
                switch (i) {
                    case 1001:
                        return new FilterOpsView(baseEditorActivity);
                    case 1002:
                        return new ParamAdjustOpsView(baseEditorActivity);
                    case 1003:
                        return new TrimAndCutOperationView(baseEditorActivity);
                    case 1004:
                        return new SplitOperationView(baseEditorActivity);
                    case 1005:
                        return new SpeedOpsView(baseEditorActivity);
                    case 1006:
                        return new RatioAdjustOpsView(baseEditorActivity);
                    case 1007:
                    case 1008:
                    case 1009:
                    case 1010:
                        break;
                    case 1011:
                        return new TransitionOpsView(baseEditorActivity);
                    default:
                        switch (i) {
                            case 2001:
                                return new CollageOpsView(baseEditorActivity);
                            case 2002:
                                return new SubtitleOperationView(baseEditorActivity);
                            case 2003:
                                return new StickerOperationView(baseEditorActivity);
                            case 2004:
                                return new FxOperationView(baseEditorActivity);
                            case 2005:
                                return new MusicOperationView(baseEditorActivity);
                            case 2006:
                                return new DubOperationView(baseEditorActivity);
                            case EditorModes.EFFECT_MOSAIC_MODE /*2007*/:
                                return new MosaicOperationView(baseEditorActivity);
                            case 2008:
                                return new CustomWaterMarkOperationView(baseEditorActivity);
                            default:
                                switch (i) {
                                    case 3001:
                                        return new ThemeTitleView(baseEditorActivity);
                                    case 3002:
                                        return new ThemeMusicView(baseEditorActivity);
                                    case 3003:
                                        return new ThemeDurationView(baseEditorActivity);
                                }
                        }
                }
            }
        }
        return null;
    }
}
