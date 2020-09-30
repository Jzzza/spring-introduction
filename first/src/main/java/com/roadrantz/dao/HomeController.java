package com.roadrantz.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private List<Rant> recentRants=new ArrayList<Rant>();

    @RequestMapping({"/", "home"})
    public ModelAndView showHomePage(Map<String, Object> recentRants) {
        return new ModelAndView("home", "rants" , recentRants);
    }
}
