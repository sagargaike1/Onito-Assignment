package com.sagar.Controller;
import com.sagar.Model.TambolaSetEntity;
import com.sagar.Service.TambolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tambola")
public class TambolaController {

    private final TambolaService tambolaService;

    @Autowired
    public TambolaController(TambolaService tambolaService) {
        this.tambolaService = tambolaService;
    }

    @PostMapping("/generateSets")
    public Map<String, List<String>> generateTambolaSets(@RequestParam int numberOfSets) {
        return tambolaService.generateTambolaSets(numberOfSets);
    }

    @GetMapping("/getAllSets")
    public List<TambolaSetEntity> getAllTambolaSets() {
        return tambolaService.getAllTambolaSets();
    }

    @GetMapping("/getSetById/{setId}")
    public TambolaSetEntity getTambolaSetById(@PathVariable Long setId) {
        return tambolaService.getTambolaSetById(setId);
    }
}



