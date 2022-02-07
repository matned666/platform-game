package eu.mrndesign.matned.client.controller;

public interface Controller {

    void move(String id, double x, double y);

    void rotate(String id, double x , double y);

    String getActiveDrawingAreaId();

    void setActiveDrawingAreaId(String id);

    void addNewDrawingArea(double width, double height);

    void removeDrawingArea(String id);



}
