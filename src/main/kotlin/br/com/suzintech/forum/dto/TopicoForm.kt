package br.com.suzintech.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicoForm(
    @field:NotEmpty(message = "Título não pode ser em branco")
    val titulo: String,

    @field:NotEmpty(message = "Mensagem não pode ser em branco")
    val mensagem: String,

    @field:NotNull
    val idCurso: Long,

    @field:NotNull
    val idAutor: Long
)