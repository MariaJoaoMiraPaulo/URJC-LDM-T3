package juego;

import liliana.piratas.Pantalla;
import androidimpl.AndroidJuego;

/**
 * Jeugo piratas class
 */
public class JuegoPiratas extends AndroidJuego {
    /**
     * Get start screen
     * @return the start screen
     */
    @Override
    public Pantalla getStartScreen() {

        return new LoadingScreen(this);
    }
}
