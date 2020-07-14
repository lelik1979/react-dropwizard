package org.home;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.conscrypt.Conscrypt;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.Security;

/**
 * Hello world!
 */
public class App {

    //Due to it is self signed certificate on server I need to add it to the trust store on the client side too.
    public static final String CERT_FILE_LOCATION = "okhttp-client/localhost.cer";

    static {
        // switch to use Conscrypt library for http2
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
    }

    public static void main(String[] args) throws Exception {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());

        SSLSocketFactory sslFactory = SSLFactoryBuilder.createSSLConnectionFactory(CERT_FILE_LOCATION, trustManagerFactory);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslFactory, (X509TrustManager) trustManagerFactory.getTrustManagers()[0])
                // this is only require to fix self signed certificate verification
                .hostnameVerifier((hostname, session) -> true)
                .build();
        Request request = new Request.Builder().url("https://localhost:8085/api/someApi").build();
        okhttp3.Response response = okHttpClient.newCall(request).execute();
        System.out.println("Request: " + request);
        System.out.println("Response: " + response);
        System.out.println("Body: " + response.body().string());

    }

}
