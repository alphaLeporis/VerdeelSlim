package gui.i18n;

public class French implements Language {
    @Override
    public String goBack() {
        return "Retourner";
    }

    @Override
    public String split() {
        return "Divisé";
    }

    @Override
    public String paidBy() {
        return "Qui a payé ?";
    }

    @Override
    public String ticketName() {
        return "Quel est le nom du billet ?";
    }

    @Override
    public String ticketType() {
        return "De quel type de billet s'agit-il ?";
    }

    @Override
    public String ticketPrice() {
        return "Quel est le prix du billet ?";
    }

    @Override
    public String addUser() {
        return "Ajouter un utilisateur";
    }

    @Override
    public String userName() {
        return "Quel est votre nom ?";
    }

    @Override
    public String pays() {
        return "%s reçoit %.2f€ de %s.";
    }

    @Override
    public String receives() {
        return "%s paie %.2f€ à %s.";
    }

    @Override
    public String getsGives() {
        return " obtient/donne ";
    }

    @Override
    public String amount() {
        return " montant : ";
    }

    @Override
    public String addTicket() {
        return "Ajouter un billet";
    }

    @Override
    public String checkSum() {
        return "Vérifier la somme";
    }

    @Override
    public String dividedUniformly() {
        return "Divisé uniformément";
    }

    @Override
    public String dividedNonUniformly() {
        return "Divisé de manière non-uniforme";
    }

    @Override
    public String totalPrice() {
        return "Prix total : ";
    }

    @Override
    public String viewUsers() {
        return "Afficher les utilisateurs";
    }

    @Override
    public String viewTickets() {
        return "Voir les billets actuels";
    }

    @Override
    public String calculate() {
        return "Calculer";
    }

    @Override
    public String exit() {
        return "Sortir";
    }

    @Override
    public String yourSum() {
        return "Votre somme : ";
    }

    @Override
    public String correctSum() {
        return "La somme correcte : ";
    }

    @Override
    public String missingSum() {
        return "Il manque : ";
    }

    @Override
    public String yourCorrectSum() {
        return "La bonne et votre somme : ";
    }

    @Override
    public String priceNotValidError() {
        return "Veuillez vérifier la saisie !";
    }

    @Override
    public String checkSumError() {
        return "Veuillez vérifier votre somme !";
    }

    @Override
    public String fillInPriceError() {
        return "Veuillez indiquer un prix !";
    }

    @Override
    public String currentLanguage() {
        return "Français";
    }

    @Override
    public String changeLanguage() {
        return "Changer la langue en français";
    }
}
