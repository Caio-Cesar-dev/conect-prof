package conectprof.api.fornecedor;

import conectprof.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "fornecedores")
@Entity(name = "FornecedorEntity")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String telefone;
    private boolean ativo;
    @Embedded
    private Endereco endereco;

    public FornecedorEntity(DadosFornecedorDto dados){
        this.nomeFantasia = dados.nomeFantasia();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarFornecedor(DadoAtualizacaoFornecedorDto dados) {
        if (dados.nomeFantasia() != null){
            this.nomeFantasia = dados.nomeFantasia();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
