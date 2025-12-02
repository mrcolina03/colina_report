package espe.edu.ec.colina_report.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import espe.edu.ec.colina_report.models.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
