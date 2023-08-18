package com.example.demo.controller;

import com.example.demo.dao.CommentjdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CommentjdbcDAO commentjdbcDAO;



    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        List<Map<String, ?>> commentList = commentjdbcDAO.selectAllCommentList();
        Map<String, ?> cmt = commentList.get(0);

        model.addAttribute("no", cmt.get("no"));
        model.addAttribute("author", cmt.get("author"));
        model.addAttribute("comment", cmt.get("comment"));


        return "main";
    }
}
