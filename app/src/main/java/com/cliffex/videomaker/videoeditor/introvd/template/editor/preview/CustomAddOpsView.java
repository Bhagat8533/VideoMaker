package com.introvd.template.editor.preview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.p363o.C8086a;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@SuppressLint({"ViewConstructor"})
public class CustomAddOpsView extends BaseOperationView<C5686a> {
    private ImageButton cZs;
    private LinearLayout cZt;
    private LinearLayout cZu;

    public CustomAddOpsView(Activity activity) {
        super(activity, C5686a.class);
    }

    /* access modifiers changed from: private */
    public void aoF() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                CustomAddOpsView.this.exit(true);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    public void aex() {
        super.aex();
        this.cZs = (ImageButton) findViewById(R.id.btn_cancel);
        this.cZt = (LinearLayout) findViewById(R.id.layout_move_camera);
        this.cZu = (LinearLayout) findViewById(R.id.layout_move_gallery);
        this.cZs.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CustomAddOpsView.this.getEditor().adX();
                CustomAddOpsView.this.exit();
            }
        });
        this.cZt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                final Activity activity = (Activity) CustomAddOpsView.this.bwg.get();
                if (activity != null) {
                    CustomAddOpsView.this.getEditor().adX();
                    final HashMap hashMap = new HashMap();
                    hashMap.put(CameraRouter.KEY_CAMERA_INTENT, Integer.valueOf(4098));
                    hashMap.put(CameraRouter.KEY_INTENT_CLIP_INSERT_POSITION, Integer.valueOf(C5843c.agO().agQ()));
                    C8086a.m23466a(activity, (C8099d) new C8099d() {
                        /* renamed from: PP */
                        public void mo24403PP() {
                            CameraRouter.launchCameraForResult(activity, true, hashMap, 24582);
                            CustomAddOpsView.this.aoF();
                        }

                        /* renamed from: PQ */
                        public void mo24404PQ() {
                        }
                    });
                }
            }
        });
        this.cZu.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Activity activity = (Activity) CustomAddOpsView.this.bwg.get();
                if (activity != null) {
                    CustomAddOpsView.this.getEditor().adX();
                    boolean isMVPrj = C8522g.aJA().aHe() != null ? C8522g.aJA().aHe().isMVPrj() : false;
                    String str = GalleryRouter.URL;
                    Object[] objArr = new Object[1];
                    objArr[0] = new Builder().setSourceMode(isMVPrj ? 2 : 0).setAction(2).setNewPrj(false).build();
                    GalleryRouter.getInstance().launchActivity(activity, PassThoughUrlGenerator.generateUrl(str, objArr), 24581);
                    CustomAddOpsView.this.aoF();
                }
            }
        });
    }

    public int getLayoutId() {
        return R.layout.editor_custom_preview_ops_layout;
    }
}
