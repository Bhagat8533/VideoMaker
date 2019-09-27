package com.introvd.template.p320j;

import com.introvd.template.router.editor.EditorRouter;

/* renamed from: com.introvd.template.j.a */
public class C7547a {

    /* renamed from: com.introvd.template.j.a$a */
    public static class C7548a {
        public String crj = "";
        public String crk = "";
        public String crl = "0";
        public String crm = "";
        public String crn = "";
        /* access modifiers changed from: private */
        public String version = "1";

        public String aaW() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.version);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(this.crj);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(this.crk);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(this.crl);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(this.crm);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(this.crn);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C7548a aVar = (C7548a) obj;
            if (this.version.equals(aVar.version) && this.crj.equals(aVar.crj) && this.crk.equals(aVar.crk) && this.crl.equals(aVar.crl) && this.crm.equals(aVar.crm)) {
                return this.crn.equals(aVar.crn);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.version.hashCode() * 31) + this.crj.hashCode()) * 31) + this.crk.hashCode()) * 31) + this.crl.hashCode()) * 31) + this.crm.hashCode()) * 31) + this.crn.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("WaterMarkInfo{version='");
            sb.append(this.version);
            sb.append('\'');
            sb.append(", rawUserProductId='");
            sb.append(this.crj);
            sb.append('\'');
            sb.append(", rawUserId='");
            sb.append(this.crk);
            sb.append('\'');
            sb.append(", genUserProductId='");
            sb.append(this.crl);
            sb.append('\'');
            sb.append(", genUserId='");
            sb.append(this.crm);
            sb.append('\'');
            sb.append(", trackInfo='");
            sb.append(this.crn);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static String m22295a(C7548a aVar, String str, String str2) {
        C7548a aVar2 = new C7548a();
        if (aVar != null) {
            aVar2.crj = aVar.crj;
            aVar2.crk = aVar.crk;
        } else {
            aVar2.crj = str;
            aVar2.crk = str2;
        }
        aVar2.crl = str;
        aVar2.crm = str2;
        return aVar2.aaW();
    }

    /* renamed from: fU */
    public static C7548a m22296fU(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return m22297fV(str);
    }

    /* renamed from: fV */
    public static C7548a m22297fV(String str) {
        String[] split = str.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        if (split.length <= 4) {
            return null;
        }
        C7548a aVar = new C7548a();
        aVar.version = split[0];
        aVar.crj = split[1];
        aVar.crk = split[2];
        aVar.crl = split[3];
        aVar.crm = split[4];
        if (split.length > 5) {
            aVar.crn = split[5];
        }
        return aVar;
    }
}
