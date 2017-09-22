package model;

import model.enumerations.Mass;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

public class DimensionalAnalyzer {
    private ArrayList<String> listIn;
    private ArrayList<String> listOut;
    private ArrayList<Integer> powerIn = new ArrayList<Integer>();
    private ArrayList<Integer> powerOut = new ArrayList<Integer>();
    private ArrayList<String> unitInStripped = new ArrayList<String>();
    private ArrayList<String> unitOutStripped = new ArrayList<String>();
    private boolean lengthFlag = false; //false means that the length is wrong
    private boolean dimensionFlag; //false means that the dimension is wrong
    private ArrayList<Class<?>> enumList = new ArrayList<Class<?>>();
    private Class<Mass> mass;
    private Class<Length> length;

    public void add(ArrayList<String> listIn, ArrayList<String> listOut) {
        this.listIn = listIn;
        this.listOut = listOut;
        powerIn.clear();
        powerOut.clear();
        powerExtractor();
        if(lengthFlag != false) {
            analyzer();
        }
        //we add the Class<Enum> into enumlist
        enumList.add(mass);
        enumList.add(length);

    }

    private void analyzer() {
        int len = listIn.size();
        int enumListlen = enumList.size();
        for(int i=0;i<len;i++) {
            String unitIn = listIn.get(i);
            String unitOut = listOut.get(i);
            for(int j =0;i<enumListlen;j++) {
                Class<E> obtained = enumList.get(j);
                if(isInEnum(unitIn,unitOut,obtained) != true) {
                    dimensionFlag = false;
                    break;
                } else {
                    dimensionFlag = true;
                }
            }


        }
    }

    public <E extends Enum<E>> boolean isInEnum(String value1,String value2, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if(e.name().equals(value1) && e.name().equals(value2)) { return true; }
        }
        return false;
    }


    private void powerExtractor() {
        //assume length the same
        if(listIn.size() != listOut.size()) {
            lengthFlag = false;

        } else {
            lengthFlag = true;
            int len = listIn.size();
            for(int i=0;i<len;i++) {
                powerIn.add(powerCheck(listIn.get(i)));
                powerOut.add(powerCheck(listOut.get(i)));

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


    public boolean isLengthFlag() {
        return lengthFlag;
    }

    public boolean isDimensionFlag() {
        return dimensionFlag;
    }
}
