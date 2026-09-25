package conectprof.api.cliente;

import conectprof.api.endereco.Endereco;
import conectprof.api.profissional.DadosDetalhamentoProfissionalDto;

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
