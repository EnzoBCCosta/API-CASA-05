    package org.serratec.aula03.exception;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.http.converter.HttpMessageNotReadableException;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class ControllerExceptionHandler {


        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<String> handleNotReadable(HttpMessageNotReadableException ex) {
            Throwable cause = ex.getCause();
            if (cause != null && cause.getCause() instanceof EnumValidationException enumEx) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(enumEx.getMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("Requisição inválida ou campo ausente.");
        }
    }