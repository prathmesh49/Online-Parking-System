package com.example.service;

import com.example.model.Books;
import com.example.model.Cart;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.serviceInterfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceIMPL implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addToCart(User user, Books book, int quantity, int cid) {

        Optional<Cart> cart1 = cartRepository.findById(cid);

        if (!cart1.isEmpty()) {
            Cart cart = cart1.get();
            List<Books> books = new ArrayList<>();
            books.add(book);
            cart.setBooks(books);
            cart.setQuantity(quantity);
            cart.setUser(user);

            cartRepository.save(cart);
        } else {
            Cart cart = new Cart();
            List<Books> books = new ArrayList<>();
            books.add(book);
            cart.setBooks(books);
            cart.setQuantity(quantity);
            cart.setUser(user);
        }
    }

    @Override
    public void removeFromCart(User user, Books book, int cid) {
        Optional<Cart> cart1 = cartRepository.findById(cid);
        Cart cart = cart1.get();
        List<Books> books = cart.getBooks();
        if (books.contains(book)) {
            books.remove(book);
        }
    }

    @Override
    public List<Books> getCartItems(User user, int cid) {
        Optional<Cart> cart1 = cartRepository.findById(cid);
        Cart cart = cart1.get();
        return cart.getBooks();
    }

    @Override
    public Cart getCartById(int cart_id) {
        return cartRepository.findById(cart_id).get();
    }

    @Override
    public double calculateTotalPrice(User user, int cid) {
        Optional<Cart> cart1 = cartRepository.findById(cid);
        Cart cart = cart1.get();
        List<Books> books = cart.getBooks();
        double price = 0;
        for (Books el : books) {
            price = price + el.getPrice();
        }
        return price;
    }

    @Override
    public void clearCart(Cart cart) {
        cartRepository.delete(cart);
    }
}
