package com.example.david.watchcatalog.models;

/**
 * The class {@code WatchGalleryModel} is used to represent a single watch
 * with in {@code WatchGalleryActivity} gridView. This class should be refactored to use AutoParcelable
 * <p/>
 * Created by ronan on 2/12/2016.
 */
public class WatchGalleryModel {

    private String id;
    private String resourceId;

    public WatchGalleryModel(String id, String resourceId) {
        this.id = id;
        this.resourceId = resourceId;
    }

    public String getId() {
        return id;
    }

    public String getResourceId() {
        return resourceId;
    }
}
