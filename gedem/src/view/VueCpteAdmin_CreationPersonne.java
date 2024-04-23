package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ControlFormPersonne;
import model.Role;

public class VueCpteAdmin_CreationPersonne extends JPanel
	implements
	    ActionListener {

    JLabel v1, v2;
    JLabel ml2c1, ml2c3, ml3c1, ml3c3;

    private JLabel label_intro;
    private JLabel label_fa, label_fb, label_fc, label_fd;
    private JLabel label_vide1, label_vide2, label_vide4, label_vide5,
	    label_vide6;
    protected JLabel jmessageLabel, imagelabel; // pour les messages d'erreur à
						// la saisie et/ou validation
    private JLabel label_nom, label_prenom, label_mail, label_tel, label_role,
	    label_login, label_pass;
    private JButton btn_f1;
    private JTextField jt_nom, jt_prenom, jt_mail, jt_tel, jt_login;
    private JComboBox<String> jc_role;
    private JPasswordField jt_pass;
    private ControlFormPersonne cfp;
    private App appli;
    protected Role listeRole;
    private boolean flag_btnf1 = false;
    private boolean flag_jc_role = false;
    public Font messageFont = new Font("Georgia,Helvetica,Serif", Font.PLAIN,
	    18);
    protected ImageIcon image;
    protected int evt_cpt = 0; // compteur pour les clics sur bouton "valider"

    public VueCpteAdmin_CreationPersonne(App appli) {
	this.appli = appli;
	appli.setJMenuBar(appli.getJMenuBar());

	/*
	 * Dimension maNewDim = new Dimension(700,600); appli.setSize(maNewDim);
	 * appli.pack(); Color maCouleur = new Color(180,180,180);
	 * setBackground(maCouleur); setBorder(new LineBorder(Color.cyan));
	 * setLayout(new BorderLayout()); // ensemble principal
	 */
	JPanel intro = new JPanel(new FlowLayout()); // ======================
						     // JPANEL intro
	// intro.setBackground(maCouleur);
	label_intro = new JLabel("Nouveau profil utilisateur");
	label_intro.setHorizontalTextPosition(SwingConstants.CENTER);
	// label_intro.setPreferredSize(getMaximumSize());
	intro.add(label_intro);

	ml2c1 = new JLabel("Tabulation++");
	ml2c3 = new JLabel("Tabulation++");
	ml2c3.setFont(new Font("Serif", Font.PLAIN, 14));

	ml2c1.setForeground(getBackground());
	ml2c3.setForeground(getBackground());
	// ml2c1.setBorder(new LineBorder(Color.red));
	// ml2c3.setBorder(new LineBorder(Color.red));

	JPanel jpmain = new JPanel(new GridLayout(6, 4, 20, 10)); // =============
								  // JPANEL
								  // jpmain
	// line, col, hgap, vgap // second ensemble

	// jpmain.setPreferredSize(new Dimension(24,45));
	label_fa = new JLabel("");
	label_fb = new JLabel("");
	label_fc = new JLabel("");
	label_fd = new JLabel("");

	label_vide1 = new JLabel();
	label_vide2 = new JLabel();
	label_vide4 = new JLabel();
	label_vide5 = new JLabel();
	label_vide6 = new JLabel();

	label_nom = new JLabel("Nom : ");
	label_prenom = new JLabel("Prénom : ");
	label_role = new JLabel("Rôle : ");
	label_tel = new JLabel("Tel: ");
	label_login = new JLabel("Login : ");
	label_pass = new JLabel("Mot de passe : ");
	label_mail = new JLabel("Mail : ");

	jt_nom = new JTextField(25);
	jt_nom.addActionListener(this);
	jt_prenom = new JTextField(25);
	jt_prenom.addActionListener(this);
	jt_mail = new JTextField(25);
	jt_mail.addActionListener(this);
	jt_tel = new JTextField(13);
	jt_tel.addActionListener(this);

	// ================================== JCOMBOBOX liste de roles
	listeRole = new Role(); // instanciation de la classe role
	// et accès à la méthode listerRole()

	jc_role = new JComboBox<>(listeRole.listerRole());
	// On récupère la liste des Roles à partir de la table role
	// en parammètre de JComboBox : le Vector qui contient la liste des
	// roles

	jc_role.addActionListener(this);

	jt_login = new JTextField(16);
	jt_login.addActionListener(this);
	jt_pass = new JPasswordField(16);
	jt_pass.addActionListener(this);

	btn_f1 = new JButton("Enregistrer");
	btn_f1.addActionListener(this);
	flag_btnf1 = false; // valeur par défaut du flag (sert à
			    // l'actionListener)

	jpmain.add(label_fa);
	jpmain.add(label_fb);
	jpmain.add(label_fc);
	jpmain.add(label_fd);
	jpmain.add(label_nom);
	jpmain.add(jt_nom);
	jpmain.add(label_role);
	jpmain.add(jc_role);
	jpmain.add(label_prenom);
	jpmain.add(jt_prenom);
	jpmain.add(label_login);
	jpmain.add(jt_login);
	jpmain.add(label_mail);
	jpmain.add(jt_mail);
	jpmain.add(label_pass);
	jpmain.add(jt_pass);
	jpmain.add(label_tel);
	jpmain.add(jt_tel);
	jpmain.add(label_vide1);
	jpmain.add(label_vide2);
	jpmain.add(label_vide4);
	jpmain.add(label_vide5);
	jpmain.add(label_vide6);
	jpmain.add(btn_f1);
	jpmain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	JPanel conclu = new JPanel(); // ====================== JPANEL conclu
				      // (en bas)
	// conclu.setBackground(maCouleur);
	ImageIcon image = new ImageIcon("./img/eleve2.png");
	imagelabel = new JLabel(image);
	conclu.add(imagelabel);

	jmessageLabel = new JLabel("");
	jmessageLabel.setFont(this.messageFont);
	jmessageLabel.setForeground(Color.RED);
	jmessageLabel.setBackground(Color.BLACK);
	jmessageLabel.setOpaque(true);
	Border marginBorder = new EmptyBorder(10, 10, 10, 10); // pour avoir une
							       // marge autour
							       // de la bordure
	Border labelBorder = new LineBorder(Color.WHITE, 2, true); // couleur,
								   // épaisseur,
								   // round?(boolean)
	jmessageLabel.setBorder(new CompoundBorder(labelBorder, marginBorder)); // bordure
										// composée
										// -
										// couleur,
										// épaisseur,
										// round?(boolean)
	conclu.add(jmessageLabel);

	add(intro, BorderLayout.NORTH);
	add(ml2c1, BorderLayout.WEST);
	add(jpmain, BorderLayout.CENTER);
	add(ml2c3, BorderLayout.EAST);
	add(conclu, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {

	if (evt.getSource() == btn_f1)
	{ // si clic sur le bouton "Enregistrer"
	    flag_btnf1 = true; // permet d'indiquer que le bouton a été
			       // actionné.
	    if (evt_cpt < 1)
	    { // on crée une instance du controleur au premier appui sur
	      // "valider"
		cfp = new ControlFormPersonne(this, appli);
	    } else
	    { // si on veut valider un nouveau profil ou corriger le profil
	      // courant
		cfp.ajouterPersonne();
		evt_cpt += 1;
	    }
	    // cfp.ajouterPersonne();
	}

	if (evt.getSource() == jc_role)
	{ // si sélection de la JComboBox
	    setFlag_jc_role(true); // permet d'indiquer que la JComboBox a été
				   // actionnée
	    String itemSel = jc_role.getSelectedItem().toString();
	    // jc_role.setSelectedItem(jc_role);
	    System.out.println("jc_role.getSelectedItem() " + itemSel);

	    // cfp.ajouterPersonne();

	}

    }

    public JTextField getJt_nom() {
	return jt_nom;
    }
    public void setJt_nom(JTextField jt_nom) {
	this.jt_nom = jt_nom;
    }
    public JTextField getJt_prenom() {
	return jt_prenom;
    }
    public void setJt_prenom(JTextField jt_prenom) {
	this.jt_prenom = jt_prenom;
    }
    public JTextField getJt_mail() {
	return jt_mail;
    }
    public void setJt_mail(JTextField jt_mail) {
	this.jt_mail = jt_mail;
    }
    public JTextField getJt_tel() {
	return jt_tel;
    }
    public void setJt_tel(JTextField jt_tel) {
	this.jt_tel = jt_tel;
    }
    public JTextField getJt_login() {
	return jt_login;
    }
    public void setJt_login(JTextField jt_login) {
	this.jt_login = jt_login;
    }
    public JComboBox<String> getJc_role() {
	return jc_role;
    }
    public void setJc_role(JComboBox<String> jc_role) {
	this.jc_role = jc_role;
    }
    public JPasswordField getJt_pass() {
	return jt_pass;
    }
    public void setJt_pass(JPasswordField jt_pass) {
	this.jt_pass = jt_pass;
    }
    public boolean isFlag_btnf1() {
	return flag_btnf1;

    }
    public void setJmessageLabel(String jmes) {
	this.jmessageLabel.setFont(messageFont);
	this.jmessageLabel.setText(jmes);

    }

    public void setImage(ImageIcon image) {
	this.image = image;
	this.imagelabel.setBackground(Color.yellow);

    }
    public void setJmessageLabelColor(String couleur) {
	Color laCouleur;
	if (couleur.toUpperCase().equals("BLACK"))
	{
	    laCouleur = Color.BLACK;
	} else if (couleur.toUpperCase().equals("WHITE"))
	{
	    laCouleur = Color.white;
	} else
	{
	    laCouleur = Color.red;
	}

	this.jmessageLabel.setForeground(laCouleur);
    }

    public boolean isFlag_jc_role() {
	return flag_jc_role;
    }

    public void setFlag_jc_role(boolean flag_jc_role) {
	this.flag_jc_role = flag_jc_role;
    }
}
