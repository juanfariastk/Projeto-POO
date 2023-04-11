import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_6 extends JFrame {

    public Janela_6(Valetinho valetinhoMain) {
        super("Listar vagas do Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        

        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Listar Vagas Do Estacionamento!\r\n");
        label.setBounds(10, 11, 564, 105);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        content.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 127, 584, 234);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        content.add(buttonPanel);
        buttonPanel.setLayout(null);

        JButton button_1 = new JButton("Listar\r\n");
        
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 350));
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        textArea.setFont(new Font("Tahoma", Font.BOLD, 11));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 564, 120);
        
        buttonPanel.add(scrollPane);
        
        button_1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                try{
                	String[] dadosListagem = valetinhoMain.listagemGeral();
                	String texto ="";
                    for(String s: dadosListagem ){
                        texto+= s  + "\n";
                    }                    
                    textArea.setText(texto);

                }catch (Exception e3){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
       
        button_1.setBounds(10, 141, 564, 66);
        button_1.setPreferredSize(new Dimension(180, 40));
        button_1.setFocusPainted(false);
        button_1.setBackground(Color.GREEN.darker());
        button_1.setForeground(Color.WHITE);
        button_1.setBorder(BorderFactory.createEmptyBorder());
        button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        buttonPanel.add(button_1);        
        setVisible(true);       
        
    }

    public static void main(String[] args) {
        new Janela_6(null);
    }
}


       
          
