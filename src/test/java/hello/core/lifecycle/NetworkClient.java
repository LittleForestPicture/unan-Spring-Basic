package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url =  " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void call(String message){
        System.out.println("call : " + url+ "message : " +message);
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }


    @PostConstruct
    public void init() {
        disconnect();
    }
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }
}
