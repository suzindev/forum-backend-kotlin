package br.com.suzintech.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AtualizacaoTopicoForm(

    @field:NotNull val id: Long,
    @field:NotEmpty val titulo: String,
    @field:NotEmpty val mensagem: String
)
