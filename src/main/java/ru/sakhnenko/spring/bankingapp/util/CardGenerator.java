package ru.sakhnenko.spring.bankingapp.util;

import ru.sakhnenko.spring.bankingapp.repository.ClientRepository;

import java.util.Random;

public class CardGenerator {

    public static String generateCardNumber(ClientRepository clientRepository) {
        Random rnd = new Random();
        String result = "400000";
        result += String.format("%09d", rnd.nextInt(1000_000_000));
        int sum = getNumberSum(result);
        if (sum % 10 == 0) {
            result += 0;
        } else {
            result += 10 - (sum % 10);
        }
        if (clientRepository.findClientByCardNumber(result) != null) {
            generateCardNumber(clientRepository);
        }
        return result;
    }

    private static int getNumberSum(String str)
    {
        int sum = 0;
        char[] strToArray = str.toCharArray();
        for (int i = 0; i < strToArray.length; i++) {
            int num = Integer.parseInt(strToArray[i] + "");
            if (i % 2 == 0) {
                num *= 2;
                if (num > 9) {
                    num -= 9;
                }
            }
            sum += num;
        }
        return sum;
    }

    public static String generatePin() {
        Random rnd = new Random();
        int nmb = rnd.nextInt(10000);
        return (String.format("%04d", nmb));
    }

    public static boolean isLuhnAlg(String num)
    {
        int sum = getNumberSum(num);
        int lastNum = num.charAt(num.length() - 1)  - '0';
        sum -= lastNum;
        if (sum % 10 == 0) {
            if (lastNum == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (10 - sum % 10 == lastNum) {
                return true;
            } else {
                return false;
            }
        }
    }
}
