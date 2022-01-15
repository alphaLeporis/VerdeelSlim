package gui.i18n;

import gui.i18n.Language;

public class English implements Language {
    @Override
    public String goBack() {
        return "Go back";
    }

    @Override
    public String split() {
        return "Split";
    }

    @Override
    public String paidBy() {
        return "Who paid?";
    }

    @Override
    public String ticketName() {
        return "What is the ticket's name?";
    }

    @Override
    public String ticketType() {
        return "What type of ticket is it?";
    }

    @Override
    public String ticketPrice() {
        return "What's the ticket's price?";
    }

    @Override
    public String addUser() {
        return "Add user";
    }

    @Override
    public String userName() {
        return "What's your name?";
    }

    @Override
    public String pays() {
        return "%s receives %.2f€ from %s.";
    }

    @Override
    public String receives() {
        return "%s pays %.2f€ to %s.";
    }

    @Override
    public String getsGives() {
        return " gets/gives ";
    }

    @Override
    public String amount() {
        return " amount: ";
    }

    @Override
    public String addTicket() {
        return "Add ticket";
    }

    @Override
    public String checkSum() {
        return "Check sum";
    }

    @Override
    public String dividedUniformly() {
        return "Divided uniformly";
    }

    @Override
    public String dividedNonUniformly() {
        return "Divided non-uniformly";
    }

    @Override
    public String totalPrice() {
        return "Total price: ";
    }

    @Override
    public String viewUsers() {
        return "View users";
    }

    @Override
    public String viewTickets() {
        return "View current tickets";
    }

    @Override
    public String calculate() {
        return "Calculate";
    }

    @Override
    public String exit() {
        return "Exit";
    }

    @Override
    public String yourSum() {
        return "Your sum: ";
    }

    @Override
    public String correctSum() {
        return "The correct sum: ";
    }

    @Override
    public String missingSum() {
        return "There misses: ";
    }

    @Override
    public String yourCorrectSum() {
        return "The correct and your sum: ";
    }

    @Override
    public String priceNotValidError() {
        return "Please check the input!";
    }

    @Override
    public String checkSumError() {
        return "Please check your sum!";
    }

    @Override
    public String fillInPriceError() {
        return "Please fill in a price!";
    }

    @Override
    public String currentLanguage() {
        return "English";
    }

    @Override
    public String changeLanguage() {
        return "Change language to English";
    }
}
