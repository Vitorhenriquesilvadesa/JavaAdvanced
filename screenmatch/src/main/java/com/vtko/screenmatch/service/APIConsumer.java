package com.vtko.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {

    public String getData(String address) {

        // Cria um novo cliente Http.
        HttpClient client = HttpClient.newHttpClient();

        // Constroi uma nova requisição usando como rota o conteudo da variavel "address".
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();

        HttpResponse<String> response = null;

        try {

            // Faz o cliente enviar a requisição e receber a resposta, o corpo da resposta vem no formato String porque
            // isso foi especificado em HttpResponse.BodyHandlers.ofString(),
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // retorna o corpo da resposta caso ele exista.
        if(response.statusCode() == 200){
            return response.body();
        }

        return null;
    }
}
