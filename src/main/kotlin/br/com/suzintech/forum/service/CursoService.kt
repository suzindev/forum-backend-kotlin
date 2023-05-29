package br.com.suzintech.forum.service

import br.com.suzintech.forum.model.Curso
import br.com.suzintech.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }
}
