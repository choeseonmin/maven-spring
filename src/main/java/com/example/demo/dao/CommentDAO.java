package com.example.demo.dao;

import com.example.demo.model.CommentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDAO {
    List<CommentModel> selectAllComment();

    CommentModel selectComment(@Param("no") int no);

    void insertComment(CommentModel comment);

    void deleteComment(@Param("no") int no);

    void updateComment(CommentModel comment);
}

