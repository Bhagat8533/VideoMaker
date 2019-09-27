package com.introvd.template.router.sns;

import java.util.List;

public class PopupVideoShareInfo {
    public List<MyResolveInfo> myResolveInfoList;
    public OnPopShowListener onPopShowListener;
    public OnPopupItemClickListener onPopupItemClickListener;

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<MyResolveInfo> myResolveInfoList;
        /* access modifiers changed from: private */
        public OnPopShowListener onPopShowListener;
        /* access modifiers changed from: private */
        public OnPopupItemClickListener onPopupItemClickListener;

        public PopupVideoShareInfo build() {
            return new PopupVideoShareInfo(this);
        }

        public Builder myResolveInfoList(List<MyResolveInfo> list) {
            this.myResolveInfoList = list;
            return this;
        }

        public Builder onPopupItemClickListener(OnPopupItemClickListener onPopupItemClickListener2) {
            this.onPopupItemClickListener = onPopupItemClickListener2;
            return this;
        }

        public Builder onPopupShowListener(OnPopShowListener onPopShowListener2) {
            this.onPopShowListener = onPopShowListener2;
            return this;
        }
    }

    public interface OnPopShowListener {
        void onShow(boolean z);
    }

    public interface OnPopupItemClickListener {
        void onItemClick(MyResolveInfo myResolveInfo);
    }

    private PopupVideoShareInfo(Builder builder) {
        this.myResolveInfoList = builder.myResolveInfoList;
        this.onPopupItemClickListener = builder.onPopupItemClickListener;
        this.onPopShowListener = builder.onPopShowListener;
    }
}
