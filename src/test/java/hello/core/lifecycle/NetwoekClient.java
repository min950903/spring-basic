package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetwoekClient {
    private String url;

    public NetwoekClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect url = " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url +  "message = " + message);
    }

    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("disconnect ");
        disconnect();
    }
}