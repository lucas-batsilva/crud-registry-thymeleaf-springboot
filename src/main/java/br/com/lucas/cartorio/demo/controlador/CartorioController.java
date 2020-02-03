package br.com.lucas.cartorio.demo.controlador;

import br.com.lucas.cartorio.demo.dominio.Cartorio;
import br.com.lucas.cartorio.demo.servico.CartorioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CartorioController {

    @Autowired
    CartorioServico cartorioServico;

    // endpoints para as páginas do thymeleaf
    @GetMapping("/")
    public ModelAndView consultar() {
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("cartorios", cartorioServico.consultar());
        return mv;
    }

    @GetMapping("/adicionar")
	public ModelAndView adicionar(Cartorio cartorio) {
		ModelAndView mv = new ModelAndView("/adicionarCartorio");
		mv.addObject("cartorio", cartorio);
		return mv;
	}

	// endpoints do crud
    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid Cartorio cartorio, BindingResult result) {
        if(result.hasErrors()) {
            return adicionar(cartorio);
        }
        cartorioServico.salvar(cartorio);
        return consultar();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        return adicionar(cartorioServico.buscarPorId(id));
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        cartorioServico.excluir(cartorioServico.buscarPorId(id));
        return consultar();
    }

}
