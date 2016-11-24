package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class Human extends BaseObject implements Serializable{
//    private int id;
    private String name;
    private int age;
    private String city;

    public Human(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Human(Human human) {
        this.id = human.id;
        this.name = human.name;
        this.age = human.age;
        this.city = human.city;
    }

    public Human(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String usernName) {
        this.name = usernName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String city;

        public Builder id(int value) {
            id = value;
            return  this;
        }

        public Builder name(String value) {
            name = value;
            return  this;
        }

        public Builder age(int value) {
            age = value;
            return  this;
        }

        public Builder city(String value) {
            city = value;
            return  this;
        }

        public Human build() {
            return new Human(this);
        }

    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .add("name", this.name)
                .add("login", this.age)
                .add("city", this.city).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().getName().equals(this.getClass().getName())) {
            return false;
        }

        Human that = (Human)obj;

        return
//                Objects.equal(this.id, that.id) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.age, that.age) &&
                Objects.equal(this.city, that.city);
    }

    //TODO: переопределить hashcode
}
