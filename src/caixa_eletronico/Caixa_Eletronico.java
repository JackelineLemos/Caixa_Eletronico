package caixa_eletronico;

import java.util.Scanner;

public class Caixa_Eletronico {
    public static void main(String[] args) {
       Scanner ler = new Scanner (System.in);
       String CPF = "12345678900";//gabarito do CPF
       String cpf; //receptor do cpf
       String SENHA = "01020304";//gabarito da senha
       String senha;// receptor da senha
       float saldo = 1000;//saldo inicial
       float deposito, saque;
       int menu, menu2 = 0, tentativa = 2, bloqueio = 0;
       
       do{
            System.out.println("********BEM VINDE*********");//Início

            System.out.print("Digite o seu CPF: ");//Colher informação do CPF
            cpf = ler.nextLine();

            if(!CPF.equals(cpf)){//Verifica se CPF digitado é diferente do gabarito
                System.out.println("ACESSO NÃO PERMITIDO");

            }else{ 

                do{
                    System.out.print("Digite sua senha: ");//Colher informação da Senha
                    senha = ler.nextLine();

                    if(!senha.equals(SENHA)){//Verificação da senha
                        tentativa--;
                        bloqueio++;
                        System.out.println("Senha Incorretra, ainda restam: " + tentativa + " tentativas");
                    }else{
                        System.out.println("Senha correta");
                        tentativa = 0;
                    }
                }while(tentativa != 0);

                if(bloqueio == 2){//bloqueia a conta caso senha não for verdadeira 
                    System.out.println("Sua conta foi bloqueada. Entre em contato com seu gerente.");
                }else{

                    do{
                        do{
                            System.out.println("*********DIGITE***********");//Colher info da operação desejada
                            System.out.println("1 - Saldo");
                            System.out.println("2 - Depósito");
                            System.out.println("3 - Saque");
                            menu = ler.nextInt();

                            switch(menu){
                                case 1://Saldo (deverá exibir o saldo atual)
                                    System.out.println("Seu saldo atual é de: R$" + saldo);
                                    break;

                                case 2://Depósito (deverá requisitar o valor do depósito e somar ao saldo atual)
                                    System.out.println("Digite o valor que deseja depositar: ");
                                    deposito = ler.nextFloat();
                                    saldo = saldo + deposito;
                                    break;

                                case 3://Saque (deverá requisitar o valor do saque e subtrair o saldo atual)
                                    System.out.println("Digite a quantidade que deseja sacar: ");
                                    saque = ler.nextFloat();
                                    saldo = saldo - saque;
                                    break;

                                default://se opção digitada for falsa
                                    System.out.println("Opção inválida, digite novamente");
                            }
                        }while(menu < 0 || menu > 3);//permite digitar opção até que seja verdadeira

                        System.out.println("Você deseja finalizar a operação? ");
                        System.out.println("0 - Sair ");
                        System.out.println("4 - Voltar ao menu ");
                        menu2 = ler.nextInt();

                        switch(menu2){
                            case 0://Sair
                                System.out.println("Obrigade por utilizar nosso caixa");
                                break;

                            case 4:
                                System.out.println("********MENU*********");

                            default://se opção digitada for falsa
                                System.out.println("****ERRO OPERACIONAL****");
                        }
                    }while(menu2 == 4);//Verificação final
                }
            }
        }while(menu2 == 0);
    }
}
    
    

