package eu.mrndesign.matned.client.model.game.object;

public class GameElementsFactory {


    public GameElement addNewEnemy(){
//        not implemented
        return null;
    }

    public static GameElement hero() {
        return new StarShip();
    }


}
