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

 
import javafx.concurrent.Task;

public class TherapistTask  extends Task<String> {

   public String dialogue;
   public String result = "";

   public TherapistTask(String message) {
      dialogue = message;
   }

   @Override
   protected String call() throws Exception {
      //updateMessage("    Processing... ");
      
      result = voitheia.Therapist.interactive(dialogue); 
      dialogue = result;
      //updateMessage("    Done.  ");
      return dialogue;
    }
   
   public void setDialogue(String newX) {
   	dialogue = newX;
   }
}
