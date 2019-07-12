package com.mockup.allexamples.models.pokemonAPIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {
    private int number;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    public int getNumber() {
        String[] urlpartes = url.split("/");

        return Integer.parseInt(urlpartes[urlpartes.length -1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Pokemon() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public Pokemon(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

