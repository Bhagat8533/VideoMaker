package com.aiii.sdk.android.oss.model;

import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.util.Date;

public class OSSBucketSummary {
    private CannedAccessControlList acl;
    public Date createDate;
    public String extranetEndpoint;
    public String intranetEndpoint;
    public String location;
    public String name;
    public Owner owner;
    public String storageClass;

    public String getAcl() {
        if (this.acl != null) {
            return this.acl.toString();
        }
        return null;
    }

    public void setAcl(String str) {
        this.acl = CannedAccessControlList.parseACL(str);
    }

    public String toString() {
        if (this.storageClass == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("OSSBucket [name=");
            sb.append(this.name);
            sb.append(", creationDate=");
            sb.append(this.createDate);
            sb.append(", owner=");
            sb.append(this.owner.toString());
            sb.append(", location=");
            sb.append(this.location);
            sb.append(RequestParameters.RIGHT_BRACKETS);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OSSBucket [name=");
        sb2.append(this.name);
        sb2.append(", creationDate=");
        sb2.append(this.createDate);
        sb2.append(", owner=");
        sb2.append(this.owner.toString());
        sb2.append(", location=");
        sb2.append(this.location);
        sb2.append(", storageClass=");
        sb2.append(this.storageClass);
        sb2.append(RequestParameters.RIGHT_BRACKETS);
        return sb2.toString();
    }
}
