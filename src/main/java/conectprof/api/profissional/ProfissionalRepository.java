package conectprof.api.profissional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {


    Page<ProfissionalEntity>findAllByAtivoTrue(Pageable paginacao);
}
