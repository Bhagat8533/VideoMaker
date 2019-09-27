package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.explorer.extract.ExtractMusicActivity;
import com.introvd.template.explorer.extract.ExtractMusicCompleteActivity;
import com.introvd.template.explorer.file.FileExplorerActivity;
import com.introvd.template.explorer.music.XYMusicEffectFragment;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.router.explorer.ExplorerRouter.FileExplorerParams;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import java.util.Map;

public class ARouter$$Group$$Explorer implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(FileExplorerParams.URL, RouteMeta.build(C1945a.ACTIVITY, FileExplorerActivity.class, "/explorer/fileexplorer", "explorer", null, -1, Integer.MIN_VALUE));
        map.put(MusicParams.URL, RouteMeta.build(C1945a.FRAGMENT, XYMusicFragment.class, "/explorer/music", "explorer", null, -1, Integer.MIN_VALUE));
        map.put(ExplorerRouter.URL_MUSIC_DIRECT_EXTRACT, RouteMeta.build(C1945a.ACTIVITY, ExtractMusicCompleteActivity.class, "/explorer/musicdirectextract", "explorer", null, -1, Integer.MIN_VALUE));
        map.put(MusicParams.URL_EFFECT, RouteMeta.build(C1945a.FRAGMENT, XYMusicEffectFragment.class, "/explorer/musiceffect", "explorer", null, -1, Integer.MIN_VALUE));
        map.put(ExplorerRouter.URL_VIDEO_EXTRACT, RouteMeta.build(C1945a.ACTIVITY, ExtractMusicActivity.class, "/explorer/videoextract", "explorer", null, -1, Integer.MIN_VALUE));
    }
}
