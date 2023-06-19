package br.com.suzintech.forum.repository

import br.com.suzintech.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmail(username: String?): Usuario?
}