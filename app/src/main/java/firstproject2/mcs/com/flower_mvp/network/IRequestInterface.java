package firstproject2.mcs.com.flower_mvp.network;


import java.util.List;

import firstproject2.mcs.com.flower_mvp.data.FlowerModel;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IRequestInterface {
    // GET request, PUT,
    // [ JSON ARRAY = LIST
    // { JSON OBJECT : Object


    @GET(API_Request.API_FLOWERS_LIST)
    Observable<List<FlowerModel>> getFlowerList();
}
