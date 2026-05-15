package org.serratec.aula03.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.serratec.aula03.exception.EnumValidationException;

public enum TipoCliente {
    PESSOA_FISICA,
    PESSOA_JURIDICA;

    @JsonCreator
    public static TipoCliente fromValue(String value) throws EnumValidationException {
        for (TipoCliente tipo : TipoCliente.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }

        String valoresAceitos = Arrays.stream(TipoCliente.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        throw new EnumValidationException(
            "Valor inválido para TipoCliente: '" + value + "'. " +
            "Valores aceitos: " + valoresAceitos
        );
    }
}