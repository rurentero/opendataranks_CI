package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ReuseWeight implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "reuse_id", referencedColumnName = "id")
    @JsonIgnore
    private Reuse reuse;

    @Id
    @ManyToOne
    @JoinColumn(name = "weight_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"reuseAssoc","datasetAssoc"})
    @JsonProperty("weight_id")
    private Weight weight;


    @JsonProperty("value")
    private Float value;


    public Reuse getReuse() {
        return reuse;
    }

    public void setReuse(Reuse reuse) {
        this.reuse = reuse;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReuseWeight that = (ReuseWeight) o;
        return Objects.equals(reuse, that.reuse) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reuse, weight, value);
    }

    @Override
    public String toString() {
        return "ReuseWeight{" +
                "reuse=" + reuse +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
