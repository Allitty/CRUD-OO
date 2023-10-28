package cursinhos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImplementacoes implements ICursoDAO {
    private List<Curso> cursos = new ArrayList<>();
    private int proximoId = 1;
    private String arquivoDados = "cursos.txt";

    public CursoDAOImplementacoes() {
        carregarDadosDoArquivo();
    }

    @Override
    public Curso salvar(Curso curso) {
        curso.setId(proximoId);
        cursos.add(curso);
        proximoId++;
        salvarDadosNoArquivo();
        return curso;
    }

    @Override
    public Curso buscarPorId(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> listarTodos() {
        return cursos;
    }

    @Override
    public boolean atualizar(Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == curso.getId()) {
                cursos.set(i, curso);
                salvarDadosNoArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                cursos.remove(curso);
                salvarDadosNoArquivo();
                return true;
            }
        }
        return false;
    }

    private void carregarDadosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoDados))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String prof = partes[2];
                String desc = partes[3];
                double valor = Double.parseDouble(partes[4]);
                cursos.add(new Curso(id, nome, prof, desc, valor));
            }
        } catch (FileNotFoundException e) {
            // Se o arquivo não existir, não faz nada.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarDadosNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoDados))) {
            for (Curso curso : cursos) {
                writer.write(curso.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

