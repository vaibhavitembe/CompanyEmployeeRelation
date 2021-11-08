package com.zplus.companycrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SubjectReqDto {

    private Integer subjectId;
    private String subjectName;
    private Double marks;

    List<Integer> studentIdList = new ArrayList<>();
}
