package com.nyha.webfinal.model.entity;

public class Station extends Entity{
    private String name;
    private String city;
    private String country;

    public Station() {
    }

    public Station(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        if (name == null) {
            if (station.name != null) {
                return false;
            }
        } else if (!name.equals(station.name)) {
            return false;
        }
        if (city == null) {
            if (station.city != null) {
                return false;
            }
        } else if (!city.equals(station.city)) {
            return false;
        }
        if (country == null) {
            if (station.country != null) {
                return false;
            }
        } else if (!country.equals(station.country)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Station{");
        sb.append("name='").append(name).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country);
        sb.append('}');
        return sb.toString();
    }
}

