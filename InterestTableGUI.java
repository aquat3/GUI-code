package labprok;
import javafx.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*; 
 

 
public class InterestTableGUI extends Application{

	double principal;
		double rate;
		 double year;
		
	public InterestTableGUI(){
	
	}
	public void start(Stage primaryStage) {	 
	
	     GridPane gridpane = new GridPane();

	
		int sceneWidth = 600, sceneHeight = 500;
		int verSpaceBetweenNodes = 8, horSpaceBetweenNodes = 8;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;
		
	 
		FlowPane fieldsPane = new FlowPane();
		fieldsPane.setHgap(horSpaceBetweenNodes);
		fieldsPane.setVgap(verSpaceBetweenNodes);
		fieldsPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
 		Label pLabel = new Label("Principal: ");
		TextField principal = new TextField();
		fieldsPane.getChildren().addAll(pLabel, principal);
		
		Label costPerCreditLabel = new Label("Rate: ");
		TextField costPerCredit = new TextField();
		fieldsPane.getChildren().addAll(costPerCreditLabel, costPerCredit);
 
		
		Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(25);
		slider.setValue(40);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
	 
		 slider.setMajorTickUnit(5);
	        slider.setMinorTickCount(0);		
		
 		slider.setMinorTickCount(5);
		slider.setBlockIncrement(10);
		Label years = new Label("Number of Years: ");
		fieldsPane.getChildren().addAll(years,slider);
		
	
		
		// adding labels to the borderpane
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(fieldsPane);
		Button button = new Button("Simple Interest");
		borderPane.setLeft(button);
		
	
 		borderPane.setTop(fieldsPane);
		Button button2 = new Button("Compound Interest");
		borderPane.setCenter(button2);
		
 		borderPane.setTop(fieldsPane);
		Button button3 = new Button("Simple and Compound Interest");
		borderPane.setRight(button3);
		
		TextArea textArea = new TextArea();
 		ScrollPane scrollPane = new ScrollPane(textArea);
		 
		fieldsPane.getChildren().addAll(scrollPane);//
		//slider actionevent
		
		slider.valueProperty().addListener((observable, oldValue, newValue) -> {

			year= (double) newValue;
 

        });// lambda
		//calculators simple interest
		
		/*
		 * 
		 * simple interest amount = principal + (principal * (rate/100) * years)

 
Compound Interest Amount = principal * (1 + rate/100)^Years 
		 * 
		 * 
		 */
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String s="";
				double principal2 = Double.parseDouble(principal.getText());
				double rate = Double.parseDouble(costPerCredit.getText());
				s+="Simple Interest \n";

				s+= "Principal: "+principal2+" Rate: "+rate;
 				for(int i=1;i<=year;i++) {
					s+="\n"+i+": $"+(principal2+(principal2*(rate/100)*i))+"0";
					
				}
				textArea.setText(s);
			}
		});// anon class
		
		//calculators compound interest
 
		button2.setOnAction(e -> {		
						String s="";
						double principal2 = Double.parseDouble(principal.getText());
						double rate = Double.parseDouble(costPerCredit.getText());
						s+="Compound Interest \n";

						s+= "Principal: "+principal2+" Rate: "+rate;
						for(int i=1;i<=year;i++) {
							String f=""; 
							f=f.format("%.2f", ((principal2*Math.pow((1+rate/100),i ))) );
							s+="\n"+i+": $"+f; 
						
							
						}
						textArea.setText(s);
						
					});// lambda
				
		
				//calculators bboth interest
				button3.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						String s="";
						double principal2 = Double.parseDouble(principal.getText());
						double rate = Double.parseDouble(costPerCredit.getText());
						s+="Simple Interest --> Compound Interest \n";
						s+= "Principal: "+principal2+" Rate: "+rate;
						 
						for(int i=1;i<=year;i++) {
							String f=""; 
							f=f.format("%.2f", ((principal2*Math.pow((1+rate/100),i ))) );
							s+="\n"+i+": $"+(principal2+(principal2*(rate/100)*i))+"0";
							s+="--> $"+ f; 
							
						}
						textArea.setText(s);
						
				 
					}
				});
		
			     GridPane g= new GridPane();
				 g.add(button, 0, 0);
				 g.add(button2, 1, 0);
				 g.add(button3, 2, 0);
			     
			     gridpane.add(fieldsPane, 1, 0); // column=1 row=0
				 gridpane.add(g, 1, 1); // column=1 row=0
				  
					
				 BorderPane b = new BorderPane();//
					b.setTop(fieldsPane);//
					b.setCenter(g);//

				 
	 
		 
				 Scene scene = new Scene(b, sceneWidth, sceneHeight);//gridpane
				 primaryStage.setTitle("Payment Computation");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

public static void main(String[] args) {
 
	Application.launch(args);
}	

public class Inner{
	
	public void button3() {
		
		 
		
	}
	
}

}
