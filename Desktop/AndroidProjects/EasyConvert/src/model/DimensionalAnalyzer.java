package model;

import java.util.ArrayList;

public class DimensionalAnalyzer {
    private ArrayList<String> listIn;
    private ArrayList<String> listOut;
    private ArrayList<Integer> powerIn = new ArrayList<Integer>();
    private ArrayList<Integer> powerOut = new ArrayList<Integer>();
    public void add(ArrayList<String> listIn, ArrayList<String> listOut) {
        this.listIn = listIn;
        this.listOut = listOut;
        powerIn.clear();
        powerOut.clear();
        powerExtractor();


    }

    private void powerExtractor() {
        //assume length the same
        int len = listIn.size();
        for(int i=0;i<len;i++) {
            powerIn.add(powerCheck(listIn.get(i)));
            powerOut.add(powerCheck(listOut.get(i)));

        }
    }

    private Integer powerCheck(String unitToCheck) {
        if(unitToCheck.contains("^") == false) {
                return 1;
        }else {
            return Integer.parseInt(unitToCheck.substring(unitToCheck.lastIndexOf('^') +1));
        }


    }
}
