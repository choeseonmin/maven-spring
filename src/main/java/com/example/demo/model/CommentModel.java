package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {

    private int no;
    private String author;
    private String comment;
    private LocalDateTime date; // 시간을 가져오는 타입은 date도 있는데 지역적인 문제가 많아서 localdatetime을 씀
}
