package com.ludocashking.core;

import android.view.View;

/**
 * Ludo Cash King - Admin Access Control
 * This class manages who can see the admin dashboard and control the game.
 */
public class AdminAccess {

    // کلائنٹ کا نمبر بطور سپر ایڈمن
    public static final String SUPER_ADMIN_NUMBER = "+923270394662";

    /**
     * یہ فنکشن چیک کرتا ہے کہ لاگ ان کرنے والا نمبر ایڈمن ہے یا نہیں
     */
    public static boolean isUserAdmin(String phoneNumber) {
        if (phoneNumber == null) return false;
        
        // نمبر کو صاف کرنا (تاکہ سپیس یا پلس کا مسئلہ نہ ہو)
        String cleanNumber = phoneNumber.replace(" ", "").replace("-", "");
        return cleanNumber.equals(SUPER_ADMIN_NUMBER);
    }

    /**
     * صرف ایڈمن کو کنٹرول بٹن دکھانے کے لیے
     */
    public static void setupAdminView(String userNumber, View adminButton) {
        if (isUserAdmin(userNumber)) {
            adminButton.setVisibility(View.VISIBLE);
        } else {
            adminButton.setVisibility(View.GONE);
        }
    }
}
