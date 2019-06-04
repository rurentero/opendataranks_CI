package io.swagger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;

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

  //TODO Cambiar la inicializacion de las variables y poner una por defecto
  // TODO Mejor idea?: Declarar normal y poner constructor por defecto con todo inicializado a cadena vacía o un número

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("created_at")
  private Date createdAt = null;

  @JsonProperty("last_modified")
  private Date lastModified = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("views")
  private Integer views = 0;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("reviews_num")
  private Integer reviewsNum = 0;

  @JsonProperty("datasets_num")
  private Integer datasetsNum = 0;

  @JsonProperty("score")
  private Float score = 0f;

  @JsonProperty("score_5")
  private Float score5 = 0f;

  @JsonProperty("score_4")
  private Float score4 = 0f;

  @JsonProperty("score_3")
  private Float score3 = 0f;

  @JsonProperty("score_2")
  private Float score2 = 0f;

  @JsonProperty("score_1")
  private Float score1 = 0f;

  @JsonProperty("downloads")
  private Integer downloads = 0;

  @ManyToOne
  @JoinColumn(name = "organization_id")
  @JsonProperty("organization")
  @JsonIgnoreProperties({"datasets","reuses"})
  private Organization organization;

  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          },
          mappedBy = "reuses")
  @JsonProperty("datasets")
  @JsonIgnoreProperties({"reuses","organization","tags"})
  private List<Dataset> datasets = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
  @JoinTable(name = "reuse_tag",
        joinColumns = { @JoinColumn(name = "id_reuse", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "id_tag", referencedColumnName = "id") })
  @JsonIgnoreProperties({"datasets","reuses"})
  private List<Tag> tags = new ArrayList<>();


  // TODO Valorar si se mostrará al usuario el valor calculado por el portal @JsonProperty("weights")
  // TODO @JsonIgnore para quitar totalmente esta propiedad de los JSON. Sale tanto al recuperar una coleccion como si es una sola mediante Id, ya que se hace referencia directa en el repo (no como con el resto de listas)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "reuse")
  @JsonProperty("weights")
  private List<ReuseWeight> weightAssoc = new ArrayList<>();

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

  public Reuse createdAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Reuse lastModified(Date lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Get lastModified
   * @return lastModified
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
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

  public Reuse views(Integer views) {
    this.views = views;
    return this;
  }

  /**
   * Get views
   * @return views
  **/
  @ApiModelProperty(value = "")

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
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

  public Reuse score(Float score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public Reuse score5(Float score5) {
    this.score5 = score5;
    return this;
  }

  /**
   * Get score5
   * @return score5
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore5() {
    return score5;
  }

  public void setScore5(Float score5) {
    this.score5 = score5;
  }

  public Reuse score4(Float score4) {
    this.score4 = score4;
    return this;
  }

  /**
   * Get score4
   * @return score4
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore4() {
    return score4;
  }

  public void setScore4(Float score4) {
    this.score4 = score4;
  }

  public Reuse score3(Float score3) {
    this.score3 = score3;
    return this;
  }

  /**
   * Get score3
   * @return score3
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore3() {
    return score3;
  }

  public void setScore3(Float score3) {
    this.score3 = score3;
  }

  public Reuse score2(Float score2) {
    this.score2 = score2;
    return this;
  }

  /**
   * Get score2
   * @return score2
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore2() {
    return score2;
  }

  public void setScore2(Float score2) {
    this.score2 = score2;
  }

  public Reuse score1(Float score1) {
    this.score1 = score1;
    return this;
  }

  /**
   * Get score1
   * @return score1
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Float getScore1() {
    return score1;
  }

  public void setScore1(Float score1) {
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

  /**
   * Get tags
   * @return tags
   **/
  public List<Tag> getTags() { return tags; }

  public void setTags(List<Tag> tags) { this.tags = tags; }

  /**
   * Get weightAssoc
   * @return weightAssoc
   **/
  public List<ReuseWeight> getWeightAssoc() { return weightAssoc; }

  public void setWeightAssoc(List<ReuseWeight> weightAssoc) { this.weightAssoc = weightAssoc; }

  /**
   * Get datasetsNum
   * @return datasetsNum
   **/
  public Integer getDatasetsNum() { return datasetsNum; }

  public void setDatasetsNum(Integer datasetsNum) { this.datasetsNum = datasetsNum; }

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
    return Objects.hash(id, title, description, createdAt, lastModified, url, image, views, type, reviewsNum, score, score5, score4, score3, score2, score1, downloads);
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
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    reviewsNum: ").append(toIndentedString(reviewsNum)).append("\n");
    sb.append("    datasetsNum: ").append(toIndentedString(datasetsNum)).append("\n");
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
