package br.edu.unifei.demon.windowns;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

import br.edu.unifei.demon.ArmType;
import br.edu.unifei.demon.Armamento;
import br.edu.unifei.demon.Habilidade;

public class AddArmamento {

	private JFrame frmAdiconarArmamento;
	private JTextField valName;
	private JTextField valDesc;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bleach");
	private EntityManager em = emf.createEntityManager();
	private Armamento armamento = new Armamento();
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddArmamento window = new AddArmamento();
					window.frmAdiconarArmamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddArmamento() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		frmAdiconarArmamento = new JFrame();
		frmAdiconarArmamento.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				em.close();
				emf.close();
				frmAdiconarArmamento.dispose();
			}
		});
		frmAdiconarArmamento.getContentPane().setBackground(Color.DARK_GRAY);
		BufferedImage ic = ImageIO.read(new File("src\\main\\resources\\pngwing.com.png"));
		frmAdiconarArmamento.setIconImage(ic);
		frmAdiconarArmamento.setTitle("Adiconar Armamento");
		frmAdiconarArmamento.setResizable(false);
		frmAdiconarArmamento.setBounds(100, 100, 488, 322);
		frmAdiconarArmamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdiconarArmamento.getContentPane().setLayout(null);
		
		valName = new JTextField();
		valName.setForeground(Color.WHITE);
		valName.setOpaque(false);
		valName.setBounds(10, 35, 200, 20);
		frmAdiconarArmamento.getContentPane().add(valName);
		valName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 21, 46, 14);
		frmAdiconarArmamento.getContentPane().add(lblNewLabel);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(0,0,200,1);
		SpinnerNumberModel model2 = new SpinnerNumberModel(0,0,200,1);
		
		JSpinner valForca = new JSpinner(model1);
		valForca.setOpaque(false);
		valForca.setBounds(404, 36, 46, 20);
		frmAdiconarArmamento.getContentPane().add(valForca);
		
		JSpinner valResist = new JSpinner(model2);
		valResist.setOpaque(false);
		valResist.setBounds(404, 81, 46, 20);
		frmAdiconarArmamento.getContentPane().add(valResist);
		
		JLabel lblNewLabel_1 = new JLabel("Força:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(360, 39, 46, 14);
		frmAdiconarArmamento.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resistência:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(323, 84, 78, 14);
		frmAdiconarArmamento.getContentPane().add(lblNewLabel_2);
		
		JComboBox<ArmType> valTipo = new JComboBox<>();
		valTipo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		valTipo.setEditable(true);
		valTipo.setBounds(10, 116, 200, 22);
		valTipo.addItem(ArmType.ARMAMENTO_ESPIRITUAL);
		valTipo.addItem(ArmType.BANKAI);
		valTipo.addItem(ArmType.SHINKAI);
		valTipo.addItem(ArmType.ZANPAKUTO);
		frmAdiconarArmamento.getContentPane().add(valTipo);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 102, 46, 14);
		frmAdiconarArmamento.getContentPane().add(lblNewLabel_3);
		
		valDesc = new JTextField();
		valDesc.setHorizontalAlignment(SwingConstants.LEFT);
		valDesc.setForeground(Color.WHITE);
		valDesc.setOpaque(false);
		valDesc.setBounds(10, 190, 440, 48);
		frmAdiconarArmamento.getContentPane().add(valDesc);
		valDesc.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 175, 89, 14);
		frmAdiconarArmamento.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnQuebrada = new JRadioButton("Quebrada");
		rdbtnQuebrada.setOpaque(false);
		rdbtnQuebrada.setForeground(Color.WHITE);
		rdbtnQuebrada.setBounds(10, 72, 109, 23);
		frmAdiconarArmamento.getContentPane().add(rdbtnQuebrada);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armamento.setNome(valName.getText());
				if(!(valName.getText().isEmpty())) {
					btnAdd.setEnabled(true);
				}
				armamento.setForcaExtra((int) valForca.getValue());
				armamento.setResistencia((int) valResist.getValue());
				armamento.setDescricao(valDesc.getText());
				armamento.setTipo((ArmType) valTipo.getSelectedItem());
				armamento.setQuebrado(rdbtnQuebrada.isSelected());
				em.getTransaction().begin();
				em.persist(armamento);
				em.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Arma salva na base de dados!");
				em.close();
				emf.close();
				frmAdiconarArmamento.dispose();
			}
		});
		btnAdd.setOpaque(false);
		btnAdd.setBounds(335, 249, 114, 23);
		frmAdiconarArmamento.getContentPane().add(btnAdd);
		
		// Acao para desabilitar o botao com base no campo da chave primaria
		valName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Armamento aux = null;
				aux = em.find(Armamento.class, valName.getText());
				if(aux!=null) {
					btnAdd.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Já existe uma arma com esse nome.");
				}else {
					btnAdd.setEnabled(true);
				}
				
				if(valName.getText().isEmpty()) {
					btnAdd.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Informe um nome para a nova arma.");
				}
			}
		});
		
		JButton btnHabilidade = new JButton("Adicionar habilidades");
		btnHabilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WinAbility win = new WinAbility(armamento);
					win.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHabilidade.setOpaque(false);
		btnHabilidade.setBounds(250, 115, 200, 23);
		frmAdiconarArmamento.getContentPane().add(btnHabilidade);
		
		JLabel lblBackgraund = new JLabel("");
		lblBackgraund.setBounds(0, 0, 472, 283);
		BufferedImage bck = ImageIO.read(new File("src\\main\\resources\\Ep376Zanpakuto.jpg"));
		lblBackgraund.setIcon(new ImageIcon(bck.getScaledInstance( lblBackgraund.getWidth(), lblBackgraund.getHeight(), Image.SCALE_SMOOTH)));
		frmAdiconarArmamento.getContentPane().add(lblBackgraund);
	}
}
