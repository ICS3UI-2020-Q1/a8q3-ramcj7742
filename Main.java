import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel tempFah;
  JLabel tempCel;

  JTextField convertFah;
  JTextField convertCel;

  JButton fahToCel;
  JButton celToFah;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Temperature converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize main panel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    //initialize labels
    tempFah = new JLabel("Degrees Fahrenheit");
    tempCel = new JLabel("Degrees Celsius");

    //set location and size of labels
    tempFah.setBounds(20, 20, 200, 20);
    tempCel.setBounds(20, 60, 200, 20);

    //initialize input fields
    convertFah = new JTextField();
    convertCel = new JTextField();

    //set location and size of inputs
    convertFah.setBounds(240, 20, 100, 20);
    convertCel.setBounds(240, 60, 100, 20);

    //initialize buttons
    fahToCel = new JButton("F -> C");
    celToFah = new JButton("C -> F");

    //set location and size for buttons
    fahToCel.setBounds(360, 20, 100, 20);
    celToFah.setBounds(360, 60, 100, 20);

    //add action listener to buttons
    fahToCel.addActionListener(this);
    celToFah.addActionListener(this);

    //set action command for the buttons
    fahToCel.setActionCommand("fahrenheit");
    celToFah.setActionCommand("celsius");

    //add all elements ot main panel
    mainPanel.add(tempFah);
    mainPanel.add(tempCel);

    mainPanel.add(convertFah);
    mainPanel.add(convertCel);

    mainPanel.add(fahToCel);
    mainPanel.add(celToFah);

    //add main panel to frame
    frame.add(mainPanel);
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("fahrenheit")){
      //gets current number in fahrenheit box
      String userNum = convertFah.getText();

      //converts string to integer
      int conversionF = Integer.parseInt(userNum);

      //turns temp F to C
      int degreesCels = (conversionF - 32) * 5 / 9;

      //displays temp in degrees celsius
      convertCel.setText("" + degreesCels);
    }else if(command.equals("celsius")){
      //gets current number in celsius box
      String userNum = convertCel.getText();

      //converts string to int
      int conversionC = Integer.parseInt(userNum);

      //turns temp c to f 
      int degreesFah = conversionC / 5 * 9 + 32;

      //displays temp in degrees fahrenheit
      convertFah.setText("" + degreesFah);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
