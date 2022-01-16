package gui.i18n;

public class Urdu implements Language {
    @Override
    public String goBack() {
        return "واپس جاو";
    }

    @Override
    public String split() {
        return "تقسیم";
    }

    @Override
    public String paidBy() {
        return "کس نے ادا کیا؟";
    }

    @Override
    public String ticketName() {
        return "ٹکٹ کا نام کیا ہے؟";
    }

    @Override
    public String ticketType() {
        return "یہ کس قسم کا ٹکٹ ہے؟";
    }

    @Override
    public String ticketPrice() {
        return "ٹکٹ کی قیمت کیا ہے؟";
    }

    @Override
    public String addUser() {
        return "صارف شامل کریں۔";
    }

    @Override
    public String userName() {
        return "آپ کا نام کیا ہے؟";
    }

    @Override
    public String pays() {
        return "%s کو %s سے%s€ موصول ہوتا ہے۔";
    }

    @Override
    public String receives() {
        return "%s %s کو %s€ ادا کرتا ہے۔";
    }

    @Override
    public String getsGives() {
        return "ملتا/دیتا ہے۔ ";
    }

    @Override
    public String amount() {
        return " رقم: ";
    }

    @Override
    public String addTicket() {
        return "ٹکٹ شامل کریں۔";
    }

    @Override
    public String checkSum() {
        return "رقم چیک کریں۔";
    }

    @Override
    public String dividedUniformly() {
        return "یکساں طور پر تقسیم";
    }

    @Override
    public String dividedNonUniformly() {
        return "غیر یکساں طور پر تقسیم";
    }

    @Override
    public String totalPrice() {
        return "کل قیمت: ";
    }

    @Override
    public String viewUsers() {
        return "صارفین کو دیکھیں";
    }

    @Override
    public String viewTickets() {
        return "موجودہ ٹکٹ دیکھیں";
    }

    @Override
    public String calculate() {
        return "حساب لگانا";
    }

    @Override
    public String exit() {
        return "باہر نکلیں";
    }

    @Override
    public String yourSum() {
        return "آپ کا مجموعہ: ";
    }

    @Override
    public String correctSum() {
        return "درست رقم: ";
    }

    @Override
    public String missingSum() {
        return "وہاں کمی ہے: ";
    }

    @Override
    public String yourCorrectSum() {
        return "صحیح اور آپ کا مجموعہ: ";
    }

    @Override
    public String priceNotValidError() {
        return "براہ کرم ان پٹ کو چیک کریں!";
    }

    @Override
    public String checkSumError() {
        return "براہ کرم اپنی رقم چیک کریں!";
    }

    @Override
    public String fillInPriceError() {
        return "براہ کرم قیمت بھریں!";
    }

    @Override
    public String currentLanguage() {
        return "Urdu";
    }

    @Override
    public String changeLanguage() {
        return "زبان کو اردو میں تبدیل کریں۔";
    }

    @Override
    public Boolean isRTL() {
        return true;
    }
}
