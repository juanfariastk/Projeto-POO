package tests;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import EstacionamentoException;

public class ValetinhoUI {
    private JFrame frame;
    private JLabel label_1;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private  JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
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
                    button_5.setEnabled(true);
                    button_6.setEnabled(true);
                    button_7.setEnabled(true);
                }catch(EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception e2){
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
                }catch(EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(null, e2, "Erro", JOptionPane.ERROR_MESSAGE);
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
                }catch (EstacionamentoException e1){
                    JOptionPane.showMessageDialog(null, e1, "erro", JOptionPane.ERROR_MESSAGE);
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_3.setBounds(13,168,96,23);
        this.frame.getContentPane().add(this.button_3);
        //
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
                } catch (EstacionamentoException e1){
                    ValetinhoUI.this.textField_5.setText("Inexistente");
                } catch(Exception e2){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_4.setBounds(13, 215, 96,23);
        this.frame.getContentPane().add(button_4);
        this.label_6 = new JLabel("Transferência de placa :");
        this.textField_6 = new JTextField();
        this.textField_7 = new JTextField();
        this.label_6.setBounds(13, 245, 150, 14);
        this.textField_6.setBounds(155, 242, 30,23);
        this.textField_7.setBounds(190, 242, 30, 23);
        this.frame.getContentPane().add(label_6);
        this.frame.getContentPane().add(textField_6);
        this.frame.getContentPane().add(textField_7);
        this.button_5 = new JButton("Transferir");
        this.button_5.setEnabled(false);
        this.button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    valetinho.transfereVaga(Integer.parseInt(ValetinhoUI.this.textField_6.getText()), Integer.parseInt(ValetinhoUI.this.textField_7.getText()));
                    JOptionPane.showMessageDialog(null, "Transferido com sucesso!", "Transferido!", JOptionPane.INFORMATION_MESSAGE);
                }catch(EstacionamentoException  e1){
                    JOptionPane.showMessageDialog(null, e1, "erro", JOptionPane.ERROR_MESSAGE);
                }catch (Exception e2){
                    JOptionPane.showMessageDialog(null, "Erro", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_5.setBounds(13, 262, 96, 23);
        this.frame.getContentPane().add(button_5);
        //
        this.button_6 = new JButton("Listar Geral");
        this.button_6.setEnabled(false);
        this.button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame = new JFrame();
                    frame.setSize(300, 300);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setTitle("Nova Janela");

                    JPanel panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 85, 10, 85));

                    JTextArea areaDeTexto = new JTextArea();
                    areaDeTexto.setEnabled(false);
                    areaDeTexto.setDisabledTextColor(Color.BLACK);
                    areaDeTexto.setBackground(null);
                    areaDeTexto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    areaDeTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
                    areaDeTexto.setAlignmentY(Component.CENTER_ALIGNMENT);
                    areaDeTexto.setPreferredSize(new Dimension(150, 200));

                    JLabel label = new JLabel("Listagem: ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setAlignmentY(Component.CENTER_ALIGNMENT);

                    String[] dadosListagem = valetinho.listagemGeral();

                    String texto ="";
                    for(String s: dadosListagem ){
                        texto+= s  + "\n";
                    }
                    areaDeTexto.setText(texto);

                    panel.add(label);
                    panel.add(areaDeTexto);

                    frame.add(panel);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        this.button_6.setBounds(13,292, 125,23);
        this.frame.getContentPane().add(button_6);
        //
        this.button_7 = new JButton("Listar Livres");
        this.button_7.setEnabled(false);
        this.button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame = new JFrame();
                    frame.setSize(300, 300);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setTitle("Nova Janela");

                    JPanel panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 85, 10, 85));

                    JTextArea areaDeTexto = new JTextArea();
                    areaDeTexto.setEnabled(false);
                    areaDeTexto.setDisabledTextColor(Color.BLACK);
                    areaDeTexto.setBackground(null);
                    areaDeTexto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    areaDeTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
                    areaDeTexto.setAlignmentY(Component.CENTER_ALIGNMENT);
                    areaDeTexto.setPreferredSize(new Dimension(150, 200));

                    JLabel label = new JLabel("Listagem: ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setAlignmentY(Component.CENTER_ALIGNMENT);

                    ArrayList<Integer> dadosListagem = valetinho.listagemLivres();

                    String texto ="";
                    for(Integer i: dadosListagem ){
                        texto += i  + "\n";
                    }
                    areaDeTexto.setText(texto);

                    panel.add(label);
                    panel.add(areaDeTexto);

                    frame.add(panel);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.button_7.setBounds(13,320, 125,23);
        this.frame.getContentPane().add(button_7);
    }
}
