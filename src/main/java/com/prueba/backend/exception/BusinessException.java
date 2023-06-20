package com.prueba.backend.exception;

import java.util.function.Supplier;

public class BusinessException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public enum Type {

        CREDIT_APPLICATION_EXISTS("El vehiculo indicado actualmente se encuentra reservado para un credito."),
        PERSONA_NOT_FOUND("Persona no existe en Base de datos"),
        JUZGADO_NOT_FOUND("Juzgado no existe."),
        CASO_NOT_FOUND("Caso no existe."),
        PROCESO_NOT_FOUND("Proceso no existe."),
        PERSONA_ALREADY_EXISTS("La persona ya existe en la base de datos");

        private final String message;

        public String getMessage() {
            return message;
        }

        public BusinessException build() {
            return new BusinessException(this);
        }

        public Supplier<Throwable> defer() {
            return () -> new BusinessException(this);
        }

        Type(String message) {
            this.message = message;
        }

    }

    private final Type type;

    public BusinessException(Type type){
        super(type.message);
        this.type = type;
    }

    public BusinessException(Type type, String menssage){
        super(menssage);
        this.type = type;
    }

    @Override
    public String getCode(){
        return type.name();
    }


}
