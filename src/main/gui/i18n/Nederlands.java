package gui.i18n;

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
    public String pays() {
        return "%s moet %.2f€ van %s krijgen.";
    }

    @Override
    public String receives() {
        return "%s moet %.2f€ aan %s betalen.";
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

    @Override
    public String yourSum() {
        return "Jouw som: ";
    }

    @Override
    public String correctSum() {
        return "De correcte som: ";
    }

    @Override
    public String missingSum() {
        return "Er mist: ";
    }

    @Override
    public String yourCorrectSum() {
        return "De correcte en jouw som: ";
    }

    @Override
    public String priceNotValidError() {
        return "De ingevulde prijs is niet geldig!";
    }

    @Override
    public String checkSumError() {
        return "De totale som is niet correct!";
    }

    @Override
    public String fillInPriceError() {
        return "Vul een prijs in!";
    }

    @Override
    public String currentLanguage() {
        return "Nederlands";
    }

    @Override
    public String changeLanguage() {
        return "Verander taal in Nederlands";
    }

    @Override
    public Boolean isRTL() {
        return false;
    }
}
