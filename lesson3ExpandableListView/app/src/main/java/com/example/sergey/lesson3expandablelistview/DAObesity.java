package com.example.sergey.lesson3expandablelistview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAObesity {

    private static DAObesity daObesity;

    static DAObesity getDaObesity() {
        if (daObesity == null) {
            daObesity = new DAObesity();
        }
        return daObesity;
    }

    private static List<Mobila> mobilaList = new ArrayList<>();


    private void save(Mobila e) {
        mobilaList.add(e);
    }

    List<Mobila> getMobilaList() {
        return mobilaList;
    }

    private DAObesity() {


        List<Model> htc = new ArrayList<>();
        htc.add(new Model(1, "D600"));
        htc.add(new Model(2, "M8"));
        htc.add(new Model(3, "One"));

        List<Model> lg = new ArrayList<>();
        lg.add(new Model(1, "3s"));
        lg.add(new Model(2, "4s"));
        lg.add(new Model(3, "L90"));

        List<Model> samsung = new ArrayList<>();
        samsung.add(new Model(1, "S3"));
        samsung.add(new Model(2, "J5"));
        samsung.add(new Model(3, "A7"));

        save(new Mobila(1, "HTC", htc));
        save(new Mobila(2, "LG", lg));
        save(new Mobila(3, "Samsung", samsung));


    }

    /*List<ArrayList<Mobila>> getByGroup() {
        Set<String> uniquiMark = new HashSet<>();
        List<ArrayList<Mobila>> groupList = new ArrayList<>();

        for (Mobila m : mobilaList) {
            uniquiMark.add(m.getMark().toString());
        }

        for (String marka : uniquiMark) {
            ArrayList<Mobila> list = new ArrayList<>();
            for (Mobila m : mobilaList) {
                if (marka.equals(m.getMark())) {
                    list.add(m);
                }
            }
            groupList.add(list);
        }
        return groupList;
    }*/

}
