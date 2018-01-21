/*
 * [GuidanceAppointment.java]
 * Author: Beini, Parmida
 * Jan 2015
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JTabbedPane;
import java.lang.Object;
import javax.swing.table.TableColumn;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

//****************************************************************************************************
public class GuidanceAppointment extends JFrame implements ActionListener{ 
  
  //data for table
  String[] columnNames = {"Time","Garito (A-E)",
    "Mondal (N-T)","Graves (F-K)","Park (U-Z)","McNeilly (L-M)","Trefler (U-Z)",
    "Won (U-Z)","Time","Garito (A-E)",
    "Mondal (N-T)","Graves (F-K)","Park (U-Z)","McNeilly (L-M)","Trefler (U-Z)",
    "Won (U-Z)","Time","Garito (A-E)",
    "Mondal (N-T)","Graves (F-K)","Park (U-Z)","McNeilly (L-M)","Trefler (U-Z)",
    "Won (U-Z)","Time","Garito (A-E)",
    "Mondal (N-T)","Graves (F-K)","Park (U-Z)","McNeilly (L-M)","Trefler (U-Z)",
    "Won (U-Z)","Time","Garito (A-E)",
    "Mondal (N-T)","Graves (F-K)","Park (U-Z)","McNeilly (L-M)","Trefler (U-Z)",
    "Won (U-Z)",};
  String[][] data1 = new String [20][40];
  
  
  
  //Variables
  String[][] subject=new String[6][2501];
  int hour=8,minute=50,rate=3,column,row,hour2=8,minute2=50 ,column2;
  String studentnumber="0";
  int counter=0;
  
  
  String passentered;
  //Create some Panels
  JPanel pan1 = new JPanel();//view all
  JPanel pan3 = new JPanel();//add
  JPanel pan2 = new JPanel();//save
  JPanel pan4 = new JPanel();//pan3
  JPanel pan6 = new JPanel();//pan3
  JPanel pan7 = new JPanel();//pan4
  JPanel pan8 = new JPanel();//pan4
  JPanel pan9 = new JPanel();//pan4
  JPanel pan10 = new JPanel();//pan4
  
  //Create some GUI components
  JTabbedPane tabbedPane = new JTabbedPane();//tabs
  
  
  
  //pan 1 table
  JTable table = new JTable(data1, columnNames);//table
  JScrollPane tableScrollPane = new JScrollPane(table);//scroll bar
  JButton searchButton = new JButton("Search");      
  JButton cancelButton = new JButton("Cancel Appointment"); 
  JButton bookButton = new JButton("Book Appointment"); 
  JButton unavailableButton = new JButton("Make it unavailble"); 
  JButton availableButton = new JButton("Make it available");  
  JButton sortButton = new JButton("Sort & Save");
  JButton savefile = new JButton("Save File");
  JTextField searchField = new JTextField();
  JLabel dayLabel = new JLabel("Day selected: Monday", JLabel.CENTER);
  JLabel dayLabel2 = new JLabel("Day selected: Monday", JLabel.CENTER); 
  JLabel nextLabel = new JLabel("Scroll Right For Next Day >>  ", JLabel.CENTER);
  JLabel previousLabel = new JLabel("<< Scroll Left For Previous Day", JLabel.CENTER); 
  
  JTextField firstName = new JTextField();
  JTextField lastName = new JTextField();
  JTextField studentnum = new JTextField();
  
 JTextField sortingoption= new JTextField();
  
  //dialogues 
  final JComponent[] book = new JComponent[] {new JLabel("First Name:"),firstName,new JLabel("Last Name:"),lastName,new JLabel("Student Number:"),studentnum};
  final JComponent[] cancel = new JComponent[] {new JLabel("Enter your Student number for validation:"),studentnum};
  final JComponent[] search = new JComponent[] {new JLabel("First Name:"),firstName,new JLabel("Last Name:"),lastName};
  final JComponent[] sorting = new JComponent[] {new JLabel("Sort By: "),sortingoption,new JLabel("Options: Lastname, Date, Councillor")};
  
  
  //pan3
  JButton passwordButton=new JButton("Log In");
  JButton logoutButton=new JButton("Log Out"); 
  JTable table2 = new JTable(data1, columnNames);//table
  JScrollPane table2ScrollPane = new JScrollPane(table2);//scroll bar
  JPasswordField pass= new JPasswordField();
  final JComponent[] password = new JComponent[] {new JLabel("Enter the password:"),pass};
  
//***********************************************************************************************************************************************************
  // CONSTRUCTOR - Setup your GUI here
  public GuidanceAppointment() { 
    setTitle("Guidance Appointment");    //Create a window with a title
    setSize(1400, 820);           // set the window size
    dayLabel.setFont(new Font("Courier New", Font.BOLD, 16));
    dayLabel.setForeground(Color.RED);
    dayLabel2.setFont(new Font("Courier New", Font.BOLD, 16));
    dayLabel2.setForeground(Color.RED);
    nextLabel.setFont(new Font("Courier New", Font.BOLD, 16));
    previousLabel.setFont(new Font("Courier New", Font.BOLD, 16));
    
    //set tabs
    JTabbedPane tp = new JTabbedPane();
    
    //declaring the data in the table
    for (int i=0;i<20;i++){
      for (int j=0;j<40;j++){
        data1[i][j]=null;
      }
    }
    //UNAVAILABLE CELLS
    //row1
    for (int k=0;k<40;){
      for (int i=0;i<4;i++){
        for (int j=1+k;j<2+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=0;i<4;i++){
        for (int j=3+k;j<4+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=0;i<4;i++){
        for (int j=6+k;j<8+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }
      //row2
      for (int i=4;i<8;i++){
        for (int j=2+k;j<7+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }
      //row3
      for (int i=8;i<12;i++){
        for (int j=3+k;j<7+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }
      //row4
      for (int i=12;i<16;i++){
        for (int j=1+k;j<2+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=12;i<16;i++){
        for (int j=3+k;j<5+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=12;i<16;i++){
        for (int j=7+k;j<8+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }
      //row5
      for (int i=16;i<20;i++){
        for (int j=2+k;j<3+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=16;i<20;i++){
        for (int j=4+k;j<5+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }for (int i=16;i<20;i++){
        for (int j=6+k;j<8+k;j++){
          data1[i][j]="|||||||||||||||||||||||||||||||||||||||||||";
        }
      }
      k=k+8;
    }

    // Create some Layouts
    // Set the frame and both panel layouts
    BoxLayout layout1 = new BoxLayout(pan1,BoxLayout.Y_AXIS);
    BoxLayout layout2 = new BoxLayout(pan2,BoxLayout.X_AXIS);
    BoxLayout layout3 = new BoxLayout(pan3,BoxLayout.Y_AXIS);
    BoxLayout layout4 = new BoxLayout(pan4,BoxLayout.X_AXIS);
    pan2.setLayout(layout2);
    pan1.setLayout(layout1);
    pan3.setLayout(layout3);
    pan4.setLayout(layout4);
    
    
    //add tabs
    tp.addTab("Students", pan1);
    tp.addTab("Guidance", pan3);
    
    
    
    //Panel 1
    //************************declaring time for table********
    for (int i=0;i<20;i++){
      for (int j=0;j<1;j++){
        data1[i][j]=hour + ":" + minute;
        minute=minute+20;
      }if (minute>60) {
        hour=hour+1;
        minute = minute - 60;
      }
    }
    hour=8;
    minute=50;
    for (int i=0;i<20;i++){
      for (int j=8;j<9;j++){
        data1[i][j]=hour + ":" + minute;
        minute=minute+20;
      }if (minute>60) {
        hour=hour+1;
        minute=minute-60;
      }
    }
    hour=8;
    minute=50;
    for (int i=0;i<20;i++){
      for (int j=16;j<17;j++){
        data1[i][j]=hour + ":" + minute;
        minute=minute+20;
      }if (minute>60) {
        hour=hour+1;
        minute=minute-60;
      }
    }
    hour=8;
    minute=50;
    for (int i=0;i<20;i++){
      for (int j=24;j<25;j++){
        data1[i][j]=hour + ":" + minute;
        minute=minute+20;
      }if (minute>60) {
        hour=hour+1;
        minute=minute-60;
      }
    }
    hour=8;
    minute=50;
    for (int i=0;i<20;i++){
      for (int j=32;j<33;j++){
        data1[i][j]=hour + ":" + minute;
        minute=minute+20;
      }if (minute>60) {
        hour=hour+1;
        minute=minute-60;
      }
    }
    //*********************************************
    
    
    //gui
    pan1.setBorder(BorderFactory.createLineBorder(Color.black));
    pan1.add(tableScrollPane);
    //table height and width
    table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));
    table.setFont(new Font("Serif", Font.BOLD, 18));
    table.setRowHeight(33);
    for (int i=0;i<=35;){
      table.getColumnModel().getColumn(i).setPreferredWidth(90);//time width
      table.getColumnModel().getColumn(i+1).setPreferredWidth(180);//Garito width
      table.getColumnModel().getColumn(i+2).setPreferredWidth(180);//Mondal width
      table.getColumnModel().getColumn(i+3).setPreferredWidth(180);//Graves width
      table.getColumnModel().getColumn(i+4).setPreferredWidth(180);//Park width
      table.getColumnModel().getColumn(i+5).setPreferredWidth(180);//Mcneily width
      table.getColumnModel().getColumn(i+6).setPreferredWidth(180);//Trefler width
      table.getColumnModel().getColumn(i+7).setPreferredWidth(180);//Wong width
      i=i+8;
    }
    table.setGridColor(Color.BLACK);//colour of the grid
    pan1.add(pan2);
    //buttons
    pan2.add(previousLabel);
    pan2.add(bookButton);
    pan2.add(cancelButton);    
    pan2.add(nextLabel);    
    pan2.add(dayLabel);
    pan2.add(savefile);
    bookButton.addActionListener(this);//action listener for book button
    cancelButton.addActionListener(this);
    table.setShowGrid(true);//show grid
    
    
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //table selection
    for (int c = 0; c < table.getColumnCount(); c++){
      Class<?> col_class = table.getColumnClass(c);
      table.setDefaultEditor(col_class, null);        // remove editor
    }
    
    table.setColumnSelectionAllowed(false);
    table.setRowSelectionAllowed(false);
    
//-----------------------------------------------------------------------------
    //pan3 guidance
    //declaring time for table
    
    
    //gui
    pan3.setBorder(BorderFactory.createLineBorder(Color.black));
    pan3.add(table2ScrollPane);
    //table height and width
    table2.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 20));
    table2.setFont(new Font("Serif", Font.BOLD, 18));
    table2.setRowHeight(35);
    for (int i=0;i<=35;){
      table2.getColumnModel().getColumn(i).setPreferredWidth(90);//time width
      table2.getColumnModel().getColumn(i+1).setPreferredWidth(180);//Garito width
      table2.getColumnModel().getColumn(i+2).setPreferredWidth(180);//Mondal width
      table2.getColumnModel().getColumn(i+3).setPreferredWidth(180);//Graves width
      table2.getColumnModel().getColumn(i+4).setPreferredWidth(180);//Park width
      table2.getColumnModel().getColumn(i+5).setPreferredWidth(180);//Mcneily width
      table2.getColumnModel().getColumn(i+6).setPreferredWidth(180);//Trefler width
      table2.getColumnModel().getColumn(i+7).setPreferredWidth(180);//Wong width
      i=i+8;
    }
    table2.setGridColor(Color.BLACK);//colour of the grid
    pan3.add(pan4);
    pan4.add(passwordButton);
    pan4.add(logoutButton);
    pan4.add(unavailableButton);
    pan4.add(availableButton);
    pan4.add(sortButton);
    pan4.add(dayLabel2);
    passwordButton.addActionListener(this);//action listener for book button
    logoutButton.addActionListener(this);
    unavailableButton.addActionListener(this);
    availableButton.addActionListener(this);
    sortButton.addActionListener(this);
    savefile.addActionListener(this);
   
    
    
    table.setShowGrid(true);//show grid
    table2.setVisible(false);
    logoutButton.setVisible(false);
    unavailableButton.setVisible(false);
    availableButton.setVisible(false);
    sortButton.setVisible(false);
    
    table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //table selection
    for (int c = 0; c < table2.getColumnCount(); c++){
      Class<?> col_class = table2.getColumnClass(c);
      table2.setDefaultEditor(col_class, null);        // remove editor
    }
    
    table2.setColumnSelectionAllowed(false);
    table2.setRowSelectionAllowed(false);
    
    //add the tabs
    add(tp);
    
    setResizable(false);//not resizable
    setVisible(true); 
    
    for(int i=0;i<5;i++){
      for(int j=0;j<2500;j++){
        subject[i][j]="null";
      }
    }
    
    subject = loadFileOntoArray(subject, counter);
    counter = Integer.parseInt(subject[0][2500]);
    subject[0][2500] = "null";
  }
  
  
//********************************************************************************************************************************************************************
  // ACTION LISTENER - This method runs when an event occurs
  public void actionPerformed(ActionEvent event) {
    
    String command = event.getActionCommand();  //find out the name of the component that was used

    
    if (command.equals("Book Appointment")){ //if Book button was pressed 
      row=table.getSelectedRow();
      column=table.getSelectedColumn();
      System.out.println("column"+ column);
      System.out.println("row"+ row);
      System.out.println(data1[row][column]);
      if(data1[row][column]==null){
        JOptionPane.showMessageDialog(null, book, "Book Appointment", JOptionPane.PLAIN_MESSAGE);
        System.out.println("You entered " + firstName.getText() + ", " + lastName.getText() + ", " + studentnum.getText());
        data1[row][column]=firstName.getText() + " " + lastName.getText();
        
          subject[0][counter]=firstName.getText() ;
          subject[1][counter]=lastName.getText();
          subject[2][counter]=studentnum.getText();
          
          
          if (column<8){
            subject[3][counter]="Monday";
          }else if (column<16 ){
            subject[3][counter]="Tuesday";
          }else if (column<24){
            subject[3][counter]="Wednesday";
          }else if (column<32){
            subject[3][counter]="Thursday";
          }else {
            subject[3][counter]="Friday";
          }
        }
        firstName.setText(null);
        lastName.setText(null);
        studentnum.setText(null);
        
        subject[4][counter]= data1[row][0];
        subject[5][counter]=columnNames[column];
        
        counter++;
        
       
      }else {
        JOptionPane.showMessageDialog(this,"Sorry this timeslot is unavailable!","Unavailable", JOptionPane.ERROR_MESSAGE);
      
        
      }if (command.equals("Save File") ){
        
        
        String[][] tempSubject=new String[6][2500];
   //     tempSubject=SortingByCouncelorLastName(subject,(counter-1),1);        
        outputToFile(tempSubject,counter);
        
        
      }
      
      
    if (command.equals("Cancel Appointment")){ //if Cancel button was pressed 
      row=table.getSelectedRow();
      column=table.getSelectedColumn();
      System.out.println("column "+ column);
      System.out.println("row "+ row);
      if (data1[row][column]==null || data1[row][column]=="|||||||||||||||||||||||||||||||||||||||||||"){
        JOptionPane.showMessageDialog(this,"Sorry you can't cancel anything in this timeslot","Error", JOptionPane.ERROR_MESSAGE);
      }else {
        JOptionPane.showMessageDialog(null, cancel, "Cancel Appointment", JOptionPane.PLAIN_MESSAGE);
        System.out.println("You entered" + studentnum.getText());
        studentnumber=studentnum.getText();
        studentnum.setText(null);
        for(int i=0;i<3500;i++){ 
          if (studentnumber.equals(subject[2][i])){ //if the student number match  
            data1[row][column]=null;
            subject[0][i]=null;
            subject[1][i]=null;
            subject[2][i]=null;
            subject[3][i]=null;
            subject[4][i]=null;
            subject[5][i]=null;
            JOptionPane.showMessageDialog(this,"Appointment Canceled!","Canceled", JOptionPane.PLAIN_MESSAGE);
            break;
          }else {
            JOptionPane.showMessageDialog(this,"Wrong Student Number!","Wrong", JOptionPane.ERROR_MESSAGE);
            break;
          }
        } 
      }
      
    }else if (command.equals("Log In")){
      JOptionPane.showMessageDialog(null, password, "Password", JOptionPane.PLAIN_MESSAGE);
      System.out.println("You entered" + pass.getText());
      passentered=pass.getText();
      if (passentered.equals("1234")){
        //pan3.add(table2ScrollPane);
        table2.setVisible(true);
        pass.setText(null);
        logoutButton.setVisible(true);
        unavailableButton.setVisible(true);
        availableButton.setVisible(true);
        sortButton.setVisible(true);
      }else {
        JOptionPane.showMessageDialog(this,"Wrong Password!","Wrong", JOptionPane.ERROR_MESSAGE);
        pass.setText(null);
      }
      
    }else if (command.equals("Log Out")){
      table2.setVisible(false);
      logoutButton.setVisible(false);
      unavailableButton.setVisible(false);
      availableButton.setVisible(false);
      sortButton.setVisible(false);
      
    }else if (command.equals("Make it unavailble")){
      row=table2.getSelectedRow();
      column=table2.getSelectedColumn();
      data1[row][column]="|||||||||||||||||||||||||||||||||||||||||||";
      
    }else if (command.equals("Make it available")){
      row=table2.getSelectedRow();
      column=table2.getSelectedColumn();
      data1[row][column]=null;
    }else if (command.equals("Sort & Save")){
      JOptionPane.showMessageDialog(null, sorting, "Sort & Save", JOptionPane.PLAIN_MESSAGE);
      if((sortingoption.getText()).equals("Last Name")|| (sortingoption.getText()).equals("lastname") || (sortingoption.getText()).equals("LastName") || (sortingoption.getText()).equals("Last Name")){
        
      }else if((sortingoption.getText()).equals("Date")|| (sortingoption.getText()).equals("date")){
       
      }else if((sortingoption.getText()).equals("Councillor")|| (sortingoption.getText()).equals("councillor")){
        
      }
    }
    
    //day label
    column=table.getSelectedColumn();
    if (column<8){
      dayLabel.setText("Day selected: Monday");
    }else if (column<16 ){
      dayLabel.setText("Day selected: Tuesday");
    }else if (column<24){
      dayLabel.setText("Day selected: Wednesday");
    }else if (column<32){
      dayLabel.setText("Day selected: Thursday");
    }else {
      dayLabel.setText("Day selected: Friday");
    }column2=table2.getSelectedColumn();
    if (column2<8){
      dayLabel2.setText("Day selected: Monday");
    }else if (column2<16 ){
      dayLabel2.setText("Day selected: Tuesday");
    }else if (column2<24){
      dayLabel2.setText("Day selected: Wednesday");
    }else if (column2<32){
      dayLabel2.setText("Day selected: Thursday");
    }else {
      dayLabel2.setText("Day selected: Friday");
    }
  }
  
  
//****************************************************************************************************
  //Main method
  
  public static void main(String[] args) throws Exception {
    GuidanceAppointment frame1 = new GuidanceAppointment();  //Start the GUI
    
  }
  
// ****************************************************************************************************************************//
//                                                Sorting by name                                                              //
// ****************************************************************************************************************************//
  
  public String[][] SortingByCouncelorLastName(String subject[][], int counter, int index) throws Exception{
    try {
    String tempname="";
    String templastname="";
    String tempstudentnumber="";
    String tempdate="";
    String temptime="";
    String tempcounclor="";
    int changed=0;        
    
    for(int i=0;i<counter;i++){
      changed=0;
      for(int j=0;j<counter;j++){
        if(subject[index][j].compareToIgnoreCase(subject[index][j+1])>0 || subject[index][j].equals("null")&&!subject[index][j+1].equals("null")){
          templastname=subject[0][j];
          tempname=subject[1][j];
          tempstudentnumber=subject[2][j];
          tempdate=subject[3][j];
          temptime=subject[4][j];
          tempcounclor=subject[5][j];
          
          subject[0][j]=subject[0][j+1];
          subject[1][j]=subject[1][j+1];
          subject[2][j]=subject[2][j+1];
          subject[3][j]=subject[3][j+1];
          subject[4][j]=subject[4][j+1];
          subject[5][j]=subject[5][j+1];
          
          subject[0][j+1]=templastname;
          subject[1][j+1]=tempname;
          subject[2][j+1]=tempstudentnumber;
          subject[3][j+1]=tempdate;
          subject[4][j+1]=temptime;
          subject[5][j+1]=tempcounclor;
          
          changed=1;
        }
      }
      if(changed==0)
        break;
    }
    
    return subject;
    } catch (Exception e){
      System.out.print(e);
      return null;
    }
    
  }
  
// ****************************************************************************************************************************//
//                                                  Sorting by date/time                                                       //
// ****************************************************************************************************************************//
  
  public static String[][] SortByDateTime(String subject[][], int counter, int index){
        String tempname="";
        String templastname="";
        String tempstudentnumber="";
        String tempdate="";
        String temptime="";
        String tempcounclor="";
        int changed=0;
        
        for(int i=0;i<counter;i++){
          changed=0;
          for(int j=0;j<(counter);j++){
            if((subject[index][j].compareTo(subject[index][j+1]))<0 || subject[index][j].equals("null")&&!subject[0][j+1].equals("null")){
              
              templastname=subject[0][j];
              tempname=subject[1][j];
              tempstudentnumber=subject[2][j];
              tempdate=subject[3][j];
              temptime=subject[4][j];
              tempcounclor=subject[5][j];
              
              subject[0][j]=subject[0][j+1];
              subject[1][j]=subject[1][j+1];
              subject[2][j]=subject[2][j+1];
              subject[3][j]=subject[3][j+1];
              subject[4][j]=subject[4][j+1];
              subject[5][j]=subject[5][j+1];
              
              subject[0][j+1]=templastname;
              subject[1][j+1]=tempname;
              subject[2][j+1]=tempstudentnumber;
              subject[3][j+1]=tempdate;
              subject[4][j+1]=temptime;
              subject[5][j+1]=tempcounclor;
              
              changed=1;
            }
          }
          if(changed==0)
            break;
        }

    return subject;
  }
  
// ****************************************************************************************************************************//
//                                             Output array to file                                                            //
// ****************************************************************************************************************************//
  
  public static void outputToFile (String appointments[][], int counter){
    try {
      File myFile = createFile(); //Call create file method
      
      PrintWriter output = new PrintWriter(myFile);
      
      output.println ("First Name:          " + "Last Name:         " + "Student Number:     " + "Date:               " + "Time:               " + "Counselor:     ");  // Output title of colms (20 spaces each)
      for (int count = 0; count < counter; count++) {   //Output to file
        
        for (int indexCounter = 0; indexCounter < 6; indexCounter++) {
          output.print (appointments[indexCounter][count]);
          for (int spaces = 0; spaces < (20 - appointments[indexCounter][count].trim().length()); spaces++) {  // Adds extra spaces so that data remains in chart form
            output.print (" ");         
          }
        }
        output.println ("");  //Starts a new line for the next set of data
      }
      
      for (int count = 0; count < counter; count++) {
        for (int indexCounter = 0; indexCounter < 6; indexCounter++) {
          System.out.print (appointments[indexCounter][count] + "      ");
        }
        System.out.println();
      }
      
      System.out.println ("\nData has been outputed to file\n");    
      output.close();   
    } catch (java.io.FileNotFoundException e){
      System.err.println ("FileNotFoundException");
    };
    
  }
// ****************************************************************************************************************************//
//                                             Create File Method                                                              //
// ****************************************************************************************************************************//   
  
   public static File createFile () {  
    Date date = new Date();
    String myDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
    System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(date));   
    
    File myFile = new java.io.File("Guidance_Appointments_" + myDate + ".txt");    // Creates a new file
//    myFile.createNewFile();
    return (myFile);
  } 
   
     
// ****************************************************************************************************************************//
//                                                    Load Array                                                               //
// ****************************************************************************************************************************//    
   
    public static String[][] loadFileOntoArray (String[][]fileArray, int counter) {
    try {
      File myFile = createFile(); //Call create file method
      Scanner input = new Scanner(myFile);
      int index = 0;
      
      while(input.hasNext()) {
        if (counter == 0 && index == 0) {
          input.nextLine();  //Ignore the first line of the file, input data to array starting from the second line
        } 
        
        fileArray[index][counter] = input.next();        
        System.out.print (fileArray[index][counter] + "     ");
        index++;
        
        if (index == 6) {
          System.out.println("");
          index = 0;
          counter++;
        }
      }
      input.close();
    } catch (Exception e) {};
    
    fileArray[0][2500] = Integer.toString(counter);
    return (fileArray);
  }
  
}
