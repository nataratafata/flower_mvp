package firstproject2.mcs.com.flower_mvp.network;


import java.util.List;

import firstproject2.mcs.com.flower_mvp.data.FlowerModel;
import io.reactivex.Observable;

public interface IFlower_Interacter {

    Observable<List<FlowerModel>> getFlowerList();

}
