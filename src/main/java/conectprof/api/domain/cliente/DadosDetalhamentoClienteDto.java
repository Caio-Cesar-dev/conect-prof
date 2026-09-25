package conectprof.api.domain.cliente;

import conectprof.api.domain.endereco.Endereco;

public record DadosDetalhamentoClienteDto(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco
) {
    public DadosDetalhamentoClienteDto(ClienteEntity cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(),
                cliente.getCpf(), cliente.getEndereco());
    }
}
