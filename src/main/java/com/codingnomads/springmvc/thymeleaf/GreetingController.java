/* CodingNomads (C)2024 */
package com.codingnomads.springmvc.thymeleaf;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("name", "Spring Developer!");
        return "greeting";
    }

    @GetMapping("/subjects")
    public String subjects(Model model) {
        Subject s1 = new Subject("Java", "Programming");
        Subject s2 = new Subject("Python", "Programming");
        Subject s3 = new Subject("Geometry", "Math");

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @GetMapping("/practice")
    public String practice(Model model) {

        String s1 = "This";
        String s2 = "is";
        String s3 = "for";
        String s4 = "practice,";
        String s5 = "capiche?";

        model.addAttribute("att1",s1);
        model.addAttribute("att2",s2);
        model.addAttribute("att3",s3);
        model.addAttribute("att4",s4);
        model.addAttribute("att5",s5);

        return "practice";
    }

}
