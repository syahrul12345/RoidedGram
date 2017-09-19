package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitParser {
    private String unitIn;
    private String unitOut;
    private UnitScript unitScript;

    public void accept(String unitIn, String unitOut) {

        this.unitIn = unitIn;
        this.unitOut = unitOut;
        unitScript = new UnitScript();
        parse();
    }

    public void parse() {
        Pattern regex = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = regex.matcher(unitIn);
          while(matcher.find()) {
             unitScript.addIn(matcher.group(1));
          }

        Pattern regex2 = Pattern.compile("\\((.*?)\\)");
        Matcher matcher2 = regex2.matcher(unitOut);
            while(matcher2.find()) {
                unitScript.addOut(matcher2.group(1));
             }


    }

}

