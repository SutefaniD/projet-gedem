package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.ControlLogin;

public class ViewConnection extends JPanel implements ActionListener {

	private JLabel labelTitre;
	private JLabel labelLogin;
	private JLabel labelMdp;
	private JLabel message;
	private JLabel message2;
	private JCheckBox montreMdp;
	private JTextField uLogin;
	private JPasswordField uPassword;
	private JButton bouton_val;
	private JButton reset_btn;
	private App appli;


	/**
	 * CONSTRUCTEUR ViewConnection
	 * @param app_conn : vue de l'app principale (JFrame)
	 */
	public ViewConnection(App app_conn) {		

		this.appli = app_conn;
		
		this.setLayout(null);

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		labelTitre = new JLabel("Se connecter à GEDEM");
		labelTitre.setFont(new Font("Verdana", Font.PLAIN, 38));
		labelTitre.setBounds(100, 0, 500, 40);
		labelTitre.setForeground(new Color(100,100,250));

		labelLogin = new JLabel("Utilisateur : ");
		labelLogin.setBounds(100, 100, 100, 40);
		
		//TODO Limiter à 25 caracteres
		uLogin = new JTextField(25); // login = int(25) dans BDD
		uLogin.setBounds(200, 100, 200, 40);
		uLogin.addActionListener(this);
		
		labelMdp = new JLabel("Mot de passe : ");
		labelMdp.setBounds(100, 200, 100, 40);
		
		// TODO Limiter à 25 caracteres + regle mdp fort ?
		uPassword = new JPasswordField(25); // mdp = int(25) dans BDD
		uPassword.setBounds(200, 200, 200, 40);
		uPassword.addActionListener(this);
		
		montreMdp = new JCheckBox("Montrer le mot de passe");
		montreMdp.setBounds(450, 200, 300, 40);
		montreMdp.addActionListener(this);
		
		bouton_val = new JButton("Valider");
		bouton_val.setBounds(300, 300, 100, 40);
		bouton_val.addActionListener(this);
		
		reset_btn = new JButton("Effacer");
		reset_btn.setBounds(100, 300, 100, 40);
		reset_btn.addActionListener(this);
		
		message = new JLabel("");
		message.setBounds(100, 400, 300, 40);
		message2 = new JLabel("CONNEXION REFUSEE");
		

		this.add(labelTitre);
		this.add(labelLogin);
		this.add(uLogin);
		this.add(labelMdp);
		this.add(uPassword);
		this.add(montreMdp);	
		this.add(bouton_val);
		this.add(reset_btn);
		this.add(message);

	} 


//-- ACCESSEURS --------------------------------------------------------------------------------

	public JTextField getULogin() {
		return uLogin;
	}


	public void setULogin(JTextField login) {
		this.uLogin = login;
	}


	public JPasswordField getUPassword() {
		return uPassword;
	}


	public void setUPassword(JPasswordField password) {
		this.uPassword = password;
	}
	
	/**
	 * @return the message
	 */
	public JLabel getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(JLabel msg) {
		this.message = msg;
	}

	/**
	 * @return the message2
	 */
	public JLabel getMessage2() {
		return message2;
	}


	/**
	 * @param message2 the message2 to set
	 */
	public void setMessage2(JLabel message2) {
		this.message2 = message2;
	}

	

//--- GESTION DES ACTIONS ------------------------------------------------------------------------------- 



	public void addActionEvent() {
	// ajouter des actions listener aux boutons
		bouton_val.addActionListener(this);
	    reset_btn.addActionListener(this);
	    montreMdp.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		/*
		 Lorsque le bouton est actionné, on fait appel au constructeur du controleur ControlLogin,
		 en lui passant en paramètres cette Vue ViewConnexion (grâce au mot-clé this), et la Frame actuelle
		 avec appli (instance de App en cours)

		*/
		if (evt.getSource() == bouton_val) {
			new ControlLogin(this,appli);
		}
		
		// si on appuie sur [ENTREE] dans le champ password du formulaire --> changement de couleur
		// ça sert à rien mais c'est tellement bien...
		if (evt.getSource() == uPassword) {
			
			uPassword.setForeground(Color.RED);
			uPassword.setFont(new Font("serif", Font.PLAIN, 42));
			setBackground(new Color(200,130,220));
			
			// idem le message suivant s'affiche
			this.setMessage(new JLabel("CONNEXION REFUSEE"));
			message.setForeground(Color.RED);
			message.setBounds(100, 400, 300, 40);
			this.add(message);
			
			
		}
		
		// Si on appuie sur EFFACER
        if (evt.getSource() == reset_btn) {
            uLogin.setText("");
            uPassword.setText("");
        }
       
        // Quand on coche la JCheckBox montreMdp
        if (evt.getSource() == montreMdp) {
            if (montreMdp.isSelected()) {
                uPassword.setEchoChar((char) 0);
            } else {
                uPassword.setEchoChar('*');
            }
        }
}
	
	// ????
	public void pbConnect() {
		JLabel refus = new JLabel("Pas bon.");
		this.add(refus);
	}
}
