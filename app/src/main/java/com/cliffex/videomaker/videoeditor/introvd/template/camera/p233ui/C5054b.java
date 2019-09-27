package com.introvd.template.camera.p233ui;

/* renamed from: com.introvd.template.camera.ui.b */
public class C5054b {
    public C5056b bRS;
    public C5057c bRT;

    /* renamed from: com.introvd.template.camera.ui.b$a */
    public static class C5055a {
        private boolean bRU = false;
        private boolean bRV = true;
        private int itemId;
        private String title;

        public int getItemId() {
            return this.itemId;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isClickable() {
            return this.bRV;
        }

        public boolean isSelected() {
            return this.bRU;
        }

        public void setClickable(boolean z) {
            this.bRV = z;
        }

        public void setItemId(int i) {
            this.itemId = i;
        }

        public void setSelected(boolean z) {
            this.bRU = z;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    /* renamed from: com.introvd.template.camera.ui.b$b */
    public interface C5056b {
        /* renamed from: a */
        void mo25941a(C5055a aVar);
    }

    /* renamed from: com.introvd.template.camera.ui.b$c */
    public interface C5057c {
        void onDismiss();
    }

    /* renamed from: a */
    public void mo25931a(C5056b bVar) {
        this.bRS = bVar;
    }

    /* renamed from: a */
    public void mo25932a(C5057c cVar) {
        this.bRT = cVar;
    }
}
