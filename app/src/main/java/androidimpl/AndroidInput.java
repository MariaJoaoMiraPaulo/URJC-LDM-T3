package androidimpl;

import java.util.List;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import liliana.piratas.Input;

public class AndroidInput implements Input {
    AccelerometerHandler accelHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);
        if(Integer.parseInt(VERSION.SDK) < 5)
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    /**
     * Key pressed verifier
     * @param keyCode the keycode
     * @return key pressed or npt
     */
    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }

    /**
     * Touch down verifier
     * @param pointer the pointer
     * @return touched down or not
     */
    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    /**
     * Get x
     * @param pointer the pointer
     * @return the x
     */
    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    /**
     * Get y
     * @param pointer the pointer
     * @return the y
     */
    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    /**
     * Gets x accel
     * @return the accel
     */
    @Override
    public float getAccelX() {
        return accelHandler.getAccelX();
    }

    /**
     * Get y accel
     * @return the accel
     */
    @Override
    public float getAccelY() {
        return accelHandler.getAccelY();
    }

    /**
     * Gets x accel
     * @return the accel
     */
    @Override
    public float getAccelZ() {
        return accelHandler.getAccelZ();
    }

    /**
     * Get touch event
     * @return the touch events
     */
    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }

    /**
     * Gets key events
     * @return the key events
     */
    @Override
    public List<KeyEvent> getKeyEvents() {
        return keyHandler.getKeyEvents();
    }
}
