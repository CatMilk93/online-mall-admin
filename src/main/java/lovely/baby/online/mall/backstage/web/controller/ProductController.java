package lovely.baby.online.mall.backstage.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.model.Category;
import lovely.baby.online.mall.backstage.model.Product;
import lovely.baby.online.mall.backstage.service.CategoryService;
import lovely.baby.online.mall.backstage.service.ProductService;
import lovely.baby.online.mall.backstage.util.RequestDataHolder;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    @RequestMapping("/background/product")
    public ModelAndView backgroundProduct(@RequestParam(defaultValue = "1") int page) {
        List<Product> products = this.productService.query(page);
        ModelAndView modelAndView = new ModelAndView("background_product");
        modelAndView.addObject("products", products);
        modelAndView.addObject("nextPage", page + 1);
        modelAndView.addObject("name", RequestDataHolder.getName());
        return modelAndView;
    }

    @RequestMapping("/background/deleteProduct")
    public String deleteProduct(int id) {
        productService.deleteById(id);
        return "redirect:/background/product";
    }

    @RequestMapping("/background/saveProductEnter")
    public ModelAndView saveEnter() {
        List<Category> categories = categoryService.queryAll();
        ModelAndView modelAndView = new ModelAndView("product_save");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping("/background/saveProduct")
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/background/product";
    }

    @RequestMapping("/background/updateProductEntry")
    public ModelAndView updateEnter(int id) {
        List<Category> categories = categoryService.queryAll();
        Product product = productService.queryProduct(id);
        ModelAndView modelAndView = new ModelAndView("product_update");
        modelAndView.addObject("id", id);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/background/updateProduct")
    public String updateProduct(Product product, int id) {
        productService.update(product, id);
        return "redirect:/background/product";
    }
}
