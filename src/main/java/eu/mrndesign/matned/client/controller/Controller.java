package eu.mrndesign.matned.client.controller;

import eu.mrndesign.matned.client.model.game.object.DrawingArea;

public interface Controller {

    void move(String id, double x, double y);

    void rotate(String id, double x , double y);

    String getActiveDrawingAreaId();

    DrawingArea getActiveDrawingArea();

    void setActiveDrawingAreaId(String id);

    void addNewDrawingArea(double width, double height);

    void removeDrawingArea(String id);



}
