Exception in thread "main" java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
        at java.lang.reflect.Method.invoke(Unknown Source)
        at org.eclipse.jdt.internal.jarinjarloader.JarRsrcLoader.main(JarRsrcLoa der.java:58) Caused by: java.lang.UnsatisfiedLinkError: java.lang.StrictMath.floor(D)D
        at java.lang.StrictMath.floor(Native Method)
        at java.lang.Math.floor(Unknown Source)
        at sun.misc.FloatingDecimal.dtoa(Unknown Source)
        at sun.misc.FloatingDecimal.<init>(Unknown Source)
        at java.lang.Double.toString(Unknown Source)
        at java.lang.String.valueOf(Unknown Source)
        at java.security.Provider.putId(Unknown Source)
        at java.security.Provider.<init>(Unknown Source)
        at sun.security.provider.Sun.<init>(Unknown Source)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)

        at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)

        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Sou rce)
        at java.lang.reflect.Constructor.newInstance(Unknown Source)
        at java.lang.Class.newInstance0(Unknown Source)
        at java.lang.Class.newInstance(Unknown Source)
        at sun.security.jca.ProviderConfig$3.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at sun.security.jca.ProviderConfig.doLoadProvider(Unknown Source)
        at sun.security.jca.ProviderConfig.getProvider(Unknown Source)
        at sun.security.jca.ProviderList.getProvider(Unknown Source)
        at sun.security.jca.ProviderList.getService(Unknown Source)
        at sun.security.jca.GetInstance.getInstance(Unknown Source)
        at java.security.Security.getImpl(Unknown Source)
        at java.security.MessageDigest.getInstance(Unknown Source)
        at org.postgresql.util.MD5Digest.encode(MD5Digest.java:46)
        at org.postgresql.core.v3.ConnectionFactoryImpl.doAuthentication(Connect ionFactoryImpl.java:328)
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(Conne ctionFactoryImpl.java:95)
        at org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactor y.java:66)
        at org.postgresql.jdbc2.AbstractJdbc2Connection.<init>(AbstractJdbc2Conn ection.java:124)
        at org.postgresql.jdbc3.AbstractJdbc3Connection.<init>(AbstractJdbc3Conn ection.java:30)
        at org.postgresql.jdbc4.AbstractJdbc4Connection.<init>(AbstractJdbc4Conn ection.java:29)
        at org.postgresql.jdbc4.Jdbc4Connection.<init>(Jdbc4Connection.java:24)
        at org.postgresql.Driver.makeConnection(Driver.java:386)
        at org.postgresql.Driver.connect(Driver.java:260)
        at java.sql.DriverManager.getConnection(Unknown Source)
        at java.sql.DriverManager.getConnection(Unknown Source)
        at db.PostgresHandler.connect(PostgresHandler.java:70)
        at db.PostgresHandler.<init>(PostgresHandler.java:47)
        at db.DBInsertHandler.<init>(DBInsertHandler.java:16)
        at Server.main(Server.java:62)
        ... 5 more
