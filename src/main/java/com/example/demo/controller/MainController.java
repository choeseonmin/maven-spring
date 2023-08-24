package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.dao.CommentjdbcDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CommentjdbcDAO commentjdbcDAO;

    @Autowired
    private CommentDAO commentDAO;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        //List<Map<String, ?>> commentList = commentjdbcDAO.selectAllCommentList();

        List<CommentModel> cmList = commentDAO.sellectAllComment();

        model.addAttribute("commentList", cmList); // 댓글 리스트를 view로 전달한다.

        CommentModel cm = new CommentModel();

        return "main";
    }
    @PostMapping("/comments")
    public String createComment(CommentModel commentModel) {

        System.out.println(commentModel.getAuthor());
        System.out.println(commentModel.getComment());

        commentDAO.insertComment(commentModel);

        return "redirect:/";
    }
    @DeleteMapping("/comments/{no}")
    public String deleteComment(@PathVariable int no){   //@pathvariable이 {no}를 자동으로 매핑

        commentDAO.deleteComment(no);

        return "redirect:/";
    }

}
