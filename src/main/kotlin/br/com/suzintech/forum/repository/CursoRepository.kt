package br.com.suzintech.forum.repository

import br.com.suzintech.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}