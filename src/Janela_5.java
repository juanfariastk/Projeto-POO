import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_5 extends JFrame {
    private JButton button_1;
    private JLabel label_2;
    private JTextField textField_1;
    private JLabel label_1;
    private JTextField textField;

    public Janela_5(Estacionamento valetinhoMain) {
        super("Transferir Placa do Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);

        JPanel content = new JPanel();
        content.setBackground(SystemColor.controlDkShadow);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Digite as Placas para Transferência!");
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

        this.button_1 = new JButton("Transferir");
        this.button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinhoMain.transferir(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField.getText()));
                    JOptionPane.showMessageDialog(null, "Transferido com sucesso!", "Transferido!", JOptionPane.INFORMATION_MESSAGE);
                }catch(EstacionamentoException  e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null,"Tipo de parâmetro incorreto! Digite um número de vaga válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (Exception e3){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        this.button_1.setBounds(10, 97, 564, 66);
        this.button_1.setPreferredSize(new Dimension(180, 40));
        this.button_1.setFocusPainted(false);
        this.button_1.setBackground(Color.GREEN.darker());
        this.button_1.setForeground(Color.WHITE);
        this.button_1.setBorder(BorderFactory.createEmptyBorder());
        this.button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(this.button_1);
        
        label_1 = new JLabel("Vaga Destino:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(147, 54, 86, 14);
        buttonPanel.add(label_1);
        
        label_2 = new JLabel("Vaga Origem:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(157, 29, 76, 14);
        buttonPanel.add(label_2);
        
        textField_1 = new JTextField();
        textField_1.setBounds(258, 26, 86, 20);
        buttonPanel.add(textField_1);
        textField_1.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(258, 52, 86, 20);
        buttonPanel.add(textField);
        textField.setColumns(10);
        

        setVisible(true);
        
        
    }

    public static void main(String[] args) {
        new Janela_5(null);
    }
}


       
          
