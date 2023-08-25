package io.miswah.secondbrain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponseDTO {
    private HttpStatusCode statusCode;
    private String message;
    private Object object;
}
