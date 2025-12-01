package espe.edu.ec.colina_report.repositories;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import espe.edu.ec.colina_report.models.entities.Report;

@Transactional
public interface ReportRepository extends CrudRepository<Report, Long> {

}