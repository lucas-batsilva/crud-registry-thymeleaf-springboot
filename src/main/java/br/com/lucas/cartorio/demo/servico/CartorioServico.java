package br.com.lucas.cartorio.demo.servico;

import br.com.lucas.cartorio.demo.dominio.Cartorio;
import br.com.lucas.cartorio.demo.repositorio.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartorioServico {

    @Autowired
    CartorioRepository cartorioRepository;

    public void salvar(Cartorio cartorio) {
        cartorioRepository.saveAndFlush(cartorio);
    }

    public void excluir(Cartorio cartorio) {
        cartorioRepository.delete(cartorio);
    }

    public List<Cartorio> consultar() {
        return cartorioRepository.findAll();
    }

    public Cartorio buscarPorId(Long id) {
        return cartorioRepository.findById(id).get();
    }

}
