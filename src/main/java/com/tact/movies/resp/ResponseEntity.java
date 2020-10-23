package com.tact.movies.resp;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class ResponseEntity<T>{
    private int status;
    private String msg;
    private T data;

    public ResponseEntity() {
        
    }

    public ResponseEntity(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T>ResponseEntity<T> success(T data){
        return success(200,"success",data);
    }

    public static <T> ResponseEntity<T> success(int status, String msg ,T data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setStatus(status);
        responseEntity.setMsg(msg);
        responseEntity.setData(data);
        return responseEntity;
    }
    public static <T>ResponseEntity<T>error(){
        return error(404,"error");
    }

    public static <T> ResponseEntity<T> error(int status, String msg) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setStatus(status);
        responseEntity.setMsg(msg);
        return responseEntity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
