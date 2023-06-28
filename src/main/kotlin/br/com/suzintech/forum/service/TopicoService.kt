package br.com.suzintech.forum.service

import br.com.suzintech.forum.dto.AtualizacaoTopicoForm
import br.com.suzintech.forum.dto.TopicoForm
import br.com.suzintech.forum.dto.TopicoPorCategoriaDTO
import br.com.suzintech.forum.dto.TopicoView
import br.com.suzintech.forum.exception.NotFoundException
import br.com.suzintech.forum.mapper.TopicoFormMapper
import br.com.suzintech.forum.mapper.TopicoViewMapper
import br.com.suzintech.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.persistence.EntityManager

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundException: String = "Tópico não encontrado!",
    private val em: EntityManager
) {

    fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }

        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundException) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm): TopicoView {
        val topico = topicoFormMapper.map(dto)

        repository.save(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(dto.id)
            .orElseThrow { NotFoundException(notFoundException) }

        topico.titulo = dto.titulo
        topico.mensagem = dto.mensagem
        topico.dataAlteracao = LocalDate.now()

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDTO> {
        return repository.relatorio()
    }
}