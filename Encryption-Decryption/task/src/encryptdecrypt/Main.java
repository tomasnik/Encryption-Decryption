package encryptdecrypt;

import encryptdecrypt.model.Cipher;
import encryptdecrypt.model.Mode;
import encryptdecrypt.model.ShiftCipher;
import encryptdecrypt.model.UnicodeCipher;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Cipher algorithm = new ShiftCipher();
        Mode mode = null;
        int key = 0;
        String input = "";
        File outFile = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-alg")) {
                if (args[i + 1].equals("unicode")) {
                    algorithm = new UnicodeCipher();
                }
            }
            if (args[i].equals("-mode")) {
                switch (args[i + 1]) {
                    case "enc":
                        mode = Mode.ENCRYPT;
                        break;
                    case "dec":
                        mode = Mode.DECRYPT;
                        break;
                }
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                input = args[i + 1];
            }
            if (args[i].equals("-in")) {
                File inputFile = new File("/home/tomas/IdeaProjects/Encryption-Decryption/Encryption-Decryption/task/" + args[i + 1]);
                Scanner fileScanner = new Scanner(inputFile);
                input = fileScanner.nextLine();
                fileScanner.close();
            }
            if (args[i].equals("-out")) {
                outFile = new File(args[i + 1]);
            }
        }
        switch (mode) {
            case ENCRYPT:
                if (outFile != null) {
                    FileWriter fileWriter = new FileWriter(outFile);
                    fileWriter.write(algorithm.encrypt(input, key));
                    fileWriter.close();
                } else {
                    System.out.println(algorithm.encrypt(input, key));
                }
                break;
            case DECRYPT:
                if (outFile != null) {
                    FileWriter fileWriter = new FileWriter(outFile);
                    fileWriter.write(algorithm.decrypt(input, key));
                    fileWriter.close();
                } else {
                    System.out.println(algorithm.decrypt(input, key));
                }
                break;
        }
    }
}
