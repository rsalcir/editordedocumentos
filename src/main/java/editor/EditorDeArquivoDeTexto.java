package editor;

import editor.docx.EditorDeArquivoDeTextoDocx;
import editor.docx.ErroAoEditarArquivoDeTexto;
import editor.docx.rodape.AlinhamentoDaNotaDeRodape;
import editor.docx.tabela.FormatacaoDaTabela;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public abstract class EditorDeArquivoDeTexto {

    private static EditorDeArquivoDeTextoDocx editorDeArquivoDeTexto;

    @Deprecated
    public File editar(File arquivoQueSeraEditado, Object object, String nomeDoArquivoDeSaida) throws ErroAoEditarArquivoDeTexto {
        editarArquivo(arquivoQueSeraEditado, object, nomeDoArquivoDeSaida);
        return getArquivoEditado();
    }

    public OutputStream editar(InputStream arquivoQueSeraEditado, Object dados) throws ErroAoEditarArquivoDeTexto {
        return editarArquivo(arquivoQueSeraEditado, dados);
    }

    public ByteBuffer editar(ByteBuffer byteBuffer, Object object) throws ErroAoEditarArquivoDeTexto {
        return editarArquivo(byteBuffer, object);
    }

    public ByteBuffer editar(ByteBuffer byteBuffer, Map<String, Object> mapObjects) throws ErroAoEditarArquivoDeTexto {
        return editarArquivo(byteBuffer, mapObjects);
    }

    protected abstract void editarArquivo(File arquivoQueSeraEditado, Object object, String nomeDoArquivoDeSaida) throws ErroAoEditarArquivoDeTexto;

    protected abstract OutputStream editarArquivo(InputStream arquivoQueSeraEditado, Object dados) throws ErroAoEditarArquivoDeTexto;

    protected abstract ByteBuffer editarArquivo(ByteBuffer byteBuffer, Object dados) throws ErroAoEditarArquivoDeTexto;

    protected abstract ByteBuffer editarArquivo(ByteBuffer byteBuffer, Map<String, Object> mapObjects) throws ErroAoEditarArquivoDeTexto;

    protected abstract File getArquivoEditado();

    public static EditorDeArquivoDeTexto editarArquivoDocx() {
        editorDeArquivoDeTexto = new EditorDeArquivoDeTextoDocx();
        return editorDeArquivoDeTexto;
    }

    public EditorDeArquivoDeTexto docxComTabelas(Object[] listasDeObjetosParaAsTabelasDoDocumento, FormatacaoDaTabela... formatacaoDaTabelas) {
        editorDeArquivoDeTexto.docxComTabelas(listasDeObjetosParaAsTabelasDoDocumento, formatacaoDaTabelas);
        return this;
    }

    public EditorDeArquivoDeTexto docxComTabelas(List<Map<String, Object>> listasDeObjetosParaAsTabelasDoDocumento, FormatacaoDaTabela... formatacaoDaTabelas) {
        editorDeArquivoDeTexto.docxComTabelas(listasDeObjetosParaAsTabelasDoDocumento, formatacaoDaTabelas);
        return this;
    }

    public EditorDeArquivoDeTexto comNotaDeRodape(String notaDeRodape, AlinhamentoDaNotaDeRodape... alinhamentoDaNotaDeRodape) {
        editorDeArquivoDeTexto.comNotaDeRodape(notaDeRodape, alinhamentoDaNotaDeRodape);
        return this;
    }
}
