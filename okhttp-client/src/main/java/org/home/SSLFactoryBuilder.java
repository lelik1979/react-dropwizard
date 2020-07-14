package org.home;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SSLFactoryBuilder {

    public static SSLSocketFactory createSSLConnectionFactory(String certificateUrl, TrustManagerFactory trustManager) throws Exception {

        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream cert = new FileInputStream(certificateUrl);

        Certificate certificate = certificateFactory.generateCertificate(cert);
        cert.close();

        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("Certificate Entry", certificate);

        trustManager.init(keyStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManager.getTrustManagers(), null);

        return sslContext.getSocketFactory();
    }

}
