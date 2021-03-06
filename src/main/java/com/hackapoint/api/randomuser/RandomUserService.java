package com.hackapoint.api.randomuser;

import com.hackapoint.api.randomuser.models.Activity;
import com.hackapoint.api.randomuser.models.KanyeQuote;
import com.hackapoint.api.randomuser.models.RandomUser;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RandomUserService {

    public RandomUser getRandomUser(){
        RandomUser random = new RandomUser();
        String url = "https://randomuser.me/api/";
        WebClient webClient = WebClient.create(url);
        Mono<RandomUser> call = webClient.get().retrieve().bodyToMono(RandomUser.class);
        random = call.block();
        return random;
    }
    public String getKanyeQuote(){
        String url = "https://api.kanye.rest/?format=json";
        String quote = "";
        WebClient webClient = WebClient.create(url);
        Mono<KanyeQuote> call = webClient.get().retrieve().bodyToMono(KanyeQuote.class);
        KanyeQuote q = call.block();
        quote = q.getQuote();
        return quote;
    }
    public String getRandomActivity(){
        String url = "https://www.boredapi.com/api/activity";
        String actv = "";
        WebClient webClient = WebClient.create(url);
        Mono<Activity> call = webClient.get().retrieve().bodyToMono(Activity.class);
        Activity a = call.block();
        return actv = a.getActivity();
    }
}
