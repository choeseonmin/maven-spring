package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 목록 처리
    @GetMapping("/comments")
    public String getComments (Model model) {

        //List<Map<String, ?>> commentList = commentjdbcDAO.selectAllCommentList();

        List<CommentModel> cmList = commentService.getAllCommentList();

        model.addAttribute("commentList", cmList); // 댓글 리스트를 view로 전달한다.

        CommentModel cm = new CommentModel();

        return "main";
    }

    // 댓글 작성 처리
    @PostMapping("/comments")
    public String createComment(CommentModel commentModel) {

        commentService.createComment(commentModel);

        return "redirect:/";
    }

    // 댓글 수정 화면 요청 처리
    @GetMapping("/comment/{no}")
    public String modifyCommentForm(@PathVariable int no, Model model) {

        CommentModel comment = commentService.getComment(no);
        model.addAttribute("comment", comment);
        return "comment-form";
    }

    // 댓글 수정 요청 처리
    @PostMapping("/comments/{no}")
    public String modifyComment(@PathVariable int no, CommentModel commentModel) {
        //댓글 정보를 update 처리
        commentModel.setNo(no);

        commentService.updateComment(commentModel);

        return "redirect:/";
    }
}
