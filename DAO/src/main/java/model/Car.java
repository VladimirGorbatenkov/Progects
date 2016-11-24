package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
//import java.util.Objects;

public class Car extends BaseObject implements Serializable{
//    private int carId;
    private String modelName;
    private int probeg;
    private int ownerId;

    public Car(int id, String modelName, int probeg, int ownerId) {
        this.id = id;
        this.modelName = modelName;
        this.probeg = probeg;
        this.ownerId = ownerId;
    }

    public Car(Car car) {
        this.id = car.id;
        this.modelName = car.modelName;
        this.probeg = car.probeg;
        this.ownerId = car.ownerId;
    }

    public Car(Builder builder) {
        this.id = builder.id;
        this.modelName = builder.modelName;
        this.probeg = builder.probeg;
        this.ownerId = builder.ownerId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getProbeg() {
        return probeg;
    }

    public void setProbeg(int probeg) {
        this.probeg = probeg;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public static class Builder {
        private int id;
        private String modelName;
        private int probeg;
        private int ownerId;

        public Builder id(int value) {
            id = value;
            return this;
        }

        public Builder modelName(String value) {
            modelName = value;
            return this;
        }

        public Builder probeg(int value) {
            probeg = value;
            return this;
        }

        public Builder ownerId(int value) {
            ownerId = value;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().getName().equals(this.getClass().getName())) {
            return false;
        }

        Car that = (Car)obj;

        return
//                  Objects.equal(this.id, that.id) &&
                  Objects.equal(this.modelName, that.modelName) &&
                  Objects.equal(this.probeg, that.probeg) &&
                  Objects.equal(this.ownerId, that.ownerId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .add("model_name", this.modelName)
                .add("probeg", this.probeg)
                .add("ownerId", this.ownerId).toString();
    }

/*
    public int hashCode() {
        return Objects.hash(this.modelName, this.probeg, this.ownerId);
    }
*/

    //TODO: переопределить hashcode
}
