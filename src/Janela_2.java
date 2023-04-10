import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_2 extends JFrame {
    private JButton button_1;
    private JFrame frame;
    private JTextField textField;
    private JLabel label_1;
    private JLabel label_2;
    private JTextField textField_1;

    public Janela_2(Valetinho valetinhoMain) {
        super("Adicionar placa ao Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Escolha uma vaga e Digite a Placa para Adicionar!");
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

        this.button_1 = new JButton("Adicionar");
        this.button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinhoMain.Entrada(Integer.parseInt(textField.getText()) ,textField_1.getText());
                    JOptionPane.showMessageDialog(null, "Placa Adicionada!" ,"Sucesso!", JOptionPane.INFORMATION_MESSAGE );

                }catch(EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception e2){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //
        this.button_1.setBounds(10, 100, 564, 66);
        this.button_1.setPreferredSize(new Dimension(180, 40));
        this.button_1.setFocusPainted(false);
        this.button_1.setBackground(Color.GREEN.darker());
        this.button_1.setForeground(Color.WHITE);
        this.button_1.setBorder(BorderFactory.createEmptyBorder());
        this.button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(this.button_1);
        
        textField = new JTextField();
        textField.setBounds(264, 25, 27, 20);
        buttonPanel.add(textField);
        textField.setColumns(10);
        
        label_1 = new JLabel("Vaga:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(210, 28, 56, 14);
        buttonPanel.add(label_1);
        
        label_2 = new JLabel("Placa:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(210, 53, 46, 14);
        buttonPanel.add(label_2);
        
        textField_1 = new JTextField();
        textField_1.setBounds(264, 50, 86, 20);
        buttonPanel.add(textField_1);
        textField_1.setColumns(10);
        

        setVisible(true);
        
        
    }

    public static void main(String[] args) {
        new Janela_2(null);
    }
}


       
          
