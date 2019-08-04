/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voitheia;
/**
 *
 * @author the.devils.advocate
 */
import java.util.*;

public class Diagnosis {
public static double total = 0;	

    public static ArrayList<String> getAilmentName(ArrayList<Integer> numb) {
        ArrayList<String> ill = new ArrayList<>();
        ArrayList<String> illdb = initDB();
        for (int i = 0; i < illdb.size(); i++) {
            if (numb.contains(i)) {
                ill.add(illdb.get(i));
            }
        }
        return ill;
    }
	
    public static ArrayList<String> initDB() {
        ArrayList< String> symptomsdb = new ArrayList<>();
        
        symptomsdb.add("loss_interest");
      	symptomsdb.add("feeling_sad_pessimism");
      	symptomsdb.add("appetite_loss_gain");
        symptomsdb.add("fatigue");
        symptomsdb.add("suicidal_thoughts");
        symptomsdb.add("germophobia");
        symptomsdb.add("order_and_symmetry");
        symptomsdb.add("frequent_hand_washing");
        symptomsdb.add("execessive_need_to_organise");
        symptomsdb.add("intrusive_thoughts");
        symptomsdb.add("avoiding_reminders");
        symptomsdb.add("negative_thoughts");
        symptomsdb.add("reactive_symptoms");
        symptomsdb.add("excessive_worry");
        symptomsdb.add("concentration_issues");
        symptomsdb.add("reactive_symptoms");
        symptomsdb.add("phobia");
        symptomsdb.add("panic_attacks");
        symptomsdb.add("insomia");
        symptomsdb.add("feelings_of_guilt");
        
        return(symptomsdb);
	}

    public static ArrayList<Object> diagnoseForDepression(ArrayList<String> symptomsPresent) {
        ArrayList<Object> value = new ArrayList<>();
        double count = 0; // Number of symptoms matched
        ArrayList<String> list = new ArrayList<>(Arrays.asList("feeling_sad_pessimism", "feelings_of_guilt","loss_interest","concentration_issues","insomia","appetite_loss_gain","suicidal_thoughts")); //likely symptoms for depression
        for (int i = 0; i < symptomsPresent.size(); i++) {
            if (list.contains(symptomsPresent.get(i))) {
                    count++;
            }
        }
        double percentage = count/list.size(); 
        value.add("depression");
        value.add(new Double(percentage)); //returns the name of the ailment and a double value representing the likelyhood of this being the ailment.
        return value;
    }

    public static ArrayList<Object> diagnoseForPTSD(ArrayList<String> symptomsPresent) {
                ArrayList<Object> value = new ArrayList<>();
                double count = 0; // Number of symptoms matched
                ArrayList<String> list = new ArrayList<>(Arrays.asList("intrusive_thoughts","avoiding_reminders","negative_thoughts","reactive_symptoms"));
                for (int i = 0; i < symptomsPresent.size(); i++) {
                        if (list.contains(symptomsPresent.get(i))) {
                                count++;
                        }
                }
                double percentage = count/list.size();
                value.add("Post Traumatic Stress Disorder (PTSD)"); 
                value.add(new Double(percentage)); //returns the name of the ailment and a double value representing the likelyhood of this being the ailment.
                return value;
    }

    public static ArrayList<Object> diagnoseForOCD(ArrayList<String> symptomsPresent) {
                ArrayList<Object> value = new ArrayList<>();
                double count = 0; // Number of symptoms matched
                ArrayList<String> list = new ArrayList<>(Arrays.asList("germophobia","order_and_symmetry","frequent_hand_washing","execessive_need_to_organise"));
                for (int i = 0; i < symptomsPresent.size(); i++) {
                        if (list.contains(symptomsPresent.get(i))) {
                                count++;
                        }
                }
                double percentage = count/list.size();
                value.add("Obssesive Compulsive Disorder (OCD)"); 
                value.add(new Double(percentage)); //returns the name of the ailment and a double value representing the likelyhood of this being the ailment.
                return value;
    }        

    public static ArrayList<Object> diagnoseForAnxiety(ArrayList<String> symptomsPresent) {
                ArrayList<Object> value = new ArrayList<>();
                double count = 0; // Number of symptoms matched
                ArrayList<String> list = new ArrayList<>(Arrays.asList("excessive_worry", "fatigue","concentration_issues","irritable","insomia","panic_attacks","phobia"));
                for (int i = 0; i < symptomsPresent.size(); i++) {
                        if (list.contains(symptomsPresent.get(i))) {
                                count++;
                        }
                }
                double percentage = count/list.size();
                value.add("Psychological Anxiety"); 
                value.add(new Double(percentage)); //returns the name of the ailment and a double value representing the likelyhood of this being the ailment.
                return value;
    }
    
    public static String returnIndex(double[] myList) { 
        //Returns the name of mental health disorder from result gotten from calculations.
        double max = myList[0];
        int indexOfMax = 0;
        
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        if (total == 0)
            return "No match";
        
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
                indexOfMax = i;
            }
        }
        if (indexOfMax == 0) 
            return "Clinical Depression";
        if (indexOfMax == 1) 
            return "Post Traumatic Stress Disorder (PTSD)";
        if (indexOfMax == 2) 
            return "Obssesive Compulsive Disorder (OCD)";
        else
            return "Psychological Anxiety";

    }
    
    public static String initialize(ArrayList<Integer> clicks) {
        //Initializes the process
    	ArrayList<String> userSymptoms = getAilmentName(clicks);
    	ArrayList<Object> dpsn = diagnoseForDepression(userSymptoms);
    	ArrayList<Object> ptsd = diagnoseForPTSD(userSymptoms);
    	ArrayList<Object> ocd = diagnoseForOCD(userSymptoms);
    	ArrayList<Object> anx = diagnoseForAnxiety(userSymptoms);
    	
        double[] val = {((Number)dpsn.get(1)).doubleValue(), ((Number)ptsd.get(1)).doubleValue(), ((Number)ocd.get(1)).doubleValue(), ((Number)anx.get(1)).doubleValue()};
        String diag = returnIndex(val);

        return diag;

    	
    }
    
}
