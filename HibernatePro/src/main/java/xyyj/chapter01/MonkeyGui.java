package xyyj.chapter01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonkeyGui extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JComboBox<String> genderComboBox;
	private BusinessService2 bService = new BusinessService2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonkeyGui frame = new MonkeyGui();
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
	public MonkeyGui() {
		setTitle("Huaguoshan Information System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nameLabel);
		
		nameTextField = new JTextField();
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(ageLabel);
		
		ageTextField = new JTextField();
		contentPane.add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(genderLabel);
		
		genderComboBox = new JComboBox<String>();
		genderComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"M", "F"}));
		contentPane.add(genderComboBox);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			String gender = (String)genderComboBox.getSelectedItem();
			
			public void actionPerformed(ActionEvent e) {
				Monkey monkey = new Monkey(nameTextField.getText().trim(), 
						Integer.parseInt(ageTextField.getText().trim()), gender.charAt(0));
				
				bService.saveMonkey(monkey);
			}
		});
		contentPane.add(saveButton);
	}

}
