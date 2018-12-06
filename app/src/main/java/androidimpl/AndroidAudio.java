package androidimpl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import liliana.piratas.Audio;
import liliana.piratas.Musica;
import liliana.piratas.Sonido;

public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Musica nuevaMusica(String nombrearchivo) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(nombrearchivo);
            return new AndroidMusica(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("no se ha podido cargar archivo '" + nombrearchivo + "'");
        }
    }

    @Override
    public Sonido nuevoSonido(String nombrearchivo) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(nombrearchivo);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSonido(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido cargar archivo '" + nombrearchivo + "'");
        }
    }
}