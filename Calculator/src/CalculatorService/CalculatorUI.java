package CalculatorService;

import java.awt.event.*;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NumberConventerService.NumberConverterService;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;




public class CalculatorUI extends JFrame {

	private JPanel contentPane;
	private JTextField firstNumberTextField;
	private JTextField secondNumberTextField;
	private JTextField resultTextField;
	Locale tr = new Locale("tr", "TR");
	Locale en = new Locale("en","EN");
	Locale currentLocale = tr;
	
	public CalculatorUI(NumberConverterService numberConverter) {
		setTitle("Case");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstNumberTextField = new JTextField();
		firstNumberTextField.setBounds(249, 129, 307, 20);
		contentPane.add(firstNumberTextField);
		firstNumberTextField.setColumns(10);
		
		secondNumberTextField = new JTextField();
		secondNumberTextField.setBounds(249, 182, 307, 20);
		contentPane.add(secondNumberTextField);
		secondNumberTextField.setColumns(10);
		
		resultTextField = new JTextField();
		resultTextField.setBounds(249, 239, 307, 20);
		contentPane.add(resultTextField);
		resultTextField.setColumns(10);
		
		final JLabel lblNewLabel = new JLabel("Birinci Sayı");
		lblNewLabel.setBounds(67, 132, 172, 17);
		contentPane.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("İkinci Sayı");
		lblNewLabel_1.setBounds(67, 185, 172, 14);
		contentPane.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Sonuç");
		lblNewLabel_2.setBounds(67, 242, 172, 14);
		contentPane.add(lblNewLabel_2);
		
		final JButton multiplyBtn = new JButton("Çarp");
		multiplyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = firstNumberTextField.getText();
		        String num2 = secondNumberTextField.getText();
		        int number1 = numberConverter.convertToNumber(num1, currentLocale);
		        int number2 = numberConverter.convertToNumber(num2, currentLocale);
		        System.out.println("----mult-----");
		        System.out.println(number1*number2);
		        System.out.println("-----------");
		        String result  =   numberConverter.convertToString(number1*number2,currentLocale);
		        resultTextField.setText(result);
			}
		});
		multiplyBtn.setBounds(89, 306, 89, 23);
		contentPane.add(multiplyBtn);
		
		final JButton divideBtn = new JButton("Böl");
		divideBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = firstNumberTextField.getText();
		        String num2 = secondNumberTextField.getText();
		        int number1 = numberConverter.convertToNumber(num1, currentLocale);
		        int number2 = numberConverter.convertToNumber(num2, currentLocale);
		        System.out.println("-----div-----");
		        System.out.println(number1/number2);
		        System.out.println("-----------");
		        String result  =   numberConverter.convertToString(number1/number2,currentLocale);
		        resultTextField.setText(result);
			}
		});
		divideBtn.setBounds(213, 306, 89, 23);
		contentPane.add(divideBtn);
		
		final JButton subBtn = new JButton("Çıkar");
		subBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = firstNumberTextField.getText();
		        String num2 = secondNumberTextField.getText();
		        int number1 = numberConverter.convertToNumber(num1, currentLocale);
		        int number2 = numberConverter.convertToNumber(num2, currentLocale);
		        System.out.println("----sub-----");
		        System.out.println(number1-number2);
		        System.out.println("-----------");
		        String result  =   numberConverter.convertToString(number1-number2,currentLocale);
		        resultTextField.setText(result);
			}
		});
		subBtn.setBounds(351, 306, 89, 23);
		contentPane.add(subBtn);
		
		final JButton addBtn = new JButton("Topla");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = firstNumberTextField.getText();
		        String num2 = secondNumberTextField.getText();
		        int number1 = numberConverter.convertToNumber(num1, currentLocale);
		        int number2 = numberConverter.convertToNumber(num2, currentLocale);
		        System.out.println("----add------");
		        System.out.println(number1+number2);
		        System.out.println("-----------");
		        String result  =   numberConverter.convertToString(number1+number2,currentLocale);
		        resultTextField.setText(result);
			}
		});
		addBtn.setBounds(491, 306, 89, 23);
		contentPane.add(addBtn);
		
		
		
		final JButton languageBtn = new JButton("En");
		languageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentLocale.equals(en)) {
					  currentLocale = tr;
				      languageBtn.setText("En");
				      addBtn.setText("Topla");
				      subBtn.setText("Cıkar");
				      divideBtn.setText("Böl");
				      multiplyBtn.setText("Çarp");
				      lblNewLabel.setText("Birinci Sayı");
				      lblNewLabel_1.setText("İkinci Sayı");
				      lblNewLabel_2.setText("Sonuç");
				    } else {
				    	currentLocale = en;
				    	languageBtn.setText("Tr");
				    	addBtn.setText("Add");
				    	subBtn.setText("Sub");
				    	divideBtn.setText("Divide");
				    	multiplyBtn.setText("Multiply");
				    	lblNewLabel.setText("First number");
				    	lblNewLabel_1.setText("Second number");
				    	lblNewLabel_2.setText("Result ");
				    }
			}
		});
		languageBtn.setBounds(491, 26, 65, 31);
		contentPane.add(languageBtn);
	}
}
