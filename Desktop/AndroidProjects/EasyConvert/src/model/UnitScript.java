package model;

import java.util.ArrayList;

public class UnitScript {
    private ArrayList<String> unitListIn;
    private ArrayList<String> unitListOut;

    public UnitScript() {
        unitListIn = new ArrayList<String>();
        unitListOut = new ArrayList<String>();
    }

    public void addIn(String unitIn) {
        unitListIn.add(unitIn);

    }
    public void addOut(String unitOut) {
        unitListOut.add(unitOut);
    }

    public ArrayList<String> getUnitListIn() {
        return unitListIn;
    }

    public ArrayList<String> getUnitListOut() {
        return unitListOut;
    }


}
