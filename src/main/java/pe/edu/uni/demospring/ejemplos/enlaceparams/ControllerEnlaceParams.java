package pe.edu.uni.demospring.ejemplos.enlaceparams;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.uni.demospring.dominio.Cotizacion;
import pe.edu.uni.demospring.dominio.CotizacionItem;
import pe.edu.uni.demospring.dominio.Usuario;

@Controller
public class ControllerEnlaceParams {

	List<Usuario> lstUsuario = null;
	
	public ControllerEnlaceParams() {
		lstUsuario = new ArrayList();
		lstUsuario.add(new Usuario(301, "Juan Perez", "juanperez@gmail.com"));
		lstUsuario.add(new Usuario(302, "Carlos Jara", "carlosjara@gmail.com"));
		lstUsuario.add(new Usuario(303, "Fiorella Diaz", "fiorelladiaz@gmail.com"));
	}
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("listaUsuarios", lstUsuario);
		return "/enlaceparams/listado";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@ModelAttribute Usuario usuarioActualizado) {
		System.out.println("Actualizando " + usuarioActualizado);
		Usuario usuarioSeleccionado = null;
		for (Usuario usuario : lstUsuario) {
			if (usuario.getId()==usuarioActualizado.getId()) {
				usuarioSeleccionado = usuario;
				break;
			}
		}
		usuarioSeleccionado.setNombre(usuarioActualizado.getNombre());
		usuarioSeleccionado.setEmail(usuarioActualizado.getEmail());
		return "redirect:/listarUsuarios";
	}

	@PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuarioActualizado) {
        for (Usuario u : lstUsuario) {
            if (u.getId() == usuarioActualizado.getId()) {
                u.setNombre(usuarioActualizado.getNombre());
                u.setEmail(usuarioActualizado.getEmail());
                break;
            }
        }
        return "redirect:/listarUsuarios";
    }
	
	@GetMapping("/editar/{id}")
    public String irEditar(@PathVariable(name = "id") int id, Model model) {
		System.out.println("Editando usuario con id: " + id);
        Usuario usuario = lstUsuario.stream()
                .filter(u -> u.getId()==id)
                .findFirst().get();
        model.addAttribute("usuarioEdicion", usuario);
        return "/enlaceparams/edicion";
    }
}
