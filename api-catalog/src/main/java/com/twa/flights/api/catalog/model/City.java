package com.twa.flights.api.catalog.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class City extends Base {

    @Column(length = 50, nullable = false)
    private String timeZone;

    @JoinColumn(name = "country_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Continent))
            return false;
        final City o = (City) obj;
        return Objects.equals(getId(), o.getId())
                && Objects.equals(getCode(), o.getCode())
                && Objects.equals(getName(), o.getName())
                && Objects.equals(getTimeZone(), o.getTimeZone())
                && Objects.equals(getCountry(), o.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getTimeZone(), getCountry());
    }
}
