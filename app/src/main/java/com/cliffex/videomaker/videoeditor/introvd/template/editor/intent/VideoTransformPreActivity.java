package com.introvd.template.editor.intent;

import android.app.Activity;
import android.os.Bundle;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.router.AppRouter.IntentHomeParams;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.vivavideo.component.permission.R;
import java.util.HashMap;

public class VideoTransformPreActivity extends Activity {
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.viva_permission_activity_alpha, R.anim.viva_permission_activity_alpha_out);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.introvd.template.editor.R.layout.editor_app_empy_layout);
        VivaRouter.getRouterBuilder(IntentHomeParams.URL).mo10400g(getIntent().getExtras()).mo10399f(GalleryRouter.GALLERY_EXTRA_INTENT_ACTION, getIntent().getAction()).mo10406h(GalleryRouter.EXTRA_INTENT_MODE_KEY, 2001).mo10398dD(67108864).mo10382H(this);
        HashMap hashMap = new HashMap();
        hashMap.put("which", "speed");
        UserBehaviorLog.onKVEvent(getApplicationContext(), "Gallery_Intent_Action", hashMap);
        finish();
    }
}
