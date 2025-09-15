package pe.edu.uni.demospring.ejemplos.buclecondicional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.uni.demospring.dominio.Cotizacion;
import pe.edu.uni.demospring.dominio.CotizacionItem;

@Controller
public class ControllerObjetoItems {

	@GetMapping("/cotizacion/{id}")
	public String consultarCotizacion(@PathVariable(name = "id") int id, Model model) {
		Cotizacion cot = new Cotizacion();
		List<CotizacionItem> lst = new ArrayList();
		lst.add(new CotizacionItem("Mouse Logitech", 5, 350));
		lst.add(new CotizacionItem("Mouse Targus", 5, 300));
		lst.add(new CotizacionItem("Mouse Generico", 5, 150));
		cot.setId(id);
		cot.setItems(lst);
		model.addAttribute("objetoCotizacion", cot);
		return "/buclecondicional/cotizacion";
	}
}
