package com.frmurta.hackathon.abstracoes;


import com.frmurta.hackathon.utils.ControllerUtils;
import com.frmurta.hackathon.utils.ObjectUtils;
import com.frmurta.hackathon.utils.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.List;

public class AbstractCtrl<T> {

    private IBaseService<T> service;

    public AbstractCtrl(IBaseService<T> service) {
        this.service = service;
    }

    protected ResponseEntity sendBadRequest(BindingResult result) {
        return ControllerUtils.sendBadRequest(result);
    }

    protected ResponseEntity sendBadRequest(List<String> messages) {
        return ControllerUtils.sendBadRequest(messages);
    }


    protected ResponseEntity sendBadRequest(String message) {
        return ControllerUtils.sendBadRequest(Collections.singletonList(message));
    }

    protected ResponseEntity sendBadRequest(Throwable e) {
        String message = e.getMessage();
        if (StringUtils.isEmpty(message) && ObjectUtils.isAllNonNull(e.getCause())) {
            message = e.getCause().getMessage();
        }
        return ControllerUtils.sendBadRequest(Collections.singletonList(message));
    }

    protected ResponseEntity sendNoContent() {
        return ControllerUtils.sendNoContent();
    }

    protected ResponseEntity sendOk(Object response) {
        return ControllerUtils.sendOk(response);
    }
}
