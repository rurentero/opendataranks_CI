package io.swagger.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

/**
 * Weight
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Weight implements Serializable {
  @Id
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("reviews_num_val")
  private Float reviewsNumVal = null;

  @JsonProperty("score_val")
  private Float scoreVal = null;

  @JsonProperty("downloads_val")
  private Float downloadsVal = null;

  // TODO Es realmente necesario serializar reuseAssoc y datasetAssoc?
  @OneToMany(mappedBy = "weight")
  @JsonIgnoreProperties({"weight"})
  @JsonIgnore
  private List<ReuseWeight> reuseAssoc;

  @OneToMany(mappedBy = "weight")
  @JsonIgnoreProperties({"weight"})
  @JsonIgnore
  private List<DatasetWeight> datasetAssoc;

  public Weight id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  /**
   * Get name
   * @return name
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Weight reviewsNumVal(Float reviewsNumVal) {
    this.reviewsNumVal = reviewsNumVal;
    return this;
  }

  /**
   * Get reviewsNumVal
   * @return reviewsNumVal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Float getReviewsNumVal() {
    return reviewsNumVal;
  }

  public void setReviewsNumVal(Float reviewsNumVal) {
    this.reviewsNumVal = reviewsNumVal;
  }

  public Weight scoreVal(Float scoreVal) {
    this.scoreVal = scoreVal;
    return this;
  }

  /**
   * Get scoreVal
   * @return scoreVal
  **/
  @ApiModelProperty(value = "")

  public Float getScoreVal() {
    return scoreVal;
  }

  public void setScoreVal(Float scoreVal) {
    this.scoreVal = scoreVal;
  }

  public Weight downloadsVal(Float downloadsVal) {
    this.downloadsVal = downloadsVal;
    return this;
  }

  /**
   * Get downloadsVal
   * @return downloadsVal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Float getDownloadsVal() {
    return downloadsVal;
  }

  public void setDownloadsVal(Float downloadsVal) {
    this.downloadsVal = downloadsVal;
  }

  /**
   * Get reuseAssoc
   * @return reuseAssoc
   **/
  public List<ReuseWeight> getReuseAssoc() { return reuseAssoc; }

  public void setReuseAssoc(List<ReuseWeight> reuseAssoc) { this.reuseAssoc = reuseAssoc; }

  /**
   * Get datasetAssoc
   * @return datasetAssoc
   **/
  public List<DatasetWeight> getDatasetAssoc() {
    return datasetAssoc;
  }

  public void setDatasetAssoc(List<DatasetWeight> datasetAssoc) {
    this.datasetAssoc = datasetAssoc;
  }

  /**
   * Check if weight values are correct.
   * @return True if correct, False if not.
   */
  public boolean isValid() {
    return getId()!=null && getName()!=null && ((getDownloadsVal() + getScoreVal() + getReviewsNumVal()) <= 100 );
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
