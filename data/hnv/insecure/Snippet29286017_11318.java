 HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
AssetManager assetManager = MainActivity.ctx.getAssets();
InputStream requestXML = assetManager.open("requestdump");         
String requestString = convertStreamToString(requestXML);
java.net.URL url = new URL("https://nn.nnn.nnn.nnn:xxxx");
HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
urlConnection.setSSLSocketFactory(getSSLSocketFactory());
urlConnection.setReadTimeout(10000);
urlConnection.setConnectTimeout(15000);
urlConnection.setRequestMethod("POST");
urlConnection.setHostnameVerifier(hostnameVerifier );
urlConnection.setDoInput(true);
urlConnection.setDoOutput(true);
byte[] outputInBytes = requestString.getBytes("UTF-8");       
OutputStream os = urlConnection.getOutputStream();
os.write( outputInBytes );
os.close();             
InputStream in = urlConnection.getInputStream();
