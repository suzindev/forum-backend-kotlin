package br.com.suzintech.forum.service

import br.com.suzintech.forum.dto.AtualizacaoTopicoForm
import br.com.suzintech.forum.dto.TopicoForm
import br.com.suzintech.forum.dto.TopicoView
import br.com.suzintech.forum.exception.NotFoundException
import br.com.suzintech.forum.mapper.TopicoFormMapper
import br.com.suzintech.forum.mapper.TopicoViewMapper
import br.com.suzintech.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundException: String = "Tópico não encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream()
            .map { t ->
                topicoViewMapper.map(t)
            }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow { NotFoundException(notFoundException) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm): TopicoView {
        val topico = topicoFormMapper.map(dto)
        topico.id = topicos.size.toLong() + 1

        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream()
            .filter { t -> t.id == dto.id }
            .findFirst()
            .orElseThrow { NotFoundException(notFoundException) }

        val topicoAtualizado = Topico(
            id = dto.id,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )

        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow { NotFoundException(notFoundException) }

        topicos = topicos.minus(topico)
    }
}