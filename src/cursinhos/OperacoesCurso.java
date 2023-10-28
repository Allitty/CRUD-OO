package cursinhos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacoesCurso {
    public static void criarCurso(ICursoDAO cursoDAO, Scanner scanner) {
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Nome do professor: ");
        String prof = scanner.nextLine();
        System.out.print("Descrição do curso: ");
        String desc = scanner.nextLine();
        System.out.print("Preço do curso: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        Curso curso = new Curso(0, nome, prof, desc, valor);
        cursoDAO.salvar(curso);
        System.out.println("Curso criado com sucesso!");
    }

	public static void listarTodosCursos(ICursoDAO cursoDAO) {
		System.out.println("Lista de todos os cursos:");
		for (Curso curso : cursoDAO.listarTodos()) {
			System.out.println(curso.getId() + ": " + "Curso: " + curso.getNome() + " - " + "Professor(a): "
					+ curso.getProf() + " - " + "Descrição: " + curso.getDesc() + " - " + "Valor: " + curso.getValor());
		}
	}
    
    public static void listarCursosPorProfessor(ICursoDAO cursoDAO, Scanner scanner) {
        System.out.print("Digite o nome do professor: ");
        String professor = scanner.nextLine();
        
        List<Curso> cursosDoProfessor = new ArrayList<>();
        
        for (Curso curso : cursoDAO.listarTodos()) {
            if (professor.equalsIgnoreCase(curso.getProf())) {
                cursosDoProfessor.add(curso);
            }
        }
        
        if (cursosDoProfessor.isEmpty()) {
            System.out.println("Nenhum curso encontrado para o professor: " + professor);
        } else {
            System.out.println("Cursos ministrados pelo professor " + professor + ":");
			for (Curso curso : cursosDoProfessor) {
				System.out.println(
						curso.getId() + ": " + "Curso: " + curso.getNome() + " - " + "Professor(a): " + curso.getProf()
								+ " - " + "Descrição: " + curso.getDesc() + " - " + "Valor: " + curso.getValor());
			}
        }
    }

    
    public static void editarCurso(ICursoDAO cursoDAO, Scanner scanner) {
        System.out.print("Digite o ID do curso que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoDAO.buscarPorId(id);
        if (curso != null) {
            System.out.print("Novo nome do curso: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo professor: ");
            String novoProf = scanner.nextLine();
            System.out.print("Nova descrição: ");
            String novaDesc = scanner.nextLine();
            System.out.print("Novo valor do curso: ");
            double novoValor = scanner.nextDouble();
            scanner.nextLine(); 

            curso.setNome(novoNome);
            curso.setProf(novoProf);
            curso.setDesc(novaDesc);
            curso.setValor(novoValor);
            cursoDAO.atualizar(curso);
            System.out.println("Curso editado com sucesso!");
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    public static void excluirCurso(ICursoDAO cursoDAO, Scanner scanner) {
        System.out.print("Digite o ID do curso que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (cursoDAO.excluir(id)) {
            System.out.println("Curso excluído com sucesso!");
        } else {
            System.out.println("Curso não encontrado.");
        }
    }
    
}
