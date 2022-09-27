package oriedita.editor.action;

import oriedita.editor.canvas.CreasePattern_Worker;
import oriedita.editor.canvas.MouseMode;
import oriedita.editor.databinding.MeasuresModel;
import origami.crease_pattern.OritaCalc;
import origami.crease_pattern.element.LineSegment;
import origami.crease_pattern.element.Point;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MouseHandlerDisplayLengthBetweenPoints1 extends BaseMouseHandlerInputRestricted {
    private final MeasuresModel measuresModel;

    @Inject
    public MouseHandlerDisplayLengthBetweenPoints1(CreasePattern_Worker d, MeasuresModel measuresModel) {
        this.d = d;
        this.measuresModel = measuresModel;
    }

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.DISPLAY_LENGTH_BETWEEN_POINTS_1_53;
    }

    //Work when operating the mouse (when the button is pressed)
    public void mousePressed(Point p0) {
        Point p = new Point();
        p.set(d.getCamera().TV2object(p0));
        Point closest_point = d.getClosestPoint(p);
        if (p.distance(closest_point) < d.getSelectionDistance()) {
            d.lineStepAdd(new LineSegment(closest_point, closest_point, d.getLineColor()));
        }
    }

    //マウス操作(ドラッグしたとき)を行う関数
    public void mouseDragged(Point p0) {
    }

    //マウス操作(ボタンを離したとき)を行う関数
    public void mouseReleased(Point p0) {
        if (d.getLineStep().size() == 2) {
            measuresModel.setMeasuredLength1(OritaCalc.distance(d.getLineStep().get(0).getA(), d.getLineStep().get(1).getA()) * (double) d.getGrid().getGridSize() / 400.0);
            d.getLineStep().clear();
        }
    }
}
