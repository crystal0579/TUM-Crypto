        FileInputStream  file = new FileInputStream("src/image/AA.jpg");
        FileOutputStream output = new FileOutputStream("src/image/AAA.jpg");
        byte j[]="12345678".getBytes();
        SecretKeySpec kye = new SecretKeySpec(j,"DES");
        System.out.println(kye);
        Cipher enc = Cipher.getInstance("DES");
        enc.init(Cipher.DECRYPT_MODE,kye);
        CipherOutputStream cos = new CipherOutputStream(output, enc);
        byte[] buf = new byte[1024];
        int read;
        while((read=file.read(buf))!=-1){
            cos.write(buf,0,read);
        }
        file.close();
        output.flush();
        cos.close();
