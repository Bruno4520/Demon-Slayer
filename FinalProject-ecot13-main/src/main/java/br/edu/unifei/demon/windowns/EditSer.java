package br.edu.unifei.demon.windowns;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import br.edu.unifei.demon.Alma;
import br.edu.unifei.demon.ArmType;
import br.edu.unifei.demon.Armamento;
import br.edu.unifei.demon.Demonio;
import br.edu.unifei.demon.EnumHollow;
import br.edu.unifei.demon.Espadachim;
import br.edu.unifei.demon.Restrição;
import br.edu.unifei.demon.Humano;
import br.edu.unifei.demon.Local;
import br.edu.unifei.demon.Organizacao;
import br.edu.unifei.demon.Ser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditSer {

	private JFrame frmEditarInformaesDe;
	private JTextField textProficao;
	private JTextField txtNome;
	private JTextField txtFraseAoInvocar;
	private JTextField textRaca;
	private JTextField textLocal;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bleach");
	private EntityManager em = emf.createEntityManager();
	private JTextField textArma;
	private JTextField textOrg;
	private Ser aux = null;
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSer window = new EditSer();
					window.frmEditarInformaesDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditSer() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		frmEditarInformaesDe = new JFrame();
		BufferedImage ic = ImageIO.read(new File("src\\main\\resources\\pngwing.com.png"));
		frmEditarInformaesDe.setIconImage(ic);
		frmEditarInformaesDe.setTitle("Editar informações de personagem");
		frmEditarInformaesDe.setResizable(false);
		frmEditarInformaesDe.setBounds(100, 100, 552, 399);
		frmEditarInformaesDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditarInformaesDe.getContentPane().setLayout(null);
		
		textProficao = new JTextField();
		textProficao.setOpaque(false);
		textProficao.setBounds(10, 85, 187, 20);
		frmEditarInformaesDe.getContentPane().add(textProficao);
		textProficao.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setOpaque(false);
		txtNome.setBounds(10, 34, 187, 20);
		frmEditarInformaesDe.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtFraseAoInvocar = new JTextField();
		txtFraseAoInvocar.setOpaque(false);
		txtFraseAoInvocar.setBounds(10, 295, 337, 20);
		frmEditarInformaesDe.getContentPane().add(txtFraseAoInvocar);
		txtFraseAoInvocar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 21, 46, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Profissão:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 72, 66, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Frase ao invocar sua bankai:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(10, 280, 172, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_2);
		
		JSpinner spReserva = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spReserva.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spReserva.setBounds(146, 116, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spReserva);
		
		JSpinner spReiatsu = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spReiatsu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spReiatsu.setBounds(146, 147, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spReiatsu);
		
		JSpinner spVida = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spVida.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spVida.setBounds(311, 147, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spVida);
		
		JSpinner spAlmas = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spAlmas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spAlmas.setBounds(311, 209, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spAlmas);
		
		JSpinner spDefesa = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spDefesa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spDefesa.setBounds(311, 116, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spDefesa);
		
		JSpinner spForca = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spForca.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spForca.setBounds(311, 85, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spForca);
		
		JSpinner spVelocidade = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spVelocidade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spVelocidade.setBounds(311, 178, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spVelocidade);
		
		JRadioButton rdbtnMorto = new JRadioButton("Esta morto(a)");
		rdbtnMorto.setOpaque(false);
		rdbtnMorto.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnMorto.setBounds(383, 207, 109, 23);
		frmEditarInformaesDe.getContentPane().add(rdbtnMorto);
		
		JRadioButton rdbtnBankai = new JRadioButton("Possui bankai");
		rdbtnBankai.setOpaque(false);
		rdbtnBankai.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnBankai.setBounds(383, 176, 109, 23);
		frmEditarInformaesDe.getContentPane().add(rdbtnBankai);
		
		JRadioButton rdbtnCeifado = new JRadioButton("Foi ceifado(a)");
		rdbtnCeifado.setOpaque(false);
		rdbtnCeifado.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnCeifado.setBounds(383, 147, 109, 23);
		frmEditarInformaesDe.getContentPane().add(rdbtnCeifado);
		
		JLabel lblNewLabel_3 = new JLabel("Defesa:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(221, 119, 66, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_3);
		
		JLabel lblForca = new JLabel("Força: ");
		lblForca.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblForca.setBounds(220, 88, 46, 14);
		frmEditarInformaesDe.getContentPane().add(lblForca);
		
		JLabel lblNewLabel_5 = new JLabel("Velocidade:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(221, 181, 76, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Reserva Espiritual:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(10, 119, 132, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Reiatsu:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(10, 147, 132, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Vida:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(220, 150, 46, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Almas Devoradas:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9.setBounds(220, 212, 109, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_9);
		
		JRadioButton rdbtnQuincy = new JRadioButton("É quincy");
		rdbtnQuincy.setOpaque(false);
		rdbtnQuincy.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnQuincy.setBounds(383, 115, 109, 23);
		frmEditarInformaesDe.getContentPane().add(rdbtnQuincy);
		
		JLabel lblNewLabel_9_1 = new JLabel("Hollows Devorados:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9_1.setBounds(10, 178, 132, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_9_1);
		
		JSpinner spHollows = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spHollows.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spHollows.setBounds(146, 175, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spHollows);
		
		JComboBox<EnumHollow> comboBox = new JComboBox<>();
		comboBox.addItem(EnumHollow.ADJUNCHA);
		comboBox.addItem(EnumHollow.COMUM);
		comboBox.addItem(EnumHollow.GILLIAN);
		comboBox.addItem(EnumHollow.VASTOLORD);
		comboBox.setBounds(217, 33, 130, 22);
		frmEditarInformaesDe.getContentPane().add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo de Hollow:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTipo.setBounds(221, 21, 88, 14);
		frmEditarInformaesDe.getContentPane().add(lblTipo);
		
		textRaca = new JTextField();
		textRaca.setBounds(383, 34, 130, 20);
		frmEditarInformaesDe.getContentPane().add(textRaca);
		textRaca.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Raça:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(388, 21, 46, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("Afinidade com bankai:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 211, 138, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_5_1);
		
		JSpinner spAfinidade = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spAfinidade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spAfinidade.setBounds(146, 206, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spAfinidade);
		
		textLocal = new JTextField();
		textLocal.setOpaque(false);
		textLocal.setBounds(383, 85, 130, 20);
		frmEditarInformaesDe.getContentPane().add(textLocal);
		textLocal.setColumns(10);
		
		JLabel lblLocal = new JLabel("Local atual:");
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLocal.setBounds(383, 72, 76, 14);
		frmEditarInformaesDe.getContentPane().add(lblLocal);
		
		JButton btnAlterar = new JButton("Salvar alterações");
		btnAlterar.setOpaque(false);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAlterar.setBounds(388, 326, 138, 23);
		frmEditarInformaesDe.getContentPane().add(btnAlterar);
		
		textLocal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(em.find(Local.class, textLocal.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Informe um Local existente!");
					textLocal.setText(aux.getLocalAtual().getNome());
				}
				btnAlterar.setEnabled(true);
			}
			@Override
			public void focusGained(FocusEvent e) {
				btnAlterar.setEnabled(false);
			}
		});
		
		JButton btnHabilidades = new JButton("Lista de Habilidades");
		btnHabilidades.setOpaque(false);
		btnHabilidades.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHabilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinAbility win;
				try {
					win = new WinAbility(aux);
					win.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHabilidades.setBounds(221, 326, 138, 23);
		frmEditarInformaesDe.getContentPane().add(btnHabilidades);
		
		textArma = new JTextField();
		textArma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Armamento a = em.find(Armamento.class, textArma.getText());
				if(a == null && ! textArma.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma arma existente!");
					if(aux.getEspada() != null) {
						textArma.setText(aux.getEspada().getNome());
					}else {
						textArma.setText("");	
					}	
				}else if(aux.getRaca() instanceof Demonio){
					if(! textArma.getText().isEmpty()) {
						if(a.getTipo() != ArmType.ZANPAKUTO) {
							JOptionPane.showMessageDialog(null, "Arrancars são permitidos a utilizar somente Zanpakutos.\n"
									+ "Informe outra arma que seja desse tipo!");
							if(aux.getEspada() != null) {
								textArma.setText(aux.getEspada().getNome());
							}else {
								textArma.setText("");
							}
						}
					}
				}
				btnAlterar.setEnabled(true);
			}
			@Override
			public void focusGained(FocusEvent e) {
				btnAlterar.setEnabled(false);
			}
		});
		textArma.setOpaque(false);
		textArma.setEnabled(false);
		textArma.setColumns(10);
		textArma.setBounds(10, 252, 187, 20);
		frmEditarInformaesDe.getContentPane().add(textArma);
		
		JLabel lblNewLabel_1_1 = new JLabel("Arma:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 237, 66, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_1_1);
		
		textOrg = new JTextField();
		textOrg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if((em.find(Organizacao.class, textOrg.getText()) == null) && ! textOrg.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma organização existente!");
					if(aux.getOrganizacao() != null) {
						textOrg.setText(aux.getOrganizacao().getNome());
					}else {
						textOrg.setText("");
					}	
				}
				btnAlterar.setEnabled(true);
			}
			@Override
			public void focusGained(FocusEvent e) {
				btnAlterar.setEnabled(false);
			}
		});
		textOrg.setOpaque(false);
		textOrg.setBounds(383, 295, 130, 20);
		frmEditarInformaesDe.getContentPane().add(textOrg);
		textOrg.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Organização: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_11.setBounds(383, 280, 88, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_11);
		
		JRadioButton rdbtnPercepcao = new JRadioButton("Vê espiritos");
		rdbtnPercepcao.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnPercepcao.setOpaque(false);
		rdbtnPercepcao.setBounds(384, 236, 109, 23);
		frmEditarInformaesDe.getContentPane().add(rdbtnPercepcao);
		
		JLabel lblNewLabel_8_1 = new JLabel("Tempo de morte:");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1.setBounds(220, 255, 109, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_8_1);
		
		JSpinner spMorte = new JSpinner(new SpinnerNumberModel(0,0,200,1));
		spMorte.setFont(new Font("Tahoma", Font.PLAIN, 10));
		spMorte.setEnabled(false);
		spMorte.setBounds(311, 252, 36, 20);
		frmEditarInformaesDe.getContentPane().add(spMorte);
		
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNome.getText().isEmpty()) {
					btnAlterar.setEnabled(false);
					textArma.setEnabled(false);
					btnHabilidades.setEnabled(false);
					comboBox.setEnabled(false);
					rdbtnBankai.setEnabled(false);
					rdbtnCeifado.setEnabled(false);
					rdbtnMorto.setEnabled(false);
					rdbtnQuincy.setEnabled(false);
					rdbtnPercepcao.setEnabled(false);
					spAfinidade.setEnabled(false);
					spAlmas.setEnabled(false);
					spDefesa.setEnabled(false);
					spForca.setEnabled(false);
					spHollows.setEnabled(false);
					spReiatsu.setEnabled(false);
					spReserva.setEnabled(false);
					spVelocidade.setEnabled(false);
					spVida.setEnabled(false);
					spMorte.setEnabled(false);
					textLocal.setEnabled(false);
					textProficao.setEnabled(false);
					txtFraseAoInvocar.setEnabled(false);
				}else {
					aux = em.find(Ser.class, txtNome.getText());
					if(aux==null) {
						JOptionPane.showMessageDialog(null, "O persongem informado não existe.");
						btnAlterar.setEnabled(false);
						textArma.setEnabled(false);
						btnHabilidades.setEnabled(false);
						comboBox.setEnabled(false);
						rdbtnBankai.setEnabled(false);
						rdbtnCeifado.setEnabled(false);
						rdbtnMorto.setEnabled(false);
						rdbtnQuincy.setEnabled(false);
						rdbtnPercepcao.setEnabled(false);
						spAfinidade.setEnabled(false);
						spAlmas.setEnabled(false);
						spDefesa.setEnabled(false);
						spForca.setEnabled(false);
						spHollows.setEnabled(false);
						spReiatsu.setEnabled(false);
						spReserva.setEnabled(false);
						spVelocidade.setEnabled(false);
						spVida.setEnabled(false);
						spMorte.setEnabled(false);
						textLocal.setEnabled(false);
						textProficao.setEnabled(false);
						txtFraseAoInvocar.setEnabled(false);
					}else {
						txtNome.setEnabled(false);
						btnHabilidades.setEnabled(true);
						btnAlterar.setEnabled(true);
						frmEditarInformaesDe.setTitle("Editando: " + aux.getNome());
						
						rdbtnMorto.setEnabled(true);
						rdbtnMorto.setSelected(aux.isMorto());
						
						spReiatsu.setEnabled(true);
						spReiatsu.setValue(aux.getReiatsu());
						
						spReserva.setEnabled(true);
						spReserva.setValue(aux.getRaca().getReservaEspiritual());
						
						spVelocidade.setEnabled(true);
						spVelocidade.setValue(aux.getRaca().getVelocidade());
						
						spVida.setEnabled(true);
						spVida.setValue(aux.getRaca().getVida());
						
						spDefesa.setEnabled(true);
						spDefesa.setValue(aux.getRaca().getDefesa());
						
						spForca.setEnabled(true);
						spForca.setValue(aux.getRaca().getForca());
						
						textLocal.setEnabled(true);
						if(aux.getLocalAtual() != null)
							textLocal.setText(aux.getLocalAtual().getNome());
						
						textOrg.setEnabled(true);
						if(aux.getOrganizacao() != null)
							textOrg.setText(aux.getOrganizacao().getNome());
						
						textRaca.setEnabled(false);
						textRaca.setEditable(false);
						if(aux.getRaca() instanceof Alma) {
							textRaca.setText("Alma");
							Alma alma = (Alma) aux.getRaca();
							
							rdbtnCeifado.setEnabled(true);
							rdbtnCeifado.setSelected(alma.isCeifado());
								
							textProficao.setEnabled(true);
							if(alma.getProfissao() != null)
								textProficao.setText(alma.getProfissao());
							
							spMorte.setEnabled(true);
							spMorte.setValue(alma.getTempoDeMorte());
							
						}else if(aux.getRaca() instanceof Demonio) {
							textRaca.setText("Arranacar");
							Demonio demonio = (Demonio) aux.getRaca();
							
							spHollows.setEnabled(true);
							spHollows.setValue(demonio.getHollowsDevorados());
							
							spAlmas.setEnabled(true);
							spAlmas.setValue(demonio.getAlmasDevoradas());
							
							comboBox.setEnabled(true);
							if(demonio.getTipo() != null)
								comboBox.setSelectedItem(demonio.getTipo());
							
							textArma.setEnabled(true);
							if(aux.getEspada() != null)
								textArma.setText(aux.getEspada().getNome());
							
						}else if(aux.getRaca() instanceof Restrição) {
							textRaca.setText("Hollow");
							Restrição restrição = (Restrição) aux.getRaca();
							
							spHollows.setEnabled(true);
							spHollows.setValue(restrição.getHollowsDevorados());
							
							spAlmas.setEnabled(true);
							spAlmas.setValue(restrição.getAlmasDevoradas());
							
							comboBox.setEnabled(true);
							if(restrição.getTipo() != null)
								comboBox.setSelectedItem(restrição.getTipo());
							
						}else if(aux.getRaca() instanceof Humano) {
							textRaca.setText("Humano");
							Humano humano = (Humano) aux.getRaca();
							
							rdbtnQuincy.setEnabled(true);
							rdbtnQuincy.setSelected(humano.isQuincy());
							
							rdbtnPercepcao.setEnabled(true);
							rdbtnPercepcao.setSelected(humano.isPercepcaoEspiritual()); 
							
							textProficao.setEnabled(true);
							if(humano.getProfissao() != null)
								textProficao.setText(humano.getProfissao());
							
							if(humano.isQuincy()) {
								textArma.setEnabled(true);
								if(aux.getEspada() != null)
									textArma.setText(aux.getEspada().getNome());
							}
							
						}else if(aux.getRaca() instanceof Espadachim) {
							textRaca.setText("Shinigami");
							Espadachim espadachim = (Espadachim) aux.getRaca();
							
							rdbtnBankai.setEnabled(true);
							rdbtnBankai.setSelected(espadachim.isPossuiBankai());
							
							spAfinidade.setEnabled(true);
							spAfinidade.setValue(espadachim.getAfinidadeZanpakuto());
							
							txtFraseAoInvocar.setEnabled(true);
							if(espadachim.getFraseDeEfeito() != null)
								txtFraseAoInvocar.setText(espadachim.getFraseDeEfeito());
							
							textArma.setEnabled(true);
							if(aux.getEspada() != null)
								textArma.setText(aux.getEspada().getNome());
						}
					}
				}
			}
		});
		
		btnAlterar.setEnabled(false);
		btnHabilidades.setEnabled(false);
		comboBox.setEnabled(false);
		rdbtnBankai.setEnabled(false);
		rdbtnCeifado.setEnabled(false);
		rdbtnMorto.setEnabled(false);
		rdbtnQuincy.setEnabled(false);
		rdbtnPercepcao.setEnabled(false);
		spAfinidade.setEnabled(false);
		spAlmas.setEnabled(false);
		spDefesa.setEnabled(false);
		spForca.setEnabled(false);
		spHollows.setEnabled(false);
		spReiatsu.setEnabled(false);
		spReserva.setEnabled(false);
		spVelocidade.setEnabled(false);
		spVida.setEnabled(false);
		spMorte.setEnabled(false);
		textLocal.setEnabled(false);
		textProficao.setEnabled(false);
		txtFraseAoInvocar.setEnabled(false);
		textOrg.setEnabled(false);
		textArma.setEnabled(false);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				
				Organizacao orgAnterior;
				if(aux.getOrganizacao()!=null) {
					orgAnterior = em.find(Organizacao.class, aux.getOrganizacao().getNome());
				}else {
					orgAnterior = null;
				}
				
				if(orgAnterior!=null) {
					orgAnterior.getMembros().remove(aux);
					em.merge(orgAnterior);
				}
				
				if(aux.getLocalAtual()!=null) {
					if(textLocal.getName() != aux.getLocalAtual().getNome()) {
						aux.getLocalAtual().getHabitantes().remove(aux);
						em.merge(aux.getLocalAtual());
					}
				}
				
				evalue(aux);
				
				if(aux.getLocalAtual()!=null) 
					em.merge(aux.getLocalAtual());
				
				em.merge(aux);
				em.merge(aux.getRaca());
				
				if(aux.getEspada()!=null)
					em.merge(aux.getEspada());
				
				if(aux.getOrganizacao()!=null) {
					aux.getOrganizacao().getMembros().add(aux);
					em.merge(aux.getOrganizacao());
				}
				em.getTransaction().commit();
				em.close();
				emf.close();
				JOptionPane.showMessageDialog(null, "Alteração salva com sucesso!");
				frmEditarInformaesDe.dispose();
			}

			private void evalue(Ser s) {
				
				s.setMorto(rdbtnMorto.isSelected());
				s.setReiatsu((int) spReiatsu.getValue());
				s.getRaca().setReservaEspiritual((int) spReserva.getValue());
				s.getRaca().setVelocidade((int) spVelocidade.getValue());
				s.getRaca().setVida((int) spVida.getValue());
				s.getRaca().setDefesa((int) spDefesa.getValue());
				s.getRaca().setForca((int) spForca.getValue());
				s.setLocalAtual(em.find(Local.class, textLocal.getText()));
				s.getLocalAtual().getHabitantes().add(s);
				if(textOrg.getText().isEmpty()) {
					s.setOrganizacao(null);
				}else {
					s.setOrganizacao(em.find(Organizacao.class, textOrg.getText()));
				}
				
				if(aux.getRaca() instanceof Alma) {
					Alma alma = (Alma) s.getRaca();
					alma.setCeifado(rdbtnCeifado.isSelected());
					alma.setProfissao(textProficao.getText());
					alma.setTempoDeMorte((int) spMorte.getValue());
					s.setRaca(alma);
					
				}else if(aux.getRaca() instanceof Demonio) {
					Demonio demonio = (Demonio) aux.getRaca();
					demonio.setHollowsDevorados((int) spHollows.getValue());
					demonio.setAlmasDevoradas((int) spAlmas.getValue());
					demonio.setTipo((EnumHollow) comboBox.getSelectedItem());
					s.setRaca(demonio);
					if(! textArma.getText().isEmpty()) {
						s.setEspada(em.find(Armamento.class, textArma.getText()));
					}else {
						s.setEspada(null);
					}
					
				}else if(aux.getRaca() instanceof Restrição) {
					Restrição restrição = (Restrição) aux.getRaca();
					restrição.setHollowsDevorados((int) spHollows.getValue());
					restrição.setAlmasDevoradas((int) spAlmas.getValue());
					restrição.setTipo((EnumHollow) comboBox.getSelectedItem());
					s.setRaca(restrição);
					
				}else if(aux.getRaca() instanceof Humano) {
					Humano humano = (Humano) aux.getRaca();
					humano.setQuincy(rdbtnQuincy.isSelected());
					humano.setPercepcaoEspiritual(rdbtnPercepcao.isSelected());
					humano.setProfissao(textProficao.getText());
					s.setRaca(humano);
					if(humano.isQuincy() && ! textArma.getText().isEmpty()) {
						s.setEspada(em.find(Armamento.class, textArma.getText()));
					}else {
						s.setEspada(null);
					}
					
				}else if(aux.getRaca() instanceof Espadachim) {
					Espadachim espadachim = (Espadachim) aux.getRaca();
					espadachim.setPossuiBankai(rdbtnBankai.isSelected());
					espadachim.setAfinidadeZanpakuto((int) spAfinidade.getValue());
					espadachim.setFraseDeEfeito(txtFraseAoInvocar.getText());
					s.setRaca(espadachim);
					if(! textArma.getText().isEmpty()) {
						s.setEspada(em.find(Armamento.class, textArma.getText()));
					}else {
						s.setEspada(null);
					}
				}
			}
		});
		
		JLabel lblNewLabel_12 = new JLabel("Anos");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(348, 255, 46, 14);
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_12);
		
		BufferedImage bck = ImageIO.read(new File("src\\main\\resources\\wp3326175.jpg"));
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(0, 0, 536, 360);
		lblNewLabel_10.setIcon(new ImageIcon(bck.getScaledInstance(frmEditarInformaesDe.getWidth() , frmEditarInformaesDe.getHeight(), Image.SCALE_SMOOTH)));
		frmEditarInformaesDe.getContentPane().add(lblNewLabel_10);	
		
	}

}
