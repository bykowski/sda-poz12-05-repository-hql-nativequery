package pl.bykowski.springbootdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CorpseApi {

    private CorpseRepo corpseRepo;

    @Autowired
    public CorpseApi(CorpseRepo corpseRepo) {
        this.corpseRepo = corpseRepo;
    }

//    @GetMapping("/show")
//    public Iterable<Corpse> show() {
//        return corpseRepo.findAll();
//    }

    @GetMapping("/getByName")
    public List<Corpse> getByName(@RequestParam String name) {
        return corpseRepo.findByName(name);
    }

    @GetMapping("/getavg")
    public List<Object> getavg() {
        return corpseRepo.getAvgByAgeOfDeath();
    }


    @GetMapping("/getAllElements")
    public List<Corpse> getAllElements() {
        return corpseRepo.getAllElements();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Corpse c1 = new Corpse(CorpseSize.BIG, LocalDate.now(), "Jan", 44);
        Corpse c2 = new Corpse(CorpseSize.MEDIUM, LocalDate.now(), "Karolina", 33);
        Corpse c3 = new Corpse(CorpseSize.SMALL, LocalDate.now(), "Anna", 22);
        Corpse c4 = new Corpse(CorpseSize.BIG, LocalDate.now(), "Przemek", 11);
        Corpse c5 = new Corpse(CorpseSize.BIG, LocalDate.now(), "Karolina", 1);
        corpseRepo.save(c1);
        corpseRepo.save(c2);
        corpseRepo.save(c3);
        corpseRepo.save(c4);
        corpseRepo.save(c5);
    }


}
