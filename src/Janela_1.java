import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Janela_1 extends JFrame {

    public Janela_1(ValetinhoUIII valetinhoUIII) {
        super("Vagas do Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
       

        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Escolha o Número de Vagas do Estacionamento!");
        label.setBounds(10, 32, 564, 84);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        content.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 127, 584, 234);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        content.add(buttonPanel);
        buttonPanel.setLayout(null);
        
        JTextField textField = new JTextField();
        textField.setBounds(276, 25, 74, 20);
        buttonPanel.add(textField);
        textField.setColumns(10);

        JButton button_1 = new JButton("Definir número de vagas");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Valetinho valetinho = new Valetinho(Integer.parseInt(textField.getText()));
                    valetinhoUIII.setValetinho(valetinho);
                    JOptionPane.showMessageDialog(null, "Valetinho Criado!" ,"Sucesso!", JOptionPane.INFORMATION_MESSAGE );
                    button_1.setEnabled(false);

                }catch(EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception e2){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        button_1.setBounds(10, 69, 564, 66);
        button_1.setPreferredSize(new Dimension(180, 40));
        button_1.setFocusPainted(false);
        button_1.setBackground(Color.GREEN.darker());
        button_1.setForeground(Color.WHITE);
        button_1.setBorder(BorderFactory.createEmptyBorder());
        button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(button_1);
        
        JLabel label_1 = new JLabel("Quantas vagas você deseja?");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(98, 28, 168, 14);
        buttonPanel.add(label_1);
        
        setVisible(true);  
        
    }

    public static void main(String[] args) {
        new Janela_1(null);
    }
}


       
          
