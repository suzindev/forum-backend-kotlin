package br.com.suzintech.forum.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {
    fun notificar(autor: String) {
        val message = SimpleMailMessage()
        message.setSubject("Resposta Recebida")
        message.setText("Olá, o seu tópico foi respondido. Vamos lá conferir?")
        message.setTo(autor)

        javaMailSender.send(message)
    }
}