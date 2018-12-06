package juego;

import liliana.piratas.Pantalla;
import androidimpl.AndroidJuego;

public class JuegoPiratas extends AndroidJuego {
    @Override
    public Pantalla getStartScreen() {

        return new LoadingScreen(this);
    }
}
