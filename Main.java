

import java.io.FileWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try {
//            Estacionamento est1 = new Estacionamento(10);
//            est1.entrar(1, "asdsads12");
//            est1.entrar(2, "sadadda");
//            est1.entrar(3, "sadadda2311");
//            est1.entrar(5, "asdsads1");
//            est1.entrar(8, "asdsads131");
//            est1.sair(1);
//            //System.out.println(est1.consultarPlaca("asdsads12"));
//            System.out.println(est1);
//            est1.transferirVaga("asdsads12", 4);
//            est1.sair(2);
//            System.out.println(est1);
//            String[] teste = new String[10];
//            teste = est1.listarGeral();
//            System.out.println(Arrays.deepToString(teste));
//            System.out.println(est1.listarLivres());
//            est1.gravarDados();
//            est1.lerDados();
            Valetinho testeValetinho = new Valetinho(10);
            testeValetinho.Entrada(1, "XCZ1JC");
            testeValetinho.Entrada(2, "XYA5F1");
            testeValetinho.Entrada(4, "OPC0B7");
            System.out.println(testeValetinho.consultaPlaca("OPC0B7"));
            testeValetinho.Saida(2);
            testeValetinho.transfereVaga("OPC0B7",2);
            System.out.println(Arrays.deepToString(testeValetinho.listagemGeral()));
            System.out.println(testeValetinho.listagemLivres());
        }catch(Exception e) {
            System.out.println(e);
        }

    }
}
