
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;



public class ChocAnDirectory extends JFrame {

	/**
	 * 
	 */
	int openedFrame = 0;
	private static final long serialVersionUID = 1L;
	private User currentEntry;
	private Directory directory;
	private List <User> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;
	
	private JPanel contentPane;
	private final JLabel lblId = new JLabel("ID: ");
	private final JTextField textField = new JTextField();
	private final JLabel lblFirstName = new JLabel("First Name:");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblLastName = new JLabel("Last Name:");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblStreetAddress = new JLabel("Street Address:");
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblCity = new JLabel("City:");
	private final JTextField textField_4 = new JTextField();
	private final JLabel lblState = new JLabel("State:");
	private final JTextField textField_5 = new JTextField();
	private final JLabel lblZipCode = new JLabel("Zip Code:");
	private final JTextField textField_6 = new JTextField();
	private final JLabel lblType = new JLabel("Type Member/Provider:");
	private final JTextField textField_7 = new JTextField();
	private final JButton btnInsertNewEntry = new JButton("Insert New Entry");
	private final JTextField textField_8 = new JTextField();
	private final Panel panel = new Panel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblOf = new JLabel("of");
	private final JButton btnNewButton_1 = new JButton("Provider Report");
	private final JButton btnEftDataReport = new JButton("EFT Data Report");
	private final JButton Clearbutton = new JButton("Clear");
	private final JTextField Index = new JTextField();
	private final JTextField MaxIndex = new JTextField();
	private final JButton btnNewButton = new JButton("Add Service");
	
	
	public ChocAnDirectory() {	
		
		initGUI();
	}
	
	private void initGUI() {
		directory = new Directory();
		Index.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				IndexActionPerformed(evt);
			}
		});
		
		Index.setBounds(201, 22, 53, 42);
		Index.setColumns(10);
		Index.setHorizontalAlignment(JTextField.CENTER);
		textField_7.setBounds(189, 353, 142, 28);
		textField_7.setColumns(10);
		textField_6.setBounds(189, 317, 142, 28);
		textField_6.setColumns(10);
		textField_4.setBounds(189, 237, 142, 28);
		textField_4.setColumns(10);
		textField_3.setBounds(189, 198, 276, 28);
		textField_3.setColumns(10);
		textField_2.setBounds(189, 161, 142, 26);
		textField_2.setColumns(10);
		textField_1.setBounds(189, 122, 142, 28);
		textField_1.setColumns(10);
		textField.setBounds(189, 83, 142, 28);
		textField.setColumns(10);
		
		setTitle("ChocAn Directory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblId.setBounds(27, 90, 46, 14);
		contentPane.add(lblId);
		contentPane.add(textField);
		
		lblFirstName.setBounds(27, 128, 81, 16);
		contentPane.add(lblFirstName);
		contentPane.add(textField_1);
		
		lblLastName.setBounds(27, 166, 81, 16);
		contentPane.add(lblLastName);
		contentPane.add(textField_2);
		
		lblStreetAddress.setBounds(29, 204, 91, 16);
		contentPane.add(lblStreetAddress);
		contentPane.add(textField_3);
		
		lblCity.setBounds(27, 243, 55, 16);
		contentPane.add(lblCity);
		contentPane.add(textField_4);
		
		lblState.setBounds(27, 283, 55, 16);
		contentPane.add(lblState);
		textField_5.setBounds(189, 276, 65, 30);
		contentPane.add(textField_5);
		
		lblZipCode.setBounds(27, 329, 55, 16);
		contentPane.add(lblZipCode);
		contentPane.add(textField_6);
		
		lblType.setBounds(27, 356, 152, 22);
		contentPane.add(lblType);
		contentPane.add(textField_7);
		
		final JButton btnPrevious = new JButton("Previous");
		final JButton btnNext = new JButton("Next");
				
		btnNext.setEnabled(false);
		btnPrevious.setEnabled(false);
		Index.setEnabled(false);
		
		JButton btnBrowseAllProviders = new JButton("Browse All Providers");
		btnBrowseAllProviders.setBounds(27, 429, 164, 43);
		btnBrowseAllProviders.addActionListener( 
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt){
						btnNext.setEnabled(true);
						btnPrevious.setEnabled(true);
						Index.setEnabled(true);
						btnBrowseAllProvidersActionPerformed(evt);
					}
				});
		contentPane.add(btnBrowseAllProviders);
		
		JButton btnBrowseAllMembers = new JButton("Browse All Members");
		btnBrowseAllMembers.setBounds(222, 429, 152, 43);
		btnBrowseAllMembers.addActionListener( 
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt){
						btnNext.setEnabled(true);
						btnPrevious.setEnabled(true);
						Index.setEnabled(true);
						btnBrowseAllMembersActionPerformed(evt);
					}
				});
		contentPane.add(btnBrowseAllMembers);
		
		
		btnPrevious.setBounds(100, 30, 91, 26);
		btnPrevious.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) {
						btnPreviousActionPerformed(evt);
					}
		});
		contentPane.add(btnPrevious);
		
		
		btnNext.setBounds(384, 30, 91, 26);
		btnNext.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnNextActionPerformed(evt);
					}
		});
		contentPane.add(btnNext);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(709, 10, 182, 394);
		
		contentPane.add(panel);
		panel.setLayout(null);
		btnInsertNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(false);
				Index.setEnabled(false);
				btnInsertNewEntryActionPerformed(evt);
			}
		});
		btnInsertNewEntry.setBounds(10, 11, 164, 43);
		panel.add(btnInsertNewEntry);
		
		JButton btnUpdateEntry = new JButton("UpDate Entry");
		btnUpdateEntry.setBounds(10, 65, 164, 43);
		panel.add(btnUpdateEntry);
		
		JButton btnDeleteEntry = new JButton("Delete Entry");
		btnDeleteEntry.setBounds(12, 119, 162, 43);
		panel.add(btnDeleteEntry);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//ServiceActionPerformed(evt);
			}
		});
		btnNewButton_1.setBounds(10, 227, 164, 49);
		
		panel.add(btnNewButton_1);
		btnEftDataReport.setBounds(10, 285, 164, 43);
		
		panel.add(btnEftDataReport);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					//btnAddServiceActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(10, 173, 164, 43);
		
		panel.add(btnNewButton);
		
		JButton btnPrintSelectedType = new JButton("Member Report");
		btnPrintSelectedType.setBounds(10, 339, 164, 43);
		panel.add(btnPrintSelectedType);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, btnInsertNewEntry, btnDeleteEntry, btnUpdateEntry, btnBrowseAllProviders, btnBrowseAllMembers, btnPrintSelectedType, btnPrevious, btnNext, lblId, lblFirstName, lblLastName, lblStreetAddress, lblCity, lblState, lblZipCode, lblType}));
		
		btnDeleteEntry.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnNext.setEnabled(false);
						btnPrevious.setEnabled(false);
						Index.setEnabled(false);
						btnDeleteEntryActionPerformed(evt);
					}
		});
		btnUpdateEntry.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnNext.setEnabled(false);
						btnPrevious.setEnabled(false);
						Index.setEnabled(false);
						btnUpdateEntryActionPerformed(evt);
					}
		});
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(26, 483, 601, 48);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnFind = new JButton("Search");
		btnFind.setBounds(476, 11, 97, 23);
		panel_1.add(btnFind);
		
		JLabel lblFindById = new JLabel("Search User by ID:");
		lblFindById.setBounds(10, 4, 171, 37);
		panel_1.add(lblFindById);
		textField_8.setBounds(165, 8, 301, 28);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		btnFind.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnNext.setEnabled(false);
						btnPrevious.setEnabled(false);
						Index.setEnabled(false);
						btnFindActionPerformed(evt);
			}
		});
		lblOf.setBounds(271, 36, 16, 14);
		
		contentPane.add(lblOf);
		Clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(false);
				Index.setEnabled(false);
				ClearbuttonActionPerformed(evt);
			}
		});
		Clearbutton.setBounds(520, 30, 91, 26);
		contentPane.add(Clearbutton);
		contentPane.add(Index);
		MaxIndex.setHorizontalAlignment(SwingConstants.CENTER);
		MaxIndex.setColumns(10);
		MaxIndex.setBounds(297, 22, 53, 42);
		MaxIndex.setEditable(false);
		contentPane.add(MaxIndex);
}

// Handles call when update button is invoked 
protected void btnUpdateEntryActionPerformed(ActionEvent evt) {
	
	if(textField_7.getText().equals("Member")){
		
		directory.updateEntry(textField.getText(),textField_1.getText(),textField_2.getText(), textField_3.getText(), 
				textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText());
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		MaxIndex.setText("");
		Index.setText("");
		JOptionPane.showMessageDialog(null, "Member was updated Successfully!");
	}else{
		directory.updateEntry(textField.getText(),textField_1.getText(),textField_2.getText(), textField_3.getText(), 
				textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText());
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		MaxIndex.setText("");
		Index.setText("");
		JOptionPane.showMessageDialog(null, "Provider was updated Successfully!");
	}
	

}

//Handles call when Clear button is invoked 
protected void ClearbuttonActionPerformed(ActionEvent evt) {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		MaxIndex.setText("");
		Index.setText("");
		
	}
// Handles call when insert button is invoked 
protected void btnInsertNewEntryActionPerformed(ActionEvent evt) {
	
	int CHK  = directory.CheckDuplicate(textField_1.getText(),textField_2.getText());
	
	if(CHK == 1){
		JOptionPane.showMessageDialog(this, "Member/Provider already exists!", "Error", JOptionPane.PLAIN_MESSAGE);
	}else{
		int result = directory.addUser(textField_1.getText(),textField_2.getText(), textField_3.getText(), 
				textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText());
	
	
	System.out.println(result);
	if(result == 1){
		if(textField_7.getText().equals("Member") || textField_7.getText().equals("member")){
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
		//	textArea.setText("");
			MaxIndex.setText("");
			Index.setText("");
			JOptionPane.showMessageDialog(this,"Member has been added!","Error",JOptionPane.PLAIN_MESSAGE);
		}else{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			//textArea.setText("");
			MaxIndex.setText("");
			Index.setText("");
			JOptionPane.showMessageDialog(this,"Provider has been added!","Error",JOptionPane.PLAIN_MESSAGE);
		}
	}else{
		
		JOptionPane.showMessageDialog(this,"Provider/Member has not been added! \nDupplcate ID! \nPlease check it again !","Error",JOptionPane.PLAIN_MESSAGE);
	}
	}
			
		
	}

 // Handles call when delete button is invoked 
protected void btnDeleteEntryActionPerformed(ActionEvent evt) {
		int result = directory.DeleteUser(textField.getText());
		
		if(result == 1){
			if(textField_7.getText().equals("Member") || textField_7.getText().equals("member")){
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				MaxIndex.setText("");
				Index.setText("");
				JOptionPane.showMessageDialog(this,"Member has been deleted!","Error",JOptionPane.PLAIN_MESSAGE);
			}else{
			
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				MaxIndex.setText("");
				Index.setText("");
				JOptionPane.showMessageDialog(this,"Provider has been deleted!","Error",JOptionPane.PLAIN_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(this,"Provider/Member has not been deleted!","Error",JOptionPane.PLAIN_MESSAGE);
		}
		
	}

//Handles call when next button is invoked 
private void btnNextActionPerformed(ActionEvent evt){
			
			currentEntryIndex++;
			if(currentEntryIndex >= numberOfEntries){
				currentEntryIndex = 0;
				textFieldAction(evt);			
			}
			Index.setText("" + (currentEntryIndex + 1));
			IndexActionPerformed(evt);
		}

//Handles call when previous button is invoked 
private void btnPreviousActionPerformed(ActionEvent evt){
		
		currentEntryIndex--;
		if(currentEntryIndex < 0){
			currentEntryIndex = numberOfEntries - 1;
			textFieldAction(evt);
		}
		Index.setText("" + (currentEntryIndex + 1));
		IndexActionPerformed(evt);
	}

//Handles call when Browse Provider button is invoked 
private void btnBrowseAllProvidersActionPerformed(ActionEvent evt){
		
		try{
			results = directory.getAllProviders();
			numberOfEntries = results.size();
			if (numberOfEntries != 0){
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				textField.setText("" + currentEntry.getIdChocAn());
				textField_1.setText(currentEntry.getfirstName());
				textField_2.setText(currentEntry.getlastName());
				textField_3.setText(currentEntry.getTheStreet());
				textField_4.setText(currentEntry.getTheCity());
				textField_5.setText(currentEntry.getTheState());
				textField_6.setText(currentEntry.getTheZip());
				textField_7.setText(currentEntry.getTheType());
				MaxIndex.setText("" + numberOfEntries);
				Index.setText("" + (currentEntryIndex + 1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

// Handles call when browse Member button is invoked 
private void btnBrowseAllMembersActionPerformed(ActionEvent evt){
		
		try{
			results = directory.getAllMembers();
			numberOfEntries = results.size();
			if (numberOfEntries != 0){
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				textField.setText("" + currentEntry.getIdChocAn());
				textField_1.setText(currentEntry.getfirstName());
				textField_2.setText(currentEntry.getlastName());
				textField_3.setText(currentEntry.getTheStreet());
				textField_4.setText(currentEntry.getTheCity());
				textField_5.setText(currentEntry.getTheState());
				textField_6.setText(currentEntry.getTheZip());
				textField_7.setText(currentEntry.getTheType());
				MaxIndex.setText("" + numberOfEntries);
				Index.setText("" + (currentEntryIndex + 1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
//Handles call when find button is invoked 
private void btnFindActionPerformed(ActionEvent evt){
		
		results = directory.getByID(textField_8.getText());
		numberOfEntries = results.size();
		
		if( numberOfEntries != 0){
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
			textField.setText("" + currentEntry.getIdChocAn());
			textField_1.setText(currentEntry.getfirstName());
			textField_2.setText(currentEntry.getlastName());
			textField_3.setText(currentEntry.getTheStreet());
			textField_4.setText(currentEntry.getTheCity());
			textField_5.setText(currentEntry.getTheState());
			textField_6.setText(currentEntry.getTheZip());
			textField_7.setText(currentEntry.getTheType());
			MaxIndex.setText("" + numberOfEntries);
			Index.setText("" + (currentEntryIndex + 1));
		}else{
			
		}
	}
//Handles call when new test is entered text field 
private void textFieldAction(ActionEvent evt){
		
		if(numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
			currentEntry = results.get(currentEntryIndex);
			textField.setText("" + currentEntry.getIdChocAn());
			textField_1.setText(currentEntry.getfirstName());
			textField_2.setText(currentEntry.getlastName());
			textField_3.setText(currentEntry.getTheStreet());
			textField_4.setText(currentEntry.getTheCity());
			textField_5.setText(currentEntry.getTheState());
			textField_6.setText(currentEntry.getTheZip());
			textField_7.setText(currentEntry.getTheType());
			MaxIndex.setText("" + numberOfEntries);
			Index.setText("" + (currentEntryIndex + 1));
			
		}
	}
// Handles call when a new value is entered in index text field 
protected void IndexActionPerformed(ActionEvent evt) {
		currentEntryIndex = (Integer.parseInt(Index.getText()) - 1);
		
		if(numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
			currentEntry = results.get(currentEntryIndex);
			textField.setText("" + currentEntry.getIdChocAn());
			textField_1.setText(currentEntry.getfirstName());
			textField_2.setText(currentEntry.getlastName());
			textField_3.setText(currentEntry.getTheStreet());
			textField_4.setText(currentEntry.getTheCity());
			textField_5.setText(currentEntry.getTheState());
			textField_6.setText(currentEntry.getTheZip());
			textField_7.setText(currentEntry.getTheType());
			MaxIndex.setText("" + numberOfEntries);
			Index.setText("" + (currentEntryIndex + 1));
		}
	}

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChocAnDirectory frame = new ChocAnDirectory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
