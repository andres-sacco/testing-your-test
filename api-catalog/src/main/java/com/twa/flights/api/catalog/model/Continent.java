package com.twa.flights.api.catalog.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Continent extends Base {

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Continent))
            return false;
        final Continent o = (Continent) obj;
        return Objects.equals(getId(), o.getId())
                && Objects.equals(getCode(), o.getCode())
                && Objects.equals(getName(), o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName());
    }
}
