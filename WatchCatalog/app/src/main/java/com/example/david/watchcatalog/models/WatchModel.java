package com.example.david.watchcatalog.models;

/**
 * This can be converted to a AutoParcelable Object {@link 'https://github.com/frankiesardo/auto-parcel'}
 *
 * Created by David on 08/02/2016.
 */
public class WatchModel {

    //This creates our variables
    private int id;
    private String name;
    private String price;
    private String description;
    private int imageId;

    //These assign the variables to the watch
    public WatchModel (int id,String name,String price,String description,int imageId){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageId = imageId;
    }

    //These pull the information needed to assign the variables to the watch.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
