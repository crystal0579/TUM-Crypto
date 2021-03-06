import javax.net.ssl.*;
import pakeightball.*;

public class HelloWorldClient {

    public static void DisableCertificateValidation() {
          TrustManager[] trustAllCerts = new TrustManager[]{
              new X509TrustManager() {
                  public X509Certificate[] getAcceptedIssuers() { return null; }
                  public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                  public void checkServerTrusted(X509Certificate[] certs, String authType) { }
              }
          };
          try {
              SSLContext sc = SSLContext.getInstance("SSL");
              sc.init(null, trustAllCerts, new java.security.SecureRandom());
              HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
          } catch (Exception e) {
          }
    }

    public static void main(String[] argv) {
      MagicEightBallService locator = new MagicEightBallService();
      IMagicEightBallService service = locator.getWSHttpBindingTransportSecurityIMagicEightBallService();

      // disable certificate validation
      DisableCertificateValidation();

      //invoke business method
      String result = service.getAdvice();
      System.out.println(result);
    }

}
