package origami_editor.editor.drawing_worker;

import origami.crease_pattern.element.LineColor;
import origami.crease_pattern.element.Point;
import origami_editor.editor.MouseMode;

public class MouseHandlerLineSegmentDelete extends BaseMouseHandler{

    public MouseHandlerLineSegmentDelete(DrawingWorker d) {
        super(d);
    }

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.LINE_SEGMENT_DELETE_3;
    }

    @Override
    public void mouseMoved(Point p0) {

    }

    //3 3 3 3 3 33333333333333333333333333333333333333333333333333333333
    //マウス操作(mouseMode==3,23 "線分削除" でボタンを押したとき)時の作業----------------------------------------------------
    @Override
    public void mousePressed(Point p0) {
        //System.out.println("(1)zzzzz foldLineSet.check4_size() = "+foldLineSet.check4_size());
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.POLY_LINE_0) {
            d.mPressed_A_box_select(p0);
        }//折線の削除
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.BLACK_LINE_2) {
            d.mPressed_A_box_select(p0);
        }//黒の折線
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LIVE_LINE_3) {
            d.mPressed_A_box_select(p0);
        }//補助活線

        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LINE_1) {
            d.mPressed_A_box_select(p0);
        }//補助絵線

        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.BOTH_4) {
            d.mPressed_A_box_select(p0);
        }//折線と補助活線と補助絵線
    }
//--------------------

    //マウス操作(mouseMode==3,23でドラッグしたとき)を行う関数----------------------------------------------------
    @Override
    public void mouseDragged(Point p0) {
        //System.out.println("(2)zzzzz foldLineSet.check4_size() = "+foldLineSet.check4_size());
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.POLY_LINE_0) {
            d.mDragged_A_box_select(p0);
        }
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.BLACK_LINE_2) {
            d.mDragged_A_box_select(p0);
        }
        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LIVE_LINE_3) {
            d.mDragged_A_box_select(p0);
        }

        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LINE_1) {
            d.mDragged_A_box_select(p0);
        }

        if (d.i_foldLine_additional == FoldLineAdditionalInputMode.BOTH_4) {
            d.mDragged_A_box_select(p0);
        }
    }

    //マウス操作(mouseMode==3,23 でボタンを離したとき)を行う関数----------------------------------------------------
    @Override
    public void mouseReleased(Point p0) {//折線と補助活線と円
        Point p = new Point();
        //System.out.println("(3_1)zzzzz foldLineSet.check4_size() = "+foldLineSet.check4_size());
        //Ten p =new Ten();
        p.set(d.camera.TV2object(p0));
        d.i_drawing_stage = 0;

        //最寄の一つを削除
        if (d.p19_1.distance(p0) <= 0.000001) {//最寄の一つを削除
            int i_removal_mode;//i_removal_mode is defined and declared here
            switch (d.i_foldLine_additional) {
                case POLY_LINE_0:
                    i_removal_mode = 0;
                    break;
                case BLACK_LINE_2:
                    i_removal_mode = 2;
                    break;
                case AUX_LIVE_LINE_3:
                    i_removal_mode = 3;
                    break;
                case AUX_LINE_1:
                    i_removal_mode = 1;
                    break;
                case BOTH_4:
                    i_removal_mode = 10;
                    double rs_min = d.foldLineSet.closestLineSegmentDistance(p);//点pに最も近い線分(折線と補助活線)の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                    double re_min = d.foldLineSet.closestCircleDistance(p);//点pに最も近い円の番号での、その距離を返す	public double mottomo_tikai_en_kyori(Ten p)
                    double hoj_rs_min = d.auxLines.closestLineSegmentDistance(p);//点pに最も近い補助絵線の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                    if ((rs_min <= re_min) && (rs_min <= hoj_rs_min)) {
                        if (d.foldLineSet.getColor(d.foldLineSet.closestLineSegmentSearchReversedOrder(p)).getNumber() < 3) {
                            i_removal_mode = 0;
                        } else {
                            i_removal_mode = 3;
                        }
                    }
                    if ((re_min < rs_min) && (re_min <= hoj_rs_min)) {
                        i_removal_mode = 3;
                    }
                    if ((hoj_rs_min < rs_min) && (hoj_rs_min < re_min)) {
                        i_removal_mode = 1;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            if (i_removal_mode == 0) { //折線の削除

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = d.foldLineSet.closestLineSegmentDistance(p);//点pに最も近い線分(折線と補助活線)の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d.selectionDistance) {
                    if (d.foldLineSet.getColor(d.foldLineSet.closestLineSegmentSearchReversedOrder(p)).getNumber() < 3) {
                        d.foldLineSet.deleteLineSegment_vertex(d.foldLineSet.closestLineSegmentSearchReversedOrder(p));
                        d.organizeCircles();
                        d.record();
                    }
                }
            }

            if (i_removal_mode == 2) { //黒の折線の削除
                double rs_min = d.foldLineSet.closestLineSegmentDistance(p);//点pに最も近い線分(折線と補助活線)の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d.selectionDistance) {
                    if (d.foldLineSet.getColor(d.foldLineSet.closestLineSegmentSearchReversedOrder(p)) == LineColor.BLACK_0) {
                        d.foldLineSet.deleteLineSegment_vertex(d.foldLineSet.closestLineSegmentSearchReversedOrder(p));
                        d.organizeCircles();
                        d.record();
                    }
                }
            }

            if (i_removal_mode == 3) {  //補助活線
                double rs_min = d.foldLineSet.closestLineSegmentDistance(p);//点pに最も近い線分(折線と補助活線)の番号での、その距離を返す
                double re_min = d.foldLineSet.closestCircleDistance(p);//点pに最も近い円の番号での、その距離を返す	public double mottomo_tikai_en_kyori(Ten p)

                if (rs_min <= re_min) {
                    if (rs_min < d.selectionDistance) {//点pに最も近い線分の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                        if (d.foldLineSet.getColor(d.foldLineSet.closestLineSegmentSearchReversedOrder(p)) == LineColor.CYAN_3) {
                            d.foldLineSet.deleteLineSegment_vertex(d.foldLineSet.closestLineSegmentSearchReversedOrder(p));
                            d.organizeCircles();
                            d.record();
                        }
                    }
                } else {
                    if (re_min < d.selectionDistance) {
                        d.foldLineSet.deleteCircle(d.foldLineSet.closest_circle_search_reverse_order(p));
                        d.organizeCircles();
                        d.record();
                    }
                }
            }

            if (i_removal_mode == 1) { //補助絵線
                double rs_min;
                rs_min = d.auxLines.closestLineSegmentDistance(p);//点pに最も近い補助絵線の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)

                if (rs_min < d.selectionDistance) {
                    d.auxLines.deleteLineSegment_vertex(d.auxLines.closestLineSegmentSearchReversedOrder(p));
                    d.record();
                }
            }
        }


        //四角枠内の削除 //p19_1はselectの最初のTen。この条件は最初のTenと最後の点が遠いので、四角を発生させるということ。
        if (d.p19_1.distance(p0) > 0.000001) {
            if ((d.i_foldLine_additional == FoldLineAdditionalInputMode.POLY_LINE_0) || (d.i_foldLine_additional == FoldLineAdditionalInputMode.BOTH_4)) { //折線の削除	//D_nisuru(p19_1,p0)で折線だけが削除される。
                if (d.deleteInside_foldingLine(d.p19_1, p0)) {
                    d.organizeCircles();
                    d.record();
                }
            }


            if (d.i_foldLine_additional == FoldLineAdditionalInputMode.BLACK_LINE_2) {  //Delete only the black polygonal line
                if (d.deleteInside_edge(d.p19_1, p0)) {
                    d.organizeCircles();
                    d.record();
                }
            }


            if ((d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LIVE_LINE_3) || (d.i_foldLine_additional == FoldLineAdditionalInputMode.BOTH_4)) {  //Auxiliary live line // Currently it is recorded for undo even if it is not deleted 20161218
                if (d.deleteInside_aux(d.p19_1, p0)) {
                    d.organizeCircles();
                    d.record();
                }
            }

            if ((d.i_foldLine_additional == FoldLineAdditionalInputMode.AUX_LINE_1) || (d.i_foldLine_additional == FoldLineAdditionalInputMode.BOTH_4)) { //補助絵線	//現状では削除しないときもUNDO用に記録されてしまう20161218
                if (d.deleteInside(d.p19_1, p0)) {
                    d.record();
                }
            }

        }

//qqqqqqqqqqqqqqqqqqqqqqqqqqqqq//System.out.println("= ");qqqqq
//check4(0.0001);//D_nisuru0をすると、foldLineSet.D_nisuru0内でresetが実行されるため、check4のやり直しが必要。
        if (d.check1) {
            d.check1(0.001, 0.5);
        }
        if (d.check2) {
            d.check2(0.01, 0.5);
        }
        if (d.check3) {
            d.check3(0.0001);
        }
        if (d.check4) {
            d.check4(0.0001);
        }

    }
}