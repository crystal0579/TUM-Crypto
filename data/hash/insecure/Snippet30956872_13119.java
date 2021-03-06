try {
    PackageInfo info = getPackageManager().getPackageInfo(
            "hu.returpack.mindendoboz",
            PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
    }
} catch (NoSuchAlgorithmException | PackageManager.NameNotFoundException e) {
    e.printStackTrace();
}
