package s3test.demo.domain.post.exception;


import s3test.demo.global.exception.BaseException;
import s3test.demo.global.exception.BaseExceptionType;

public class PostException extends BaseException {
    private final BaseExceptionType exceptionType;

    public PostException(BaseExceptionType exceptionType){
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
