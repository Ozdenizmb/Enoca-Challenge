package com.enoca.challenge.exception;

public class ErrorMessages {

    private ErrorMessages(){}

    public static final String DEFAULT_ERROR_MESSAGE = "An unexpected error occurred! Please contact the api support!";

    public static final String EMAIL_NOT_FOUND = "Email not found";

    public static final String WRONG_PASSWORD = "Wrong password";

    public static final String FORBIDDEN = "Forbidden";

    public static final String CUSTOMER_NOT_FOUND = "Customer not found!";

    public static final String PRODUCT_NOT_FOUND = "Product not found!";

    public static final String CART_NOT_FOUND = "Cart not found!";

    public static final String NO_CART_TO_EMPTY = "The cart to be emptied could not be found.";

    public static final String PRODUCT_CANNOT_DELETE_FOR_CART_NOTFOUND = "The cart where the product will be deleted could not be found.";

    public static final String PRODUCT_NOT_FOUND_IN_CART = "The product you want to remove from the cart could not be found.";

    public static final String INSUFFICIENT_STOCK = "Insufficient stock available.";

}
