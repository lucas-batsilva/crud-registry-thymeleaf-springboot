package br.com.lucas.cartorio.demo.repositorio;

import br.com.lucas.cartorio.demo.dominio.Cartorio;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {}
