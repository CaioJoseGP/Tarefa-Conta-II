import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanLeitura = new Scanner(System.in);
        ArrayList<ContaCorrente> arrayConta = new ArrayList<>();

        while(true) {
            System.out.println("\nEscolha uma opção:\n" 
                + "1 - Criar uma nova conta\n"
                + "2 - Exibir saldo ou extrato de uma conta\n"
                + "3 - Sacar um valor de uma conta\n"
                + "4 - Depositar um valor em uma conta\n"
                + "5 - Transferir valores de uma conta para outra\n");
            
            String opcao = scanLeitura.nextLine();

            //1 - Criar uma nova conta
            if(opcao.equals("1")) {
                System.out.println("\nVamos criar sua Conta Corrente!");
                System.out.println("Primeiro vamos registrar as informações do Titular.\n");

                //Cadastro -entrada de dados- Titular
                System.out.println("Qual o nome completo?");
                String nomeTitular = scanLeitura.nextLine();

                System.out.println("\nQual o CPF?");
                String cpf = scanLeitura.nextLine();

                System.out.println("\nQual o telefone principal?");
                String telefone = scanLeitura.nextLine();

                //Cadastro -entrada de dados- Endereco
                System.out.println("\nAgora vamos registrar o endereço do Titular.");
                System.out.println("\nQual o logradouro?");
                String logradouro = scanLeitura.nextLine();

                System.out.println("\nQual o bairro?");
                String bairro = scanLeitura.nextLine();

                System.out.println("\nQual o número?");
                int numeroEndereco = scanLeitura.nextInt();
                scanLeitura.nextLine();

                System.out.println("\nQual a cidade?");
                String cidade = scanLeitura.nextLine();

                System.out.println("\nQual o estado?");
                String estado = scanLeitura.nextLine();

                System.out.println("\nQual o CEP?");
                String cep = scanLeitura.nextLine();

                //Cadastro -entrada de dados- Conta Corrente
                System.out.println("\nPor fim, vamos registrar os dados da Conta.");
                System.out.println("\nQual o número da conta?");
                String numeroConta = scanLeitura.nextLine();

                System.out.println("\nQual o banco utilizado? (A agência utilizada será a local)");
                String banco = scanLeitura.nextLine();

                //Inicialização (Constructor Class) Endereco, Titular e Conta
                Endereco endereco = new Endereco(numeroEndereco, logradouro, bairro, cidade, estado, cep);
                Titular titular1 = new Titular(nomeTitular, cpf, telefone, endereco);
                ContaCorrente contaCorrente = new ContaCorrente(numeroConta, banco, titular1);
                contaCorrente.setAgencia("1234-5");

                arrayConta.add(contaCorrente);

            //2 - Exibir saldo ou extrato de uma conta
            } else if(opcao.equals("2")) {
                if(!arrayConta.isEmpty()) {
                    System.out.println("\nDigite o número da conta que deseja extrair o saldo:");
                    String numeroConta = scanLeitura.nextLine();

                    for(int i = 0; i < arrayConta.size(); i++) {
                        ContaCorrente contaAux = arrayConta.get(i);
    
                        if(contaAux.getNumero().equals(numeroConta)) {
                            contaAux.extrato();
                            break;

                        } else if(i == (arrayConta.size() - 1)) {
                            System.out.println("\nNão foram encontradas contas nesse número! Tente novamente.\n");
                        }
                    }

                } else {
                    System.out.println("\nPara isso, por favor cadastre uma Conta Corrente!\n");
                }

            //3 - Sacar um valor de uma conta
            } else if(opcao.equals("3")) {
                if(!arrayConta.isEmpty()) {
                    System.out.println("\nDigite o número da conta que deseja sacar:");
                    String numeroConta = scanLeitura.nextLine();

                    for(int i = 0; i < arrayConta.size(); i++) {
                        ContaCorrente contaAux = arrayConta.get(i);
    
                        if(contaAux.getNumero().equals(numeroConta)) {
                            System.out.println("\nConta encontrada! Digite o valor para sacar:");
                            double valor = scanLeitura.nextDouble();
                            scanLeitura.nextLine();

                            if(contaAux.sacar(valor)) {
                                System.out.println("Saque efetuado com sucesso!\n");
                                break;

                            } else {
                                System.out.println("Saque não efetuado!\n");
                                break;
                            }

                        } else if(i == (arrayConta.size() - 1)) {
                            System.out.println("\nNão foram encontradas contas nesse número! Tente novamente.\n");
                        }
                    }

                } else {
                    System.out.println("\nPara isso, por favor cadastre uma Conta Corrente!\n");
                }

            //4 - Depositar um valor em uma conta
            } else if(opcao.equals("4")) {
                if(!arrayConta.isEmpty()) {
                    System.out.println("\nDigite o número da conta que deseja depositar:");
                    String numeroConta = scanLeitura.nextLine();

                    for(int i = 0; i < arrayConta.size(); i++) {
                        ContaCorrente contaAux = arrayConta.get(i);
    
                        if(contaAux.getNumero().equals(numeroConta)) {
                            System.out.println("\nConta encontrada! Digite o valor para depositar:");
                            double valor = scanLeitura.nextDouble();
                            scanLeitura.nextLine();

                            if(contaAux.depositar(valor)) {
                                System.out.println("Depósito efetuado com sucesso!\n");
                                break;

                            } else {
                                System.out.println("Depósito não efetuado!\n");
                                break;
                            }

                        } else if(i == (arrayConta.size() - 1)) {
                            System.out.println("\nNão foram encontradas contas nesse número! Tente novamente.\n");
                        }
                    }

                } else {
                    System.out.println("\nPara isso, por favor cadastre uma Conta Corrente!\n");
                }

            //5 - Transferir valores de uma conta para outra
            } else if(opcao.equals("5")) {
                if(!arrayConta.isEmpty() && arrayConta.size() >= 2) {
                    System.out.println("\nDigite o número da sua conta:");
                    String numeroContaOrigem = scanLeitura.nextLine();
                    ContaCorrente contaOrigem;

                    for(int i = 0; i < arrayConta.size(); i++) {
                        ContaCorrente contaAux = arrayConta.get(i);
    
                        if(contaAux.getNumero().equals(numeroContaOrigem)) {
                            contaOrigem = contaAux;

                            System.out.println("\nConta encontrada!\n");
                            System.out.println("Digite o número da conta para transferência:");
                            String numeroContaDestino = scanLeitura.nextLine();
                            ContaCorrente contaDestino;

                            for(int x = 0; x < arrayConta.size(); x++) {
                                contaAux = arrayConta.get(x);

                                if(contaAux.getNumero().equals(numeroContaDestino)) {
                                    contaDestino = contaAux;

                                    System.out.println("\nConta encontrada!\n");
                                    System.out.println("Digite o valor de transferência:");
                                    double valor = scanLeitura.nextDouble();
                                    scanLeitura.nextLine();
                                    
                                    if(contaOrigem.transferir(valor, contaDestino)) {
                                        System.out.println("\nTransferência efetuada com sucesso!\n");
                                        break;

                                    } else {
                                        System.out.println("\nTransferência não efetuada!\n");
                                        break;
                                    }

                                } else if(x == (arrayConta.size() - 1)) {
                                    System.out.println("\nErro! Número não coincide com conta para transferência. Tente novamente.\n");
                                }
                            }

                        } else if(i == (arrayConta.size() - 1)) {
                            System.out.println("\nNão foram encontradas contas nesse número! Tente novamente.\n");
                        }
                    }

                } else {
                    System.out.println("\nPara isso, por favor cadastre o número mínimo de contas!\n");
                }

            //Opções fora do escopo (opcao != (1, 2, 3, 4, 5))
            } else {
                System.out.println("\nOpção não encontrada, tente novamente! Lembre-se, isso é um loop infinito, você nunca vai sair daqui hahahahahhaahhahahaahahahhahahahhaehhehe!\n");
            }
        }
    }
}
