package com.issuemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    private Long id;
    @NotNull
    private String projectName;
    @NotNull
    private String projectCode;
}
