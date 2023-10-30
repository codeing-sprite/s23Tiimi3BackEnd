package hh.sof05.dogbackend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long manufacturer_id;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private List<Item> items;

    public Manufacturer() {}

    public Manufacturer(String name) {
        this.name = name;
    }

    public long getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(long manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
