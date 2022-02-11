package main;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("ficheiro");
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bin.readAllBytes());
            byte[] hash = md.digest();
            toHexString(hash);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void toHexString(byte[] hash) {
        StringBuilder result= new StringBuilder();
        for (byte b : hash) {
            result.append(String.format("%x", b));
        }
        System.out.println(result);
    }
}
