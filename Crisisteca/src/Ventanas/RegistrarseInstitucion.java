package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegistrarseInstitucion extends JFrame{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			
            @Override
            public void run() {
                new RegistrarseInstitucion();
            }
            
		});

	}
	
	private JTextField tfNombre;
	private JTextField tfEmail;
	private JTextField tfTelefono;
		
	public RegistrarseInstitucion() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registrarse como Institución");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600,200);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);

		///Paneles
		JPanel pnlMain = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();
			
		pnlMain.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlAbajo.setLayout(new BoxLayout(pnlAbajo, BoxLayout.X_AXIS));
		
		/// Panel de la Izquierda
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 30));

		pnlIzquierda.add(lblNombre);
		pnlIzquierda.add(lblEmail);
		pnlIzquierda.add(lblTelefono);

		/// Panel de la Derecha
		tfNombre = new JTextField( 20);
		tfEmail = new JTextField(20);
		tfTelefono= new JTextField(20);
		
		tfTelefono.addKeyListener(new KeyAdapter() { //https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
		public void keyPressed(KeyEvent p) {
            if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
            	tfTelefono.setEditable(true);
            } else {
            	tfTelefono.setEditable(false);
                JOptionPane.showMessageDialog(null, "Recuerde no incluir letras");

            }
         }
		public void keyTyped(KeyEvent t) {
	        if (tfTelefono.getText().length() >= 9 )
	            t.consume(); 
		}
      	
	});
		
		tfNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		tfTelefono.setFont(new Font("Arial", Font.PLAIN, 20));
		
		pnlDerecha.add(tfNombre);
		pnlDerecha.add(tfEmail);
		pnlDerecha.add(tfTelefono);

		
		///Panel abajo
        JCheckBox cboxCondicionesUso = new JCheckBox("Acepto los términos de uso");
        cboxCondicionesUso.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlAbajo.add(cboxCondicionesUso, BorderLayout.EAST);
        
        JButton bRegistrar = new JButton("Registrar");
        pnlAbajo.add(bRegistrar, BorderLayout.SOUTH);

		/// Panel principal
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlAbajo, BorderLayout.SOUTH);
		getContentPane().add(pnlMain);

		setVisible(true);
		
		
		
	}
	
	
	

}


