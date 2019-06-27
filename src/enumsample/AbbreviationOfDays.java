package enumsample;

import java.util.ArrayList;

/**
 * Create By: Ron Rith
 * Create Date on: 6/27/19.
 */
public enum AbbreviationOfDays {
    SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"),
    THURSDAY("THURS"), FRIDAY("FRI"), SATURDAY("SAT");
    private String abbreviation;
    public String getAbbreviation() {
        return this.abbreviation;
    }
    AbbreviationOfDays(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
class EnumFields {
    public ArrayList<String> enumFields() {
        AbbreviationOfDays[] abbreviationOfDays = AbbreviationOfDays.values();
        ArrayList<String> daysList = new ArrayList<String>();
        for (AbbreviationOfDays day : abbreviationOfDays) {
            daysList.add(day.getAbbreviation().toString());
        }
        return daysList;
    }

    public static void main(String args[]){
        System.out.println("Friday Day: "+AbbreviationOfDays.FRIDAY.getAbbreviation());
    }
}
