byte[] kd = key.getBytes("UTF-8");

SecretKeySpec ks = new SecretKeySpec(kd, "Blowfish");
Cipher cipher = Cipher.getInstance("Blowfish");
cipher.init(Cipher.ENCRYPT_MODE, ks);

byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

String str = new String(Base64.encodeBase64(encrypted), "UTF-8");
