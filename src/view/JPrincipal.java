package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Libro;
import controller.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileSystemView;

public class JPrincipal extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		
		Libro libro = new Libro();
		Controllers controller = new Controllers();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libro.setISSN(textField_1.getText().toString());
			}
		});
		textField_1.setBounds(228, 36, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libro.setAutor(textField.getText().toString());
			}
		});
		textField.setBounds(228, 80, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISSN");
		lblNewLabel.setBounds(73, 42, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(73, 83, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("titulo");
		lblNewLabel_2.setBounds(73, 132, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("editorial");
		lblNewLabel_3.setBounds(73, 183, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("a\u00F1o");
		lblNewLabel_4.setBounds(73, 229, 46, 14);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libro.setTitulo(textField_2.getText().toString());
			}
		});
		textField_2.setBounds(228, 129, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libro.setAño(textField_3.getText().toString());
			}
		});
		textField_3.setBounds(228, 226, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pearson", "Cisco", "LNS", "Don Bosco", "Ayala"}));
		comboBox.setBounds(228, 179, 97, 22);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libro.setEditorial(comboBox.getSelectedItem().toString());
			}
		});
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Registrar Libro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libro.setISSN(textField_1.getText().toString());
				libro.setAutor(textField.getText().toString());
				libro.setTitulo(textField_2.getText().toString());
				libro.setAño(textField_3.getText().toString());
				
				controller.guardarLibro(libro);
//				System.out.print(libro.toString());
			}
		});
		btnNewButton.setBounds(73, 278, 115, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Libros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.verLibrosPrestados();
			}
		});
		btnNewButton_1.setBounds(73, 312, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sb = "TEST CONTENT";
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				JFileChooser chooser = new JFileChooser();
				 


				try (FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")){
					fw.write(sb.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(228, 278, 89, 23);
		panel.add(btnNewButton_2);
	}
}
