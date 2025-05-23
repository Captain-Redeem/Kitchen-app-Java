//17003323
//Basic Addition Client
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Program extends Application
{
	private String remoteHost = "127.0.0.1";
	private int port = 9999;
	
	// declare low level and high level objects for input
	private InputStream inStream;
	private DataInputStream inDataStream;
	
	// declare low level and high level objects for output
	private OutputStream outStream ;
	private DataOutputStream outDataStream;
	
	// declare a socket
	private Socket connection;
	
	
	double total;

			
			
	@Override
	public void start(Stage stage)
	
	{
		final double WIDTH = 700;
		final double HEIGHT = 400;
		
		
		TextField txtConnection = new TextField();
		
		
		
		Label lblOrder = new Label();
		
		
		
		//labelling each group of menu and allergies box
		Label lblMain = new Label("Mains");
		Label lblSide = new Label("Sides");
		Label lblDrink = new Label("Drinks");
		Label lblAllergiesNote = new Label("Allergies");
		
		
		
		
		
		
		//Declaring prices for options
		//mains prices
		Double pepperoniPizzaPrice = 4.50;
		Double cheeseBurgerPrice = 2.50;
		Double gourmetBurgerPrice = 5.80;
		
		//Sides prices
		Double chipsPrice = 1.20;
		Double potatoWedgesPrice = 1.40;
		Double periPeriChipsPrice = 1.50;
		
		//Drinks prices
		Double waterPrice = 1.00;
		Double fantaPrice = 1.00;
		Double sevenUpPrice = 1.20;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Creating objects for the menu options
		//Pepperoni Pizza
		Label lblPepperoniPizza = new Label ("Pepperoni Pizza - £" + pepperoniPizzaPrice);
		Button btnAddPepperoniPizza = new Button("+");
		Label lblPepperoniPizzaQty = new Label("0");
		Button btnMinusPepperoniPizza = new Button("-");
		
		
		//Cheese burger
		Label lblCheeseBurger = new Label("Cheese Burger: £" + cheeseBurgerPrice);
		Button btnAddCheeseBurger = new Button("+");
		Label lblCheeseBurgerQty = new Label("0");
		Button btnMinusCheeseBurger = new Button("-");
		
		//Gourmet Burger
		Label lblGourmetBurger = new Label("Gourmet Burger: £" + gourmetBurgerPrice);
		Button btnAddGourmetBurger = new Button("+");
		Label lblGourmetBurgerQty = new Label("0");
		Button btnMinusGourmetBurger = new Button("-");
		
		//Chips
		Label lblChips = new Label("Chips - £" + chipsPrice);
		Button btnAddChips = new Button("+");
		Label lblChipsQty = new Label("0");
		Button btnMinusChips = new Button("-");
		
		//Potato Wedges
		Label lblPotatoWedges = new Label("Potato Wedges £" + potatoWedgesPrice);
		Button btnAddPotatoWedges = new Button("+");
		Label lblPotatoWedgesQty = new Label("0");
		Button btnMinusPotatoWedges = new Button("-");
		
		//Peri Peri Chips
		Label lblPeriPeriChips = new Label("Peri Peri Chips: £" + periPeriChipsPrice);
		Button btnMinusPeriPeriChips = new Button("-");
		Label lblPeriPeriChipsQty = new Label("0");
		Button btnAddPeriPeriChips = new Button ("+");
		
		//Water
		Label lblWater = new Label("Water (25 cl): £" + waterPrice);
		Button btnMinusWater = new Button("-");
		Label lblWaterQty = new Label("0");
		Button btnAddWater = new Button("+");
		
		//Fanta
		Label lblFanta = new Label("Fanta (can): £" + fantaPrice);
		Button btnMinusFanta = new Button("-");
		Label lblFantaQty = new Label("0");
		Button btnAddFanta = new Button("+");
		
		//Seven Up
		Label lblSevenUp = new Label("7 Up (can): £" + sevenUpPrice);
		Button btnMinusSevenUp = new Button("-");
		Label lblSevenUpQty = new Label("0");
		Button btnAddSevenUp = new Button("+");
		
		//CheckBoxes for allergies
		//West H et al (2022)
		CheckBox chkNuts = new CheckBox("Nuts");
		CheckBox chkMilk = new CheckBox("Milk");
		CheckBox chkEggs = new CheckBox("Eggs");
		CheckBox chkWheat = new CheckBox("Wheat");
		CheckBox chkSoy = new CheckBox("Soy");
		
		//Eating in checkbox
		CheckBox chkEatingIn = new CheckBox("Eating In");
		
		
		
		
		
		
		
		
		
		
		
		
		//functionality for pepperoniPizza option
		//adding a Pepperoni pizza
		btnAddPepperoniPizza.setOnAction(e ->
		{

			Integer Qty = Integer.parseInt(lblPepperoniPizzaQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				//
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			else
			{
				double pepperoniPizzaTotal = 0;
				
				pepperoniPizzaTotal = pepperoniPizzaTotal + pepperoniPizzaPrice;
				total = total + pepperoniPizzaTotal;
				lblPepperoniPizzaQty.setText(Qty.toString());
			}
			
		}
				);
				
		//removing a Pepperoni pizza
		btnMinusPepperoniPizza.setOnAction(e ->
		{
			
			double pepperoniPizzaTotal = 0;
			Integer Qty = Integer.parseInt(lblPepperoniPizzaQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				pepperoniPizzaTotal = pepperoniPizzaTotal - pepperoniPizzaPrice;
				total = total - pepperoniPizzaPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblPepperoniPizzaQty.setText(Qty.toString());
		}
				);
		
		
		
		
		
		//functionality for Cheese Burger
		//Adding a Cheese Burger
		btnAddCheeseBurger.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblCheeseBurgerQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			else
			{
				double cheeseBurgerTotal = 0;
				cheeseBurgerTotal = cheeseBurgerTotal + cheeseBurgerPrice;
				total = total + cheeseBurgerPrice;
				lblCheeseBurgerQty.setText(Qty.toString());
			}
		}
				);
		
		
		//removing a Cheese burger pizza
		btnMinusCheeseBurger.setOnAction(e ->
		{
			
			double cheeseBurgerTotal = 0;
			Integer Qty = Integer.parseInt(lblCheeseBurgerQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				cheeseBurgerTotal = cheeseBurgerTotal - cheeseBurgerPrice;
				total = total - cheeseBurgerPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblCheeseBurgerQty.setText(Qty.toString());
		}
				);
			
		
		
		//functionality for Gourmet burger
		btnAddGourmetBurger.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblGourmetBurgerQty.getText());
		
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			
			double gourmetBurgerTotal = 0;
			gourmetBurgerTotal = gourmetBurgerTotal + gourmetBurgerPrice;
			total = total + gourmetBurgerPrice;
			lblGourmetBurgerQty.setText(Qty.toString());
		}
				);
		
		//removing a Gourmet Burger
		btnMinusGourmetBurger.setOnAction(e ->
		{
					
			double gourmetBurgerTotal = 0;
			Integer Qty = Integer.parseInt(lblGourmetBurgerQty.getText());
					
			if(Qty >= 1)
			{
				Qty--;
				gourmetBurgerTotal = gourmetBurgerTotal - gourmetBurgerPrice;
				total = total - gourmetBurgerPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblGourmetBurgerQty.setText(Qty.toString());
		}
				);
				
		
		//functionality for chips portion
		//adding a chips
		btnAddChips.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblChipsQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			else
			{
				double chipsTotal = 0;
				chipsTotal = chipsTotal + chipsPrice;
				total = total + chipsPrice;
				lblChipsQty.setText(Qty.toString());
			}
		}
				);
		
		//removing a Chips portion
		btnMinusChips.setOnAction(e ->
		{
		
			double chipsTotal = 0;
			Integer Qty = Integer.parseInt(lblChipsQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				chipsTotal = chipsTotal - chipsPrice;
				total = total - chipsPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblChipsQty.setText(Qty.toString());
		}
				);
		
		//functionality
		//adding potato wedges
		btnAddPotatoWedges.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblPotatoWedgesQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			
			else
			{
				double potatoWedgesTotal = 0;
				potatoWedgesTotal = potatoWedgesTotal + potatoWedgesPrice;
				total = total + potatoWedgesPrice;
				lblPotatoWedgesQty.setText(Qty.toString());
			}
		}
				);
		
		
		//removing a Potato Wedges portion
		btnMinusPotatoWedges.setOnAction(e ->
		{
				
			double potatoWedgesTotal = 0;
			Integer Qty = Integer.parseInt(lblPotatoWedgesQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				potatoWedgesTotal = potatoWedgesTotal - potatoWedgesPrice;
				total = total - potatoWedgesPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblPotatoWedgesQty.setText(Qty.toString());
		}
				);
		
		
		
		//adding Peri Peri Chips
		btnAddPeriPeriChips.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblPeriPeriChipsQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			
			else
			{
				double periPeriChipsTotal = 0;
				periPeriChipsTotal = periPeriChipsTotal + periPeriChipsPrice;
				total = total + periPeriChipsPrice;
				lblPeriPeriChipsQty.setText(Qty.toString());
			}
		}
				);
						
						
		//removing a Chips portion
		btnMinusPeriPeriChips.setOnAction(e ->
		{
		
			double periPeriChipsTotal = 0;
			Integer Qty = Integer.parseInt(lblPeriPeriChipsQty.getText());
					
			if(Qty >= 1)
			{
				Qty--;
				periPeriChipsTotal = periPeriChipsTotal - periPeriChipsPrice;
				total = total - periPeriChipsPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblPeriPeriChipsQty.setText(Qty.toString());
		}
				);
	
		
		
		//adding Water
		btnAddWater.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblWaterQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			
			else
			{
				double waterTotal = 0;
				waterTotal = waterTotal + waterPrice;
				total = total + waterPrice;
				lblWaterQty.setText(Qty.toString());
			}
		}
				);
		
		
		//removing Water
		btnMinusWater.setOnAction(e ->
		{
		
			double waterTotal = 0;
			Integer Qty = Integer.parseInt(lblWaterQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				waterTotal = waterTotal - waterPrice;
				total = total - waterPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblWaterQty.setText(Qty.toString());
		}
				);		
		
		
		//adding Fanta
		btnAddFanta.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblFantaQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			
			else
			{
				double fantaTotal = 0;
				fantaTotal = fantaTotal + fantaPrice;
				total = total + fantaPrice;
				lblFantaQty.setText(Qty.toString());
			}
		}
				);
		
		
		//removing a Fanta
		btnMinusFanta.setOnAction(e ->
		{
			
			double fantaTotal = 0;
			Integer Qty = Integer.parseInt(lblFantaQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				fantaTotal = fantaTotal - fantaPrice;
				total = total - fantaPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblFantaQty.setText(Qty.toString());
		}
				);
		
		
		
		//Adding a seven Up
		btnAddSevenUp.setOnAction(e ->
		{
			Integer Qty = Integer.parseInt(lblSevenUpQty.getText());
			
			Qty++;
			
			if(Qty>=11)
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add more than 10 items!").showAndWait();
			}
			else
			{
				double sevenUpTotal = 0;
				sevenUpTotal = sevenUpTotal + sevenUpPrice;
				total = total + sevenUpPrice;
				lblSevenUpQty.setText(Qty.toString());
			}
		}
				);
				
		//removing a Seven Up
		btnMinusSevenUp.setOnAction(e ->
		{
		
			double sevenUpTotal = 0;
			Integer Qty = Integer.parseInt(lblSevenUpQty.getText());
			
			if(Qty >= 1)
			{
				Qty--;
				sevenUpTotal = sevenUpTotal - sevenUpPrice;
				total = total - sevenUpPrice;
			}
			else
			{
				new Alert(Alert.AlertType.ERROR, "Cannot add less than 0 Items!").showAndWait();
			}
			lblSevenUpQty.setText(Qty.toString());
		}
				);
		
		
		//place order button
		Button btnOrder = new Button("Place Order");
		
		
		
		
		
		
		
		TextField txtbxNotes = new TextField();
		
		Label lblNotes = new Label("Additional Notes: ");
		
		
		txtbxNotes.setMinHeight(50);
		
		
		
		
		
		
		
		
		//Visual designs
		//Making a grid for the objects to position
		GridPane gpMenu = new GridPane();
		
		//GridPane design
		gpMenu.setVgap(10);
		gpMenu.setHgap(10);
		
		//positioning pepperoni pizza components
		gpMenu.add(lblMain, 0, 0);
		gpMenu.add(lblPepperoniPizza, 0, 1);
		gpMenu.add(btnMinusPepperoniPizza, 1, 1);
		gpMenu.add(lblPepperoniPizzaQty, 2, 1);
		gpMenu.add(btnAddPepperoniPizza, 3, 1);
		
		//positioning cheese burger components
		gpMenu.add(lblCheeseBurger, 0, 2);
		gpMenu.add(btnMinusCheeseBurger, 1, 2);
		gpMenu.add(lblCheeseBurgerQty, 2, 2);
		gpMenu.add(btnAddCheeseBurger, 3, 2);
				
		//positioning the Gourmet burger objects
		gpMenu.add(lblGourmetBurger, 0, 3);
		gpMenu.add(btnMinusGourmetBurger, 1, 3);
		gpMenu.add(lblGourmetBurgerQty, 2, 3);
		gpMenu.add(btnAddGourmetBurger, 3, 3);
		
		
		
		
		//Side dishes
		//positioning the chips objects		
		gpMenu.add(lblSide, 4, 0);
		gpMenu.add(lblChips, 4, 1);
		gpMenu.add(btnMinusChips, 5, 1);
		gpMenu.add(lblChipsQty, 6, 1);
		gpMenu.add(btnAddChips, 7, 1);
		
		//positioning Potato Wedges
		gpMenu.add(lblPotatoWedges, 4,2);
		gpMenu.add(btnMinusPotatoWedges, 5, 2);
		gpMenu.add(lblPotatoWedgesQty, 6, 2);
		gpMenu.add(btnAddPotatoWedges, 7, 2);
		
		
		gpMenu.add(lblPeriPeriChips, 4, 3);
		gpMenu.add(btnMinusPeriPeriChips, 5, 3);
		gpMenu.add(lblPeriPeriChipsQty, 6, 3);
		gpMenu.add(btnAddPeriPeriChips, 7, 3);
				
		
		//positioning water components
		gpMenu.add(lblDrink, 9, 0);
		gpMenu.add(lblWater, 9, 1);
		gpMenu.add(btnMinusWater, 10, 1);
		gpMenu.add(lblWaterQty, 11, 1);
		gpMenu.add(btnAddWater, 12, 1);
		
		
		gpMenu.add(lblFanta, 9, 2);
		gpMenu.add(btnMinusFanta, 10, 2);
		gpMenu.add(lblFantaQty, 11, 2);
		gpMenu.add(btnAddFanta, 12, 2);		
		
		
		gpMenu.add(lblSevenUp, 9, 3);
		gpMenu.add(btnMinusSevenUp, 10, 3);
		gpMenu.add(lblSevenUpQty, 11, 3);
		gpMenu.add(btnAddSevenUp, 12, 3);

		
		//adding eat in checkbox to the GridPane
		gpMenu.add(chkEatingIn, 0, 5);
		
		//adding allergies to the gridpane
		gpMenu.add(lblAllergiesNote, 0, 6);
		gpMenu.add(chkNuts, 0, 7);
		gpMenu.add(chkMilk, 0, 8);
		gpMenu.add(chkEggs, 0, 9);
		gpMenu.add(chkWheat, 0, 10);
		gpMenu.add(chkSoy, 0, 11);
		
		
		

		

		gpMenu.add(btnOrder, 9, 10);
		gpMenu.add(lblOrder, 5, 7);
		gpMenu.add(txtbxNotes, 4, 8);
		gpMenu.add(lblNotes, 4, 7);
		
		
		
		txtConnection.setMaxWidth(150);
		gpMenu.add(txtConnection, 4, 6);
		
		
		
		//to round the total to two decimal places
		//Jai (2018)
		DecimalFormat df = new DecimalFormat("#0.00");
		
		
		VBox root = new VBox();
		
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setAlignment(Pos.TOP_LEFT);
		root.getChildren().addAll(gpMenu);
		
		// create the  scene
		Scene scene = new Scene(root, WIDTH, HEIGHT);

		// configure the stage
		stage.setScene(scene);
		stage.setTitle("Food Express Customer Screen");
		
		// show the stage
		stage.show();
		try
		{
			// attempt to create a connection to the server
			connection = new Socket(remoteHost, port);
			txtConnection.setText("Connection established");
			
			// create an input stream from the server
			inStream = connection.getInputStream();
			inDataStream = new DataInputStream(inStream);
			
			// create an output stream to the server
			outStream = connection.getOutputStream();
			outDataStream = new DataOutputStream(outStream);
			
			// send the host IP to the server
			outDataStream.writeUTF(connection.getLocalAddress().getHostAddress());
		}
		catch (UnknownHostException e)
		{
			txtConnection.setText("Unknown host");
		}
		catch (IOException ie)
		{
			txtConnection.setText("Network Exception");
		}
		
		// specify the behaviour of the calculate button
		btnOrder.setOnAction(e ->
		{
			try
			{
				//temporary variable to store stock for each item
				//stock for mains
				Integer intPepperoniPizzaStock;
				Integer intCheeseBurgerStock;
				Integer intGourmetBurgerStock;
						 
				//stock for sides
				Integer intChipsStock;
				Integer intPotatoWedgesStock;
				Integer intPeriPeriChipsStock;
						
				//stock for drinks
				Integer intWaterStock;
				Integer intFantaStock;
				Integer intSevenUpStock;
				
				
				
				
				
				//send integer data about stock of the items
				intPepperoniPizzaStock = inDataStream.readInt();
				intCheeseBurgerStock = inDataStream.readInt();
				intGourmetBurgerStock = inDataStream.readInt();
				
				intChipsStock = inDataStream.readInt();
				intPotatoWedgesStock = inDataStream.readInt();
				intPeriPeriChipsStock = inDataStream.readInt();
				
				intWaterStock = inDataStream.readInt();
				intFantaStock = inDataStream.readInt();
				intSevenUpStock = inDataStream.readInt();
				
				
				
				
				
				
				double VAT = total * 0.20;
				
				//lblAllergies.setText(txtbxAllergies.getText());
				String yourOrder = new String();
				
				
				//converting all quantities to integer
				Integer intPepperoniPizzaQty = Integer.parseInt(lblPepperoniPizzaQty.getText());
				Integer intCheeseBurgerQty = Integer.parseInt(lblCheeseBurgerQty.getText());
				Integer intGourmetBurgerQty = Integer.parseInt(lblGourmetBurgerQty.getText());
				
				Integer intChipsQty = Integer.parseInt(lblChipsQty.getText());
				Integer intPotatoWedgesQty = Integer.parseInt(lblPotatoWedgesQty.getText());
				Integer intPeriPeriChipsQty = Integer.parseInt(lblPeriPeriChipsQty.getText());

				Integer intWaterQty = Integer.parseInt(lblWaterQty.getText());
				Integer intFantaQty = Integer.parseInt(lblFantaQty.getText());
				Integer intSevenUpQty = Integer.parseInt(lblSevenUpQty.getText());
				
				//if none of the mains are selected
				if(intPepperoniPizzaQty == 0 && intCheeseBurgerQty == 0 && intGourmetBurgerQty == 0)
				{
					new Alert(Alert.AlertType.ERROR, "Please select at least one main").showAndWait();
				}
				
				
				//if none of the sides are selected
				else if(intChipsQty == 0 && intPotatoWedgesQty == 0 && intPeriPeriChipsQty == 0)
				{
					new Alert(Alert.AlertType.ERROR, "Please select at least one side").showAndWait();
				}
				
				
				//if none of the drinks are selected
				else if(intWaterQty == 0 && intFantaQty == 0 && intSevenUpQty == 0)
				{
					new Alert(Alert.AlertType.ERROR, "Please select at least one drink").showAndWait();
				}
				else
				{
					if (intPepperoniPizzaQty > intPepperoniPizzaStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intPepperoniPizzaStock + "PepperoniPizzas are available");
					}
					else if (intPepperoniPizzaQty >= 1)
					{						
						double pepperoniPizzaTotal = pepperoniPizzaPrice * intPepperoniPizzaQty;
						yourOrder = yourOrder + "Pepperoni Pizza " + "x" + intPepperoniPizzaQty + "  £" + df.format(pepperoniPizzaTotal) + "\n";
					}
				
					
					
					//Cheese burger
					if (intCheeseBurgerQty > intCheeseBurgerQty)
					{						
						new Alert(Alert.AlertType.ERROR, "Only " + intCheeseBurgerStock + "Cheese Burger are available");
					}
					else if (intCheeseBurgerQty >= 1)
					{
						double cheeseBurgerTotal = cheeseBurgerPrice * intCheeseBurgerQty;
						yourOrder = yourOrder + "Cheese Burger " + "x" + intCheeseBurgerQty + "  £" + df.format(cheeseBurgerTotal) + "\n";
					}
				
					
					
					//gourmet burger option
					if(intGourmetBurgerQty > intGourmetBurgerStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intGourmetBurgerStock + "Gourmet Burger are available");
					}
					else if (intGourmetBurgerQty >= 1)
					{						
						double gourmetBurgerTotal = gourmetBurgerPrice * intGourmetBurgerQty;
						yourOrder = yourOrder + "Gourmet Burger " + "x" + intGourmetBurgerQty + "  £" + df.format(gourmetBurgerTotal) + "\n";
					}
					
					
					
					
					//chips
					//take the selected quantity away from stock
					
					if(intChipsQty > intChipsStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intChipsStock + "Chips are available");
					}
					else if (intChipsQty >= 1)
					{						
						double chipsTotal = chipsPrice * intChipsQty;
						yourOrder = yourOrder + "Chips " + "x" + intChipsQty + "  £" + df.format(chipsTotal) + "\n";
					}
					
					
					
					//Potato Wedges
					//
					if(intPotatoWedgesQty > intPotatoWedgesStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intPotatoWedgesStock + "Potato Wedges are available");
					}
					else if (intPotatoWedgesQty >= 1)
					{						
						double potatoWedgesTotal = potatoWedgesPrice * intPotatoWedgesQty;
						yourOrder = yourOrder + "Potato Wedges " + "x" + intPotatoWedgesQty + "  £" + df.format(potatoWedgesTotal) + "\n";
					}
					
					
					
					//
					
					if(intPeriPeriChipsQty > intPeriPeriChipsStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intPeriPeriChipsStock + "CheeseBurger are available");
					}
					else if (intPeriPeriChipsQty >= 1)
					{						
						double periPeriChipsTotal = periPeriChipsPrice * intPeriPeriChipsQty;
						yourOrder = yourOrder + "Peri Peri Chips " + "x" + intPeriPeriChipsQty + "  £" + df.format(periPeriChipsTotal) + "\n";
					}
					
					
					//
					intWaterStock = intWaterStock - intWaterQty;
					if(intWaterQty > intWaterStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intWaterStock + "Water are available");
					}
					else if (intWaterQty >= 1)
					{
						double waterTotal = waterPrice * intWaterQty;
						yourOrder = yourOrder + "Water " + "x" + intWaterQty + "  £" + df.format(waterTotal) + "\n";
					}
					
					//
					if(intFantaQty > intFantaStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intFantaStock + "Fanta are available");
					}
					else if (intFantaQty >= 1)
					{
						double fantaTotal = fantaPrice * intFantaQty;
						yourOrder = yourOrder + "Fanta " + "x" + intFantaQty + "  £" + df.format(fantaTotal) + "\n";
					}
					
					
					//
					if(intSevenUpQty > intSevenUpStock)
					{
						new Alert(Alert.AlertType.ERROR, "Only " + intSevenUpStock + "SevenUp are available");
					}
					else if (intSevenUpQty >= 1)
					{
						
						double sevenUpTotal = sevenUpPrice * intSevenUpQty;
						yourOrder = yourOrder + "Seven Up " + "x" + intSevenUpQty + "  £" + df.format(sevenUpTotal) + "\n";
					}
					
					
					
					//Update the stocks by taking current order quantity away from them
					intPepperoniPizzaStock = intPepperoniPizzaStock - intPepperoniPizzaQty;
					intCheeseBurgerStock = intCheeseBurgerStock - intCheeseBurgerQty;
					intGourmetBurgerStock = intGourmetBurgerStock - intGourmetBurgerQty;
					
					intGourmetBurgerStock = intChipsStock - intChipsQty;
					intGourmetBurgerStock = intPotatoWedgesStock - intPotatoWedgesQty;
					intGourmetBurgerStock = intPeriPeriChipsStock - intPeriPeriChipsQty;
					
					intChipsStock = intWaterStock - intWaterQty;
					intPotatoWedgesStock = intFantaStock - intFantaQty;
					intPeriPeriChipsStock = intSevenUpStock - intSevenUpQty;
					
					
					
					//Send stocks back to the server
					outDataStream.writeInt(intPepperoniPizzaStock);
					outDataStream.writeInt(intCheeseBurgerStock);
					outDataStream.writeInt(intGourmetBurgerStock);
					
					outDataStream.writeInt(intChipsStock);
					outDataStream.writeInt(intPotatoWedgesStock);
					outDataStream.writeInt(intPeriPeriChipsStock);
					
					outDataStream.writeInt(intWaterStock);
					outDataStream.writeInt(intFantaStock);
					outDataStream.writeInt(intSevenUpStock);
					
					
					//Ryzhikov. E (2013)
					//disable buttons for out of stock items
					if(intPepperoniPizzaStock <= 0)
					{
						btnAddPepperoniPizza.setDisable(true);
						btnMinusPepperoniPizza.setDisable(true);
					}
					if (intCheeseBurgerStock <= 0)
					{
						btnAddCheeseBurger.setDisable(true);
						btnMinusCheeseBurger.setDisable(true);
					}
					if (intGourmetBurgerStock <= 0)
					{
						btnAddGourmetBurger.setDisable(true);
						btnMinusGourmetBurger.setDisable(true);
					}
					if (intChipsStock <= 0)
					{
						btnAddChips.setDisable(true);
						btnMinusChips.setDisable(true);
					}
					if (intPotatoWedgesStock <= 0)
					{
						btnAddPotatoWedges.setDisable(true);
						btnMinusPotatoWedges.setDisable(true);
					}
					if (intPeriPeriChipsStock <= 0)
					{
						btnAddPeriPeriChips.setDisable(true);
						btnMinusPeriPeriChips.setDisable(true);
					}
					if (intWaterStock <= 0)
					{
						btnAddWater.setDisable(true);
						btnMinusWater.setDisable(true);
					}
					if (intFantaStock <= 0)
					{
						btnAddFanta.setDisable(true);
						btnMinusFanta.setDisable(true);
					}
					if (intSevenUpStock <= 0)
					{
						btnAddSevenUp.setDisable(true);
						btnMinusSevenUp.setDisable(true);
					}
					
					
					//display selected allergies
					yourOrder = yourOrder + "Allergies: " + "\n";
					
					
					
					if(!chkNuts.isSelected() && !chkMilk.isSelected() && !chkEggs.isSelected() && !chkWheat.isSelected() && !chkSoy.isSelected())
					{
						yourOrder = yourOrder + "No Allergies" + "\n";
					}
					else
					{
						//West. H et al (2022)
						//selected Allergies
						if (chkNuts.isSelected())
						{
							yourOrder = yourOrder + "Nuts" + "\n";
						}
						
						if (chkMilk.isSelected())
						{
							yourOrder = yourOrder + "Milk" + "\n";
						}
						
						if (chkEggs.isSelected())
						{
							yourOrder = yourOrder + "Eggs" + "\n";
						}
						
						if (chkWheat.isSelected())
						{
							yourOrder = yourOrder + "Wheat" + "\n";
						}
						
						if (chkSoy.isSelected())
						{
							yourOrder = yourOrder + "Soy" + "\n";
						}
					}
					
					yourOrder = yourOrder + "Additional Notes: " + "\n";
					
					yourOrder = yourOrder + txtbxNotes.toString();
					
					yourOrder = yourOrder + "Subtotal: £"  + df.format(total) + "\n" + "20% VAT: £" + df.format(VAT) + "\n" + "Total: £" + df.format(total+VAT) + "\n";
					
					if (chkEatingIn.isSelected())
					{
						yourOrder = yourOrder + "Eating In" + "\n";
					}
					else
					{
						yourOrder = yourOrder + "Eating Out" + "\n";
					}
					
					
					
					
					//send the string of order back to kitchen for staff to read
					outDataStream.writeUTF(yourOrder);
					
					//display customer ID
					yourOrder = yourOrder + "Customer No: ";
					Integer id = inDataStream.readInt();
					yourOrder = yourOrder + id.toString();
					
					//show the customer a new window that displays their order
					new Alert(Alert.AlertType.INFORMATION, yourOrder).showAndWait();
					
					//increase the customer id by one for next customer
					id++;
					
					//send the id back to the server
					outDataStream.writeInt(id);
					
					//Start a new menu
					//Fabian (2019)
					stage.hide();
					start(new Stage());
				}
			}
			catch(IOException ie)
			{
			}
		}
				);
	}
		
	public static void main(String[] args)
	{
		launch(args);
	}
}





/*
//References
1) Fabian (2019), how can I add a reset/restart button to my JavaFX Application in order to reset my scene?, [Online], Available at: https://stackoverflow.com/questions/57023980/how-can-i-add-a-reset-restart-button-to-my-javafx-application-in-order-to-reset, [Last Accessed: 18th January 2023].
2) Jai (2018), Javafx variable with two decimal places, [Online] Available at: https://stackoverflow.com/questions/50672302/javafx-double-variable-with-two-decimal-places, [Last Accessed: 13th January 2023].
3) Ryzhikov. E (2013), Disabling a button in JavaFX, [Online], Available at: https://stackoverflow.com/questions/17871329/disabling-a-button-in-javafx, [Last Accessed: 17th January 2023].
4) West H, et al (2022), The 9 Most Common Food Allergies, [Online], Available at: https://www.healthline.com/nutrition/common-food-allergies#other-common-food-allergies [Last Accessed: 13th January 2023].









//Bibliography
1.	Fabian (2018), Clearing the scene in javafx, [Online], https://stackoverflow.com/questions/49216396/clearing-the-scene-in-javafx, [Available at: 16th Jan 2023].
2.	Kans, Charatan. Q (2019), java in Two Semesters, [Book], 4th ed, Springer: Switzerland [Last read: 17th Jan 2023].
3.	programiz (n.d), Java ByteArrayInputStream Class, [Online], Available at: https://www.programiz.com/java-programming/bytearrayinputstream, [Last Accessed: 18th Jan 2023].
4.	TutorialKart (2021), Java OR (||) Operator, https://www.bing.com/search?q=or+operator+java&qs=n&form=QBRE&sp=-1&pq=or+operator+java&sc=10-16&sk=&cvid=B1EC667276D04575B14FE532C40180AA&ghsh=0&ghacc=0&ghpl= [Last Accessed: 16th January 2023].

*/