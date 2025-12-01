package espe.edu.ec.colina_report.controllers;

import espe.edu.ec.colina_report.models.entities.Report;
import espe.edu.ec.colina_report.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // -------- GET: obtener todos --------
    @GetMapping
    public ResponseEntity<List<Report>> listar() {
        return ResponseEntity.ok(reportService.buscarTodos());
    }

    // -------- GET: buscar por ID --------
    @GetMapping("/{id}")
    public ResponseEntity<Report> obtenerPorId(@PathVariable Long id) {
        return reportService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- POST: crear --------
    @PostMapping
    public ResponseEntity<Report> crear( @RequestBody Report report) {
        Report nuevoReport = reportService.guardar(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReport);
    }

    // -------- PUT: actualizar --------
    @PutMapping("/{id}")
    public ResponseEntity<Report> actualizar(@PathVariable Long id,
                                              @RequestBody Report reportDetalles) {

        return reportService.buscarPorId(id)
                .map(reportDB -> {
                    reportDB.setTitle(reportDetalles.getTitle());
                    reportDB.setContent(reportDetalles.getContent());
                    reportDB.setCreatedBy(reportDetalles.getCreatedBy());
                    reportDB.setCreatedAt(reportDetalles.getCreatedAt());
                    reportDB.setStatus(reportDetalles.getStatus());

                    Report actualizado = reportService.guardar(reportDB);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- DELETE: eliminar --------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return reportService.buscarPorId(id)
                .map(report -> {
                    reportService.eliminarPorId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}