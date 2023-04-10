import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ValetinhoUIII {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JMenuItem menuItem_1;
    private JMenuItem menuItem_2;
    private JMenuItem menuItem_3;
    private JMenuItem menuItem_4;
    private JMenuItem menuItem_5;
    private JMenuItem menuItem_6;
    private JMenuBar menuBar_1;
    private JMenu menu_1;
    private JLabel label;
    private JLabel label_2;
    private Valetinho valetinhoMain;



    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ValetinhoUIII window = new ValetinhoUIII();
                    window.frame.setVisible(true);
                }catch(Exception ex2){
                    ex2.printStackTrace();
                }
            }
        });
    }

    public ValetinhoUIII(){
        this.initialize();
    }
    
    public void setValetinho(Valetinho valetinho) {
    	this.valetinhoMain = valetinho;
    }
    
    private void initialize(){
        this.frame = new JFrame();
        this.frame.setTitle("Valetinho beta.01");
        this.frame.setBounds(200, 200, 601, 490);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout((LayoutManager) null);
        frame.getContentPane().setLayout(null);
      
        
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 105, 22);
        frame.getContentPane().add(menuBar);
        
        menu = new JMenu("Menu - Valetinho");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Quantidade de vagas");
        menuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	new Janela_1(ValetinhoUIII.this);
                }
        });
        menu.add(menuItem);
        
        menuItem_1 = new JMenuItem("Adicionar Placa");
        menuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_2(valetinhoMain);
        	}
        });
        menu.add(menuItem_1);
        
        menuItem_2 = new JMenuItem("Remover Placa");
        menuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_3(valetinhoMain);
        	}
        });
        menu.add(menuItem_2);
        
        menuItem_3 = new JMenuItem("Consultar placa");
        menuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_4(valetinhoMain);
        	}
        });
        menu.add(menuItem_3);
        
        menuItem_4 = new JMenuItem("Transferir placa");
        menuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_5();
        	}
        
        });
        menu.add(menuItem_4);
        
        menuItem_5 = new JMenuItem("Listar Todas as vagas");
        menuItem_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_6();
        	}
        });
        menu.add(menuItem_5);
        
        menuItem_6 = new JMenuItem("Listar vagas livres");
        menuItem_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_7();
        		
        	}
        });
        menu.add(menuItem_6);
        
        menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(105, 0, 41, 22);
        frame.getContentPane().add(menuBar_1);
        
        menu_1 = new JMenu("Sair                                           ");
        menu_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.dispose();
        	}
        });
        menuBar_1.add(menu_1);
        
        label = new JLabel("Bem Vindo ao Valetinho\r\n");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 44));
        label.setBounds(10, 106, 565, 83);
        frame.getContentPane().add(label);
        
        label_2 = new JLabel("Controle a aplicação pelo Menu!");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBounds(10, 188, 565, 93);
        frame.getContentPane().add(label_2);
        
     
        
    }
} 
