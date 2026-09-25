package conectprof.api.domain.fornecedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {

    Page<FornecedorEntity> findAllByAtivoTrue(Pageable paginacao);
}
