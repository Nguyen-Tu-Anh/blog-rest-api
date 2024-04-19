package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Post title must have at least 2 characters")
    private String title;
    @NotEmpty(message = "Post description must not be empty")
    @Size(min = 10, message = "Post description must have at least 10 characters")
    private String description;
    @NotEmpty(message = "Post description must not be empty")
    private String content;
    private Set<CommentDto> comments;
}
