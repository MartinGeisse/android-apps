package name.martingeisse.taschenlampe;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private FlashlightController flashlightController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flashlightController = new FlashlightController();
        setContentView(new MainView(this, flashlightController));
    }

    @Override
    protected void onPause() {
        super.onPause();
        flashlightController.setActive(false);
    }

}
