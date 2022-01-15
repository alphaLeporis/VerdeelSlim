package gui;

public class Nederlands implements Language{
    @Override
    public String goBack() {
        return "Keer terug";
    }

    @Override
    public String split() {
        return "Verdeel";
    }

    @Override
    public String paidBy() {
        return "Wie heeft betaald?";
    }

    @Override
    public String ticketName() {
        return "Wat is de naam van het ticket?";
    }

    @Override
    public String ticketType() {
        return "Wat voor een ticket was het?";
    }

    @Override
    public String ticketPrice() {
        return "Hoeveel kostte dit ticket?";
    }

    @Override
    public String addUser() {
        return "Gebruiker toevoegen";
    }

    @Override
    public String userName() {
        return "Wat is je naam?";
    }

    @Override
    public String getsGives() {
        return " krijgt/geeft van/aan ";
    }

    @Override
    public String amount() {
        return " bedrag: ";
    }

    @Override
    public String addTicket() {
        return "Voeg ticket toe";
    }

    @Override
    public String checkSum() {
        return "Kijk na";
    }

    @Override
    public String dividedUniformly() {
        return "Even verdeeld";
    }

    @Override
    public String dividedNonUniformly() {
        return "Oneven verdeeld";
    }

    @Override
    public String totalPrice() {
        return "Totaal prijs: ";
    }

    @Override
    public String viewUsers() {
        return "Bekijk gebruikers";
    }

    @Override
    public String viewTickets() {
        return "Bekijk huidige tickets";
    }

    @Override
    public String calculate() {
        return "Bereken";
    }

    @Override
    public String exit() {
        return "Sluit af";
    }
}
