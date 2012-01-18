package baseXNumber.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import baseXNumber.BaseXNumber;

public class BaseXNumberGUI extends JFrame{

	private static final long serialVersionUID = 3L;

	private JTextField leftField, rightField;
	private JButton convert;
	private JRadioButton binaryLeft, octalLeft, decimalLeft, hexLeft;
	private JRadioButton binaryRight, octalRight, decimalRight, hexRight;
	private ButtonGroup groupLeft, groupRight;

	public BaseXNumberGUI()
	{
		super("Base Number Conversion");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//Creating the panel that will hold everything
		JPanel all = new JPanel();
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));

		//Setting up the convert button
		convert = new JButton("Convert");
		convert.addActionListener(new ConvertButtonListener());

		//Setting the Radio Buttons
		binaryLeft = new JRadioButton("Binary");
		binaryLeft.setActionCommand("binary");
		octalLeft = new JRadioButton("Octal");
		octalLeft.setActionCommand("octal");
		decimalLeft = new JRadioButton("Decimal", true);
		decimalLeft.setActionCommand("decimal");
		hexLeft = new JRadioButton("Hexadecimal");
		hexLeft.setActionCommand("hexadecimal");

		binaryRight = new JRadioButton("Binary");
		binaryRight.setActionCommand("binary");
		octalRight = new JRadioButton("Octal");
		octalRight.setActionCommand("octal");
		decimalRight = new JRadioButton("Decimal", true);
		decimalRight.setActionCommand("decimal");
		hexRight = new JRadioButton("Hexadecimal");
		hexRight.setActionCommand("hexadecimal");

		groupLeft = new ButtonGroup();
		groupLeft.add(binaryLeft);
		groupLeft.add(octalLeft);
		groupLeft.add(decimalLeft);
		groupLeft.add(hexLeft);

		groupRight = new ButtonGroup();
		groupRight.add(binaryRight);
		groupRight.add(octalRight);
		groupRight.add(decimalRight);
		groupRight.add(hexRight);

		//Adding the Radio Buttons to the panel on the left side
		JPanel radioButtonPanelLeft = new JPanel();
		radioButtonPanelLeft.setLayout(new BoxLayout(radioButtonPanelLeft, BoxLayout.Y_AXIS));
		radioButtonPanelLeft.add(binaryLeft);
		radioButtonPanelLeft.add(octalLeft);
		radioButtonPanelLeft.add(decimalLeft);
		radioButtonPanelLeft.add(hexLeft);

		//Adding the Radio Buttons to the panel on the right side
		JPanel radioButtonPanelRight = new JPanel();
		radioButtonPanelRight.setLayout(new BoxLayout(radioButtonPanelRight, BoxLayout.Y_AXIS));
		radioButtonPanelRight.add(binaryRight);
		radioButtonPanelRight.add(octalRight);
		radioButtonPanelRight.add(decimalRight);
		radioButtonPanelRight.add(hexRight);


		//Setting the fields that will work as input
		JPanel fields = new JPanel();
		leftField = new JTextField(15);
		rightField = new JTextField(15);
		fields.add(leftField);
		fields.add(new JLabel("              TO              "));
		fields.add(rightField);

		JPanel radiosHolder = new JPanel();
		radiosHolder.add(radioButtonPanelLeft);
		radiosHolder.add(Box.createRigidArea(new Dimension(270,0)));
		radiosHolder.add(radioButtonPanelRight);

		all.add(radiosHolder);
		all.add(fields);
		all.add(convert);
		all.add(Box.createRigidArea(new Dimension(0,50)));
		add(all);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class ConvertButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(!leftField.getText().trim().equals(""))
			{
				BaseXNumber num = new BaseXNumber(groupLeft.getSelection().getActionCommand(), leftField.getText().trim());

				if(groupRight.getSelection().getActionCommand().equals("binary"))
				{
					rightField.setText(num.toBinary());
				}

				else if(groupRight.getSelection().getActionCommand().equals("octal"))
				{
					rightField.setText(num.toOctal());
				}

				else if(groupRight.getSelection().getActionCommand().equals("decimal"))
				{
					rightField.setText(num.toDecimal());
				}

				else if(groupRight.getSelection().getActionCommand().equals("hexadecimal"))
				{
					rightField.setText(num.toHexadecimal());
				}

			}
		}

	}

	/**
	 * Main method
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		new BaseXNumberGUI();
	}

}
