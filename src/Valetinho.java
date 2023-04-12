import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Valetinho{
    private JFrame frame;
    private static Estacionamento estacionamentoMain;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Valetinho window = new Valetinho();
                    estacionamentoMain = new Estacionamento(10);
                    window.frame.setVisible(true);
                }catch(Exception ex2){
                    ex2.printStackTrace();
                }
            }
        });
    }

    public Valetinho(){
        this.initialize();
    }
    
    private void initialize(){
        this.frame = new JFrame();
        this.frame.setTitle("Valetinho beta.01");
        this.frame.setBounds(200, 200, 601, 400);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout((LayoutManager) null);
        frame.getContentPane().setLayout(null);
      
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 105, 22);
        frame.getContentPane().add(menuBar);
        
        JMenu menu = new JMenu("Menu - Valetinho");
        menuBar.add(menu);
        
        
        JMenuItem menuItem_1 = new JMenuItem("Adicionar Placa");
        menuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_2(estacionamentoMain);
        	}
        });
        menu.add(menuItem_1);
        
        JMenuItem menuItem_2 = new JMenuItem("Remover Placa");
        menuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_3(estacionamentoMain);
        	}
        });
        menu.add(menuItem_2);
        
        JMenuItem menuItem_3 = new JMenuItem("Consultar placa");
        menuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_4(estacionamentoMain);
        	}
        });
        menu.add(menuItem_3);
        
        JMenuItem menuItem_4 = new JMenuItem("Transferir placa");
        menuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_5(estacionamentoMain);
        	}
        
        });
        menu.add(menuItem_4);
        
        JMenuItem menuItem_5 = new JMenuItem("Listar Todas as vagas");
        menuItem_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_6(estacionamentoMain);
        	}
        });
        menu.add(menuItem_5);
        
        JMenuItem menuItem_6 = new JMenuItem("Listar vagas livres");
        menuItem_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Janela_7(estacionamentoMain);
        		
        	}
        });
        menu.add(menuItem_6);
        
        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(105, 0, 41, 22);
        frame.getContentPane().add(menuBar_1);
        
        JMenu menu_1 = new JMenu("Sair                                           ");
        menu_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.dispose();
        	}
        });
        menuBar_1.add(menu_1);
        
        JLabel label = new JLabel("Bem Vindo ao Valetinho\r\n");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 44));
        label.setBounds(10, 106, 565, 83);
        frame.getContentPane().add(label);
        
        JLabel label_2 = new JLabel("Controle a aplicação pelo Menu!");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBounds(10, 188, 565, 93);
        frame.getContentPane().add(label_2);
        
    }
} 
