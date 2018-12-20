package firstproject2.mcs.com.flower_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.List;

import firstproject2.mcs.com.flower_mvp.data.FlowerModel;
import firstproject2.mcs.com.flower_mvp.flowerlist.FlowerList_Presenter;
import firstproject2.mcs.com.flower_mvp.flowerlist.IFlowerList_Contract;
import firstproject2.mcs.com.flower_mvp.network.ConnectionService;
import firstproject2.mcs.com.flower_mvp.network.IFlower_Interacter;
import firstproject2.mcs.com.flower_mvp.presentation.FlowerAdapter;

public class MainActivity extends AppCompatActivity implements IFlowerList_Contract.IView_FlowerList {

    private FlowerList_Presenter flowerList_presenter;
    private IFlower_Interacter iFlower_interacter;

    private FlowerAdapter adapter;
    private RecyclerView recyclerView;

    public static File cacheDir;

    @Override
    public void _displayProgressDialog() {

    }

    @Override
    public void _flowerList(List<FlowerModel> flowerModels) {
        recyclerView = (RecyclerView) findViewById(R.id.rv_flower_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FlowerAdapter(flowerModels);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void _dismissProgressDialog() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _initializePresenterAndCallApi();

        cacheDir = getCacheDir();
    }


    public void _initializePresenterAndCallApi(){
        iFlower_interacter = new ConnectionService();
        flowerList_presenter = new FlowerList_Presenter(iFlower_interacter);
        flowerList_presenter.onBind(this);
        flowerList_presenter.getFlowerFromAPI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flowerList_presenter.unBind();
    }
}
