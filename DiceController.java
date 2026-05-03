package com.ludocashking.game;

import java.util.Random;

/**
 * Ludo Cash King - Dice Logic with Admin Control
 */
public class DiceController {

    private static int forcedNumber = 0; // 0 کا مطلب ہے کوئی کنٹرول نہیں، رینڈم چلے گا

    /**
     * ایڈمن اس فنکشن کے ذریعے نمبر فکس کر سکتا ہے
     * @param number (1 سے 6 کے درمیان کوئی بھی نمبر)
     */
    public static void setAdminOverride(int number) {
        if (number >= 1 && number <= 6) {
            forcedNumber = number;
        } else {
            forcedNumber = 0; // کنٹرول ختم کرنے کے لیے
        }
    }

    /**
     * ڈائس رول کرنے کا اصلی لاجک
     */
    public static int rollDice() {
        // اگر ایڈمن نے کوئی نمبر فکس کیا ہوا ہے تو وہی واپس کرو
        if (forcedNumber != 0) {
            int result = forcedNumber;
            // ایک بار نمبر دینے کے بعد اسے واپس 0 کر دیں تاکہ ہر بار وہی نہ آئے (آپ کی مرضی پر ہے)
            forcedNumber = 0; 
            return result;
        }

        // ورنہ عام کھلاڑی کے لیے رینڈم نمبر (1-6)
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
