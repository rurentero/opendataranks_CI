package io.swagger.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Entity
public class LikesPerUser implements Serializable {
    @Id
    private String id;
    @Id
    private String ip;
    private Long datemilis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getFechamilis() {
        return datemilis;
    }

    public void setFechamilis(Long datemilis) {
        this.datemilis = datemilis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesPerUser that = (LikesPerUser) o;
        return id.equals(that.id) &&
                ip.equals(that.ip) &&
                datemilis.equals(that.datemilis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ip, datemilis);
    }

    @Override
    public String toString() {
        return "LikesPerUser{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", datemilis=" + datemilis +
                '}';
    }
}
