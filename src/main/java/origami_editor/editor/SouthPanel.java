package origami_editor.editor;

import origami_editor.editor.component.FoldedFigureResize;
import origami_editor.editor.component.FoldedFigureRotate;
import origami_editor.editor.component.UndoRedo;
import origami_editor.editor.folded_figure.FoldedFigure;
import origami_editor.record.string_op.StringOp;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JButton foldButton;
    private JPanel panel1;
    private JButton anotherSolutionButton;
    private JButton flipButton;
    private JTextField goToFoldedFigureTextField;
    private FoldedFigureRotate foldedFigureRotate;
    private FoldedFigureResize foldedFigureResize;
    private JButton a_aButton;
    private JButton shadowButton;
    private JButton FCButton;
    private JButton BCButton;
    private JButton LCButton;
    private JButton haltButton;
    private JButton trashButton;
    private JButton resetButton;
    private JButton oriagari_sousaButton;
    private JButton oriagari_sousa_2Button;
    private JButton As100Button;
    private JButton goToFoldedFigureButton;
    private UndoRedo undoRedo;
    private JButton foldedFigureMove;
    private final App app;

    public SouthPanel(App app) {
        this.app = app;

        $$$setupUI$$$();
        foldButton.addActionListener(e -> {
            app.setHelp("qqq/suitei_04.png");

            System.out.println("20180220 get_i_fold_type() = " + app.getFoldType());
            app.oritatame(app.getFoldType(), FoldedFigure.EstimationOrder.ORDER_5);//引数の意味は(i_fold_type , i_suitei_meirei);

            if (!app.ckbox_select_nokosi.isSelected()) {
                app.es1.unselect_all();
            }

            app.Button_shared_operation();
        });
        anotherSolutionButton.addActionListener(e -> {
            app.setHelp("qqq/Button3.png");

            app.OZ.estimationOrder = FoldedFigure.EstimationOrder.ORDER_6;

            app.subThreadMode = SubThread.Mode.FOLDING_ESTIMATE_0;//1 = Put together another solution for folding estimation. 0 = It is not a mode to put out different solutions of folding estimation at once. This variable is used to change the behavior of subthreads.
            if (!app.subThreadRunning) {
                app.subThreadRunning = true;
                app.mks();//新しいスレッドを作る
                app.sub.start();
            }
        });
        flipButton.addActionListener(e -> {
            app.setHelp("qqq/Button0b.png");
            app.OZ.ip4 = app.OZ.ip4.advance();
            if ((app.i_mouse_modeA == MouseMode.MODIFY_CALCULATED_SHAPE_101) && (app.OZ.ip4 == FoldedFigure.State.BOTH_2)) {
                app.OZ.ip4 = FoldedFigure.State.FRONT_0;
            }//Fold-up forecast map Added to avoid the mode that can not be moved when moving
            app.Button_shared_operation();
            app.canvas.repaint();
        });
        As100Button.addActionListener(e -> {
            app.subThreadMode = SubThread.Mode.FOLDING_ESTIMATE_SAVE_100_1;
            app.setHelp("qqq/AS_matome.png");
            if (app.OZ.findAnotherOverlapValid) {
                app.OZ.estimationOrder = FoldedFigure.EstimationOrder.ORDER_6;

                if (!app.subThreadRunning) {
                    app.subThreadRunning = true;
                    app.mks();//新しいスレッドを作る
                    app.sub.start();
                }
            }
        });
        goToFoldedFigureButton.addActionListener(e -> {
            int foldedCases_old = app.foldedCases;
            app.foldedCases = StringOp.String2int(goToFoldedFigureTextField.getText(), foldedCases_old);
            if (app.foldedCases < 1) {
                app.foldedCases = 1;
            }

            app.text26.setText(String.valueOf(app.foldedCases));

            app.OZ.estimationOrder = FoldedFigure.EstimationOrder.ORDER_6;

            if (app.foldedCases < app.OZ.discovered_fold_cases) {
                app.configure_syokika_yosoku();//折り上がり予想の廃棄
                app.OZ.estimationOrder = FoldedFigure.EstimationOrder.ORDER_51;    //i_suitei_meirei=51はoritatami_suiteiの最初の推定図用カメラの設定は素通りするための設定。推定図用カメラの設定を素通りしたら、i_suitei_meirei=5に変更される。
                //1例目の折り上がり予想はi_suitei_meirei=5を指定、2例目以降の折り上がり予想はi_suitei_meirei=6で実施される
            }

            app.subThreadMode = SubThread.Mode.FOLDING_ESTIMATE_SPECIFIC_2;
            if (!app.subThreadRunning) {
                app.subThreadRunning = true;
                app.mks();//新しいスレッドを作る
                app.sub.start();
            }

            app.setHelp("qqq/bangou_sitei_suitei_hyouji.png");
            app.Button_shared_operation();
            app.canvas.repaint();
        });

        undoRedo.addUndoActionListener(e -> {
            app.setHelp("qqq/undo.png");

            app.OZ.undo();
            app.Button_shared_operation();
            app.canvas.repaint();
        });
        undoRedo.addRedoActionListener(e -> {
            app.setHelp("qqq/redo.png");

            app.OZ.redo();
            app.Button_shared_operation();
            app.canvas.repaint();
        });
        undoRedo.addSetUndoCountActionListener(e -> {
            app.setHelp("qqq/undo_syutoku.png");
            int i_undo_suu_om_old = app.i_undo_suu_om;
            app.i_undo_suu_om = StringOp.String2int(app.foldedFigureUndoRedo.getText(), i_undo_suu_om_old);
            if (app.i_undo_suu < 0) {
                app.i_undo_suu_om = 0;
            }
            app.foldedFigureUndoRedo.setText(String.valueOf(app.i_undo_suu_om));
            app.OZ.cp_worker2.setUndoBoxUndoTotal(app.i_undo_suu_om);                  //  <<<------------
        });
        oriagari_sousaButton.addActionListener(e -> {
            app.setHelp("qqq/oriagari_sousa.png");
            app.OZ.i_foldedFigure_operation_mode = 1;
            app.OZ.setAllPointStateFalse();
            app.OZ.record();
            app.i_mouse_modeA = MouseMode.MODIFY_CALCULATED_SHAPE_101;
            System.out.println("i_mouse_modeA = " + app.i_mouse_modeA);

            app.Button_shared_operation();
        });
        oriagari_sousa_2Button.addActionListener(e -> {
            app.setHelp("qqq/oriagari_sousa_2.png");
            app.OZ.i_foldedFigure_operation_mode = 2;
            app.OZ.setAllPointStateFalse();
            app.OZ.record();
            app.i_mouse_modeA = MouseMode.MODIFY_CALCULATED_SHAPE_101;
            System.out.println("i_mouse_modeA = " + app.i_mouse_modeA);


            app.Button_shared_operation();
        });
        foldedFigureMove.addActionListener(e -> {
            app.setHelp("qqq/oriagari_idiu.png");

            app.i_mouse_modeA = MouseMode.MOVE_CALCULATED_SHAPE_102;
            System.out.println("i_mouse_modeA = " + app.i_mouse_modeA);
            app.Button_shared_operation();
        });
        a_aButton.addActionListener(e -> {
            app.Button_shared_operation();
            app.setHelp("qqq/a_a.png");

            app.OZ.ct_worker.toggleAntiAlias();
            app.canvas.repaint();
        });
        shadowButton.addActionListener(e -> {
            app.Button_shared_operation();
            app.setHelp("qqq/kage.png");
            app.OZ.ct_worker.toggleDisplayShadows();
            app.canvas.repaint();
        });
        FCButton.addActionListener(e -> {
            app.setHelp("qqq/F_color.png");
            app.Button_shared_operation();
            app.i_mouseDragged_valid = false;
            app.i_mouseReleased_valid = false;

            //以下にやりたいことを書く

            app.OZ.foldedFigure_F_color = JColorChooser.showDialog(null, "F_col", Color.white);
            if (app.OZ.foldedFigure_F_color != null) {
                app.OZ.ct_worker.set_F_color(app.OZ.foldedFigure_F_color);
            }

            //以上でやりたいことは書き終わり

            app.Button_F_color.setBackground(app.OZ.foldedFigure_F_color);    //ボタンの色設定

            app.canvas.repaint();
        });
        BCButton.addActionListener(e -> {
            app.setHelp("qqq/B_color.png");
            app.Button_shared_operation();
            app.i_mouseDragged_valid = false;
            app.i_mouseReleased_valid = false;

            //以下にやりたいことを書く
            app.OZ.foldedFigure_B_color = JColorChooser.showDialog(null, "B_col", Color.white);

            if (app.OZ.foldedFigure_B_color != null) {
                app.OZ.ct_worker.set_B_color(app.OZ.foldedFigure_B_color);
            }
            //以上でやりたいことは書き終わり

            app.Button_B_color.setBackground(app.OZ.foldedFigure_B_color);    //ボタンの色設定
            app.canvas.repaint();
        });
        LCButton.addActionListener(e -> {
            app.setHelp("qqq/L_color.png");
            app.Button_shared_operation();
            app.i_mouseDragged_valid = false;
            app.i_mouseReleased_valid = false;

            //以下にやりたいことを書く

            app.OZ.foldedFigure_L_color = JColorChooser.showDialog(null, "L_col", Color.white);
            if (app.OZ.foldedFigure_L_color != null) {
                app.OZ.ct_worker.set_L_color(app.OZ.foldedFigure_L_color);
            }


            //以上でやりたいことは書き終わり

            app.Button_L_color.setBackground(app.OZ.foldedFigure_L_color);    //ボタンの色設定
            app.canvas.repaint();
        });
        haltButton.addActionListener(e -> {
            app.setHelp("qqq/keisan_tyuusi.png");

            if (app.subThreadRunning) {
                app.keisan_tyuusi();
            }

            app.Button_shared_operation();
        });
        trashButton.addActionListener(e -> {
            app.setHelp("qqq/settei_syokika.png");

            if (app.i_OAZ == 0) {
                return;
            }
            app.OZ = app.temp_OZ;//20171223この行は不要かもしれないが、一瞬でもOZが示すOriagari_Zuがなくなることがないように念のために入れておく
            if (app.i_OAZ == app.OAZ.size() - 1) {
                app.OAZ.remove(app.i_OAZ);
                app.set_i_OAZ(app.OAZ.size() - 1);
            }
            if (app.i_OAZ < app.OAZ.size() - 1) {
                app.OAZ.remove(app.i_OAZ);
                app.set_i_OAZ(app.i_OAZ);
            }

            app.Button_shared_operation();
            app.canvas.repaint();
        });
        resetButton.addActionListener(e -> {

            app.setHelp("qqq/zen_syokika.png");

            //展開図の初期化　開始
            //settei_syokika_cp();//展開図パラメータの初期化
            app.developmentView_initialization();
            //展開図の初期化　終了
            //
            //折畳予測図のの初期化　開始
            app.OZ = app.temp_OZ;//20171223この行は不要かもしれないが、一瞬でもOZが示すOriagari_Zuがなくなることがないように念のために入れておく
            app.OAZ.clear();
            app.OAZ_add_new_Oriagari_Zu();
            app.set_i_OAZ(0);
            app.configure_syokika_yosoku();
            //折畳予測図のの初期化　終了

            app.Button_shared_operation();
            app.canvas.repaint();
            app.i_mouse_modeA = MouseMode.FOLDABLE_LINE_DRAW_71;
            System.out.println("i_mouse_modeA = " + app.i_mouse_modeA);

            app.es1.record();
            app.es1.h_record();
        });
    }

    public JButton getFCButton() {
        return FCButton;
    }

    public JButton getBCButton() {
        return BCButton;
    }

    public JButton getLCButton() {
        return LCButton;
    }

    public UndoRedo getUndoRedo() {
        return undoRedo;
    }

    public JTextField getGoToFoldedFigureTextField() {
        return goToFoldedFigureTextField;
    }

    public JButton getGoToFoldedFigureButton() {
        return goToFoldedFigureButton;
    }

    public JButton getAs100Button() {
        return As100Button;
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
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        foldButton = new JButton();
        foldButton.setIcon(new ImageIcon(getClass().getResource("/ppp/suitei_04.png")));
        foldButton.setText("Fold");
        panel1.add(foldButton);
        anotherSolutionButton = new JButton();
        anotherSolutionButton.setText("a_s");
        panel1.add(anotherSolutionButton);
        flipButton = new JButton();
        flipButton.setIcon(new ImageIcon(getClass().getResource("/ppp/Button0b.png")));
        panel1.add(flipButton);
        As100Button = new JButton();
        As100Button.setText("AS100");
        panel1.add(As100Button);
        goToFoldedFigureTextField = new JTextField();
        panel1.add(goToFoldedFigureTextField);
        goToFoldedFigureButton = new JButton();
        goToFoldedFigureButton.setText("Go");
        panel1.add(goToFoldedFigureButton);
        undoRedo = new UndoRedo();
        panel1.add(undoRedo.$$$getRootComponent$$$());
        oriagari_sousaButton = new JButton();
        oriagari_sousaButton.setIcon(new ImageIcon(getClass().getResource("/ppp/oriagari_sousa.png")));
        panel1.add(oriagari_sousaButton);
        oriagari_sousa_2Button = new JButton();
        oriagari_sousa_2Button.setIcon(new ImageIcon(getClass().getResource("/ppp/oriagari_sousa_2.png")));
        panel1.add(oriagari_sousa_2Button);
        foldedFigureMove = new JButton();
        foldedFigureMove.setIcon(new ImageIcon(getClass().getResource("/ppp/oriagari_idiu.png")));
        panel1.add(foldedFigureMove);
        panel1.add(foldedFigureRotate.$$$getRootComponent$$$());
        panel1.add(foldedFigureResize.$$$getRootComponent$$$());
        a_aButton = new JButton();
        a_aButton.setText("a_a");
        panel1.add(a_aButton);
        shadowButton = new JButton();
        shadowButton.setText("S");
        panel1.add(shadowButton);
        FCButton = new JButton();
        FCButton.setIcon(new ImageIcon(getClass().getResource("/ppp/F_color.png")));
        panel1.add(FCButton);
        BCButton = new JButton();
        BCButton.setIcon(new ImageIcon(getClass().getResource("/ppp/B_color.png")));
        panel1.add(BCButton);
        LCButton = new JButton();
        LCButton.setIcon(new ImageIcon(getClass().getResource("/ppp/L_color.png")));
        panel1.add(LCButton);
        haltButton = new JButton();
        haltButton.setIcon(new ImageIcon(getClass().getResource("/ppp/keisan_tyuusi.png")));
        panel1.add(haltButton);
        trashButton = new JButton();
        trashButton.setIcon(new ImageIcon(getClass().getResource("/ppp/settei_syokika.png")));
        panel1.add(trashButton);
        resetButton = new JButton();
        resetButton.setIcon(new ImageIcon(getClass().getResource("/ppp/zen_syokika.png")));
        panel1.add(resetButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    public JButton getAnotherSolutionButton() {
        return anotherSolutionButton;
    }

    private void createUIComponents() {
        panel1 = this;
        foldedFigureResize = new FoldedFigureResize(app);
        foldedFigureRotate = new FoldedFigureRotate(app);
    }

    public JTextField getFoldedFigureResizeTextField() {
        return foldedFigureResize.getSizeTextField();
    }

    public JTextField getFoldedFigureRotateTextField() {
        return foldedFigureRotate.getFoldedFigureRotateTextField();
    }
}
