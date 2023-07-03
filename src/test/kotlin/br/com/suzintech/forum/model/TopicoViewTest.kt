package br.com.suzintech.forum.model

import br.com.suzintech.forum.dto.TopicoView
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoViewTest {

    fun build() = TopicoView(
        id = 1,
        titulo = "Kotlin",
        mensagem = "Aprendendo",
        status = StatusTopico.NAO_RESPONDIDO,
        dataCriacao = LocalDateTime.now(),
        dataAlteracao = LocalDate.now()
    )
}