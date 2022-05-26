package dev.sonnyjon.spring5recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sonny on 5/25/2022.
 */
@Controller
public class IndexController
{
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage()
    {
        return "index";
    }
}
