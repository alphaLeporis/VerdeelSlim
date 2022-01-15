package gui;

public class English implements Language{
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
}
