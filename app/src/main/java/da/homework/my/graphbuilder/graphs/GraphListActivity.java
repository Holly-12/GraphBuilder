package da.homework.my.graphbuilder.graphs;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import da.homework.my.graphbuilder.R;
import da.homework.my.graphbuilder.databinding.ActivityGraphListBinding;


public class GraphListActivity extends AppCompatActivity {

    private GraphListViewModel viewModel;
    private GraphListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGraphListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_graph_list);
        viewModel = ViewModelProviders.of(this).get(GraphListViewModel.class);
        adapter = new GraphListAdapter();
        binding.setViewModel(viewModel);
        binding.graphsList.setAdapter(adapter);

        subscribeToModel();
    }

    private void subscribeToModel() {
        viewModel.getGraphs().observe(this, adapter::setGraphs);
    }
}
