package conectprof.api.domain.fornecedor;

public record DadosListagemFornecedorDto(Long id, String nomeFantasia, String email, String cnpj) {

    public DadosListagemFornecedorDto(FornecedorEntity fornecedor){
        this(fornecedor.getId(), fornecedor.getNomeFantasia(), fornecedor.getEmail(), fornecedor.getCnpj());
    }
}
