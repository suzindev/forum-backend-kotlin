package br.com.suzintech.forum.service

import br.com.suzintech.forum.dto.AtualizacaoTopicoForm
import br.com.suzintech.forum.dto.TopicoForm
import br.com.suzintech.forum.dto.TopicoView
import br.com.suzintech.forum.exception.NotFoundException
import br.com.suzintech.forum.mapper.TopicoFormMapper
import br.com.suzintech.forum.mapper.TopicoViewMapper
import br.com.suzintech.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundException: String = "Tópico não encontrado!"
) {

    fun listar(): List<TopicoView> {
        return repository.findAll()
            .stream()
            .map { t ->
                topicoViewMapper.map(t)
            }.collect(Collectors.toList())
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

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}