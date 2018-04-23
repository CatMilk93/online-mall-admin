package lovely.baby.online.mall.backstage.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.model.Category;
import lovely.baby.online.mall.backstage.service.CategoryService;
import lovely.baby.online.mall.backstage.util.RequestDataHolder;

@RequiredArgsConstructor
@Controller
@RequestMapping("background")
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping("category")
    public ModelAndView backgroundCategory(@RequestParam(defaultValue = "1") int page) {
        List<Category> categories = this.categoryService.query(page);
        ModelAndView modelAndView = new ModelAndView("background_category");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("nextPage", page + 1);
        modelAndView.addObject("name", RequestDataHolder.getUsername());
        return modelAndView;
    }

    @RequestMapping("deleteCategory")
    public String deleteCategory(int id) {
        categoryService.deleteById(id);
        return "redirect:/background/category";
    }

    @RequestMapping("saveCategoryEnter")
    public String saveEnter() {
        return "category_save";
    }

    @RequestMapping("saveCategory")
    public String saveCategory(String name) {
        categoryService.save(name);
        return "redirect:/background/category";
    }

    @RequestMapping("updateCategoryEntry")
    public ModelAndView updateEnter(int id) {
        ModelAndView modelAndView = new ModelAndView("category_update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping("updateCategory")
    public String updateCategory(String name, int id) {
        categoryService.update(name, id);
        return "redirect:/background/category";
    }
}
