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
import java.util.ArrayList;


public class Question {
            static int random = (int)(Math.random() * 50);
	    static ArrayList<String> questionTag = init();
            static String x = "";
	    static int currentIndex = 0;
	    static int ptsdMarker = 0;
	    static int ocdMarker = 0;
	    static int depressionMarker = 0;
	    static int anxietyMarker = 0;

	    public static void indexer(String answer) {
	    	if (currentIndex > 0 && currentIndex < 2 && answer == "YES") {
	    		depressionMarker++;
	    	}

	    	if (currentIndex >= 6 && !(currentIndex > 8) && answer == "YES") {
	    		ocdMarker++;
	    	}

	    	if (currentIndex >= 10 && !(currentIndex > 11) && answer == "YES") {
	    		ptsdMarker++;
	    	}

	    	if (answer == "YES") {
	    		currentIndex++;
	    	}
	    	

	    	else if (answer == "NO"){
	    		if (currentIndex == 2 && depressionMarker == 0) {
	    			currentIndex += 3;
	    		}
	    		if (currentIndex == 7 && ocdMarker == 0) {
	    			currentIndex += 2;
	    		}
	    		if (currentIndex == 11 && ptsdMarker == 0) {
	    			currentIndex += 3;
	    		}
	    		else{
                                currentIndex++;
	    		}
	    	}

	    }

	    public static String questionaire(String answer) {
	    	indexer(answer);
	   	return (questionTag.get(currentIndex));
	    }

	    public static void main(String[] args) {
	    	java.util.Scanner input = new java.util.Scanner(System.in);
	    	while (currentIndex < questionTag.size() - 1) {
	    	    if (input.nextInt() == 1)
	    	       System.out.println(questionaire("YES"));
	    	    else
	    	       System.out.println(questionaire("NO"));
	    	}
	    }
	    
	    public static ArrayList<String> init() {
	    	ArrayList<String> questionTag = new ArrayList<>();
                    questionTag.add("");
		    if (random < 10) questionTag.add("a");
                    if (random >= 10 && random <= 20)questionTag.add("b");
                    if (random >= 20 && random <= 30)questionTag.add("c");
                    if (random >= 30 && random <= 40)questionTag.add("d");
                    if (random >= 40 && random <= 50)questionTag.add("e");
                    
                //Depression
                    questionTag.add("Have you lost interest or pleasure in hobbies and activities that used to be enjoyable to you?");
	 	    questionTag.add("Do you find yourself to be persistently sad, anxious,  having a feeling of hopelessness or pessimistic thoughts?");
	 	    questionTag.add("Has there been any change in your eating habit, loss or gain of appetite/ weight?");
	 	    questionTag.add("Are you constantly fatigued?");
      		    questionTag.add("Do you get frequent suicidal thoughts or actually attempted committing suicide?");
	    
	    	//ocd
	    	    questionTag.add("Do you have a fear of accumulating dirt?");
	    	    questionTag.add("Do you have a constant need to have things arranged in order and symmetry?");
	    	    questionTag.add("Do you find yourself repeatedly washing your hands? ");
	    	    questionTag.add("Do you have an excessive need to constantly organise?");
	    	
	    	//PTSD
	    	    questionTag.add("Do you get intrusive thoughts such as repeated, involuntary memories; distressing dreams; or flashbacks of the traumatic event?");
	    	    questionTag.add("Do you find yourself avoiding reminders of the traumatic event such avoiding people, places, activities, objects and situations that bring on distressing memories?");
	    	    questionTag.add("Do you have Negative thoughts and feelings such as ongoing and distorted beliefs about yourself or others (e.g.); ongoing fear, horror, anger, guilt or shame; much less interest in activities previously enjoyed; or feeling detached or estranged from others?");
	    	    questionTag.add("Do you get any arousal and reactive symptoms such being irritable and having angry outbursts; behaving recklessly or in a self-destructive way; being easily startled; or having problems concentrating or sleeping?");
	    
		//Anxiety
	    	    questionTag.add("Do you find yourself worrying excessively?");
	    	    questionTag.add("Is your level concentrations impaired?");
	    	    questionTag.add("Do you get any arousal and reactive symptoms such being irritable and having angry outbursts; behaving recklessly or in a self-destructive way; being easily startled; or having problems concentrating or sleeping?");
	    	    questionTag.add("Do you experience any phobias (like a fear of social interaction)?");
	    	    questionTag.add("Do you get panic attacks?");
	    	    questionTag.add("Has there been a change in sleeping habit (increase or decrease) or a lack of it?");
	    	    questionTag.add("Do you have feelings of guilt, worthlessness or helplessness?")	;
			
		return questionTag;
	    }
	    
}
