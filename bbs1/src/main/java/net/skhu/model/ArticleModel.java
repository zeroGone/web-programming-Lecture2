package net.skhu.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ArticleModel {
    int id;

    @NotEmpty(message="제목을 입력하세요")
    String title;

    @Size(min=13, message="내용을 입력하세요")
    String body;
}
