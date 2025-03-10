package com.sp.user.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

    private String globalError;
    private List<FieldError> fieldErrors;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public static class FieldError implements Serializable{
        private String payloadKey;
        private String errorMessage;

        public FieldError(Map.Entry<String, String> ErrorEntry){
            this.payloadKey=ErrorEntry.getKey();
            this.errorMessage=ErrorEntry.getValue();
        }
    }

}
