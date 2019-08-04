/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voitheia;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import static voitheia.Question.currentIndex;
import static voitheia.Question.questionTag;
import static voitheia.Question.questionaire;
import voitheia.Therapist;


/**
 *
 * @author the.devils.advocate
 */
public class FXMLDocumentController implements Initializable {
    private int count = 0;
    @FXML
    private Label questionLbl;
    @FXML
    private Label genderLabel;
    @FXML
    private Button preteenButton;
    @FXML
    private Button teenishButton;
    @FXML
    private Button agedButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    @FXML
    private Button aboutButton;
    @FXML
    private Button minimizebtn;
    @FXML
    private Button closebtn;
    @FXML
    private Button therapistButton;
    @FXML
    private Button diagnosisButton;
    @FXML
    private Button showTreatmentButton;
    @FXML
    private Button speakToTheRapistButton;
    @FXML
    private Button femaleGenderButton;
    @FXML
    private Button maleGenderButton;
    @FXML
    private Button proceedButton;
    @FXML
    private Button maleYesTeenAgedAlchohoButton;
    @FXML
    private Button maleNoTeenAgedButtonAlchohol;
    @FXML
    private Button maleNoPreteenButton;
    @FXML
    private Button maleYesPreteenButton;
    @FXML
    private AnchorPane diagnosisPane;
    @FXML
    private AnchorPane therapistPane;
    @FXML
    private AnchorPane aboutPane;    
    @FXML
    private AnchorPane treatmentPane;
    @FXML
    private AnchorPane firstDiagPane;
    @FXML
    private AnchorPane maleDiagPane;
    @FXML
    private AnchorPane femaleDiagPane;
    @FXML
    private TitledPane ocdTitledPane;
    @FXML
    private TitledPane depressionTitledPane;
    @FXML
    private TitledPane ptsdTitledPane;
    @FXML
    private TitledPane anxietyTitledPane;
    @FXML
    private TextArea therapistTextArea = new TextArea();
    @FXML
    private TextField therapistTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label malePreteenLabel;
    @FXML
    private Label maleTeenAgedAlchoholLabel;
    @FXML
    private Button therapistSendButton;
    @FXML
    private Button maleNoTeenAgedButtonMedication;
    @FXML
    private Label maleTeenAgedMedicationLabel;
    @FXML
    private Button maleYesTeenAgedMedicationButton;
    
    String ailment = "";
    
    //private final static String message_text_style="-fx-border-width: 5px;-fx-border-radius: 10px;-fx-border-style: solid;-fx-border-color: #ff7f7f;";
    
    private String ogText = "";
    
    public TherapistTask therapistTask;
    
    public boolean visibility = true;
    
    public ArrayList<Integer> sym = new ArrayList<>();
    
    public String diagn = "";
    
    PatientBio patientZero = new PatientBio();
    @FXML
    private Label maleTeenAgedPDLabel;
    @FXML
    private Button maleYesTeenAgedPDButton;
    @FXML
    private Button maleNoTeenAgedPDButton;
    @FXML
    private Label maleTeenAgedMHLabel;
    @FXML
    private Button maleYesTeenAgedMHButton;
    @FXML
    private Button maleNoTeenAgedMHButton;
    @FXML
    private Label maleTeenAgedHDLabel;
    @FXML
    private Button maleYesTeenAgedHDButton;
    @FXML
    private Button maleNoTeenAgedHDButton;
    @FXML
    private Label fAgeLabel;
    @FXML
    private Button fPreteenButton;
    @FXML
    private Button fTeenishButton;
    @FXML
    private Button fAgedButton;
    @FXML
    private Label femalePreteenLabel1;
    @FXML
    private Button femaleYesPreteenButton1;
    @FXML
    private Button femaleNoPreteenButton1;
    @FXML
    private Label femalePreteenLabel2;
    @FXML
    private Button femaleYesPreteenButton2;
    @FXML
    private Button femaleNoPreteenButton2;
    @FXML
    private Label femaleteenAgedLabel1;
    @FXML
    private Button femaleYesTeenAgedButton1;
    @FXML
    private Button femaleNoTeenAgedButton1;
    @FXML
    private Label femaleteenAgedLabel2;
    @FXML
    private Button femaleYesTeenAgedButton2;
    @FXML
    private Button femaleNoTeenAgedButton2;
    @FXML
    private Label femaleteenAgedLabel3;
    @FXML
    private Button femaleYesTeenAgedButton3;
    @FXML
    private Button femaleNoTeenAgedButton3;
    @FXML
    private Button femaleNoTeenAgedButton4;
    @FXML
    private Button femaleYesTeenAgedButton4;
    @FXML
    private Label femaleteenAgedLabel4;
    @FXML
    private Label femaleteenAgedLabel5;
    @FXML
    private Button femaleYesTeenAgedButton5;
    @FXML
    private Button femaleNoTeenAgedButton5;
    @FXML
    private Label femaleteenAgedLabel6;
    @FXML
    private Button femaleYesTeenAgedButton6;
    @FXML
    private Button femaleNoTeenAgedButton6;
    
    int dynamicDepression = 0;
    int dynamicOCD = 0;
    int dynamicPTSD = 0;
    
   
    

    @FXML
    private void therapistAction(ActionEvent event) {
        ogText = therapistTextField.getText();
        therapistTask = new TherapistTask(ogText);
        therapistTask.setOnSucceeded((succeededEvent) -> {
            therapistTextArea.appendText("Patient:   " + ogText + "\n");
            therapistTextArea.appendText(("Therapist:   " + therapistTask.getValue() + "\n"));
            //System.out.println(therapistTask.getValue());
            // btnStart.setDisable(false);
          });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
          executorService.execute(therapistTask);
          executorService.shutdown();
    }
    
    /**
    Method is charged with getting events triggered by pressing the Yes/ No button in the diagnosis pane and displaying the result on screen.
    **/
    @FXML
    private void handleButtonAction(ActionEvent event) {
       if (event.getSource() == yesButton) {
	    	questionLbl.setText((questionaire("YES")));
                sym.add(currentIndex - 1);
                System.out.println((currentIndex));
                //System.out.println((sym.get(0)));
                if (currentIndex == 20) {
                    
                    disBut();
                    sym.add(currentIndex);
                    showTreatmentButton.setVisible(true);
                    speakToTheRapistButton.setVisible(true);
                    diagn = Diagnosis.initialize(sym);
                    questionLbl.setText((diagn));
                    //ailment = diagn;
                }
           
           
           //displayPrompt();
           //sym.add(count);
            
           
            
          /* if (count == 19){
               disBut();
               sym.add(19);
               showTreatmentButton.setVisible(true);
               speakToTheRapistButton.setVisible(true);
               //System.out.println(sym);
               diagn = Diagnosis.initialize(sym);
               questionLbl.setText((diagn));
               ailment = diagn;
               //showTreatment(diagn);
           }
           */
       }
       else if (event.getSource() == noButton) {
           //displayPrompt();
           
           questionLbl.setText((questionaire("NO")));
           
           
           if (currentIndex == 20){
               disBut();
               speakToTheRapistButton.setVisible(true);
               showTreatmentButton.setVisible(true);
               diagn = Diagnosis.initialize(sym);
               ailment = diagn;
               questionLbl.setText((diagn));
           }
       }
       
                  
    }
    
    @FXML
    private void dynamicDiag(ActionEvent event) {
       if (event.getSource() == proceedButton) {
           patientZero.setName(nameTextField.getText());
           nameLabel.setVisible(false);
           nameTextField.setVisible(false);
           proceedButton.setVisible(false);
           genderLabel.setVisible(true);
           maleGenderButton.setVisible(true);
           femaleGenderButton.setVisible(true);
           System.out.println(patientZero.getName());
       }
       if (event.getSource() == maleGenderButton) {
           patientZero.setGender("Male");
           genderLabel.setVisible(false);
           maleGenderButton.setVisible(false);
           femaleGenderButton.setVisible(false);
           ageLabel.setVisible(true);
           preteenButton.setVisible(true);
           teenishButton.setVisible(true);
           agedButton.setVisible(true);
           
       }
       if (event.getSource() == preteenButton && patientZero.getGender() == "Male") {
           ageLabel.setVisible(false);
           preteenButton.setVisible(false);
           teenishButton.setVisible(false);
           agedButton.setVisible(false);
           malePreteenLabel.setVisible(true);
           maleYesPreteenButton.setVisible(true);
           maleNoPreteenButton.setVisible(true);
       }
       if (event.getSource() == maleYesPreteenButton || event.getSource() == maleNoPreteenButton ) {
           malePreteenLabel.setVisible(false);
           maleYesPreteenButton.setVisible(false);
           maleNoPreteenButton.setVisible(false);
           //SHOW KIDS SYMPTOMS
       }
       if ((event.getSource() == teenishButton || event.getSource() == agedButton)) {
           ageLabel.setVisible(false);
           preteenButton.setVisible(false);
           teenishButton.setVisible(false);
           agedButton.setVisible(false);
           maleTeenAgedAlchoholLabel.setVisible(true);
           maleYesTeenAgedAlchohoButton.setVisible(true);
           maleNoTeenAgedButtonAlchohol.setVisible(true);
       }
       if (event.getSource() == maleYesTeenAgedAlchohoButton || event.getSource() == maleNoTeenAgedButtonAlchohol) {
           maleTeenAgedAlchoholLabel.setVisible(false);
           maleYesTeenAgedAlchohoButton.setVisible(false);
           maleNoTeenAgedButtonAlchohol.setVisible(false);
           maleTeenAgedMedicationLabel.setVisible(true);
           maleYesTeenAgedMedicationButton.setVisible(true);
           maleNoTeenAgedButtonMedication.setVisible(true);
       }
       if (event.getSource() == maleYesTeenAgedMedicationButton) {
           maleTeenAgedMedicationLabel.setVisible(false);
           maleYesTeenAgedMedicationButton.setVisible(false);
           maleNoTeenAgedButtonMedication.setVisible(false);
           maleTeenAgedPDLabel.setVisible(true);
           maleYesTeenAgedPDButton.setVisible(true);
           maleNoTeenAgedPDButton.setVisible(true);
       }
       if (event.getSource() == maleYesTeenAgedPDButton || event.getSource() == maleNoTeenAgedPDButton || event.getSource() == maleYesTeenAgedMHButton || event.getSource() == maleYesTeenAgedHDButton || event.getSource() == maleNoTeenAgedHDButton) {
            maleTeenAgedPDLabel.setVisible(false);
            maleYesTeenAgedPDButton.setVisible(false);
            maleNoTeenAgedPDButton.setVisible(false);
            maleTeenAgedHDLabel.setVisible(false);
            maleYesTeenAgedHDButton.setVisible(false);
            maleNoTeenAgedHDButton.setVisible(false);
            maleTeenAgedMHLabel.setVisible(false);
            maleYesTeenAgedMHButton.setVisible(false);
            maleNoTeenAgedMHButton.setVisible(false);
            //SHOW TEENAGED SYMPTOMS
            therapistPane.setVisible(false);
            diagnosisPane.setVisible(true);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
       }
       if (event.getSource() == maleNoTeenAgedButtonMedication) {
           maleTeenAgedMedicationLabel.setVisible(false);
           maleYesTeenAgedMedicationButton.setVisible(false);
           maleNoTeenAgedButtonMedication.setVisible(false);
           maleTeenAgedPDLabel.setVisible(false);
           maleYesTeenAgedPDButton.setVisible(false);
           maleNoTeenAgedPDButton.setVisible(false);
           maleTeenAgedMHLabel.setVisible(true);
           maleYesTeenAgedMHButton.setVisible(true);
           maleNoTeenAgedMHButton.setVisible(true);
       }
       if (event.getSource() == maleNoTeenAgedMHButton) {
           maleTeenAgedMHLabel.setVisible(false);
           maleYesTeenAgedMHButton.setVisible(false);
           maleNoTeenAgedMHButton.setVisible(false);
           maleTeenAgedHDLabel.setVisible(true);
           maleYesTeenAgedHDButton.setVisible(true);
           maleNoTeenAgedHDButton.setVisible(true);
       }
       }
    /**
    Method is charged with getting events triggered by pressing the buttons in the top pane and displaying the appropriate functions associated with each.
    **/
    
    @FXML
    private void FemaleDynamicDiag(ActionEvent event) {
        if (event.getSource() == femaleGenderButton) {
           firstDiagPane.setVisible(false);
           femaleDiagPane.setVisible(true);
           patientZero.setGender("Female");
           //genderLabel.setVisible(false);
           //maleGenderButton.setVisible(false);
           //femaleGenderButton.setVisible(false);
           fAgeLabel.setVisible(true);
           fPreteenButton.setVisible(true);
           fTeenishButton.setVisible(true);
           fAgedButton.setVisible(true); 
       }
       if (event.getSource() == fPreteenButton) {
           fAgeLabel.setVisible(false);
           fPreteenButton.setVisible(false);
           fTeenishButton.setVisible(false);
           fAgedButton.setVisible(false);
           femalePreteenLabel1.setVisible(true);
           femaleYesPreteenButton1.setVisible(true);
           femaleNoPreteenButton1.setVisible(true);
       }
       if (event.getSource() == femaleYesPreteenButton1) {
           femalePreteenLabel1.setVisible(false);
           femaleYesPreteenButton1.setVisible(false);
           femaleNoPreteenButton1.setVisible(false);
           //Show FEMALE SYMPTOMS
       }
       if (event.getSource() == femaleNoPreteenButton1) {
           femalePreteenLabel1.setVisible(false);
           femaleYesPreteenButton1.setVisible(false);
           femaleNoPreteenButton1.setVisible(false);
           femalePreteenLabel2.setVisible(true);
           femaleYesPreteenButton2.setVisible(true);
           femaleNoPreteenButton2.setVisible(true);
       }
       if (event.getSource() == femaleYesPreteenButton2 || event.getSource() == femaleNoPreteenButton2 ) {
           femalePreteenLabel2.setVisible(false);
           femaleYesPreteenButton2.setVisible(false);
           femaleNoPreteenButton2.setVisible(false);
           //SHOW SYMPTOMS?
           therapistPane.setVisible(false);
            diagnosisPane.setVisible(true);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
       }
       if (event.getSource() == fTeenishButton || event.getSource() == fAgedButton) {
           fAgeLabel.setVisible(false);
           fPreteenButton.setVisible(false);
           fTeenishButton.setVisible(false);
           fAgedButton.setVisible(false);
           femaleteenAgedLabel1.setVisible(true);
           femaleYesTeenAgedButton1.setVisible(true);
           femaleNoTeenAgedButton1.setVisible(true);
       }
       if (event.getSource() == femaleYesTeenAgedButton1 || event.getSource() == femaleNoTeenAgedButton1 ) {
           femaleteenAgedLabel1.setVisible(false);
           femaleYesTeenAgedButton1.setVisible(false);
           femaleNoTeenAgedButton1.setVisible(false);
           femaleteenAgedLabel2.setVisible(true);
           femaleYesTeenAgedButton2.setVisible(true);
           femaleNoTeenAgedButton2.setVisible(true);
       }
       if (event.getSource() == femaleNoTeenAgedButton2) {
           //alchohol
           femaleteenAgedLabel2.setVisible(false);
           femaleYesTeenAgedButton2.setVisible(false);
           femaleNoTeenAgedButton2.setVisible(false);
           femaleteenAgedLabel3.setVisible(true);
           femaleYesTeenAgedButton3.setVisible(true);
           femaleNoTeenAgedButton3.setVisible(true);
       }
       if (event.getSource() == femaleNoTeenAgedButton3 || event.getSource() == femaleYesTeenAgedButton3) {
           femaleteenAgedLabel3.setVisible(false);
           femaleYesTeenAgedButton3.setVisible(false);
           femaleNoTeenAgedButton3.setVisible(false);
           femaleteenAgedLabel4.setVisible(true);
           femaleYesTeenAgedButton4.setVisible(true);
           femaleNoTeenAgedButton4.setVisible(true);
       }
       if (event.getSource() == femaleNoTeenAgedButton4 || event.getSource() == femaleYesTeenAgedButton4 || event.getSource() == femaleNoTeenAgedButton5 ) {
           femaleteenAgedLabel4.setVisible(false);
           femaleYesTeenAgedButton4.setVisible(false);
           femaleNoTeenAgedButton4.setVisible(false);
           femaleteenAgedLabel5.setVisible(false);
           femaleYesTeenAgedButton5.setVisible(false);
           femaleNoTeenAgedButton5.setVisible(false);
           //SHOW SYMPTOMS
           therapistPane.setVisible(false);
            diagnosisPane.setVisible(true);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
       }
       if (event.getSource() == femaleYesTeenAgedButton2) {
           //alchohol
           femaleteenAgedLabel2.setVisible(false);
           femaleYesTeenAgedButton2.setVisible(false);
           femaleNoTeenAgedButton2.setVisible(false);
           femaleteenAgedLabel5.setVisible(true);
           femaleYesTeenAgedButton5.setVisible(true);
           femaleNoTeenAgedButton5.setVisible(true);
       }
       if (event.getSource() == femaleYesTeenAgedButton5) {
           femaleteenAgedLabel5.setVisible(false);
           femaleYesTeenAgedButton5.setVisible(false);
           femaleNoTeenAgedButton5.setVisible(false);
           femaleteenAgedLabel6.setVisible(true);
           femaleYesTeenAgedButton6.setVisible(true);
           femaleNoTeenAgedButton6.setVisible(true);
       }
       if (event.getSource() == femaleYesTeenAgedButton6 || event.getSource() == femaleNoTeenAgedButton6) {
           femaleteenAgedLabel6.setVisible(false);
           femaleYesTeenAgedButton6.setVisible(false);
           femaleNoTeenAgedButton6.setVisible(false);
           //SHOWSYMPTOMS
            therapistPane.setVisible(false);
            diagnosisPane.setVisible(true);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
           
       }
       
        
        
    }
    
    @FXML
    private void minimizer(ActionEvent event) {
        if (event.getSource() == minimizebtn) {
                //System.exit(1);
                //anch.setVisible(false);
            if (visibility == true) {
               //therapist.setVisible(false);
               //about.setVisible(false);
               diagnosisPane.setVisible(false);
               therapistPane.setVisible(false);
               aboutPane.setVisible(false);
               visibility = false;
               treatmentPane.setVisible(false);
               firstDiagPane.setVisible(false);
               femaleDiagPane.setVisible(false);
           }
           else if (visibility == false) {
               diagnosisPane.setVisible(true);
               therapistPane.setVisible(true);
               aboutPane.setVisible(true);
               visibility = true;
               firstDiagPane.setVisible(true);
               femaleDiagPane.setVisible(true);
           }
        }
        if (event.getSource() == therapistButton || event.getSource() == speakToTheRapistButton) {
            therapistPane.setVisible(true);
            diagnosisPane.setVisible(false);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
        }else if (event.getSource() == diagnosisButton) {
            therapistPane.setVisible(false);
            diagnosisPane.setVisible(false);
            aboutPane.setVisible(false);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(true);
            femaleDiagPane.setVisible(false);
        }else if (event.getSource() == aboutButton) {
            therapistPane.setVisible(false);
            diagnosisPane.setVisible(false);
            aboutPane.setVisible(true);
            treatmentPane.setVisible(false);
            firstDiagPane.setVisible(false);
            femaleDiagPane.setVisible(false);
        }
        
        
    }


    
    /**
    Method closes app, when registered button is clicked.
    **/
    @FXML
    private void close(ActionEvent event) {
        System.exit(1);
    }

    /**
    Method is charged with showing treatment for illness gotten from the handleActionButton() method.
    **/
    @FXML  
    private void showTreatment() {
        if (ailment.equals("Clinical Depression")) {
            treatmentPane.setVisible(true);
            ocdTitledPane.setVisible(false);
            depressionTitledPane.setVisible(true);
            ptsdTitledPane.setVisible(false);
            anxietyTitledPane.setVisible(false);
            diagnosisPane.setVisible(false);
            therapistPane.setVisible(false);
            aboutPane.setVisible(false);
            visibility = false;
        }
        else if (ailment.equals("Post Traumatic Stress Disorder (PTSD)")) {
            treatmentPane.setVisible(true);
            ocdTitledPane.setVisible(false);
            depressionTitledPane.setVisible(false);
            ptsdTitledPane.setVisible(true);
            anxietyTitledPane.setVisible(false);
            diagnosisPane.setVisible(false);
            therapistPane.setVisible(false);
            aboutPane.setVisible(false);
            visibility = false;
        }
        else if (ailment.equals("Obssesive Compulsive Disorder (OCD)")) {
            treatmentPane.setVisible(true);
            ocdTitledPane.setVisible(true);
            depressionTitledPane.setVisible(false);
            ptsdTitledPane.setVisible(false);
            anxietyTitledPane.setVisible(false);
            diagnosisPane.setVisible(false);
            therapistPane.setVisible(false);
            aboutPane.setVisible(false);
            visibility = false;
        }        
        else if (ailment.equals("Psychological Anxiety")) {
            treatmentPane.setVisible(true);
            ocdTitledPane.setVisible(false);
            depressionTitledPane.setVisible(false);
            ptsdTitledPane.setVisible(false);
            anxietyTitledPane.setVisible(true);
            diagnosisPane.setVisible(false);
            therapistPane.setVisible(false);
            aboutPane.setVisible(false);
            visibility = false;
        }
        else;
         
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
    Method disables button.
    **/
    public void disBut(){
        yesButton.setVisible(false);        
        noButton.setVisible(false);
    }

    
}
