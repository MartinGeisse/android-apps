package name.martingeisse.taschenlampe;

import android.hardware.Camera;

public class FlashlightController {

    private boolean active;
    private Camera camera;

    public boolean isActive() {
        return active;
    }

    public void toggle() {
        setActive(!active);
    }

    public void setActive(boolean active) {
        this.active = active;
        if (active && camera == null) {
            camera = Camera.open();
            Camera.Parameters parameters = camera.getParameters();
            // TODO parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            camera.startPreview();
        } else if (!active && camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

}
