package br.com.suzintech.forum.service

import br.com.suzintech.forum.model.Resposta
import br.com.suzintech.forum.repository.RespostaRepository
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private val respostaRepository: RespostaRepository,
    private val emailService: EmailService
) {
    fun salvar(resposta: Resposta) {
        respostaRepository.save(resposta)

        val autor = resposta.topico.autor.email

        emailService.notificar(autor)
    }
}