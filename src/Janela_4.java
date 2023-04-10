import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_4 extends JFrame {
    private JButton button_1;
    private JFrame frame;
    private JLabel label_2;
    private JTextField textField_1;
    private JTextField textField_2;

    public Janela_4(Valetinho valetinhoMain) {
        super("Consultar Placa do Estacionamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        setContentPane(content);
        content.setLayout(null);

        JLabel label = new JLabel("Digite uma placa para Consultar!");
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

        this.button_1 = new JButton("Consultar");
        this.button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int vagaPlaca = valetinhoMain.consultaPlaca(textField_1.getText());
                    if(vagaPlaca > 0){
                    	textField_2.setVisible(true);
                        textField_2.setText("Vaga: "+vagaPlaca);
                    }
                } catch (EstacionamentoException e1){
                	textField_2.setVisible(true);
                    textField_2.setText("Inexistente");
                } catch(Exception e2){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_1.setBounds(10, 83, 564, 66);
        this.button_1.setPreferredSize(new Dimension(180, 40));
        this.button_1.setFocusPainted(false);
        this.button_1.setBackground(Color.GREEN.darker());
        this.button_1.setForeground(Color.WHITE);
        this.button_1.setBorder(BorderFactory.createEmptyBorder());
        this.button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(this.button_1);
        
        label_2 = new JLabel("Placa:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(211, 29, 46, 14);
        buttonPanel.add(label_2);
        
        textField_1 = new JTextField();
        textField_1.setBounds(258, 26, 86, 20);
        buttonPanel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(258, 56, 86, 20);
        buttonPanel.add(textField_2);
        textField_2.setColumns(10);
        textField_2.setVisible(false);
        

        setVisible(true);
        
        
    }

    public static void main(String[] args) {
        new Janela_4(null);
    }
}


       
          
