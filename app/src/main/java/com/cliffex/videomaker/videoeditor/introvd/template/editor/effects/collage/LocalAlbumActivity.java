package com.introvd.template.editor.effects.collage;

import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.EventActivity;
import com.introvd.template.editor.R;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.gallery.AbstractGalleryFragment;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import java.util.ArrayList;
import org.greenrobot.eventbus.C10021c;

@C1942a(mo10417rZ = "/XYVideoEditor/CollageAlbum")
public class LocalAlbumActivity extends EventActivity {
    private int cJA;
    AbstractGalleryFragment cJz;
    private int sourceMode;

    /* renamed from: Oj */
    private void m17288Oj() {
        findViewById(R.id.video_title_left_button).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LocalAlbumActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i && intent != null && intent.getExtras() != null) {
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList(MediaGalleryRouter.INTENT_IMAGE_LIST_KEY);
            if (parcelableArrayList != null && parcelableArrayList.size() > 0 && parcelableArrayList.get(0) != null && ((TrimedClipItemDataModel) parcelableArrayList.get(0)).mRawFilePath != null) {
                C10021c.aZH().mo38492aA(new C7134a(((TrimedClipItemDataModel) parcelableArrayList.get(0)).mRawFilePath));
            }
        }
    }

    public void onBackPressed() {
        if (this.cJz == null || this.cJz.ayj()) {
            finish();
        } else {
            this.cJz.ayi();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_local_album);
        this.sourceMode = getIntent().getIntExtra(MediaGalleryRouter.KEY_INTENT_SOURCE_MODE, 2);
        this.cJA = getIntent().getIntExtra(MediaGalleryRouter.KEY_INTENT_NEXT_ACTION, 0);
        int i = this.cJA != 0 ? this.cJA : this.sourceMode == 2 ? 6 : 8;
        ((TextView) findViewById(R.id.title_name)).setText(this.sourceMode == 2 ? getString(R.string.xiaoying_str_ve_choose_photo_title) : getString(R.string.xiaoying_str_ve_choose_videos_title));
        this.cJz = (AbstractGalleryFragment) C1919a.m5529sc().mo10355al(MediaGalleryRouter.OTHER_MEDIA_URL).mo10406h(MediaGalleryRouter.KEY_INTENT_ADDMODE, this.sourceMode).mo10406h(MediaGalleryRouter.KEY_GALLERY_ACTION, i).mo10412rX();
        getSupportFragmentManager().beginTransaction().add(R.id.collage_album_container, (Fragment) this.cJz).commit();
        m17288Oj();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.cJz != null && this.cJz.ayj()) {
            this.cJz.mo32017ai(this.sourceMode == 2 ? 1 : 0, false);
        }
    }
}
