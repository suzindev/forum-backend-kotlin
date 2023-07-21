package br.com.suzintech.forum.repository

import br.com.suzintech.forum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository : JpaRepository<Resposta, Long>