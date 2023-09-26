package com.example.serviceInterfaces;

import com.example.model.Books;
import com.example.model.Cart;
import com.example.model.User;

import java.util.List;


public interface CartService {
    void addToCart(User user, Books book, int quantity, int cid);

    void removeFromCart(User user, Books book, int cid);

    List<Books> getCartItems(User user, int cid);

    Cart getCartById(int cart_id);

    double calculateTotalPrice(User user, int cid);

    void clearCart(Cart cart);

}
