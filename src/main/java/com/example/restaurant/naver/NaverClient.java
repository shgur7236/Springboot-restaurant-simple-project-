package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;

@Component
public class NaverClient {

    @Value("${naver.client.id}") // application.yaml파일에 가서 naver.client.id 값을 가져온다
    private String naverClientId;

    @Value("${naver.client.secret}") // application.yaml파일에 가서 naver.client.secret 값을 가져온다
    private String naverSecret;

    @Value("${naver.url.search.local}") // application.yaml파일에 가서 naver.client.search.local 값을 가져온다
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.img}") // application.yaml파일에 가서 naver.client.search.local 값을 가져온다
    private String naverImageSearchUrl;

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq){
        // 주소 만들기
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        // 헤더 만들기
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};


        var responseEntity= new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }

    public void imageSearch(){

    }

}
