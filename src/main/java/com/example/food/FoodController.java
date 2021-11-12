package com.example.food;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.applet.Applet;

@Controller
public class FoodController {


    @GetMapping("/bmi")
    public String index( Model model) {
        return "index";
    }

//    @GetMapping("/bmi/{bmi}")
//    public String index(@PathVariable("bmi") String bmi, Model model) {
//        int numBmi = Integer.parseInt(bmi);
//        Applet request;
//        int number = request.getParameter("count");
//        int period = request.getParameter("month");
//        int cal = 1 * 299 * 1 * 30;
//        double kg = cal / 7200;
//
//        if (kg <= 5) {
//            System.out.println("太っている");
//            model.addAttribute("message", "太っている");
//        } else if (kg > 5 && kg <= 10) {
//            System.out.println("普通");
//            model.addAttribute("message", "普通");
//        } else {
//            System.out.println("痩せている");
//            model.addAttribute("message", "痩せている");
//
//        }
//        return "index";
//    }

    @PostMapping("/post")
    public String post(@RequestParam("kosuu") String kosuu, @RequestParam("kikan") String kikan, Model model) {
        System.out.println(kosuu);
        System.out.println(kikan);
        int cal = Integer.parseInt(kosuu) * 299 * Integer.parseInt(kikan) * 30;
        double kg = cal / 7200;
        model.addAttribute("kikan", kikan);
        model.addAttribute("kg", kg);
        if (kg <= 5) {
            model.addAttribute("nodebuFlag", true);
            model.addAttribute("debuFlag", false);
            model.addAttribute("littledebuFlag", false);

            model.addAttribute("comment", "問題ない？？");
            model.addAttribute("message", "食べ過ぎに注意しましょう!!");
            return "post";
        } else if (kg>5 && kg<=10) {
            model.addAttribute("littledebuFlag", true);
            model.addAttribute("nodebuFlag", false);
            model.addAttribute("debuFlag", false);
            model.addAttribute("comment", "注意…");
            model.addAttribute("message", "肥満予備軍!?!?");
            return "post";
        } else {
            model.addAttribute("debuFlag", true);
            model.addAttribute("nodebuFlag", false);
            model.addAttribute("littledebuFlag", false);
            model.addAttribute("comment", "！危険！");
            model.addAttribute("message", "少し量を減らしましょう⚠️");

            return "post";
        }

    }

    @GetMapping("/post")
    public String get() {
        return "get";
    }
}


//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable("name") String name, Model model) {
//        model.addAttribute("name2", name);
//        System.out.println(name);
//        return "hello";
