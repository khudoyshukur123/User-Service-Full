package uz.pdp.user_crud_service.payload;

import lombok.Getter;

@Getter
public class ApiResult<E> {

    private final boolean success;

    private E data;

    private String message;

    private ApiResult() {
        this.success = true;
    }

    private ApiResult(E data) {
        this();
        this.data = data;
    }

    private ApiResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static <T> ApiResult<T> successResponse() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> successResponse(T data) {
        return new ApiResult<>(data);
    }

    public static <T> ApiResult<T> failResponse(String message) {
        return new ApiResult<>(false, message);
    }


}
