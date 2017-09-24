package model;

import model.enumerations.Mass;
import model.enumerations.Panjang;
import model.enumerations.Time;

import java.util.ArrayList;
import java.util.Observable;

public class DimensionalAnalyzer extends Observable{
    private ArrayList<String> listIn;
    private ArrayList<String> listOut;
    private ArrayList<Integer> powerIn = new ArrayList<Integer>();
    private ArrayList<Integer> powerOut = new ArrayList<Integer>();
    private ArrayList<String> unitInStripped = new ArrayList<String>(); //this array has the powers removed
    private ArrayList<String> unitOutStripped = new ArrayList<String>();
    private ArrayList<String> inPrefixes = new ArrayList<String>();
    private ArrayList<String> outPrefixes = new ArrayList<String>();
    private ArrayList<String> baseUnitIn = new ArrayList<String>();
    private ArrayList<String> baseUnitOut = new ArrayList<String>();
    private boolean lengthFlag = false; //false means that the Panjang is wrong
    public boolean dimensionFlag; //false means that the dimension is wrong


    public void add(ArrayList<String> listIn, ArrayList<String> listOut) {
        this.listIn = listIn;
        this.listOut = listOut;
        clearArrays();
        powerExtractor(); //extracts the power and strips the main array of powers
        unitExtractor();

        if(lengthFlag != false) {
            DimensionObserver dimensionObserver = new DimensionObserver();
            addObserver(dimensionObserver);
            analyzer();
        }

    }

    private void unitExtractor() {
        int len = unitInStripped.size();
        for(int j=0;j<len;j++) {
            inPrefixes.add(prefixStripper(unitInStripped.get(j)));
            outPrefixes.add(prefixStripper(unitOutStripped.get(j)));
            baseUnitIn.add(baseUnitExtractor(unitInStripped.get(j)));
            baseUnitOut.add(baseUnitExtractor(unitOutStripped.get(j)));


        }
    }
    private String prefixStripper(String unitToCheck) {
        if(unitToCheck.length() == 1) {
            return "noPrefix";
        } else {
            int length = unitToCheck.length();
            return unitToCheck.substring(0,length-1);

        }
    }
    private String baseUnitExtractor(String unitToCheck) {
        if(unitToCheck.length() == 1) {
            return unitToCheck;
        } else {
            int length = unitToCheck.length();
            return unitToCheck.substring(length-1,length);
        }
    }

    private void clearArrays() {
        powerIn.clear();
        powerOut.clear();
        unitInStripped.clear();
        unitOutStripped.clear();
        inPrefixes.clear();
        outPrefixes.clear();
        baseUnitIn.clear();
        baseUnitOut.clear();

    }

    private void analyzer() {
        int len = listIn.size();
        for(int i=0;i<len;i++) {
            String unitIn = unitInStripped.get(i); //obtains the units in the array
            String unitOut = unitOutStripped.get(i);
            if(isInEnum(unitIn,unitOut,Mass.class) == true) {
                dimensionFlag = true;
            } else if(isInEnum(unitIn,unitOut, Panjang.class) == true) {
                dimensionFlag = true;
            } else if(isInEnum(unitIn,unitOut,Time.class) == true) {
                dimensionFlag = true;
            } else {
                dimensionFlag = false;
            }

        }
        setChanged();
        notifyObservers(dimensionFlag);
    }

    public <E extends Enum<E>> boolean isInEnum(String value1,String unitOut, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if(e.name().equals(value1) && e.name().equals(unitOut)) { return true; }
        }
        return false;
    }


    private void powerExtractor() {
        //assume Panjang the same
        if(listIn.size() != listOut.size()) {
            lengthFlag = false;


        } else {
            lengthFlag = true;
            int len = listIn.size();
            for(int i=0;i<len;i++) {
                powerIn.add(powerCheck(listIn.get(i)));
                powerOut.add(powerCheck(listOut.get(i)));
                //potential multi threading for speed
                unitInStripped.add(powerStripper(listIn.get(i)));
                unitOutStripped.add(powerStripper(listOut.get(i)));

            }
        }

    }

    private Integer powerCheck(String unitToCheck) {
        if(unitToCheck.contains("^") == false) {
                return 1;
        }else {
            return Integer.parseInt(unitToCheck.substring(unitToCheck.lastIndexOf('^') +1));
        }
    }
    private String powerStripper(String unitTocheck) {
        if(unitTocheck.contains("^") == false) {
            return unitTocheck;
        } else {
            return unitTocheck.substring(0,unitTocheck.lastIndexOf('^'));
        }
    }


    public boolean isLengthFlag() {
        return lengthFlag;
    }

    public boolean isDimensionFlag() {
        return dimensionFlag;
    }
}
