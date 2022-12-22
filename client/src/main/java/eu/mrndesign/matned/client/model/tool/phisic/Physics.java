package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.tool.math.Vector2D;

public interface Physics {

    void calculate(Vector2D moveVector, double moveForce);

    double getVerticalSpeed();

    void setGravityMod(double value);

}
