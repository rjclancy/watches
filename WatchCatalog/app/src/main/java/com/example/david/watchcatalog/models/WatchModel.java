package com.example.david.watchcatalog.models;

/**
 * This can be converted to a AutoParcelable Object {@link 'https://github.com/frankiesardo/auto-parcel'}
 * <p/>
 * Created by David on 08/02/2016.
 */
public class WatchModel {

    //This creates our variables
    private int id;
    private String name;
    private String price;
    private String description;

    //These assign the variables to the watch
    public WatchModel(int id, String name, String price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //These pull the information needed to assign the variables to the watch.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
