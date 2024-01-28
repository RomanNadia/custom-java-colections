package exeptions;

public class NotExistedKeyExeption extends RuntimeException {

    public NotExistedKeyExeption(String message) {
        super(message);
    }
}
