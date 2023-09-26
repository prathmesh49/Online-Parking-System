package com.example.controller;

import com.example.model.*;
import com.example.service.CartServiceIMPL;
import com.example.service.OrderServiceIMPL;
import com.example.service.UserServiceIMPL;
import com.example.serviceInterfaces.CartService;
import com.example.serviceInterfaces.OrderService;
import com.example.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class CartController {
    @Autowired
    private CartServiceIMPL cartService;

    @Autowired
    private UserServiceIMPL userService;

    @Autowired
    private OrderServiceIMPL orderService;

    @PostMapping("/add")
    public void addToCart(@RequestBody CartRequest cartRequest) {
        // Retrieve user and book details from the request
        User user = cartRequest.getUser();
        Books book = cartRequest.getBook();
        int quantity = cartRequest.getQuantity();

        // Add the book to the cart
        cartService.addToCart(user, book, quantity, cartRequest.getCart_id());
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestBody CartRequest cartRequest) {
        User user = cartRequest.getUser();
        Books book = cartRequest.getBook();
        cartService.removeFromCart(user,book,cartRequest.getCart_id());
    }

    @GetMapping("/view")
    public List<Books> viewCart(@RequestParam Integer userId, Integer cid) {
        // Retrieve the user's cart items
        User user = userService.getUserById(userId);
        return cartService.getCartItems(user, cid);
    }

    @PostMapping("/checkout")
    public void checkout(@RequestParam Integer userId, @RequestParam Integer cartId) {
        // Retrieve the user and cart
        User user = userService.getUserById(userId);
        Cart cart = cartService.getCartById(cartId);

        if (cart != null) {
            // Retrieve the books in the cart
            List<Books> cartItems = cart.getBooks();

            // Calculate the total price based on cart items (you can implement your own logic)
            double totalPrice = cartService.calculateTotalPrice(user, cartId);

            // Create an order
            Orders order = new Orders();
            order.setUser(user);
            order.setOrder_date(LocalDate.now());
            order.setTotal_price(totalPrice);

            // Add order items based on cart contents
            for (Books book : cartItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setBook(book);
                orderItem.setQuantity(1); // Assuming each book is added once
                orderItem.setSubtotal(book.getPrice()); // Assuming price per book
                order.getOrderItems().add(orderItem);
            }

            // Save the order and remove items from the cart
            orderService.placeOrder(order);
            cartService.clearCart(cart);

            // You can implement additional steps like payment processing and order confirmation here
        }
    }

}
