package espe.edu.ec.colina_report.controllers;

import espe.edu.ec.colina_report.models.entities.Report;
import espe.edu.ec.colina_report.services.ReportService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    // -------- GET: obtener todos --------
    @GetMapping
    public ResponseEntity<List<Report>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    // -------- GET: buscar por ID --------
    @GetMapping("/{id}")
    public ResponseEntity<Report> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- POST: crear --------
    @PostMapping
    public ResponseEntity<Report> crear(@RequestBody Report report) {
        Report saved = service.guardar(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // -------- PUT: actualizar --------
    @PutMapping("/{id}")
    public ResponseEntity<Report> actualizar(
            @PathVariable Long id,
            @RequestBody Report detalles) {

        return service.buscarPorId(id)
                .map(reportDB -> {
                    reportDB.setTitle(detalles.getTitle());
                    reportDB.setContent(detalles.getContent());
                    reportDB.setCreatedBy(detalles.getCreatedBy());
                    reportDB.setStatus(detalles.getStatus());

                    Report actualizado = service.guardar(reportDB);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // -------- DELETE: eliminar --------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(report -> {
                    service.eliminarPorId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
