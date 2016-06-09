package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class añadeSuministro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreT;
	private JTextField matriculaT;
	private JTextField cantidadT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			añadeSuministro dialog = new añadeSuministro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public añadeSuministro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel nombre = new JLabel("nombre");
			GridBagConstraints gbc_nombre = new GridBagConstraints();
			gbc_nombre.insets = new Insets(0, 0, 5, 5);
			gbc_nombre.gridx = 1;
			gbc_nombre.gridy = 1;
			contentPanel.add(nombre, gbc_nombre);
		}
		{
			nombreT = new JTextField();
			GridBagConstraints gbc_nombreT = new GridBagConstraints();
			gbc_nombreT.insets = new Insets(0, 0, 5, 0);
			gbc_nombreT.fill = GridBagConstraints.HORIZONTAL;
			gbc_nombreT.gridx = 3;
			gbc_nombreT.gridy = 1;
			contentPanel.add(nombreT, gbc_nombreT);
			nombreT.setColumns(10);
		}
		{
			JLabel matricula = new JLabel("matricula");
			GridBagConstraints gbc_matricula = new GridBagConstraints();
			gbc_matricula.insets = new Insets(0, 0, 5, 5);
			gbc_matricula.gridx = 1;
			gbc_matricula.gridy = 3;
			contentPanel.add(matricula, gbc_matricula);
		}
		{
			matriculaT = new JTextField();
			GridBagConstraints gbc_matriculaT = new GridBagConstraints();
			gbc_matriculaT.insets = new Insets(0, 0, 5, 0);
			gbc_matriculaT.fill = GridBagConstraints.HORIZONTAL;
			gbc_matriculaT.gridx = 3;
			gbc_matriculaT.gridy = 3;
			contentPanel.add(matriculaT, gbc_matriculaT);
			matriculaT.setColumns(10);
		}
		{
			JLabel cantidad = new JLabel("cantidad");
			GridBagConstraints gbc_cantidad = new GridBagConstraints();
			gbc_cantidad.insets = new Insets(0, 0, 0, 5);
			gbc_cantidad.gridx = 1;
			gbc_cantidad.gridy = 5;
			contentPanel.add(cantidad, gbc_cantidad);
		}
		{
			cantidadT = new JTextField();
			GridBagConstraints gbc_cantidadT = new GridBagConstraints();
			gbc_cantidadT.fill = GridBagConstraints.HORIZONTAL;
			gbc_cantidadT.gridx = 3;
			gbc_cantidadT.gridy = 5;
			contentPanel.add(cantidadT, gbc_cantidadT);
			cantidadT.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
