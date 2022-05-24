package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchLocalReq;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}") // application.yaml파일에 가서 naver.client.id 값을 가져온다
    private String naverClientId;

    @Value("${naver.client.secret") // application.yaml파일에 가서 naver.client.secret 값을 가져온다
    private String naverSecret;

    @Value("${naver.url.search.local}") // application.yaml파일에 가서 naver.client.search.local 값을 가져온다
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.img}") // application.yaml파일에 가서 naver.client.search.local 값을 가져온다
    private String naverImageSearchUrl;

    public void localSearch(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParam()



    }

    public void imageSearch(){

    }

}
