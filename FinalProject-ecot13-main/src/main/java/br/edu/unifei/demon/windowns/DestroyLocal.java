package br.edu.unifei.demon.windowns;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.unifei.demon.Cidade;
import br.edu.unifei.demon.Deserto;
import br.edu.unifei.demon.Local;
import br.edu.unifei.demon.Universo;
import br.edu.unifei.demon.Ser;
import br.edu.unifei.demon.WorldType;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DestroyLocal {

	private JFrame frmDestruaUmMundo;
	private JTextField textName;
	private JTextField textTipo;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bleach");
	private EntityManager em = emf.createEntityManager();
	private Local local;
	private List<Ser> seres;
	private JTextField textNum;
	private JTextField textMundo;
	
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DestroyLocal window = new DestroyLocal();
					window.frmDestruaUmMundo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DestroyLocal() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		frmDestruaUmMundo = new JFrame();
		frmDestruaUmMundo.setTitle("Destrua um mundo");
		BufferedImage ic = ImageIO.read(new File("src\\main\\resources\\pngwing.com.png"));
		frmDestruaUmMundo.setIconImage(ic);
		frmDestruaUmMundo.setBounds(100, 100, 408, 186);
		frmDestruaUmMundo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDestruaUmMundo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do local:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 129, 14);
		frmDestruaUmMundo.getContentPane().add(lblNewLabel);
		
		textName = new JTextField();
		textName.setOpaque(false);
		textName.setForeground(Color.WHITE);
		textName.setBounds(10, 26, 158, 20);
		frmDestruaUmMundo.getContentPane().add(textName);
		textName.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setEnabled(false);
		textTipo.setForeground(Color.WHITE);
		textTipo.setOpaque(false);
		textTipo.setBounds(255, 26, 129, 20);
		frmDestruaUmMundo.getContentPane().add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(258, 11, 46, 14);
		frmDestruaUmMundo.getContentPane().add(lblNewLabel_1);
		
		JButton btnDestroi = new JButton("Destruir");
		btnDestroi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(seres != null) {
					em.getTransaction().begin();
					for(Ser s : seres) {
						s.setMorto(true);
						s.setLocalAtual(null);
						em.merge(s);
					}
					em.getTransaction().commit();
					local.setHabitantes(null);
				}
				
				Universo aux = local.getMundoPertencente();
				if(aux != null) {
					em.getTransaction().begin();
					aux.getLocais().remove(local);
					em.merge(aux);
					em.getTransaction().commit();
					local.setMundoPertencente(null);
				}
				
				em.getTransaction().begin();
				em.remove(local);
				em.getTransaction().commit();
				em.close();
				emf.close();
				frmDestruaUmMundo.dispose();
			}
		});
		btnDestroi.setBounds(10, 113, 372, 23);
		btnDestroi.setEnabled(false);
		frmDestruaUmMundo.getContentPane().add(btnDestroi);
		
		JLabel lblNewLabel_2 = new JLabel("Isso matará todos os personagens nesse local");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 98, 287, 14);
		frmDestruaUmMundo.getContentPane().add(lblNewLabel_2);
		
		JButton btnBusca = new JButton("New button");
		btnBusca.setBounds(167, 25, 36, 23);
		frmDestruaUmMundo.getContentPane().add(btnBusca);
		
		textNum = new JTextField();
		textNum.setForeground(Color.WHITE);
		textNum.setOpaque(false);
		textNum.setEnabled(false);
		textNum.setBounds(255, 72, 86, 20);
		frmDestruaUmMundo.getContentPane().add(textNum);
		textNum.setColumns(10);
		
		textMundo = new JTextField();
		textMundo.setEditable(false);
		textMundo.setEnabled(false);
		textMundo.setOpaque(false);
		textMundo.setForeground(Color.WHITE);
		textMundo.setColumns(10);
		textMundo.setBounds(10, 72, 158, 20);
		frmDestruaUmMundo.getContentPane().add(textMundo);
		
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				local = em.find(Local.class, textName.getText());
				if(local == null) {
					btnDestroi.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Informe um Local existente");
				}else {
					btnDestroi.setEnabled(true);
					seres = em.createQuery("from Ser s where s.localAtual.nome = '" + textName.getText()+"'").getResultList();
					
					Integer size = local.getHabitantes().size();
					textNum.setText(size.toString());
					
					if(local.getMundoPertencente().getTipo() == WorldType.HUECO_MUNDO) {
						textMundo.setText("Hueco Mundo");
					}else if(local.getMundoPertencente().getTipo() == WorldType.MUNDO_FISICO) {
						textMundo.setText("Mundo Fisico (Humano)");
					}else {
						textMundo.setText("Mundo das Almas");
					}
						
					
					if(local instanceof Cidade) {
						textTipo.setText("Cidade");
					}else if(local instanceof Deserto) {
						textTipo.setText("Deserto");
					}else {
						textTipo.setText("Fenda");
					}
				}
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("Mundo:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(13, 57, 46, 14);
		frmDestruaUmMundo.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Numero de habitantes:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(255, 57, 129, 14);
		frmDestruaUmMundo.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		BufferedImage bck = ImageIO.read(new File("src\\main\\resources\\ichigo-kurosaki.png"));
		lblNewLabel_3.setBounds(0, 0, 516, 280);
		lblNewLabel_3.setIcon(new ImageIcon(bck.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		frmDestruaUmMundo.getContentPane().add(lblNewLabel_3);
	}
}
