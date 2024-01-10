package com.example.mvcdemo;

import com.example.mvcdemo.services.NewService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.standard.expression.GreaterThanExpression;

@Controller
public class SampleController {
    private final NewService newService;

    public SampleController(NewService newService){
        this.newService=newService;
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(
            name="name",
            required = false,
            defaultValue = "World")String name,Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping("/news")
    public String news(
            @RequestParam(
                    name = "country",
                    required = false,
                    defaultValue = "India"
            )String country,
            @RequestParam(
                    name = "year",
                    required = false
            )Integer year,
            Model model
    ) {
        model.addAttribute(
                "news",
                newService.getNews(country,year!=null?year:2024)
        );return
    }

}
