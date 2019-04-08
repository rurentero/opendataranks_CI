package io.swagger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Dataset
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Dataset implements Serializable  {
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

  @JsonProperty("frequency")
  private String frequency = null;

  @JsonProperty("reuses_num")
  private Integer reusesNum = null;

  @JsonProperty("license")
  private String license = null;

  @ManyToOne
  @JoinColumn(name = "organization_id")
  @JsonProperty("organization")
  @JsonIgnoreProperties({"datasets", "reuses"})
  private Organization organization;

  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          })
  @JoinTable(name="dataset_reuse",
          joinColumns = { @JoinColumn(name = "id_dataset", referencedColumnName = "id") },
          inverseJoinColumns = { @JoinColumn(name = "id_reuse", referencedColumnName = "id") })
  @JsonProperty("reuses")
  @JsonIgnoreProperties({"datasets","organization","tags", "weightAssoc"})
  private List<Reuse> reuses = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          })
  @JoinTable(name = "dataset_tag",
          joinColumns = { @JoinColumn(name = "id_dataset", referencedColumnName = "id") },
          inverseJoinColumns = { @JoinColumn(name = "id_tag", referencedColumnName = "id") })
  @JsonIgnoreProperties({"datasets","reuses"})
  private List<Tag> tags = new ArrayList<>();


  public Dataset id(String id) {
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

  public Dataset title(String title) {
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

  public Dataset description(String description) {
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

  public Dataset createdAt(OffsetDateTime createdAt) {
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

  public Dataset lastModified(OffsetDateTime lastModified) {
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

  public Dataset url(String url) {
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

  public Dataset image(String image) {
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

  public Dataset views(String views) {
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

  public Dataset followers(String followers) {
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

  public Dataset frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Get frequency
   * @return frequency
  **/
  @ApiModelProperty(value = "")

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public Dataset reusesNum(Integer reusesNum) {
    this.reusesNum = reusesNum;
    return this;
  }

  /**
   * Get reusesNum
   * @return reusesNum
  **/
  @ApiModelProperty(value = "")

  public Integer getReusesNum() {
    return reusesNum;
  }

  public void setReusesNum(Integer reusesNum) {
    this.reusesNum = reusesNum;
  }

  public Dataset license(String license) {
    this.license = license;
    return this;
  }

  /**
   * Get license
   * @return license
  **/
  @ApiModelProperty(value = "")

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }


  /**
   * Get organization
   * @return organization
   **/
  public Organization getOrganization() { return organization; }

  public void setOrganization(Organization organization) { this.organization = organization; }

  /**
   * Get reuses
   * @return reuses
   **/
  public List<Reuse> getReuses() { return reuses; }

  public void setReuses(List<Reuse> reuses) { this.reuses = reuses; }

  /**
   * Get tags
   * @return tags
   **/
  public List<Tag> getTags() { return tags; }

  public void setTags(List<Tag> tags) { this.tags = tags; }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dataset dataset = (Dataset) o;
    return Objects.equals(this.id, dataset.id) &&
        Objects.equals(this.title, dataset.title) &&
        Objects.equals(this.description, dataset.description) &&
        Objects.equals(this.createdAt, dataset.createdAt) &&
        Objects.equals(this.lastModified, dataset.lastModified) &&
        Objects.equals(this.url, dataset.url) &&
        Objects.equals(this.image, dataset.image) &&
        Objects.equals(this.views, dataset.views) &&
        Objects.equals(this.followers, dataset.followers) &&
        Objects.equals(this.frequency, dataset.frequency) &&
        Objects.equals(this.reusesNum, dataset.reusesNum) &&
        Objects.equals(this.license, dataset.license);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, createdAt, lastModified, url, image, views, followers, frequency, reusesNum, license);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dataset {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    reusesNum: ").append(toIndentedString(reusesNum)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
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
