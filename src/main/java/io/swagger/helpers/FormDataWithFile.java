package io.swagger.helpers;

import org.springframework.web.multipart.MultipartFile;

/**
 * This class stores the mapping between system attributes and user attributes (when uploading the mapping file).
 */
public class FormDataWithFile {

    //Uploaded file
    private MultipartFile file;

    //Dataset mapping
    private String d_id;
    private String d_title;
    private String d_description;
    private String d_createdAt;
    private String d_lastModified;
    private String d_url;
    private String d_image;
    private String d_views;
    private String d_frequency;
    private String d_reusesNum;
    private String d_license;
    private String d_organization_name;
    private String d_organization_id;
    private String d_tags;

    //Reuses mapping
    private String r_id;
    private String r_title;
    private String r_description;
    private String r_createdAt;
    private String r_lastModified;
    private String r_url;
    private String r_image;
    private String r_views;
    private String r_type;
    private String r_reviewsNum;
    private String r_datasetsNum;
    private String r_score;
    private String r_score5;
    private String r_score4;
    private String r_score3;
    private String r_score2;
    private String r_score1;
    private String r_downloads;
    private String r_organization_name;
    private String r_organization_id;
    private String r_tags;

    //Relations mapping
    private String dr_id_dataset;
    private String dr_id_reuse;



    //Setters and Getters

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public String getD_description() {
        return d_description;
    }

    public void setD_description(String d_description) {
        this.d_description = d_description;
    }

    public String getD_createdAt() {
        return d_createdAt;
    }

    public void setD_createdAt(String d_createdAt) {
        this.d_createdAt = d_createdAt;
    }

    public String getD_lastModified() {
        return d_lastModified;
    }

    public void setD_lastModified(String d_lastModified) {
        this.d_lastModified = d_lastModified;
    }

    public String getD_url() {
        return d_url;
    }

    public void setD_url(String d_url) {
        this.d_url = d_url;
    }

    public String getD_image() {
        return d_image;
    }

    public void setD_image(String d_image) {
        this.d_image = d_image;
    }

    public String getD_views() {
        return d_views;
    }

    public void setD_views(String d_views) {
        this.d_views = d_views;
    }

    public String getD_frequency() {
        return d_frequency;
    }

    public void setD_frequency(String d_frequency) {
        this.d_frequency = d_frequency;
    }

    public String getD_reusesNum() {
        return d_reusesNum;
    }

    public void setD_reusesNum(String d_reusesNum) {
        this.d_reusesNum = d_reusesNum;
    }

    public String getD_license() {
        return d_license;
    }

    public void setD_license(String d_license) {
        this.d_license = d_license;
    }

    public String getD_organization_name() {
        return d_organization_name;
    }

    public void setD_organization_name(String d_organization_name) {
        this.d_organization_name = d_organization_name;
    }

    public String getD_organization_id() {
        return d_organization_id;
    }

    public void setD_organization_id(String d_organization_id) {
        this.d_organization_id = d_organization_id;
    }

    public String getD_tags() { return d_tags; }

    public void setD_tags(String d_tags) { this.d_tags = d_tags; }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public String getR_createdAt() {
        return r_createdAt;
    }

    public void setR_createdAt(String r_createdAt) {
        this.r_createdAt = r_createdAt;
    }

    public String getR_lastModified() {
        return r_lastModified;
    }

    public void setR_lastModified(String r_lastModified) {
        this.r_lastModified = r_lastModified;
    }

    public String getR_url() {
        return r_url;
    }

    public void setR_url(String r_url) {
        this.r_url = r_url;
    }

    public String getR_image() {
        return r_image;
    }

    public void setR_image(String r_image) {
        this.r_image = r_image;
    }

    public String getR_views() {
        return r_views;
    }

    public void setR_views(String r_views) {
        this.r_views = r_views;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getR_reviewsNum() {
        return r_reviewsNum;
    }

    public void setR_reviewsNum(String r_reviewsNum) {
        this.r_reviewsNum = r_reviewsNum;
    }

    public String getR_datasetsNum() { return r_datasetsNum; }

    public void setR_datasetsNum(String r_datasetsNum) { this.r_datasetsNum = r_datasetsNum; }

    public String getR_score() {
        return r_score;
    }

    public void setR_score(String r_score) {
        this.r_score = r_score;
    }

    public String getR_score5() {
        return r_score5;
    }

    public void setR_score5(String r_score5) {
        this.r_score5 = r_score5;
    }

    public String getR_score4() {
        return r_score4;
    }

    public void setR_score4(String r_score4) {
        this.r_score4 = r_score4;
    }

    public String getR_score3() {
        return r_score3;
    }

    public void setR_score3(String r_score3) {
        this.r_score3 = r_score3;
    }

    public String getR_score2() {
        return r_score2;
    }

    public void setR_score2(String r_score2) {
        this.r_score2 = r_score2;
    }

    public String getR_score1() {
        return r_score1;
    }

    public void setR_score1(String r_score1) {
        this.r_score1 = r_score1;
    }

    public String getR_downloads() {
        return r_downloads;
    }

    public void setR_downloads(String r_downloads) {
        this.r_downloads = r_downloads;
    }

    public String getR_organization_name() {
        return r_organization_name;
    }

    public void setR_organization_name(String r_organization_name) {
        this.r_organization_name = r_organization_name;
    }

    public String getR_organization_id() {
        return r_organization_id;
    }

    public void setR_organization_id(String r_organization_id) {
        this.r_organization_id = r_organization_id;
    }

    public String getR_tags() { return r_tags; }

    public void setR_tags(String r_tags) { this.r_tags = r_tags; }

    public String getDr_id_dataset() {
        return dr_id_dataset;
    }

    public void setDr_id_dataset(String dr_id_dataset) {
        this.dr_id_dataset = dr_id_dataset;
    }

    public String getDr_id_reuse() {
        return dr_id_reuse;
    }

    public void setDr_id_reuse(String dr_id_reuse) {
        this.dr_id_reuse = dr_id_reuse;
    }

    @Override
    public String toString() {
        return "FormDataWithFile{" +
                "file=" + file +
                ", d_id='" + d_id + '\'' +
                ", d_title='" + d_title + '\'' +
                ", d_description='" + d_description + '\'' +
                ", d_createdAt='" + d_createdAt + '\'' +
                ", d_lastModified='" + d_lastModified + '\'' +
                ", d_url='" + d_url + '\'' +
                ", d_image='" + d_image + '\'' +
                ", d_views='" + d_views + '\'' +
                ", d_frequency='" + d_frequency + '\'' +
                ", d_reusesNum='" + d_reusesNum + '\'' +
                ", d_license='" + d_license + '\'' +
                ", d_organization_name='" + d_organization_name + '\'' +
                ", d_organization_id='" + d_organization_id + '\'' +
                ", d_tags='" + d_tags + '\'' +
                ", r_id='" + r_id + '\'' +
                ", r_title='" + r_title + '\'' +
                ", r_description='" + r_description + '\'' +
                ", r_createdAt='" + r_createdAt + '\'' +
                ", r_lastModified='" + r_lastModified + '\'' +
                ", r_url='" + r_url + '\'' +
                ", r_image='" + r_image + '\'' +
                ", r_views='" + r_views + '\'' +
                ", r_type='" + r_type + '\'' +
                ", r_reviewsNum='" + r_reviewsNum + '\'' +
                ", r_datasetsNum='" + r_datasetsNum + '\'' +
                ", r_score='" + r_score + '\'' +
                ", r_score5='" + r_score5 + '\'' +
                ", r_score4='" + r_score4 + '\'' +
                ", r_score3='" + r_score3 + '\'' +
                ", r_score2='" + r_score2 + '\'' +
                ", r_score1='" + r_score1 + '\'' +
                ", r_downloads='" + r_downloads + '\'' +
                ", r_organization_name='" + r_organization_name + '\'' +
                ", r_organization_id='" + r_organization_id + '\'' +
                ", r_tags='" + r_tags + '\'' +
                ", dr_id_dataset='" + dr_id_dataset + '\'' +
                ", dr_id_reuse='" + dr_id_reuse + '\'' +
                '}';
    }
}
