package com.introvd.template.apicore;

/* renamed from: com.introvd.template.apicore.p */
public class C3639p {
    public String bhD;
    public long bhE;
    public int errorCode;
    public String errorMsg;
    public String method;
    public int statusCode;
    public String url;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============= \nURL ==> ");
        sb.append(this.url);
        sb.append("\nMethod ==> ");
        sb.append(this.method);
        sb.append("\nParam ==> ");
        sb.append(this.bhD);
        sb.append("\nStatusCode ==> ");
        sb.append(this.statusCode);
        sb.append("\nErrorCode ==> ");
        sb.append(this.errorCode);
        sb.append("\nErrorMsg ==> ");
        sb.append(this.errorMsg);
        sb.append("\nCostMills ==> ");
        sb.append(this.bhE);
        sb.append("\n============= ");
        return sb.toString();
    }
}
