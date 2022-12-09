package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Mesa;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.entities.Reserva;
import restaurantSiglo.backend.repository.MesaRepository;
import restaurantSiglo.backend.repository.PersonaRepository;
import restaurantSiglo.backend.repository.ReservaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class ReservaController {

    //Obtenemos los repositorios
    private ReservaRepository reservaRepository;
    private PersonaRepository personaRepository;
    private MesaRepository mesaRepository;
    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMATTER2= "HH:mm:ss";

    //Esta función es utilizada para comparar fechas
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

    //Creamos el constructor
    public ReservaController(ReservaRepository reservaRepository, PersonaRepository personaRepository, MesaRepository mesaRepository) {
        this.reservaRepository = reservaRepository;
        this.personaRepository = personaRepository;
        this.mesaRepository = mesaRepository;
    }

    //Esta función obtiene a todas las reservas de las base de datos
    @GetMapping("/reservas")
    public List<Reserva> findAll(){
        try {
            List<Reserva> reservas = reservaRepository.findAll();
            return reservas;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función obtiene una reserva por su Id de la base de datos
    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Integer id){
        try {
            List<Reserva> reservas = reservaRepository.findAll();
            for (int i=0; i<reservas.size();i++){
                Reserva reserva = reservas.get(i);
                if (reserva.getId_reserva() == id){
                    return ResponseEntity.ok(reserva);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a una reserva por su Id de la base de datos
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Reserva> delete(@PathVariable Integer id){
        try {
            List<Reserva> reservas =reservaRepository.findAll();
            for (int i=0; i<reservas.size();i++){
                Reserva reserva = reservas.get(i);
                if (reserva.getId_reserva() == id){
                    reservaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    public boolean MesaEstado(){
        try {

        }catch (Exception e){
            e.getCause();
        }
        return false;
    }

    //Esta función crea una reserva en base de datos
    @PostMapping("/reservas")
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
        try {
            List<Persona> personas = personaRepository.findAll();
            List<Mesa> mesas = mesaRepository.findAll();
            if (reserva.getId_reserva() == null){
                for (int i=0; i<personas.size();i++){
                    Persona persona = personas.get(i);
                    if (persona == reserva.getPersona()){
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                        String formatDateTime = localDateTime.format(formatter);
                        Date fecha = reserva.getFecha();
                        Date hora = reserva.getHora();
                        LocalDateTime ldt1 = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
                        LocalDateTime ldt2 = LocalDateTime.ofInstant(hora.toInstant(), ZoneId.systemDefault());
                        if (compareDates(ldt1.format(formatter),formatDateTime)){
                            for (int o=0;o<mesas.size();o++){
                                Mesa mesa = mesas.get(o);
                                if (mesa == reserva.getMesa()){
                                    Reserva reserva1 = reservaRepository.save(reserva);
                                    mesa.setEstado(false);
                                    mesaRepository.save(mesa);
                                    /*Calendar cal = Calendar.getInstance();
                                    cal.setTime(hora);
                                    cal.add(Calendar.HOUR_OF_DAY,1);
                                    Date hora1 = cal.getTime();
                                    LocalDateTime ldt3 = LocalDateTime.ofInstant(hora1.toInstant(), ZoneId.systemDefault());
                                    if ()*/
                                    return ResponseEntity.ok(reserva1);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de una reserva en base de datos
    @PutMapping("/reservas")
    public ResponseEntity<Reserva> update(@RequestBody Reserva reserva){
        try {
            List<Reserva>reservas = reservaRepository.findAll();
            List<Persona>personas = personaRepository.findAll();
            List<Mesa> mesas = mesaRepository.findAll();
            for (int i=0;i<reservas.size();i++){
                Reserva reserva1 = reservas.get(i);
                if (reserva1.getId_reserva() == reserva.getId_reserva()){
                    for (int o = 0; o<personas.size();o++){
                        Persona persona = personas.get(o);
                        if (persona == reserva.getPersona()){
                            LocalDateTime localDateTime = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                            String formatDateTime = localDateTime.format(formatter);
                            Date fecha = reserva.getFecha();
                            LocalDateTime ldt1 = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
                            if (compareDates(ldt1.format(formatter),formatDateTime)){
                                for (int u=0; u<mesas.size();u++){
                                    Mesa mesa = mesas.get(u);
                                    if (mesa == reserva.getMesa()){
                                        Reserva reserva2 = reservaRepository.save(reserva);
                                        mesa.setEstado(false);
                                        mesaRepository.save(mesa);
                                        return ResponseEntity.ok(reserva2);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }
}
