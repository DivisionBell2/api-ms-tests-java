package ru.projects.entities.auth;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Auth {

    public static Map<String, String> generateSignature() {
        String basedir = System.getProperty("user.dir");
        byte[] keyBytes = new byte[0];
        try {
            keyBytes = Files.readAllBytes(Paths.get(basedir + "/keys/private.der"));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            System.out.print(e.getMessage());
        }
        PrivateKey privateKey = null;
        try {
            privateKey = keyFactory.generatePrivate(spec);
        } catch (InvalidKeySpecException e) {
            System.out.print(e.getMessage());
        }
        String requestId = UUID.randomUUID().toString();
        long currentTimeInThousandsOfSeconds =
                ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond() / 1000000L;
        String message = String.valueOf(currentTimeInThousandsOfSeconds) + requestId;
        Signature signer = null;
        try {
            signer = Signature.getInstance("SHA256withRSA");
        } catch (NoSuchAlgorithmException e) {
            System.out.print(e.getMessage());
        }
        try {
            signer.initSign(privateKey);
        } catch (InvalidKeyException e) {
            System.out.print(e.getMessage());
        }
        try {
            signer.update(message.getBytes());
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        String signature = null;
        try {
            signature = DatatypeConverter.printBase64Binary(signer.sign());
        } catch (SignatureException e) {
            e.printStackTrace();
            System.out.print("Signature creation was failed. Error message is - " + e.getMessage());
        }
        Map<String, String> data = new HashMap<>();
        data.put("requestId", requestId);
        data.put("signature", signature);
        return data;
    }
}
