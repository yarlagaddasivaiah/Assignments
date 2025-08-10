package ecommerce;


public interface InventoryService {
    boolean isAvailable(String itemId);
}

public interface CartValidator {
    boolean validateCart(String cartId);
}

public interface OrderService {
    String checkout(String cartId);
}
