package com.piotrszych.zadanielista.units;

import java.util.ArrayList;

public class DatabaseDummy {
    private static ArrayList<ListObject> tableDummy;
    private static DatabaseDummy instance;

    private DatabaseDummy() {
        //TODO initialize array here
    }

    public static DatabaseDummy getInstance() {
        if(instance == null) {
            instance = new DatabaseDummy();
        }
        return instance;
    }

    public int getItemCount() {
        return tableDummy.size();
    }

    public ListObject getItemAt(int index) {
        if(index < 0 || index >= tableDummy.size())
            throw new ArrayIndexOutOfBoundsException();

        return tableDummy.get(index);
    }
}
