package com.introvd.template.explorer.file;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.explorer.C7138b;
import com.introvd.template.explorer.file.C7241a.C7242a;
import com.introvd.template.explorer.file.C7243b.C7245a;
import com.introvd.template.explorer.p298c.C7142b;
import com.introvd.template.explorer.p298c.C7142b.C7147a;
import com.introvd.template.router.explorer.ExplorerRouter.FileExplorerParams;
import com.introvd.template.vivaexplorermodule.R;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@C1942a(mo10417rZ = "/Explorer/FileExplorer")
public class FileExplorerActivity extends EventActivity implements OnClickListener, OnItemClickListener {
    private TextView bCG;
    private List<C7241a> dyA = new ArrayList();
    private List<C7241a> dyB = new ArrayList();
    private File dyC = Environment.getExternalStorageDirectory();
    private final File dyD = Environment.getExternalStorageDirectory();
    private int dyE = 1;
    /* access modifiers changed from: private */
    public C7243b dyF;
    private View dyG;
    private View dyH;
    private Boolean dyI = Boolean.valueOf(true);
    private Button dyJ;
    private Button dyK;
    private RelativeLayout dyL;
    private RelativeLayout dyM;
    private TextView dyN;
    /* access modifiers changed from: private */
    public CheckBox dyO;
    /* access modifiers changed from: private */
    public boolean dyP = false;
    private ImageView dyQ;
    private C7142b dyR;
    private C7147a dyS = new C7147a() {
        public void awr() {
            FileExplorerActivity.this.finish();
        }
    };
    private C7245a dyT = new C7245a() {
        public void aws() {
            if (FileExplorerActivity.this.dyF != null && FileExplorerActivity.this.dyO != null) {
                FileExplorerActivity.this.dyP = FileExplorerActivity.this.dyF.awu();
                FileExplorerActivity.this.dyO.setChecked(FileExplorerActivity.this.dyP);
            }
        }
    };
    private ListView dyx;
    private Button dyy;
    private List<C7241a> dyz = new ArrayList();
    private ImageView mImgIcon;

    /* renamed from: com.introvd.template.explorer.file.FileExplorerActivity$a */
    class C7240a implements Comparator<C7241a> {
        C7240a() {
        }

        /* renamed from: a */
        public int compare(C7241a aVar, C7241a aVar2) {
            return Collator.getInstance(Locale.CHINA).compare(aVar.getFileName(), aVar2.getFileName());
        }
    }

    /* renamed from: a */
    private void m21370a(File[] fileArr) {
        if (fileArr == null) {
            ToastUtils.show((Context) this, getString(R.string.xiaoying_str_com_permission_deny_tip), 0);
            awn();
            return;
        }
        this.dyz.clear();
        this.dyB.clear();
        this.dyA.clear();
        if (awo()) {
            this.dyH.setEnabled(true);
            this.dyQ.setEnabled(true);
            this.dyN.setEnabled(true);
        } else {
            this.dyH.setEnabled(false);
            this.dyQ.setEnabled(false);
            this.dyN.setEnabled(false);
        }
        this.dyN.setText(this.dyC.getAbsolutePath());
        for (File file : fileArr) {
            if (!m21377x(file)) {
                if (file.isDirectory()) {
                    this.dyB.add(new C7241a(file.getAbsolutePath().substring(this.dyC.getAbsolutePath().length()), getResources().getDrawable(R.drawable.xiaoying_com_file_explorer_file_icon), C7242a.DIREC_OR_FILE));
                } else {
                    String name = file.getName();
                    if (m21378x(name, this.dyE)) {
                        Drawable y = m21379y(name, this.dyE);
                        if (y != null) {
                            this.dyA.add(new C7241a(file.getAbsolutePath().substring(this.dyC.getAbsolutePath().length()), y, C7242a.DIREC_OR_FILE));
                        }
                    }
                }
            }
        }
        C7240a aVar = new C7240a();
        Collections.sort(this.dyB, aVar);
        Collections.sort(this.dyA, aVar);
        this.dyz.addAll(this.dyB);
        this.dyz.addAll(this.dyA);
        this.dyF.mo31769bN(this.dyz);
        this.dyx.setAdapter(this.dyF);
        this.dyF.notifyDataSetChanged();
    }

    private List<String> awk() {
        ArrayList arrayList = new ArrayList();
        for (C7241a aVar : this.dyz) {
            if (aVar.isSelectable()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.dyC.getAbsolutePath());
                sb.append(aVar.getFilePath());
                arrayList.add(sb.toString());
            }
        }
        return arrayList;
    }

    private void awl() {
        this.dyR.awl();
    }

    private void awm() {
        this.dyR.mo31600bO(awk());
    }

    private void awn() {
        this.dyP = false;
        this.dyO.setChecked(false);
        if (this.dyC.getParent() != null) {
            m21376w(this.dyC.getParentFile());
        }
    }

    private boolean awo() {
        return this.dyC.getParent() != null && !this.dyC.getPath().equals(StorageInfo.getStorageRootPath());
    }

    private void awp() {
        m21375qA(this.dyE);
        this.dyI = Boolean.valueOf(true);
        this.dyL.setVisibility(0);
        this.dyM.setVisibility(4);
        this.dyO.setVisibility(4);
    }

    private void awq() {
        this.bCG.setText(R.string.xiaoying_str_ve_gallery_file_pick);
        this.dyI = Boolean.valueOf(false);
        this.dyL.setVisibility(4);
        this.dyM.setVisibility(0);
        m21376w(Environment.getExternalStorageDirectory());
        this.dyO.setVisibility(0);
    }

    /* renamed from: b */
    private boolean m21373b(String str, String[] strArr) {
        String fileType = FileUtils.getFileType(str);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        for (String equalsIgnoreCase : strArr) {
            if (fileType.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: qA */
    private void m21375qA(int i) {
        int i2 = R.string.xiaoying_str_ve_gallery_file_pick;
        if (i == 4) {
            i2 = R.string.xiaoying_str_ve_gallery_scan_photo_title;
        } else if (i != 6) {
            switch (i) {
                case 1:
                    i2 = R.string.xiaoying_str_ve_gallery_scan_music_title;
                    break;
                case 2:
                    i2 = R.string.xiaoying_str_ve_gallery_scan_video_title;
                    break;
            }
        } else {
            i2 = R.string.xiaoying_str_ve_gallery_scan_video_photo_title;
        }
        this.bCG.setText(i2);
    }

    /* renamed from: w */
    private void m21376w(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ToastUtils.show((Context) this, getString(R.string.xiaoying_str_com_permission_deny_tip), 0);
                return;
            }
            setTitle(file.getAbsolutePath());
            this.dyC = file;
            m21370a(listFiles);
            this.dyO.setChecked(false);
            this.dyP = false;
        }
    }

    /* renamed from: x */
    private boolean m21377x(File file) {
        return this.dyR.mo31602x(file);
    }

    /* renamed from: x */
    private boolean m21378x(String str, int i) {
        boolean z = false;
        if (i != 4) {
            if (i != 6) {
                switch (i) {
                    case 1:
                        if (m21373b(str, C7138b.avQ())) {
                            return true;
                        }
                        break;
                    case 2:
                        if (m21373b(str, C7138b.avP())) {
                            return true;
                        }
                        break;
                }
            } else {
                if (m21373b(str, C7138b.avO()) || m21373b(str, C7138b.avP())) {
                    z = true;
                }
                return z;
            }
        } else if (m21373b(str, C7138b.avO())) {
            return true;
        }
        return false;
    }

    /* renamed from: y */
    private Drawable m21379y(String str, int i) {
        if (i == 4) {
            return getResources().getDrawable(R.drawable.xiaoying_com_file_explorer_pic_icon);
        }
        if (i == 6) {
            return m21378x(str, 2) ? m21379y(str, 2) : m21379y(str, 4);
        }
        switch (i) {
            case 1:
                return getResources().getDrawable(R.drawable.xiaoying_com_file_explorer_music_icon);
            case 2:
                return getResources().getDrawable(R.drawable.xiaoying_com_file_explorer_video_icon);
            default:
                return null;
        }
    }

    public void onClick(View view) {
        if (view.equals(this.dyy)) {
            awm();
        } else if (view.equals(this.dyG)) {
            finish();
        } else if (view.equals(this.dyH)) {
            awn();
        } else if (view.equals(this.dyJ)) {
            awp();
            awl();
        } else if (view.equals(this.dyK)) {
            awq();
        } else if (view.equals(this.dyO)) {
            this.dyP = !this.dyP;
            for (C7241a aVar : this.dyz) {
                if (aVar.awt() != C7242a.LAST_DIR) {
                    aVar.setSelectable(this.dyP);
                }
            }
            if (this.dyF != null) {
                this.dyF.mo31774hW(this.dyP);
                this.dyF.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dyE = getIntent().getExtras().getInt(FileExplorerParams.KEY_EXPLORER_FILE_TYPE, 1);
        this.dyR = new C7142b(this, this.dyE, this.dyS);
        setContentView(R.layout.xiaoying_com_file_explorer_layout);
        this.dyG = findViewById(R.id.xiaoying_com_btn_left);
        this.dyG.setOnClickListener(this);
        this.dyx = (ListView) findViewById(R.id.file_listview);
        this.dyx.setOnItemClickListener(this);
        this.dyH = findViewById(R.id.layout_back_item);
        this.dyH.setOnClickListener(this);
        this.dyN = (TextView) findViewById(R.id.back_file_name);
        this.dyQ = (ImageView) findViewById(R.id.back_file_icon);
        this.dyy = (Button) findViewById(R.id.btn_scan);
        this.dyy.setOnClickListener(this);
        this.dyJ = (Button) findViewById(R.id.btn_qucik_scan);
        this.dyK = (Button) findViewById(R.id.btn_custom_scan);
        this.dyJ.setOnClickListener(this);
        this.dyK.setOnClickListener(this);
        this.dyL = (RelativeLayout) findViewById(R.id.scan_type_select_layout);
        this.dyM = (RelativeLayout) findViewById(R.id.custom_scan_layout);
        this.dyM.setVisibility(4);
        this.bCG = (TextView) findViewById(R.id.title);
        this.dyO = (CheckBox) findViewById(R.id.select_all);
        this.dyO.setOnClickListener(this);
        this.mImgIcon = (ImageView) findViewById(R.id.img_icon);
        this.dyF = new C7243b(this, this.dyT);
        awq();
        if (this.dyE == 1) {
            this.mImgIcon.setImageResource(R.drawable.xiaoying_com_music_icon_big);
        } else {
            this.mImgIcon.setImageResource(R.drawable.xiaoying_com_clip_icon_big);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((C7241a) this.dyz.get(i)).awt() == C7242a.LAST_DIR) {
            awn();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.dyC.getAbsolutePath());
        sb.append(((C7241a) this.dyz.get(i)).getFilePath());
        File file = new File(sb.toString());
        if (file.isDirectory()) {
            m21376w(file);
        } else if (this.dyF != null) {
            C7241a aVar = (C7241a) this.dyF.getItem(i);
            aVar.setSelectable(!aVar.isSelectable());
            this.dyF.notifyDataSetChanged();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dyI.booleanValue()) {
            return super.onKeyUp(i, keyEvent);
        }
        if (awo()) {
            awn();
        } else {
            finish();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
    }
}
