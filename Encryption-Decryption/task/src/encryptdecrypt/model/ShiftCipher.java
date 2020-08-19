package encryptdecrypt.model;

public class ShiftCipher implements Cipher {
    @Override
    public String encrypt(String text, int key) {
        StringBuilder cipherText = new StringBuilder();
        for (char letter : text.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                int originalAlphabetPosition = letter - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                cipherText.append(newCharacter);
            } else if (Character.isUpperCase(letter)) {
                int originalAlphabetPosition = letter - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                cipherText.append(newCharacter);
            } else {
                cipherText.append(letter);
            }
        }
        return cipherText.toString();
    }

    @Override
    public String decrypt(String cipherText, int key) {
        return encrypt(cipherText, 26 - (key % 26));
    }
}
