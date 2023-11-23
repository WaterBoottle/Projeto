package br.italo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import br.italo.autenticacao.Autentica;
import br.italo.conexao.Conexao;
import br.italo.modelos.Cliente;


public class Main {

	static Connection con;
	static PreparedStatement pmp;
    public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		con = Conexao.conectar();

		if ( con != null) {

            int opcao;

            do {
                System.out.println("Menu: ");
                System.out.println("1 - Cadastrar dados");
                System.out.println("2 - Fazer login");
                System.out.println("3 - Esqueci senha");
                System.out.println("4 - Acessar menu administrativo");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma op��o: ");

                opcao = scanner.nextInt();

                switch (opcao) {

                    case 1:
                        System.out.println("Voc� escolheu: Cadastrar dados");

                        Cliente usuario = new Cliente();

                        System.out.println();
                        System.out.println("Insira seu nome: ");
                        usuario.setNome(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu sobrenome: ");
                        usuario.setSobrenome(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu CPF: ");
                        usuario.setCPF(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu RG: ");
                        usuario.setRG(scanner.next());
                        System.out.println();
                        System.out.println("Insira sua data de nascimento em yyyy-mm-dd: ");
                        usuario.setDataNasc(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu genero: ");
                        usuario.setGenero(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu numero de telefone: ");
                        usuario.setNumTel(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu email: ");
                        usuario.setEmail(scanner.next());
                        System.out.println();
                        System.out.println("Insira sua senha: ");
                        usuario.setSenha(scanner.next());
                        System.out.println();

                        pmp = con.prepareStatement("insert into banco.cliente (nome, sobrenome, CPF, RG, dataNascimento, genero, numTelefone, email, endere�o, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                        pmp.setString(1, usuario.getNome());
                        pmp.setString(2, usuario.getSobrenome());
                        pmp.setString(3, usuario.getCPF());
                        pmp.setString(4, usuario.getRG());
                        pmp.setString(5, usuario.getDataNasc());
                        pmp.setString(6, usuario.getGenero());
                        pmp.setString(7, usuario.getNumTel());
                        pmp.setString(8, usuario.getEmail());
                        pmp.setString(9, usuario.getEndereco());
                        pmp.setString(10, usuario.getSenha());

                        pmp.executeUpdate();


                        System.out.println("Usu�rio cadastrado com sucesso");
                        break;


                    case 2:
                        System.out.println("Voc� escolheu: Fazer Login");

                        Cliente validacao = new Cliente();

                        System.out.println("Insira seu CPF: ");
                        validacao.setCPF(scanner.next());
                        System.out.println();
                        System.out.println("Insira sua senha: ");
                        validacao.setSenha(scanner.next());

                        if (Autentica.autenticarSistema(validacao.getCPF(), validacao.getSenha())) {

                            System.out.println("Usu�rio validado!");
                            System.out.println();
                            System.out.println("Deseja realizar uma nova loca��o de veiculo?");

                            //inserir aqui c�digo para loca��o

                        }
                        else {

                            System.out.println("Usu�rio n�o encontrado, por favor reset sua senha ou realize seu cadastro");

                        }

                        break;


                    case 3:
                        System.out.println("Voc� escolheu: Esqueci minha senha");

                        Cliente resetdeSenha = new Cliente();

                        System.out.println("Insira seu CPF: ");
                        resetdeSenha.setCPF(scanner.next());
                        System.out.println();
                        System.out.println("Insira seu email: ");
                        resetdeSenha.setEmail(scanner.next());

                        if (Autentica.autenticarResetdeSenha(resetdeSenha.getCPF(), resetdeSenha.getEmail())) {

                            System.out.println("Usu�rio encontrado");
                            System.out.println();
                            System.out.println("Insira uma nova senha: ");
                            resetdeSenha.setSenha(scanner.next());

                            pmp = con.prepareStatement("UPDATE cliente SET senha = '"+resetdeSenha.getSenha()+"' WHERE CPF = '"+resetdeSenha.getCPF()+"'");
                            pmp.executeUpdate();

                            System.out.println("Senha atualizada com sucesso, retorne ao menu de login");

                        }
                        else {

                            System.out.println("Usu�rio n�o encontrado");

                        }

                        break;


                    case 4:
                        System.out.println("Voc� escolheu: Acessar o menu administrativo");

                        do {
                            System.out.println("Menu Administrativo: ");
                            System.out.println("1 - Cadastrar dados");
                            System.out.println("2 - Fazer login");
                            System.out.println("3 - Esqueci senha");
                            System.out.println("4 - Gerir produtos em estoque");
                            System.out.println("5 - Gerir pagamento");
                            System.out.println("6 - Gerir vendas");
                            System.out.println("7 - Sair do menu administrativo");
                            System.out.print("Escolha uma op��o: ");

                            opcao = scanner.nextInt();

                            switch (opcao) {

                                case 1:
                                    System.out.println("Voc� escolheu: Cadastrar dados");
                                    //c�digo para cadastro administrativo
                                    break;


                                case 2:
                                    System.out.println("Voc� escolheu: Fazer login");
                                    //c�digo para login administrativo
                                    break;


                                case 3:
                                    System.out.println("Voc� escolheu: Esqueci senha");
                                    //c�digo para reset de senha administrativo
                                    break;


                                case 4:
                                    System.out.println("Voc� escolheu: Gerir produtos em estoque");
                                    //c�digo para gerir estoque
                                    break;


                                case 5:
                                    System.out.println("Voc� escolheu: Gerir pagamento");
                                    //c�digo para gerir pagamentos
                                    break;


                                case 6:
                                    System.out.println("Voc� escolheu: Gerir vendas");
                                    //c�digo para gerir vendas
                                    break;


                                case 7:
                                    System.out.println("Voc� escolheu: Sair do menu administrativo");
                                    break;


                                default:
                                    System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");
                            }
                        } while (opcao != 7);

                        System.out.println("Saindo do menu administrativo");

                        break;


                    case 5:
                        System.out.println("Voc� escolheu: Sair");

                        break;


                    default:
                        System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");
                }

            } while (opcao != 5);

            System.out.println("Programa encerrado.");

        }
		else {

			System.out.println("Sem conex�o!!");

		}
	}
}