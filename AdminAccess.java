// یہ کوڈ صرف مخصوص نمبر کو ایڈمن پاور دے گا
public class AdminAccess {
    public static final String SUPER_ADMIN_NUMBER = "+923270394662";

    public static boolean isUserAdmin(String phoneNumber) {
        return phoneNumber.equals(SUPER_ADMIN_NUMBER);
    }
}
