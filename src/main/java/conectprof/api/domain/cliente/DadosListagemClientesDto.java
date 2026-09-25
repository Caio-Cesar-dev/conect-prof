package conectprof.api.domain.cliente;

public record DadosListagemClientesDto(Long id, String nome, String email, String cpf) {

    public DadosListagemClientesDto(ClienteEntity cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }
}
