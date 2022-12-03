package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Sector;
import restaurantSiglo.backend.entities.Tipo_Medida;
import restaurantSiglo.backend.repository.SectorRepository;

import java.util.List;

@RestController
public class SectorController {

    //Obtenemos el Repositorio
    private SectorRepository sectorRepository;

    //Creamos el Constructor
    public SectorController(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    //Esta función obtiene a todos los sectores de la base de datos
    @GetMapping("/sector")
    public List<Sector> findAll() {
        List<Sector> sectores = sectorRepository.findAll();
        return sectores;
    }

    //Esta función busca a un sector por Id dentro de la base de datos
    @GetMapping("/sector/{id}")
    public ResponseEntity<Sector> findById(@PathVariable Integer id) {
        List<Sector> sectores = sectorRepository.findAll();
        for (int i = 0; i < sectores.size(); i++) {
            Sector sector = sectores.get(i);
            if (sector.getId_sector() == id) {
                return ResponseEntity.ok(sector);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un sector dentro de la base de datos
    @DeleteMapping("/sector/{id}")
    public ResponseEntity<Sector> delete(@PathVariable Integer id) {
        List<Sector> sectores = sectorRepository.findAll();
        for (int i = 0; i < sectores.size(); i++) {
            Sector sector = sectores.get(i);
            if (sector.getId_sector() == id) {
                sectorRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea a un sector en base de datos
    @PostMapping("/sector")
    public ResponseEntity<Sector> create(@RequestBody Sector sector){
        if (sector.getId_sector() == null){
            Sector s1 = sectorRepository.save(sector);
            return ResponseEntity.ok(s1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un sector en base de datos
    @PutMapping("/sector")
    public ResponseEntity<Sector> update(@RequestBody Sector sector){
        List<Sector> sectores = sectorRepository.findAll();
        for (int i = 0; i < sectores.size(); i++) {
            Sector sector1 = sectores.get(i);
            if (sector1.getId_sector() == sector.getId_sector()){
                Sector s1 = sectorRepository.save(sector);
                return ResponseEntity.ok(s1);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
