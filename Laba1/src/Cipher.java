/**
 *  Группа АП-71
 *  Царенко А.В.
 *  Вариант 12
 *  Задание:
 *  Класс, кодирования/восстановления сообщений по ключу
 */

import java.io.*;
import java.util.Scanner;
import javax.crypto.*;
import java.security.*;

public class Cipher{
    /**
     *
     * @param args аргументы передаваемые программе
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws IOException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
    {
        try {
            System.out.println("Класс, кодирования/восстановления сообщений по ключу");
            int selection;
            Scanner in = new Scanner(System.in);
            String oriTxt, encTxt, decTxt;
            Cesar a = new Cesar();
            System.out.print("Выберите шифр 0 или 1: ");
            try {
                selection = Integer.parseInt(in.nextLine());
            }catch (Exception e){
                selection = -1;
            }
            while (selection<0 || selection>1) {
                System.out.println("Не понял!");
                System.out.print("Выберите шифр 0 или 1: ");
                try {
                    selection = Integer.parseInt(in.nextLine());
                }catch(Exception e){
                    selection = -1;
                }
            }

            if (selection == 0) {
                do {
                    System.out.print("Введите ключ: ");
                }
                while (!a.setSet(in.nextInt()));
                System.out.print("Введите текст: ");
                BufferedReader b;
                b = new BufferedReader(new InputStreamReader(System.in));
                oriTxt = b.readLine();

                if (a.getSet() > 0) {
                    encTxt = a.encrypt(oriTxt);
                    System.out.println("Зашифрованный текст: " + encTxt);

                    decTxt = a.decrypt(encTxt);
                    System.out.println("Расшифрованный текст: " + decTxt);

                } else {
                    System.out.println("Текст не изменен, т.к. set<=0: " + oriTxt);
                }
            }else if (selection == 1) {

                System.out.print("Введите текст: ");
                BufferedReader b;
                b = new BufferedReader(new InputStreamReader(System.in));
                oriTxt = b.readLine();

                SecretKey key=null;
                key = KeyGenerator.getInstance("DES").generateKey();
                DesCrypt encrypted = new DesCrypt(key);

                encTxt = encrypted.encrypt2(oriTxt);
                System.out.println("Зашифрованный текст: " + encTxt);

                decTxt = encrypted.decrypt2(encTxt);
                System.out.println("Расшифрованный текст: " + decTxt);

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
