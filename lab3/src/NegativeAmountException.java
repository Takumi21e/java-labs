public class NegativeAmountException extends RuntimeException {

    public NegativeAmountException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ошибка количества материала: " + super.getMessage();
    }
}