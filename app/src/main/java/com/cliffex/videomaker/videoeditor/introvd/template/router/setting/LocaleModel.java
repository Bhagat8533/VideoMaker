package com.introvd.template.router.setting;

import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;

public class LocaleModel {
    public String name;
    public String value = SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE;

    public LocaleModel() {
    }

    public LocaleModel(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocaleModel localeModel = (LocaleModel) obj;
        if (this.value != null) {
            z = this.value.equals(localeModel.value);
        } else if (localeModel.value != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.value != null) {
            return this.value.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(',');
        sb.append(this.value);
        return sb.toString();
    }
}
