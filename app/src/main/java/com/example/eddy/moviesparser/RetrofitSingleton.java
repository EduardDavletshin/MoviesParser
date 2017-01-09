package com.example.eddy.moviesparser;

        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eddy on 1/5/2017.
 */
class RetrofitSingleton {

    private RequestInterface requestInterface;

    private RetrofitSingleton() {
        String URL = "http://jsonparsing.parseapp.com/jsonData/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestInterface = retrofit.create(RequestInterface.class);
    }

    RequestInterface getRequestInterface() {
        return requestInterface;
    }

    private static RetrofitSingleton instance = new RetrofitSingleton();

    static RetrofitSingleton getInstance() {
        return instance;
    }
}
