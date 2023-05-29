package br.com.suzintech.forum.service

import br.com.suzintech.forum.model.Usuario
import br.com.suzintech.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }
}
