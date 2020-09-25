package com.habuma.spitter.mvc;

import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

// Объявить как контроллер
@Controller
public class HomeController {
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private SpitterService spitterService;

    @Inject // Внедрить SpitterService
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/", "home"})  // Обрабатывает запросы на получение главной страницы
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)); // Лобавить сообщения в модель
        return "home";  // Вернуть имя представления
    }
}
