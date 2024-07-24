package br.senac.cantina.movimentacao.types;


public enum TipoRegistroEnum {
    ENTRADA('E'),
    SAIDA('S');

    private Character value;

    TipoRegistroEnum(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public static TipoRegistroEnum fromvalue(Character value) {
        for (TipoRegistroEnum tipo : values()) {
            if (tipo.getValue().equals(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de movimentação inválido: " + value);
    }
}