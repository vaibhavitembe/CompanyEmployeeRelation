package com.zplus.companycrud.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SubjectDetailsResDto {

    private Integer subjectId;
    private String subjectName;
    private Double marks;

    private List studList= new ArrayList<>();
}
