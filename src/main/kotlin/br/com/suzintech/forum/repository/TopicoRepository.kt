package br.com.suzintech.forum.repository

import br.com.suzintech.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}