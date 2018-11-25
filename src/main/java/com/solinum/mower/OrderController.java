package com.solinum.mower;

import com.solinum.mower.dto.Mower;
import com.solinum.mower.dto.request.OrderRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    @ResponseBody
    public Mower order(@RequestBody OrderRequest orderRequest){
        return orderService.executeOrder(orderRequest);
    }
}
