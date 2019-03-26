package io.swagger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reuse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Reuse implements Serializable {
  @Id
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("created_at")
  private OffsetDateTime createdAt = null;

  @JsonProperty("last_modified")
  private OffsetDateTime lastModified = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("views")
  private String views = null;

  @JsonProperty("followers")
  private String followers = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("reviews_num")
  private Integer reviewsNum = null;

  @JsonProperty("score")
  private BigDecimal score = null;

  @JsonProperty("score_5")
  private BigDecimal score5 = null;

  @JsonProperty("score_4")
  private BigDecimal score4 = null;

  @JsonProperty("score_3")
  private BigDecimal score3 = null;

  @JsonProperty("score_2")
  private BigDecimal score2 = null;

  @JsonProperty("score_1")
  private BigDecimal score1 = null;

  @JsonProperty("downloads")
  private Integer downloads = null;

  @ManyToOne
  @JoinColumn(name = "organization_id")
  @JsonProperty("organization")
  @JsonIgnoreProperties({"datasets","reuses"})
  private Organization organization;

  // TODO Relacion Many to Many con Dataset implementada, ver como evoluciona.
  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          },
          mappedBy = "reuses")
  @JsonProperty("datasets")
  @JsonIgnoreProperties({"reuses","organization"})
  private List<Dataset> datasets = new ArrayList<>();

  public Reuse id(String id) {
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

  public Reuse title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Reuse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Reuse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")

  @Valid
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Reuse lastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Get lastModified
   * @return lastModified
  **/
  @ApiModelProperty(value = "")

  @Valid
  public OffsetDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
  }

  public Reuse url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Reuse image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Reuse views(String views) {
    this.views = views;
    return this;
  }

  /**
   * Get views
   * @return views
  **/
  @ApiModelProperty(value = "")

  public String getViews() {
    return views;
  }

  public void setViews(String views) {
    this.views = views;
  }

  public Reuse followers(String followers) {
    this.followers = followers;
    return this;
  }

  /**
   * Get followers
   * @return followers
  **/
  @ApiModelProperty(value = "")

  public String getFollowers() {
    return followers;
  }

  public void setFollowers(String followers) {
    this.followers = followers;
  }

  public Reuse type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Reuse reviewsNum(Integer reviewsNum) {
    this.reviewsNum = reviewsNum;
    return this;
  }

  /**
   * Get reviewsNum
   * @return reviewsNum
  **/
  @ApiModelProperty(value = "")

  public Integer getReviewsNum() {
    return reviewsNum;
  }

  public void setReviewsNum(Integer reviewsNum) {
    this.reviewsNum = reviewsNum;
  }

  public Reuse score(BigDecimal score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }

  public Reuse score5(BigDecimal score5) {
    this.score5 = score5;
    return this;
  }

  /**
   * Get score5
   * @return score5
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore5() {
    return score5;
  }

  public void setScore5(BigDecimal score5) {
    this.score5 = score5;
  }

  public Reuse score4(BigDecimal score4) {
    this.score4 = score4;
    return this;
  }

  /**
   * Get score4
   * @return score4
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore4() {
    return score4;
  }

  public void setScore4(BigDecimal score4) {
    this.score4 = score4;
  }

  public Reuse score3(BigDecimal score3) {
    this.score3 = score3;
    return this;
  }

  /**
   * Get score3
   * @return score3
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore3() {
    return score3;
  }

  public void setScore3(BigDecimal score3) {
    this.score3 = score3;
  }

  public Reuse score2(BigDecimal score2) {
    this.score2 = score2;
    return this;
  }

  /**
   * Get score2
   * @return score2
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore2() {
    return score2;
  }

  public void setScore2(BigDecimal score2) {
    this.score2 = score2;
  }

  public Reuse score1(BigDecimal score1) {
    this.score1 = score1;
    return this;
  }

  /**
   * Get score1
   * @return score1
  **/
  @ApiModelProperty(value = "")

  @Valid
  public BigDecimal getScore1() {
    return score1;
  }

  public void setScore1(BigDecimal score1) {
    this.score1 = score1;
  }

  public Reuse downloads(Integer downloads) {
    this.downloads = downloads;
    return this;
  }

  /**
   * Get downloads
   * @return downloads
  **/
  @ApiModelProperty(value = "")

  public Integer getDownloads() {
    return downloads;
  }

  public void setDownloads(Integer downloads) {
    this.downloads = downloads;
  }

  /**
   * Get datasets
   * @return datasets
   **/
  public List<Dataset> getDatasets() { return datasets; }

  public void setDatasets(List<Dataset> datasets) { this.datasets = datasets; }

  /**
   * Get organization
   * @return organization
   **/
  public Organization getOrganization() { return organization; }

  public void setOrganization(Organization organization) { this.organization = organization; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reuse reuse = (Reuse) o;
    return Objects.equals(this.id, reuse.id) &&
        Objects.equals(this.title, reuse.title) &&
        Objects.equals(this.description, reuse.description) &&
        Objects.equals(this.createdAt, reuse.createdAt) &&
        Objects.equals(this.lastModified, reuse.lastModified) &&
        Objects.equals(this.url, reuse.url) &&
        Objects.equals(this.image, reuse.image) &&
        Objects.equals(this.views, reuse.views) &&
        Objects.equals(this.followers, reuse.followers) &&
        Objects.equals(this.type, reuse.type) &&
        Objects.equals(this.reviewsNum, reuse.reviewsNum) &&
        Objects.equals(this.score, reuse.score) &&
        Objects.equals(this.score5, reuse.score5) &&
        Objects.equals(this.score4, reuse.score4) &&
        Objects.equals(this.score3, reuse.score3) &&
        Objects.equals(this.score2, reuse.score2) &&
        Objects.equals(this.score1, reuse.score1) &&
        Objects.equals(this.downloads, reuse.downloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, createdAt, lastModified, url, image, views, followers, type, reviewsNum, score, score5, score4, score3, score2, score1, downloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reuse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    reviewsNum: ").append(toIndentedString(reviewsNum)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    score5: ").append(toIndentedString(score5)).append("\n");
    sb.append("    score4: ").append(toIndentedString(score4)).append("\n");
    sb.append("    score3: ").append(toIndentedString(score3)).append("\n");
    sb.append("    score2: ").append(toIndentedString(score2)).append("\n");
    sb.append("    score1: ").append(toIndentedString(score1)).append("\n");
    sb.append("    downloads: ").append(toIndentedString(downloads)).append("\n");
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
