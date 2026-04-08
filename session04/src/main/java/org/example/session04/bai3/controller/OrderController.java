package org.example.session04.bai3.controller;


//Trong Cách A:
//        URL /bai3/orders/5 thì số 5 nằm trong đường dẫn (URI Path).
//        Nó là một phần của URL, đại diện cho ID cụ thể của tài nguyên (đơn hàng).
//
//        Trong Cách B:
//        URL /bai3/orders?id=5 thì số 5 nằm trong chuỗi truy vấn (Query String).
//        Nó là một tham số gửi kèm sau dấu ?, thường dùng để lọc hoặc tìm kiếm.
//Theo nguyên tắc thiết kế REST:
//
//        Khi cần lấy 1 đối tượng cụ thể theo ID
//        → nên dùng PathVariable (Cách A)
//
//        Vì:
//
//        URL rõ ràng, dễ hiểu
//        Thể hiện đúng ý nghĩa “truy cập trực tiếp tài nguyên”
//        Đúng chuẩn RESTful
import org.example.session04.bai3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai3/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
}