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
public class DatasetWeight implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dataset_id", referencedColumnName = "id")
    @JsonIgnore
    private Dataset dataset;

    @Id
    @ManyToOne
    @JoinColumn(name = "weight_id", referencedColumnName = "id")
    //@JsonIgnore
    @JsonIgnoreProperties({"reuseAssoc","datasetAssoc"})
    @JsonProperty("weight_id")
    private Weight weight;


    @JsonProperty("value")
    private Float value;

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
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
        DatasetWeight that = (DatasetWeight) o;
        return Objects.equals(dataset, that.dataset) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataset, weight, value);
    }

    @Override
    public String toString() {
        return "DatasetWeight{" +
                "dataset=" + dataset +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
