package encryptdecrypt.model;

public interface Cipher {
    String encrypt(String text, int key);

    String decrypt(String cipherText, int key);
}
