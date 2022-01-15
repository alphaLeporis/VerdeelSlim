package gui.i18n;

public interface Language {
    //General
    String goBack();

    //addTicket
    String split();
    String paidBy();
    String ticketName();
    String ticketType();
    String ticketPrice();

    //Adding users
    String addUser();
    String userName();


    //Calculate
    String pays();
    String receives();
    String getsGives();
    String amount();

    //Dividing
    String addTicket();
    String checkSum();
    String dividedUniformly();
    String dividedNonUniformly();
    String totalPrice();

    //StartState
    String viewUsers();
    String viewTickets();
    String calculate();
    String exit();

    // Sum
    String yourSum();
    String correctSum();
    String missingSum();
    String yourCorrectSum();

    // Errors
    String priceNotValidError();
    String checkSumError();
    String fillInPriceError();

    // Method
    String currentLanguage();
    String changeLanguage();
}
