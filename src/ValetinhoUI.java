import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ValetinhoUI {
    private JFrame frame;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton button;
    private JButton button_1;

    private JButton button_2;
    private Valetinho valetinho;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ValetinhoUI window = new ValetinhoUI();
                    window.frame.setVisible(true);
                }catch(Exception ex2){
                    ex2.printStackTrace();
                }
            }
        });
    }

    public ValetinhoUI(){
        this.initialize();
    }
    private void initialize(){
        this.frame = new JFrame();
        this.frame.setTitle("Valetinho beta.01");
        this.frame.setBounds(200, 200, 400, 300);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout((LayoutManager) null);
        this.button = new JButton("?");
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ValetinhoUI.this.valetinho = new Valetinho(99);
                    ValetinhoUI.this.textField.setText("?");
                    ValetinhoUI.this.button_1.setEnabled(true);
                    ValetinhoUI.this.label.setText("?" );
                } catch (Exception ex2) {
                    ValetinhoUI.this.label_2.setText(ex2.getMessage());
                }

            }
        });
        this.button.setBounds(13,11,125,23);
        this.frame.getContentPane().add(this.button);
        this.label_1 = new JLabel("Defina a quantidade de vagas do Valetinho: ");
        this.label_1.setBounds(13,48,245,14);
        this.frame.getContentPane().add(this.label_1);
        this.label_3 = new JLabel("Escolha uma vaga e digite a placa: ");
        this.label_3.setBounds(13,100,200,14);
        this.frame.getContentPane().add(this.label_3);
        this.textField = new JTextField();
        this.textField.setBounds(260,45,35,23);
        this.frame.getContentPane().add(this.textField);
        this.textField.setColumns(5);
        this.button_1 = new JButton("Confirmar");
        this.button.setEnabled(true);
        this.button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinho = new Valetinho(Integer.parseInt(ValetinhoUI.this.textField.getText()));
                    button_1.setEnabled(false);
                    button_2.setEnabled(true);
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex2){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_1.setBounds(13,65,96,23);
        this.frame.getContentPane().add(this.button_1);
        this.frame.getContentPane().add(this.label_3);
        this.textField_1 = new JTextField();
        this.textField_1.setBounds(250, 97, 70,23);
        this.frame.getContentPane().add(this.textField_1);
        this.textField_2 = new JTextField();
        this.textField_2.setBounds(215, 97, 30, 23);
        this.frame.getContentPane().add(this.textField_2);
        this.button_2 = new JButton("Adicionar Placa" );
        this.button_2.setEnabled(false);
        this.button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinho.Entrada(Integer.parseInt(ValetinhoUI.this.textField_2.getText()) ,ValetinhoUI.this.textField_1.getText());
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        this.button_2.setBounds(13,117,126,23);
        this.frame.getContentPane().add(this.button_2);
    }
}
