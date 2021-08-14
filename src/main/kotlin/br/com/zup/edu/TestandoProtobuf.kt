package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua teste")
                .setCep("00000-000")
                .setComplemento("Casa 04")
                .build()
        )
        .build()

    println(request)
    request.writeTo(FileOutputStream("funcionario1-request.bin"))


    //lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario1-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)
}