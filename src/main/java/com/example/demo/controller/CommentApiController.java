package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

// 댓글의 crud를 처리하는 api 컨트롤러
@RestController
public class CommentApiController {

    @Autowired
    private CommentService commentService;


    // 댓글 조회
    @GetMapping("/api/comments/{no}")
    public CommentModel getComment(@PathVariable int no) {

        CommentModel comment = commentService.getComment(no);

        return comment;
    }

    // 댓글 등록 API
    @PostMapping("/api/comments")
    public CommentModel postComment(@RequestBody CommentModel comment) {
        // 등록 처리
        int no = commentService.createComment(comment);
        return commentService.getComment(no);
    }

    // 댓글 수정 API
    @PutMapping("/api/comments/{no}")
    public CommentModel modifyComment(@RequestBody CommentModel comment, @PathVariable int no) {
        comment.setNo(no);
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/api/comments/{no}")
    public String deleteComment(@PathVariable int no) {
        commentService.deleteComment(no);

        return "OK";
    }
}

