package br.com.suzintech.forum.integration

import br.com.suzintech.forum.configuration.DatabaseContainerConfiguration
import br.com.suzintech.forum.dto.TopicoPorCategoriaDTO
import br.com.suzintech.forum.model.TopicoTest
import br.com.suzintech.forum.repository.TopicoRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.data.domain.PageRequest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest : DatabaseContainerConfiguration() {

    @Autowired
    private lateinit var topicoRepository: TopicoRepository

    private val paginacao = PageRequest.of(0, 5)
    private val topico = TopicoTest.build()

    @Test
    fun `deve gerar um relatorio`() {
        topicoRepository.save(topico)

        val relatorio = topicoRepository.relatorio()

        Assertions.assertThat(relatorio).isNotNull
        Assertions.assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoriaDTO::class.java)
    }

    @Test
    fun `deve buscar um topico por nome`() {
        topicoRepository.save(topico)
        val resultado = topicoRepository.findByCursoNome(nomeCurso = "Kotlin", paginacao = paginacao)

        Assertions.assertThat(resultado.totalElements).isEqualTo(1)
    }
}