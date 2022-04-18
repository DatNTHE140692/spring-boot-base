package vn.edu.fpt.library.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DefaultResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public static <T> DefaultResponse<T> success(T data) {
        DefaultResponse<T> response = new DefaultResponse<>();
        response.setSuccess(true);
        response.setMessage("Thành công");
        response.setData(data);
        return response;
    }

    public static <T> DefaultResponse<T> success() {
        return success(null);
    }

    public static <T> DefaultResponse<T> error(String message, T data) {
        DefaultResponse<T> response = new DefaultResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> DefaultResponse<T> error(String message) {
        return error(message, null);
    }

}
