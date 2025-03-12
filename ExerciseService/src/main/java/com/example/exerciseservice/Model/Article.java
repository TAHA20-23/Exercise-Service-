package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Article {

    @NotNull(message = "id Can not be null")
    private int id;

    @NotNull(message = "Title Can not be null")
    @Size(max = 100, message = "Title Maximum length is 100 characters. ")
    private String title;

    @NotNull(message = "Author Can not be null")
    @Size(min = 5, max = 20, message = "Author length must be between 5 and 20 characters")
    private String author;

    @NotNull(message = "Category can not be null")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "Category Must be either 'politics',  'sports' or 'technology' only.")
    private String category;

    @NotNull(message = "Content Can not be null")
    @Size(min = 200, message = "Content must be more than 200 characters.  ")
    private String content;

    @NotNull(message = "ImageUrl Can not be null")
    private String imageUrl;

    @AssertFalse(message = "isPublish must be initially set to false.")
    private boolean isPublish;

    @NotNull(message = "PublishDte Can not be null")
    @PastOrPresent(message = "PublishDte should be a date in the present or the past.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate PublishDte;

}
