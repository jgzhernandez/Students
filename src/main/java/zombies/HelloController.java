package zombies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/getZombieBrains")
    public String zombieBrains() {
        Zombie newZombs = new Zombie(30, "I have brains.");
        return newZombs.getBrains();
    }

    @GetMapping("/getZombie")
    public List<Zombie> zombie() {
        List<Zombie> zombieList = new ArrayList<Zombie>();
        zombieList.add(new Zombie(40, "I have 2 brains."));
        zombieList.add(new Zombie(15, "I have no brains." ));
        return zombieList;
    }
}
