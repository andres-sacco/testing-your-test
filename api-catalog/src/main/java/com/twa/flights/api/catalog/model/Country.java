package com.twa.flights.api.catalog.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Country extends Base {

    @JoinColumn(name = "continent_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Continent continent;

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Continent))
            return false;
        final Country o = (Country) obj;
        return Objects.equals(getId(), o.getId())
                && Objects.equals(getCode(), o.getCode())
                && Objects.equals(getName(), o.getName())
                && Objects.equals(getContinent(), o.getContinent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getContinent());
    }
}
