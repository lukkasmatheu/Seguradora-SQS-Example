package br.com.cadastro.sqs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class Cliente implements Serializable {
    @MongoId
    private String id;
    @Field("nome")
    String nome;
    @Field("idade")
    String idade;
    @Field("sexo")
    String sexo;
    @Field("tipo_documento")
    String tipo_documento;
    @Field("documento")
    String documento;
}
