import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ValetinhoUI {
    private JFrame frame;
    private JLabel label_1;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private  JTextField textField_5;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
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
        this.frame.setBounds(200, 200, 400, 500);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout((LayoutManager) null);
        //
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
        this.button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinho = new Valetinho(Integer.parseInt(ValetinhoUI.this.textField.getText()));
                    button_1.setEnabled(false);
                    button_2.setEnabled(true);
                    button_3.setEnabled(true);
                    button_4.setEnabled(true);
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex2){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //
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
                    JOptionPane.showMessageDialog(null, "Placa adicionada com sucesso" ,"Adicionada!", JOptionPane.INFORMATION_MESSAGE );
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        this.button_2.setBounds(13,117,126,23);
        this.frame.getContentPane().add(this.button_2);
        this.label_4 = new JLabel("Digite uma vaga para remover: " );
        this.label_4.setBounds(13,150,200,14);
        this.frame.getContentPane().add(this.label_4);
        this.textField_3 = new JTextField();
        this.textField_3.setBounds(190, 147, 30, 23);
        this.button_3 = new JButton("Remover");
        this.frame.getContentPane().add(this.textField_3);
        this.button_3.setEnabled(false);
        this.button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int acao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a vaga: " + ValetinhoUI.this.textField_3.getText(), "Remover Vaga", JOptionPane.OK_CANCEL_OPTION);
                    if(acao == JOptionPane.OK_OPTION){
                        valetinho.Saida(Integer.parseInt(ValetinhoUI.this.textField_3.getText()));
                        JOptionPane.showMessageDialog(null, "Removido com Sucesso!", "Removida!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_3.setBounds(13,168,96,23);
        this.frame.getContentPane().add(this.button_3);

        this.label_5 = new JLabel("Digite uma placa para consultar: ");
        this.label_5.setBounds(13,197, 200, 14);
        this.frame.getContentPane().add(this.label_5);
        this.textField_4 = new JTextField();
        this.textField_4.setBounds(199, 194, 65, 23);
        this.frame.getContentPane().add(textField_4);
        this.textField_5 = new JTextField();
        this.textField_5.setBounds(275, 194, 65,23);
        this.frame.getContentPane().add(this.textField_5);
        this.textField_5.setEnabled(false);
        this.textField_5.setDisabledTextColor(Color.BLACK);
        this.button_4 = new JButton("Consultar");
        this.button_4.setEnabled(false);
        this.button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int vagaPlaca = valetinho.consultaPlaca(ValetinhoUI.this.textField_4.getText());
                    if(vagaPlaca > 0){
                        ValetinhoUI.this.textField_5.setText("Vaga: "+vagaPlaca);
                    }
                } catch (Exception e1){
                    ValetinhoUI.this.textField_5.setText("Inexistente");
                }
            }
        });
        this.button_4.setBounds(13, 215, 96,23);
        this.frame.getContentPane().add(button_4);
    }
}
