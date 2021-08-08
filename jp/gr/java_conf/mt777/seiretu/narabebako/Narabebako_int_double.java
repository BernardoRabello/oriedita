package jp.gr.java_conf.mt777.seiretu.narabebako;

import java.util.*;

public class Narabebako_int_double {//データーをdoubleの小さい順に整列して収める
    ArrayList<int_double> i_d_List = new ArrayList<>();
    //---------------------------------


    //コンストラクタ
    public Narabebako_int_double() {
        i_d_List.add(new int_double(0, -1.0));
    }

    //
    public void reset() {
        i_d_List.clear();
        i_d_List.add(new int_double());
    }

    //
    public int getsousuu() {
        return i_d_List.size() - 1;
    }

    //
    public int_double get_i_d(int i) {//並べ箱内の前からi番目のint_doubleを取り出す
        int_double i_d_temp = new int_double();
        i_d_temp.set(i_d_List.get(i));
        return i_d_temp;
        //return (int_double)i_d_List.get(i);

    }

    //
    public int get_jyunjyo(int i_of_i_d) {//並べられた結果として、intの順序を返す。intに同じ値があると結果はおかしくなる
        for (int i = 1; i <= getsousuu(); i++) {

            if (i_of_i_d == get_int(i)) {
                return i;
            }


        }

        return 0;//順番が0ということはありえないので、intの順番を見つけられなかった場合は0を返す。
    }


//-------------------------

    public int get_int(int i) {//並べられた結果、順序がi番目になったintを返す
        int_double i_d_temp = new int_double();
        i_d_temp.set(i_d_List.get(i));
        return i_d_temp.get_i();
    }

    public int usirokara_get_int(int iu) {//後ろからi番目のintを返す
        int i = getsousuu() + 1 - iu;
        int_double i_d_temp = new int_double();
        i_d_temp.set(i_d_List.get(i));
        return i_d_temp.get_i();
    }

    public double get_double(int i) {//並べられた結果、順序がi番目になったintとペアのdoubleを返す
        int_double i_d_temp = new int_double();
        i_d_temp.set(i_d_List.get(i));
        return i_d_temp.get_d();
    }

    public void add(int_double i_d_0) {//int_doubleを単に最後尾に加える
        i_d_List.add(i_d_0);
    }


    public void add(int i, int_double i_d_0) {//int_doubleを単にi番目にに加える（挿入する）
        i_d_List.add(i, i_d_0);
    }


    public void ire_i_tiisaijyun(int_double i_d_0) {//この関数の名前の意味はiをdの小さい順に入れるという意味だがわかりにくいかも
        for (int i = 1; i <= getsousuu(); i++) {

            if (i_d_0.get_d() < get_double(i)) {
                i_d_List.add(i, i_d_0);
                return;
            }


        }

        i_d_List.add(i_d_0);

        //for(int i=1;i<=m0.getGyousuu();i++){
        //	addGyou(m0.getGyou(i));
        //}
    }


    public void set(Narabebako_int_double nbox) {
        reset();
        for (int i = 1; i <= nbox.getsousuu(); i++) {
            i_d_List.add(nbox.get_i_d(i));
        }
    }

//

    //int_doubleの1番目をgetsousuu番目にし、2番目を1番目、3番目を2番目、、、getsousuu番目をgetsousuu-1番目にする
    public void jyunkai2wo1nisuru() {
        Narabebako_int_double nbox = new Narabebako_int_double();
        for (int i = 2; i <= getsousuu(); i++) {
            nbox.add(get_i_d(i));
        }
        nbox.add(get_i_d(1));

        set(nbox);

    }


    public void hyouji() {
        System.out.println("--- narabebako.hyouji() ---");
        for (int k = 1; k <= getsousuu(); k++) {
            int_double i_d_temp = new int_double();
            i_d_temp.set(i_d_List.get(k));

            System.out.println("   Narabebako.hyouj " + k + " : " + i_d_temp.get_i() + "," + i_d_temp.get_d());
        }
    }


}



