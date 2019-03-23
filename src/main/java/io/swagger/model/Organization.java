package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Organization
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class Organization   {
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

  @JsonProperty("reuses_num")
  private Integer reusesNum = null;

  @JsonProperty("datasets_num")
  private Integer datasetsNum = null;

  public Organization id(String id) {
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

  public Organization title(String title) {
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

  public Organization description(String description) {
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

  public Organization createdAt(OffsetDateTime createdAt) {
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

  public Organization lastModified(OffsetDateTime lastModified) {
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

  public Organization url(String url) {
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

  public Organization image(String image) {
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

  public Organization views(String views) {
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

  public Organization followers(String followers) {
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

  public Organization reusesNum(Integer reusesNum) {
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

  public Organization datasetsNum(Integer datasetsNum) {
    this.datasetsNum = datasetsNum;
    return this;
  }

  /**
   * Get datasetsNum
   * @return datasetsNum
  **/
  @ApiModelProperty(value = "")

  public Integer getDatasetsNum() {
    return datasetsNum;
  }

  public void setDatasetsNum(Integer datasetsNum) {
    this.datasetsNum = datasetsNum;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization) o;
    return Objects.equals(this.id, organization.id) &&
        Objects.equals(this.title, organization.title) &&
        Objects.equals(this.description, organization.description) &&
        Objects.equals(this.createdAt, organization.createdAt) &&
        Objects.equals(this.lastModified, organization.lastModified) &&
        Objects.equals(this.url, organization.url) &&
        Objects.equals(this.image, organization.image) &&
        Objects.equals(this.views, organization.views) &&
        Objects.equals(this.followers, organization.followers) &&
        Objects.equals(this.reusesNum, organization.reusesNum) &&
        Objects.equals(this.datasetsNum, organization.datasetsNum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, createdAt, lastModified, url, image, views, followers, reusesNum, datasetsNum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
    sb.append("    reusesNum: ").append(toIndentedString(reusesNum)).append("\n");
    sb.append("    datasetsNum: ").append(toIndentedString(datasetsNum)).append("\n");
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
