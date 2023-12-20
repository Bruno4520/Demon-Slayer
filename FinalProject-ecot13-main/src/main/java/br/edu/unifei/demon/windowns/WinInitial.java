package br.edu.unifei.demon.windowns;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class WinInitial {

	private JFrame frmMenu;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinInitial window = new WinInitial();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WinInitial() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {		
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		BufferedImage ic = ImageIO.read(new File("src\\main\\resources\\pngwing.com.png"));
		frmMenu.setIconImage(ic);
		frmMenu.setResizable(false);
		frmMenu.setBounds(100, 100, 560, 360);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar nova arma");
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddArmamento arm = new AddArmamento();
					arm.main(null);
				
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton.setBounds(297, 139, 168, 23);
		frmMenu.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Editar personagem");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditSer win;
				try {
					win = new EditSer();
					win.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnEdit.setOpaque(false);
		btnEdit.setBounds(297, 185, 168, 23);
		frmMenu.getContentPane().add(btnEdit);
		
		JButton btnDel = new JButton("Destruir local");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DestroyLocal win = new DestroyLocal();
					win.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDel.setOpaque(false);
		btnDel.setBounds(297, 230, 168, 23);
		frmMenu.getContentPane().add(btnDel);
		
		JLabel lblBck = new JLabel("");
		BufferedImage bck = ImageIO.read(new File("src\\main\\resources\\initial.jpg"));
		lblBck.setBounds(0, 0, 544, 321);
		lblBck.setIcon(new ImageIcon(bck.getScaledInstance(lblBck.getWidth(), lblBck.getHeight(), Image.SCALE_SMOOTH)));
		frmMenu.getContentPane().add(lblBck);	
	}

}
