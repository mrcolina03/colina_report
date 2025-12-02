package espe.edu.ec.colina_report.services;

import espe.edu.ec.colina_report.models.entities.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    List<Report> buscarTodos();
    Optional<Report> buscarPorId(Long id);
    Report guardar(Report report);
    void eliminarPorId(Long id);
}
