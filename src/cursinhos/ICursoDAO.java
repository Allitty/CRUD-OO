package cursinhos;

import java.util.List;

public interface ICursoDAO {
    Curso salvar(Curso curso);
    Curso buscarPorId(int id);
    List<Curso> listarTodos();
    boolean atualizar(Curso curso);
    boolean excluir(int id);
}

