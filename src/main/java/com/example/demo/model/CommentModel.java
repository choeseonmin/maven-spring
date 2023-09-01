package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {

    private int no;
    @NotBlank(message = "작성자는 필수 항목입니다.")
    private String author;
    @NotBlank(message = "댓글 내용은 필수입니다.")
    private String comment;
    private LocalDateTime modDatetime; // 시간을 가져오는 타입은 date도 있는데 지역적인 문제가 많아서 localdatetime을 씀
    private LocalDateTime regDatetime;
    private int likeCount;

}
