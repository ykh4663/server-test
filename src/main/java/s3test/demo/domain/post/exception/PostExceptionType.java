package s3test.demo.domain.post.exception;

import org.springframework.http.HttpStatus;
import s3test.demo.global.exception.BaseExceptionType;

public enum PostExceptionType implements BaseExceptionType {


    NOT_FOUND_POST(602, HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),;

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    PostExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }



    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
