package main;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("ficheiro");
        BufferedInputStream bin = createBufferInputStream(fichero);
        byte[] hash = getFileHash(bin);
        toHexString(hash);
    }

    private static byte[] getFileHash(BufferedInputStream bin) {
        byte[] hash=new byte[0];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bin.readAllBytes());
            hash = md.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return hash;
    }

    private static BufferedInputStream createBufferInputStream(File fichero) {
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bin;
    }

    private static void toHexString(byte[] hash) {
        StringBuilder result= new StringBuilder();
        for (byte b : hash) {
            result.append(String.format("%x", b));
        }
        System.out.println(result);
    }
}
