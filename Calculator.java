import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JTextField;
import java.util.Stack;

	/* This is a Java GUI replica of a Windows calculator in programmer mode.
	 * A stack is used to push and pop a String of operands and operators to and
	*  from the stack. When the the division and mod operations are entered peek
	*  is used to make sure a zero was not the previous number entered. When equal
	*  is entered the string is calculated using the ScriptEngineManager class. 
	*/
public class FinalCalculator2 {
	
	private JFrame frame;
	private final Action action = new SwingAction();
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine engine = mgr.getEngineByName("Js");
	Stack<String> myStringStack = new Stack<String>();
	String firstNumber;
	String secondNumber;
	String result;
	String operations;
	private Object math;
	private JTextField outPutText2;
	private JTextField hex_textField;
	private JTextField dec_textField_1;
	private JTextField bin_textField;
	private JTextField oct_textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgrammerCalculator window = new ProgrammerCalculator();
					window.frame.setVisible(true);
					//window.frame.setResizable(true);
					//window.frame.setEnabled(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalCalculator2() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Calculator");
		frame.getContentPane().setBackground(new Color(236, 236, 236));
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setBounds(0, 100, 484, 745);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.blue));
		frame.setLocationRelativeTo(null);
		//frame.setEnabled(true);
		
		JTextField outPutText = new JTextField("");
		//outPutText.setMinimumFractionDigits(2);
		outPutText.setEditable(false);
		outPutText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		outPutText.setOpaque(false);
		outPutText2.setColumns(20);
		
		outPutText2 = new JTextField();
		outPutText2.setEditable(false);
		outPutText2.setOpaque(false);
		outPutText2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		outPutText2.setBounds(76, 80, 376, 26);
		frame.getContentPane().add(outPutText2);
		outPutText2.setColumns(20);
		outPutText2.setHorizontalAlignment(SwingConstants.RIGHT);
		outPutText2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		hex_textField = new JTextField();
		hex_textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hex_textField.setEditable(false);
		hex_textField.setOpaque(false);
		hex_textField.setBounds(61, 174, 175, 26);
		frame.getContentPane().add(hex_textField);
		hex_textField.setColumns(20);
		hex_textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		dec_textField_1 = new JTextField();
		dec_textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dec_textField_1.setEditable(false);
		dec_textField_1.setOpaque(false);
		dec_textField_1.setBounds(61, 214, 175, 26);
		frame.getContentPane().add(dec_textField_1);
		dec_textField_1.setColumns(20);
		dec_textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		oct_textField = new JTextField();
		oct_textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		oct_textField.setEditable(false);
		oct_textField.setOpaque(false);
		oct_textField.setBounds(61, 254, 175, 26);
		frame.getContentPane().add(oct_textField);
		oct_textField.setColumns(20);
		oct_textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		bin_textField = new JTextField();
		bin_textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bin_textField.setEditable(false);
		bin_textField.setOpaque(false);
		bin_textField.setBounds(61, 294, 175, 26);
		frame.getContentPane().add(bin_textField);
		bin_textField.setColumns(20);
		bin_textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JButton button_0 = new JButton("0");
		button_0.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_0.setBackground(new Color(255, 255, 255));
		button_0.setBounds(241, 646, 75, 50);
		frame.getContentPane().add(button_0);
		
		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBounds(162, 592, 75, 50);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(new Color(255, 255, 255));
		button_2.setBounds(241, 592, 75, 50);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(new Color(255, 255, 255));
		button_3.setBounds(320, 592, 75, 50);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setAlignmentY(0.0f);
		button_4.setBounds(162, 538, 75, 50);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBackground(new Color(255, 255, 255));
		button_5.setAlignmentY(0.0f);
		button_5.setBounds(241, 538, 75, 50);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(new Color(255, 255, 255));
		button_6.setAlignmentY(0.0f);
		button_6.setBounds(320, 538, 75, 50);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_7.setBackground(new Color(255, 255, 255));
		button_7.setAlignmentY(0.0f);
		button_7.setBounds(162, 484, 75, 50);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_8.setBackground(new Color(255, 255, 255));
		button_8.setAlignmentY(0.0f);
		button_8.setBounds(241, 484, 75, 50);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_9.setBackground(new Color(255, 255, 255));
		button_9.setAlignmentY(0.0f);
		button_9.setBounds(320, 484, 75, 50);
		frame.getContentPane().add(button_9);
		
		JButton button_A = new JButton("A");
		button_A.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_A.setBackground(new Color(255, 255, 255));
		button_A.setAlignmentY(0.0f);
		button_A.setBounds(4, 484, 75, 50);
		button_A.setRolloverEnabled(true);
		frame.getContentPane().add(button_A);
		button_A.setEnabled(false);
		
		JButton button_B = new JButton("B");
		button_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_B.setBackground(new Color(255, 255, 255));
		button_B.setAlignmentY(0.0f);
		button_B.setBounds(83, 484, 75, 50);
		frame.getContentPane().add(button_B);
		button_B.setEnabled(false);
		
		JButton button_C = new JButton("C");
		button_C.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_C.setBackground(new Color(255, 255, 255));
		button_C.setAlignmentY(0.0f);
		button_C.setBounds(4, 538, 75, 50);
		frame.getContentPane().add(button_C);
		button_C.setEnabled(false);
		
		JButton button_D = new JButton("D");
		button_D.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_D.setBackground(new Color(255, 255, 255));
		button_D.setAlignmentY(0.0f);
		button_D.setBounds(83, 538, 75, 50);
		frame.getContentPane().add(button_D);
		button_D.setEnabled(false);
		
		JButton button_E = new JButton("E");
		button_E.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_E.setBackground(new Color(255, 255, 255));
		button_E.setBounds(4, 592, 75, 50);
		frame.getContentPane().add(button_E);
		button_E.setEnabled(false);
		
		JButton button_F = new JButton("F");
		button_F.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_F.setBackground(new Color(255, 255, 255));
		button_F.setBounds(83, 592, 75, 50);
		frame.getContentPane().add(button_F);
		button_F.setEnabled(false);
		
		JButton button_divide = new JButton("\u00F7");
		button_divide.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_divide.setBackground(new Color(245, 245, 245));
		button_divide.setAlignmentY(0.0f);
		button_divide.setBounds(399, 430, 75, 50);
		frame.getContentPane().add(button_divide);
		
		JButton button_multiply = new JButton("\u00D7");
		button_multiply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_multiply.setBackground(new Color(245, 245, 245));
		button_multiply.setAlignmentY(0.0f);
		button_multiply.setBounds(399, 484, 75, 50);
		frame.getContentPane().add(button_multiply);
		
		JButton button_sub = new JButton("\u2212");
		button_sub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_sub.setBackground(new Color(245, 245, 245));
		button_sub.setAlignmentY(0.0f);
		button_sub.setBounds(399, 538, 75, 50);
		frame.getContentPane().add(button_sub);
		
		JButton button_add = new JButton("+");
		button_add.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_add.setBackground(new Color(245, 245, 245));
		button_add.setBounds(399, 592, 75, 50);
		frame.getContentPane().add(button_add);
		
		JButton button_equals = new JButton("=");
		button_equals.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_equals.setBackground(new Color(245, 245, 245));
		button_equals.setBounds(399, 646, 75, 50);
		frame.getContentPane().add(button_equals);
		button_equals.setEnabled(false);
		
		JButton buttonDecimal = new JButton(".");
		buttonDecimal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonDecimal.setBackground(new Color(245, 245, 245));
		buttonDecimal.setBounds(320, 646, 75, 50);
		frame.getContentPane().add(buttonDecimal);
		buttonDecimal.setEnabled(false);
		
		JButton buttonPlusMinus = new JButton("\u00B1");
		buttonPlusMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPlusMinus.setBackground(new Color(245, 245, 245));
		buttonPlusMinus.setBounds(162, 646, 75, 50);
		frame.getContentPane().add(buttonPlusMinus);
		
		JButton buttonRightPara = new JButton(")");
		buttonRightPara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonRightPara.setBackground(new Color(245, 245, 245));
		buttonRightPara.setBounds(83, 646, 75, 50);
		frame.getContentPane().add(buttonRightPara);
		
		JButton buttonLeftPara = new JButton("(");
		buttonLeftPara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonLeftPara.setForeground(new Color(0, 0, 0));
		buttonLeftPara.setBackground(new Color(245, 245, 245));
		buttonLeftPara.setAlignmentY(0.0f);
		buttonLeftPara.setBounds(4, 646, 75, 50);
		frame.getContentPane().add(buttonLeftPara);
		
		JButton button_back = new JButton("\u232b");
		button_back.setBackground(new Color(245, 245, 245));
		button_back.setAlignmentY(0.0f);
		button_back.setBounds(320, 430, 75, 50);
		frame.getContentPane().add(button_back);
		
		JButton button_clear = new JButton("C");
		button_clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_clear.setBackground(new Color(245, 245, 245));
		button_clear.setAlignmentY(0.0f);
		button_clear.setBounds(241, 430, 75, 50);
		frame.getContentPane().add(button_clear);
		
		JButton button_ce = new JButton("CE");
		button_ce.setBackground(new Color(245, 245, 245));
		button_ce.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_ce.setAlignmentY(0.0f);
		button_ce.setBounds(162, 430, 75, 50);
		frame.getContentPane().add(button_ce);
		
		JButton button_mod = new JButton("Mod");
		button_mod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_mod.setBackground(new Color(245, 245, 245));
		button_mod.setAlignmentY(0.0f);
		button_mod.setBounds(83, 430, 75, 50);
		frame.getContentPane().add(button_mod);
		
		JButton button_up = new JButton("\u2191");
		button_up.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_up.setBackground(new Color(245, 245, 245));
		button_up.setAlignmentY(0.0f);
		button_up.setBounds(4, 430, 75, 50);
		frame.getContentPane().add(button_up);
		
		JButton button_and = new JButton("And");
		button_and.setBackground(new Color(245, 245, 245));
		button_and.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_and.setAlignmentY(0.0f);
		button_and.setBounds(399, 376, 75, 50);
		frame.getContentPane().add(button_and);
		
		JButton button_not = new JButton("Not");
		button_not.setBackground(new Color(245, 245, 245));
		button_not.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_not.setAlignmentY(0.0f);
		button_not.setBounds(320, 376, 75, 50);
		frame.getContentPane().add(button_not);
		
		JButton button_or = new JButton("Or");
		button_or.setBackground(new Color(245, 245, 245));
		button_or.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_or.setAlignmentY(0.0f);
		button_or.setBounds(162, 376, 75, 50);
		frame.getContentPane().add(button_or);
		
		JButton button_rsh = new JButton("Rsh");
		button_rsh.setBackground(new Color(245, 245, 245));
		button_rsh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_rsh.setAlignmentY(0.0f);
		button_rsh.setBounds(83, 376, 75, 50);
		frame.getContentPane().add(button_rsh);
		
		JButton button_M = new JButton("M");
		button_M.setBorderPainted(false);
		button_M.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_M.setAlignmentY(0.0f);
		button_M.setOpaque(false);
		button_M.setContentAreaFilled(false);
		button_M.setBounds(399, 332, 75, 40);
		frame.getContentPane().add(button_M);
		
		JButton button_word = new JButton("WORD");
		button_word.setBorderPainted(false);
		button_word.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_word.setAlignmentY(0.0f);
		button_word.setOpaque(false);
		button_word.setContentAreaFilled(false);
		button_word.setBounds(189, 332, 100, 40);
		frame.getContentPane().add(button_word);
		
		JButton button_dots2 = new JButton("...");
		button_dots2.setBorderPainted(false);
		button_dots2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_dots2.setAlignmentY(0.0f);
		button_dots2.setOpaque(false);
		button_dots2.setContentAreaFilled(false);
		button_dots2.setBounds(83, 332, 75, 40);
		frame.getContentPane().add(button_dots2);
		
		JButton button_dots1 = new JButton("\u2026");
		button_dots1.setBorderPainted(false);
		button_dots1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_dots1.setOpaque(false);
		button_dots1.setContentAreaFilled(false);
		button_dots1.setAlignmentY(0.0f);
		button_dots1.setBounds(4, 332, 75, 40);
		frame.getContentPane().add(button_dots1);
		
		JButton button_xor = new JButton("Xor");
		button_xor.setBackground(new Color(245, 245, 245));
		button_xor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_xor.setAlignmentY(0.0f);
		button_xor.setBounds(241, 376, 75, 50);
		frame.getContentPane().add(button_xor);
		
		JButton button_lsh = new JButton("Lsh");
		button_lsh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_lsh.setInheritsPopupMenu(true);
		button_lsh.setIgnoreRepaint(true);
		//btnLsh.setOpaque(false);
		//btnLsh.setContentAreaFilled(false);
		button_lsh.setBackground(new Color(240, 240, 240));
		button_lsh.setAlignmentY(0.0f);
		button_lsh.setBounds(4, 376, 75, 50);
		frame.getContentPane().add(button_lsh);
		
		JButton button_ms = new JButton("MS");
		button_ms.setBorderPainted(false);
		button_ms.setBorder(UIManager.getBorder("Button.border"));
		button_ms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_ms.setAlignmentY(0.0f);
		button_ms.setOpaque(false);
		button_ms.setContentAreaFilled(false);
		button_ms.setBounds(320, 332, 75, 40);
		frame.getContentPane().add(button_ms);
		
		JButton button_bin = new JButton("BIN");
		button_bin.setBorderPainted(false);
		button_bin.setForeground(Color.BLACK);
		button_bin.setOpaque(false);
		button_bin.setContentAreaFilled(false);
		button_bin.setBorder(UIManager.getBorder("Button.border"));
		button_bin.setFont(new Font("Calibri Light", Font.BOLD, 20));
		button_bin.setOpaque(false);
		button_bin.setHorizontalAlignment(SwingConstants.LEFT);
		button_bin.setAlignmentY(0.0f);
		button_bin.setBounds(0, 288, 478, 40);
		frame.getContentPane().add(button_bin);
		
		
		JButton button_oct = new JButton("OCT");
		button_oct.setBorderPainted(false);
		button_oct.setOpaque(false);
		button_oct.setContentAreaFilled(false);
		button_oct.setBorder(UIManager.getBorder("Button.border"));
		button_oct.setFont(new Font("Calibri Light", Font.BOLD, 20));
		button_oct.setOpaque(false);
		button_oct.setHorizontalAlignment(SwingConstants.LEFT);
		button_oct.setAlignmentY(0.0f);
		button_oct.setBounds(0, 248, 478, 40);
		frame.getContentPane().add(button_oct);
		
		JButton button_dec = new JButton("DEC");
		button_dec.setBorderPainted(false);
		button_dec.setContentAreaFilled(false);
		button_dec.setBorder(UIManager.getBorder("Button.border"));
		button_dec.setFont(new Font("Calibri Light", Font.BOLD, 20));
		button_dec.setOpaque(false);
		button_dec.setHorizontalAlignment(SwingConstants.LEFT);
		button_dec.setAlignmentY(0.0f);
		button_dec.setBounds(0, 208, 478, 40);
		
		frame.getContentPane().add(button_dec);
		
		JButton button_hex = new JButton("HEX");
		button_hex.setBorderPainted(false);
		button_hex.setOpaque(false);
		button_hex.setContentAreaFilled(false);
		button_hex.setBorder(UIManager.getBorder("Button.border"));
		button_hex.setFont(new Font("Calibri Light", Font.BOLD, 20));
		button_hex.setHorizontalAlignment(SwingConstants.LEFT);
		button_hex.setAlignmentY(0.0f);
		button_hex.setBounds(0, 168, 478, 40);
		frame.getContentPane().add(button_hex);
		
		
		//JTextField outPutText = new JTextField("0");
		outPutText.setBackground(new Color(240, 240, 240));
		outPutText.setFont(new Font("Tahoma", Font.PLAIN, 45));
		outPutText.setHorizontalAlignment(SwingConstants.RIGHT);
		outPutText.setBounds(4, 89, 459, 80);
		frame.getContentPane().add(outPutText);
		//outPutLabel.setText("1");
		
		JLabel label_programmer = new JLabel("  Programmer");
		label_programmer.setFont(new Font("Calibri Light", Font.PLAIN, 35));
		label_programmer.setBounds(76, 0, 402, 70);
		frame.getContentPane().add(label_programmer);
		
		JButton label_trigram = new JButton("\u2630");
		label_trigram.setBorderPainted(false);
		label_trigram.setAlignmentY(0.0f);
		label_trigram.setOpaque(false);
		label_trigram.setContentAreaFilled(false);
		label_trigram.setBounds(4, 0, 70, 70);
		frame.getContentPane().add(label_trigram);
		
		JButton button_45 = new JButton("New button");
		button_45.setAlignmentY(0.0f);
		button_45.setBounds(478, 0, 75, 50);
		frame.getContentPane().add(button_45);
		
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inum = outPutText.getText() + button_0.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_1.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_2.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
				
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_3.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_4.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_5.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
		
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_6.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
	
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_7.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
			
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});

		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_8.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + button_9.getText();
				outPutText.setText(inum);
				dec_textField_1.setText(inum);

				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 10;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
				
			}
		});
		
		button_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 11;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 12;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 13;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_E.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 14;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});

		button_F.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + 15;
				outPutText.setText(inum);
				dec_textField_1.setText(inum);
				
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				
				button_divide.setEnabled(true);
				button_multiply.setEnabled(true);
				button_sub.setEnabled(true);
				button_add.setEnabled(true);
				button_mod.setEnabled(true);
				button_equals.setEnabled(true);
			}
		});
		
		button_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText();
				myStringStack.push(inum);
				firstNumber = outPutText.getText();
				outPutText.setText(null);
				operations = ("\u00F7");
				outPutText2.setText(outPutText2.getText() + firstNumber + " \u00F7 ");
				myStringStack.push("/");
				button_divide.setEnabled(false);
				
			}
		});
		
		button_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText();
				myStringStack.push(inum);
				firstNumber = outPutText.getText();
				outPutText.setText(null);
				operations = ("\u00D7");
				//outPutText2.setText(firstNumber + " \u00D7");
				outPutText2.setText(outPutText2.getText() + firstNumber + " \u00D7 ");
				myStringStack.push("*");
				button_multiply.setEnabled(false);
			}
		});
		
		button_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText();
				myStringStack.push(inum);
				firstNumber = outPutText.getText();
				outPutText.setText(null);
				operations = ("\u2212");
				outPutText2.setText(outPutText2.getText() + firstNumber + " \u2212 ");
				myStringStack.push("-");
				button_sub.setEnabled(false);
			}
		});
		
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText();
				myStringStack.push(inum);
				firstNumber = outPutText.getText();
				outPutText.setText(null);
				operations = ("+");
				outPutText2.setText(outPutText2.getText() + firstNumber + " + ");
				myStringStack.push("+");
				button_add.setEnabled(false);
			}
		});
		
		button_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText();
				myStringStack.push(inum);
				firstNumber = outPutText.getText();
				outPutText.setText(null);
				operations = ("mod");
				outPutText2.setText(outPutText2.getText() + firstNumber + " Mod ");
				myStringStack.push("%");
				button_mod.setEnabled(false);
			}
		});
		
		button_equals.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e)  {
			
				String inum = outPutText.getText();
				myStringStack.push(inum);
				String formattedString = myStringStack.toString();
				String s = formattedString.replace("[", "").replace(",", "").replace("]", "");
				//outPutText.setText(s);
				DecimalFormat dc = new DecimalFormat("0.00");

				try {
					Object answer = engine.eval(s);
					int result = new Integer(answer.toString());
					int x = (int) Math.floor(result);
					//String i = Integer.toString(x);
					outPutText.setText(Integer.toString(x));
					//System.out.print(Integer.toString(x));
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				outPutText2.setText("");
				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
				button_equals.setEnabled(false);
				
				myStringStack.clear();

			} 
		});
		
		buttonDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!outPutText.getText().contains("."))
				{
					outPutText.setText(outPutText.getText() + buttonDecimal.getText()); 
				}
			}
		});
		
		button_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myStringStack.clear();
				outPutText.setText("");
				outPutText2.setText("");
				dec_textField_1.setText("");
				bin_textField.setText("");
				oct_textField.setText("");
				hex_textField.setText("");
				
				button_divide.setEnabled(false);
				button_multiply.setEnabled(false);
				button_sub.setEnabled(false);
				button_add.setEnabled(false);
				button_mod.setEnabled(false);
				button_equals.setEnabled(true);
			}
		});

		button_ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outPutText.setText("");
			}
		});

		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace = null;
				
				if(outPutText.getText().length() > 0)
				{
					StringBuilder stringBuilder = new StringBuilder(outPutText.getText());
					stringBuilder.deleteCharAt(outPutText.getText().length() - 1);
					backSpace = stringBuilder.toString();
					outPutText.setText(backSpace);
					
					dec_textField_1.setText(backSpace);
					bin_textField.setText(backSpace);
					oct_textField.setText(backSpace);
					hex_textField.setText(backSpace);
				}
			}
		});
		
		buttonPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int operator = Integer.parseInt(String.valueOf(outPutText.getText()));
				operator = operator * (-1);
				outPutText.setText(String.valueOf(operator));
				dec_textField_1.setText(String.valueOf(operator));

				int A = Integer.parseInt(outPutText.getText());
				bin_textField.setText(Integer.toString(A, 2));
				
				int B = Integer.parseInt(outPutText.getText());
				oct_textField.setText(Integer.toString(B, 8));
				
				int C = Integer.parseInt(outPutText.getText());
				hex_textField.setText(Integer.toString(C, 16));
			}
		});
		
		
		button_dec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_7.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				
				button_A.setEnabled(false);
				button_B.setEnabled(false);
				button_C.setEnabled(false);
				button_D.setEnabled(false);
				button_E.setEnabled(false);
				button_F.setEnabled(false);

			}
		});
		
		button_bin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				button_2.setEnabled(false);
				button_3.setEnabled(false);
				button_4.setEnabled(false);
				button_5.setEnabled(false);
				button_6.setEnabled(false);
				button_7.setEnabled(false);
				button_8.setEnabled(false);
				button_9.setEnabled(false);
				
				button_A.setEnabled(false);
				button_B.setEnabled(false);
				button_C.setEnabled(false);
				button_D.setEnabled(false);
				button_E.setEnabled(false);
				button_F.setEnabled(false);
				
			}
		});
		
		button_oct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_7.setEnabled(true);
				button_8.setEnabled(false);
				button_9.setEnabled(false);
				
				button_A.setEnabled(false);
				button_B.setEnabled(false);
				button_C.setEnabled(false);
				button_D.setEnabled(false);
				button_E.setEnabled(false);
				button_F.setEnabled(false);

			}
		});
		
		button_hex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_7.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				
				button_A.setEnabled(true);
				button_B.setEnabled(true);
				button_C.setEnabled(true);
				button_D.setEnabled(true);
				button_E.setEnabled(true);
				button_F.setEnabled(true);
				
			}
		});

		buttonRightPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + buttonRightPara.getText();
				outPutText.setText(inum);
			}
		});
		
		buttonLeftPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inum = outPutText.getText() + buttonLeftPara.getText();
				outPutText.setText(inum);
			}
		});
		

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
