package cursinhos;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ICursoDAO cursoDAO = new CursoDAOImplementacoes();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vinde ao Sistema de Cursos. O que deseja fazer?");

        while (true) {
            System.out.println("Opções:");
            System.out.println("1 - Criar curso");
            System.out.println("2 - Listar todos os cursos");
            System.out.println("3 - Listar cursos por professor");
            System.out.println("4 - Editar curso");
            System.out.println("5 - Excluir curso");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    OperacoesCurso.criarCurso(cursoDAO, scanner);
                    break;
                case 2:
                    OperacoesCurso.listarTodosCursos(cursoDAO);
                    break;
                case 3:
                    OperacoesCurso.listarCursosPorProfessor(cursoDAO, scanner);
                    break;
                case 4:
                    OperacoesCurso.editarCurso(cursoDAO, scanner);
                    break;
                case 5:
                    OperacoesCurso.excluirCurso(cursoDAO, scanner);
                    break;
                case 6:
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}

