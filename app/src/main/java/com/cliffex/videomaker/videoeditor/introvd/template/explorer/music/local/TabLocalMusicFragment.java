package com.introvd.template.explorer.music.local;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import com.introvd.template.explorer.music.MusicBaseFragment;
import com.introvd.template.vivaexplorermodule.R;

public class TabLocalMusicFragment extends MusicBaseFragment {
    public static TabLocalMusicFragment axJ() {
        TabLocalMusicFragment tabLocalMusicFragment = new TabLocalMusicFragment();
        tabLocalMusicFragment.setArguments(new Bundle());
        return tabLocalMusicFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31805Oj() {
        getChildFragmentManager().beginTransaction().add(R.id.music_rootLayout, (Fragment) LocalSubFragment.axI()).commit();
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_local_fragment;
    }

    /* access modifiers changed from: protected */
    public void initData() {
    }
}
