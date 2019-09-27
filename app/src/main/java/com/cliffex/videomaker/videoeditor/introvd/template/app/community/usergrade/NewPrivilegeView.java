package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import java.util.List;

public class NewPrivilegeView extends RelativeLayout {

    /* renamed from: Vu */
    private RecyclerView f3375Vu;
    private TextView bkA;
    /* access modifiers changed from: private */
    public C3771a bkB;
    private C3783a bkz;

    /* renamed from: com.introvd.template.app.community.usergrade.NewPrivilegeView$a */
    public interface C3771a {
        /* renamed from: bF */
        void mo23251bF(View view);
    }

    public NewPrivilegeView(Context context) {
        super(context);
        m9247Iu();
    }

    /* renamed from: Iu */
    private void m9247Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.user_new_privilege_view, this, true);
        this.f3375Vu = (RecyclerView) findViewById(R.id.recycler_view);
        this.bkA = (TextView) findViewById(R.id.btn_confirm);
        this.bkz = new C3783a();
        this.bkA.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NewPrivilegeView.this.bkB != null) {
                    NewPrivilegeView.this.bkB.mo23251bF(view);
                }
            }
        });
    }

    /* renamed from: J */
    public void mo23248J(List<C3791d> list) {
        this.f3375Vu.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f3375Vu.setAdapter(this.bkz);
        this.bkz.setDataList(list);
        this.bkz.notifyDataSetChanged();
    }

    public void setOnBtnClickListener(C3771a aVar) {
        this.bkB = aVar;
    }
}
