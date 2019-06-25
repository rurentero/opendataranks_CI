package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Mail / Suggestion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Mail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("reviews_num_val")
    private Float reviewsNumVal;
    @JsonProperty("score_val")
    private Float scoreVal;
    @JsonProperty("downloads_val")
    private Float downloadsVal;
    @JsonProperty("comment")
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getReviewsNumVal() {
        return reviewsNumVal;
    }

    public void setReviewsNumVal(Float reviewsNumVal) {
        this.reviewsNumVal = reviewsNumVal;
    }

    public Float getScoreVal() {
        return scoreVal;
    }

    public void setScoreVal(Float scoreVal) {
        this.scoreVal = scoreVal;
    }

    public Float getDownloadsVal() {
        return downloadsVal;
    }

    public void setDownloadsVal(Float downloadsVal) {
        this.downloadsVal = downloadsVal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reviewsNumVal=" + reviewsNumVal +
                ", scoreVal=" + scoreVal +
                ", downloadsVal=" + downloadsVal +
                ", comment='" + comment + '\'' +
                '}';
    }
}
