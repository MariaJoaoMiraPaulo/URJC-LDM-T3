package androidimpl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * The accelerometer handler
 */
public class AccelerometerHandler implements SensorEventListener {
    float accelX;
    float accelY;
    float accelZ;

    /**
     * Constructor
     * @param context the context
     */
    public AccelerometerHandler(Context context) {
        SensorManager manager = (SensorManager) context
                .getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor accelerometer = manager.getSensorList(
                    Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accelerometer,
                    SensorManager.SENSOR_DELAY_GAME);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No hace nada
    }

    /**
     * On sensor change sate
     * @param event the event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        accelX = event.values[0];
        accelY = event.values[1];
        accelZ = event.values[2];
    }

    /**
     * Gets the x acceleration
     * @return the accel
     */
    public float getAccelX() {
        return accelX;
    }

    /**
     * Gets the y acceleration
     * @return the accel
     */
    public float getAccelY() {
        return accelY;
    }

    /**
     * Gets the z acceleration
     * @return the accel
     */
    public float getAccelZ() {
        return accelZ;
    }
}