import static java.math.BigDecimal.ROUND_HALF_UP;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import javax.swing.ComboBoxModel;
import java.nio.charset.StandardCharsets;


public class UserInformationForm {
	private JFrame frame;
	private JRadioButton rdbtnAgreement;
	public JTextField nameInput;
	public JTextField surenameInput;
	public JComboBox<String> ageInput;
	public JComboBox<String> livingPlaceInput;
	public JComboBox<String> universityProgramComboBox;
	public JComboBox<String> schoolLevelStatusInput;
	private JComboBox<String> genderInput;
	private JComboBox<String> versionInput;
	
	/**Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformationForm window = new UserInformationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** Create the application.*/
	public UserInformationForm() {
		initialize();
	}
	
	/*** Initialize the contents of the frame. */
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(screenSize.width/6*1, screenSize.height/12*1,982, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*//Verzija
		JLabel versionText = new JLabel("Verzija");
		versionText.setBounds(30, 36, 127, 16);
		frame.getContentPane().add(versionText);
		versionInput = new JComboBox<String>(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		versionInput.setSelectedIndex(0);
		versionInput.setBounds(110, 34, 310, 22);
		frame.getContentPane().add(versionInput);		*/
		
		//Spol
		JLabel genderText = new JLabel("Spol");
		genderText.setBounds(32, 135, 52, 16);
		frame.getContentPane().add(genderText);
		genderInput = new JComboBox<String>(new DefaultComboBoxModel(new String[] {"Izberi spol", "M", "Ž"}));
		genderInput.setSelectedIndex(0);
		genderInput.setBounds(145, 127, 310, 25);
		frame.getContentPane().add(genderInput);
		
		//Starost
		String[] ageValues = new String[] {"Starost", "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"};
		DefaultComboBoxModel<String> bDateComboModel = new DefaultComboBoxModel<String>(ageValues);
		ageInput = new JComboBox<String>(bDateComboModel);
		ageInput.setSelectedIndex(0);
		ageInput.setBounds(145, 99, 310, 22);
		frame.getContentPane().add(ageInput);
		JLabel ageText = new JLabel("Starost");
		ageText.setBounds(32, 106, 127, 16);
		frame.getContentPane().add(ageText);
		
		//Izobrazba
		String[] MiddleSchoolValues = new String[] {"Izberi stopnjo", "osnovnošolska", "srednješolska", "višješolska", "diplomski študij", "magisterij", "doktorat"};
		DefaultComboBoxModel<String> MiddleSchoolBox = new DefaultComboBoxModel<String>(MiddleSchoolValues);
	    schoolLevelStatusInput = new JComboBox<String>(MiddleSchoolBox);
		schoolLevelStatusInput.setSelectedIndex(0);
		schoolLevelStatusInput.setBounds(145, 189, 310, 25);
		frame.getContentPane().add(schoolLevelStatusInput);
		JLabel schoolLevelText = new JLabel("Izobrazba");
		schoolLevelText.setBounds(32, 197, 91, 16);
		frame.getContentPane().add(schoolLevelText);
		
		
		//Bivalisce
		String[] livingPlaceValues = new String[] {"Izberi pokrajno", "Gorenjska","Dolenjska","Koroška","Notranjska","Obalno-kraška","Osrednjeslovenska","Zasavska","Savinjska","Podravska","Pomurska","Spodnjeposavska"};
		DefaultComboBoxModel<String> universityComboModel = new DefaultComboBoxModel<String>(livingPlaceValues);
		livingPlaceInput = new JComboBox<String>(universityComboModel);
		livingPlaceInput.setSelectedIndex(0);
		livingPlaceInput.setBounds(145, 158, 310, 25);
		frame.getContentPane().add(livingPlaceInput);
		/*livingPlaceInput.addItemListener(
				new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED && livingPlaceInput.getSelectedItem() == "Ekonomska fakulteta (EF)") {	
							universityProgramComboBox.setVisible(true);
						}else {
							universityProgramComboBox.setVisible(false);
						}
					}
				}
		);*/
		JLabel livingPlaceText = new JLabel("Bivališče");
		livingPlaceText.setBounds(32, 166, 127, 16);
		frame.getContentPane().add(livingPlaceText);
		
		//Št ur, ki jih preživijo za 
		String[] SpendTimeOnPCValues = new String[] {"Izberi", "Manj kot 1h na dan", "Med 1h in 4h na dan", "Več kot 4h na dan"};
		DefaultComboBoxModel<String> SpendTimeOnPCBox = new DefaultComboBoxModel<String>(SpendTimeOnPCValues);
		final JComboBox<String> spendTimeOnPCInput = new JComboBox<String>(SpendTimeOnPCBox);
		spendTimeOnPCInput.setSelectedIndex(0);
		spendTimeOnPCInput.setBounds(434, 359, 300, 25);
		frame.getContentPane().add(spendTimeOnPCInput);
		JLabel spendTimeOnPCText = new JLabel("Koliko časa povprečno\r\n preživiš za računalnikom? ");
		spendTimeOnPCText.setBounds(30, 355, 340, 33);
		frame.getContentPane().add(spendTimeOnPCText);

		//Slepo tipkanje
		String[] BlindTypingValues = new String[] {"Izberi", "Ne", "Da"};
		DefaultComboBoxModel<String>  BlindTypingBox = new DefaultComboBoxModel<String>(BlindTypingValues);
		final JComboBox<String> blindTypinglnput = new JComboBox<String>(BlindTypingBox);
		blindTypinglnput.setSelectedIndex(0);
		blindTypinglnput.setBounds(145, 285, 507, 25);
		frame.getContentPane().add(blindTypinglnput);
		JLabel blindTypingText = new JLabel("Ali slepo tipkaš?");
		blindTypingText.setBounds(32, 289, 304, 16);
		frame.getContentPane().add(blindTypingText);
		
		
		//st rok ki jih uporablja za tipkanje
		String[] numHandsValues = new String[] {"Izberi", "eno roko za pisanje po tipkovnici", "obe roki za pisanje po tipkovnici"};
		DefaultComboBoxModel<String>  numHandsBox = new DefaultComboBoxModel<String>(numHandsValues);
		final JComboBox<String> numHandsInput = new JComboBox<String>(numHandsBox);
		numHandsInput.setSelectedIndex(0);
		numHandsInput.setBounds(145, 221, 310, 22);
		frame.getContentPane().add(numHandsInput);
		JLabel numHandsText = new JLabel("Uporabljam");
		numHandsText.setBounds(32, 228, 127, 16);
		frame.getContentPane().add(numHandsText);	
		
		
		//desnicar ali levicar
		String[] handOrientationValues = new String[] {"Izberi", "levičar", "desničar"};
		DefaultComboBoxModel<String>  handOrientationBox = new DefaultComboBoxModel<String>(handOrientationValues);
		final JComboBox<String> handOrientationInput = new JComboBox<String>(handOrientationBox);
		handOrientationInput.setSelectedIndex(0);
		handOrientationInput.setBounds(145, 253, 310, 22);
		frame.getContentPane().add(handOrientationInput);
		JLabel handOrientationText = new JLabel("Sem");
		handOrientationText.setBounds(32, 260, 52, 16);
		frame.getContentPane().add(handOrientationText);
		
		//znanje anglescine
		String[] angValues = new String[] {"Izberi", "1", "2", "3", "4", "5"};
		DefaultComboBoxModel<String>  angBox = new DefaultComboBoxModel<String>(angValues);
		final JComboBox<String> angInput = new JComboBox<String>(angBox);
		angInput.setSelectedIndex(0);
		angInput.setBounds(434, 320, 300, 25);
		frame.getContentPane().add(angInput);
		JLabel numAng = new JLabel("Kako bi ocenili svoje znanje angleščine, pri čemer je 5 najboljše?");
		numAng.setBounds(32, 320, 392, 25);
		frame.getContentPane().add(numAng);
		
		//SOGLASJE
		rdbtnAgreement = new JRadioButton("Potrjujem, da se pridobljene podatke lahko uporabi v magisterski nalogi z naslovom \"RAZVRŠČANJE \r\nPORABNIKOV NA PODLAGI VZORCEV TIPKANJA\" za raziskavalne namene.");
		rdbtnAgreement.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rdbtnAgreement.setBounds(21, 381, 922, 73);
		frame.getContentPane().add(rdbtnAgreement);
		
		
        //SPOROCILO
		final JLabel lblErrorMsg = new JLabel("Error Msg");
		lblErrorMsg.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		lblErrorMsg.setForeground(Color.RED);
		lblErrorMsg.setVisible(false);
		lblErrorMsg.setBounds(145, 440, 798, 54);
		frame.getContentPane().add(lblErrorMsg);

		//SUBMIT BTN
		JButton btnStart = new JButton("Za\u010Dni");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String userGender = genderInput.getSelectedItem().toString();
				String userBirthYear = ageInput.getSelectedItem().toString();
				String userShoolLevel = schoolLevelStatusInput.getSelectedItem().toString();
				String userLivingPlace = livingPlaceInput.getSelectedItem().toString();
				String userSpendTimeOnPC = spendTimeOnPCInput.getSelectedItem().toString();
				String userBlindTyping = blindTypinglnput.getSelectedItem().toString();
				String userNumHands = numHandsInput.getSelectedItem().toString();
				String userHandOrientation = handOrientationInput.getSelectedItem().toString();
				String userAng = angInput.getSelectedItem().toString();
				//String userVersion = versionInput.getSelectedItem().toString();
				
				if(userBirthYear.equals("Starost")) {
					lblErrorMsg.setText("Izpolnite polje: Starost");
					lblErrorMsg.setVisible(true);
				}else if(userGender.equals("Izberi spol")) {
					lblErrorMsg.setText("Izpolnite polje: Spol");
					lblErrorMsg.setVisible(true);
				}else if(userLivingPlace.equals("Izberi pokrajno")) {
					lblErrorMsg.setText("Izpolnite polje: Bivalisce");
					lblErrorMsg.setVisible(true);
				}else if(userShoolLevel.equals("Izberi stopnjo")) {
					lblErrorMsg.setText("Izpolnite polje: Izobrazba");
					lblErrorMsg.setVisible(true);
				}else if(userSpendTimeOnPC.equals("Izberi")) {
					lblErrorMsg.setText("Izpolnite polje:Koliko casa povprecno prezivis za racunalnikom?");
					lblErrorMsg.setVisible(true);
				}else if(userBlindTyping.equals("Izberi")) {
					lblErrorMsg.setText("Izpolnite polje:Ali slepo tipkas?");
					lblErrorMsg.setVisible(true);
				 }else if(userNumHands.equals("Izberi")) {
						lblErrorMsg.setText("Izpolnite polje:Uporabljam");
						lblErrorMsg.setVisible(true);
				 }else if(userHandOrientation.equals("Izberi")) {
						lblErrorMsg.setText("Izpolnite polje:Sem");
						lblErrorMsg.setVisible(true);
				 }else if(userAng.equals("Izberi")) {
						lblErrorMsg.setText("Izpolnite polje:Kako bi ocenili svoje znanje anglescine, pri cemer je 5 najboljse?");
						lblErrorMsg.setVisible(true);
				 }else if(!rdbtnAgreement.isSelected()) {
					 lblErrorMsg.setText("Ali se strinjate s pogoji?");
					lblErrorMsg.setVisible(true);
				 }else{  
						 switch (userGender) {
						    case "M":
						    	userGender = "0";
						        break;
						    case "Ž":
						    	userGender = "1";
						        break;
						    default:
						    	userGender = "Napaka";
						  }
					 
						 switch (userLivingPlace) {
						    case "Gorenjska":
						    	userLivingPlace = "0";
						        break;
						    case "Dolenjska":
						    	userLivingPlace = "1";
						        break;
						    case "Koroška":
						    	userLivingPlace = "2";
						        break;
						    case "Notranjska":
						    	userLivingPlace = "3";
						        break;
						    case "Obalno-kraška":
						    	userLivingPlace = "4";
						        break;  
						    case "Osrednjeslovenska":
						    	userLivingPlace = "5";
						        break;
						    case "Zasavska":
						    	userLivingPlace = "6";
						        break;
						    case "Savinjska":
						    	userLivingPlace = "7";
						        break;
						    case "Podravska":
						    	userLivingPlace = "8";
						        break;
						    case "Pomurska":
						    	userLivingPlace = "9";
						        break;
						    case "Spodnjeposavska":
						    	userLivingPlace = "10";
						        break;
						    default:
						    	userLivingPlace = "Napaka";
						  }
						 
						 switch (userShoolLevel) {
						    case "osnovnošolska":
						    	userShoolLevel = "0";
						        break;
						    case "srednješolska":
						    	userShoolLevel = "1";
						        break;
						    case "višješolska":
						    	userShoolLevel = "2";
						        break;
						    case "diplomski študij":
						    	userShoolLevel = "3";
						        break;
						    case "magisterij":
						    	userShoolLevel = "4";
						        break;    
						    case "doktorat":
						    	userShoolLevel = "5";
						        break;  
						    default:
						    	userShoolLevel = "Napaka";
						  }
						 
						  switch (userSpendTimeOnPC) {
						    case "Manj kot 1h na dan":
						    	userSpendTimeOnPC = "0";
						        break;
						    case "Med 1h in 4h na dan":
						    	userSpendTimeOnPC = "1";
						        break;
						    case "Več kot 4h na dan":
						    	userSpendTimeOnPC = "2";
						        break;
						    default:
						    	userSpendTimeOnPC = "Napaka";
						  }
						  
						  switch (userBlindTyping) {
						    case "Da":
						    	userBlindTyping = "0";
						        break;
						    case "Ne":
						    	userBlindTyping = "1";
						        break;
						    default:
						    	userBlindTyping = "Napaka";
						  }
						  
						  switch (userNumHands) {
						    case "eno roko za pisanje po tipkovnici":
						    	userNumHands = "0";
						        break;
						    case "obe roki za pisanje po tipkovnici":
						    	userNumHands = "1";
						        break;
						    default:
						    	userNumHands = "Napaka";
						  }
						  
						  switch (userHandOrientation) {
						    case "levičar":
						    	userHandOrientation = "0";
						        break;
						    case "desničar":
						    	userHandOrientation = "1";
						        break;
						    default:
						    	userHandOrientation = "Napaka";
						  }
					 
					 	UserInfo userInfo = new UserInfo(userGender, userBirthYear, userShoolLevel, userLivingPlace, userSpendTimeOnPC, userBlindTyping , userNumHands,userHandOrientation,userAng );
				        TestTypingForm testTypingForm = new TestTypingForm("1");
				        testTypingForm.main(userInfo);
				        testTypingForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				        testTypingForm.setVisible(true);
					    frame.setVisible(false);	
				 }
			}
		});
		btnStart.setBounds(30, 456, 97, 25);
		frame.getContentPane().add(btnStart);
		
		JLabel instructions = new JLabel("Izpolnite spodnjo anketo nato pa pritisnite tipko Zacni. Odprla se vam bo nova stran kjer boste prepisovali besedilo. Pri prepisovanju ne uporabljajte miške. ");
		instructions.setBounds(32, 49, 907, 16);
		frame.getContentPane().add(instructions);
		
	}
}
