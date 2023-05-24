package br.com.suzintech.forum.service

import br.com.suzintech.forum.model.Curso
import br.com.suzintech.forum.model.Topico
import br.com.suzintech.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Kotlin",
            mensagem = "Variáveis",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Dev",
                email = "dev@email.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Kotlin 2",
            mensagem = "Variáveis",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Dev",
                email = "dev@email.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Kotlin 3",
            mensagem = "Variáveis",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Dev",
                email = "dev@email.com"
            )
        )

        topicos = Arrays.asList(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream()
            .filter { t -> t.id == id }
            .findFirst()
            .get()
    }
}