
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class CIS extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//LOG IN
	private static JPanel contentPane;
	JFrame frame;
	
	private final JLabel lblId = new JLabel("ID:");
	private final JLabel lblPassword = new JLabel("Password:");

	private static JTextField textID = new JTextField();
	private static JPasswordField passwordField = new JPasswordField(10);
	
	private final JCheckBox chckbxManager = new JCheckBox(" Manager");
	private final JLabel lblChocanInformationSystem = new JLabel("ChocAn Information System");
	private final JButton btnNewButton = new JButton("Log In");
	
//*********************USERNAME AND PASSWORD*******************************
	private static float inputID = 123;
	static int IDnum;
	@SuppressWarnings("unused")
	private static String password = "lehongminh";
//****************************CONTENT**************************************
	
	private static ChocAnDirectory form1;
//*****************************MAIN*****************************************
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Runnable
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
					CIS frame = new CIS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	/**
	 * Create the frame.
	 */
	public CIS() {
		this.frame = frame;
		textID.setBounds(155, 93, 143, 24);
		textID.setColumns(10);
		initGUI();
		
	}
//********************************INITIALIZATION*******************************************************
	
	private void initGUI() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblId.setBounds(52, 96, 46, 14);
		
		contentPane.add(lblId);
		lblPassword.setBounds(52, 133, 70, 14);
		contentPane.add(lblPassword);
		contentPane.add(textID);
		
		passwordField.setBounds(155, 124, 143, 24);
		passwordField.setEnabled(false);
		//Set FONT
		contentPane.add(passwordField);
//********************************CheckBox Listener*****************************************************	
		
		chckbxManager.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				passwordField.setEnabled(arg0.getStateChange() == ItemEvent.SELECTED);
			}
		});
		
		chckbxManager.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxManager.setBounds(155, 171, 97, 23);
		
		//FONT FOR CHECK
		contentPane.add(chckbxManager);
		lblChocanInformationSystem.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblChocanInformationSystem.setBounds(86, 25, 279, 45);
		
		contentPane.add(lblChocanInformationSystem);	
//******************************************************************************************************	
		
		//LOG-IN BUTTON ACTION
		btnNewButton.addActionListener(new Action1());
		btnNewButton.setBounds(297, 201, 97, 30);
		contentPane.add(btnNewButton);
	}
//********************************ACTION BUTTON LOGIN PERFORMANCE***************************************
	
	public static class Action1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
		        IDnum = Integer.parseInt(textID.getText());
		        if(inputID == IDnum && checkPassword("lehongminh")){
					if(form1 == null){
							form1 = new ChocAnDirectory();
							form1.show();
							
						}		
				}
		        else{
					JOptionPane.showMessageDialog(null, "Invalid ID or Password !!");
				}
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Please enter a correct ID or Password ");
		    }
		}
	}
//**************************************Check PassWord**************************************************
	private static boolean checkPassword(String corrPswd)
    {
        char[] input, correct;
        input = passwordField.getPassword();
        correct = corrPswd.trim().toCharArray();
        
        if (Arrays.equals(input, correct))
            return true;

        Arrays.fill(input, ' ');
        return false;
    }
}
