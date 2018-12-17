package androidimpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.content.res.AssetManager;
import android.os.Environment;
import liliana.piratas.FileIO;

/**
 * The AndroidFileIO class
 */
public class AndroidFileIO implements FileIO {
    AssetManager assets;
    String rutaAlmacenamientoExterno;

    /**
     * Constructor
     * @param assets the assets
     */
    public AndroidFileIO(AssetManager assets) {
        this.assets = assets;
        this.rutaAlmacenamientoExterno = Environment
                .getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    /**
     * Read asset
     * @param nombreArchivo asset name
     * @return the asset
     * @throws IOException
     */
    @Override
    public InputStream leerAsset(String nombreArchivo) throws IOException {
        return assets.open(nombreArchivo);
    }

    /**
     * Reds archive
     * @param nombreArchivo archive name
     * @return the archie
     * @throws IOException
     */
    @Override
    public InputStream leerArchivo(String nombreArchivo) throws IOException {
        return new FileInputStream(rutaAlmacenamientoExterno + nombreArchivo);
    }

    /**
     * Writes archive
     * @param nombreArchivo archive name
     * @return the archive
     * @throws IOException
     */
    @Override
    public OutputStream escribirArchivo(String nombreArchivo) throws IOException {
        return new FileOutputStream(rutaAlmacenamientoExterno + nombreArchivo);
    }
}
