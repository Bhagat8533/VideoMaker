package com.introvd.template.editor.intent;

import android.app.Activity;
import android.os.Bundle;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.editor.R;
import com.introvd.template.router.AppRouter.IntentHomeParams;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import java.util.HashMap;

public class VideoTrimPreActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_app_empy_layout);
        VivaRouter.getRouterBuilder(IntentHomeParams.URL).mo10400g(getIntent().getExtras()).mo10399f(GalleryRouter.GALLERY_EXTRA_INTENT_ACTION, getIntent().getAction()).mo10406h(GalleryRouter.EXTRA_INTENT_MODE_KEY, 2003).mo10398dD(67108864).mo10382H(this);
        HashMap hashMap = new HashMap();
        hashMap.put("which", "trim");
        UserBehaviorLog.onKVEvent(getApplicationContext(), "Gallery_Intent_Action", hashMap);
        finish();
    }
}
