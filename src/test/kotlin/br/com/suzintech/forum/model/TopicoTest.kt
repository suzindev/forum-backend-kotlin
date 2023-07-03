package br.com.suzintech.forum.model

object TopicoTest {

    fun build() = Topico(
        id = 1,
        titulo = "Kotlin",
        mensagem = "Aprendendo",
        curso = CursoTest.build(),
        autor = UsuarioTest.build()
    )
}