package espe.edu.ec.colina_report.services;

import espe.edu.ec.colina_report.models.entities.Report;
import espe.edu.ec.colina_report.repositories.ReportRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Report> buscarTodos() {
        return (List<Report>) repository.findAll();
    }

    @Override
    public Optional<Report> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Report guardar(Report report) {
        return repository.save(report);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}