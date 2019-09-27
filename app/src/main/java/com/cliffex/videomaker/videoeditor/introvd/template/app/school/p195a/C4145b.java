package com.introvd.template.app.school.p195a;

/* renamed from: com.introvd.template.app.school.a.b */
public class C4145b extends C4144a {
    private static volatile C4145b bxH;

    private C4145b() {
    }

    /* renamed from: NT */
    public static C4145b m10328NT() {
        if (bxH == null) {
            synchronized (C4145b.class) {
                if (bxH == null) {
                    bxH = new C4145b();
                }
            }
        }
        return bxH;
    }

    /* renamed from: NR */
    public String mo23830NR() {
        return "school_pref";
    }

    /* renamed from: NU */
    public void mo23832NU() {
        mo23831NS().setBoolean("template_list_next_hint_shown", true);
    }

    /* renamed from: NV */
    public boolean mo23833NV() {
        return !mo23831NS().getBoolean("template_list_next_hint_shown", false);
    }
}
