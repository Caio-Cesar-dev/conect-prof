package conectprof.api.fornecedor;

import conectprof.api.endereco.Endereco;

public record DadosDetalhamentoFornecedorDto(
        Long id,
        String nomeFantasia,
        String cnpj,
        String email,
        String telefone,
        Endereco endereco) {

    public DadosDetalhamentoFornecedorDto(FornecedorEntity fornecedor){
        this(fornecedor.getId(), fornecedor.getNomeFantasia(), fornecedor.getCnpj(), fornecedor.getEmail(), fornecedor.getTelefone(), fornecedor.getEndereco());
    }
}
