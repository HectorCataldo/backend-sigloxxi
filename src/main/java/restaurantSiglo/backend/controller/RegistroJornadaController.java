package restaurantSiglo.backend.controller;

import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Registro_Jornada;
import restaurantSiglo.backend.repository.Registro_JornadaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class RegistroJornadaController {

    //Obtenemos el repositorio
    private Registro_JornadaRepository registro_jornadaRepository;
    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    //Creamos el constructor
    public RegistroJornadaController(Registro_JornadaRepository registro_jornadaRepository) {
        this.registro_jornadaRepository = registro_jornadaRepository;
    }

    public static boolean compareDates(String d1,String d2)
    {
        try{
            // If you already have date objects then skip 1

            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            System.out.println("Date1"+sdf.format(date1));
            System.out.println("Date2"+sdf.format(date2));System.out.println();

            // Create 2 dates ends
            //1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if(date1.after(date2)){
                System.out.println("Date1 is after Date2");
                return true;
            }
            // before() will return true if and only if date1 is before date2
            if(date1.before(date2)){
                System.out.println("Date1 is before Date2");
                return false;
            }

            //equals() returns true if both the dates are equal
            if(date1.equals(date2)){
                System.out.println("Date1 is equal Date2");
                return false;
            }

            System.out.println();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
        return false;
    }


    //Esta función obtiene y muestra todos los registros de jornada de la base de datos
    @GetMapping("/registros_jornadas")
    public List<Registro_Jornada> findAll(){
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        return registro_jornadas;
    }

    //Esta función obtiene un registro de jornada por su ID de la base de datos
    @GetMapping("/registro_jornadas/{id}")
    public ResponseEntity<Registro_Jornada> findById(@PathVariable Integer id){
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        for (int i =0; i< registro_jornadas.size();i++){
            Registro_Jornada registro_jornada = registro_jornadas.get(i);
            if (registro_jornada.getId_registro()==id){
                return ResponseEntity.ok(registro_jornada);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina un registro de jornada de la base de datos por su ID
    @DeleteMapping("/registro_jornadas/{id}")
    public ResponseEntity<Registro_Jornada> delete(@PathVariable Integer id){
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        for (int i =0; i< registro_jornadas.size();i++){
            Registro_Jornada registro_jornada = registro_jornadas.get(i);
            if (registro_jornada.getId_registro() == id){
                registro_jornadaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un registro de jornada en la base de datos
    @PostMapping("/registro_jornadas")
    public ResponseEntity<Registro_Jornada> create(@RequestBody Registro_Jornada registro_jornada){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);
        Date fecha = registro_jornada.getFecha();
        LocalDateTime ldt = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());        if (registro_jornada.getId_registro() == null){
            if (compareDates(ldt.format(formatter),formatDateTime)){
                Date horaE = registro_jornada.getHora_entrada();
                Date horaS = registro_jornada.getHora_salida();
                LocalDateTime ldt1 = LocalDateTime.ofInstant(horaE.toInstant(), ZoneId.systemDefault());
                LocalDateTime ldt2 = LocalDateTime.ofInstant(horaS.toInstant(), ZoneId.systemDefault());
                if (compareDates(ldt2.format(formatter),ldt1.format(formatter))){
                    Registro_Jornada rj = registro_jornadaRepository.save(registro_jornada);
                    return ResponseEntity.ok(rj);
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/registro_jornadas")
    public ResponseEntity<Registro_Jornada> update(@RequestBody Registro_Jornada registro_jornada){
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        for (int i=0; i<registro_jornadas.size();i++){
            Registro_Jornada registro = registro_jornadas.get(i);
            if (registro.getId_registro()==registro_jornada.getId_registro()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                Date fechaA = registro.getFecha();
                Date fechaN = registro_jornada.getFecha();
                LocalDateTime ldt1 = LocalDateTime.ofInstant(fechaA.toInstant(), ZoneId.systemDefault());
                LocalDateTime ldt2 = LocalDateTime.ofInstant(fechaN.toInstant(), ZoneId.systemDefault());
                if (compareDates(ldt2.format(formatter),ldt1.format(formatter))){
                    Date horaE = registro_jornada.getHora_entrada();
                    Date horaS = registro_jornada.getHora_salida();
                    LocalDateTime ldt3 = LocalDateTime.ofInstant(horaE.toInstant(), ZoneId.systemDefault());
                    LocalDateTime ldt4 = LocalDateTime.ofInstant(horaS.toInstant(), ZoneId.systemDefault());
                    if (compareDates(ldt4.format(formatter),ldt3.format(formatter))){
                        Registro_Jornada rj = registro_jornadaRepository.save(registro_jornada);
                        return ResponseEntity.ok(rj);
                    }
                }
            }
        }
        return ResponseEntity.notFound().build();
    }
}
