package lovely.baby.online.mall.backstage.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.model.Order;
import lovely.baby.online.mall.backstage.model.OrderItemView;
import lovely.baby.online.mall.backstage.model.OrderStatus;
import lovely.baby.online.mall.backstage.service.OrderItemViewService;
import lovely.baby.online.mall.backstage.service.OrderService;
import lovely.baby.online.mall.backstage.util.HasCodeUtils;
import lovely.baby.online.mall.backstage.util.RequestDataHolder;

@RequiredArgsConstructor
@Controller
@RequestMapping("background")
public class OrderController {

    private final OrderService orderService;

    private final OrderItemViewService orderItemViewService;

    @RequestMapping("order")
    public ModelAndView backgroundOrder(@RequestParam(defaultValue = "1") int page) {
        List<Order> orders = this.orderService.query(page);
        ModelAndView modelAndView = new ModelAndView("background_order");
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("nextPage", page + 1);
        modelAndView.addObject("name", RequestDataHolder.getUsername());
        return modelAndView;
    }

    @RequestMapping("order_item")
    public ModelAndView backgroundOrderItem(int id, String username) {
        List<OrderItemView> orderItemViews = orderItemViewService.query(id);
        ModelAndView modelAndView = new ModelAndView("order_item");
        modelAndView.addObject("orderItemViews", orderItemViews);
        modelAndView.addObject("username", username);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("updateOrderEntry")
    public ModelAndView backgroundOrderUpdateEntry(int id) {
        ModelAndView modelAndView = new ModelAndView("order_update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("updateOrder")
    public String backgroundOrderUpdate(int status, int id) {
        orderService.updateStatus(HasCodeUtils.getInstance(status, OrderStatus.class), id);
        return "redirect:/background/order";
    }
}
