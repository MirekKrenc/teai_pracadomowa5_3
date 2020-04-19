package krenc.mirek.teaipracadomowa53.model;

public class CurrencyGameData {

    private String currencySymbol;
    private Double currencyValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public CurrencyGameData() {
    }

    public CurrencyGameData(String currencySymbol, Double currencyValue) {
        this.currencySymbol = currencySymbol;
        this.currencyValue = currencyValue;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(Double currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public String toString() {
        return "CurrencyGameData{" +
                "currencySymbol='" + currencySymbol + '\'' +
                ", currencyValue=" + currencyValue +
                '}';
    }
}
