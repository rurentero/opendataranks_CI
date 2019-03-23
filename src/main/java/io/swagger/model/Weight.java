package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Weight
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Weight   {
  @Id
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("reviews_num_val")
  private Integer reviewsNumVal = null;

  @JsonProperty("score_val")
  private Integer scoreVal = null;

  @JsonProperty("downloads_val")
  private Integer downloadsVal = null;

  public Weight id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Weight reviewsNumVal(Integer reviewsNumVal) {
    this.reviewsNumVal = reviewsNumVal;
    return this;
  }

  /**
   * Get reviewsNumVal
   * @return reviewsNumVal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getReviewsNumVal() {
    return reviewsNumVal;
  }

  public void setReviewsNumVal(Integer reviewsNumVal) {
    this.reviewsNumVal = reviewsNumVal;
  }

  public Weight scoreVal(Integer scoreVal) {
    this.scoreVal = scoreVal;
    return this;
  }

  /**
   * Get scoreVal
   * @return scoreVal
  **/
  @ApiModelProperty(value = "")

  public Integer getScoreVal() {
    return scoreVal;
  }

  public void setScoreVal(Integer scoreVal) {
    this.scoreVal = scoreVal;
  }

  public Weight downloadsVal(Integer downloadsVal) {
    this.downloadsVal = downloadsVal;
    return this;
  }

  /**
   * Get downloadsVal
   * @return downloadsVal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getDownloadsVal() {
    return downloadsVal;
  }

  public void setDownloadsVal(Integer downloadsVal) {
    this.downloadsVal = downloadsVal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Weight weight = (Weight) o;
    return Objects.equals(this.id, weight.id) &&
        Objects.equals(this.reviewsNumVal, weight.reviewsNumVal) &&
        Objects.equals(this.scoreVal, weight.scoreVal) &&
        Objects.equals(this.downloadsVal, weight.downloadsVal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reviewsNumVal, scoreVal, downloadsVal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Weight {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reviewsNumVal: ").append(toIndentedString(reviewsNumVal)).append("\n");
    sb.append("    scoreVal: ").append(toIndentedString(scoreVal)).append("\n");
    sb.append("    downloadsVal: ").append(toIndentedString(downloadsVal)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
