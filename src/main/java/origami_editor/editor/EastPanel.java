package origami_editor.editor;

import origami_editor.editor.drawing_worker.Drawing_Worker;
import origami_editor.record.string_op.StringOp;

import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {
    private JCheckBox cAMVCheckBox;
    private JButton ck4_colorIncreaseButton;
    private JCheckBox ckTCheckBox;
    private JCheckBox ckOCheckBox;
    private JButton fxOButton;
    private JButton fxTButton;
    private JButton angleSystemAButton;
    private JButton ck4_colorDecreaseButton;
    private JButton angleSystemADecreaseButton;
    private JButton angleSystemAIncreaseButton;
    private JButton angleSystemBDecreaseButton;
    private JButton angleSystemBButton;
    private JButton angleSystemBIncreaseButton;
    private JTextField angleATextField;
    private JTextField angleCTextField;
    private JTextField angleBTextField;
    private JButton restrictedAngleABCSetButton;
    private JButton c_colButton;
    private JButton l1Button;
    private JLabel measuredLength1Label;
    private JLabel measuredLength2Label;
    private JButton ad_fncButton;
    private JTextField h_undoTotalTextField;
    private JPanel panel1;
    private JButton degButton;
    private JButton deg3Button;
    private JButton angleRestrictedButton;
    private JButton deg2Button;
    private JButton deg4Button;
    private JButton polygonSizeSetButton;
    private JTextField polygonSizeTextField;
    private JButton regularPolygonButton;
    private JButton circleDrawFreeButton;
    private JButton circleDrawButton;
    private JButton circleDrawSeparateButton;
    private JButton circleDrawConcentricButton;
    private JButton circleDrawConcentricSelectButton;
    private JButton circleDrawTwoConcentricButton;
    private JButton circleDrawTangentLineButton;
    private JButton circleDrawThreePointButton;
    private JButton circleDrawInvertedButton;
    private JButton sen_tokutyuu_color_henkouButton;
    private JButton h_undoButton;
    private JButton h_redoButton;
    private JButton h_senhaba_sageButton;
    private JButton h_senhaba_ageButton;
    private JButton h_senbun_nyuryokuButton;
    private JButton h_senbun_sakujyoButton;
    private JButton restrictedAngleSetDEFButton;
    private JTextField angleDTextField;
    private JTextField angleETextField;
    private JTextField angleFTextField;
    private JButton h_undoTotalSetButton;
    private JButton colOrangeButton;
    private JButton colYellowButton;
    private JButton l2Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JLabel measuredAngle1Label;
    private JLabel measuredAngle2Label;
    private JLabel measuredAngle3Label;

    public EastPanel(App app) {

        $$$setupUI$$$();
        ckOCheckBox.addActionListener(e -> {
            app.setHelp("check1");
            app.es1.unselect_all();

            if (ckOCheckBox.isSelected()) {
                app.es1.check1(0.001, 0.5);//r_hitosiiとr_heikouhanteiは、hitosiiとheikou_hanteiのずれの許容程度
                app.es1.set_i_check1(true);
            } else {
                app.es1.set_i_check1(false);
            }
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        fxOButton.addActionListener(e -> {

            app.setHelp("fix1");
            app.es1.unselect_all();
            app.es1.fix1(0.001, 0.5);
            app.es1.check1(0.001, 0.5);
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        ckTCheckBox.addActionListener(e -> {
            app.setHelp("check2");
            app.es1.unselect_all();

            if (ckTCheckBox.isSelected()) {
                app.es1.check2(0.01, 0.5);//r_hitosiiとr_heikouhanteiは、hitosiiとheikou_hanteiのずれの許容程度
                app.es1.setCheck2(true);
            } else {
                app.es1.setCheck2(false);
            }
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        fxTButton.addActionListener(e -> {
            app.setHelp("fix2");
            app.es1.unselect_all();
            app.es1.fix2(0.001, 0.5);
            app.es1.check2(0.001, 0.5);
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        cAMVCheckBox.addActionListener(e -> {
            app.setHelp("check4");
            app.es1.unselect_all();

            if (cAMVCheckBox.isSelected()) {
                app.es1.check4(0.0001);//r_hitosiiとr_heikouhanteiは、hitosiiとheikou_hanteiのずれの許容程度
                app.es1.setCheck4(true);
            } else {
                app.es1.setCheck4(false);
            }
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        ck4_colorDecreaseButton.addActionListener(e -> {
            app.es1.ck4_color_sage();
            app.setHelp("ck4_color_sage");
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        ck4_colorIncreaseButton.addActionListener(e -> {
            app.es1.ck4_color_age();
            app.setHelp("ck4_color_age");
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        angleSystemADecreaseButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_a_tiisaku");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            app.id_angle_system_a = app.id_angle_system_a + 1;//if(id_angle_system_a<2){id_angle_system_a=2;}
            angleSystemAButton.setText("180/" + app.id_angle_system_a + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_a)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_a);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });

        angleSystemAButton.setText("180/" + app.id_angle_system_a + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_a)) * 1000)) / 1000.0);
        angleSystemAButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_a");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            angleSystemAButton.setText("180/" + app.id_angle_system_a + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_a)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_a);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        angleSystemAIncreaseButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_a_ookiku");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            app.id_angle_system_a = app.id_angle_system_a - 1;
            if (app.id_angle_system_a < 2) {
                app.id_angle_system_a = 2;
            }
            angleSystemAButton.setText("180/" + app.id_angle_system_a + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_a)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_a);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });

        angleSystemBDecreaseButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_b_tiisaku");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            app.id_angle_system_b = app.id_angle_system_b + 1;//if(id_angle_system_b<2){id_angle_system_b=2;}
            angleSystemBButton.setText("180/" + app.id_angle_system_b + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_b)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_b);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });

        angleSystemBButton.setText("180/" + app.id_angle_system_b + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_b)) * 1000)) / 1000.0);
        angleSystemBButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_b");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            angleSystemBButton.setText("180/" + app.id_angle_system_b + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_b)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_b);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        angleSystemBIncreaseButton.addActionListener(e -> {
            app.setHelp("kakudo_kei_b_ookiku");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            app.id_angle_system_b = app.id_angle_system_b - 1;
            if (app.id_angle_system_b < 2) {
                app.id_angle_system_b = 2;
            }
            angleSystemBButton.setText("180/" + app.id_angle_system_b + "=" + (double) (Math.round((180.0 / ((double) app.id_angle_system_b)) * 1000)) / 1000.0);

            app.es1.set_id_angle_system(app.id_angle_system_b);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        restrictedAngleABCSetButton.addActionListener(e -> {
            app.set_restricted_angle_abc();
            app.setHelp("jiyuu_kaku_set_a");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.set_id_angle_system(0);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });

        restrictedAngleSetDEFButton.addActionListener(e -> {
            app.setRestrictedAngleDEF();
            app.setHelp("jiyuu_kaku_set_b");

            switch (app.angle_system_input_id) {
                case DEG_1:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
                    break;
                case DEG_2:
                    app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
                    break;
                case DEG_3:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
                    break;
                case DEG_4:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
                    break;
                case DEG_5:
                    app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
                    break;
            }

            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.set_id_angle_system(0);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        degButton.addActionListener(e -> {
            app.setHelp("deg");

            app.angle_system_input_id = App.AngleSystemInputType.DEG_1;
            app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_13;
            System.out.println("mouseMode = " + app.mouseMode);


            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        deg3Button.addActionListener(e -> {
            app.setHelp("deg3");

            app.angle_system_input_id = App.AngleSystemInputType.DEG_3;
            app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_2_17;
            System.out.println("mouseMode = " + app.mouseMode);


            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        angleRestrictedButton.addActionListener(e -> {
            app.setHelp("senbun_nyuryoku37");
            app.angle_system_input_id = App.AngleSystemInputType.DEG_5;
            app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_37;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        deg2Button.addActionListener(e -> {

            app.setHelp("deg2");
            app.angle_system_input_id = App.AngleSystemInputType.DEG_2;
            app.mouseMode = MouseMode.ANGLE_SYSTEM_16;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        deg4Button.addActionListener(e -> {
            app.setHelp("deg4");
            app.angle_system_input_id = App.AngleSystemInputType.DEG_4;
            app.mouseMode = MouseMode.DRAW_CREASE_ANGLE_RESTRICTED_3_18;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        polygonSizeSetButton.addActionListener(e -> {
            int numPolygonCornersOld = app.numPolygonCorners;
            app.numPolygonCorners = StringOp.String2int(polygonSizeTextField.getText(), numPolygonCornersOld);
            if (app.numPolygonCorners < 3) {
                app.numPolygonCorners = 3;
            }
            if (app.numPolygonCorners > 100) {
                app.numPolygonCorners = 100;
            }
            polygonSizeTextField.setText(String.valueOf(app.numPolygonCorners));
            app.es1.setNumPolygonCorners(app.numPolygonCorners);

            app.setHelp("kakusuu_set");
            app.mouseMode = MouseMode.POLYGON_SET_NO_CORNERS_29;
            System.out.println("mouseMode = " + app.mouseMode);

            app.Button_shared_operation();
            app.repaintCanvas();
        });
        regularPolygonButton.addActionListener(e -> {
            int numPolygonCorners_old = app.numPolygonCorners;
            app.numPolygonCorners = StringOp.String2int(polygonSizeTextField.getText(), numPolygonCorners_old);
            if (app.numPolygonCorners < 3) {
                app.numPolygonCorners = 3;
            }
            polygonSizeTextField.setText(String.valueOf(app.numPolygonCorners));
            app.es1.setNumPolygonCorners(app.numPolygonCorners);

            app.setHelp("sei_takakukei");
            app.mouseMode = MouseMode.POLYGON_SET_NO_CORNERS_29;
            System.out.println("mouseMode = " + app.mouseMode);
            app.iro_sitei_ato_ni_jissisuru_sagyou_bangou = MouseMode.POLYGON_SET_NO_CORNERS_29;
            app.Button_shared_operation();
            app.repaintCanvas();
            app.es1.unselect_all();
        });
        circleDrawFreeButton.addActionListener(e -> {
            app.setHelp("en_nyuryoku_free");
            app.mouseMode = MouseMode.CIRCLE_DRAW_FREE_47;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawButton.addActionListener(e -> {
            app.setHelp("en_nyuryoku");
            app.mouseMode = MouseMode.CIRCLE_DRAW_42;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawSeparateButton.addActionListener(e -> {
            app.setHelp("en_bunri_nyuryoku");
            app.mouseMode = MouseMode.CIRCLE_DRAW_SEPARATE_44;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawConcentricButton.addActionListener(e -> {
            app.setHelp("dousin_en_tuika_s");
            app.mouseMode = MouseMode.CIRCLE_DRAW_CONCENTRIC_48;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawConcentricSelectButton.addActionListener(e -> {
            app.setHelp("dousin_en_tuika_d");
            app.mouseMode = MouseMode.CIRCLE_DRAW_CONCENTRIC_SELECT_49;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawTwoConcentricButton.addActionListener(e -> {
            app.setHelp("en_en_dousin_en");

            app.mouseMode = MouseMode.CIRCLE_DRAW_CONCENTRIC_TWO_CIRCLE_SELECT_50;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawTangentLineButton.addActionListener(e -> {
            app.setHelp("en_en_sessen");

            app.mouseMode = MouseMode.CIRCLE_DRAW_TANGENT_LINE_45;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawThreePointButton.addActionListener(e -> {
            app.setHelp("en_3ten_nyuryoku");

            app.mouseMode = MouseMode.CIRCLE_DRAW_THREE_POINT_43;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        circleDrawInvertedButton.addActionListener(e -> {
            app.setHelp("hanten");

            app.mouseMode = MouseMode.CIRCLE_DRAW_INVERTED_46;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        c_colButton.addActionListener(e -> {
            app.setHelp("sen_tokutyuu_color");
            app.Button_shared_operation();
            app.mouseDraggedValid = false;
            app.mouseReleasedValid = false;
            //以下にやりたいことを書く

            Color color = JColorChooser.showDialog(null, "color", new Color(100, 200, 200));
            if (color != null) {
                app.circleCustomizedColor = color;
            }

            //以上でやりたいことは書き終わり
            c_colButton.setBackground(app.circleCustomizedColor);    //ボタンの色設定

            app.mouseMode = MouseMode.CIRCLE_CHANGE_COLOR_59;
            System.out.println("mouseMode = " + app.mouseMode);
            app.es1.set_sen_tokutyuu_color(app.circleCustomizedColor);

            app.repaintCanvas();
        });
        sen_tokutyuu_color_henkouButton.addActionListener(e -> {
            app.setHelp("sen_tokutyuu_color_henkou");
            app.mouseMode = MouseMode.CIRCLE_CHANGE_COLOR_59;
            System.out.println("mouseMode = " + app.mouseMode);
            app.es1.set_sen_tokutyuu_color(app.circleCustomizedColor);
            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        h_undoButton.addActionListener(e -> {
            app.setHelp("undo");

            app.es1.h_undo();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        h_undoTotalSetButton.addActionListener(e -> {
            app.setHelp("h_undo_syutoku");
            int i_h_undo_suu_old = app.i_undo_suu;
            app.i_h_undo_suu = StringOp.String2int(h_undoTotalTextField.getText(), i_h_undo_suu_old);
            if (app.i_h_undo_suu < 0) {
                app.i_h_undo_suu = 0;
            }
            h_undoTotalTextField.setText(String.valueOf(app.i_h_undo_suu));
            app.es1.set_h_Ubox_undo_suu(app.i_h_undo_suu);
        });
        h_redoButton.addActionListener(e -> {
            app.setHelp("h_redo");

            app.es1.h_redo();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        h_senhaba_sageButton.addActionListener(e -> {
            app.displayAuxLineWidth = app.displayAuxLineWidth - 2;
            if (app.displayAuxLineWidth < 3) {
                app.displayAuxLineWidth = 3;
            }

            app.setHelp("h_senhaba_sage");
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        h_senhaba_ageButton.addActionListener(e -> {
            app.displayAuxLineWidth = app.displayAuxLineWidth + 2;
            app.setHelp("h_senhaba_age");
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        colOrangeButton.addActionListener(e -> {
            app.setHelp("Button_Col_orange");
            app.auxColorButtonReset();
            colOrangeButton.setBackground(Color.ORANGE);
            app.currentAuxLineColor = LineColor.ORANGE_4;
            app.es1.h_setcolor(app.currentAuxLineColor);
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        colYellowButton.addActionListener(e -> {
            app.setHelp("Button_Col_yellow");
            app.auxColorButtonReset();
            colYellowButton.setBackground(Color.yellow);
            app.currentAuxLineColor = LineColor.YELLOW_7;
            app.es1.h_setcolor(app.currentAuxLineColor);
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        h_senbun_nyuryokuButton.addActionListener(e -> {
            app.setHelp("h_senbun_nyuryoku");
            app.mouseMode = MouseMode.DRAW_CREASE_FREE_1;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
            app.foldLineAdditionalInputMode = Drawing_Worker.FoldLineAdditionalInputMode.AUX_LINE_1;//=0は折線入力　=1は補助線入力モード
            app.es1.setFoldLineAdditional(app.foldLineAdditionalInputMode);
        });
        h_senbun_sakujyoButton.addActionListener(e -> {
            app.setHelp("h_senbun_sakujyo");
            app.mouseMode = MouseMode.LINE_SEGMENT_DELETE_3;
            System.out.println("mouseMode = " + app.mouseMode);


            app.foldLineAdditionalInputMode = Drawing_Worker.FoldLineAdditionalInputMode.AUX_LINE_1;//= 0 is polygonal line input = 1 is auxiliary line input mode
            app.es1.setFoldLineAdditional(app.foldLineAdditionalInputMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        l1Button.addActionListener(e -> {
            app.setHelp("nagasa_sokutei_1");
            app.mouseMode = MouseMode.DISPLAY_LENGTH_BETWEEN_POINTS_1_53;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        l2Button.addActionListener(e -> {
            app.setHelp("nagasa_sokutei_2");
            app.mouseMode = MouseMode.DISPLAY_LENGTH_BETWEEN_POINTS_2_54;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        a1Button.addActionListener(e -> {
            app.setHelp("kakudo_sokutei_1");
            app.mouseMode = MouseMode.DISPLAY_ANGLE_BETWEEN_THREE_POINTS_1_55;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        a2Button.addActionListener(e -> {
            app.setHelp("kakudo_sokutei_2");
            app.mouseMode = MouseMode.DISPLAY_ANGLE_BETWEEN_THREE_POINTS_2_56;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        a3Button.addActionListener(e -> {
            app.setHelp("kakudo_sokutei_3");
            app.mouseMode = MouseMode.DISPLAY_ANGLE_BETWEEN_THREE_POINTS_3_57;
            System.out.println("mouseMode = " + app.mouseMode);

            app.es1.unselect_all();
            app.Button_shared_operation();
            app.repaintCanvas();
        });
        ad_fncButton.addActionListener(e -> {
            app.setHelp("tuika_kinou");

            app.Frame_tuika();
            app.add_frame.toFront();
        });
    }

    public JLabel getMeasuredLength1Label() {
        return measuredLength1Label;
    }

    public JLabel getMeasuredLength2Label() {
        return measuredLength2Label;
    }

    public JLabel getMeasuredAngle1Label() {
        return measuredAngle1Label;
    }

    public JLabel getMeasuredAngle2Label() {
        return measuredAngle2Label;
    }

    public JLabel getMeasuredAngle3Label() {
        return measuredAngle3Label;
    }

    public JButton getColOrangeButton() {
        return colOrangeButton;
    }

    public JButton getColYellowButton() {
        return colYellowButton;
    }

    public JTextField getH_undoTotalTextField() {
        return h_undoTotalTextField;
    }

    public JButton getC_colButton() {
        return c_colButton;
    }

    public JTextField getPolygonSizeTextField() {
        return polygonSizeTextField;
    }

    public JTextField getAngleATextField() {
        return angleATextField;
    }

    public JTextField getAngleCTextField() {
        return angleCTextField;
    }

    public JTextField getAngleBTextField() {
        return angleBTextField;
    }

    public JTextField getAngleDTextField() {
        return angleDTextField;
    }

    public JTextField getAngleETextField() {
        return angleETextField;
    }

    public JTextField getAngleFTextField() {
        return angleFTextField;
    }

    public JCheckBox getcAMVCheckBox() {
        return cAMVCheckBox;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1.setLayout(new GridBagLayout());
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        cAMVCheckBox = new JCheckBox();
        cAMVCheckBox.setText("cAMV");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(cAMVCheckBox, gbc);
        ck4_colorIncreaseButton = new JButton();
        ck4_colorIncreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/ck4_color_age.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(ck4_colorIncreaseButton, gbc);
        fxTButton = new JButton();
        fxTButton.setText("fxT");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(fxTButton, gbc);
        ckOCheckBox = new JCheckBox();
        ckOCheckBox.setText("ckO");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(ckOCheckBox, gbc);
        ckTCheckBox = new JCheckBox();
        ckTCheckBox.setText("ckT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(ckTCheckBox, gbc);
        ck4_colorDecreaseButton = new JButton();
        ck4_colorDecreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/ck4_color_sage.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(ck4_colorDecreaseButton, gbc);
        fxOButton = new JButton();
        fxOButton.setText("fxO");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(fxOButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer1, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        angleSystemAButton = new JButton();
        angleSystemAButton.setText("180/12=15.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemAButton, gbc);
        angleSystemADecreaseButton = new JButton();
        angleSystemADecreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/tiisaku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemADecreaseButton, gbc);
        angleSystemAIncreaseButton = new JButton();
        angleSystemAIncreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/ookiku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemAIncreaseButton, gbc);
        angleSystemBDecreaseButton = new JButton();
        angleSystemBDecreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/tiisaku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemBDecreaseButton, gbc);
        angleSystemBButton = new JButton();
        angleSystemBButton.setText("180/8=22.5");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemBButton, gbc);
        angleSystemBIncreaseButton = new JButton();
        angleSystemBIncreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/ookiku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(angleSystemBIncreaseButton, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer2, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel4, gbc);
        angleATextField = new JTextField();
        angleATextField.setText("40.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleATextField, gbc);
        angleCTextField = new JTextField();
        angleCTextField.setText("80.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleCTextField, gbc);
        angleBTextField = new JTextField();
        angleBTextField.setText("60.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleBTextField, gbc);
        restrictedAngleABCSetButton = new JButton();
        restrictedAngleABCSetButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(restrictedAngleABCSetButton, gbc);
        angleDTextField = new JTextField();
        angleDTextField.setText("30.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleDTextField, gbc);
        angleETextField = new JTextField();
        angleETextField.setText("50.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleETextField, gbc);
        angleFTextField = new JTextField();
        angleFTextField.setText("100.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(angleFTextField, gbc);
        restrictedAngleSetDEFButton = new JButton();
        restrictedAngleSetDEFButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(restrictedAngleSetDEFButton, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer3, gbc);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel5, gbc);
        degButton = new JButton();
        degButton.setIcon(new ImageIcon(getClass().getResource("/ppp/deg.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(degButton, gbc);
        deg3Button = new JButton();
        deg3Button.setIcon(new ImageIcon(getClass().getResource("/ppp/deg3.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(deg3Button, gbc);
        angleRestrictedButton = new JButton();
        angleRestrictedButton.setIcon(new ImageIcon(getClass().getResource("/ppp/senbun_nyuryoku37.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(angleRestrictedButton, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer4, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel6, gbc);
        c_colButton = new JButton();
        c_colButton.setText("C_col");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(c_colButton, gbc);
        sen_tokutyuu_color_henkouButton = new JButton();
        sen_tokutyuu_color_henkouButton.setIcon(new ImageIcon(getClass().getResource("/ppp/sen_tokutyuu_color_henkou.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(sen_tokutyuu_color_henkouButton, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 19;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer5, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 20;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel7, gbc);
        l1Button = new JButton();
        l1Button.setHorizontalAlignment(11);
        l1Button.setText("L1=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(l1Button, gbc);
        measuredLength1Label = new JLabel();
        measuredLength1Label.setBackground(new Color(-1));
        measuredLength1Label.setOpaque(true);
        measuredLength1Label.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(measuredLength1Label, gbc);
        l2Button = new JButton();
        l2Button.setHorizontalAlignment(11);
        l2Button.setText("L2=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(l2Button, gbc);
        measuredLength2Label = new JLabel();
        measuredLength2Label.setBackground(new Color(-1));
        measuredLength2Label.setOpaque(true);
        measuredLength2Label.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(measuredLength2Label, gbc);
        a3Button = new JButton();
        a3Button.setHorizontalAlignment(11);
        a3Button.setText("A3=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(a3Button, gbc);
        measuredAngle3Label = new JLabel();
        measuredAngle3Label.setBackground(new Color(-1));
        measuredAngle3Label.setOpaque(true);
        measuredAngle3Label.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(measuredAngle3Label, gbc);
        measuredAngle2Label = new JLabel();
        measuredAngle2Label.setBackground(new Color(-1));
        measuredAngle2Label.setOpaque(true);
        measuredAngle2Label.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(measuredAngle2Label, gbc);
        measuredAngle1Label = new JLabel();
        measuredAngle1Label.setBackground(new Color(-1));
        measuredAngle1Label.setOpaque(true);
        measuredAngle1Label.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(measuredAngle1Label, gbc);
        a2Button = new JButton();
        a2Button.setHorizontalAlignment(11);
        a2Button.setText("A2=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(a2Button, gbc);
        a1Button = new JButton();
        a1Button.setHorizontalAlignment(11);
        a1Button.setText("A1=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(a1Button, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 21;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer6, gbc);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 22;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel8, gbc);
        ad_fncButton = new JButton();
        ad_fncButton.setText("ad_fnc");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(ad_fncButton, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 23;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer8, gbc);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel9, gbc);
        circleDrawFreeButton = new JButton();
        circleDrawFreeButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_nyuryoku_free.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(circleDrawFreeButton, gbc);
        circleDrawConcentricButton = new JButton();
        circleDrawConcentricButton.setIcon(new ImageIcon(getClass().getResource("/ppp/dousin_en_tuika_s.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(circleDrawConcentricButton, gbc);
        circleDrawSeparateButton = new JButton();
        circleDrawSeparateButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_bunri_nyuryoku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(circleDrawSeparateButton, gbc);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel10, gbc);
        deg2Button = new JButton();
        deg2Button.setIcon(new ImageIcon(getClass().getResource("/ppp/deg2.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(deg2Button, gbc);
        deg4Button = new JButton();
        deg4Button.setIcon(new ImageIcon(getClass().getResource("/ppp/deg4.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(deg4Button, gbc);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel11, gbc);
        polygonSizeTextField = new JTextField();
        polygonSizeTextField.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        panel11.add(polygonSizeTextField, gbc);
        polygonSizeSetButton = new JButton();
        polygonSizeSetButton.setText("Set");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel11.add(polygonSizeSetButton, gbc);
        regularPolygonButton = new JButton();
        regularPolygonButton.setIcon(new ImageIcon(getClass().getResource("/ppp/sei_takakukei.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel11.add(regularPolygonButton, gbc);
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel12, gbc);
        circleDrawButton = new JButton();
        circleDrawButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_nyuryoku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel12.add(circleDrawButton, gbc);
        circleDrawConcentricSelectButton = new JButton();
        circleDrawConcentricSelectButton.setIcon(new ImageIcon(getClass().getResource("/ppp/dousin_en_tuika_d.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel12.add(circleDrawConcentricSelectButton, gbc);
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel13, gbc);
        circleDrawTwoConcentricButton = new JButton();
        circleDrawTwoConcentricButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_en_dousin_en.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel13.add(circleDrawTwoConcentricButton, gbc);
        circleDrawTangentLineButton = new JButton();
        circleDrawTangentLineButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_en_sessen.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel13.add(circleDrawTangentLineButton, gbc);
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel14, gbc);
        circleDrawThreePointButton = new JButton();
        circleDrawThreePointButton.setIcon(new ImageIcon(getClass().getResource("/ppp/en_3ten_nyuryoku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel14.add(circleDrawThreePointButton, gbc);
        circleDrawInvertedButton = new JButton();
        circleDrawInvertedButton.setIcon(new ImageIcon(getClass().getResource("/ppp/hanten.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel14.add(circleDrawInvertedButton, gbc);
        final JPanel panel15 = new JPanel();
        panel15.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel15, gbc);
        h_undoButton = new JButton();
        h_undoButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_undo.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel15.add(h_undoButton, gbc);
        h_undoTotalTextField = new JTextField();
        h_undoTotalTextField.setColumns(2);
        h_undoTotalTextField.setText("50");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel15.add(h_undoTotalTextField, gbc);
        h_undoTotalSetButton = new JButton();
        h_undoTotalSetButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel15.add(h_undoTotalSetButton, gbc);
        h_redoButton = new JButton();
        h_redoButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_redo.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel15.add(h_redoButton, gbc);
        final JPanel panel16 = new JPanel();
        panel16.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel16, gbc);
        h_senhaba_sageButton = new JButton();
        h_senhaba_sageButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_senhaba_sage.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel16.add(h_senhaba_sageButton, gbc);
        h_senhaba_ageButton = new JButton();
        h_senhaba_ageButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_senhaba_age.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel16.add(h_senhaba_ageButton, gbc);
        colOrangeButton = new JButton();
        colOrangeButton.setBackground(new Color(-6908266));
        colOrangeButton.setText("a1");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel16.add(colOrangeButton, gbc);
        colYellowButton = new JButton();
        colYellowButton.setBackground(new Color(-6908266));
        colYellowButton.setText("a2");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel16.add(colYellowButton, gbc);
        final JPanel panel17 = new JPanel();
        panel17.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel17, gbc);
        h_senbun_nyuryokuButton = new JButton();
        h_senbun_nyuryokuButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_senbun_nyuryoku.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel17.add(h_senbun_nyuryokuButton, gbc);
        h_senbun_sakujyoButton = new JButton();
        h_senbun_sakujyoButton.setIcon(new ImageIcon(getClass().getResource("/ppp/h_senbun_sakujyo.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel17.add(h_senbun_sakujyoButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private void createUIComponents() {
        panel1 = this;
    }
}