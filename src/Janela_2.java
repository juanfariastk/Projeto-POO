import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

public class Janela_2 extends JFrame {

    public Janela_2(Estacionamento valetinhoMain) {
        super("Adicionar placa ao Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        
        
        JPanel content = new JPanel();
        content.setBackground(SystemColor.controlDkShadow);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Escolha uma vaga e Digite a Placa para Adicionar!");
        label.setBounds(10, 11, 564, 105);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        content.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(SystemColor.controlDkShadow);
        buttonPanel.setBounds(0, 127, 584, 234);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        content.add(buttonPanel);
        buttonPanel.setLayout(null);
        
        JTextField textField = new JTextField();
        textField.setBounds(264, 25, 27, 20);
        buttonPanel.add(textField);
        textField.setColumns(10);
        
        JTextField textField_1 = new JTextField();
        textField_1.setBounds(264, 50, 86, 20);
        buttonPanel.add(textField_1);
        textField_1.setColumns(10);

        JButton button_1 = new JButton("Adicionar");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinhoMain.entrar(textField_1.getText(), Integer.parseInt(textField.getText()) );
                    JOptionPane.showMessageDialog(null, "Placa Adicionada!" ,"Sucesso!", JOptionPane.INFORMATION_MESSAGE );

                }catch(EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception e2){
                    JOptionPane.showMessageDialog(null, e2, "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        button_1.setBounds(10, 100, 564, 66);
        button_1.setPreferredSize(new Dimension(180, 40));
        button_1.setBackground(Color.GREEN.darker());
        button_1.setForeground(new Color(0, 255, 0));
        button_1.setBorder(new CompoundBorder());
        button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(button_1);
        
        JLabel label_1 = new JLabel("Vaga:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(210, 28, 56, 14);
        buttonPanel.add(label_1);
        
        JLabel label_2 = new JLabel("Placa:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(210, 53, 46, 14);
        buttonPanel.add(label_2);

        setVisible(true);
        
    }

    public static void main(String[] args) {
        new Janela_2(null);
    }
}


       
          
