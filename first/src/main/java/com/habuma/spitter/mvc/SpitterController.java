package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("/spitter") // Корневой урл
public class SpitterController {
    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String listSpittles(@RequestParam("spitter") String username, Model model){
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spitter/edit";
        }
        spitterService.saveSpitter(spitter);
        // Переадресовать после запроса POST
        return "redirect:/spitters/" + spitter.getUsername();
    }
}
