package group13Project.GUI;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import net.miginfocom.swing.MigLayout;

public class GUIMainFrame extends JFrame {
	
	// Instance variables -- GUI components

    private JFrame setUpFrame = new JFrame("Group 13 Project - Set up");
    private JPanel setUpPanel = new JPanel();
    private JFrame newDeviceFrame = new JFrame("Group 13 Project - New Device");
    private JPanel newDevicePanel = new JPanel();
    
    
    private JLabel status = new JLabel();
    private JLabel welcomeMessage = new JLabel("Welcome, Please wait a moment while complete the setup.");
    private JLabel forename = new JLabel();
    private JLabel surname = new JLabel();
    private JLabel ip = new JLabel();
    private JLabel newDeviceTitle = new JLabel();
    private JLabel alias = new JLabel();
    private JLabel forenameHelper = new JLabel("Please enter your forename.");
    private JLabel surnameHelper = new JLabel("Please enter your surname.");
    private JLabel aliasHelper = new JLabel("Please enter your name that other device would reconise you by.");
    
    private JLabel tickForename = new JLabel("\u2713");
    private JLabel tickSurname = new JLabel("\u2713");
    private JLabel tickAlias = new JLabel("\u2713");
    
    
    
    private JTextField forenameTA = new JTextField();
    private JTextField surnameTA = new JTextField();
    private JLabel ipTA = new JLabel();
    private JTextField aliasTA = new JTextField();
    
    
    private JButton nextBtn = new JButton();
    
    private static final Color headerBGColour = new Color(212,217,222);
    private static final Color headerFGColour = new Color(78,90,101);
    private static final Color mainBGColour = new Color(234, 236, 238);
    private static final Color mainFGColour = new Color(78,90,101);
    private static final Color blue = new Color(33,161,225);
    private static final Color red = new Color(245, 100, 100);
    
    private static final Font inputFont = new Font("Serif",Font.PLAIN, 18);
    private static final Font titleFont = new Font("Serif",Font.PLAIN, 32);
    private static final Font labelFont = new Font("Serif",Font.PLAIN, 20);
    private static final Font smallFont = new Font("Serif",Font.PLAIN, 14);
    
    private static final int forenameLength = 32;
    private static final int surnameLength = 32;
    private static final int aliasLength = 16;

    private Boolean newDeviceViewComplete = false;

    
    
    
	
	/* 
	 * Creates a GUI interface for user.
	 
	 */
    public GUIMainFrame() {
    	
    	//already setup
    }
	public GUIMainFrame(Boolean setup) {

	    if(setup == true){
		
			this.setupView();
			
			
		}
        
		
	}
	public void setupView() {
		
		setUpFrame.setMinimumSize(new Dimension(400, 300));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (int) ((dimension.getWidth() - setUpFrame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - setUpFrame.getHeight()) / 2);
	    
	    setUpFrame.setLocation(x, y);
	    setUpPanel.setLayout(new GridLayout(0,1));
		
		welcomeMessage.setOpaque(true);
	    welcomeMessage.setFont(labelFont);
	    welcomeMessage.setBackground(headerBGColour);
	    welcomeMessage.setForeground(headerFGColour);
	    welcomeMessage.setMaximumSize(new Dimension(800, 100));
	    welcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    status.setOpaque(true);
	    status.setFont(labelFont);
	    status.setBackground(mainBGColour);
	    status.setForeground(mainFGColour);
	    status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    setUpPanel.add(welcomeMessage);
	    setUpPanel.add(status);
	    
	    setUpFrame.add(setUpPanel);
		
		setUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpFrame.pack();
		setUpFrame.setVisible(true);
	}
	public void newDeviceView(String IP) {
		boolean errorCheckingPassed = false;
	
		
		setUpFrame.dispose();
		
		
		newDeviceFrame.setMinimumSize(new Dimension(800, 700));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (int) ((dimension.getWidth() - newDeviceFrame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - newDeviceFrame.getHeight()) / 2);
	    
	    newDeviceFrame.setLocation(x, y);
	    newDevicePanel.setLayout(new MigLayout("  wrap 3, align center ,fillx"));

	    // START title styling
	    newDeviceTitle.setText("Setup your new Device");
	    newDeviceTitle.setFont(titleFont);
	    newDeviceTitle.setForeground(mainFGColour);
	   
	    //END title styling
	    //START forname styling
	    
	    forename.setText("Forename: ");
	    forename.setFont(labelFont);
	    forename.setForeground(mainFGColour);
	    
	    //END forename styling
	    
	    //START surname styling
	    
	    surname.setText("Surname: ");
	    surname.setFont(labelFont);
	    surname.setForeground(mainFGColour);
	    
	    //END surname styling
	    //START IP styling
	    
	    ip.setText("Your IP Address: ");
	    ip.setFont(labelFont);
	    ip.setForeground(mainFGColour);
	    
	    //END ip styling
	    //START alias styling
	    
	    alias.setText("Your Alias: ");
	    alias.setFont(labelFont);
	    alias.setForeground(mainFGColour);
	    
	    //END alias styling
	    
	    // START Forename helper styling
	    forenameHelper.setFont(smallFont);
	    forenameHelper.setForeground(mainFGColour);
	    forenameHelper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    // END Forename helper styling
	    
	    // START Surname helper styling
	    surnameHelper.setFont(smallFont);
	    surnameHelper.setForeground(mainFGColour);
	    surnameHelper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    // END Surname helper styling
	    
	    // START alias helper styling
	    aliasHelper.setFont(smallFont);
	    aliasHelper.setForeground(mainFGColour);
	    aliasHelper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
	    // END Surname helper styling
	    
        
        //START forename input styling
        forenameTA.setOpaque(true);
        forenameTA.setFont(inputFont);
	    
        forenameTA.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(10, 10, 10, 10) ));
	    forenameTA.setBackground(Color.WHITE);
	    forenameTA.setForeground(mainFGColour);
	    forenameTA.setMaximumSize(new Dimension(300, 40));
	    
	    //END forename Styling
	    
	    //START surname Styling

	    surnameTA.setOpaque(true);
	    surnameTA.setFont(inputFont);
	    surnameTA.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(10, 10, 10, 10) ));
	    surnameTA.setBackground(Color.WHITE);
        surnameTA.setForeground(mainFGColour);
        surnameTA.setMaximumSize(new Dimension(300, 40));

        //END surname Styling
        
        //START ip input styling
        ipTA.setText(IP);
        ipTA.setOpaque(true);
        ipTA.setFont(inputFont);
        ipTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    
        
        ipTA.setForeground(mainFGColour);
        ipTA.setMaximumSize(new Dimension(300, 40));
	    
	    //END ip Styling
        //START alias input Styling

	    aliasTA.setOpaque(true);
	    aliasTA.setFont(inputFont);
	    aliasTA.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(10, 10, 10, 10) ));
	    aliasTA.setBackground(Color.WHITE);
	    aliasTA.setForeground(mainFGColour);
	    aliasTA.setMaximumSize(new Dimension(300, 40));

        //END alias input Styling
	    
	    
	    tickForename.setForeground(mainBGColour);
	    tickForename.setFont(labelFont);
	    tickSurname.setForeground(mainBGColour);
	    tickSurname.setFont(labelFont);
	    tickAlias.setForeground(mainBGColour);
	    tickAlias.setFont(labelFont);
	    
	    //START nextBTN styling
	    nextBtn.setText("Next");
	    nextBtn.setOpaque(true);
	    nextBtn.setFont(labelFont);
	    nextBtn.setBackground(blue);
	    nextBtn.setForeground(Color.WHITE);
	    
	    nextBtn.setFocusPainted(false);
	    nextBtn.setBorderPainted(false);

	    nextBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	    
	    nextBtn.addMouseListener(new java.awt.event.MouseAdapter() { 
	    	
	    	public void mouseEntered(java.awt.event.MouseEvent evt) {
	            nextBtn.setBackground(Color.WHITE);
	            nextBtn.setForeground(blue);
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            nextBtn.setBackground(blue);
	            nextBtn.setForeground(Color.WHITE);
	        }
	    	
	    });
	   
	    
	    
	    
	    newDevicePanel.add(newDeviceTitle, "wrap, height 100, span, align center ");
	    newDevicePanel.add(forename, "width 100, align center");
	    newDevicePanel.add(forenameTA, " width 300, align center");
	    newDevicePanel.add(tickForename, "wrap, width 20");
	    newDevicePanel.add(forenameHelper, "skip, wrap, align center, width 300, gapbottom 20");
	    
	    newDevicePanel.add(surname, "width 100, align center");
	    newDevicePanel.add(surnameTA, "width 300, align center");
	    newDevicePanel.add(tickSurname, "wrap, width 20");
	    newDevicePanel.add(surnameHelper, "skip, wrap, align center, width 300, gapbottom 20");
	   
	    
	    newDevicePanel.add(ip, "width 100, align center, gapbottom 20");
	    newDevicePanel.add(ipTA, "wrap, width 300, align center, gapbottom 20");
	    
	    
	    newDevicePanel.add(alias, "width 100, align center");
	    newDevicePanel.add(aliasTA, "width 300, align center");
	    newDevicePanel.add(tickAlias, "wrap, width 20");
	    newDevicePanel.add(aliasHelper, "skip, wrap, align center, width 300, gapbottom 10");
	  
	    
	    newDevicePanel.add(nextBtn, "span, width 300, height 40, align center, gaptop 50");
	    
		
	    
	    newDeviceFrame.add(newDevicePanel);
		
	    newDeviceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newDeviceFrame.pack();
		newDeviceFrame.setVisible(true);
		
		nextBtn.addActionListener(new ActionListener() {
		    	
				
			public void actionPerformed(ActionEvent e)	{
	    		Boolean hasError = null;
	    		//error checking
	    		
	    		if(forenameTA.getText().length() < 1 || forenameTA.getText().length() > forenameLength) {
	    			forenameHelper.setText("Please enter your forename, must with within 32 characters");
	    			forenameHelper.setForeground(red);
	    			hasError = true;
	    		} else {
	    			forenameHelper.setText("");
	    				
	    			tickForename.setForeground(blue);
	    			hasError = false;
	    		}
	    		
	    		if(surnameTA.getText().length() < 1 || surnameTA.getText().length() > surnameLength) {
	    			surnameHelper.setText("Please enter your surname, must with within 32 characters");
	    			surnameHelper.setForeground(red);
	    			hasError = true;
	    		} else {
	    			surnameHelper.setText("");
	   
	    			tickSurname.setForeground(blue);
	    			hasError = false;
	    		}
	    		
	    		if(aliasTA.getText().length() < 1 || aliasTA.getText().length() > aliasLength) {
	    			aliasHelper.setText("Please enter your alias, must with within 16 characters");
	    			aliasHelper.setForeground(red);
	    			hasError = true;
	    			
	    			
	    		} else {
	    	
	    			aliasHelper.setText("");
	   
	    			tickAlias.setForeground(blue);
	    			hasError = false;
	    		}
	    		
	    		if(hasError == false)
	    			newDeviceViewComplete = true;
	  
	    	}
	    });
	
	}
	
	public void settingUpView(String[] data) {
		setUpFrame.dispose();
	}
	public void updateStatus(String status) {
		
		this.status.setText(status);
		
	}
	public boolean newDeviceSetUp() {
		return this.newDeviceViewComplete;
	}
	public String[] getAllDetails() {
		String[] returnVals = new String[3];
		returnVals[0] = this.forenameTA.getText();
		returnVals[1] = this.surnameTA.getText();
		returnVals[2] = this.aliasTA.getText();
		
		return returnVals;
	}
}
