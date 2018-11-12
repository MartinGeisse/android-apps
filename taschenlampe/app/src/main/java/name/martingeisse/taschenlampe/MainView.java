package name.martingeisse.taschenlampe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MainView extends View {

    private static final float RADIUS = 200.0f;
    private static final float RADIUS_SQUARED = RADIUS * RADIUS;

    private final Paint redPaint;
    private final Paint greenPaint;
    private final FlashlightController flashlightController;

    public MainView(Context context, FlashlightController flashlightController) {
        super(context);
        this.flashlightController = flashlightController;
        setBackgroundColor(Color.BLACK);
        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float dx = event.getX() - getWidth() / 2;
            float dy = event.getY() - getHeight() / 2;
            if (dx * dx + dy * dy < RADIUS_SQUARED) {
                flashlightController.toggle();
                invalidate();
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 200.0f,
                flashlightController.isActive() ? greenPaint : redPaint);
    }

}
