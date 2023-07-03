package br.com.suzintech.forum.model

object UsuarioTest {

    fun build() = Usuario(
        id = 1,
        nome = "Dev",
        email = "dev@teste.com",
        password = "123"
    )

    fun buildToken() = Usuario(
        nome = "Dev",
        email = "dev@teste.com",
        password = "123456"
    )
}