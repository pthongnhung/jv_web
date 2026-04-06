package org.example.session02.lession3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, ServletContext application, Model model) {
        if(session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("DH001", "Laptop Dell", 15000000, new Date()));
        orders.add(new Order("DH002", "Chuột Logitech", 500000, new Date()));
        orders.add(new Order("DH003", "Bàn phím cơ", 1200000, new Date()));

        model.addAttribute("orders", orders);

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if(count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}
