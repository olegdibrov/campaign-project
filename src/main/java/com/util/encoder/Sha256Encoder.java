package com.util.encoder;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Sha256Encoder implements IEncoder {
    public static final Logger LOGGER = Logger.getLogger(Sha256Encoder.class);
    @Override
    public String encode(String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Can't find that algorithm", e);
            return null;
        }
        byte[] hash = messageDigest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
