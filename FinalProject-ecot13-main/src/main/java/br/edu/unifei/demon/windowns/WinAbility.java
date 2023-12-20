package br.edu.unifei.demon.windowns;

import java.awt.EventQueue;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import br.edu.unifei.demon.Armamento;
import br.edu.unifei.demon.Habilidade;
import br.edu.unifei.demon.Ser;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;

public class WinAbility {

	private JFrame frmAdicionarHabilidades;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bleach");
	private EntityManager em = emf.createEntityManager();
	private Armamento armamento = null;
	private Ser ser = null;
	
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinAbility window;
					if(ser == null) {
						window = new WinAbility(armamento);
					}else {
						window = new WinAbility(ser);
					}
//					window = new WinAbility();
					window.frmAdicionarHabilidades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public WinAbility() throws IOException {
		initialize();
	}
	
	public WinAbility(Armamento armamento) throws IOException {
		this.armamento =  armamento;
		initialize();
	}
	
	public WinAbility(Ser ser) throws IOException {
		this.ser = ser;
		initialize();
	}

	private void initialize() throws IOException {
		frmAdicionarHabilidades = new JFrame();
		frmAdicionarHabilidades.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				em.close();
				emf.close();
				frmAdicionarHabilidades.dispose();
			}
		});
		BufferedImage ic = ImageIO.read(new File("src\\main\\resources\\pngwing.com.png"));
		frmAdicionarHabilidades.setIconImage(ic);
		frmAdicionarHabilidades.setTitle("Escolha sua(s) habilidade(s)");
		frmAdicionarHabilidades.setBounds(100, 100, 536, 285);
		frmAdicionarHabilidades.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		DefaultListModel<Habilidade> model = new DefaultListModel<>();
		JList<Habilidade> list = new JList<>(model);
		list.setValueIsAdjusting(true);
		list.setOpaque(false);
		
		em.getTransaction().begin();
		List<Habilidade> ability = em.createQuery("from Habilidade").getResultList();
		List<Habilidade> habilidades;
		
		if(ser == null) {
			habilidades = armamento.getHabilidade();
		}else {
			habilidades = ser.getHabilidades();
		}
		
		for(Habilidade h : ability) {
			if(! habilidades.contains(h))
				model.addElement(h);
		}
		frmAdicionarHabilidades.getContentPane().setLayout(null);
		
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 28, 226, 163);
		scrollPane.setOpaque(false);
		frmAdicionarHabilidades.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Salvar seleção");
		btnNewButton.setBounds(175, 212, 167, 23);
		btnNewButton.setOpaque(false);
		frmAdicionarHabilidades.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Selecione mais de uma habilidade segurando Ctrl");
		lblNewLabel.setBounds(10, 191, 302, 14);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmAdicionarHabilidades.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(284, 28, 226, 163);
		scrollPane_1.setOpaque(false);
		frmAdicionarHabilidades.getContentPane().add(scrollPane_1);
		
		DefaultListModel<Habilidade> model2 = new DefaultListModel<>();
		JList<Habilidade> list_1 = new JList<Habilidade>(model2);
		list_1.setValueIsAdjusting(true);
		for(Habilidade hb : habilidades) {
			model2.addElement(hb);
		}
		list_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list_1.setOpaque(false);
		scrollPane_1.setViewportView(list_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Habilidade> selecionadas = list.getSelectedValuesList();
				for(Habilidade h : selecionadas) {
					if(ser==null) {
						armamento.getHabilidade().add(h);
					}else {
						ser.getHabilidades().add(h);
					}
				}
				
				selecionadas = list_1.getSelectedValuesList();
				for(Habilidade h : selecionadas) {
					if(ser==null) {
						armamento.getHabilidade().remove(h);
					}else {
						ser.getHabilidades().remove(h);
					}
				}
				em.close();
				emf.close();
				JOptionPane.showMessageDialog(null, "Seleções salvas com sucesso");
				frmAdicionarHabilidades.dispose();
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Habilidades que possui:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(284, 11, 139, 14);
		frmAdicionarHabilidades.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Habilidades disponiveis:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 11, 155, 14);
		frmAdicionarHabilidades.getContentPane().add(lblNewLabel_2);
	}
}
