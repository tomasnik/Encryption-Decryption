package encryptdecrypt.model;

public class UnicodeCipher implements Cipher {
    @Override
    public String encrypt(String text, int key) {
        StringBuilder cipherText = new StringBuilder();
        for (char character : text.toCharArray()) {
            cipherText.append((char) (character + key));
        }
        return cipherText.toString();
    }

    @Override
    public String decrypt(String cipherText, int key) {
        StringBuilder text = new StringBuilder();
        for (char character : cipherText.toCharArray()) {
            text.append((char) (character - key));
        }
        return text.toString();
    }
}
