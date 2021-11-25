package ru.sakhnenko.spring.bankingapp.enums;

public enum OperationType {
    TRANSFER("перевод"), REPLENISHMENT("пополнение"), RECEIPT("поступление");

    private String translation;

    OperationType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return  translation;
    }
}
