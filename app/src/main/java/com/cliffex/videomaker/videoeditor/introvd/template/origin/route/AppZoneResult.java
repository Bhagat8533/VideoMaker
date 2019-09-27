package com.introvd.template.origin.route;

import android.support.annotation.Keep;
import java.util.List;

@Keep
public class AppZoneResult {
    private String country;
    private String zone;
    private List<ZonesBean> zones;

    @Keep
    public static class ZonesBean {
        private List<CountrylistBean> countrylist;
        /* access modifiers changed from: private */
        public List<DomainlistBean> domainlist;
        /* access modifiers changed from: private */
        public String zone;

        @Keep
        public static class CountrylistBean {
            private String code;
            private int sns;

            public String getCode() {
                return this.code;
            }

            public int getSns() {
                return this.sns;
            }

            public void setCode(String str) {
                this.code = str;
            }

            public void setSns(int i) {
                this.sns = i;
            }
        }

        @Keep
        public static class DomainlistBean {
            /* access modifiers changed from: private */
            public String domain;
            /* access modifiers changed from: private */
            public String url;

            public String getDomain() {
                return this.domain;
            }

            public String getUrl() {
                return this.url;
            }

            public void setDomain(String str) {
                this.domain = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public List<CountrylistBean> getCountrylist() {
            return this.countrylist;
        }

        public List<DomainlistBean> getDomainlist() {
            return this.domainlist;
        }

        public String getZone() {
            return this.zone;
        }

        public void setCountrylist(List<CountrylistBean> list) {
            this.countrylist = list;
        }

        public void setDomainlist(List<DomainlistBean> list) {
            this.domainlist = list;
        }

        public void setZone(String str) {
            this.zone = str;
        }
    }

    public String getCountry() {
        return this.country;
    }

    public String getZone() {
        return this.zone;
    }

    public List<ZonesBean> getZones() {
        return this.zones;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setZone(String str) {
        this.zone = str;
    }

    public void setZones(List<ZonesBean> list) {
        this.zones = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("zone: ");
        sb.append(getZone());
        sb.append("\ncountry: ");
        sb.append(this.country);
        sb.append("\n");
        String sb2 = sb.toString();
        for (ZonesBean zonesBean : this.zones) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("  Zone : ");
            sb3.append(zonesBean.zone);
            sb3.append("\n  domainlist : \n");
            sb2 = sb3.toString();
            for (DomainlistBean domainlistBean : zonesBean.domainlist) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append("    domain : ");
                sb4.append(domainlistBean.domain);
                sb4.append("\n      url : ");
                sb4.append(domainlistBean.url);
                sb4.append("\n");
                sb2 = sb4.toString();
            }
        }
        return sb2;
    }
}
