package ua.lviv.iot.fishStore.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
    }

    public ItemNotFoundException(final String message) {
        super(message);
    }
}
