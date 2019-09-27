package com.introvd.template.introduce.dialog;

/* renamed from: com.introvd.template.introduce.dialog.b */
public class C7529b {
    private int dLt;
    private String desc;
    private String title;
    private int todoCode;

    /* renamed from: com.introvd.template.introduce.dialog.b$a */
    public static final class C7531a {
        /* access modifiers changed from: private */
        public int dLt;
        /* access modifiers changed from: private */
        public String desc;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public int todoCode;

        public C7529b azL() {
            return new C7529b(this);
        }

        /* renamed from: jO */
        public C7531a mo32322jO(String str) {
            this.title = str;
            return this;
        }

        /* renamed from: jP */
        public C7531a mo32323jP(String str) {
            this.desc = str;
            return this;
        }

        /* renamed from: rK */
        public C7531a mo32324rK(int i) {
            this.todoCode = i;
            return this;
        }

        /* renamed from: rL */
        public C7531a mo32325rL(int i) {
            this.dLt = i;
            return this;
        }
    }

    private C7529b(C7531a aVar) {
        this.todoCode = aVar.todoCode;
        this.title = aVar.title;
        this.desc = aVar.desc;
        this.dLt = aVar.dLt;
    }

    public int azK() {
        return this.dLt;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTodoCode() {
        return this.todoCode;
    }
}
