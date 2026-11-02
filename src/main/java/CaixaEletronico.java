import javax.swing.*;

public class CaixaEletronico {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        boolean saida ,verificadorDeLogin = true;
        String entrada1="",entrada2="",saidaDeTexto="";
        int numeroParaSair=0,numero1;
        double saldoBaseDoUsuario1=2000,dividaDoUsuario1=0, investir=0;
        do {
            boolean loop=false;
            int numeroSeletor1=0;
            double taxaDeInvestimento;
            //========================================4===========================
            // Entrada do caixa simples
            if(verificadorDeLogin)
            do {
                saidaDeTexto = """
                        ===========================
                                Banco Milagre
                        ===========================
                        Bem-vindo ao banco milagre onde seu pão e vinho se multiplica
                        [1] Entrar na conta
                        [2] sair
                        ===========================
                        """;
                verificadorDeLogin=false;

                entrada1 = JOptionPane.showInputDialog(frame, saidaDeTexto);
                numero1 = Integer.parseInt(entrada1);
                if (numero1 == 1)
                {loop = true;
                } else if (numero1 == 2)
                {loop = true;
                    numeroParaSair = numero1;
                } else if (numero1 > 2) {
                    JOptionPane.showMessageDialog(frame," Tente novamente numero invalido");
                    loop = false;
                }
            }while(!loop);
            loop=true;
            saidaDeTexto="";
        //===============================================================
            // painel de escolha de operacao
            if(numeroParaSair != 2){
                do {
                    String nomeUsuario1 = "Carlinhos cão";
                    int idadeUsuario1 = 23;
                    saidaDeTexto = String.format("""
                            ==================================
                                     Banco Milagre
                            ==================================
                            Dados da conta
                            =================================
                            nome: %s
                            Idade: %d
                            saldo: %.2f
                            Divida:%.2f
                            ==================================
                            [1] Depositar
                            [2] Sacar
                            [3] investir
                            [4] sair
                            ==================================
                            """,nomeUsuario1,idadeUsuario1,saldoBaseDoUsuario1,dividaDoUsuario1);
                     entrada1 = JOptionPane.showInputDialog(frame, saidaDeTexto);
                     numero1 = Integer.parseInt(entrada1);
                     if (numero1 > 5) {
                         JOptionPane.showMessageDialog(frame," Tente novamente numero invalido");
                         loop = false;
                     }else if (numero1 == 4) {numeroParaSair = 2; loop = true;
                     }else if (numero1 == 3) {numeroSeletor1 = numero1; loop = true;
                     }else if (numero1 == 2) {numeroSeletor1 = numero1; loop = true;
                     }else if (numero1 ==  1) {numeroSeletor1 = numero1; loop = true;
                     }
                }while(!loop);
                loop=true;
                saidaDeTexto="";
            }
            //================================================================================
            if(numeroParaSair!=2) {
                if (numeroSeletor1==1){
                    //Deposito
                    entrada2 = JOptionPane.showInputDialog(frame,"quanto voce quer depositar");
                    double deposito = Double.parseDouble(entrada2);
                    saldoBaseDoUsuario1+=deposito;
                } else if (numeroSeletor1 == 2) {
                    // saque de dinheiro
                    entrada2 = JOptionPane.showInputDialog(frame,"quanto voce Sacar");
                    double sacar = Double.parseDouble(entrada2);
                    if ((saldoBaseDoUsuario1-sacar)>=0 ){
                    saldoBaseDoUsuario1-=sacar;
                    }else { JOptionPane.showMessageDialog(frame,"Saldo insuficiente");}
                } else if (numeroSeletor1 == 3) {
                    // Investimento
                    entrada2 = JOptionPane.showInputDialog(frame,"quanto voce investir");
                     investir = Double.parseDouble(entrada2);
                    entrada2 = JOptionPane.showInputDialog(frame,"quanto Anos voce quer investir");
                    int anos = Integer.parseInt(entrada2);
                   if ((saldoBaseDoUsuario1-investir) <= saldoBaseDoUsuario1 ) {
                       saldoBaseDoUsuario1 -= investir;
                       if (anos > 5) {
                           taxaDeInvestimento = 0.1;
                       } else {
                           taxaDeInvestimento = 0.05;
                       }
                       for (int i = 1; i < anos; i++) {
                           double resultadoDoInvestimento = investir * taxaDeInvestimento;
                           investir += resultadoDoInvestimento;
                           System.out.println(investir);
                       }
                       saldoBaseDoUsuario1 += investir;
                   }else {
                       JOptionPane.showMessageDialog(frame,"Saldo insuficiente");
                   }


                }

            }




         saida = (numeroParaSair == 2) ? true : false;
        }while (!(saida));
frame.dispose();

    }
}



