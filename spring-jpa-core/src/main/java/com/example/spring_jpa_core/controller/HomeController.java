package com.example.spring_jpa_core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class HomeController {
    @GetMapping("/")
    public String Home(Model model) {
        model.addAttribute("name", "Phuong");
        model.addAttribute("searchKeyword", "abc");
        model.addAttribute("link", "https://tiv.wsm.vn/learn/vi/learning/2998/content/3021/attachment/7266/");
        model.addAttribute("userId", 42);
        model.addAttribute("findName", "Minh Anh");
        model.addAttribute("findAge", 30);
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("name", "Item 1");
        item1.put("description", "Description for Item 1");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("name", "Item 2");
        item2.put("description", "Description for Item 2");

        Map<String, Object> item3 = new HashMap<>();
        item3.put("id", 3);
        item3.put("name", "Item 3");
        item3.put("description", "Description for Item 3");

        List<Map<String, Object>> array = new ArrayList<>();
        array.add(item1);
        array.add(item2);
        array.add(item3);

        model.addAttribute("items", array);

        return "home";
    }
}
