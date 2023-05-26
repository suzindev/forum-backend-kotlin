package br.com.suzintech.forum.service

import br.com.suzintech.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Teste",
            email = "teste@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream()
            .filter { c -> c.id == id }
            .findFirst().get()
    }
}
