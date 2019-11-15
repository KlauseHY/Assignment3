package com.klaus.hometask3;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private String id;
    private String temperament;
    private String description;
    private String life_span;
    private String dog_friendly;
    private String origin;
    private String wikipedia_url;
    private weight weight;

    class weight implements Serializable{
        String imperial;
        String metric;

        public String getImperial() {
            return imperial;
        }

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(String dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public Cat.weight getWeight() {
        return weight;
    }

    public void setWeight(Cat.weight weight) {
        this.weight = weight;
    }
}
