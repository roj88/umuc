/*
 * filename: Account.java
 * author: roland carter
 * date: 2018-09-16
 * purpose: project two. this class creates a gui
 */

package atmmachinegui;

// import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// begin AtmMachineGUI class
public class AtmMachineGUI implements ActionListener {
    
    // define JFrame variables
    private final JFrame jFrame;
    private final JPanel panel;
    private final JTextField userInputValue;
    private final JButton withdrawalButton;
    private final JButton transferToButton;
    private final JButton depositButton;
    private final JButton balanceButton;
    private JRadioButton checkingRadioButton;
    private JRadioButton savingsRadioButton;
    
    // variables to hold account instances
    private Account checkingAccount;
    private Account savingsAccount;
    private Account selectedAccount;
    
    // window size constants
    final int WINDOW_WIDTH = 250;
    final int WINDOW_HEIGHT = 275;
    
    // set constants for beginning bank balances
    private static final int BEGINNING_CHECKING_BALANCE = 200;
    private static final int BEGINNING_SAVINGS_BALANCE = 10;
    
    // create click variable to count the number of times withdrawal is clicked on
    int totalWithdrawalClicks = 0;
    
    // method AtmMachineGUI define variables for the gui
    public AtmMachineGUI() {
        // intialize Account instances
        checkingAccount = new Account(BEGINNING_CHECKING_BALANCE);
        savingsAccount = new Account(BEGINNING_SAVINGS_BALANCE);
        
        // initialize button instances
        withdrawalButton = new JButton("Withdrawal");
        transferToButton = new JButton("Transfer To");
        depositButton = new JButton("Deposit");
        balanceButton = new JButton("Balance");
        
        // initialize radio button instances
        checkingRadioButton = new JRadioButton("Checking");
        savingsRadioButton = new JRadioButton("Savings");
        
        // initialize text field instance 
        userInputValue = new JTextField(10);
        
        // grouop radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(checkingRadioButton);
        group.add(savingsRadioButton);
        
        // add actions for listener
        withdrawalButton.addActionListener(this);
        transferToButton.addActionListener(this);
        depositButton.addActionListener(this);
        balanceButton.addActionListener(this);
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(withdrawalButton);
        panel.add(transferToButton);
        panel.add(depositButton);
        panel.add(balanceButton);
        panel.add(checkingRadioButton);
        panel.add(savingsRadioButton);
        panel.add(userInputValue);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        jFrame.setTitle("ATM Machine");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
        
    }
    
    @Override
    // add functionality to atm machine gui
    public void actionPerformed(ActionEvent e){
        
        // sets selected accounted type to selectedAccount
        if(checkingRadioButton.isSelected()){
            selectedAccount = checkingAccount;
        }
        else if(savingsRadioButton.isSelected()){
            selectedAccount = savingsAccount;
        }
       
       // counts the number of times the Withdrawal has been clicked
       // in order to determine charging the service fee
       if("Withdrawal".equals(e.getActionCommand())){    
            // add 1 everytime the withdrawal button is clicked
            totalWithdrawalClicks++;
        }
        
        // control structure to perform action based on clicked button
        if("Withdrawal".equals(e.getActionCommand())){
            // define input variables
            String valueInput;
            double valueDouble;
            
            // grab text from the text field
            valueInput = userInputValue.getText();
            
            // try-catch block to raise withdrawal exceptions
            try {
            // make text input double
            valueDouble = Double.parseDouble(valueInput);
            
            // call withdrawal method
            selectedAccount.withdrawal(valueDouble, totalWithdrawalClicks, 0);
            
            // display output
            JOptionPane.showMessageDialog(null, "You have withdrawn $" + valueDouble +
                    ". Your balance is now $" + selectedAccount.getBalance());
            }
            catch(NumberFormatException e0){
                JOptionPane.showMessageDialog(null, "Please enter a proper number format");
            }
            catch(InsufficientFunds e0){
                JOptionPane.showMessageDialog(null, e0.getMessage());
            }  
        }
        else if("Transfer To".equals(e.getActionCommand())){
            // input variables
            String valueInput;
            double valueDouble;
            
            // grab text from the text field
            valueInput = userInputValue.getText();
            
            // try-catch block to raise withdrawal exceptions
            try {
            valueDouble = Double.parseDouble(valueInput);
            
            // make deposit into account tranfering to
            selectedAccount.deposit(valueDouble);
            
            // make withdrawal from the account tranfering from
            if(selectedAccount == checkingAccount){
                savingsAccount.withdrawal(valueDouble, 0, 1);
            }
            else if(selectedAccount == savingsAccount){
                checkingAccount.withdrawal(valueDouble, 0, 1);
            }
            
            // display output 
            JOptionPane.showMessageDialog(null, "You have transfered $" + valueDouble +
                    ". Your balance is now $" + selectedAccount.getBalance());
            }
            catch(NumberFormatException e0){
                JOptionPane.showMessageDialog(null, "Please enter a proper number format");
            }
            catch(InsufficientFunds e0){
                JOptionPane.showMessageDialog(null, e0.getMessage());
            }
        }
        else if("Deposit".equals(e.getActionCommand())){
            // input variables
            String valueInput;
            double valueDouble;
            
            // grab text from the text field
            valueInput = userInputValue.getText();
            
            // try-catch block to raise withdrawal exceptions
            try {
            valueDouble = Double.parseDouble(valueInput);
            
            // make deposit into account tranfering to
            selectedAccount.deposit(valueDouble);
            
            // display output
            JOptionPane.showMessageDialog(null, "You have deposited $" + valueDouble +
                    ". Your balance is now $" + selectedAccount.getBalance());
            }
            catch(NumberFormatException e0){
                JOptionPane.showMessageDialog(null, "Please enter a proper number format");
            }
        }
        else if("Balance".equals(e.getActionCommand())){
            
            // display getBalance() output
            JOptionPane.showMessageDialog(null, "Your balance is $" + selectedAccount.getBalance());
        }
    }

    // main method creates and runs an instance of the gui
    public static void main(String[] args) {
        new AtmMachineGUI();
    } // end main method

} // end class AtmMachineGUI
