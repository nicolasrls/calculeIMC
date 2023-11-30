package CalcIMC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class calcimc {

	private JFrame frame;
	private JTextField inpNome;
	private JTextField inpAltura;
	private JTextField inpPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcimc window = new calcimc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calcimc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculadora IMC");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(163, 11, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 50, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		inpNome = new JTextField();
		inpNome.setToolTipText("Insira seu nome");
		inpNome.setBounds(50, 47, 107, 20);
		frame.getContentPane().add(inpNome);
		inpNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Altura:");
		lblNewLabel_2.setBounds(10, 75, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		inpAltura = new JTextField();
		inpAltura.setToolTipText("em metros. Ex: 1.74");
		inpAltura.setBounds(50, 72, 107, 20);
		frame.getContentPane().add(inpAltura);
		inpAltura.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Peso:");
		lblNewLabel_3.setBounds(167, 75, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		inpPeso = new JTextField();
		inpPeso.setToolTipText("em KG");
		inpPeso.setBounds(201, 72, 101, 20);
		frame.getContentPane().add(inpPeso);
		inpPeso.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("Resultado:");
		lblNewLabel_4.setBounds(198, 122, 72, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setBounds(10, 147, 414, 103);
		frame.getContentPane().add(labelResultado);
		
		
		
		JButton btnNewButton = new JButton("Calcular IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomePaciente = inpNome.getText();
				float altura = Float.parseFloat(inpAltura.getText());
				float peso = Float.parseFloat(inpPeso.getText());
				float IMC = 0;
				IMC = (peso/(altura*altura));
				String imcForm = String.format("%.1f", IMC);
				String categoriaIMC;
		        if (IMC < 18.5) {
		            categoriaIMC = "Abaixo do normal";
		        } else if (IMC < 24.9) {
		            categoriaIMC = "Normal";
		        } else if (IMC < 29.9) {
		            categoriaIMC = "Sobrepeso";
		        } else if (IMC < 34.9) {
		            categoriaIMC = "Obesidade Grau I";
		        } else if (IMC < 39.9) {
		            categoriaIMC = "Obesidade Grau II";
		        } else {
		            categoriaIMC = "Obesidade Grau III";
		        }
				labelResultado.setText("<html>" + nomePaciente + ",<br>Seu peso é " + peso + "Kg<br>Sua altura é " + altura +
				        "m<br>Logo seu IMC é " + imcForm + "<br>Sua categoria se enquadra em: " + categoriaIMC + "</html>");
								
			}
		});
		btnNewButton.setBounds(312, 71, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
