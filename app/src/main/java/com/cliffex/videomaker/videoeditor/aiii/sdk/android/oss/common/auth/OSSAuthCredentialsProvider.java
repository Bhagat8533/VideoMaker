package com.aiii.sdk.android.oss.common.auth;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.common.utils.IOUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OSSAuthCredentialsProvider extends OSSFederationCredentialProvider {
    private String mAuthServerUrl;
    private AuthDecoder mDecoder;

    public interface AuthDecoder {
        String decode(String str);
    }

    public OSSAuthCredentialsProvider(String str) {
        this.mAuthServerUrl = str;
    }

    public OSSFederationToken getFederationToken() throws ClientException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mAuthServerUrl).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            String readStreamAsString = IOUtils.readStreamAsString(httpURLConnection.getInputStream(), "utf-8");
            if (this.mDecoder != null) {
                readStreamAsString = this.mDecoder.decode(readStreamAsString);
            }
            JSONObject jSONObject = new JSONObject(readStreamAsString);
            if (jSONObject.getInt("StatusCode") == 200) {
                return new OSSFederationToken(jSONObject.getString("AccessKeyId"), jSONObject.getString("AccessKeySecret"), jSONObject.getString("SecurityToken"), jSONObject.getString("Expiration"));
            }
            String string = jSONObject.getString("ErrorCode");
            String string2 = jSONObject.getString("ErrorMessage");
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorCode: ");
            sb.append(string);
            sb.append("| ErrorMessage: ");
            sb.append(string2);
            throw new ClientException(sb.toString());
        } catch (Exception e) {
            throw new ClientException((Throwable) e);
        }
    }

    public void setAuthServerUrl(String str) {
        this.mAuthServerUrl = str;
    }

    public void setDecoder(AuthDecoder authDecoder) {
        this.mDecoder = authDecoder;
    }
}
