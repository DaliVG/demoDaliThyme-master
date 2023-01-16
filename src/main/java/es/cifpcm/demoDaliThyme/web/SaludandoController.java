package es.cifpcm.demoDaliThyme.web;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SaludandoController {
    @GetMapping("/greeting")
    public String saludando(@RequestParam(name="nombre", required=false, defaultValue = "a todos") String name, @RequestParam(name="planeta", required=false, defaultValue = "a todos") String planeta, Model model){
        model.addAttribute("nombre", name);
        model.addAttribute("planeta", planeta);
        return "saludos";
    }
    public String index(Model model){
        File file = new File(
                getClass().getClassLoader().getResource("/static/imagenes").getFile()
        );
        List<String> Planetas = new ArrayList<String>();
        for(File planeta: file.listFiles()) {
            Planetas.add(planeta.getName());
        }
        model.addAttribute("Planetas", Planetas);
        return "indice";
    }
}
