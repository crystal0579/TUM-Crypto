        ...
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, trustManager, null);
        SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
        ...
