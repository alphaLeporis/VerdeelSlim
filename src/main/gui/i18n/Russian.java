package gui.i18n;

public class Russian implements Language {
    @Override
    public String goBack() {
        return "Вернуться назад";
    }

    @Override
    public String split() {
        return "Сплит";
    }

    @Override
    public String paidBy() {
        return "Кто заплатил?";
    }

    @Override
    public String ticketName() {
        return "Как называется билет?";
    }

    @Override
    public String ticketType() {
        return "Какой тип билета?";
    }

    @Override
    public String ticketPrice() {
        return "Какова цена билета?";
    }

    @Override
    public String addUser() {
        return "Добавить пользователя";
    }

    @Override
    public String userName() {
        return "Как тебя зовут?";
    }

    @Override
    public String pays() {
        return "%s получает %.2f€ от %s.";
    }

    @Override
    public String receives() {
        return "%s платит %.2f€ в %s.";
    }

    @Override
    public String getsGives() {
        return " получает/даёт ";
    }

    @Override
    public String amount() {
        return " сумма: ";
    }

    @Override
    public String addTicket() {
        return "Добавить билет";
    }

    @Override
    public String checkSum() {
        return "Контрольная сумма";
    }

    @Override
    public String dividedUniformly() {
        return "Разделены равномерно";
    }

    @Override
    public String dividedNonUniformly() {
        return "Разделены неравномерно";
    }

    @Override
    public String totalPrice() {
        return "Общая цена: ";
    }

    @Override
    public String viewUsers() {
        return "Просмотр пользователей";
    }

    @Override
    public String viewTickets() {
        return "Посмотреть текущие билеты";
    }

    @Override
    public String calculate() {
        return "Рассчитать";
    }

    @Override
    public String exit() {
        return "Выход";
    }

    @Override
    public String yourSum() {
        return "Ваша сумма: ";
    }

    @Override
    public String correctSum() {
        return "Правильная сумма: ";
    }

    @Override
    public String missingSum() {
        return "Есть промахи: ";
    }

    @Override
    public String yourCorrectSum() {
        return "Правильная и ваша сумма: ";
    }

    @Override
    public String priceNotValidError() {
        return "Пожалуйста, проверьте входные данные!";
    }

    @Override
    public String checkSumError() {
        return "Пожалуйста, проверьте свою сумму!";
    }

    @Override
    public String fillInPriceError() {
        return "Пожалуйста, укажите цену!";
    }

    @Override
    public String currentLanguage() {
        return "Русский";
    }

    @Override
    public String changeLanguage() {
        return "Изменить язык на русский";
    }
}
