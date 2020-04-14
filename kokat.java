import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class kokat implements ActionListener{
    JTextField namein;
		String gender;
		String progdi;
		String konsentrasi;
		JLabel input;
		JLabel inputP;
		JLabel inputK;
		JCheckBox aa,bb,cc;
		public JRadioButton Ti,Si,mp,ti,si,gt;
    public kokat(){
    JFrame frame = new JFrame("Prototype");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = frame.getSize();

    int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
    int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(MyPanelCenter(), BorderLayout.CENTER);

    frame.setSize(720,520);
    frame.setLocation(windowX-720/2, windowY-520/2);
    // frame.pack();
    frame.setVisible(true);
  }
  public JPanel MyPanelCenter(){
  	JPanel panel = new JPanel(new FlowLayout());
  	panel.add(myleftpanel(),BorderLayout.LINE_START);
		panel.add(myrightpanel(),BorderLayout.LINE_END);
  	return panel;
  }
  public JPanel myleftpanel(){
  	JPanel myleftpanel = new JPanel();
		myleftpanel.setLayout(new BoxLayout(myleftpanel, BoxLayout.Y_AXIS));
		myleftpanel.setPreferredSize(new Dimension(280,500));
  	myleftpanel.add(Namepanel());
		myleftpanel.add(Gender());
		myleftpanel.add(Progdi());
		myleftpanel.add(Konsentrasi());
		myleftpanel.add(Ukm());
  	return myleftpanel;
  }
	public JPanel myrightpanel(){
		JPanel myrightpanel = new JPanel(new FlowLayout());
		myrightpanel.setLayout(new BoxLayout(myrightpanel, BoxLayout.Y_AXIS));
		myrightpanel.setPreferredSize(new Dimension(280,500));
		myrightpanel.add(inputPanel());
		return myrightpanel;
	}
	public JPanel inputPanel(){
		JPanel panel = new JPanel(new FlowLayout());
		input = new JLabel("");
		inputP= new JLabel("");
		inputK= new JLabel("");
		panel.setBackground(Color.yellow);
		panel.add(input);
		panel.add(inputP);
		panel.add(inputK);
		return panel;
	}
  public JPanel Namepanel(){
  	JPanel namepanel = new JPanel(new FlowLayout());
		//namepanel.setPreferredSize(new Dimension(280,50));
		namepanel.setBackground(Color.red);
  	JLabel name = new JLabel("Name:");
  	namein = new JTextField(20);
  	namepanel.add(name);
  	namepanel.add(namein);
  	return namepanel;
  }
	public JPanel Gender(){
		JPanel Gender = new JPanel(new FlowLayout());
		JLabel genderl = new JLabel("Gender:")			;
	//	Gender.setPreferredSize(new Dimension(280,50));
		ButtonGroup group = new ButtonGroup();
		JRadioButton male =new  JRadioButton("Male");
		male.addActionListener(this);
		JRadioButton female =new  JRadioButton("Female");
		female.addActionListener(this);
		male.setSelected(true);
		group.add(male);
		group.add(female);
		Gender.add(genderl);
		Gender.add(male);
		Gender.add(female);
		return Gender;
	}
	public JPanel Progdi(){
		JPanel progdi = new JPanel(new FlowLayout());
		JLabel progdil= new JLabel("Progdi:");
	//	progdi.setPreferredSize(new Dimension(280,50));
		progdi.add(progdil);
		ButtonGroup group = new ButtonGroup();
		Si = new JRadioButton("SI");
		Ti = new JRadioButton("TI");
		Si.addActionListener(this);
		Ti.addActionListener(this);
		//Ti.setSelected(true);
		group.add(Ti);
		group.add(Si);
		progdi.add(Ti);
		progdi.add(Si);
		return progdi;
	}
	public JPanel Konsentrasi(){
		JPanel konsentrasi = new JPanel(new FlowLayout());
		JLabel konsentrasil= new JLabel("Konsentrasi:");
		konsentrasi.add(konsentrasil);
//		konsentrasi.setPreferredSize(new Dimension(280,50));
		mp = new JRadioButton("MP");
		ti = new JRadioButton("IT");
		si = new JRadioButton("IS");
		gt = new JRadioButton("GT");
		mp.addActionListener(this);
		ti.addActionListener(this);
		si.addActionListener(this);
		gt.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		group.add(mp);
		group.add(ti);
		group.add(si);
		group.add(gt);
		konsentrasi.add(mp);
		konsentrasi.add(ti);
		konsentrasi.add(si);
		konsentrasi.add(gt);
		si.setVisible(false);
		gt.setVisible(false);
		mp.setVisible(false);
		ti.setVisible(false);
		return konsentrasi;
	}
	public JPanel Ukm(){
		JPanel ukm = new JPanel(new FlowLayout());
		JLabel ukml= new JLabel("UKM:");
		ukm.add(ukml);
//		ukm.setPreferredSize(new Dimension(280,50));
		JCheckBox aa = new JCheckBox("Basket");
		JCheckBox bb = new JCheckBox("Futsal");
		JCheckBox cc = new JCheckBox("Karate");
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		ukm.add(aa);
		ukm.add(bb);
		ukm.add(cc);
		ukm.add(submit);
		return ukm;
	}
  public void actionPerformed (ActionEvent e){
  			String show="";
			String a = namein.getText();
			if(e.getActionCommand()=="Male"){
				gender = "Mr";
			}
			else if (e.getActionCommand()=="Female"){
				gender = "Ms";
			}

			if(e.getActionCommand()=="TI"){
				System.out.println("a");
				mp.setVisible(true);
				ti.setVisible(true);
				si.setVisible(false);
				gt.setVisible(false);
				progdi="TI";
			}
			else if(e.getActionCommand()=="SI"){
				System.out.println("b");
				mp.setVisible(false);
				ti.setVisible(false);
				si.setVisible(true);
				gt.setVisible(true);
				progdi ="SI";
			}
			if(e.getActionCommand()=="MP"){
				konsentrasi = "Mobile Computing";
			}
			else if(e.getActionCommand()=="IT"){
				konsentrasi = "Information engineering";
			}
			else if(e.getActionCommand()=="IS"){
				konsentrasi = "Information System";
			}
			else if(e.getActionCommand()=="GT"){
				konsentrasi="Game Technology";
			}
			input.setText(gender+" "+a);
			inputP.setText(progdi);
			inputK.setText(konsentrasi);
  }
}
