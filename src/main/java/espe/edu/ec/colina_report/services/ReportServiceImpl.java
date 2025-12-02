package espe.edu.ec.colina_report.services;

import espe.edu.ec.colina_report.models.entities.Report;
import espe.edu.ec.colina_report.repositories.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;

    public ReportServiceImpl(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Report> buscarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Report> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Report guardar(Report report) {
        return repository.save(report);
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}
