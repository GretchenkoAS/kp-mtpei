package com.nyha.webfinal.model.entity;

public class Train extends Entity{
    public enum Type {
        SIGNATURE, EXPRESS, PASSENGER
    }

    private String manufacturer;
    private String model;
    private int numberOfSeats;
    private Train.Type type;

    public Train() {
    }

    public Train(String manufacturer, String model, int numberOfSeats, Type type) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Train train = (Train) o;
        if (manufacturer == null) {
            if (train.manufacturer != null) {
                return false;
            }
        } else if (!manufacturer.equals(train.manufacturer)) {
            return false;
        }
        if (model == null) {
            if (train.model != null) {
                return false;
            }
        } else if (!model.equals(train.model)) {
            return false;
        }
        if (train.numberOfSeats != numberOfSeats) {
            return false;
        }
        if (type == null) {
            if (train.type != null) {
                return false;
            }
        } else if (type != train.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + numberOfSeats;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Train{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", numberOfSeats='").append(numberOfSeats).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
