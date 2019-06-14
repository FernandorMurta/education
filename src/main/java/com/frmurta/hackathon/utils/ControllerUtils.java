package com.frmurta.hackathon.utils;

import com.frmurta.hackathon.abstracoes.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class ControllerUtils {


    private ControllerUtils() {
    }

    public static ResponseEntity sendBadRequest(BindingResult result) {
        List<String> errorMessages = new ArrayList<>();
        result.getAllErrors().forEach(erro -> errorMessages.add(erro.getDefaultMessage()));
        return ResponseEntity.badRequest().body(new Response<>(errorMessages));
    }

    public static ResponseEntity sendBadRequest(List<String> messages) {
        return ResponseEntity.badRequest().body(new Response<>(messages));
    }

    public static ResponseEntity sendBadRequest(String message) {
        return ResponseEntity.badRequest().body(new Response<>(message));
    }

    public static ResponseEntity sendNoContent() {
        return ResponseEntity.noContent().build();
    }

    public static ResponseEntity sendOk(Object response) {
        return ResponseEntity.ok(new Response<>(response));
    }
}
